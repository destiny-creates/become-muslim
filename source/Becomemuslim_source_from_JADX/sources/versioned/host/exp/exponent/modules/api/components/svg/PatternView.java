package versioned.host.exp.exponent.modules.api.components.svg;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
class PatternView extends GroupView {
    private static final float[] sRawMatrix = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    String mAlign;
    private SVGLength mH;
    private Matrix mMatrix = null;
    int mMeetOrSlice;
    private float mMinX;
    private float mMinY;
    private BrushUnits mPatternContentUnits;
    private BrushUnits mPatternUnits;
    private float mVbHeight;
    private float mVbWidth;
    private SVGLength mW;
    private SVGLength mX;
    private SVGLength mY;

    public PatternView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "x")
    public void setX(Dynamic dynamic) {
        this.mX = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "y")
    public void setY(Dynamic dynamic) {
        this.mY = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        this.mW = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        this.mH = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "patternUnits")
    public void setPatternUnits(int i) {
        switch (i) {
            case 0:
                this.mPatternUnits = BrushUnits.OBJECT_BOUNDING_BOX;
                break;
            case 1:
                this.mPatternUnits = BrushUnits.USER_SPACE_ON_USE;
                break;
            default:
                break;
        }
        invalidate();
    }

    @ReactProp(name = "patternContentUnits")
    public void setPatternContentUnits(int i) {
        switch (i) {
            case 0:
                this.mPatternContentUnits = BrushUnits.OBJECT_BOUNDING_BOX;
                break;
            case 1:
                this.mPatternContentUnits = BrushUnits.USER_SPACE_ON_USE;
                break;
            default:
                break;
        }
        invalidate();
    }

    @ReactProp(name = "patternTransform")
    public void setPatternTransform(ReadableArray readableArray) {
        if (readableArray != null) {
            readableArray = PropHelper.toMatrixData(readableArray, sRawMatrix, this.mScale);
            if (readableArray == 6) {
                if (this.mMatrix == null) {
                    this.mMatrix = new Matrix();
                }
                this.mMatrix.setValues(sRawMatrix);
            } else if (readableArray != -1) {
                FLog.w(ReactConstants.TAG, "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.mMatrix = null;
        }
        invalidate();
    }

    @ReactProp(name = "minX")
    public void setMinX(float f) {
        this.mMinX = f;
        invalidate();
    }

    @ReactProp(name = "minY")
    public void setMinY(float f) {
        this.mMinY = f;
        invalidate();
    }

    @ReactProp(name = "vbWidth")
    public void setVbWidth(float f) {
        this.mVbWidth = f;
        invalidate();
    }

    @ReactProp(name = "vbHeight")
    public void setVbHeight(float f) {
        this.mVbHeight = f;
        invalidate();
    }

    @ReactProp(name = "align")
    public void setAlign(String str) {
        this.mAlign = str;
        invalidate();
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(int i) {
        this.mMeetOrSlice = i;
        invalidate();
    }

    RectF getViewBox() {
        return new RectF(this.mMinX * this.mScale, this.mMinY * this.mScale, (this.mMinX + this.mVbWidth) * this.mScale, (this.mMinY + this.mVbHeight) * this.mScale);
    }

    void saveDefinition() {
        if (this.mName != null) {
            Brush brush = new Brush(BrushType.PATTERN, new SVGLength[]{this.mX, this.mY, this.mW, this.mH}, this.mPatternUnits);
            brush.setContentUnits(this.mPatternContentUnits);
            brush.setPattern(this);
            if (this.mMatrix != null) {
                brush.setGradientTransform(this.mMatrix);
            }
            SvgView svgView = getSvgView();
            if (this.mPatternUnits == BrushUnits.USER_SPACE_ON_USE || this.mPatternContentUnits == BrushUnits.USER_SPACE_ON_USE) {
                brush.setUserSpaceBoundingBox(svgView.getCanvasBounds());
            }
            svgView.defineBrush(brush, this.mName);
        }
    }
}
