package com.facebook.react.views.text;

import android.text.Spannable;

public class ReactTextUpdate {
    private final boolean mContainsImages;
    private final int mJsEventCounter;
    private final float mPaddingBottom;
    private final float mPaddingLeft;
    private final float mPaddingRight;
    private final float mPaddingTop;
    private final Spannable mText;
    private final int mTextAlign;
    private final int mTextBreakStrategy;

    @Deprecated
    public ReactTextUpdate(Spannable spannable, int i, boolean z, float f, float f2, float f3, float f4, int i2) {
        this(spannable, i, z, f, f2, f3, f4, i2, 1);
    }

    public ReactTextUpdate(Spannable spannable, int i, boolean z, float f, float f2, float f3, float f4, int i2, int i3) {
        this.mText = spannable;
        this.mJsEventCounter = i;
        this.mContainsImages = z;
        this.mPaddingLeft = f;
        this.mPaddingTop = f2;
        this.mPaddingRight = f3;
        this.mPaddingBottom = f4;
        this.mTextAlign = i2;
        this.mTextBreakStrategy = i3;
    }

    public Spannable getText() {
        return this.mText;
    }

    public int getJsEventCounter() {
        return this.mJsEventCounter;
    }

    public boolean containsImages() {
        return this.mContainsImages;
    }

    public float getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public float getPaddingTop() {
        return this.mPaddingTop;
    }

    public float getPaddingRight() {
        return this.mPaddingRight;
    }

    public float getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getTextAlign() {
        return this.mTextAlign;
    }

    public int getTextBreakStrategy() {
        return this.mTextBreakStrategy;
    }
}
