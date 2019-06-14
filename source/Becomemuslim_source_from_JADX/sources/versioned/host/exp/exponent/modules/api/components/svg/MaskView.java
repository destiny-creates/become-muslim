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
class MaskView extends GroupView {
    private static final float[] sRawMatrix = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    SVGLength mH;
    private BrushUnits mMaskContentUnits;
    private BrushUnits mMaskUnits;
    private Matrix mMatrix = null;
    SVGLength mW;
    SVGLength mX;
    SVGLength mY;

    public MaskView(ReactContext reactContext) {
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

    @ReactProp(name = "maskUnits")
    public void setMaskUnits(int i) {
        switch (i) {
            case 0:
                this.mMaskUnits = BrushUnits.OBJECT_BOUNDING_BOX;
                break;
            case 1:
                this.mMaskUnits = BrushUnits.USER_SPACE_ON_USE;
                break;
            default:
                break;
        }
        invalidate();
    }

    @ReactProp(name = "maskContentUnits")
    public void setMaskContentUnits(int i) {
        switch (i) {
            case 0:
                this.mMaskContentUnits = BrushUnits.OBJECT_BOUNDING_BOX;
                break;
            case 1:
                this.mMaskContentUnits = BrushUnits.USER_SPACE_ON_USE;
                break;
            default:
                break;
        }
        invalidate();
    }

    @ReactProp(name = "maskTransform")
    public void setMaskTransform(ReadableArray readableArray) {
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
            getSvgView().defineMask(this, this.mName);
        }
    }
}
