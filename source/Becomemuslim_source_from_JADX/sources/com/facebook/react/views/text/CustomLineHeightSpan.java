package com.facebook.react.views.text;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;

public class CustomLineHeightSpan implements LineHeightSpan {
    private final int mHeight;

    CustomLineHeightSpan(float f) {
        this.mHeight = (int) Math.ceil((double) f);
    }

    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt.descent > this.mHeight) {
            charSequence = Math.min(this.mHeight, fontMetricsInt.descent);
            fontMetricsInt.descent = charSequence;
            fontMetricsInt.bottom = charSequence;
            fontMetricsInt.ascent = 0;
            fontMetricsInt.top = 0;
        } else if ((-fontMetricsInt.ascent) + fontMetricsInt.descent > this.mHeight) {
            fontMetricsInt.bottom = fontMetricsInt.descent;
            charSequence = (-this.mHeight) + fontMetricsInt.descent;
            fontMetricsInt.ascent = charSequence;
            fontMetricsInt.top = charSequence;
        } else if ((-fontMetricsInt.ascent) + fontMetricsInt.bottom > this.mHeight) {
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = fontMetricsInt.ascent + this.mHeight;
        } else if ((-fontMetricsInt.top) + fontMetricsInt.bottom > this.mHeight) {
            fontMetricsInt.top = fontMetricsInt.bottom - this.mHeight;
        } else {
            i3 = (double) (((float) (this.mHeight - ((-fontMetricsInt.top) + fontMetricsInt.bottom))) / 1073741824);
            fontMetricsInt.top = (int) (((double) fontMetricsInt.top) - Math.ceil(i3));
            fontMetricsInt.bottom = (int) (((double) fontMetricsInt.bottom) + Math.floor(i3));
            fontMetricsInt.ascent = fontMetricsInt.top;
            fontMetricsInt.descent = fontMetricsInt.bottom;
        }
    }
}
