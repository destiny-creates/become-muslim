package com.facebook.react.views.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.Spacing;
import com.facebook.yoga.YogaConstants;
import java.util.Arrays;
import java.util.Locale;

public class ReactViewBackgroundDrawable extends Drawable {
    private static final int ALL_BITS_SET = -1;
    private static final int ALL_BITS_UNSET = 0;
    private static final int DEFAULT_BORDER_ALPHA = 255;
    private static final int DEFAULT_BORDER_COLOR = -16777216;
    private static final int DEFAULT_BORDER_RGB = 0;
    private int mAlpha = 255;
    private Spacing mBorderAlpha;
    private float[] mBorderCornerRadii;
    private Spacing mBorderRGB;
    private float mBorderRadius = 1.0E21f;
    private BorderStyle mBorderStyle;
    private Spacing mBorderWidth;
    private Path mCenterDrawPath;
    private int mColor = 0;
    private final Context mContext;
    private PointF mInnerBottomLeftCorner;
    private PointF mInnerBottomRightCorner;
    private Path mInnerClipPathForBorderRadius;
    private RectF mInnerClipTempRectForBorderRadius;
    private PointF mInnerTopLeftCorner;
    private PointF mInnerTopRightCorner;
    private int mLayoutDirection;
    private boolean mNeedUpdatePathForBorderRadius = false;
    private Path mOuterClipPathForBorderRadius;
    private RectF mOuterClipTempRectForBorderRadius;
    private final Paint mPaint = new Paint(1);
    private PathEffect mPathEffectForBorderStyle;
    private Path mPathForBorder;
    private Path mPathForBorderRadiusOutline;
    private RectF mTempRectForBorderRadiusOutline;
    private RectF mTempRectForCenterDrawPath;

    public enum BorderRadiusLocation {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_RIGHT,
        BOTTOM_LEFT,
        TOP_START,
        TOP_END,
        BOTTOM_START,
        BOTTOM_END
    }

    private enum BorderStyle {
        SOLID,
        DASHED,
        DOTTED;

        public PathEffect getPathEffect(float f) {
            switch (this) {
                case SOLID:
                    return null;
                case DASHED:
                    r6 = new float[4];
                    f *= 3.0f;
                    r6[0] = f;
                    r6[1] = f;
                    r6[2] = f;
                    r6[3] = f;
                    return new DashPathEffect(r6, 0.0f);
                case DOTTED:
                    return new DashPathEffect(new float[]{f, f, f, f}, 0.0f);
                default:
                    return null;
            }
        }
    }

    private static int colorFromAlphaAndRGBComponents(float f, float f2) {
        return ((((int) f) << 24) & DEFAULT_BORDER_COLOR) | (((int) f2) & 16777215);
    }

    private static int fastBorderCompatibleColorOrZero(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = -1;
        int i10 = ((i > 0 ? i5 : -1) & (i2 > 0 ? i6 : -1)) & (i3 > 0 ? i7 : -1);
        if (i4 > 0) {
            i9 = i8;
        }
        i9 &= i10;
        if (i <= 0) {
            i5 = 0;
        }
        if (i2 <= 0) {
            i6 = 0;
        }
        i = i5 | i6;
        if (i3 <= 0) {
            i7 = 0;
        }
        i |= i7;
        if (i4 <= 0) {
            i8 = 0;
        }
        return i9 == (i | i8) ? i9 : 0;
    }

