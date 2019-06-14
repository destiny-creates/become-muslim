package com.facebook.imagepipeline.core;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import p043b.C0823h;
import p043b.C0829j;

public class ImagePipeline {
    private static final CancellationException PREFETCH_EXCEPTION = new CancellationException("Prefetching is not enabled");
    private final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    private final CacheKeyFactory mCacheKeyFactory;
    private final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    private AtomicLong mIdCounter = new AtomicLong();
    private final Supplier<Boolean> mIsPrefetchEnabledSupplier;
    private final Supplier<Boolean> mLazyDataSource;
    private final BufferedDiskCache mMainBufferedDiskCache;
    private final ProducerSequenceFactory mProducerSequenceFactory;
    private final RequestListener mRequestListener;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;
    private final Supplier<Boolean> mSuppressBitmapPrefetchingSupplier;
    private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    /* renamed from: com.facebook.imagepipeline.core.ImagePipeline$4 */
    class C37464 implements Predicate<CacheKey> {
        public boolean apply(CacheKey cacheKey) {
            return true;
        }

        C37464() {
        }
    }

    public ImagePipeline(ProducerSequenceFactory producerSequenceFactory, Set<RequestListener> set, Supplier<Boolean> supplier, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, BufferedDiskCache bufferedDiskCache, BufferedDiskCache bufferedDiskCache2, CacheKeyFactory cacheKeyFactory, ThreadHandoffProducerQueue threadHandoffProducerQueue, Supplier<Boolean> supplier2, Supplier<Boolean> supplier3) {
        this.mProducerSequenceFactory = producerSequenceFactory;
        this.mRequestListener = new ForwardingRequestListener((Set) set);
        this.mIsPrefetchEnabledSupplier = supplier;
        this.mBitmapMemoryCache = memoryCache;
        this.mEncodedMemoryCache = memoryCache2;
        this.mMainBufferedDiskCache = bufferedDiskCache;
        this.mSmallImageBufferedDiskCache = bufferedDiskCache2;
        this.mCacheKeyFactory = cacheKeyFactory;
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
        this.mSuppressBitmapPrefetchingSupplier = supplier2;
        this.mLazyDataSource = supplier3;
    }

