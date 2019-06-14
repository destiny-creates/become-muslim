package versioned.host.exp.exponent.modules.api.components.svg;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
class RadialGradientView extends DefinitionView {
    private static final float[] sRawMatrix = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private SVGLength mCx;
    private SVGLength mCy;
    private SVGLength mFx;
    private SVGLength mFy;
    private ReadableArray mGradient;
    private BrushUnits mGradientUnits;
    private Matrix mMatrix = null;
    private SVGLength mRx;
    private SVGLength mRy;

    public RadialGradientView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "fx")
    public void setFx(Dynamic dynamic) {
        this.mFx = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "fy")
    public void setFy(Dynamic dynamic) {
        this.mFy = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "rx")
    public void setRx(Dynamic dynamic) {
        this.mRx = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "ry")
    public void setRy(Dynamic dynamic) {
        this.mRy = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "cx")
    public void setCx(Dynamic dynamic) {
        this.mCx = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "cy")
    public void setCy(Dynamic dynamic) {
        this.mCy = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "gradient")
    public void setGradient(ReadableArray readableArray) {
        this.mGradient = readableArray;
        invalidate();
    }

    @ReactProp(name = "gradientUnits")
    public void setGradientUnits(int i) {
        switch (i) {
            case 0:
                this.mGradientUnits = BrushUnits.OBJECT_BOUNDING_BOX;
                break;
            case 1:
                this.mGradientUnits = BrushUnits.USER_SPACE_ON_USE;
                break;
            default:
                break;
        }
        invalidate();
    }

    @ReactProp(name = "gradientTransform")
    public void setGradientTransform(ReadableArray readableArray) {
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

    void saveDefinition() {
        if (this.mName != null) {
            Brush brush = new Brush(BrushType.RADIAL_GRADIENT, new SVGLength[]{this.mFx, this.mFy, this.mRx, this.mRy, this.mCx, this.mCy}, this.mGradientUnits);
            brush.setGradientColors(this.mGradient);
            if (this.mMatrix != null) {
                brush.setGradientTransform(this.mMatrix);
            }
            SvgView svgView = getSvgView();
            if (this.mGradientUnits == BrushUnits.USER_SPACE_ON_USE) {
                brush.setUserSpaceBoundingBox(svgView.getCanvasBounds());
            }
            svgView.defineBrush(brush, this.mName);
        }
    }
}
