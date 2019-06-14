package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;

class OpacityAnimation extends Animation {
    private final float mDeltaOpacity;
    private final float mStartOpacity;
    private final View mView;

    static class OpacityAnimationListener implements AnimationListener {
        private boolean mLayerTypeChanged = false;
        private final View mView;

        public void onAnimationRepeat(Animation animation) {
        }

        public OpacityAnimationListener(View view) {
            this.mView = view;
        }

        public void onAnimationStart(Animation animation) {
            if (this.mView.hasOverlappingRendering() != null && this.mView.getLayerType() == null) {
                this.mLayerTypeChanged = true;
                this.mView.setLayerType(2, null);
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.mLayerTypeChanged != null) {
                this.mView.setLayerType(0, null);
            }
        }
    }

    public boolean willChangeBounds() {
        return false;
    }

    public OpacityAnimation(View view, float f, float f2) {
        this.mView = view;
        this.mStartOpacity = f;
        this.mDeltaOpacity = f2 - f;
        setAnimationListener(new OpacityAnimationListener(view));
    }

    protected void applyTransformation(float f, Transformation transformation) {
        this.mView.setAlpha(this.mStartOpacity + (this.mDeltaOpacity * f));
    }
}
