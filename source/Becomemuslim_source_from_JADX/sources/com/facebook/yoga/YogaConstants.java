package com.facebook.yoga;

public class YogaConstants {
    public static final float UNDEFINED = 1.0E21f;

    public static boolean isUndefined(float f) {
        if (Float.compare(f, 1.0E9f) < 0) {
            if (Float.compare(f, -1.0E9f) > null) {
                return false;
            }
        }
        return true;
    }

    public static boolean isUndefined(YogaValue yogaValue) {
        return yogaValue.unit == YogaUnit.UNDEFINED ? true : null;
    }
}
