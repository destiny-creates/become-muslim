package com.facebook.react.views.view;

import com.facebook.imageutils.JfifUtil;

public class ColorUtil {
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
}
