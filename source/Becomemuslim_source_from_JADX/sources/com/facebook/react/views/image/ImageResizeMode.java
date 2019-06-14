package com.facebook.react.views.image;

import android.graphics.Shader.TileMode;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.places.model.PlaceFields;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;

public class ImageResizeMode {
    public static ScaleType toScaleType(String str) {
        if ("contain".equals(str)) {
            return ScaleType.FIT_CENTER;
        }
        if (PlaceFields.COVER.equals(str)) {
            return ScaleType.CENTER_CROP;
        }
        if ("stretch".equals(str)) {
            return ScaleType.FIT_XY;
        }
        if ("center".equals(str)) {
            return ScaleType.CENTER_INSIDE;
        }
        if ("repeat".equals(str)) {
            return ScaleTypeStartInside.INSTANCE;
        }
        if (str == null) {
            return defaultValue();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid resize mode: '");
        stringBuilder.append(str);
        stringBuilder.append("'");
        throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
    }

    public static TileMode toTileMode(String str) {
        if (!("contain".equals(str) || PlaceFields.COVER.equals(str) || "stretch".equals(str))) {
            if (!"center".equals(str)) {
                if ("repeat".equals(str)) {
                    return TileMode.REPEAT;
                }
                if (str == null) {
                    return defaultTileMode();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid resize mode: '");
                stringBuilder.append(str);
                stringBuilder.append("'");
                throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
            }
        }
        return TileMode.CLAMP;
    }

    public static ScaleType defaultValue() {
        return ScaleType.CENTER_CROP;
    }

    public static TileMode defaultTileMode() {
        return TileMode.CLAMP;
    }
}
