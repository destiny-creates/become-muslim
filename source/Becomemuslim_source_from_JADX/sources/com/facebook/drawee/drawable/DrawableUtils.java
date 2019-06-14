package com.facebook.drawee.drawable;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.facebook.imageutils.JfifUtil;

public class DrawableUtils {
    public static int getOpacityFromColor(int i) {
        i >>>= 24;
        return i == JfifUtil.MARKER_FIRST_BYTE ? -1 : i == 0 ? -2 : -3;
    }

    public static int multiplyColorAlpha(int i, int i2) {
        if (i2 == JfifUtil.MARKER_FIRST_BYTE) {
            return i;
        }
        if (i2 == 0) {
            return i & 16777215;
        }
        return (i & 16777215) | ((((i >>> 24) * (i2 + (i2 >> 7))) >> 8) << 24);
    }

    public static Drawable cloneDrawable(Drawable drawable) {
        if (drawable instanceof CloneableDrawable) {
            return ((CloneableDrawable) drawable).cloneDrawable();
        }
        drawable = drawable.getConstantState();
        return drawable != null ? drawable.newDrawable() : null;
    }

    public static void copyProperties(Drawable drawable, Drawable drawable2) {
        if (!(drawable2 == null || drawable == null)) {
            if (drawable != drawable2) {
                drawable.setBounds(drawable2.getBounds());
                drawable.setChangingConfigurations(drawable2.getChangingConfigurations());
                drawable.setLevel(drawable2.getLevel());
                drawable.setVisible(drawable2.isVisible(), false);
                drawable.setState(drawable2.getState());
            }
        }
    }

    public static void setDrawableProperties(Drawable drawable, DrawableProperties drawableProperties) {
        if (drawable != null) {
            if (drawableProperties != null) {
                drawableProperties.applyTo(drawable);
            }
        }
    }

    public static void setCallbacks(Drawable drawable, Callback callback, TransformCallback transformCallback) {
        if (drawable != null) {
            drawable.setCallback(callback);
            if ((drawable instanceof TransformAwareDrawable) != null) {
                ((TransformAwareDrawable) drawable).setTransformCallback(transformCallback);
            }
        }
    }
}
