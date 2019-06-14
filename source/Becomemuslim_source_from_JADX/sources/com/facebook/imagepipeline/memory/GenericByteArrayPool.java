package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.BasePool.InvalidSizeException;

public class GenericByteArrayPool extends BasePool<byte[]> implements ByteArrayPool {
    private final int[] mBucketSizes;

    protected int getSizeInBytes(int i) {
        return i;
    }

    public GenericByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        memoryTrimmableRegistry = poolParams.bucketSizes;
        this.mBucketSizes = new int[memoryTrimmableRegistry.size()];
        for (poolParams = null; poolParams < memoryTrimmableRegistry.size(); poolParams++) {
            this.mBucketSizes[poolParams] = memoryTrimmableRegistry.keyAt(poolParams);
        }
        initialize();
    }

    public int getMinBufferSize() {
        return this.mBucketSizes[0];
    }

    protected byte[] alloc(int i) {
        return new byte[i];
    }

    protected void free(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
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

    protected int getBucketedSizeForValue(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        return bArr.length;
    }
}
