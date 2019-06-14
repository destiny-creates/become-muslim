package com.facebook.react.animation;

import android.view.View;

public class ScaleXAnimationPropertyUpdater extends AbstractSingleFloatProperyUpdater {
    public ScaleXAnimationPropertyUpdater(float f) {
        super(f);
    }

    public ScaleXAnimationPropertyUpdater(float f, float f2) {
        super(f, f2);
    }

    protected float getProperty(View view) {
        return view.getScaleX();
    }

    protected void setProperty(View view, float f) {
        view.setScaleX(f);
    }
}
