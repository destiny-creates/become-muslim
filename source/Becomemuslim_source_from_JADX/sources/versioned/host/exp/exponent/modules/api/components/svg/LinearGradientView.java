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
class LinearGradientView extends DefinitionView {
    private static final float[] sRawMatrix = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private ReadableArray mGradient;
    private BrushUnits mGradientUnits;
    private Matrix mMatrix = null;
    private SVGLength mX1;
    private SVGLength mX2;
    private SVGLength mY1;
    private SVGLength mY2;

    public LinearGradientView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "x1")
    public void setX1(Dynamic dynamic) {
        this.mX1 = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "y1")
    public void setY1(Dynamic dynamic) {
        this.mY1 = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "x2")
    public void setX2(Dynamic dynamic) {
        this.mX2 = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "y2")
    public void setY2(Dynamic dynamic) {
        this.mY2 = getLengthFromDynamic(dynamic);
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
            Brush brush = new Brush(BrushType.LINEAR_GRADIENT, new SVGLength[]{this.mX1, this.mY1, this.mX2, this.mY2}, this.mGradientUnits);
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
