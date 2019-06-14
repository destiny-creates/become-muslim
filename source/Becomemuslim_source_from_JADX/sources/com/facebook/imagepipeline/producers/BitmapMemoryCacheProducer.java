package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.internal.ServerProtocol;
import java.util.Map;

public class BitmapMemoryCacheProducer implements Producer<CloseableReference<CloseableImage>> {
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "BitmapMemoryCacheProducer";
    private final CacheKeyFactory mCacheKeyFactory;
    private final Producer<CloseableReference<CloseableImage>> mInputProducer;
    private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;

    protected String getProducerName() {
        return PRODUCER_NAME;
    }

    public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<CloseableReference<CloseableImage>> producer) {
        this.mMemoryCache = memoryCache;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        ProducerListener listener = producerContext.getListener();
        String id = producerContext.getId();
        listener.onProducerStart(id, getProducerName());
        CacheKey bitmapCacheKey = this.mCacheKeyFactory.getBitmapCacheKey(producerContext.getImageRequest(), producerContext.getCallerContext());
        CloseableReference closeableReference = this.mMemoryCache.get(bitmapCacheKey);
        Map map = null;
        if (closeableReference != null) {
            boolean isOfFullQuality = ((CloseableImage) closeableReference.get()).getQualityInfo().isOfFullQuality();
            if (isOfFullQuality) {
                listener.onProducerFinishWithSuccess(id, getProducerName(), listener.requiresExtraMap(id) ? ImmutableMap.of("cached_value_found", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) : null);
                listener.onUltimateProducerReached(id, getProducerName(), true);
                consumer.onProgressUpdate(1.0f);
            }
            consumer.onNewResult(closeableReference, BaseConsumer.simpleStatusForIsLast(isOfFullQuality));
            closeableReference.close();
            if (isOfFullQuality) {
                return;
            }
        }
        if (producerContext.getLowestPermittedRequestLevel().getValue() >= RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            listener.onProducerFinishWithSuccess(id, getProducerName(), listener.requiresExtraMap(id) ? ImmutableMap.of("cached_value_found", "false") : null);
            listener.onUltimateProducerReached(id, getProducerName(), false);
            consumer.onNewResult(null, 1);
            return;
        }
        consumer = wrapConsumer(consumer, bitmapCacheKey, producerContext.getImageRequest().isMemoryCacheEnabled());
        String producerName = getProducerName();
        if (listener.requiresExtraMap(id)) {
            map = ImmutableMap.of("cached_value_found", "false");
        }
        listener.onProducerFinishWithSuccess(id, producerName, map);
        this.mInputProducer.produceResults(consumer, producerContext);
    }

    protected Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> consumer, final CacheKey cacheKey, final boolean z) {
        return new DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>(consumer) {
            public void onNewResultImpl(CloseableReference<CloseableImage> closeableReference, int i) {
                boolean isLast = BaseConsumer.isLast(i);
                CloseableReference closeableReference2 = null;
                if (closeableReference == null) {
                    if (isLast) {
                        getConsumer().onNewResult(null, i);
                    }
                    return;
                }
                if (!((CloseableImage) closeableReference.get()).isStateful()) {
                    if (!BaseConsumer.statusHasFlag(i, 8)) {
                        if (!isLast) {
                            CloseableReference closeableReference3 = BitmapMemoryCacheProducer.this.mMemoryCache.get(cacheKey);
                            if (closeableReference3 != null) {
                                try {
                                    QualityInfo qualityInfo = ((CloseableImage) closeableReference.get()).getQualityInfo();
                                    QualityInfo qualityInfo2 = ((CloseableImage) closeableReference3.get()).getQualityInfo();
                                    if (!qualityInfo2.isOfFullQuality()) {
                                        if (qualityInfo2.getQuality() < qualityInfo.getQuality()) {
                                            CloseableReference.closeSafely(closeableReference3);
                                        }
                                    }
                                    getConsumer().onNewResult(closeableReference3, i);
                                    return;
                                } finally {
                                    CloseableReference.closeSafely(closeableReference3);
                                }
                            }
                        }
                        if (z) {
                            closeableReference2 = BitmapMemoryCacheProducer.this.mMemoryCache.cache(cacheKey, closeableReference);
                        }
                        if (isLast) {
                            try {
                                getConsumer().onProgressUpdate(1.0f);
                            } catch (Throwable th) {
                                CloseableReference.closeSafely(closeableReference2);
                            }
                        }
                        Consumer consumer = getConsumer();
                        if (closeableReference2 != null) {
                            closeableReference = closeableReference2;
                        }
                        consumer.onNewResult(closeableReference, i);
                        CloseableReference.closeSafely(closeableReference2);
                        return;
                    }
                }
                getConsumer().onNewResult(closeableReference, i);
            }
        };
    }
}
