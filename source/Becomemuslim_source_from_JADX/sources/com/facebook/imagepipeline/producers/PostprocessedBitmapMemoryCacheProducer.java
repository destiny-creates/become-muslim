package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.internal.ServerProtocol;
import java.util.Map;

public class PostprocessedBitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String PRODUCER_NAME = "PostprocessedBitmapMemoryCacheProducer";
    @VisibleForTesting
    static final String VALUE_FOUND = "cached_value_found";
    private final CacheKeyFactory mCacheKeyFactory;
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;
    private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

    public static class CachedPostprocessorConsumer extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>> {
        private final CacheKey mCacheKey;
        private final boolean mIsMemoryCachedEnabled;
        private final boolean mIsRepeatedProcessor;
        private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

        public CachedPostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> consumer, CacheKey cacheKey, boolean z, MemoryCache<CacheKey, CloseableImage> memoryCache, boolean z2) {
            super(consumer);
            this.mCacheKey = cacheKey;
            this.mIsRepeatedProcessor = z;
            this.mMemoryCache = memoryCache;
            this.mIsMemoryCachedEnabled = z2;
        }

        protected void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
            CloseableReference closeableReference2 = null;
            if (closeableReference == null) {
                if (BaseConsumer.isLast(i) != null) {
                    getConsumer().onNewResult(null, i);
                }
            } else if (!BaseConsumer.isNotLast(i) || this.mIsRepeatedProcessor) {
                if (this.mIsMemoryCachedEnabled) {
                    closeableReference2 = this.mMemoryCache.cache(this.mCacheKey, closeableReference);
                }
                try {
                    getConsumer().onProgressUpdate(1.0f);
                    Consumer consumer = getConsumer();
                    if (closeableReference2 != null) {
                        closeableReference = closeableReference2;
                    }
                    consumer.onNewResult(closeableReference, i);
                } finally {
                    CloseableReference.closeSafely(closeableReference2);
                }
            }
        }
    }

    protected String getProducerName() {
        return PRODUCER_NAME;
    }

    public PostprocessedBitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        ProducerListener listener = producerContext.getListener();
        String id = producerContext.getId();
        ImageRequest imageRequest = producerContext.getImageRequest();
        Object callerContext = producerContext.getCallerContext();
        Postprocessor postprocessor = imageRequest.getPostprocessor();
        if (postprocessor != null) {
            if (postprocessor.getPostprocessorCacheKey() != null) {
                listener.onProducerStart(id, getProducerName());
                CacheKey postprocessedBitmapCacheKey = this.mCacheKeyFactory.getPostprocessedBitmapCacheKey(imageRequest, callerContext);
                CloseableReference closeableReference = this.mMemoryCache.get(postprocessedBitmapCacheKey);
                Map map = null;
                if (closeableReference != null) {
                    producerContext = getProducerName();
                    if (listener.requiresExtraMap(id)) {
                        map = ImmutableMap.of("cached_value_found", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                    }
                    listener.onProducerFinishWithSuccess(id, producerContext, map);
                    listener.onUltimateProducerReached(id, PRODUCER_NAME, true);
                    consumer.onProgressUpdate(1.0f);
                    consumer.onNewResult(closeableReference, 1);
                    closeableReference.close();
                } else {
                    Consumer<CloseableReference<CloseableImage>> consumer2 = consumer;
                    Consumer cachedPostprocessorConsumer = new CachedPostprocessorConsumer(consumer2, postprocessedBitmapCacheKey, postprocessor instanceof RepeatedPostprocessor, this.mMemoryCache, producerContext.getImageRequest().isMemoryCacheEnabled());
                    consumer = getProducerName();
                    if (listener.requiresExtraMap(id)) {
                        map = ImmutableMap.of("cached_value_found", "false");
                    }
                    listener.onProducerFinishWithSuccess(id, consumer, map);
                    this.mInputProducer.produceResults(cachedPostprocessorConsumer, producerContext);
                }
                return;
            }
        }
        this.mInputProducer.produceResults(consumer, producerContext);
    }
}
