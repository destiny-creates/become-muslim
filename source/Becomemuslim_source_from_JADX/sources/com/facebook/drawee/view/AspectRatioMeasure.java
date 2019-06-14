package com.facebook.drawee.view;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;

public class AspectRatioMeasure {

    public static class Spec {
        public int height;
        public int width;
    }

    private static boolean shouldAdjust(int i) {
        if (i != 0) {
            if (i != -2) {
                return false;
            }
        }
        return true;
    }

    public static void updateMeasureSpec(Spec spec, float f, LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f) {
            if (layoutParams != null) {
                if (shouldAdjust(layoutParams.height)) {
                    spec.height = MeasureSpec.makeMeasureSpec(View.resolveSize((int) ((((float) (MeasureSpec.getSize(spec.width) - i)) / f) + ((float) i2)), spec.height), 1073741824);
                } else if (shouldAdjust(layoutParams.width) != null) {
                    spec.width = MeasureSpec.makeMeasureSpec(View.resolveSize((int) ((((float) (MeasureSpec.getSize(spec.height) - i2)) * f) + ((float) i)), spec.width), 1073741824);
                }
            }
        }
    }
}
