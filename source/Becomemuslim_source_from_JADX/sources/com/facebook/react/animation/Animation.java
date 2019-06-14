package com.facebook.react.animation;

import android.view.View;
import expolib_v1.com.facebook.infer.annotation.Assertions;

public abstract class Animation {
    private View mAnimatedView;
    private final int mAnimationID;
    private AnimationListener mAnimationListener;
    private volatile boolean mCancelled = false;
    private volatile boolean mIsFinished = false;
    private final AnimationPropertyUpdater mPropertyUpdater;

    public abstract void run();

    public Animation(int i, AnimationPropertyUpdater animationPropertyUpdater) {
        this.mAnimationID = i;
        this.mPropertyUpdater = animationPropertyUpdater;
    }

    public void setAnimationListener(AnimationListener animationListener) {
        this.mAnimationListener = animationListener;
    }

    public final void start(View view) {
        this.mAnimatedView = view;
        this.mPropertyUpdater.prepare(view);
        run();
    }

    protected final boolean onUpdate(float f) {
        Assertions.assertCondition(this.mIsFinished ^ 1, "Animation must not already be finished!");
        if (!this.mCancelled) {
            this.mPropertyUpdater.onUpdate((View) Assertions.assertNotNull(this.mAnimatedView), f);
        }
        return this.mCancelled ^ 1;
    }

    protected final void finish() {
        Assertions.assertCondition(this.mIsFinished ^ true, "Animation must not already be finished!");
        this.mIsFinished = true;
        if (!this.mCancelled) {
            if (this.mAnimatedView != null) {
                this.mPropertyUpdater.onFinish(this.mAnimatedView);
            }
            if (this.mAnimationListener != null) {
                this.mAnimationListener.onFinished();
            }
        }
    }

    public final void cancel() {
        if (!this.mIsFinished) {
            if (!this.mCancelled) {
                this.mCancelled = true;
                if (this.mAnimationListener != null) {
                    this.mAnimationListener.onCancel();
                }
            }
        }
    }

    public int getAnimationID() {
        return this.mAnimationID;
    }
}
