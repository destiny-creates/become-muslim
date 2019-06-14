package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaMeasureMode {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);
    
    private final int mIntValue;

    private YogaMeasureMode(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaMeasureMode fromInt(int i) {
        switch (i) {
            case 0:
                return UNDEFINED;
            case 1:
                return EXACTLY;
            case 2:
                return AT_MOST;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown enum value: ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
