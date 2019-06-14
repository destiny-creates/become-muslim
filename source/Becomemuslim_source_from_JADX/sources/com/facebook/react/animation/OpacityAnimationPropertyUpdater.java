package com.facebook.react.animation;

import android.view.View;

public class OpacityAnimationPropertyUpdater extends AbstractSingleFloatProperyUpdater {
    public OpacityAnimationPropertyUpdater(float f) {
        super(f);
    }

    public OpacityAnimationPropertyUpdater(float f, float f2) {
        super(f, f2);
    }

    protected float getProperty(View view) {
        return view.getAlpha();
    }

    protected void setProperty(View view, float f) {
        view.setAlpha(f);
    }
}
