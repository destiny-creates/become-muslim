package com.facebook.react.uimanager.layoutanimation;

import android.view.animation.Interpolator;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

class SimpleSpringInterpolator implements Interpolator {
    private static final float FACTOR = 0.5f;
    public static final String PARAM_SPRING_DAMPING = "springDamping";
    private final float mSpringDamping;

    public static float getSpringDamping(ReadableMap readableMap) {
        return readableMap.getType(PARAM_SPRING_DAMPING).equals(ReadableType.Number) ? (float) readableMap.getDouble(PARAM_SPRING_DAMPING) : FACTOR;
    }

    public SimpleSpringInterpolator() {
        this.mSpringDamping = FACTOR;
    }

    public SimpleSpringInterpolator(float f) {
        this.mSpringDamping = f;
    }

    public float getInterpolation(float f) {
        return (float) ((Math.pow(2.0d, (double) (-10.0f * f)) * Math.sin(((((double) (f - (this.mSpringDamping / 4.0f))) * 3.141592653589793d) * 2.0d) / ((double) this.mSpringDamping))) + 1.0d);
    }
}
