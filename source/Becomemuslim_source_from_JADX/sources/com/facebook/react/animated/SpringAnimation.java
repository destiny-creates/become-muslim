package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableMap;

class SpringAnimation extends AnimationDriver {
    private static final double MAX_DELTA_TIME_SEC = 0.064d;
    private static final double SOLVER_TIMESTEP_SEC = 0.001d;
    private int mCurrentLoop;
    private final PhysicsState mCurrentState = new PhysicsState();
    private double mDisplacementFromRestThreshold;
    private double mEndValue;
    private double mInitialVelocity;
    private int mIterations;
    private long mLastTime;
    private double mOriginalValue;
    private boolean mOvershootClampingEnabled;
    private double mRestSpeedThreshold;
    private double mSpringDamping;
    private double mSpringMass;
    private boolean mSpringStarted;
    private double mSpringStiffness;
    private double mStartValue;
    private double mTimeAccumulator;

    private static class PhysicsState {
        double position;
        double velocity;

        private PhysicsState() {
        }
    }

    SpringAnimation(ReadableMap readableMap) {
        this.mCurrentState.velocity = readableMap.getDouble("initialVelocity");
        resetConfig(readableMap);
    }

    public void resetConfig(ReadableMap readableMap) {
        this.mSpringStiffness = readableMap.getDouble("stiffness");
        this.mSpringDamping = readableMap.getDouble("damping");
        this.mSpringMass = readableMap.getDouble("mass");
        this.mInitialVelocity = this.mCurrentState.velocity;
        this.mEndValue = readableMap.getDouble("toValue");
        this.mRestSpeedThreshold = readableMap.getDouble("restSpeedThreshold");
        this.mDisplacementFromRestThreshold = readableMap.getDouble("restDisplacementThreshold");
        this.mOvershootClampingEnabled = readableMap.getBoolean("overshootClamping");
        boolean z = true;
        this.mIterations = readableMap.hasKey("iterations") ? readableMap.getInt("iterations") : true;
        if (this.mIterations != null) {
            z = false;
        }
        this.mHasFinished = z;
        this.mCurrentLoop = 0;
        this.mTimeAccumulator = 0.0d;
        this.mSpringStarted = false;
    }

    public void runAnimationStep(long j) {
        j /= 1000000;
        if (!this.mSpringStarted) {
            if (this.mCurrentLoop == 0) {
                this.mOriginalValue = this.mAnimatedValue.mValue;
                this.mCurrentLoop = 1;
            }
            PhysicsState physicsState = this.mCurrentState;
            double d = this.mAnimatedValue.mValue;
            physicsState.position = d;
            this.mStartValue = d;
            this.mLastTime = j;
            this.mTimeAccumulator = 0.0d;
            this.mSpringStarted = true;
        }
        advance(((double) (j - this.mLastTime)) / 1000.0d);
        this.mLastTime = j;
        this.mAnimatedValue.mValue = this.mCurrentState.position;
        if (isAtRest() != null) {
            if (this.mIterations != -1) {
                if (this.mCurrentLoop >= this.mIterations) {
                    this.mHasFinished = true;
                    return;
                }
            }
            this.mSpringStarted = 0;
            this.mAnimatedValue.mValue = this.mOriginalValue;
            this.mCurrentLoop++;
        }
    }

    private double getDisplacementDistanceForState(PhysicsState physicsState) {
        return Math.abs(this.mEndValue - physicsState.position);
    }

    private boolean isAtRest() {
        return Math.abs(this.mCurrentState.velocity) <= this.mRestSpeedThreshold && (getDisplacementDistanceForState(this.mCurrentState) <= this.mDisplacementFromRestThreshold || this.mSpringStiffness == 0.0d);
    }

    private boolean isOvershooting() {
        return this.mSpringStiffness > 0.0d && ((this.mStartValue < this.mEndValue && this.mCurrentState.position > this.mEndValue) || (this.mStartValue > this.mEndValue && this.mCurrentState.position < this.mEndValue));
    }

    private void advance(double d) {
        SpringAnimation springAnimation = this;
        if (!isAtRest()) {
            double d2 = MAX_DELTA_TIME_SEC;
            if (d <= MAX_DELTA_TIME_SEC) {
                d2 = d;
            }
            springAnimation.mTimeAccumulator += d2;
            d2 = springAnimation.mSpringDamping;
            double d3 = springAnimation.mSpringMass;
            double d4 = springAnimation.mSpringStiffness;
            double d5 = -springAnimation.mInitialVelocity;
            d2 /= Math.sqrt(d4 * d3) * 2.0d;
            d3 = Math.sqrt(d4 / d3);
            d4 = Math.sqrt(1.0d - (d2 * d2)) * d3;
            double d6 = springAnimation.mEndValue - springAnimation.mStartValue;
            double d7 = springAnimation.mTimeAccumulator;
            if (d2 < 1.0d) {
                double exp = Math.exp(((-d2) * d3) * d7);
                d2 *= d3;
                d5 += d2 * d6;
                d7 *= d4;
                d2 = ((d2 * exp) * (((Math.sin(d7) * d5) / d4) + (Math.cos(d7) * d6))) - (((Math.cos(d7) * d5) - ((d4 * d6) * Math.sin(d7))) * exp);
                d4 = springAnimation.mEndValue - ((((d5 / d4) * Math.sin(d7)) + (Math.cos(d7) * d6)) * exp);
            } else {
                d2 = Math.exp((-d3) * d7);
                d4 = springAnimation.mEndValue - (((((d3 * d6) + d5) * d7) + d6) * d2);
                d2 *= (d5 * ((d7 * d3) - 1.0d)) + ((d7 * d6) * (d3 * d3));
            }
            springAnimation.mCurrentState.position = d4;
            springAnimation.mCurrentState.velocity = d2;
            if (isAtRest() || (springAnimation.mOvershootClampingEnabled && isOvershooting())) {
                if (springAnimation.mSpringStiffness > 0.0d) {
                    springAnimation.mStartValue = springAnimation.mEndValue;
                    springAnimation.mCurrentState.position = springAnimation.mEndValue;
                } else {
                    springAnimation.mEndValue = springAnimation.mCurrentState.position;
                    springAnimation.mStartValue = springAnimation.mEndValue;
                }
                springAnimation.mCurrentState.velocity = 0.0d;
            }
        }
    }
}
