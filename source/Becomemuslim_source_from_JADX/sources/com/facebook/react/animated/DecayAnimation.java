package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

public class DecayAnimation extends AnimationDriver {
    private int mCurrentLoop;
    private double mDeceleration;
    private double mFromValue;
    private int mIterations;
    private double mLastValue;
    private long mStartFrameTimeMillis;
    private final double mVelocity;

    public DecayAnimation(ReadableMap readableMap) {
        this.mVelocity = readableMap.getDouble("velocity");
        resetConfig(readableMap);
    }

    public void resetConfig(ReadableMap readableMap) {
        this.mDeceleration = readableMap.getDouble("deceleration");
        boolean z = true;
        this.mIterations = readableMap.hasKey("iterations") ? readableMap.getInt("iterations") : true;
        this.mCurrentLoop = 1;
        if (this.mIterations != null) {
            z = false;
        }
        this.mHasFinished = z;
        this.mStartFrameTimeMillis = -1;
        this.mFromValue = 0.0d;
        this.mLastValue = 0.0d;
    }

    public void runAnimationStep(long j) {
        j /= 1000000;
        if (this.mStartFrameTimeMillis == -1) {
            this.mStartFrameTimeMillis = j - 16;
            if (this.mFromValue == this.mLastValue) {
                this.mFromValue = this.mAnimatedValue.mValue;
            } else {
                this.mAnimatedValue.mValue = this.mFromValue;
            }
            this.mLastValue = this.mAnimatedValue.mValue;
        }
        double exp = this.mFromValue + ((this.mVelocity / (1.0d - this.mDeceleration)) * (1.0d - Math.exp((-(1.0d - this.mDeceleration)) * ((double) (j - this.mStartFrameTimeMillis)))));
        if (Math.abs(this.mLastValue - exp) < 4591870180066957722L) {
            if (this.mIterations != -1) {
                if (this.mCurrentLoop >= this.mIterations) {
                    this.mHasFinished = true;
                    return;
                }
            }
            this.mStartFrameTimeMillis = -1;
            this.mCurrentLoop++;
        }
        this.mLastValue = exp;
        this.mAnimatedValue.mValue = exp;
    }
}
