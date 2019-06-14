package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.p028d.C0384a;
import android.support.v4.p032h.C0414c;
import android.support.v4.view.C0501e;
import android.support.v4.view.C0517s;
import android.support.v7.p035a.C0591a.C0590j;
import android.support.v7.widget.bq;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;

final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    private static final Paint DEBUG_DRAW_PAINT = null;
    private static final boolean USE_SCALING_TEXTURE = (VERSION.SDK_INT < 18);
    private boolean mBoundsChanged;
    private final Rect mCollapsedBounds;
    private float mCollapsedDrawX;
    private float mCollapsedDrawY;
    private int mCollapsedShadowColor;
    private float mCollapsedShadowDx;
    private float mCollapsedShadowDy;
    private float mCollapsedShadowRadius;
    private ColorStateList mCollapsedTextColor;
    private int mCollapsedTextGravity = 16;
    private float mCollapsedTextSize = 15.0f;
    private Typeface mCollapsedTypeface;
    private final RectF mCurrentBounds;
    private float mCurrentDrawX;
    private float mCurrentDrawY;
    private float mCurrentTextSize;
    private Typeface mCurrentTypeface;
    private boolean mDrawTitle;
    private final Rect mExpandedBounds;
    private float mExpandedDrawX;
    private float mExpandedDrawY;
    private float mExpandedFraction;
    private int mExpandedShadowColor;
    private float mExpandedShadowDx;
    private float mExpandedShadowDy;
    private float mExpandedShadowRadius;
    private ColorStateList mExpandedTextColor;
    private int mExpandedTextGravity = 16;
    private float mExpandedTextSize = 15.0f;
    private Bitmap mExpandedTitleTexture;
    private Typeface mExpandedTypeface;
    private boolean mIsRtl;
    private Interpolator mPositionInterpolator;
    private float mScale;
    private int[] mState;
    private CharSequence mText;
    private final TextPaint mTextPaint;
    private Interpolator mTextSizeInterpolator;
    private CharSequence mTextToDraw;
    private float mTextureAscent;
    private float mTextureDescent;
    private Paint mTexturePaint;
    private boolean mUseTexture;
    private final View mView;

    static {
        if (DEBUG_DRAW_PAINT != null) {
            DEBUG_DRAW_PAINT.setAntiAlias(true);
            DEBUG_DRAW_PAINT.setColor(-65281);
        }
    }

    public CollapsingTextHelper(View view) {
        this.mView = view;
        this.mTextPaint = new TextPaint(129);
        this.mCollapsedBounds = new Rect();
        this.mExpandedBounds = new Rect();
        this.mCurrentBounds = new RectF();
    }

    void setTextSizeInterpolator(Interpolator interpolator) {
        this.mTextSizeInterpolator = interpolator;
        recalculate();
    }

    void setPositionInterpolator(Interpolator interpolator) {
        this.mPositionInterpolator = interpolator;
        recalculate();
    }

    void setExpandedTextSize(float f) {
        if (this.mExpandedTextSize != f) {
            this.mExpandedTextSize = f;
            recalculate();
        }
    }

    void setCollapsedTextSize(float f) {
        if (this.mCollapsedTextSize != f) {
            this.mCollapsedTextSize = f;
            recalculate();
        }
    }

    void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.mCollapsedTextColor != colorStateList) {
            this.mCollapsedTextColor = colorStateList;
            recalculate();
        }
    }

    void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.mExpandedTextColor != colorStateList) {
            this.mExpandedTextColor = colorStateList;
            recalculate();
        }
    }

    void setExpandedBounds(int i, int i2, int i3, int i4) {
        if (!rectEquals(this.mExpandedBounds, i, i2, i3, i4)) {
            this.mExpandedBounds.set(i, i2, i3, i4);
            this.mBoundsChanged = true;
            onBoundsChanged();
        }
    }

    void setCollapsedBounds(int i, int i2, int i3, int i4) {
        if (!rectEquals(this.mCollapsedBounds, i, i2, i3, i4)) {
            this.mCollapsedBounds.set(i, i2, i3, i4);
            this.mBoundsChanged = true;
            onBoundsChanged();
        }
    }

    void onBoundsChanged() {
        boolean z = this.mCollapsedBounds.width() > 0 && this.mCollapsedBounds.height() > 0 && this.mExpandedBounds.width() > 0 && this.mExpandedBounds.height() > 0;
        this.mDrawTitle = z;
    }

    void setExpandedTextGravity(int i) {
        if (this.mExpandedTextGravity != i) {
            this.mExpandedTextGravity = i;
            recalculate();
        }
    }

    int getExpandedTextGravity() {
        return this.mExpandedTextGravity;
    }

    void setCollapsedTextGravity(int i) {
        if (this.mCollapsedTextGravity != i) {
            this.mCollapsedTextGravity = i;
            recalculate();
        }
    }

    int getCollapsedTextGravity() {
        return this.mCollapsedTextGravity;
    }

    void setCollapsedTextAppearance(int i) {
        bq a = bq.m2767a(this.mView.getContext(), i, C0590j.TextAppearance);
        if (a.m2787g(C0590j.TextAppearance_android_textColor)) {
            this.mCollapsedTextColor = a.m2783e(C0590j.TextAppearance_android_textColor);
        }
        if (a.m2787g(C0590j.TextAppearance_android_textSize)) {
            this.mCollapsedTextSize = (float) a.m2782e(C0590j.TextAppearance_android_textSize, (int) this.mCollapsedTextSize);
        }
        this.mCollapsedShadowColor = a.m2771a(C0590j.TextAppearance_android_shadowColor, 0);
        this.mCollapsedShadowDx = a.m2770a(C0590j.TextAppearance_android_shadowDx, 0.0f);
        this.mCollapsedShadowDy = a.m2770a(C0590j.TextAppearance_android_shadowDy, 0.0f);
        this.mCollapsedShadowRadius = a.m2770a(C0590j.TextAppearance_android_shadowRadius, 0.0f);
        a.m2774a();
        if (VERSION.SDK_INT >= 16) {
            this.mCollapsedTypeface = readFontFamilyTypeface(i);
        }
        recalculate();
    }

    void setExpandedTextAppearance(int i) {
        bq a = bq.m2767a(this.mView.getContext(), i, C0590j.TextAppearance);
        if (a.m2787g(C0590j.TextAppearance_android_textColor)) {
            this.mExpandedTextColor = a.m2783e(C0590j.TextAppearance_android_textColor);
        }
        if (a.m2787g(C0590j.TextAppearance_android_textSize)) {
            this.mExpandedTextSize = (float) a.m2782e(C0590j.TextAppearance_android_textSize, (int) this.mExpandedTextSize);
        }
        this.mExpandedShadowColor = a.m2771a(C0590j.TextAppearance_android_shadowColor, 0);
        this.mExpandedShadowDx = a.m2770a(C0590j.TextAppearance_android_shadowDx, 0.0f);
        this.mExpandedShadowDy = a.m2770a(C0590j.TextAppearance_android_shadowDy, 0.0f);
        this.mExpandedShadowRadius = a.m2770a(C0590j.TextAppearance_android_shadowRadius, 0.0f);
        a.m2774a();
        if (VERSION.SDK_INT >= 16) {
            this.mExpandedTypeface = readFontFamilyTypeface(i);
        }
        recalculate();
    }

    private Typeface readFontFamilyTypeface(int i) {
        i = this.mView.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = i.getString(0);
            if (string != null) {
                Typeface create = Typeface.create(string, 0);
                return create;
            }
            i.recycle();
            return 0;
        } finally {
            i.recycle();
        }
    }

    void setCollapsedTypeface(Typeface typeface) {
        if (areTypefacesDifferent(this.mCollapsedTypeface, typeface)) {
            this.mCollapsedTypeface = typeface;
            recalculate();
        }
    }

    void setExpandedTypeface(Typeface typeface) {
        if (areTypefacesDifferent(this.mExpandedTypeface, typeface)) {
            this.mExpandedTypeface = typeface;
            recalculate();
        }
    }

    void setTypefaces(Typeface typeface) {
        this.mExpandedTypeface = typeface;
        this.mCollapsedTypeface = typeface;
        recalculate();
    }

    Typeface getCollapsedTypeface() {
        return this.mCollapsedTypeface != null ? this.mCollapsedTypeface : Typeface.DEFAULT;
    }

    Typeface getExpandedTypeface() {
        return this.mExpandedTypeface != null ? this.mExpandedTypeface : Typeface.DEFAULT;
    }

    void setExpansionFraction(float f) {
        f = C0384a.m1162a(f, 0.0f, 1.0f);
        if (f != this.mExpandedFraction) {
            this.mExpandedFraction = f;
            calculateCurrentOffsets();
        }
    }

    final boolean setState(int[] iArr) {
        this.mState = iArr;
        if (isStateful() == null) {
            return null;
        }
        recalculate();
        return 1;
    }

    final boolean isStateful() {
        return (this.mCollapsedTextColor != null && this.mCollapsedTextColor.isStateful()) || (this.mExpandedTextColor != null && this.mExpandedTextColor.isStateful());
    }

    float getExpansionFraction() {
        return this.mExpandedFraction;
    }

    float getCollapsedTextSize() {
        return this.mCollapsedTextSize;
    }

    float getExpandedTextSize() {
        return this.mExpandedTextSize;
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.mExpandedFraction);
    }

    private void calculateOffsets(float f) {
        interpolateBounds(f);
        this.mCurrentDrawX = lerp(this.mExpandedDrawX, this.mCollapsedDrawX, f, this.mPositionInterpolator);
        this.mCurrentDrawY = lerp(this.mExpandedDrawY, this.mCollapsedDrawY, f, this.mPositionInterpolator);
        setInterpolatedTextSize(lerp(this.mExpandedTextSize, this.mCollapsedTextSize, f, this.mTextSizeInterpolator));
        if (this.mCollapsedTextColor != this.mExpandedTextColor) {
            this.mTextPaint.setColor(blendColors(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), f));
        } else {
            this.mTextPaint.setColor(getCurrentCollapsedTextColor());
        }
        this.mTextPaint.setShadowLayer(lerp(this.mExpandedShadowRadius, this.mCollapsedShadowRadius, f, null), lerp(this.mExpandedShadowDx, this.mCollapsedShadowDx, f, null), lerp(this.mExpandedShadowDy, this.mCollapsedShadowDy, f, null), blendColors(this.mExpandedShadowColor, this.mCollapsedShadowColor, f));
        C0517s.m1706c(this.mView);
    }

    private int getCurrentExpandedTextColor() {
        if (this.mState != null) {
            return this.mExpandedTextColor.getColorForState(this.mState, 0);
        }
        return this.mExpandedTextColor.getDefaultColor();
    }

    private int getCurrentCollapsedTextColor() {
        if (this.mState != null) {
            return this.mCollapsedTextColor.getColorForState(this.mState, 0);
        }
        return this.mCollapsedTextColor.getDefaultColor();
    }

    private void calculateBaseOffsets() {
        float f = this.mCurrentTextSize;
        calculateUsingTextSize(this.mCollapsedTextSize);
        float f2 = 0.0f;
        float measureText = this.mTextToDraw != null ? this.mTextPaint.measureText(this.mTextToDraw, 0, this.mTextToDraw.length()) : 0.0f;
        int a = C0501e.m1587a(this.mCollapsedTextGravity, this.mIsRtl);
        int i = a & 112;
        if (i == 48) {
            this.mCollapsedDrawY = ((float) this.mCollapsedBounds.top) - this.mTextPaint.ascent();
        } else if (i != 80) {
            this.mCollapsedDrawY = ((float) this.mCollapsedBounds.centerY()) + (((this.mTextPaint.descent() - this.mTextPaint.ascent()) / 2.0f) - this.mTextPaint.descent());
        } else {
            this.mCollapsedDrawY = (float) this.mCollapsedBounds.bottom;
        }
        a &= 8388615;
        if (a == 1) {
            this.mCollapsedDrawX = ((float) this.mCollapsedBounds.centerX()) - (measureText / 2.0f);
        } else if (a != 5) {
            this.mCollapsedDrawX = (float) this.mCollapsedBounds.left;
        } else {
            this.mCollapsedDrawX = ((float) this.mCollapsedBounds.right) - measureText;
        }
        calculateUsingTextSize(this.mExpandedTextSize);
        if (this.mTextToDraw != null) {
            f2 = this.mTextPaint.measureText(this.mTextToDraw, 0, this.mTextToDraw.length());
        }
        int a2 = C0501e.m1587a(this.mExpandedTextGravity, this.mIsRtl);
        int i2 = a2 & 112;
        if (i2 == 48) {
            this.mExpandedDrawY = ((float) this.mExpandedBounds.top) - this.mTextPaint.ascent();
        } else if (i2 != 80) {
            this.mExpandedDrawY = ((float) this.mExpandedBounds.centerY()) + (((this.mTextPaint.descent() - this.mTextPaint.ascent()) / 2.0f) - this.mTextPaint.descent());
        } else {
            this.mExpandedDrawY = (float) this.mExpandedBounds.bottom;
        }
        a2 &= 8388615;
        if (a2 == 1) {
            this.mExpandedDrawX = ((float) this.mExpandedBounds.centerX()) - (f2 / 2.0f);
        } else if (a2 != 5) {
            this.mExpandedDrawX = (float) this.mExpandedBounds.left;
        } else {
            this.mExpandedDrawX = ((float) this.mExpandedBounds.right) - f2;
        }
        clearTexture();
        setInterpolatedTextSize(f);
    }

    private void interpolateBounds(float f) {
        this.mCurrentBounds.left = lerp((float) this.mExpandedBounds.left, (float) this.mCollapsedBounds.left, f, this.mPositionInterpolator);
        this.mCurrentBounds.top = lerp(this.mExpandedDrawY, this.mCollapsedDrawY, f, this.mPositionInterpolator);
        this.mCurrentBounds.right = lerp((float) this.mExpandedBounds.right, (float) this.mCollapsedBounds.right, f, this.mPositionInterpolator);
        this.mCurrentBounds.bottom = lerp((float) this.mExpandedBounds.bottom, (float) this.mCollapsedBounds.bottom, f, this.mPositionInterpolator);
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        if (this.mTextToDraw != null && this.mDrawTitle) {
            float f;
            float f2 = this.mCurrentDrawX;
            float f3 = this.mCurrentDrawY;
            Object obj = (!this.mUseTexture || this.mExpandedTitleTexture == null) ? null : 1;
            float f4;
            if (obj != null) {
                f = this.mTextureAscent * this.mScale;
                f4 = this.mTextureDescent;
                f4 = this.mScale;
            } else {
                f = this.mTextPaint.ascent() * this.mScale;
                this.mTextPaint.descent();
                f4 = this.mScale;
            }
            if (obj != null) {
                f3 += f;
            }
            float f5 = f3;
            if (this.mScale != 1.0f) {
                canvas.scale(this.mScale, this.mScale, f2, f5);
            }
            if (obj != null) {
                canvas.drawBitmap(this.mExpandedTitleTexture, f2, f5, this.mTexturePaint);
            } else {
                canvas.drawText(this.mTextToDraw, 0, this.mTextToDraw.length(), f2, f5, this.mTextPaint);
            }
        }
        canvas.restoreToCount(save);
    }

    private boolean calculateIsRtl(CharSequence charSequence) {
        Object obj = 1;
        if (C0517s.m1711e(this.mView) != 1) {
            obj = null;
        }
        return (obj != null ? C0414c.f1071d : C0414c.f1070c).mo229a(charSequence, 0, charSequence.length());
    }

    private void setInterpolatedTextSize(float f) {
        calculateUsingTextSize(f);
        f = (USE_SCALING_TEXTURE == null || this.mScale == 1.0f) ? 0.0f : Float.MIN_VALUE;
        this.mUseTexture = f;
        if (this.mUseTexture != null) {
            ensureExpandedTexture();
        }
        C0517s.m1706c(this.mView);
    }

    private boolean areTypefacesDifferent(Typeface typeface, Typeface typeface2) {
        return ((typeface == null || typeface.equals(typeface2)) && (typeface != null || typeface2 == null)) ? null : true;
    }

    private void calculateUsingTextSize(float f) {
        if (this.mText != null) {
            float f2;
            Object obj;
            float width = (float) this.mCollapsedBounds.width();
            float width2 = (float) this.mExpandedBounds.width();
            boolean z = true;
            if (isClose(f, this.mCollapsedTextSize)) {
                Object obj2;
                f = this.mCollapsedTextSize;
                this.mScale = 1.0f;
                if (areTypefacesDifferent(this.mCurrentTypeface, this.mCollapsedTypeface)) {
                    this.mCurrentTypeface = this.mCollapsedTypeface;
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                f2 = f;
                obj = obj2;
            } else {
                f2 = this.mExpandedTextSize;
                if (areTypefacesDifferent(this.mCurrentTypeface, this.mExpandedTypeface)) {
                    this.mCurrentTypeface = this.mExpandedTypeface;
                    obj = 1;
                } else {
                    obj = null;
                }
                if (isClose(f, this.mExpandedTextSize)) {
                    this.mScale = 1.0f;
                } else {
                    this.mScale = f / this.mExpandedTextSize;
                }
                f = this.mCollapsedTextSize / this.mExpandedTextSize;
                width = width2 * f > width ? Math.min(width / f, width2) : width2;
            }
            if (width > 0.0f) {
                if (this.mCurrentTextSize == f2 && this.mBoundsChanged == null) {
                    if (obj == null) {
                        obj = null;
                        this.mCurrentTextSize = f2;
                        this.mBoundsChanged = false;
                    }
                }
                obj = 1;
                this.mCurrentTextSize = f2;
                this.mBoundsChanged = false;
            }
            if (this.mTextToDraw == null || r6 != null) {
                this.mTextPaint.setTextSize(this.mCurrentTextSize);
                this.mTextPaint.setTypeface(this.mCurrentTypeface);
                f = this.mTextPaint;
                if (this.mScale == 1.0f) {
                    z = false;
                }
                f.setLinearText(z);
                f = TextUtils.ellipsize(this.mText, this.mTextPaint, width, TruncateAt.END);
                if (!TextUtils.equals(f, this.mTextToDraw)) {
                    this.mTextToDraw = f;
                    this.mIsRtl = calculateIsRtl(this.mTextToDraw);
                }
            }
        }
    }

    private void ensureExpandedTexture() {
        if (this.mExpandedTitleTexture == null && !this.mExpandedBounds.isEmpty()) {
            if (!TextUtils.isEmpty(this.mTextToDraw)) {
                calculateOffsets(0.0f);
                this.mTextureAscent = this.mTextPaint.ascent();
                this.mTextureDescent = this.mTextPaint.descent();
                int round = Math.round(this.mTextPaint.measureText(this.mTextToDraw, 0, this.mTextToDraw.length()));
                int round2 = Math.round(this.mTextureDescent - this.mTextureAscent);
                if (round > 0) {
                    if (round2 > 0) {
                        this.mExpandedTitleTexture = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
                        new Canvas(this.mExpandedTitleTexture).drawText(this.mTextToDraw, 0, this.mTextToDraw.length(), 0.0f, ((float) round2) - this.mTextPaint.descent(), this.mTextPaint);
                        if (this.mTexturePaint == null) {
                            this.mTexturePaint = new Paint(3);
                        }
                    }
                }
            }
        }
    }

    public void recalculate() {
        if (this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            calculateBaseOffsets();
            calculateCurrentOffsets();
        }
    }

    void setText(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.mText)) {
            this.mText = charSequence;
            this.mTextToDraw = null;
            clearTexture();
            recalculate();
        }
    }

    CharSequence getText() {
        return this.mText;
    }

    private void clearTexture() {
        if (this.mExpandedTitleTexture != null) {
            this.mExpandedTitleTexture.recycle();
            this.mExpandedTitleTexture = null;
        }
    }

    private static boolean isClose(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    ColorStateList getExpandedTextColor() {
        return this.mExpandedTextColor;
    }

    ColorStateList getCollapsedTextColor() {
        return this.mCollapsedTextColor;
    }

    private static int blendColors(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((((float) Color.blue(i)) * f2) + (((float) Color.blue(i2)) * f)));
    }

    private static float lerp(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return C0166a.m376a(f, f2, f3);
    }

    private static boolean rectEquals(Rect rect, int i, int i2, int i3, int i4) {
        return (rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4) ? true : null;
    }
}
