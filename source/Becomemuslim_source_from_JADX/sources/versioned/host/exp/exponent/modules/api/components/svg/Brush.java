package versioned.host.exp.exponent.modules.api.components.svg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.ReactConstants;

class Brush {
    private ReadableArray mColors;
    private Matrix mMatrix;
    private PatternView mPattern;
    private final SVGLength[] mPoints;
    private final BrushType mType;
    private boolean mUseContentObjectBoundingBox;
    private final boolean mUseObjectBoundingBox;
    private Rect mUserSpaceBoundingBox;

    enum BrushType {
        LINEAR_GRADIENT,
        RADIAL_GRADIENT,
        PATTERN
    }

    enum BrushUnits {
        OBJECT_BOUNDING_BOX,
        USER_SPACE_ON_USE
    }

    Brush(BrushType brushType, SVGLength[] sVGLengthArr, BrushUnits brushUnits) {
        this.mType = brushType;
        this.mPoints = sVGLengthArr;
        this.mUseObjectBoundingBox = brushUnits == BrushUnits.OBJECT_BOUNDING_BOX ? true : null;
    }

    void setContentUnits(BrushUnits brushUnits) {
        this.mUseContentObjectBoundingBox = brushUnits == BrushUnits.OBJECT_BOUNDING_BOX ? true : null;
    }

    void setPattern(PatternView patternView) {
        this.mPattern = patternView;
    }

    private static void parseGradientStops(ReadableArray readableArray, int i, float[] fArr, int[] iArr, float f) {
        int size = readableArray.size() - i;
        for (int i2 = 0; i2 < i; i2++) {
            fArr[i2] = (float) readableArray.getDouble(size + i2);
            int i3 = i2 * 4;
            iArr[i2] = Color.argb((int) ((readableArray.getDouble(i3 + 3) * 255.0d) * ((double) f)), (int) (readableArray.getDouble(i3) * 255.0d), (int) (readableArray.getDouble(i3 + 1) * 255.0d), (int) (readableArray.getDouble(i3 + 2) * 255.0d));
        }
    }

    void setUserSpaceBoundingBox(Rect rect) {
        this.mUserSpaceBoundingBox = rect;
    }

    void setGradientColors(ReadableArray readableArray) {
        this.mColors = readableArray;
    }

    void setGradientTransform(Matrix matrix) {
        this.mMatrix = matrix;
    }

    private RectF getPaintRect(RectF rectF) {
        if (!this.mUseObjectBoundingBox) {
            rectF = new RectF(this.mUserSpaceBoundingBox);
        }
        float width = rectF.width();
        float height = rectF.height();
        float f = 0.0f;
        if (this.mUseObjectBoundingBox) {
            f = rectF.left;
            rectF = rectF.top;
        } else {
            rectF = null;
        }
        return new RectF(f, rectF, width + f, height + rectF);
    }

