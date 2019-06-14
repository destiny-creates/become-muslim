package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.ArrayUtils;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ARTShapeShadowNode extends ARTVirtualNode {
    private static final int CAP_BUTT = 0;
    private static final int CAP_ROUND = 1;
    private static final int CAP_SQUARE = 2;
    private static final int COLOR_TYPE_LINEAR_GRADIENT = 1;
    private static final int COLOR_TYPE_PATTERN = 3;
    private static final int COLOR_TYPE_RADIAL_GRADIENT = 2;
    private static final int COLOR_TYPE_SOLID_COLOR = 0;
    private static final int JOIN_BEVEL = 2;
    private static final int JOIN_MITER = 0;
    private static final int JOIN_ROUND = 1;
    private static final int PATH_TYPE_ARC = 4;
    private static final int PATH_TYPE_CLOSE = 1;
    private static final int PATH_TYPE_CURVETO = 3;
    private static final int PATH_TYPE_LINETO = 2;
    private static final int PATH_TYPE_MOVETO = 0;
    private float[] mBrushData;
    protected Path mPath;
    private int mStrokeCap = 1;
    private float[] mStrokeColor;
    private float[] mStrokeDash;
    private int mStrokeJoin = 1;
    private float mStrokeWidth = 1.0f;

    private float modulus(float f, float f2) {
        f %= f2;
        return f < 0.0f ? f + f2 : f;
    }

    public ARTShapeShadowNode(ARTShapeShadowNode aRTShapeShadowNode) {
        super(aRTShapeShadowNode);
        this.mPath = new Path(aRTShapeShadowNode.mPath);
        this.mStrokeColor = ArrayUtils.copyArray(aRTShapeShadowNode.mStrokeColor);
        this.mBrushData = ArrayUtils.copyArray(aRTShapeShadowNode.mBrushData);
        this.mStrokeDash = ArrayUtils.copyArray(aRTShapeShadowNode.mStrokeDash);
        this.mStrokeWidth = aRTShapeShadowNode.mStrokeWidth;
        this.mStrokeCap = aRTShapeShadowNode.mStrokeCap;
        this.mStrokeJoin = aRTShapeShadowNode.mStrokeJoin;
    }

    protected ARTShapeShadowNode copy() {
        return new ARTShapeShadowNode(this);
    }

    @ReactProp(name = "d")
    public void setShapePath(ReadableArray readableArray) {
        this.mPath = createPath(PropHelper.toFloatArray(readableArray));
        markUpdated();
    }

    @ReactProp(name = "stroke")
    public void setStroke(ReadableArray readableArray) {
        this.mStrokeColor = PropHelper.toFloatArray(readableArray);
        markUpdated();
    }

    @ReactProp(name = "strokeDash")
    public void setStrokeDash(ReadableArray readableArray) {
        this.mStrokeDash = PropHelper.toFloatArray(readableArray);
        markUpdated();
    }

    @ReactProp(name = "fill")
    public void setFill(ReadableArray readableArray) {
        this.mBrushData = PropHelper.toFloatArray(readableArray);
        markUpdated();
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(float f) {
        this.mStrokeWidth = f;
        markUpdated();
    }

    @ReactProp(defaultInt = 1, name = "strokeCap")
    public void setStrokeCap(int i) {
        this.mStrokeCap = i;
        markUpdated();
    }

    @ReactProp(defaultInt = 1, name = "strokeJoin")
    public void setStrokeJoin(int i) {
        this.mStrokeJoin = i;
        markUpdated();
    }

    public void draw(Canvas canvas, Paint paint, float f) {
        f *= this.mOpacity;
        if (f > 0.01f) {
            saveAndSetupCanvas(canvas);
            if (this.mPath != null) {
                if (setupFillPaint(paint, f)) {
                    canvas.drawPath(this.mPath, paint);
                }
                if (setupStrokePaint(paint, f) != null) {
                    canvas.drawPath(this.mPath, paint);
                }
                restoreCanvas(canvas);
            } else {
                throw new JSApplicationIllegalArgumentException("Shapes should have a valid path (d) prop");
            }
        }
        markUpdateSeen();
    }

    protected boolean setupStrokePaint(Paint paint, float f) {
        if (!(this.mStrokeWidth == 0.0f || this.mStrokeColor == null)) {
            if (this.mStrokeColor.length != 0) {
                paint.reset();
                paint.setFlags(1);
                paint.setStyle(Style.STROKE);
                switch (this.mStrokeCap) {
                    case 0:
                        paint.setStrokeCap(Cap.BUTT);
                        break;
                    case 1:
                        paint.setStrokeCap(Cap.ROUND);
                        break;
                    case 2:
                        paint.setStrokeCap(Cap.SQUARE);
                        break;
                    default:
                        f = new StringBuilder();
                        f.append("strokeCap ");
                        f.append(this.mStrokeCap);
                        f.append(" unrecognized");
                        throw new JSApplicationIllegalArgumentException(f.toString());
                }
                switch (this.mStrokeJoin) {
                    case 0:
                        paint.setStrokeJoin(Join.MITER);
                        break;
                    case 1:
                        paint.setStrokeJoin(Join.ROUND);
                        break;
                    case 2:
                        paint.setStrokeJoin(Join.BEVEL);
                        break;
                    default:
                        f = new StringBuilder();
                        f.append("strokeJoin ");
                        f.append(this.mStrokeJoin);
                        f.append(" unrecognized");
                        throw new JSApplicationIllegalArgumentException(f.toString());
                }
                paint.setStrokeWidth(this.mStrokeWidth * this.mScale);
                paint.setARGB((int) (this.mStrokeColor.length > 3 ? (this.mStrokeColor[3] * f) * 255.0f : f * 255.0f), (int) (this.mStrokeColor[0] * 255.0f), (int) (this.mStrokeColor[1] * 255.0f), (int) (this.mStrokeColor[2] * 255.0f));
                if (this.mStrokeDash != null && this.mStrokeDash.length > null) {
                    paint.setPathEffect(new DashPathEffect(this.mStrokeDash, 0.0f));
                }
                return true;
            }
        }
        return false;
    }

    protected boolean setupFillPaint(Paint paint, float f) {
        Paint paint2 = paint;
        int i = 0;
        if (this.mBrushData == null || r0.mBrushData.length <= 0) {
            return false;
        }
        paint.reset();
        paint2.setFlags(1);
        paint2.setStyle(Style.FILL);
        int i2 = (int) r0.mBrushData[0];
        float f2 = 255.0f;
        String str;
        StringBuilder stringBuilder;
        switch (i2) {
            case 0:
                float f3;
                float f4;
                if (r0.mBrushData.length > 4) {
                    f3 = 255.0f;
                    f4 = (r0.mBrushData[4] * f) * 255.0f;
                } else {
                    f3 = 255.0f;
                    f4 = f * 255.0f;
                }
                paint2.setARGB((int) f4, (int) (r0.mBrushData[1] * f3), (int) (r0.mBrushData[2] * f3), (int) (r0.mBrushData[3] * f3));
                break;
            case 1:
                i2 = 5;
                if (r0.mBrushData.length >= 5) {
                    int[] iArr;
                    float[] fArr;
                    float f5 = r0.mBrushData[1] * r0.mScale;
                    float f6 = r0.mBrushData[2] * r0.mScale;
                    float f7 = r0.mBrushData[3] * r0.mScale;
                    float f8 = r0.mBrushData[4] * r0.mScale;
                    int length = (r0.mBrushData.length - 5) / 5;
                    if (length > 0) {
                        int[] iArr2 = new int[length];
                        float[] fArr2 = new float[length];
                        while (i < length) {
                            fArr2[i] = r0.mBrushData[((length * 4) + i2) + i];
                            int i3 = (i * 4) + i2;
                            iArr2[i] = Color.argb((int) (r0.mBrushData[i3 + 3] * 255.0f), (int) (r0.mBrushData[i3 + 0] * f2), (int) (r0.mBrushData[i3 + 1] * f2), (int) (r0.mBrushData[i3 + 2] * f2));
                            i++;
                            i2 = 5;
                            f2 = 255.0f;
                        }
                        iArr = iArr2;
                        fArr = fArr2;
                    } else {
                        iArr = null;
                        fArr = iArr;
                    }
                    paint2.setShader(new LinearGradient(f5, f6, f7, f8, iArr, fArr, TileMode.CLAMP));
                    break;
                }
                str = ReactConstants.TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("[ARTShapeShadowNode setupFillPaint] expects 5 elements, received ");
                stringBuilder.append(r0.mBrushData.length);
                FLog.m5714w(str, stringBuilder.toString());
                return false;
            default:
                str = ReactConstants.TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("ART: Color type ");
                stringBuilder.append(i2);
                stringBuilder.append(" not supported!");
                FLog.m5714w(str, stringBuilder.toString());
                break;
        }
        return true;
    }

    private Path createPath(float[] fArr) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        int i = 0;
        while (i < fArr.length) {
            int i2;
            int i3 = i + 1;
            i = (int) fArr[i];
            float f;
            float f2;
            switch (i) {
                case 0:
                    i = i3 + 1;
                    i2 = i + 1;
                    path.moveTo(fArr[i3] * this.mScale, fArr[i] * this.mScale);
                    break;
                case 1:
                    path.close();
                    i = i3;
                    continue;
                case 2:
                    i = i3 + 1;
                    i2 = i + 1;
                    path.lineTo(fArr[i3] * this.mScale, fArr[i] * this.mScale);
                    break;
                case 3:
                    i = i3 + 1;
                    i2 = i + 1;
                    f = this.mScale * fArr[i];
                    i = i2 + 1;
                    f2 = this.mScale * fArr[i2];
                    i2 = i + 1;
                    float f3 = this.mScale * fArr[i];
                    i = i2 + 1;
                    int i4 = i + 1;
                    path.cubicTo(fArr[i3] * this.mScale, f, f2, f3, this.mScale * fArr[i2], fArr[i] * this.mScale);
                    i = i4;
                    continue;
                case 4:
                    i = i3 + 1;
                    float f4 = fArr[i3] * this.mScale;
                    i2 = i + 1;
                    float f5 = fArr[i] * this.mScale;
                    int i5 = i2 + 1;
                    float f6 = fArr[i2] * this.mScale;
                    int i6 = i5 + 1;
                    f = (float) Math.toDegrees((double) fArr[i5]);
                    int i7 = i6 + 1;
                    f2 = (float) Math.toDegrees((double) fArr[i6]);
                    int i8 = i7 + 1;
                    Object obj = fArr[i7] != 1.0f ? 1 : null;
                    f2 -= f;
                    if (Math.abs(f2) >= 360.0f) {
                        path.addCircle(f4, f5, f6, obj != null ? Direction.CCW : Direction.CW);
                    } else {
                        f2 = modulus(f2, 360.0f);
                        if (obj != null && f2 < 360.0f) {
                            f2 = (360.0f - f2) * -1.0f;
                        }
                        path.arcTo(new RectF(f4 - f6, f5 - f6, f4 + f6, f5 + f6), f, f2);
                    }
                    i = i8;
                    continue;
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unrecognized drawing instruction ");
                    stringBuilder.append(i);
                    throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
            }
            i = i2;
        }
        return path;
    }
}
