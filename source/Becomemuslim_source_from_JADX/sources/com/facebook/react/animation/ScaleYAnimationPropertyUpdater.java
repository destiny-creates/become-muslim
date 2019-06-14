package com.facebook.react.animation;

import android.view.View;

public class ScaleYAnimationPropertyUpdater extends AbstractSingleFloatProperyUpdater {
    public ScaleYAnimationPropertyUpdater(float f) {
        super(f);
    }

    public ScaleYAnimationPropertyUpdater(float f, float f2) {
        super(f, f2);
    }

    protected float getProperty(View view) {
        return view.getScaleY();
    }

    protected void setProperty(View view, float f) {
        view.setScaleY(f);
    }
}
