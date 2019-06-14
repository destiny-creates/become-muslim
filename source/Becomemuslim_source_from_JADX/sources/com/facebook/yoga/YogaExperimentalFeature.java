package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public enum YogaExperimentalFeature {
    WEB_FLEX_BASIS(0);
    
    private final int mIntValue;

    private YogaExperimentalFeature(int i) {
        this.mIntValue = i;
    }

    public int intValue() {
        return this.mIntValue;
    }

    public static YogaExperimentalFeature fromInt(int i) {
        if (i == 0) {
            return WEB_FLEX_BASIS;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown enum value: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
