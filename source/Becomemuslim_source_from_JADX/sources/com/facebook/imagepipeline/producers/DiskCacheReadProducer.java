package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import p043b.C0823h;
import p043b.C0829j;

public class DiskCacheReadProducer implements Producer<EncodedImage> {
    public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
    public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
    public static final String PRODUCER_NAME = "DiskCacheProducer";
    private final CacheKeyFactory mCacheKeyFactory;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    private final Producer<EncodedImage> mInputProducer;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;

    public DiskCacheReadProducer(BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, Producer<EncodedImage> producer) {
        this.mDefaultBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mInputProducer = producer;
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        ImageRequest imageRequest = producerContext.getImageRequest();
        if (imageRequest.isDiskCacheEnabled()) {
            producerContext.getListener().onProducerStart(producerContext.getId(), PRODUCER_NAME);
            CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, producerContext.getCallerContext());
            BufferedDiskCache bufferedDiskCache = (imageRequest.getCacheChoice() == CacheChoice.SMALL ? 1 : null) != null ? this.mSmallImageBufferedDiskCache : this.mDefaultBufferedDiskCache;
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bufferedDiskCache.get(encodedCacheKey, atomicBoolean).m2989a(onFinishDiskReads(consumer, producerContext));
            subscribeTaskForRequestCancellation(atomicBoolean, producerContext);
            return;
        }
        maybeStartInputProducer(consumer, producerContext);
    }

    private C0823h<EncodedImage, Void> onFinishDiskReads(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        final String id = producerContext.getId();
        final ProducerListener listener = producerContext.getListener();
        final Consumer<EncodedImage> consumer2 = consumer;
        final ProducerContext producerContext2 = producerContext;
        return new C0823h<EncodedImage, Void>() {
            public Void then(C0829j<EncodedImage> c0829j) {
                if (DiskCacheReadProducer.isTaskCancelled(c0829j)) {
                    listener.onProducerFinishWithCancellation(id, DiskCacheReadProducer.PRODUCER_NAME, null);
                    consumer2.onCancellation();
                } else if (c0829j.m3000e()) {
                    listener.onProducerFinishWithFailure(id, DiskCacheReadProducer.PRODUCER_NAME, c0829j.m3002g(), null);
                    DiskCacheReadProducer.this.mInputProducer.produceResults(consumer2, producerContext2);
                } else {
                    EncodedImage encodedImage = (EncodedImage) c0829j.m3001f();
                    if (encodedImage != null) {
                        listener.onProducerFinishWithSuccess(id, DiskCacheReadProducer.PRODUCER_NAME, DiskCacheReadProducer.getExtraMap(listener, id, true, encodedImage.getSize()));
                        listener.onUltimateProducerReached(id, DiskCacheReadProducer.PRODUCER_NAME, true);
                        consumer2.onProgressUpdate(1.0f);
                        consumer2.onNewResult(encodedImage, 1);
                        encodedImage.close();
                    } else {
                        listener.onProducerFinishWithSuccess(id, DiskCacheReadProducer.PRODUCER_NAME, DiskCacheReadProducer.getExtraMap(listener, id, false, 0));
                        DiskCacheReadProducer.this.mInputProducer.produceResults(consumer2, producerContext2);
                    }
                }
                return null;
            }
        };
    }

    private static boolean isTaskCancelled(C0829j<?> c0829j) {
        if (!c0829j.m2999d()) {
            if (!c0829j.m3000e() || (c0829j.m3002g() instanceof CancellationException) == null) {
                return null;
            }
        }
        return true;
    }

    private void maybeStartInputProducer(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        if (producerContext.getLowestPermittedRequestLevel().getValue() >= RequestLevel.DISK_CACHE.getValue()) {
            consumer.onNewResult(null, 1);
        } else {
            this.mInputProducer.produceResults(consumer, producerContext);
        }
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
}
