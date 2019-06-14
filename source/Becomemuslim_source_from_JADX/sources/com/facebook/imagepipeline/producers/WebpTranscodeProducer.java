package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.nativecode.WebpTranscoder;
import com.facebook.imagepipeline.nativecode.WebpTranscoderFactory;
import java.io.InputStream;
import java.util.concurrent.Executor;

public class WebpTranscodeProducer implements Producer<EncodedImage> {
    private static final int DEFAULT_JPEG_QUALITY = 80;
    public static final String PRODUCER_NAME = "WebpTranscodeProducer";
    private final Executor mExecutor;
    private final Producer<EncodedImage> mInputProducer;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    private class WebpTranscodeConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private final ProducerContext mContext;
        private TriState mShouldTranscodeWhenFinished = TriState.UNSET;

        public WebpTranscodeConsumer(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer);
            this.mContext = producerContext;
        }

        protected void onNewResultImpl(EncodedImage encodedImage, int i) {
            if (this.mShouldTranscodeWhenFinished == TriState.UNSET && encodedImage != null) {
                this.mShouldTranscodeWhenFinished = WebpTranscodeProducer.shouldTranscode(encodedImage);
            }
            if (this.mShouldTranscodeWhenFinished == TriState.NO) {
                getConsumer().onNewResult(encodedImage, i);
                return;
            }
            if (BaseConsumer.isLast(i)) {
                if (this.mShouldTranscodeWhenFinished != TriState.YES || encodedImage == null) {
                    getConsumer().onNewResult(encodedImage, i);
                } else {
                    WebpTranscodeProducer.this.transcodeLastResult(encodedImage, getConsumer(), this.mContext);
                }
            }
        }
    }

    public WebpTranscodeProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Producer<EncodedImage> producer) {
        this.mExecutor = (Executor) Preconditions.checkNotNull(executor);
        this.mPooledByteBufferFactory = (PooledByteBufferFactory) Preconditions.checkNotNull(pooledByteBufferFactory);
        this.mInputProducer = (Producer) Preconditions.checkNotNull(producer);
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        this.mInputProducer.produceResults(new WebpTranscodeConsumer(consumer, producerContext), producerContext);
    }

    private void transcodeLastResult(EncodedImage encodedImage, Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        Preconditions.checkNotNull(encodedImage);
        final EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
        this.mExecutor.execute(new StatefulProducerRunnable<EncodedImage>(consumer, producerContext.getListener(), PRODUCER_NAME, producerContext.getId()) {
            protected EncodedImage getResult() {
                PooledByteBufferOutputStream newOutputStream = WebpTranscodeProducer.this.mPooledByteBufferFactory.newOutputStream();
                CloseableReference of;
                try {
                    WebpTranscodeProducer.doTranscode(cloneOrNull, newOutputStream);
                    of = CloseableReference.of(newOutputStream.toByteBuffer());
                    EncodedImage encodedImage = new EncodedImage(of);
                    encodedImage.copyMetaDataFrom(cloneOrNull);
                    CloseableReference.closeSafely(of);
                    newOutputStream.close();
                    return encodedImage;
                } catch (Throwable th) {
                    newOutputStream.close();
                }
            }

            protected void disposeResult(EncodedImage encodedImage) {
                EncodedImage.closeSafely(encodedImage);
            }

            protected void onSuccess(EncodedImage encodedImage) {
                EncodedImage.closeSafely(cloneOrNull);
                super.onSuccess(encodedImage);
            }

            protected void onFailure(Exception exception) {
                EncodedImage.closeSafely(cloneOrNull);
                super.onFailure(exception);
            }

            protected void onCancellation() {
                EncodedImage.closeSafely(cloneOrNull);
                super.onCancellation();
            }
        });
    }

    private static TriState shouldTranscode(EncodedImage encodedImage) {
        Preconditions.checkNotNull(encodedImage);
        encodedImage = ImageFormatChecker.getImageFormat_WrapIOException(encodedImage.getInputStream());
        if (DefaultImageFormats.isStaticWebpFormat(encodedImage)) {
            WebpTranscoder webpTranscoder = WebpTranscoderFactory.getWebpTranscoder();
            if (webpTranscoder == null) {
                return TriState.NO;
            }
            return TriState.valueOf(webpTranscoder.isWebpNativelySupported(encodedImage) ^ 1);
        } else if (encodedImage == ImageFormat.UNKNOWN) {
            return TriState.UNSET;
        } else {
            return TriState.NO;
        }
    }

    private static void doTranscode(EncodedImage encodedImage, PooledByteBufferOutputStream pooledByteBufferOutputStream) {
        InputStream inputStream = encodedImage.getInputStream();
        ImageFormat imageFormat_WrapIOException = ImageFormatChecker.getImageFormat_WrapIOException(inputStream);
        if (imageFormat_WrapIOException != DefaultImageFormats.WEBP_SIMPLE) {
            if (imageFormat_WrapIOException != DefaultImageFormats.WEBP_EXTENDED) {
                if (imageFormat_WrapIOException != DefaultImageFormats.WEBP_LOSSLESS) {
                    if (imageFormat_WrapIOException != DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA) {
                        throw new IllegalArgumentException("Wrong image format");
                    }
                }
                WebpTranscoderFactory.getWebpTranscoder().transcodeWebpToPng(inputStream, pooledByteBufferOutputStream);
                encodedImage.setImageFormat(DefaultImageFormats.PNG);
                return;
            }
        }
        WebpTranscoderFactory.getWebpTranscoder().transcodeWebpToJpeg(inputStream, pooledByteBufferOutputStream, 80);
        encodedImage.setImageFormat(DefaultImageFormats.JPEG);
    }
}
