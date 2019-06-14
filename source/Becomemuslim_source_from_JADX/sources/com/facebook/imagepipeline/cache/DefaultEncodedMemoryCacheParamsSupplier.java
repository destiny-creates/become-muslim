package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Supplier;
import com.facebook.common.util.ByteConstants;
import com.facebook.imagepipeline.memory.DefaultFlexByteArrayPoolParams;

public class DefaultEncodedMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
    private static final int MAX_CACHE_ENTRIES = Integer.MAX_VALUE;
    private static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;

    public MemoryCacheParams get() {
        int maxCacheSize = getMaxCacheSize();
        return new MemoryCacheParams(maxCacheSize, Integer.MAX_VALUE, maxCacheSize, Integer.MAX_VALUE, maxCacheSize / 8);
    }

    private int getMaxCacheSize() {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (min < 16777216) {
            return ByteConstants.MB;
        }
        return min < 33554432 ? 2097152 : DefaultFlexByteArrayPoolParams.DEFAULT_MAX_BYTE_ARRAY_SIZE;
    }
}