    public boolean onResolvedLayoutDirectionChanged(int i) {
        return false;
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public ReactViewBackgroundDrawable(Context context) {
        this.mContext = context;
    }

    public void draw(Canvas canvas) {
        updatePathEffect();
        if (hasRoundedBorders()) {
            drawRoundedBackgroundWithBorders(canvas);
        } else {
            drawRectangularBackgroundWithBorders(canvas);
        }
    }

    public boolean hasRoundedBorders() {
        if (!YogaConstants.isUndefined(this.mBorderRadius) && this.mBorderRadius > 0.0f) {
            return true;
        }
        if (this.mBorderCornerRadii != null) {
            for (float f : this.mBorderCornerRadii) {
                if (!YogaConstants.isUndefined(f) && f > 0.0f) {
                    return true;
                }
            }
        }
        return false;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mNeedUpdatePathForBorderRadius = true;
    }

    public void setAlpha(int i) {
        if (i != this.mAlpha) {
            this.mAlpha = i;
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public int getOpacity() {
        return ColorUtil.getOpacityFromColor(ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha));
    }

    public void getOutline(Outline outline) {
        if (VERSION.SDK_INT < 21) {
            super.getOutline(outline);
            return;
        }
        if ((YogaConstants.isUndefined(this.mBorderRadius) || this.mBorderRadius <= 0.0f) && this.mBorderCornerRadii == null) {
            outline.setRect(getBounds());
        } else {
            updatePath();
            outline.setConvexPath(this.mPathForBorderRadiusOutline);
        }
    }

    public void setBorderWidth(int i, float f) {
        if (this.mBorderWidth == null) {
            this.mBorderWidth = new Spacing();
        }
        if (!FloatUtil.floatsEqual(this.mBorderWidth.getRaw(i), f)) {
            this.mBorderWidth.set(i, f);
            if (i != 8) {
                switch (i) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        break;
                    default:
                        break;
                }
            }
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public void setBorderColor(int i, float f, float f2) {
        setBorderRGB(i, f);
        setBorderAlpha(i, f2);
    }

    private void setBorderRGB(int i, float f) {
        if (this.mBorderRGB == null) {
            this.mBorderRGB = new Spacing(0.0f);
        }
        if (!FloatUtil.floatsEqual(this.mBorderRGB.getRaw(i), f)) {
            this.mBorderRGB.set(i, f);
            invalidateSelf();
        }
    }

    private void setBorderAlpha(int i, float f) {
        if (this.mBorderAlpha == null) {
            this.mBorderAlpha = new Spacing(255.0f);
        }
        if (!FloatUtil.floatsEqual(this.mBorderAlpha.getRaw(i), f)) {
            this.mBorderAlpha.set(i, f);
            invalidateSelf();
        }
    }

    public void setBorderStyle(String str) {
        BorderStyle borderStyle;
        if (str == null) {
            borderStyle = null;
        } else {
            borderStyle = BorderStyle.valueOf(str.toUpperCase(Locale.US));
        }
        if (this.mBorderStyle != borderStyle) {
            this.mBorderStyle = borderStyle;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public void setRadius(float f) {
        if (!FloatUtil.floatsEqual(this.mBorderRadius, f)) {
            this.mBorderRadius = f;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public void setRadius(float f, int i) {
        if (this.mBorderCornerRadii == null) {
            this.mBorderCornerRadii = new float[8];
            Arrays.fill(this.mBorderCornerRadii, 1.0E21f);
        }
        if (!FloatUtil.floatsEqual(this.mBorderCornerRadii[i], f)) {
            this.mBorderCornerRadii[i] = f;
            this.mNeedUpdatePathForBorderRadius = true;
            invalidateSelf();
        }
    }

    public float getFullBorderRadius() {
        return YogaConstants.isUndefined(this.mBorderRadius) ? 0.0f : this.mBorderRadius;
    }

    public float getBorderRadius(BorderRadiusLocation borderRadiusLocation) {
        return getBorderRadiusOrDefaultTo(1.0E21f, borderRadiusLocation);
    }

    public float getBorderRadiusOrDefaultTo(float f, BorderRadiusLocation borderRadiusLocation) {
        if (this.mBorderCornerRadii == null) {
            return f;
        }
        float f2 = this.mBorderCornerRadii[borderRadiusLocation.ordinal()];
        return YogaConstants.isUndefined(f2) ? f : f2;
    }

    public void setColor(int i) {
        this.mColor = i;
        invalidateSelf();
    }

    public int getResolvedLayoutDirection() {
        return this.mLayoutDirection;
    }

    public boolean setResolvedLayoutDirection(int i) {
        if (this.mLayoutDirection == i) {
            return false;
        }
        this.mLayoutDirection = i;
        return onResolvedLayoutDirectionChanged(i);
    }

    @VisibleForTesting
    public int getColor() {
        return this.mColor;
    }

    private void drawRoundedBackgroundWithBorders(Canvas canvas) {
        Canvas canvas2 = canvas;
        updatePath();
        canvas.save();
        int multiplyColorAlpha = ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha);
        if (Color.alpha(multiplyColorAlpha) != 0) {
            r11.mPaint.setColor(multiplyColorAlpha);
            r11.mPaint.setStyle(Style.FILL);
            canvas2.drawPath(r11.mInnerClipPathForBorderRadius, r11.mPaint);
        }
        RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
        if (directionAwareBorderInsets.top > 0.0f || directionAwareBorderInsets.bottom > 0.0f || directionAwareBorderInsets.left > 0.0f || directionAwareBorderInsets.right > 0.0f) {
            float fullBorderWidth = getFullBorderWidth();
            if (directionAwareBorderInsets.top != fullBorderWidth || directionAwareBorderInsets.bottom != fullBorderWidth || directionAwareBorderInsets.left != fullBorderWidth || directionAwareBorderInsets.right != fullBorderWidth) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                float f5;
                float f6;
                float f7;
                float f8;
                r11.mPaint.setStyle(Style.FILL);
                canvas2.clipPath(r11.mOuterClipPathForBorderRadius, Op.INTERSECT);
                canvas2.clipPath(r11.mInnerClipPathForBorderRadius, Op.DIFFERENCE);
                multiplyColorAlpha = 0;
                int borderColor = getBorderColor(0);
                int borderColor2 = getBorderColor(1);
                int borderColor3 = getBorderColor(2);
                int borderColor4 = getBorderColor(3);
                if (VERSION.SDK_INT >= 17) {
                    if (getResolvedLayoutDirection() == 1) {
                        multiplyColorAlpha = 1;
                    }
                    int borderColor5 = getBorderColor(4);
                    int borderColor6 = getBorderColor(5);
                    if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(r11.mContext)) {
                        if (isBorderColorDefined(4)) {
                            borderColor = borderColor5;
                        }
                        if (isBorderColorDefined(5)) {
                            borderColor3 = borderColor6;
                        }
                        i = multiplyColorAlpha != 0 ? borderColor3 : borderColor;
                        if (multiplyColorAlpha == 0) {
                            borderColor = borderColor3;
                        }
                        i2 = borderColor;
                    } else {
                        int i3 = multiplyColorAlpha != 0 ? borderColor6 : borderColor5;
                        if (multiplyColorAlpha == 0) {
                            borderColor5 = borderColor6;
                        }
                        boolean isBorderColorDefined = isBorderColorDefined(4);
                        boolean isBorderColorDefined2 = isBorderColorDefined(5);
                        boolean z = multiplyColorAlpha != 0 ? isBorderColorDefined2 : isBorderColorDefined;
                        if (multiplyColorAlpha == 0) {
                            isBorderColorDefined = isBorderColorDefined2;
                        }
                        if (z) {
                            borderColor = i3;
                        }
                        if (isBorderColorDefined) {
                            i = borderColor;
                            i2 = borderColor5;
                        }
                    }
                    f = r11.mOuterClipTempRectForBorderRadius.left;
                    f2 = r11.mOuterClipTempRectForBorderRadius.right;
                    f3 = r11.mOuterClipTempRectForBorderRadius.top;
                    f4 = r11.mOuterClipTempRectForBorderRadius.bottom;
                    if (directionAwareBorderInsets.left <= 0.0f) {
                        f5 = f4;
                        f6 = f3;
                        f7 = f2;
                        f8 = f;
                        drawQuadrilateral(canvas, i, f, f3, r11.mInnerTopLeftCorner.x, r11.mInnerTopLeftCorner.y, r11.mInnerBottomLeftCorner.x, r11.mInnerBottomLeftCorner.y, f, f5);
                    } else {
                        f5 = f4;
                        f6 = f3;
                        f7 = f2;
                        f8 = f;
                    }
                    if (directionAwareBorderInsets.top > 0.0f) {
                        drawQuadrilateral(canvas, borderColor2, f8, f6, r11.mInnerTopLeftCorner.x, r11.mInnerTopLeftCorner.y, r11.mInnerTopRightCorner.x, r11.mInnerTopRightCorner.y, f7, f6);
                    }
                    if (directionAwareBorderInsets.right > 0.0f) {
                        drawQuadrilateral(canvas, i2, f7, f6, r11.mInnerTopRightCorner.x, r11.mInnerTopRightCorner.y, r11.mInnerBottomRightCorner.x, r11.mInnerBottomRightCorner.y, f7, f5);
                    }
                    if (directionAwareBorderInsets.bottom > 0.0f) {
                        drawQuadrilateral(canvas, borderColor4, f8, f5, r11.mInnerBottomLeftCorner.x, r11.mInnerBottomLeftCorner.y, r11.mInnerBottomRightCorner.x, r11.mInnerBottomRightCorner.y, f7, f5);
                    }
                }
                i = borderColor;
                i2 = borderColor3;
                f = r11.mOuterClipTempRectForBorderRadius.left;
                f2 = r11.mOuterClipTempRectForBorderRadius.right;
                f3 = r11.mOuterClipTempRectForBorderRadius.top;
                f4 = r11.mOuterClipTempRectForBorderRadius.bottom;
                if (directionAwareBorderInsets.left <= 0.0f) {
                    f5 = f4;
                    f6 = f3;
                    f7 = f2;
                    f8 = f;
                } else {
                    f5 = f4;
                    f6 = f3;
                    f7 = f2;
                    f8 = f;
                    drawQuadrilateral(canvas, i, f, f3, r11.mInnerTopLeftCorner.x, r11.mInnerTopLeftCorner.y, r11.mInnerBottomLeftCorner.x, r11.mInnerBottomLeftCorner.y, f, f5);
                }
                if (directionAwareBorderInsets.top > 0.0f) {
                    drawQuadrilateral(canvas, borderColor2, f8, f6, r11.mInnerTopLeftCorner.x, r11.mInnerTopLeftCorner.y, r11.mInnerTopRightCorner.x, r11.mInnerTopRightCorner.y, f7, f6);
                }
                if (directionAwareBorderInsets.right > 0.0f) {
                    drawQuadrilateral(canvas, i2, f7, f6, r11.mInnerTopRightCorner.x, r11.mInnerTopRightCorner.y, r11.mInnerBottomRightCorner.x, r11.mInnerBottomRightCorner.y, f7, f5);
                }
                if (directionAwareBorderInsets.bottom > 0.0f) {
                    drawQuadrilateral(canvas, borderColor4, f8, f5, r11.mInnerBottomLeftCorner.x, r11.mInnerBottomLeftCorner.y, r11.mInnerBottomRightCorner.x, r11.mInnerBottomRightCorner.y, f7, f5);
                }
            } else if (fullBorderWidth > 0.0f) {
                r11.mPaint.setColor(ColorUtil.multiplyColorAlpha(getBorderColor(8), r11.mAlpha));
                r11.mPaint.setStyle(Style.STROKE);
                r11.mPaint.setStrokeWidth(fullBorderWidth);
                canvas2.drawPath(r11.mCenterDrawPath, r11.mPaint);
            }
        }
        canvas.restore();
    }

    private void updatePath() {
        if (this.mNeedUpdatePathForBorderRadius) {
            float borderRadius;
            float borderRadius2;
            float borderRadius3;
            float borderRadius4;
            float f;
            r0.mNeedUpdatePathForBorderRadius = false;
            if (r0.mInnerClipPathForBorderRadius == null) {
                r0.mInnerClipPathForBorderRadius = new Path();
            }
            if (r0.mOuterClipPathForBorderRadius == null) {
                r0.mOuterClipPathForBorderRadius = new Path();
            }
            if (r0.mPathForBorderRadiusOutline == null) {
                r0.mPathForBorderRadiusOutline = new Path();
            }
            if (r0.mCenterDrawPath == null) {
                r0.mCenterDrawPath = new Path();
            }
            if (r0.mInnerClipTempRectForBorderRadius == null) {
                r0.mInnerClipTempRectForBorderRadius = new RectF();
            }
            if (r0.mOuterClipTempRectForBorderRadius == null) {
                r0.mOuterClipTempRectForBorderRadius = new RectF();
            }
            if (r0.mTempRectForBorderRadiusOutline == null) {
                r0.mTempRectForBorderRadiusOutline = new RectF();
            }
            if (r0.mTempRectForCenterDrawPath == null) {
                r0.mTempRectForCenterDrawPath = new RectF();
            }
            r0.mInnerClipPathForBorderRadius.reset();
            r0.mOuterClipPathForBorderRadius.reset();
            r0.mPathForBorderRadiusOutline.reset();
            r0.mCenterDrawPath.reset();
            r0.mInnerClipTempRectForBorderRadius.set(getBounds());
            r0.mOuterClipTempRectForBorderRadius.set(getBounds());
            r0.mTempRectForBorderRadiusOutline.set(getBounds());
            r0.mTempRectForCenterDrawPath.set(getBounds());
            float fullBorderWidth = getFullBorderWidth();
            if (fullBorderWidth > 0.0f) {
                fullBorderWidth *= 0.5f;
                r0.mTempRectForCenterDrawPath.inset(fullBorderWidth, fullBorderWidth);
            }
            RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
            RectF rectF = r0.mInnerClipTempRectForBorderRadius;
            rectF.top += directionAwareBorderInsets.top;
            rectF = r0.mInnerClipTempRectForBorderRadius;
            rectF.bottom -= directionAwareBorderInsets.bottom;
            rectF = r0.mInnerClipTempRectForBorderRadius;
            rectF.left += directionAwareBorderInsets.left;
            rectF = r0.mInnerClipTempRectForBorderRadius;
            rectF.right -= directionAwareBorderInsets.right;
            float fullBorderRadius = getFullBorderRadius();
            float borderRadiusOrDefaultTo = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_LEFT);
            float borderRadiusOrDefaultTo2 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.TOP_RIGHT);
            float borderRadiusOrDefaultTo3 = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_LEFT);
            fullBorderRadius = getBorderRadiusOrDefaultTo(fullBorderRadius, BorderRadiusLocation.BOTTOM_RIGHT);
            if (VERSION.SDK_INT >= 17) {
                Object obj = getResolvedLayoutDirection() == 1 ? 1 : null;
                borderRadius = getBorderRadius(BorderRadiusLocation.TOP_START);
                borderRadius2 = getBorderRadius(BorderRadiusLocation.TOP_END);
                borderRadius3 = getBorderRadius(BorderRadiusLocation.BOTTOM_START);
                borderRadius4 = getBorderRadius(BorderRadiusLocation.BOTTOM_END);
                if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(r0.mContext)) {
                    if (!YogaConstants.isUndefined(borderRadius)) {
                        borderRadiusOrDefaultTo = borderRadius;
                    }
                    if (!YogaConstants.isUndefined(borderRadius2)) {
                        borderRadiusOrDefaultTo2 = borderRadius2;
                    }
                    if (!YogaConstants.isUndefined(borderRadius3)) {
                        borderRadiusOrDefaultTo3 = borderRadius3;
                    }
                    if (!YogaConstants.isUndefined(borderRadius4)) {
                        fullBorderRadius = borderRadius4;
                    }
                    borderRadius = obj != null ? borderRadiusOrDefaultTo2 : borderRadiusOrDefaultTo;
                    if (obj != null) {
                        borderRadiusOrDefaultTo2 = borderRadiusOrDefaultTo;
                    }
                    borderRadiusOrDefaultTo = obj != null ? fullBorderRadius : borderRadiusOrDefaultTo3;
                    if (obj != null) {
                        fullBorderRadius = borderRadiusOrDefaultTo3;
                    }
                    borderRadiusOrDefaultTo3 = borderRadiusOrDefaultTo;
                    borderRadiusOrDefaultTo = borderRadius;
                } else {
                    f = obj != null ? borderRadius2 : borderRadius;
                    if (obj == null) {
                        borderRadius = borderRadius2;
                    }
                    borderRadius2 = obj != null ? borderRadius4 : borderRadius3;
                    if (obj == null) {
                        borderRadius3 = borderRadius4;
                    }
                    if (!YogaConstants.isUndefined(f)) {
                        borderRadiusOrDefaultTo = f;
                    }
                    if (!YogaConstants.isUndefined(borderRadius)) {
                        borderRadiusOrDefaultTo2 = borderRadius;
                    }
                    if (!YogaConstants.isUndefined(borderRadius2)) {
                        borderRadiusOrDefaultTo3 = borderRadius2;
                    }
                    if (!YogaConstants.isUndefined(borderRadius3)) {
                        fullBorderRadius = borderRadius3;
                    }
                }
            }
            float f2 = borderRadiusOrDefaultTo3;
            float f3 = fullBorderRadius;
            r0.mInnerClipPathForBorderRadius.addRoundRect(r0.mInnerClipTempRectForBorderRadius, new float[]{Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.left, 0.0f), Math.max(borderRadiusOrDefaultTo - directionAwareBorderInsets.top, 0.0f), Math.max(borderRadiusOrDefaultTo2 - directionAwareBorderInsets.right, 0.0f), Math.max(borderRadiusOrDefaultTo2 - directionAwareBorderInsets.top, 0.0f), Math.max(fullBorderRadius - directionAwareBorderInsets.right, 0.0f), Math.max(fullBorderRadius - directionAwareBorderInsets.bottom, 0.0f), Math.max(borderRadiusOrDefaultTo3 - directionAwareBorderInsets.left, 0.0f), Math.max(borderRadiusOrDefaultTo3 - directionAwareBorderInsets.bottom, 0.0f)}, Direction.CW);
            r0.mOuterClipPathForBorderRadius.addRoundRect(r0.mOuterClipTempRectForBorderRadius, new float[]{borderRadiusOrDefaultTo, borderRadiusOrDefaultTo, borderRadiusOrDefaultTo2, borderRadiusOrDefaultTo2, f3, f3, f2, f2}, Direction.CW);
            float f4 = r0.mBorderWidth != null ? r0.mBorderWidth.get(8) / 2.0f : 0.0f;
            Path path = r0.mPathForBorderRadiusOutline;
            rectF = r0.mTempRectForBorderRadiusOutline;
            r10 = new float[8];
            borderRadiusOrDefaultTo += f4;
            r10[0] = borderRadiusOrDefaultTo;
            r10[1] = borderRadiusOrDefaultTo;
            borderRadiusOrDefaultTo2 += f4;
            r10[2] = borderRadiusOrDefaultTo2;
            r10[3] = borderRadiusOrDefaultTo2;
            borderRadiusOrDefaultTo = f3 + f4;
            r10[4] = borderRadiusOrDefaultTo;
            r10[5] = borderRadiusOrDefaultTo;
            borderRadiusOrDefaultTo = f2 + f4;
            r10[6] = borderRadiusOrDefaultTo;
            r10[7] = borderRadiusOrDefaultTo;
            path.addRoundRect(rectF, r10, Direction.CW);
            r0.mCenterDrawPath.addRoundRect(r0.mTempRectForCenterDrawPath, new float[]{r8 + f4, borderRadius + f4, borderRadius2 + f4, borderRadius3 + f4, borderRadius4 + f4, f + f4, r15 + f4, fullBorderWidth + f4}, Direction.CW);
            if (r0.mInnerTopLeftCorner == null) {
                r0.mInnerTopLeftCorner = new PointF();
            }
            r0.mInnerTopLeftCorner.x = r0.mInnerClipTempRectForBorderRadius.left;
            r0.mInnerTopLeftCorner.y = r0.mInnerClipTempRectForBorderRadius.top;
            getEllipseIntersectionWithLine((double) r0.mInnerClipTempRectForBorderRadius.left, (double) r0.mInnerClipTempRectForBorderRadius.top, (double) (r0.mInnerClipTempRectForBorderRadius.left + (r8 * 2.0f)), (double) (r0.mInnerClipTempRectForBorderRadius.top + (borderRadius * 2.0f)), (double) r0.mOuterClipTempRectForBorderRadius.left, (double) r0.mOuterClipTempRectForBorderRadius.top, (double) r0.mInnerClipTempRectForBorderRadius.left, (double) r0.mInnerClipTempRectForBorderRadius.top, r0.mInnerTopLeftCorner);
            if (r0.mInnerBottomLeftCorner == null) {
                r0.mInnerBottomLeftCorner = new PointF();
            }
            r0.mInnerBottomLeftCorner.x = r0.mInnerClipTempRectForBorderRadius.left;
            r0.mInnerBottomLeftCorner.y = r0.mInnerClipTempRectForBorderRadius.bottom;
            getEllipseIntersectionWithLine((double) r0.mInnerClipTempRectForBorderRadius.left, (double) (r0.mInnerClipTempRectForBorderRadius.bottom - (fullBorderWidth * 2.0f)), (double) (r0.mInnerClipTempRectForBorderRadius.left + (r15 * 2.0f)), (double) r0.mInnerClipTempRectForBorderRadius.bottom, (double) r0.mOuterClipTempRectForBorderRadius.left, (double) r0.mOuterClipTempRectForBorderRadius.bottom, (double) r0.mInnerClipTempRectForBorderRadius.left, (double) r0.mInnerClipTempRectForBorderRadius.bottom, r0.mInnerBottomLeftCorner);
            if (r0.mInnerTopRightCorner == null) {
                r0.mInnerTopRightCorner = new PointF();
            }
            r0.mInnerTopRightCorner.x = r0.mInnerClipTempRectForBorderRadius.right;
            r0.mInnerTopRightCorner.y = r0.mInnerClipTempRectForBorderRadius.top;
            getEllipseIntersectionWithLine((double) (r0.mInnerClipTempRectForBorderRadius.right - (borderRadius2 * 2.0f)), (double) r0.mInnerClipTempRectForBorderRadius.top, (double) r0.mInnerClipTempRectForBorderRadius.right, (double) (r0.mInnerClipTempRectForBorderRadius.top + (borderRadius3 * 2.0f)), (double) r0.mOuterClipTempRectForBorderRadius.right, (double) r0.mOuterClipTempRectForBorderRadius.top, (double) r0.mInnerClipTempRectForBorderRadius.right, (double) r0.mInnerClipTempRectForBorderRadius.top, r0.mInnerTopRightCorner);
            if (r0.mInnerBottomRightCorner == null) {
                r0.mInnerBottomRightCorner = new PointF();
            }
            r0.mInnerBottomRightCorner.x = r0.mInnerClipTempRectForBorderRadius.right;
            r0.mInnerBottomRightCorner.y = r0.mInnerClipTempRectForBorderRadius.bottom;
            getEllipseIntersectionWithLine((double) (r0.mInnerClipTempRectForBorderRadius.right - (borderRadius4 * 2.0f)), (double) (r0.mInnerClipTempRectForBorderRadius.bottom - (f * 2.0f)), (double) r0.mInnerClipTempRectForBorderRadius.right, (double) r0.mInnerClipTempRectForBorderRadius.bottom, (double) r0.mOuterClipTempRectForBorderRadius.right, (double) r0.mOuterClipTempRectForBorderRadius.bottom, (double) r0.mInnerClipTempRectForBorderRadius.right, (double) r0.mInnerClipTempRectForBorderRadius.bottom, r0.mInnerBottomRightCorner);
        }
    }

    private static void getEllipseIntersectionWithLine(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, PointF pointF) {
        PointF pointF2 = pointF;
        double d9 = (d + d3) / 2.0d;
        double d10 = (d2 + d4) / 2.0d;
        double d11 = d5 - d9;
        double d12 = d6 - d10;
        double d13 = d8 - d10;
        double abs = Math.abs(d3 - d) / 2.0d;
        double abs2 = Math.abs(d4 - d2) / 2.0d;
        d13 = (d13 - d12) / ((d7 - d9) - d11);
        d12 -= d11 * d13;
        abs2 *= abs2;
        double d14 = abs * abs;
        double d15 = ((d14 * d13) * d13) + abs2;
        abs = (((abs * 2.0d) * abs) * d12) * d13;
        abs2 = (-(d14 * ((d12 * d12) - abs2))) / d15;
        d15 *= 2.0d;
        abs = ((-abs) / d15) - Math.sqrt(abs2 + Math.pow(abs / d15, 2.0d));
        abs += d9;
        abs2 = ((d13 * abs) + d12) + d10;
        if (!Double.isNaN(abs) && !Double.isNaN(abs2)) {
            pointF2.x = (float) abs;
            pointF2.y = (float) abs2;
        }
    }

    public float getBorderWidthOrDefaultTo(float f, int i) {
        if (this.mBorderWidth == null) {
            return f;
        }
        float raw = this.mBorderWidth.getRaw(i);
        return YogaConstants.isUndefined(raw) ? f : raw;
    }

    private void updatePathEffect() {
        this.mPathEffectForBorderStyle = this.mBorderStyle != null ? this.mBorderStyle.getPathEffect(getFullBorderWidth()) : null;
        this.mPaint.setPathEffect(this.mPathEffectForBorderStyle);
    }

    public float getFullBorderWidth() {
        return (this.mBorderWidth == null || YogaConstants.isUndefined(this.mBorderWidth.getRaw(8))) ? 0.0f : this.mBorderWidth.getRaw(8);
    }

    private void drawRectangularBackgroundWithBorders(Canvas canvas) {
        int borderColor;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int width;
        int height;
        float f;
        int i6;
        float f2;
        int multiplyColorAlpha = ColorUtil.multiplyColorAlpha(this.mColor, this.mAlpha);
        if (Color.alpha(multiplyColorAlpha) != 0) {
            r11.mPaint.setColor(multiplyColorAlpha);
            r11.mPaint.setStyle(Style.FILL);
            canvas.drawRect(getBounds(), r11.mPaint);
        } else {
            Canvas canvas2 = canvas;
        }
        RectF directionAwareBorderInsets = getDirectionAwareBorderInsets();
        int round = Math.round(directionAwareBorderInsets.left);
        int round2 = Math.round(directionAwareBorderInsets.top);
        int round3 = Math.round(directionAwareBorderInsets.right);
        int round4 = Math.round(directionAwareBorderInsets.bottom);
        if (round <= 0 && round3 <= 0 && round2 <= 0) {
            if (round4 > 0) {
            }
            ReactViewBackgroundDrawable reactViewBackgroundDrawable = r11;
        }
        Rect bounds = getBounds();
        int borderColor2 = getBorderColor(0);
        int borderColor3 = getBorderColor(1);
        int borderColor4 = getBorderColor(2);
        int borderColor5 = getBorderColor(3);
        if (VERSION.SDK_INT >= 17) {
            Object obj = getResolvedLayoutDirection() == 1 ? 1 : null;
            int borderColor6 = getBorderColor(4);
            borderColor = getBorderColor(5);
            if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(r11.mContext)) {
                if (isBorderColorDefined(4)) {
                    borderColor2 = borderColor6;
                }
                if (isBorderColorDefined(5)) {
                    borderColor4 = borderColor;
                }
                int i7 = obj != null ? borderColor4 : borderColor2;
                if (obj == null) {
                    borderColor2 = borderColor4;
                }
                i = borderColor2;
                i2 = i7;
            } else {
                i3 = obj != null ? borderColor : borderColor6;
                if (obj == null) {
                    borderColor6 = borderColor;
                }
                boolean isBorderColorDefined = isBorderColorDefined(4);
                boolean isBorderColorDefined2 = isBorderColorDefined(5);
                boolean z = obj != null ? isBorderColorDefined2 : isBorderColorDefined;
                if (obj == null) {
                    isBorderColorDefined = isBorderColorDefined2;
                }
                if (z) {
                    borderColor2 = i3;
                }
                if (isBorderColorDefined) {
                    i2 = borderColor2;
                    i = borderColor6;
                }
            }
            i3 = bounds.left;
            i4 = bounds.top;
            i5 = i3;
            borderColor2 = fastBorderCompatibleColorOrZero(round, round2, round3, round4, i2, borderColor3, i, borderColor5);
            if (borderColor2 == 0) {
                if (Color.alpha(borderColor2) != 0) {
                    borderColor = bounds.right;
                    multiplyColorAlpha = bounds.bottom;
                    r11.mPaint.setColor(borderColor2);
                    if (round > 0) {
                        canvas.drawRect((float) i5, (float) i4, (float) (i5 + round), (float) (multiplyColorAlpha - round4), r11.mPaint);
                    }
                    if (round2 > 0) {
                        canvas.drawRect((float) (i5 + round), (float) i4, (float) borderColor, (float) (i4 + round2), r11.mPaint);
                    }
                    if (round3 > 0) {
                        canvas.drawRect((float) (borderColor - round3), (float) (i4 + round2), (float) borderColor, (float) multiplyColorAlpha, r11.mPaint);
                    }
                    if (round4 > 0) {
                        canvas.drawRect((float) i5, (float) (multiplyColorAlpha - round4), (float) (borderColor - round3), (float) multiplyColorAlpha, r11.mPaint);
                    }
                }
                ReactViewBackgroundDrawable reactViewBackgroundDrawable2 = r11;
            }
            r11.mPaint.setAntiAlias(false);
            width = bounds.width();
            height = bounds.height();
            if (round <= 0) {
                f = (float) i5;
                float f3 = (float) (i5 + round);
                borderColor = i4 + height;
                i6 = i4;
                drawQuadrilateral(canvas, i2, f, (float) i4, f3, (float) (i4 + round2), f3, (float) (borderColor - round4), f, (float) borderColor);
            } else {
                i6 = i4;
            }
            if (round2 > 0) {
                f2 = (float) i6;
                float f4 = (float) (i6 + round2);
                i3 = i5 + width;
                drawQuadrilateral(canvas, borderColor3, (float) i5, f2, (float) (i5 + round), f4, (float) (i3 - round3), f4, (float) i3, f2);
            }
            if (round3 > 0) {
                i3 = i5 + width;
                float f5 = (float) i3;
                borderColor = i6 + height;
                f = (float) (i3 - round3);
                drawQuadrilateral(canvas, i, f5, (float) i6, f5, (float) borderColor, f, (float) (borderColor - round4), f, (float) (i6 + round2));
            }
            if (round4 <= 0) {
                borderColor = i6 + height;
                float f6 = (float) borderColor;
                i3 = i5 + width;
                f2 = (float) (borderColor - round4);
                drawQuadrilateral(canvas, borderColor5, (float) i5, f6, (float) i3, f6, (float) (i3 - round3), f2, (float) (i5 + round), f2);
            } else {
                reactViewBackgroundDrawable2 = this;
            }
            reactViewBackgroundDrawable2.mPaint.setAntiAlias(true);
            return;
        }
        i2 = borderColor2;
        i = borderColor4;
        i3 = bounds.left;
        i4 = bounds.top;
        i5 = i3;
        borderColor2 = fastBorderCompatibleColorOrZero(round, round2, round3, round4, i2, borderColor3, i, borderColor5);
        if (borderColor2 == 0) {
            r11.mPaint.setAntiAlias(false);
            width = bounds.width();
            height = bounds.height();
            if (round <= 0) {
                i6 = i4;
            } else {
                f = (float) i5;
                float f32 = (float) (i5 + round);
                borderColor = i4 + height;
                i6 = i4;
                drawQuadrilateral(canvas, i2, f, (float) i4, f32, (float) (i4 + round2), f32, (float) (borderColor - round4), f, (float) borderColor);
            }
            if (round2 > 0) {
                f2 = (float) i6;
                float f42 = (float) (i6 + round2);
                i3 = i5 + width;
                drawQuadrilateral(canvas, borderColor3, (float) i5, f2, (float) (i5 + round), f42, (float) (i3 - round3), f42, (float) i3, f2);
            }
            if (round3 > 0) {
                i3 = i5 + width;
                float f52 = (float) i3;
                borderColor = i6 + height;
                f = (float) (i3 - round3);
                drawQuadrilateral(canvas, i, f52, (float) i6, f52, (float) borderColor, f, (float) (borderColor - round4), f, (float) (i6 + round2));
            }
            if (round4 <= 0) {
                reactViewBackgroundDrawable2 = this;
            } else {
                borderColor = i6 + height;
                float f62 = (float) borderColor;
                i3 = i5 + width;
                f2 = (float) (borderColor - round4);
                drawQuadrilateral(canvas, borderColor5, (float) i5, f62, (float) i3, f62, (float) (i3 - round3), f2, (float) (i5 + round), f2);
            }
            reactViewBackgroundDrawable2.mPaint.setAntiAlias(true);
            return;
        }
        if (Color.alpha(borderColor2) != 0) {
            borderColor = bounds.right;
            multiplyColorAlpha = bounds.bottom;
            r11.mPaint.setColor(borderColor2);
            if (round > 0) {
                canvas.drawRect((float) i5, (float) i4, (float) (i5 + round), (float) (multiplyColorAlpha - round4), r11.mPaint);
            }
            if (round2 > 0) {
                canvas.drawRect((float) (i5 + round), (float) i4, (float) borderColor, (float) (i4 + round2), r11.mPaint);
            }
            if (round3 > 0) {
                canvas.drawRect((float) (borderColor - round3), (float) (i4 + round2), (float) borderColor, (float) multiplyColorAlpha, r11.mPaint);
            }
            if (round4 > 0) {
                canvas.drawRect((float) i5, (float) (multiplyColorAlpha - round4), (float) (borderColor - round3), (float) multiplyColorAlpha, r11.mPaint);
            }
        }
        ReactViewBackgroundDrawable reactViewBackgroundDrawable22 = r11;
    }

    private void drawQuadrilateral(Canvas canvas, int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (i != 0) {
            if (this.mPathForBorder == null) {
                this.mPathForBorder = new Path();
            }
            this.mPaint.setColor(i);
            this.mPathForBorder.reset();
            this.mPathForBorder.moveTo(f, f2);
            this.mPathForBorder.lineTo(f3, f4);
            this.mPathForBorder.lineTo(f5, f6);
            this.mPathForBorder.lineTo(f7, f8);
            this.mPathForBorder.lineTo(f, f2);
            canvas.drawPath(this.mPathForBorder, this.mPaint);
        }
    }

    private int getBorderWidth(int i) {
        if (this.mBorderWidth == null) {
            return 0;
        }
        float f = this.mBorderWidth.get(i);
        return YogaConstants.isUndefined(f) ? -1 : Math.round(f);
    }

    private boolean isBorderColorDefined(int i) {
        float f = 1.0E21f;
        float f2 = this.mBorderRGB != null ? this.mBorderRGB.get(i) : 1.0E21f;
        if (this.mBorderAlpha != null) {
            f = this.mBorderAlpha.get(i);
        }
        return YogaConstants.isUndefined(f2) == 0 && YogaConstants.isUndefined(f) == 0;
    }

    private int getBorderColor(int i) {
        return colorFromAlphaAndRGBComponents(this.mBorderAlpha != null ? this.mBorderAlpha.get(i) : 1132396544, this.mBorderRGB != null ? this.mBorderRGB.get(i) : 0.0f);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.RectF getDirectionAwareBorderInsets() {
        /*
        r9 = this;
        r0 = 0;
        r1 = 8;
        r0 = r9.getBorderWidthOrDefaultTo(r0, r1);
        r1 = 1;
        r2 = r9.getBorderWidthOrDefaultTo(r0, r1);
        r3 = 3;
        r3 = r9.getBorderWidthOrDefaultTo(r0, r3);
        r4 = 0;
        r5 = r9.getBorderWidthOrDefaultTo(r0, r4);
        r6 = 2;
        r0 = r9.getBorderWidthOrDefaultTo(r0, r6);
        r6 = android.os.Build.VERSION.SDK_INT;
        r7 = 17;
        if (r6 < r7) goto L_0x0075;
    L_0x0021:
        r6 = r9.mBorderWidth;
        if (r6 == 0) goto L_0x0075;
    L_0x0025:
        r6 = r9.getResolvedLayoutDirection();
        if (r6 != r1) goto L_0x002c;
    L_0x002b:
        goto L_0x002d;
    L_0x002c:
        r1 = 0;
    L_0x002d:
        r4 = r9.mBorderWidth;
        r6 = 4;
        r4 = r4.getRaw(r6);
        r6 = r9.mBorderWidth;
        r7 = 5;
        r6 = r6.getRaw(r7);
        r7 = com.facebook.react.modules.i18nmanager.I18nUtil.getInstance();
        r8 = r9.mContext;
        r7 = r7.doLeftAndRightSwapInRTL(r8);
        if (r7 == 0) goto L_0x005e;
    L_0x0047:
        r7 = com.facebook.yoga.YogaConstants.isUndefined(r4);
        if (r7 == 0) goto L_0x004e;
    L_0x004d:
        r4 = r5;
    L_0x004e:
        r5 = com.facebook.yoga.YogaConstants.isUndefined(r6);
        if (r5 == 0) goto L_0x0055;
    L_0x0054:
        goto L_0x0056;
    L_0x0055:
        r0 = r6;
    L_0x0056:
        if (r1 == 0) goto L_0x005a;
    L_0x0058:
        r5 = r0;
        goto L_0x005b;
    L_0x005a:
        r5 = r4;
    L_0x005b:
        if (r1 == 0) goto L_0x0075;
    L_0x005d:
        goto L_0x0074;
    L_0x005e:
        if (r1 == 0) goto L_0x0062;
    L_0x0060:
        r7 = r6;
        goto L_0x0063;
    L_0x0062:
        r7 = r4;
    L_0x0063:
        if (r1 == 0) goto L_0x0066;
    L_0x0065:
        goto L_0x0067;
    L_0x0066:
        r4 = r6;
    L_0x0067:
        r1 = com.facebook.yoga.YogaConstants.isUndefined(r7);
        if (r1 != 0) goto L_0x006e;
    L_0x006d:
        r5 = r7;
    L_0x006e:
        r1 = com.facebook.yoga.YogaConstants.isUndefined(r4);
        if (r1 != 0) goto L_0x0075;
    L_0x0074:
        r0 = r4;
    L_0x0075:
        r1 = new android.graphics.RectF;
        r1.<init>(r5, r2, r0, r3);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.view.ReactViewBackgroundDrawable.getDirectionAwareBorderInsets():android.graphics.RectF");
    }
}
