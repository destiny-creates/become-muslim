package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaDirection {
    INHERIT(0),
    LTR(1),
    RTL(2);
    
    private final int mIntValue;

    private YogaDirection(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaDirection fromInt(int i) {
        switch (i) {
            case 0:
                return INHERIT;
            case 1:
                return LTR;
            case 2:
                return RTL;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown enum value: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