    void setupPaint(Paint paint, RectF rectF, float f, float f2) {
        Paint paint2 = paint;
        float f3 = f;
        float f4 = f2;
        RectF paintRect = getPaintRect(rectF);
        float width = paintRect.width();
        float height = paintRect.height();
        float f5 = paintRect.left;
        float f6 = paintRect.top;
        float textSize = paint.getTextSize();
        Matrix transform;
        if (this.mType == BrushType.PATTERN) {
            double d = (double) width;
            double d2 = (double) f5;
            double d3 = (double) f3;
            double d4 = (double) textSize;
            double fromRelative = PropHelper.fromRelative(r0.mPoints[0], d, d2, d3, d4);
            double d5 = (double) height;
            double d6 = (double) f6;
            double d7 = d3;
            double d8 = d4;
            double d9 = fromRelative;
            fromRelative = PropHelper.fromRelative(r0.mPoints[1], d5, d6, d7, d8);
            d = PropHelper.fromRelative(r0.mPoints[2], d, d2, d7, d8);
            d6 = PropHelper.fromRelative(r0.mPoints[3], d5, d6, d7, d8);
            transform = ViewBox.getTransform(r0.mPattern.getViewBox(), new RectF((float) d9, (float) fromRelative, (float) d, (float) d6), r0.mPattern.mAlign, r0.mPattern.mMeetOrSlice);
            Bitmap createBitmap = Bitmap.createBitmap((int) d, (int) d6, Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.concat(transform);
            r0.mPattern.draw(canvas, new Paint(), f2);
            transform = new Matrix();
            if (r0.mMatrix != null) {
                transform.preConcat(r0.mMatrix);
            }
            Shader bitmapShader = new BitmapShader(createBitmap, TileMode.REPEAT, TileMode.REPEAT);
            bitmapShader.setLocalMatrix(transform);
            paint.setShader(bitmapShader);
            return;
        }
        float f7 = f4;
        int size = r0.mColors.size() / 5;
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        parseGradientStops(r0.mColors, size, fArr, iArr, f7);
        if (fArr.length == 1) {
            int[] iArr2 = new int[]{iArr[0], iArr[0]};
            float[] fArr2 = new float[]{fArr[0], fArr[0]};
            FLog.w(ReactConstants.TAG, "Gradient contains only on stop");
            fArr = fArr2;
            iArr = iArr2;
        }
        double d10;
        int[] iArr3;
        float[] fArr3;
        Shader linearGradient;
        if (r0.mType == BrushType.LINEAR_GRADIENT) {
            d10 = (double) width;
            d = (double) f5;
            d3 = (double) f3;
            d4 = (double) textSize;
            iArr3 = iArr;
            fArr3 = fArr;
            d2 = (double) height;
            double fromRelative2 = PropHelper.fromRelative(r0.mPoints[0], d10, d, d3, d4);
            fromRelative = (double) f6;
            d7 = d3;
            d8 = d4;
            double d11 = fromRelative;
            fromRelative = PropHelper.fromRelative(r0.mPoints[1], d2, fromRelative, d7, d8);
            f3 = (float) PropHelper.fromRelative(r0.mPoints[2], d10, d, d7, d8);
            linearGradient = new LinearGradient((float) fromRelative2, (float) fromRelative, f3, (float) PropHelper.fromRelative(r0.mPoints[3], d2, d11, d7, d8), iArr3, fArr3, TileMode.CLAMP);
            if (r0.mMatrix != null) {
                transform = new Matrix();
                transform.preConcat(r0.mMatrix);
                linearGradient.setLocalMatrix(transform);
            }
            paint.setShader(linearGradient);
        } else {
            iArr3 = iArr;
            fArr3 = fArr;
            if (r0.mType == BrushType.RADIAL_GRADIENT) {
                d10 = (double) width;
                double d12 = (double) textSize;
                double d13 = (double) f3;
                d3 = PropHelper.fromRelative(r0.mPoints[2], d10, 0.0d, d13, d12);
                d2 = (double) height;
                d8 = d12;
                d9 = PropHelper.fromRelative(r0.mPoints[3], d2, 0.0d, d13, d8);
                d7 = d2;
                double d14 = d3;
                d10 = PropHelper.fromRelative(r0.mPoints[4], d10, (double) f5, d13, d12);
                double d15 = d14;
                d12 = d9 / d15;
                f3 = (float) (PropHelper.fromRelative(r0.mPoints[5], d7, (double) f6, d13, d8) / d12);
                linearGradient = new RadialGradient((float) d10, f3, (float) d15, iArr3, fArr3, TileMode.CLAMP);
                Matrix matrix = new Matrix();
                matrix.preScale(1.0f, (float) d12);
                if (r0.mMatrix != null) {
                    matrix.preConcat(r0.mMatrix);
                }
                linearGradient.setLocalMatrix(matrix);
                paint2.setShader(linearGradient);
            }
        }
    }
}
