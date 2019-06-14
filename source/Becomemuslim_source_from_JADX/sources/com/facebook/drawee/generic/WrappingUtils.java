package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.RoundedNinePatchDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.generic.RoundingParams.RoundingMethod;

public class WrappingUtils {
    private static final String TAG = "WrappingUtils";
    private static final Drawable sEmptyDrawable = new ColorDrawable(0);

    static Drawable maybeWrapWithScaleType(Drawable drawable, ScaleType scaleType) {
        return maybeWrapWithScaleType(drawable, scaleType, null);
    }

    static Drawable maybeWrapWithScaleType(Drawable drawable, ScaleType scaleType, PointF pointF) {
        if (drawable != null) {
            if (scaleType != null) {
                Drawable scaleTypeDrawable = new ScaleTypeDrawable(drawable, scaleType);
                if (pointF != null) {
                    scaleTypeDrawable.setFocusPoint(pointF);
                }
                return scaleTypeDrawable;
            }
        }
        return drawable;
    }

    static Drawable maybeWrapWithMatrix(Drawable drawable, Matrix matrix) {
        if (drawable != null) {
            if (matrix != null) {
                return new MatrixDrawable(drawable, matrix);
            }
        }
        return drawable;
    }

    static ScaleTypeDrawable wrapChildWithScaleType(DrawableParent drawableParent, ScaleType scaleType) {
        scaleType = maybeWrapWithScaleType(drawableParent.setDrawable(sEmptyDrawable), scaleType);
        drawableParent.setDrawable(scaleType);
        Preconditions.checkNotNull(scaleType, "Parent has no child drawable!");
        return (ScaleTypeDrawable) scaleType;
    }

    static void updateOverlayColorRounding(DrawableParent drawableParent, RoundingParams roundingParams) {
        Drawable drawable = drawableParent.getDrawable();
        if (roundingParams == null || roundingParams.getRoundingMethod() != RoundingMethod.OVERLAY_COLOR) {
            if ((drawable instanceof RoundedCornersDrawable) != null) {
                drawableParent.setDrawable(((RoundedCornersDrawable) drawable).setCurrent(sEmptyDrawable));
                sEmptyDrawable.setCallback(null);
            }
        } else if (drawable instanceof RoundedCornersDrawable) {
            RoundedCornersDrawable roundedCornersDrawable = (RoundedCornersDrawable) drawable;
            applyRoundingParams(roundedCornersDrawable, roundingParams);
            roundedCornersDrawable.setOverlayColor(roundingParams.getOverlayColor());
        } else {
            drawableParent.setDrawable(maybeWrapWithRoundedOverlayColor(drawableParent.setDrawable(sEmptyDrawable), roundingParams));
        }
    }

    static void updateLeafRounding(DrawableParent drawableParent, RoundingParams roundingParams, Resources resources) {
        drawableParent = findDrawableParentForLeaf(drawableParent);
        Drawable drawable = drawableParent.getDrawable();
        if (roundingParams == null || roundingParams.getRoundingMethod() != RoundingMethod.BITMAP_ONLY) {
            if ((drawable instanceof Rounded) != null) {
                resetRoundingParams((Rounded) drawable);
            }
        } else if (drawable instanceof Rounded) {
            applyRoundingParams((Rounded) drawable, roundingParams);
        } else if (drawable != null) {
            drawableParent.setDrawable(sEmptyDrawable);
            drawableParent.setDrawable(applyLeafRounding(drawable, roundingParams, resources));
        }
    }

    static Drawable maybeWrapWithRoundedOverlayColor(Drawable drawable, RoundingParams roundingParams) {
        if (!(drawable == null || roundingParams == null)) {
            if (roundingParams.getRoundingMethod() == RoundingMethod.OVERLAY_COLOR) {
                Drawable roundedCornersDrawable = new RoundedCornersDrawable(drawable);
                applyRoundingParams(roundedCornersDrawable, roundingParams);
                roundedCornersDrawable.setOverlayColor(roundingParams.getOverlayColor());
                return roundedCornersDrawable;
            }
        }
        return drawable;
    }

    static Drawable maybeApplyLeafRounding(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        if (!(drawable == null || roundingParams == null)) {
            if (roundingParams.getRoundingMethod() == RoundingMethod.BITMAP_ONLY) {
                if (!(drawable instanceof ForwardingDrawable)) {
                    return applyLeafRounding(drawable, roundingParams, resources);
                }
                DrawableParent findDrawableParentForLeaf = findDrawableParentForLeaf((ForwardingDrawable) drawable);
                findDrawableParentForLeaf.setDrawable(applyLeafRounding(findDrawableParentForLeaf.setDrawable(sEmptyDrawable), roundingParams, resources));
                return drawable;
            }
        }
        return drawable;
    }

    private static Drawable applyLeafRounding(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Object roundedBitmapDrawable = new RoundedBitmapDrawable(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
            applyRoundingParams(roundedBitmapDrawable, roundingParams);
            return roundedBitmapDrawable;
        } else if ((drawable instanceof NinePatchDrawable) != null) {
            resources = new RoundedNinePatchDrawable((NinePatchDrawable) drawable);
            applyRoundingParams(resources, roundingParams);
            return resources;
        } else if ((drawable instanceof ColorDrawable) == null || VERSION.SDK_INT < 11) {
            FLog.m5716w(TAG, "Don't know how to round that drawable: %s", drawable);
            return drawable;
        } else {
            drawable = RoundedColorDrawable.fromColorDrawable((ColorDrawable) drawable);
            applyRoundingParams(drawable, roundingParams);
            return drawable;
        }
    }

    static void applyRoundingParams(Rounded rounded, RoundingParams roundingParams) {
        rounded.setCircle(roundingParams.getRoundAsCircle());
        rounded.setRadii(roundingParams.getCornersRadii());
        rounded.setBorder(roundingParams.getBorderColor(), roundingParams.getBorderWidth());
        rounded.setPadding(roundingParams.getPadding());
        rounded.setScaleDownInsideBorders(roundingParams.getScaleDownInsideBorders());
    }

    static void resetRoundingParams(Rounded rounded) {
        rounded.setCircle(false);
        rounded.setRadius(0.0f);
        rounded.setBorder(0, 0.0f);
        rounded.setPadding(0.0f);
        rounded.setScaleDownInsideBorders(false);
    }

    static DrawableParent findDrawableParentForLeaf(DrawableParent drawableParent) {
        while (true) {
            Drawable drawable = r2.getDrawable();
            if (drawable == r2) {
                break;
            } else if (!(drawable instanceof DrawableParent)) {
                break;
            } else {
                drawableParent = (DrawableParent) drawable;
            }
        }
        return r2;
    }
}
