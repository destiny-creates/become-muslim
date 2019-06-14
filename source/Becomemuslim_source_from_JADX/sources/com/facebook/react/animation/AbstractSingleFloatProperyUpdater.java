package com.facebook.react.animation;

import android.view.View;

public abstract class AbstractSingleFloatProperyUpdater implements AnimationPropertyUpdater {
    private boolean mFromSource = true;
    private float mFromValue;
    private float mToValue;

    protected abstract float getProperty(View view);

    protected abstract void setProperty(View view, float f);

    protected AbstractSingleFloatProperyUpdater(float f) {
        this.mToValue = f;
    }

    protected AbstractSingleFloatProperyUpdater(float f, float f2) {
        this(f2);
        this.mFromValue = f;
    }

    public final void prepare(View view) {
        if (this.mFromSource) {
            this.mFromValue = getProperty(view);
        }
    }

    public final void onUpdate(View view, float f) {
        setProperty(view, this.mFromValue + ((this.mToValue - this.mFromValue) * f));
    }

    public void onFinish(View view) {
        setProperty(view, this.mToValue);
    }
}
