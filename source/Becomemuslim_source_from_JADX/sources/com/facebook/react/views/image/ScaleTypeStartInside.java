package com.facebook.react.views.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;

public class ScaleTypeStartInside extends AbstractScaleType {
    public static final ScaleType INSTANCE = new ScaleTypeStartInside();

    public String toString() {
        return "start_inside";
    }

    public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        i = Math.min(Math.min(f3, f4), 1065353216);
        i2 = (float) rect.left;
        rect = (float) rect.top;
        matrix.setScale(i, i);
        matrix.postTranslate((float) ((int) (i2 + 1056964608)), (float) ((int) (rect + 1056964608)));
    }
}
