package com.facebook.react.uimanager;

import android.view.View.MeasureSpec;

public class MeasureSpecAssertions {
    public static final void assertExplicitMeasureSpec(int i, int i2) {
        i = MeasureSpec.getMode(i);
        i2 = MeasureSpec.getMode(i2);
        if (i == 0 || i2 == 0) {
            throw new IllegalStateException("A catalyst view must have an explicit width and height given to it. This should normally happen as part of the standard catalyst UI framework.");
        }
    }
}
