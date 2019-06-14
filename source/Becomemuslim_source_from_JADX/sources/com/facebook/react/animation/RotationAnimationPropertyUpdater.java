package com.facebook.react.animation;

import android.view.View;

public class RotationAnimationPropertyUpdater extends AbstractSingleFloatProperyUpdater {
    public RotationAnimationPropertyUpdater(float f) {
        super(f);
    }

    protected float getProperty(View view) {
        return view.getRotation();
    }

    protected void setProperty(View view, float f) {
        view.setRotation((float) Math.toDegrees((double) f));
    }
}