    private String generateUniqueFutureId() {
        return String.valueOf(this.mIdCounter.getAndIncrement());
    }

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest imageRequest, final Object obj, final RequestLevel requestLevel) {
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>() {
            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.this.fetchDecodedImage(imageRequest, obj, requestLevel);
            }

            public String toString() {
                return Objects.toStringHelper((Object) this).add("uri", imageRequest.getSourceUri()).toString();
            }
        };
    }

    public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(ImageRequest imageRequest, Object obj, RequestLevel requestLevel, RequestListener requestListener) {
        final ImageRequest imageRequest2 = imageRequest;
        final Object obj2 = obj;
        final RequestLevel requestLevel2 = requestLevel;
        final RequestListener requestListener2 = requestListener;
        return new Supplier<DataSource<CloseableReference<CloseableImage>>>() {
            public DataSource<CloseableReference<CloseableImage>> get() {
                return ImagePipeline.this.fetchDecodedImage(imageRequest2, obj2, requestLevel2, requestListener2);
            }

            public String toString() {
                return Objects.toStringHelper((Object) this).add("uri", imageRequest2.getSourceUri()).toString();
            }
        };
    }

    public Supplier<DataSource<CloseableReference<PooledByteBuffer>>> getEncodedImageDataSourceSupplier(final ImageRequest imageRequest, final Object obj) {
        return new Supplier<DataSource<CloseableReference<PooledByteBuffer>>>() {
            public DataSource<CloseableReference<PooledByteBuffer>> get() {
                return ImagePipeline.this.fetchEncodedImage(imageRequest, obj);
            }

            public String toString() {
                return Objects.toStringHelper((Object) this).add("uri", imageRequest.getSourceUri()).toString();
            }
        };
    }

    public DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache(ImageRequest imageRequest, Object obj) {
        return fetchDecodedImage(imageRequest, obj, RequestLevel.BITMAP_MEMORY_CACHE);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj) {
        return fetchDecodedImage(imageRequest, obj, RequestLevel.FULL_FETCH);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, RequestListener requestListener) {
        return fetchDecodedImage(imageRequest, obj, RequestLevel.FULL_FETCH, requestListener);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, RequestLevel requestLevel) {
        return fetchDecodedImage(imageRequest, obj, requestLevel, null);
    }

    public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest imageRequest, Object obj, RequestLevel requestLevel, RequestListener requestListener) {
        try {
            return submitFetchRequest(this.mProducerSequenceFactory.getDecodedImageProducerSequence(imageRequest), imageRequest, requestLevel, obj, requestListener);
        } catch (ImageRequest imageRequest2) {
            return DataSources.immediateFailedDataSource(imageRequest2);
        }
    }

    public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest imageRequest, Object obj) {
        return fetchEncodedImage(imageRequest, obj, null);
    }

    public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest imageRequest, Object obj, RequestListener requestListener) {
        Preconditions.checkNotNull(imageRequest.getSourceUri());
        try {
            Producer encodedImageProducerSequence = this.mProducerSequenceFactory.getEncodedImageProducerSequence(imageRequest);
            if (imageRequest.getResizeOptions() != null) {
                imageRequest = ImageRequestBuilder.fromRequest(imageRequest).setResizeOptions(null).build();
            }
            return submitFetchRequest(encodedImageProducerSequence, imageRequest, RequestLevel.FULL_FETCH, obj, requestListener);
        } catch (ImageRequest imageRequest2) {
            return DataSources.immediateFailedDataSource(imageRequest2);
        }
    }

    public DataSource<Void> prefetchToBitmapCache(ImageRequest imageRequest, Object obj) {
        if (!((Boolean) this.mIsPrefetchEnabledSupplier.get()).booleanValue()) {
            return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
        }
        try {
            Producer encodedImagePrefetchProducerSequence;
            if (((Boolean) this.mSuppressBitmapPrefetchingSupplier.get()).booleanValue()) {
                encodedImagePrefetchProducerSequence = this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest);
            } else {
                encodedImagePrefetchProducerSequence = this.mProducerSequenceFactory.getDecodedImagePrefetchProducerSequence(imageRequest);
            }
            return submitPrefetchRequest(encodedImagePrefetchProducerSequence, imageRequest, RequestLevel.FULL_FETCH, obj, Priority.MEDIUM);
        } catch (ImageRequest imageRequest2) {
            return DataSources.immediateFailedDataSource(imageRequest2);
        }
    }

    public DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object obj) {
        return prefetchToDiskCache(imageRequest, obj, Priority.MEDIUM);
    }

    public DataSource<Void> prefetchToDiskCache(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!((Boolean) this.mIsPrefetchEnabledSupplier.get()).booleanValue()) {
            return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
        }
        try {
            return submitPrefetchRequest(this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(imageRequest), imageRequest, RequestLevel.FULL_FETCH, obj, priority);
        } catch (ImageRequest imageRequest2) {
            return DataSources.immediateFailedDataSource(imageRequest2);
        }
    }

    public void evictFromMemoryCache(Uri uri) {
        uri = predicateForUri(uri);
        this.mBitmapMemoryCache.removeAll(uri);
        this.mEncodedMemoryCache.removeAll(uri);
    }

    public void evictFromDiskCache(Uri uri) {
        evictFromDiskCache(ImageRequest.fromUri(uri));
    }

    public void evictFromDiskCache(ImageRequest imageRequest) {
        imageRequest = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        this.mMainBufferedDiskCache.remove(imageRequest);
        this.mSmallImageBufferedDiskCache.remove(imageRequest);
    }

    public void evictFromCache(Uri uri) {
        evictFromMemoryCache(uri);
        evictFromDiskCache(uri);
    }

    public void clearMemoryCaches() {
        Predicate c37464 = new C37464();
        this.mBitmapMemoryCache.removeAll(c37464);
        this.mEncodedMemoryCache.removeAll(c37464);
    }

    public void clearDiskCaches() {
        this.mMainBufferedDiskCache.clearAll();
        this.mSmallImageBufferedDiskCache.clearAll();
    }

    public void clearCaches() {
        clearMemoryCaches();
        clearDiskCaches();
    }

    public boolean isInBitmapMemoryCache(Uri uri) {
        if (uri == null) {
            return null;
        }
        return this.mBitmapMemoryCache.contains(predicateForUri(uri));
    }

    public MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        return this.mBitmapMemoryCache;
    }

    public boolean isInBitmapMemoryCache(ImageRequest imageRequest) {
        if (imageRequest == null) {
            return null;
        }
        CloseableReference closeableReference = this.mBitmapMemoryCache.get(this.mCacheKeyFactory.getBitmapCacheKey(imageRequest, null));
        try {
            boolean isValid = CloseableReference.isValid(closeableReference);
            return isValid;
        } finally {
            CloseableReference.closeSafely(closeableReference);
        }
    }

    public boolean isInDiskCacheSync(Uri uri) {
        if (!isInDiskCacheSync(uri, CacheChoice.SMALL)) {
            if (isInDiskCacheSync(uri, CacheChoice.DEFAULT) == null) {
                return null;
            }
        }
        return true;
    }

    public boolean isInDiskCacheSync(Uri uri, CacheChoice cacheChoice) {
        return isInDiskCacheSync(ImageRequestBuilder.newBuilderWithSource(uri).setCacheChoice(cacheChoice).build());
    }

    public boolean isInDiskCacheSync(ImageRequest imageRequest) {
        CacheKey encodedCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        switch (imageRequest.getCacheChoice()) {
            case DEFAULT:
                return this.mMainBufferedDiskCache.diskCheckSync(encodedCacheKey);
            case SMALL:
                return this.mSmallImageBufferedDiskCache.diskCheckSync(encodedCacheKey);
            default:
                return null;
        }
    }

    public DataSource<Boolean> isInDiskCache(Uri uri) {
        return isInDiskCache(ImageRequest.fromUri(uri));
    }

    public DataSource<Boolean> isInDiskCache(ImageRequest imageRequest) {
        imageRequest = this.mCacheKeyFactory.getEncodedCacheKey(imageRequest, null);
        final DataSource create = SimpleDataSource.create();
        this.mMainBufferedDiskCache.contains(imageRequest).m2992b(new C0823h<Boolean, C0829j<Boolean>>() {
            public C0829j<Boolean> then(C0829j<Boolean> c0829j) {
                if (c0829j.m2999d() || c0829j.m3000e() || ((Boolean) c0829j.m3001f()).booleanValue() == null) {
                    return ImagePipeline.this.mSmallImageBufferedDiskCache.contains(imageRequest);
                }
                return C0829j.m2979a(Boolean.valueOf(true));
            }
        }).m2989a(new C0823h<Boolean, Void>() {
            public Void then(C0829j<Boolean> c0829j) {
                SimpleDataSource simpleDataSource = create;
                c0829j = (c0829j.m2999d() || c0829j.m3000e() || ((Boolean) c0829j.m3001f()).booleanValue() == null) ? null : true;
                simpleDataSource.setResult(Boolean.valueOf(c0829j));
                return null;
            }
        });
        return create;
    }

    private <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> producer, ImageRequest imageRequest, RequestLevel requestLevel, Object obj, RequestListener requestListener) {
        requestListener = getRequestListenerForRequest(imageRequest, requestListener);
        try {
            boolean z;
            RequestLevel max = RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), requestLevel);
            String generateUniqueFutureId = generateUniqueFutureId();
            if (!imageRequest.getProgressiveRenderingEnabled()) {
                if (UriUtil.isNetworkUri(imageRequest.getSourceUri())) {
                    z = false;
                    return CloseableProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imageRequest, generateUniqueFutureId, requestListener, obj, max, false, z, imageRequest.getPriority()), requestListener);
                }
            }
            z = true;
            return CloseableProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imageRequest, generateUniqueFutureId, requestListener, obj, max, false, z, imageRequest.getPriority()), requestListener);
        } catch (Producer<CloseableReference<T>> producer2) {
            return DataSources.immediateFailedDataSource(producer2);
        }
    }

    private DataSource<Void> submitPrefetchRequest(Producer<Void> producer, ImageRequest imageRequest, RequestLevel requestLevel, Object obj, Priority priority) {
        RequestListener requestListenerForRequest = getRequestListenerForRequest(imageRequest, null);
        try {
            return ProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imageRequest, generateUniqueFutureId(), requestListenerForRequest, obj, RequestLevel.getMax(imageRequest.getLowestPermittedRequestLevel(), requestLevel), true, false, priority), requestListenerForRequest);
        } catch (Producer<Void> producer2) {
            return DataSources.immediateFailedDataSource(producer2);
        }
    }

    private RequestListener getRequestListenerForRequest(ImageRequest imageRequest, RequestListener requestListener) {
        if (requestListener == null) {
            if (imageRequest.getRequestListener() == null) {
                return this.mRequestListener;
            }
            return new ForwardingRequestListener(this.mRequestListener, imageRequest.getRequestListener());
        } else if (imageRequest.getRequestListener() == null) {
            return new ForwardingRequestListener(this.mRequestListener, requestListener);
        } else {
            return new ForwardingRequestListener(this.mRequestListener, requestListener, imageRequest.getRequestListener());
        }
    }

    private Predicate<CacheKey> predicateForUri(final Uri uri) {
        return new Predicate<CacheKey>() {
            public boolean apply(CacheKey cacheKey) {
                return cacheKey.containsUri(uri);
            }
        };
    }

    public void pause() {
        this.mThreadHandoffProducerQueue.startQueueing();
    }

    public void resume() {
        this.mThreadHandoffProducerQueue.stopQueuing();
    }

    public boolean isPaused() {
        return this.mThreadHandoffProducerQueue.isQueueing();
    }

    public Supplier<Boolean> isLazyDataSource() {
        return this.mLazyDataSource;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        return this.mCacheKeyFactory;
    }
}
