package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class CustomStyleSpan extends MetricAffectingSpan {
    private final AssetManager mAssetManager;
    private final String mFontFamily;
    private final int mStyle;
    private final int mWeight;

    public CustomStyleSpan(int i, int i2, String str, AssetManager assetManager) {
        this.mStyle = i;
        this.mWeight = i2;
        this.mFontFamily = str;
        this.mAssetManager = assetManager;
    }

    public void updateDrawState(TextPaint textPaint) {
        apply(textPaint, this.mStyle, this.mWeight, this.mFontFamily, this.mAssetManager);
    }

    public void updateMeasureState(TextPaint textPaint) {
        apply(textPaint, this.mStyle, this.mWeight, this.mFontFamily, this.mAssetManager);
    }

    public int getStyle() {
        return this.mStyle == -1 ? 0 : this.mStyle;
    }

    public int getWeight() {
        return this.mWeight == -1 ? 0 : this.mWeight;
    }

    public String getFontFamily() {
        return this.mFontFamily;
    }

    private static void apply(Paint paint, int i, int i2, String str, AssetManager assetManager) {
        Typeface typeface = paint.getTypeface();
        int i3 = 0;
        int i4;
        if (typeface == null) {
            i4 = 0;
        } else {
            i4 = typeface.getStyle();
        }
        if (i2 == 1 || ((r2 & 1) != 0 && i2 == -1)) {
            i3 = 1;
        }
        if (i == 2 || ((2 & r2) != 0 && i == -1)) {
            i3 |= 2;
        }
        if (str != null) {
            typeface = ReactFontManager.getInstance().getTypeface(str, i3, assetManager);
        } else if (typeface != null) {
            typeface = Typeface.create(typeface, i3);
        }
        if (typeface != null) {
            paint.setTypeface(typeface);
        } else {
            paint.setTypeface(Typeface.defaultFromStyle(i3));
        }
    }
}
