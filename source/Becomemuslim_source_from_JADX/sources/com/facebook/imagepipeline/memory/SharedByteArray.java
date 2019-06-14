package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.OOMSoftReference;
import com.facebook.common.references.ResourceReleaser;
import java.util.concurrent.Semaphore;

public class SharedByteArray implements MemoryTrimmable {
    @VisibleForTesting
    final OOMSoftReference<byte[]> mByteArraySoftRef;
    @VisibleForTesting
    final int mMaxByteArraySize;
    @VisibleForTesting
    final int mMinByteArraySize;
    private final ResourceReleaser<byte[]> mResourceReleaser;
    @VisibleForTesting
    final Semaphore mSemaphore;

    /* renamed from: com.facebook.imagepipeline.memory.SharedByteArray$1 */
    class C37541 implements ResourceReleaser<byte[]> {
        C37541() {
        }

        public void release(byte[] bArr) {
            SharedByteArray.this.mSemaphore.release();
        }
    }

    public SharedByteArray(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams) {
        Preconditions.checkNotNull(memoryTrimmableRegistry);
        boolean z = false;
        Preconditions.checkArgument(poolParams.minBucketSize > 0);
        if (poolParams.maxBucketSize >= poolParams.minBucketSize) {
            z = true;
        }
        Preconditions.checkArgument(z);
        this.mMaxByteArraySize = poolParams.maxBucketSize;
        this.mMinByteArraySize = poolParams.minBucketSize;
        this.mByteArraySoftRef = new OOMSoftReference();
        this.mSemaphore = new Semaphore(1);
        this.mResourceReleaser = new C37541();
        memoryTrimmableRegistry.registerMemoryTrimmable(this);
    }

    public CloseableReference<byte[]> get(int i) {
        boolean z = false;
        Preconditions.checkArgument(i > 0, "Size must be greater than zero");
        if (i <= this.mMaxByteArraySize) {
            z = true;
        }
        Preconditions.checkArgument(z, "Requested size is too big");
        this.mSemaphore.acquireUninterruptibly();
        try {
            return CloseableReference.of(getByteArray(i), this.mResourceReleaser);
        } catch (int i2) {
            this.mSemaphore.release();
            i2 = Throwables.propagate(i2);
        }
    }

    private byte[] getByteArray(int i) {
        i = getBucketedSize(i);
        byte[] bArr = (byte[]) this.mByteArraySoftRef.get();
        return (bArr == null || bArr.length < i) ? allocateByteArray(i) : bArr;
    }

    public void trim(MemoryTrimType memoryTrimType) {
        if (this.mSemaphore.tryAcquire() != null) {
            try {
                this.mByteArraySoftRef.clear();
            } finally {
                this.mSemaphore.release();
            }
        }
    }

    @VisibleForTesting
    int getBucketedSize(int i) {
        return Integer.highestOneBit(Math.max(i, this.mMinByteArraySize) - 1) * 2;
    }

    private synchronized byte[] allocateByteArray(int i) {
        this.mByteArraySoftRef.clear();
        i = new byte[i];
        this.mByteArraySoftRef.set(i);
        return i;
    }
}
