package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.BasePool.InvalidSizeException;

public class NativeMemoryChunkPool extends BasePool<NativeMemoryChunk> {
    private final int[] mBucketSizes;

    protected int getSizeInBytes(int i) {
        return i;
    }

    public NativeMemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        memoryTrimmableRegistry = poolParams.bucketSizes;
        this.mBucketSizes = new int[memoryTrimmableRegistry.size()];
        for (poolParams = null; poolParams < this.mBucketSizes.length; poolParams++) {
            this.mBucketSizes[poolParams] = memoryTrimmableRegistry.keyAt(poolParams);
        }
        initialize();
    }

    public int getMinBufferSize() {
        return this.mBucketSizes[0];
    }

    protected NativeMemoryChunk alloc(int i) {
        return new NativeMemoryChunk(i);
    }

    protected void free(NativeMemoryChunk nativeMemoryChunk) {
        Preconditions.checkNotNull(nativeMemoryChunk);
        nativeMemoryChunk.close();
    }

    protected int getBucketedSize(int i) {
        if (i > 0) {
            for (int i2 : this.mBucketSizes) {
                if (i2 >= i) {
                    return i2;
                }
            }
            return i;
        }
        throw new InvalidSizeException(Integer.valueOf(i));
    }

    protected int getBucketedSizeForValue(NativeMemoryChunk nativeMemoryChunk) {
        Preconditions.checkNotNull(nativeMemoryChunk);
        return nativeMemoryChunk.getSize();
    }

    protected boolean isReusable(NativeMemoryChunk nativeMemoryChunk) {
        Preconditions.checkNotNull(nativeMemoryChunk);
        return nativeMemoryChunk.isClosed() ^ 1;
    }
}
