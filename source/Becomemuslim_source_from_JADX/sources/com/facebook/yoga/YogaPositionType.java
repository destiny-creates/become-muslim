package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaPositionType {
    RELATIVE(0),
    ABSOLUTE(1);
    
    private final int mIntValue;

    private YogaPositionType(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaPositionType fromInt(int i) {
        switch (i) {
            case 0:
                return RELATIVE;
            case 1:
                return ABSOLUTE;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown enum value: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
