package com.facebook.react.views.scroll;

import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;

public class OnScrollDispatchHelper {
    private static final int MIN_EVENT_SEPARATION_MS = 10;
    private long mLastScrollEventTimeMs = -11;
    private int mPrevX = LinearLayoutManager.INVALID_OFFSET;
    private int mPrevY = LinearLayoutManager.INVALID_OFFSET;
    private float mXFlingVelocity = 0.0f;
    private float mYFlingVelocity = 0.0f;

    public boolean onScrollChanged(int i, int i2) {
        boolean z;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.mLastScrollEventTimeMs <= 10 && this.mPrevX == i) {
            if (this.mPrevY == i2) {
                z = false;
                if (uptimeMillis - this.mLastScrollEventTimeMs != 0) {
                    this.mXFlingVelocity = ((float) (i - this.mPrevX)) / ((float) (uptimeMillis - this.mLastScrollEventTimeMs));
                    this.mYFlingVelocity = ((float) (i2 - this.mPrevY)) / ((float) (uptimeMillis - this.mLastScrollEventTimeMs));
                }
                this.mLastScrollEventTimeMs = uptimeMillis;
                this.mPrevX = i;
                this.mPrevY = i2;
                return z;
            }
        }
        z = true;
        if (uptimeMillis - this.mLastScrollEventTimeMs != 0) {
            this.mXFlingVelocity = ((float) (i - this.mPrevX)) / ((float) (uptimeMillis - this.mLastScrollEventTimeMs));
            this.mYFlingVelocity = ((float) (i2 - this.mPrevY)) / ((float) (uptimeMillis - this.mLastScrollEventTimeMs));
        }
        this.mLastScrollEventTimeMs = uptimeMillis;
        this.mPrevX = i;
        this.mPrevY = i2;
        return z;
    }

    public float getXFlingVelocity() {
        return this.mXFlingVelocity;
    }

    public float getYFlingVelocity() {
        return this.mYFlingVelocity;
    }
}
