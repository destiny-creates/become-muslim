package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.util.LinkedList;
import java.util.Queue;

@VisibleForTesting
class Bucket<V> {
    private static final String TAG = "BUCKET";
    private final boolean mFixBucketsReinitialization;
    final Queue mFreeList;
    private int mInUseLength;
    public final int mItemSize;
    public final int mMaxLength;

    public Bucket(int i, int i2, int i3, boolean z) {
        boolean z2 = false;
        Preconditions.checkState(i > 0);
        Preconditions.checkState(i2 >= 0);
        if (i3 >= 0) {
            z2 = true;
        }
        Preconditions.checkState(z2);
        this.mItemSize = i;
        this.mMaxLength = i2;
        this.mFreeList = new LinkedList();
        this.mInUseLength = i3;
        this.mFixBucketsReinitialization = z;
    }

    public boolean isMaxLengthExceeded() {
        return this.mInUseLength + getFreeListSize() > this.mMaxLength;
    }

    int getFreeListSize() {
        return this.mFreeList.size();
    }

    public V get() {
        V pop = pop();
        if (pop != null) {
            this.mInUseLength++;
        }
        return pop;
    }

    public V pop() {
        return this.mFreeList.poll();
    }

    public void incrementInUseCount() {
        this.mInUseLength++;
    }

    public void release(V v) {
        Preconditions.checkNotNull(v);
        boolean z = false;
        if (this.mFixBucketsReinitialization) {
            if (this.mInUseLength > 0) {
                z = true;
            }
            Preconditions.checkState(z);
            this.mInUseLength--;
            addToFreeList(v);
        } else if (this.mInUseLength > 0) {
            this.mInUseLength--;
            addToFreeList(v);
        } else {
            FLog.m5676e(TAG, "Tried to release value %s from an empty bucket!", v);
        }
    }

    void addToFreeList(V v) {
        this.mFreeList.add(v);
    }

    public void decrementInUseCount() {
        Preconditions.checkState(this.mInUseLength > 0);
        this.mInUseLength--;
    }

    public int getInUseCount() {
        return this.mInUseLength;
    }
}
