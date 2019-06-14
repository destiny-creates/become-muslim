package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class ScalingUtils {

    public interface ScaleType {
        public static final ScaleType CENTER = ScaleTypeCenter.INSTANCE;
        public static final ScaleType CENTER_CROP = ScaleTypeCenterCrop.INSTANCE;
        public static final ScaleType CENTER_INSIDE = ScaleTypeCenterInside.INSTANCE;
        public static final ScaleType FIT_BOTTOM_START = ScaleTypeFitBottomStart.INSTANCE;
        public static final ScaleType FIT_CENTER = ScaleTypeFitCenter.INSTANCE;
        public static final ScaleType FIT_END = ScaleTypeFitEnd.INSTANCE;
        public static final ScaleType FIT_START = ScaleTypeFitStart.INSTANCE;
        public static final ScaleType FIT_XY = ScaleTypeFitXY.INSTANCE;
        public static final ScaleType FOCUS_CROP = ScaleTypeFocusCrop.INSTANCE;

        Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2);
    }

    public interface StatefulScaleType {
        Object getState();
    }

    public static abstract class AbstractScaleType implements ScaleType {
        public abstract void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4);

        public Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
            int i3 = i;
            int i4 = i2;
            getTransformImpl(matrix, rect, i3, i4, f, f2, ((float) rect.width()) / ((float) i3), ((float) rect.height()) / ((float) i4));
            return matrix;
        }
    }

    public static class InterpolatingScaleType implements ScaleType, StatefulScaleType {
        private final Rect mBoundsFrom;
        private final Rect mBoundsTo;
        private final PointF mFocusPointFrom;
        private final PointF mFocusPointTo;
        private float mInterpolatingValue;
        private final float[] mMatrixValuesFrom;
        private final float[] mMatrixValuesInterpolated;
        private final float[] mMatrixValuesTo;
        private final ScaleType mScaleTypeFrom;
        private final ScaleType mScaleTypeTo;

        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2, Rect rect, Rect rect2, PointF pointF, PointF pointF2) {
            this.mMatrixValuesFrom = new float[9];
            this.mMatrixValuesTo = new float[9];
            this.mMatrixValuesInterpolated = new float[9];
            this.mScaleTypeFrom = scaleType;
            this.mScaleTypeTo = scaleType2;
            this.mBoundsFrom = rect;
            this.mBoundsTo = rect2;
            this.mFocusPointFrom = pointF;
            this.mFocusPointTo = pointF2;
        }

        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2, Rect rect, Rect rect2) {
            this(scaleType, scaleType2, rect, rect2, null, null);
        }

        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2) {
            this(scaleType, scaleType2, null, null);
        }

        public ScaleType getScaleTypeFrom() {
            return this.mScaleTypeFrom;
        }

        public ScaleType getScaleTypeTo() {
            return this.mScaleTypeTo;
        }

        public Rect getBoundsFrom() {
            return this.mBoundsFrom;
        }

        public Rect getBoundsTo() {
            return this.mBoundsTo;
        }

        public PointF getFocusPointFrom() {
            return this.mFocusPointFrom;
        }

        public PointF getFocusPointTo() {
            return this.mFocusPointTo;
        }

        public void setValue(float f) {
            this.mInterpolatingValue = f;
        }

        public float getValue() {
            return this.mInterpolatingValue;
        }

        public Object getState() {
            return Float.valueOf(this.mInterpolatingValue);
        }

        public Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
            Matrix matrix2 = matrix;
            Rect rect2 = this.mBoundsFrom != null ? r0.mBoundsFrom : rect;
            Rect rect3 = r0.mBoundsTo != null ? r0.mBoundsTo : rect;
            r0.mScaleTypeFrom.getTransform(matrix, rect2, i, i2, r0.mFocusPointFrom == null ? f : r0.mFocusPointFrom.x, r0.mFocusPointFrom == null ? f2 : r0.mFocusPointFrom.y);
            matrix.getValues(r0.mMatrixValuesFrom);
            r0.mScaleTypeTo.getTransform(matrix, rect3, i, i2, r0.mFocusPointTo == null ? f : r0.mFocusPointTo.x, r0.mFocusPointTo == null ? f2 : r0.mFocusPointTo.y);
            matrix.getValues(r0.mMatrixValuesTo);
            for (int i3 = 0; i3 < 9; i3++) {
                r0.mMatrixValuesInterpolated[i3] = (r0.mMatrixValuesFrom[i3] * (1.0f - r0.mInterpolatingValue)) + (r0.mMatrixValuesTo[i3] * r0.mInterpolatingValue);
            }
            matrix.setValues(r0.mMatrixValuesInterpolated);
            return matrix2;
        }

        public String toString() {
            return String.format("InterpolatingScaleType(%s (%s) -> %s (%s))", new Object[]{String.valueOf(this.mScaleTypeFrom), String.valueOf(this.mFocusPointFrom), String.valueOf(this.mScaleTypeTo), String.valueOf(this.mFocusPointTo)});
        }
    }

    private static class ScaleTypeCenter extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeCenter();

        public String toString() {
            return "center";
        }

        private ScaleTypeCenter() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            matrix.setTranslate((float) ((int) ((((float) rect.left) + (((float) (rect.width() - i)) * 1056964608)) + 0.5f)), (float) ((int) ((((float) rect.top) + (((float) (rect.height() - i2)) * 1056964608)) + 1056964608)));
        }
    }

    private static class ScaleTypeCenterCrop extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeCenterCrop();

        public String toString() {
            return "center_crop";
        }

        private ScaleTypeCenterCrop() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            if (f4 > f3) {
                i2 = ((float) rect.left) + ((((float) rect.width()) - (((float) i) * f4)) * 0.5f);
                rect = (float) rect.top;
                i = i2;
                f3 = f4;
            } else {
                i = (float) rect.left;
                rect = ((((float) rect.height()) - (((float) i2) * f3)) * 1056964608) + ((float) rect.top);
            }
            matrix.setScale(f3, f3);
            matrix.postTranslate((float) ((int) (i + 1056964608)), (float) ((int) (rect + 1056964608)));
        }
    }

    private static class ScaleTypeCenterInside extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeCenterInside();

        public String toString() {
            return "center_inside";
        }

        private ScaleTypeCenterInside() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            f = Math.min(Math.min(f3, f4), 1.0f);
            f2 = ((float) rect.left) + ((((float) rect.width()) - (((float) i) * f)) * 0.5f);
            f3 = ((float) rect.top) + ((((float) rect.height()) - (((float) i2) * f)) * 1056964608);
            matrix.setScale(f, f);
            matrix.postTranslate((float) ((int) (f2 + 0.5f)), (float) ((int) (f3 + 0.5f)));
        }
    }

    private static class ScaleTypeFitBottomStart extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitBottomStart();

        public String toString() {
            return "fit_bottom_start";
        }

        private ScaleTypeFitBottomStart() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            i = Math.min(f3, f4);
            f = (float) rect.left;
            f2 = ((float) rect.top) + (((float) rect.height()) - (((float) i2) * i));
            matrix.setScale(i, i);
            matrix.postTranslate((float) ((int) (f + 0.5f)), (float) ((int) (f2 + 0.5f)));
        }
    }

    private static class ScaleTypeFitCenter extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitCenter();

        public String toString() {
            return "fit_center";
        }

        private ScaleTypeFitCenter() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            f = Math.min(f3, f4);
            f2 = ((float) rect.left) + ((((float) rect.width()) - (((float) i) * f)) * 0.5f);
            f3 = ((float) rect.top) + ((((float) rect.height()) - (((float) i2) * f)) * 1056964608);
            matrix.setScale(f, f);
            matrix.postTranslate((float) ((int) (f2 + 0.5f)), (float) ((int) (f3 + 0.5f)));
        }
    }

    private static class ScaleTypeFitEnd extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitEnd();

        public String toString() {
            return "fit_end";
        }

        private ScaleTypeFitEnd() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            f = Math.min(f3, f4);
            f2 = ((float) rect.left) + (((float) rect.width()) - (((float) i) * f));
            i = ((float) rect.top) + (((float) rect.height()) - (((float) i2) * f));
            matrix.setScale(f, f);
            matrix.postTranslate((float) ((int) (f2 + 0.5f)), (float) ((int) (i + 1056964608)));
        }
    }

    private static class ScaleTypeFitStart extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitStart();

        public String toString() {
            return "fit_start";
        }

        private ScaleTypeFitStart() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            i = Math.min(f3, f4);
            i2 = (float) rect.left;
            rect = (float) rect.top;
            matrix.setScale(i, i);
            matrix.postTranslate((float) ((int) (i2 + 1056964608)), (float) ((int) (rect + 1056964608)));
        }
    }

    private static class ScaleTypeFitXY extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFitXY();

        public String toString() {
            return "fit_xy";
        }

        private ScaleTypeFitXY() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            i = (float) rect.left;
            rect = (float) rect.top;
            matrix.setScale(f3, f4);
            matrix.postTranslate((float) ((int) (i + 1056964608)), (float) ((int) (rect + 1056964608)));
        }
    }

    private static class ScaleTypeFocusCrop extends AbstractScaleType {
        public static final ScaleType INSTANCE = new ScaleTypeFocusCrop();

        public String toString() {
            return "focus_crop";
        }

        private ScaleTypeFocusCrop() {
        }

        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            if (f4 > f3) {
                i = ((float) i) * f4;
                f = ((float) rect.left) + Math.max(Math.min((((float) rect.width()) * 1056964608) - (f * i), 0.0f), ((float) rect.width()) - i);
                rect = (float) rect.top;
                f3 = f4;
            } else {
                f = (float) rect.left;
                i2 = ((float) i2) * f3;
                i = (((float) rect.height()) * 1056964608) - (f2 * i2);
                rect = Math.max(Math.min(i, 0.0f), ((float) rect.height()) - i2) + ((float) rect.top);
            }
            matrix.setScale(f3, f3);
            matrix.postTranslate((float) ((int) (f + 0.5f)), (float) ((int) (rect + 1056964608)));
        }
    }

    public static ScaleTypeDrawable getActiveScaleTypeDrawable(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) drawable;
        }
        if (drawable instanceof DrawableParent) {
            return getActiveScaleTypeDrawable(((DrawableParent) drawable).getDrawable());
        }
        if (drawable instanceof ArrayDrawable) {
            ArrayDrawable arrayDrawable = (ArrayDrawable) drawable;
            int numberOfLayers = arrayDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                ScaleTypeDrawable activeScaleTypeDrawable = getActiveScaleTypeDrawable(arrayDrawable.getDrawable(i));
                if (activeScaleTypeDrawable != null) {
                    return activeScaleTypeDrawable;
                }
            }
        }
        return null;
    }
}
