package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;

public class PoolParams {
    public static final int IGNORE_THREADS = -1;
    public final SparseIntArray bucketSizes;
    public boolean fixBucketsReinitialization;
    public final int maxBucketSize;
    public final int maxNumThreads;
    public final int maxSizeHardCap;
    public final int maxSizeSoftCap;
    public final int minBucketSize;

    public PoolParams(int i, SparseIntArray sparseIntArray) {
        this(i, i, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public PoolParams(int i, int i2, SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public PoolParams(int i, int i2, SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        boolean z = i >= 0 && i2 >= i;
        Preconditions.checkState(z);
        this.maxSizeSoftCap = i;
        this.maxSizeHardCap = i2;
        this.bucketSizes = sparseIntArray;
        this.minBucketSize = i3;
        this.maxBucketSize = i4;
        this.maxNumThreads = i5;
    }
}
