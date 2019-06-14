package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.InputStream;
import java.util.concurrent.Executor;

public abstract class LocalFetchProducer implements Producer<EncodedImage> {
    private final Executor mExecutor;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    protected abstract EncodedImage getEncodedImage(ImageRequest imageRequest);

    protected abstract String getProducerName();

    protected LocalFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory) {
        this.mExecutor = executor;
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        final ProducerListener listener = producerContext.getListener();
        final String id = producerContext.getId();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        final Runnable c46501 = new StatefulProducerRunnable<EncodedImage>(consumer, listener, getProducerName(), id) {
            protected EncodedImage getResult() {
                EncodedImage encodedImage = LocalFetchProducer.this.getEncodedImage(imageRequest);
                if (encodedImage == null) {
                    listener.onUltimateProducerReached(id, LocalFetchProducer.this.getProducerName(), false);
                    return null;
                }
                encodedImage.parseMetaData();
                listener.onUltimateProducerReached(id, LocalFetchProducer.this.getProducerName(), true);
                return encodedImage;
            }

            protected void disposeResult(EncodedImage encodedImage) {
                EncodedImage.closeSafely(encodedImage);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() {
            public void onCancellationRequested() {
                c46501.cancel();
            }
        });
        this.mExecutor.execute(c46501);
    }

    protected EncodedImage getByteBufferBackedEncodedImage(InputStream inputStream, int i) {
        if (i <= 0) {
            try {
                i = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(inputStream));
            } catch (Throwable th) {
                Closeables.closeQuietly(inputStream);
                CloseableReference.closeSafely(null);
            }
        } else {
            i = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(inputStream, i));
        }
        CloseableReference closeableReference = i;
        i = new EncodedImage(closeableReference);
        Closeables.closeQuietly(inputStream);
        CloseableReference.closeSafely(closeableReference);
        return i;
    }

    protected EncodedImage getEncodedImage(InputStream inputStream, int i) {
        return getByteBufferBackedEncodedImage(inputStream, i);
    }
}
