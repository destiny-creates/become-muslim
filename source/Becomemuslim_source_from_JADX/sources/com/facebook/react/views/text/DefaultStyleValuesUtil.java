package com.facebook.react.views.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;

public final class DefaultStyleValuesUtil {
    private DefaultStyleValuesUtil() {
        throw new AssertionError("Never invoke this for an Utility class!");
    }

    public static ColorStateList getDefaultTextColorHint(Context context) {
        return getDefaultTextAttribute(context, 16842906);
    }

    public static ColorStateList getDefaultTextColor(Context context) {
        return getDefaultTextAttribute(context, 16842904);
    }

    public static int getDefaultTextColorHighlight(Context context) {
        return getDefaultTextAttribute(context, 16842905).getDefaultColor();
    }

    private static ColorStateList getDefaultTextAttribute(Context context, int i) {
        TypedArray typedArray = null;
        try {
            context = context.getTheme().obtainStyledAttributes(new int[]{i});
            try {
                i = context.getColorStateList(0);
                if (context != null) {
                    context.recycle();
                }
                return i;
            } catch (Throwable th) {
                i = th;
                typedArray = context;
                if (typedArray != null) {
                    typedArray.recycle();
                }
                throw i;
            }
        } catch (Throwable th2) {
            i = th2;
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw i;
        }
    }
}
