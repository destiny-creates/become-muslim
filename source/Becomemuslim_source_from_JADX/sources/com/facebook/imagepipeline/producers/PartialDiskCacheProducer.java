package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.internal.ServerProtocol;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import p043b.C0823h;
import p043b.C0829j;

public class PartialDiskCacheProducer implements Producer<EncodedImage> {
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "PartialDiskCacheProducer";
    private final ByteArrayPool mByteArrayPool;
    private final CacheKeyFactory mCacheKeyFactory;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    private final Producer<EncodedImage> mInputProducer;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    private static class PartialDiskCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private static final int READ_SIZE = 16384;
        private final ByteArrayPool mByteArrayPool;
        private final BufferedDiskCache mDefaultBufferedDiskCache;
        private final EncodedImage mPartialEncodedImageFromCache;
        private final CacheKey mPartialImageCacheKey;
        private final PooledByteBufferFactory mPooledByteBufferFactory;

        private PartialDiskCacheConsumer(Consumer<EncodedImage> consumer, BufferedDiskCache bufferedDiskCache, CacheKey cacheKey, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, EncodedImage encodedImage) {
            super(consumer);
            this.mDefaultBufferedDiskCache = bufferedDiskCache;
            this.mPartialImageCacheKey = cacheKey;
            this.mPooledByteBufferFactory = pooledByteBufferFactory;
            this.mByteArrayPool = byteArrayPool;
            this.mPartialEncodedImageFromCache = encodedImage;
        }

        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            if (!BaseConsumer.isNotLast(i)) {
                if (this.mPartialEncodedImageFromCache != null && encodedImage.getBytesRange() != null) {
                    try {
                        sendFinalResultToConsumer(merge(this.mPartialEncodedImageFromCache, encodedImage));
                    } catch (Throwable e) {
                        FLog.m5675e(PartialDiskCacheProducer.PRODUCER_NAME, "Error while merging image data", e);
                        getConsumer().onFailure(e);
                    } catch (Throwable th) {
                        encodedImage.close();
                        this.mPartialEncodedImageFromCache.close();
                    }
                    encodedImage.close();
                    this.mPartialEncodedImageFromCache.close();
                    this.mDefaultBufferedDiskCache.remove(this.mPartialImageCacheKey);
                } else if (BaseConsumer.statusHasFlag(i, 8) && BaseConsumer.isLast(i) && encodedImage.getImageFormat() != ImageFormat.UNKNOWN) {
                    this.mDefaultBufferedDiskCache.put(this.mPartialImageCacheKey, encodedImage);
                    getConsumer().onNewResult(encodedImage, i);
                } else {
                    getConsumer().onNewResult(encodedImage, i);
                }
            }
        }

        private PooledByteBufferOutputStream merge(EncodedImage encodedImage, EncodedImage encodedImage2) {
            OutputStream newOutputStream = this.mPooledByteBufferFactory.newOutputStream(encodedImage2.getSize() + encodedImage2.getBytesRange().from);
            copy(encodedImage.getInputStream(), newOutputStream, encodedImage2.getBytesRange().from);
            copy(encodedImage2.getInputStream(), newOutputStream, encodedImage2.getSize());
            return newOutputStream;
        }

        private void copy(InputStream inputStream, OutputStream outputStream, int i) {
            byte[] bArr = (byte[]) this.mByteArrayPool.get(READ_SIZE);
            int i2 = i;
            while (i2 > 0) {
                try {
                    int read = inputStream.read(bArr, 0, Math.min(READ_SIZE, i2));
                    if (read < 0) {
                        break;
                    } else if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        i2 -= read;
                    }
                } catch (Throwable th) {
                    this.mByteArrayPool.release(bArr);
                }
            }
            this.mByteArrayPool.release(bArr);
            if (i2 > 0) {
                throw new IOException(String.format((Locale) null, "Failed to read %d bytes - finished %d short", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            }
        }

        private void sendFinalResultToConsumer(PooledByteBufferOutputStream pooledByteBufferOutputStream) {
            Throwable th;
            CloseableReference of = CloseableReference.of(pooledByteBufferOutputStream.toByteBuffer());
            EncodedImage encodedImage;
            try {
                encodedImage = new EncodedImage(of);
                try {
                    encodedImage.parseMetaData();
                    getConsumer().onNewResult(encodedImage, 1);
                    EncodedImage.closeSafely(encodedImage);
                    CloseableReference.closeSafely(of);
                } catch (Throwable th2) {
                    th = th2;
                    EncodedImage.closeSafely(encodedImage);
                    CloseableReference.closeSafely(of);
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                encodedImage = null;
                th = th4;
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely(of);
                throw th;
            }
        }
    }

    public PartialDiskCacheProducer(BufferedDiskCache bufferedDiskCache, CacheKeyFactory cacheKeyFactory, PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, Producer<EncodedImage> producer) {
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mByteArrayPool = byteArrayPool;
        this.mInputProducer = producer;
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        ImageRequest imageRequest = producerContext.getImageRequest();
        if (imageRequest.isDiskCacheEnabled()) {
            producerContext.getListener().onProducerStart(producerContext.getId(), PRODUCER_NAME);
            CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, createUriForPartialCacheKey(imageRequest), producerContext.getCallerContext());
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            this.mDefaultBufferedDiskCache.get(encodedCacheKey, atomicBoolean).m2989a(onFinishDiskReads(consumer, producerContext, encodedCacheKey));
            subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
            return;
        }
        this.mInputProducer.produceResults(consumer, producerContext);
    }

    private C0823h<EncodedImage, Void> onFinishDiskReads(Consumer<EncodedImage> consumer, ProducerContext producerContext, CacheKey cacheKey) {
        final String id = producerContext.getId();
        final ProducerListener listener = producerContext.getListener();
        final Consumer<EncodedImage> consumer2 = consumer;
        final ProducerContext producerContext2 = producerContext;
        final CacheKey cacheKey2 = cacheKey;
        return new C0823h<EncodedImage, Void>() {
            public Void then(C0829j<EncodedImage> c0829j) {
                if (PartialDiskCacheProducer.isTaskCancelled(c0829j)) {
                    listener.onProducerFinishWithCancellation(id, PartialDiskCacheProducer.PRODUCER_NAME, null);
                    consumer2.onCancellation();
                } else if (c0829j.m3000e()) {
                    listener.onProducerFinishWithFailure(id, PartialDiskCacheProducer.PRODUCER_NAME, c0829j.m3002g(), null);
                    PartialDiskCacheProducer.this.startInputProducer(consumer2, producerContext2, cacheKey2, null);
                } else {
                    EncodedImage encodedImage = (EncodedImage) c0829j.m3001f();
                    if (encodedImage != null) {
                        listener.onProducerFinishWithSuccess(id, PartialDiskCacheProducer.PRODUCER_NAME, PartialDiskCacheProducer.getExtraMap(listener, id, true, encodedImage.getSize()));
                        BytesRange toMax = BytesRange.toMax(encodedImage.getSize() - 1);
                        encodedImage.setBytesRange(toMax);
                        int size = encodedImage.getSize();
                        ImageRequest imageRequest = producerContext2.getImageRequest();
                        if (toMax.contains(imageRequest.getBytesRange())) {
                            listener.onUltimateProducerReached(id, PartialDiskCacheProducer.PRODUCER_NAME, true);
                            consumer2.onNewResult(encodedImage, 9);
                        } else {
                            consumer2.onNewResult(encodedImage, 8);
                            PartialDiskCacheProducer.this.startInputProducer(consumer2, new SettableProducerContext(ImageRequestBuilder.fromRequest(imageRequest).setBytesRange(BytesRange.from(size - 1)).build(), producerContext2), cacheKey2, encodedImage);
                        }
                    } else {
                        listener.onProducerFinishWithSuccess(id, PartialDiskCacheProducer.PRODUCER_NAME, PartialDiskCacheProducer.getExtraMap(listener, id, false, 0));
                        PartialDiskCacheProducer.this.startInputProducer(consumer2, producerContext2, cacheKey2, encodedImage);
                    }
                }
                return null;
            }
        };
    }

    private void startInputProducer(Consumer<EncodedImage> consumer, ProducerContext producerContext, CacheKey cacheKey, EncodedImage encodedImage) {
        this.mInputProducer.produceResults(new PartialDiskCacheConsumer(consumer, this.mDefaultBufferedDiskCache, cacheKey, this.mPooledByteBufferFactory, this.mByteArrayPool, encodedImage), producerContext);
    }

    private static boolean isTaskCancelled(C0829j<?> c0829j) {
        if (!c0829j.m2999d()) {
            if (!c0829j.m3000e() || (c0829j.m3002g() instanceof CancellationException) == null) {
                return null;
            }
        }
        return true;
    }

    @VisibleForTesting
    static Map<String, String> getExtraMap(ProducerListener producerListener, String str, boolean z, int i) {
        if (producerListener.requiresExtraMap(str) == null) {
            return null;
        }
        if (z) {
            return ImmutableMap.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i));
        }
        return ImmutableMap.of("cached_value_found", String.valueOf(z));
    }

    private void subscribeTaskForRequestCancellation(final AtomicBoolean atomicBoolean, ProducerContext producerContext) {
        producerContext.addCallbacks(new BaseProducerContextCallbacks() {
            public void onCancellationRequested() {
                atomicBoolean.set(true);
            }
        });
    }

    private static Uri createUriForPartialCacheKey(ImageRequest imageRequest) {
        return imageRequest.getSourceUri().buildUpon().appendQueryParameter("fresco_partial", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE).build();
    }
}
