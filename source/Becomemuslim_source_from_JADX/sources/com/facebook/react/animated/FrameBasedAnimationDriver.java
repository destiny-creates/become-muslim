package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

class FrameBasedAnimationDriver extends AnimationDriver {
    private static final double FRAME_TIME_MILLIS = 16.666666666666668d;
    private int mCurrentLoop;
    private double[] mFrames;
    private double mFromValue;
    private int mIterations;
    private long mStartFrameTimeNanos;
    private double mToValue;

    FrameBasedAnimationDriver(ReadableMap readableMap) {
        resetConfig(readableMap);
    }

    public void resetConfig(ReadableMap readableMap) {
        ReadableArray array = readableMap.getArray("frames");
        int size = array.size();
        if (this.mFrames == null || this.mFrames.length != size) {
            this.mFrames = new double[size];
        }
        for (int i = 0; i < size; i++) {
            this.mFrames[i] = array.getDouble(i);
        }
        this.mToValue = readableMap.hasKey("toValue") ? readableMap.getDouble("toValue") : 0.0d;
        boolean z = true;
        this.mIterations = readableMap.hasKey("iterations") ? readableMap.getInt("iterations") : true;
        this.mCurrentLoop = 1;
        if (this.mIterations != null) {
            z = false;
        }
        this.mHasFinished = z;
        this.mStartFrameTimeNanos = -1;
    }

    public void runAnimationStep(long j) {
        if (this.mStartFrameTimeNanos < 0) {
            this.mStartFrameTimeNanos = j;
            if (this.mCurrentLoop == 1) {
                this.mFromValue = this.mAnimatedValue.mValue;
            }
        }
        j = (int) Math.round(((double) ((j - this.mStartFrameTimeNanos) / 1000000)) / 4625384467293973163L);
        if (j < null) {
            throw new IllegalStateException("Calculated frame index should never be lower than 0");
        } else if (!this.mHasFinished) {
            if (j >= this.mFrames.length - 1) {
                j = this.mToValue;
                if (this.mIterations != -1) {
                    if (this.mCurrentLoop >= this.mIterations) {
                        this.mHasFinished = true;
                    }
                }
                this.mStartFrameTimeNanos = -1;
                this.mCurrentLoop++;
            } else {
                j = (this.mFrames[j] * (this.mToValue - this.mFromValue)) + this.mFromValue;
            }
            this.mAnimatedValue.mValue = j;
        }
    }
}
