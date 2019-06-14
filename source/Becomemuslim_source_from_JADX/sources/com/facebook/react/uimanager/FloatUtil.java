package com.facebook.react.uimanager;

public class FloatUtil {
    private static final float EPSILON = 1.0E-5f;

    public static boolean floatsEqual(float f, float f2) {
        boolean z = true;
        if (!Float.isNaN(f)) {
            if (!Float.isNaN(f2)) {
                if (Math.abs(f2 - f) >= EPSILON) {
                    z = false;
                }
                return z;
            }
        }
        if (Float.isNaN(f) == null || Float.isNaN(f2) == null) {
            z = false;
        }
        return z;
    }
}
