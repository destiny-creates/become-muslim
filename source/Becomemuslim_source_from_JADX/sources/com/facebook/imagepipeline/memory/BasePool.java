package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.Pool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class BasePool<V> implements Pool<V> {
    private final Class<?> TAG = getClass();
    private boolean mAllowNewBuckets;
    @VisibleForTesting
    final SparseArray<Bucket<V>> mBuckets;
    @VisibleForTesting
    final Counter mFree;
    @VisibleForTesting
    final Set<V> mInUseValues;
    final MemoryTrimmableRegistry mMemoryTrimmableRegistry;
    final PoolParams mPoolParams;
    private final PoolStatsTracker mPoolStatsTracker;
    @VisibleForTesting
    final Counter mUsed;

    @VisibleForTesting
    static class Counter {
        private static final String TAG = "com.facebook.imagepipeline.memory.BasePool.Counter";
        int mCount;
        int mNumBytes;

        Counter() {
        }

        public void increment(int i) {
            this.mCount++;
            this.mNumBytes += i;
        }

        public void decrement(int i) {
            if (this.mNumBytes < i || this.mCount <= 0) {
                FLog.wtf(TAG, "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.mNumBytes), Integer.valueOf(this.mCount));
                return;
            }
            this.mCount--;
            this.mNumBytes -= i;
        }

        public void reset() {
            this.mCount = 0;
            this.mNumBytes = 0;
        }
    }

    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Object obj) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid size: ");
            stringBuilder.append(obj.toString());
            super(stringBuilder.toString());
        }
    }

    public static class InvalidValueException extends RuntimeException {
        public InvalidValueException(Object obj) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid value: ");
            stringBuilder.append(obj.toString());
            super(stringBuilder.toString());
        }
    }

    public static class PoolSizeViolationException extends RuntimeException {
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Pool hard cap violation? Hard cap = ");
            stringBuilder.append(i);
            stringBuilder.append(" Used size = ");
            stringBuilder.append(i2);
            stringBuilder.append(" Free size = ");
            stringBuilder.append(i3);
            stringBuilder.append(" Request size = ");
            stringBuilder.append(i4);
            super(stringBuilder.toString());
        }
    }

    public static class SizeTooLargeException extends InvalidSizeException {
        public SizeTooLargeException(Object obj) {
            super(obj);
        }
    }

    protected abstract V alloc(int i);

    @VisibleForTesting
    protected abstract void free(V v);

    protected abstract int getBucketedSize(int i);

    protected abstract int getBucketedSizeForValue(V v);

    protected abstract int getSizeInBytes(int i);

    protected void onParamsChanged() {
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        this.mMemoryTrimmableRegistry = (MemoryTrimmableRegistry) Preconditions.checkNotNull(memoryTrimmableRegistry);
        this.mPoolParams = (PoolParams) Preconditions.checkNotNull(poolParams);
        this.mPoolStatsTracker = (PoolStatsTracker) Preconditions.checkNotNull(poolStatsTracker);
        this.mBuckets = new SparseArray();
        if (this.mPoolParams.fixBucketsReinitialization != null) {
            initBuckets();
        } else {
            legacyInitBuckets(new SparseIntArray(null));
        }
        this.mInUseValues = Sets.newIdentityHashSet();
        this.mFree = new Counter();
        this.mUsed = new Counter();
    }

    protected void initialize() {
        this.mMemoryTrimmableRegistry.registerMemoryTrimmable(this);
        this.mPoolStatsTracker.setBasePool(this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V get(int r6) {
        /*
        r5 = this;
        r5.ensurePoolSizeInvariant();
        r6 = r5.getBucketedSize(r6);
        monitor-enter(r5);
        r0 = r5.getBucket(r6);	 Catch:{ all -> 0x00cb }
        r1 = 2;
        if (r0 == 0) goto L_0x0053;
    L_0x000f:
        r2 = r0.get();	 Catch:{ all -> 0x00cb }
        if (r2 == 0) goto L_0x0053;
    L_0x0015:
        r6 = r5.mInUseValues;	 Catch:{ all -> 0x00cb }
        r6 = r6.add(r2);	 Catch:{ all -> 0x00cb }
        com.facebook.common.internal.Preconditions.checkState(r6);	 Catch:{ all -> 0x00cb }
        r6 = r5.getBucketedSizeForValue(r2);	 Catch:{ all -> 0x00cb }
        r0 = r5.getSizeInBytes(r6);	 Catch:{ all -> 0x00cb }
        r3 = r5.mUsed;	 Catch:{ all -> 0x00cb }
        r3.increment(r0);	 Catch:{ all -> 0x00cb }
        r3 = r5.mFree;	 Catch:{ all -> 0x00cb }
        r3.decrement(r0);	 Catch:{ all -> 0x00cb }
        r3 = r5.mPoolStatsTracker;	 Catch:{ all -> 0x00cb }
        r3.onValueReuse(r0);	 Catch:{ all -> 0x00cb }
        r5.logStats();	 Catch:{ all -> 0x00cb }
        r0 = com.facebook.common.logging.FLog.isLoggable(r1);	 Catch:{ all -> 0x00cb }
        if (r0 == 0) goto L_0x0051;
    L_0x003e:
        r0 = r5.TAG;	 Catch:{ all -> 0x00cb }
        r1 = "get (reuse) (object, size) = (%x, %s)";
        r3 = java.lang.System.identityHashCode(r2);	 Catch:{ all -> 0x00cb }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x00cb }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x00cb }
        com.facebook.common.logging.FLog.m5696v(r0, r1, r3, r6);	 Catch:{ all -> 0x00cb }
    L_0x0051:
        monitor-exit(r5);	 Catch:{ all -> 0x00cb }
        return r2;
    L_0x0053:
        r2 = r5.getSizeInBytes(r6);	 Catch:{ all -> 0x00cb }
        r3 = r5.canAllocate(r2);	 Catch:{ all -> 0x00cb }
        if (r3 == 0) goto L_0x00b9;
    L_0x005d:
        r3 = r5.mUsed;	 Catch:{ all -> 0x00cb }
        r3.increment(r2);	 Catch:{ all -> 0x00cb }
        if (r0 == 0) goto L_0x0067;
    L_0x0064:
        r0.incrementInUseCount();	 Catch:{ all -> 0x00cb }
    L_0x0067:
        monitor-exit(r5);	 Catch:{ all -> 0x00cb }
        r0 = 0;
        r3 = r5.alloc(r6);	 Catch:{ Throwable -> 0x006f }
        r0 = r3;
        goto L_0x0083;
    L_0x006f:
        r3 = move-exception;
        monitor-enter(r5);
        r4 = r5.mUsed;	 Catch:{ all -> 0x00b6 }
        r4.decrement(r2);	 Catch:{ all -> 0x00b6 }
        r4 = r5.getBucket(r6);	 Catch:{ all -> 0x00b6 }
        if (r4 == 0) goto L_0x007f;
    L_0x007c:
        r4.decrementInUseCount();	 Catch:{ all -> 0x00b6 }
    L_0x007f:
        monitor-exit(r5);	 Catch:{ all -> 0x00b6 }
        com.facebook.common.internal.Throwables.propagateIfPossible(r3);
    L_0x0083:
        monitor-enter(r5);
        r3 = r5.mInUseValues;	 Catch:{ all -> 0x00b3 }
        r3 = r3.add(r0);	 Catch:{ all -> 0x00b3 }
        com.facebook.common.internal.Preconditions.checkState(r3);	 Catch:{ all -> 0x00b3 }
        r5.trimToSoftCap();	 Catch:{ all -> 0x00b3 }
        r3 = r5.mPoolStatsTracker;	 Catch:{ all -> 0x00b3 }
        r3.onAlloc(r2);	 Catch:{ all -> 0x00b3 }
        r5.logStats();	 Catch:{ all -> 0x00b3 }
        r1 = com.facebook.common.logging.FLog.isLoggable(r1);	 Catch:{ all -> 0x00b3 }
        if (r1 == 0) goto L_0x00b1;
    L_0x009e:
        r1 = r5.TAG;	 Catch:{ all -> 0x00b3 }
        r2 = "get (alloc) (object, size) = (%x, %s)";
        r3 = java.lang.System.identityHashCode(r0);	 Catch:{ all -> 0x00b3 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x00b3 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x00b3 }
        com.facebook.common.logging.FLog.m5696v(r1, r2, r3, r6);	 Catch:{ all -> 0x00b3 }
    L_0x00b1:
        monitor-exit(r5);	 Catch:{ all -> 0x00b3 }
        return r0;
    L_0x00b3:
        r6 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x00b3 }
        throw r6;
    L_0x00b6:
        r6 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x00b6 }
        throw r6;
    L_0x00b9:
        r6 = new com.facebook.imagepipeline.memory.BasePool$PoolSizeViolationException;	 Catch:{ all -> 0x00cb }
        r0 = r5.mPoolParams;	 Catch:{ all -> 0x00cb }
        r0 = r0.maxSizeHardCap;	 Catch:{ all -> 0x00cb }
        r1 = r5.mUsed;	 Catch:{ all -> 0x00cb }
        r1 = r1.mNumBytes;	 Catch:{ all -> 0x00cb }
        r3 = r5.mFree;	 Catch:{ all -> 0x00cb }
        r3 = r3.mNumBytes;	 Catch:{ all -> 0x00cb }
        r6.<init>(r0, r1, r3, r2);	 Catch:{ all -> 0x00cb }
        throw r6;	 Catch:{ all -> 0x00cb }
    L_0x00cb:
        r6 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x00cb }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.get(int):V");
    }

    public void release(V v) {
        Preconditions.checkNotNull(v);
        int bucketedSizeForValue = getBucketedSizeForValue(v);
        int sizeInBytes = getSizeInBytes(bucketedSizeForValue);
        synchronized (this) {
            Bucket bucketIfPresent = getBucketIfPresent(bucketedSizeForValue);
            if (this.mInUseValues.remove(v)) {
                if (!(bucketIfPresent == null || bucketIfPresent.isMaxLengthExceeded() || isMaxSizeSoftCapExceeded())) {
                    if (isReusable(v)) {
                        bucketIfPresent.release(v);
                        this.mFree.increment(sizeInBytes);
                        this.mUsed.decrement(sizeInBytes);
                        this.mPoolStatsTracker.onValueRelease(sizeInBytes);
                        if (FLog.isLoggable(2)) {
                            FLog.m5696v(this.TAG, "release (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                        }
                    }
                }
                if (bucketIfPresent != null) {
                    bucketIfPresent.decrementInUseCount();
                }
                if (FLog.isLoggable(2)) {
                    FLog.m5696v(this.TAG, "release (free) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                }
                free(v);
                this.mUsed.decrement(sizeInBytes);
                this.mPoolStatsTracker.onFree(sizeInBytes);
            } else {
                FLog.m5672e(this.TAG, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(bucketedSizeForValue));
                free(v);
                this.mPoolStatsTracker.onFree(sizeInBytes);
            }
            logStats();
        }
    }

    public void trim(MemoryTrimType memoryTrimType) {
        trimToNothing();
    }

    protected boolean isReusable(V v) {
        Preconditions.checkNotNull(v);
        return true;
    }

    private synchronized void ensurePoolSizeInvariant() {
        boolean z;
        if (isMaxSizeSoftCapExceeded()) {
            if (this.mFree.mNumBytes != 0) {
                z = false;
                Preconditions.checkState(z);
            }
        }
        z = true;
        Preconditions.checkState(z);
    }

    private synchronized void legacyInitBuckets(SparseIntArray sparseIntArray) {
        Preconditions.checkNotNull(sparseIntArray);
        this.mBuckets.clear();
        SparseIntArray sparseIntArray2 = this.mPoolParams.bucketSizes;
        if (sparseIntArray2 != null) {
            for (int i = 0; i < sparseIntArray2.size(); i++) {
                int keyAt = sparseIntArray2.keyAt(i);
                this.mBuckets.put(keyAt, new Bucket(getSizeInBytes(keyAt), sparseIntArray2.valueAt(i), sparseIntArray.get(keyAt, 0), this.mPoolParams.fixBucketsReinitialization));
            }
            this.mAllowNewBuckets = false;
        } else {
            this.mAllowNewBuckets = true;
        }
    }

    private synchronized void initBuckets() {
        SparseIntArray sparseIntArray = this.mPoolParams.bucketSizes;
        if (sparseIntArray != null) {
            fillBuckets(sparseIntArray);
            this.mAllowNewBuckets = false;
        } else {
            this.mAllowNewBuckets = true;
        }
    }

    private void fillBuckets(SparseIntArray sparseIntArray) {
        this.mBuckets.clear();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            this.mBuckets.put(keyAt, new Bucket(getSizeInBytes(keyAt), sparseIntArray.valueAt(i), 0, this.mPoolParams.fixBucketsReinitialization));
        }
    }

    private List<Bucket<V>> refillBuckets() {
        List<Bucket<V>> arrayList = new ArrayList(this.mBuckets.size());
        int size = this.mBuckets.size();
        for (int i = 0; i < size; i++) {
            Bucket bucket = (Bucket) this.mBuckets.valueAt(i);
            int i2 = bucket.mItemSize;
            int i3 = bucket.mMaxLength;
            int inUseCount = bucket.getInUseCount();
            if (bucket.getFreeListSize() > 0) {
                arrayList.add(bucket);
            }
            this.mBuckets.setValueAt(i, new Bucket(getSizeInBytes(i2), i3, inUseCount, this.mPoolParams.fixBucketsReinitialization));
        }
        return arrayList;
    }

    @VisibleForTesting
    void trimToNothing() {
        synchronized (this) {
            List refillBuckets;
            if (this.mPoolParams.fixBucketsReinitialization) {
                refillBuckets = refillBuckets();
            } else {
                refillBuckets = new ArrayList(this.mBuckets.size());
                SparseIntArray sparseIntArray = new SparseIntArray();
                for (int i = 0; i < this.mBuckets.size(); i++) {
                    Bucket bucket = (Bucket) this.mBuckets.valueAt(i);
                    if (bucket.getFreeListSize() > 0) {
                        refillBuckets.add(bucket);
                    }
                    sparseIntArray.put(this.mBuckets.keyAt(i), bucket.getInUseCount());
                }
                legacyInitBuckets(sparseIntArray);
            }
            this.mFree.reset();
            logStats();
        }
        onParamsChanged();
        for (int i2 = 0; i2 < refillBuckets.size(); i2++) {
            Bucket bucket2 = (Bucket) refillBuckets.get(i2);
            while (true) {
                Object pop = bucket2.pop();
                if (pop == null) {
                    break;
                }
                free(pop);
            }
        }
    }

    @VisibleForTesting
    synchronized void trimToSoftCap() {
        if (isMaxSizeSoftCapExceeded()) {
            trimToSize(this.mPoolParams.maxSizeSoftCap);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.facebook.common.internal.VisibleForTesting
    synchronized void trimToSize(int r8) {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = r7.mUsed;	 Catch:{ all -> 0x008e }
        r0 = r0.mNumBytes;	 Catch:{ all -> 0x008e }
        r1 = r7.mFree;	 Catch:{ all -> 0x008e }
        r1 = r1.mNumBytes;	 Catch:{ all -> 0x008e }
        r0 = r0 + r1;
        r0 = r0 - r8;
        r1 = r7.mFree;	 Catch:{ all -> 0x008e }
        r1 = r1.mNumBytes;	 Catch:{ all -> 0x008e }
        r0 = java.lang.Math.min(r0, r1);	 Catch:{ all -> 0x008e }
        if (r0 > 0) goto L_0x0017;
    L_0x0015:
        monitor-exit(r7);
        return;
    L_0x0017:
        r1 = 2;
        r2 = com.facebook.common.logging.FLog.isLoggable(r1);	 Catch:{ all -> 0x008e }
        if (r2 == 0) goto L_0x003a;
    L_0x001e:
        r2 = r7.TAG;	 Catch:{ all -> 0x008e }
        r3 = "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d";
        r4 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x008e }
        r5 = r7.mUsed;	 Catch:{ all -> 0x008e }
        r5 = r5.mNumBytes;	 Catch:{ all -> 0x008e }
        r6 = r7.mFree;	 Catch:{ all -> 0x008e }
        r6 = r6.mNumBytes;	 Catch:{ all -> 0x008e }
        r5 = r5 + r6;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x008e }
        r6 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x008e }
        com.facebook.common.logging.FLog.m5697v(r2, r3, r4, r5, r6);	 Catch:{ all -> 0x008e }
    L_0x003a:
        r7.logStats();	 Catch:{ all -> 0x008e }
        r2 = 0;
    L_0x003e:
        r3 = r7.mBuckets;	 Catch:{ all -> 0x008e }
        r3 = r3.size();	 Catch:{ all -> 0x008e }
        if (r2 >= r3) goto L_0x006b;
    L_0x0046:
        if (r0 > 0) goto L_0x0049;
    L_0x0048:
        goto L_0x006b;
    L_0x0049:
        r3 = r7.mBuckets;	 Catch:{ all -> 0x008e }
        r3 = r3.valueAt(r2);	 Catch:{ all -> 0x008e }
        r3 = (com.facebook.imagepipeline.memory.Bucket) r3;	 Catch:{ all -> 0x008e }
    L_0x0051:
        if (r0 <= 0) goto L_0x0068;
    L_0x0053:
        r4 = r3.pop();	 Catch:{ all -> 0x008e }
        if (r4 != 0) goto L_0x005a;
    L_0x0059:
        goto L_0x0068;
    L_0x005a:
        r7.free(r4);	 Catch:{ all -> 0x008e }
        r4 = r3.mItemSize;	 Catch:{ all -> 0x008e }
        r0 = r0 - r4;
        r4 = r7.mFree;	 Catch:{ all -> 0x008e }
        r5 = r3.mItemSize;	 Catch:{ all -> 0x008e }
        r4.decrement(r5);	 Catch:{ all -> 0x008e }
        goto L_0x0051;
    L_0x0068:
        r2 = r2 + 1;
        goto L_0x003e;
    L_0x006b:
        r7.logStats();	 Catch:{ all -> 0x008e }
        r0 = com.facebook.common.logging.FLog.isLoggable(r1);	 Catch:{ all -> 0x008e }
        if (r0 == 0) goto L_0x008c;
    L_0x0074:
        r0 = r7.TAG;	 Catch:{ all -> 0x008e }
        r1 = "trimToSize: TargetSize = %d; Final Size = %d";
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x008e }
        r2 = r7.mUsed;	 Catch:{ all -> 0x008e }
        r2 = r2.mNumBytes;	 Catch:{ all -> 0x008e }
        r3 = r7.mFree;	 Catch:{ all -> 0x008e }
        r3 = r3.mNumBytes;	 Catch:{ all -> 0x008e }
        r2 = r2 + r3;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x008e }
        com.facebook.common.logging.FLog.m5696v(r0, r1, r8, r2);	 Catch:{ all -> 0x008e }
    L_0x008c:
        monitor-exit(r7);
        return;
    L_0x008e:
        r8 = move-exception;
        monitor-exit(r7);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.trimToSize(int):void");
    }

    private synchronized Bucket<V> getBucketIfPresent(int i) {
        return (Bucket) this.mBuckets.get(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.facebook.common.internal.VisibleForTesting
    synchronized com.facebook.imagepipeline.memory.Bucket<V> getBucket(int r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.mBuckets;	 Catch:{ all -> 0x002f }
        r0 = r0.get(r4);	 Catch:{ all -> 0x002f }
        r0 = (com.facebook.imagepipeline.memory.Bucket) r0;	 Catch:{ all -> 0x002f }
        if (r0 != 0) goto L_0x002d;
    L_0x000b:
        r1 = r3.mAllowNewBuckets;	 Catch:{ all -> 0x002f }
        if (r1 != 0) goto L_0x0010;
    L_0x000f:
        goto L_0x002d;
    L_0x0010:
        r0 = 2;
        r0 = com.facebook.common.logging.FLog.isLoggable(r0);	 Catch:{ all -> 0x002f }
        if (r0 == 0) goto L_0x0022;
    L_0x0017:
        r0 = r3.TAG;	 Catch:{ all -> 0x002f }
        r1 = "creating new bucket %s";
        r2 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x002f }
        com.facebook.common.logging.FLog.m5695v(r0, r1, r2);	 Catch:{ all -> 0x002f }
    L_0x0022:
        r0 = r3.newBucket(r4);	 Catch:{ all -> 0x002f }
        r1 = r3.mBuckets;	 Catch:{ all -> 0x002f }
        r1.put(r4, r0);	 Catch:{ all -> 0x002f }
        monitor-exit(r3);
        return r0;
    L_0x002d:
        monitor-exit(r3);
        return r0;
    L_0x002f:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.getBucket(int):com.facebook.imagepipeline.memory.Bucket<V>");
    }

    Bucket<V> newBucket(int i) {
        return new Bucket(getSizeInBytes(i), Integer.MAX_VALUE, 0, this.mPoolParams.fixBucketsReinitialization);
    }

    @VisibleForTesting
    synchronized boolean isMaxSizeSoftCapExceeded() {
        boolean z;
        z = this.mUsed.mNumBytes + this.mFree.mNumBytes > this.mPoolParams.maxSizeSoftCap;
        if (z) {
            this.mPoolStatsTracker.onSoftCapReached();
        }
        return z;
    }

    @VisibleForTesting
    synchronized boolean canAllocate(int i) {
        int i2 = this.mPoolParams.maxSizeHardCap;
        if (i > i2 - this.mUsed.mNumBytes) {
            this.mPoolStatsTracker.onHardCapReached();
            return false;
        }
        int i3 = this.mPoolParams.maxSizeSoftCap;
        if (i > i3 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
            trimToSize(i3 - i);
        }
        if (i <= i2 - (this.mUsed.mNumBytes + this.mFree.mNumBytes)) {
            return true;
        }
        this.mPoolStatsTracker.onHardCapReached();
        return false;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    private void logStats() {
        if (FLog.isLoggable(2)) {
            FLog.m5698v(this.TAG, "Used = (%d, %d); Free = (%d, %d)", Integer.valueOf(this.mUsed.mCount), Integer.valueOf(this.mUsed.mNumBytes), Integer.valueOf(this.mFree.mCount), Integer.valueOf(this.mFree.mNumBytes));
        }
    }

    public synchronized Map<String, Integer> getStats() {
        Map<String, Integer> hashMap;
        hashMap = new HashMap();
        for (int i = 0; i < this.mBuckets.size(); i++) {
            int keyAt = this.mBuckets.keyAt(i);
            Bucket bucket = (Bucket) this.mBuckets.valueAt(i);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(PoolStatsTracker.BUCKETS_USED_PREFIX);
            stringBuilder.append(getSizeInBytes(keyAt));
            hashMap.put(stringBuilder.toString(), Integer.valueOf(bucket.getInUseCount()));
        }
        hashMap.put(PoolStatsTracker.SOFT_CAP, Integer.valueOf(this.mPoolParams.maxSizeSoftCap));
        hashMap.put(PoolStatsTracker.HARD_CAP, Integer.valueOf(this.mPoolParams.maxSizeHardCap));
        hashMap.put(PoolStatsTracker.USED_COUNT, Integer.valueOf(this.mUsed.mCount));
        hashMap.put(PoolStatsTracker.USED_BYTES, Integer.valueOf(this.mUsed.mNumBytes));
        hashMap.put(PoolStatsTracker.FREE_COUNT, Integer.valueOf(this.mFree.mCount));
        hashMap.put(PoolStatsTracker.FREE_BYTES, Integer.valueOf(this.mFree.mNumBytes));
        return hashMap;
    }
}
