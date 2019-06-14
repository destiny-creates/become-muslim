package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.cache.CountingMemoryCache.CacheTrimStrategy;
import com.facebook.imagepipeline.image.CloseableImage;

public class BitmapCountingMemoryCacheFactory {

    /* renamed from: com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory$1 */
    static class C37361 implements ValueDescriptor<CloseableImage> {
        C37361() {
        }

        public int getSizeInBytes(CloseableImage closeableImage) {
            return closeableImage.getSizeInBytes();
        }
    }

    public static CountingMemoryCache<CacheKey, CloseableImage> get(Supplier<MemoryCacheParams> supplier, MemoryTrimmableRegistry memoryTrimmableRegistry) {
        return get(supplier, memoryTrimmableRegistry, new BitmapMemoryCacheTrimStrategy());
    }

    public static CountingMemoryCache<CacheKey, CloseableImage> get(Supplier<MemoryCacheParams> supplier, MemoryTrimmableRegistry memoryTrimmableRegistry, CacheTrimStrategy cacheTrimStrategy) {
        Object countingMemoryCache = new CountingMemoryCache(new C37361(), cacheTrimStrategy, supplier);
        memoryTrimmableRegistry.registerMemoryTrimmable(countingMemoryCache);
        return countingMemoryCache;
    }
}
