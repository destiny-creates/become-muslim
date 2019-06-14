package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.internal.ServerProtocol;
import java.util.Map;

public class EncodedMemoryCacheProducer implements Producer<EncodedImage> {
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "EncodedMemoryCacheProducer";
    private final CacheKeyFactory mCacheKeyFactory;
    private final Producer<EncodedImage> mInputProducer;
    private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;

    private static class EncodedMemoryCacheConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
        private final boolean mIsMemoryCacheEnabled;
        private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;
        private final CacheKey mRequestedCacheKey;

        public EncodedMemoryCacheConsumer(Consumer<EncodedImage> consumer, MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKey cacheKey, boolean z) {
            super(consumer);
            this.mMemoryCache = memoryCache;
            this.mRequestedCacheKey = cacheKey;
            this.mIsMemoryCacheEnabled = z;
        }

        public void onNewResultImpl(EncodedImage encodedImage, int i) {
            if (!(BaseConsumer.isNotLast(i) || encodedImage == null)) {
                if (!BaseConsumer.statusHasAnyFlag(i, 10)) {
                    CloseableReference byteBufferRef = encodedImage.getByteBufferRef();
                    if (byteBufferRef != null) {
                        CloseableReference closeableReference = null;
                        try {
                            if (this.mIsMemoryCacheEnabled) {
                                closeableReference = this.mMemoryCache.cache(this.mRequestedCacheKey, byteBufferRef);
                            }
                            CloseableReference.closeSafely(byteBufferRef);
                            if (closeableReference != null) {
                                try {
                                    EncodedImage encodedImage2 = new EncodedImage(closeableReference);
                                    encodedImage2.copyMetaDataFrom(encodedImage);
                                    try {
                                        getConsumer().onProgressUpdate(1.0f);
                                        getConsumer().onNewResult(encodedImage2, i);
                                        return;
                                    } finally {
                                        EncodedImage.closeSafely(encodedImage2);
                                    }
                                } finally {
                                    CloseableReference.closeSafely(closeableReference);
                                }
                            }
                        } catch (Throwable th) {
                            CloseableReference.closeSafely(byteBufferRef);
                        }
                    }
                    getConsumer().onNewResult(encodedImage, i);
                    return;
                }
            }
            getConsumer().onNewResult(encodedImage, i);
        }
    }

    public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        String id = producerContext.getId();
        ProducerListener listener = producerContext.getListener();
        listener.onProducerStart(id, PRODUCER_NAME);
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
        CloseableReference closeableReference = this.mMemoryCache.get(encodedCacheKey);
        Map map = null;
        if (closeableReference != null) {
            try {
                producerContext = new EncodedImage(closeableReference);
                String str = PRODUCER_NAME;
                if (listener.requiresExtraMap(id)) {
                    map = ImmutableMap.of("cached_value_found", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
                listener.onProducerFinishWithSuccess(id, str, map);
                listener.onUltimateProducerReached(id, PRODUCER_NAME, true);
                consumer.onProgressUpdate(1.0f);
                consumer.onNewResult(producerContext, 1);
                EncodedImage.closeSafely(producerContext);
                CloseableReference.closeSafely(closeableReference);
            } catch (Throwable th) {
                CloseableReference.closeSafely(closeableReference);
            }
        } else if (producerContext.getLowestPermittedRequestLevel().getValue() >= RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
            listener.onProducerFinishWithSuccess(id, PRODUCER_NAME, listener.requiresExtraMap(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            listener.onUltimateProducerReached(id, PRODUCER_NAME, false);
            consumer.onNewResult(null, 1);
            CloseableReference.closeSafely(closeableReference);
        } else {
            Consumer encodedMemoryCacheConsumer = new EncodedMemoryCacheConsumer(consumer, this.mMemoryCache, encodedCacheKey, producerContext.getImageRequest().isMemoryCacheEnabled());
            consumer = PRODUCER_NAME;
            if (listener.requiresExtraMap(id)) {
                map = ImmutableMap.of("cached_value_found", "false");
            }
            listener.onProducerFinishWithSuccess(id, consumer, map);
            this.mInputProducer.produceResults(encodedMemoryCacheConsumer, producerContext);
            CloseableReference.closeSafely(closeableReference);
        }
    }
}
