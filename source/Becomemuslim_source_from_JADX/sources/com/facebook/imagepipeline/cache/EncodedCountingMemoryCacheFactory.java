package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBuffer;

public class EncodedCountingMemoryCacheFactory {

    /* renamed from: com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory$1 */
    static class C37411 implements ValueDescriptor<PooledByteBuffer> {
        C37411() {
        }

        public int getSizeInBytes(PooledByteBuffer pooledByteBuffer) {
            return pooledByteBuffer.size();
        }
    }

    public static CountingMemoryCache<CacheKey, PooledByteBuffer> get(Supplier<MemoryCacheParams> supplier, MemoryTrimmableRegistry memoryTrimmableRegistry) {
        Object countingMemoryCache = new CountingMemoryCache(new C37411(), new NativeMemoryCacheTrimStrategy(), supplier);
        memoryTrimmableRegistry.registerMemoryTrimmable(countingMemoryCache);
        return countingMemoryCache;
    }
}
