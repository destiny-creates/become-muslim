package com.facebook.react.uimanager.layoutanimation;

import com.facebook.react.uimanager.ViewProps;

enum AnimatedPropertyType {
    OPACITY(ViewProps.OPACITY),
    SCALE_X("scaleX"),
    SCALE_Y("scaleY"),
    SCALE_XY("scaleXY");
    
    private final String mName;

    private AnimatedPropertyType(String str) {
        this.mName = str;
    }

    public static AnimatedPropertyType fromString(String str) {
        for (AnimatedPropertyType animatedPropertyType : values()) {
            if (animatedPropertyType.toString().equalsIgnoreCase(str)) {
                return animatedPropertyType;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported animated property : ");
        stringBuilder.append(str);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public String toString() {
        return this.mName;
    }
}
