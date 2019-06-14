package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

public class DefaultFlexByteArrayPoolParams {
    public static final int DEFAULT_MAX_BYTE_ARRAY_SIZE = 4194304;
    public static final int DEFAULT_MAX_NUM_THREADS = Runtime.getRuntime().availableProcessors();
    private static final int DEFAULT_MIN_BYTE_ARRAY_SIZE = 131072;

    private DefaultFlexByteArrayPoolParams() {
    }

    public static SparseIntArray generateBuckets(int i, int i2, int i3) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        while (i <= i2) {
            sparseIntArray.put(i, i3);
            i *= 2;
        }
        return sparseIntArray;
    }

    public static PoolParams get() {
        return new PoolParams(DEFAULT_MAX_BYTE_ARRAY_SIZE, DEFAULT_MAX_NUM_THREADS * DEFAULT_MAX_BYTE_ARRAY_SIZE, generateBuckets(DEFAULT_MIN_BYTE_ARRAY_SIZE, DEFAULT_MAX_BYTE_ARRAY_SIZE, DEFAULT_MAX_NUM_THREADS), DEFAULT_MIN_BYTE_ARRAY_SIZE, DEFAULT_MAX_BYTE_ARRAY_SIZE, DEFAULT_MAX_NUM_THREADS);
    }
}