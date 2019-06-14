package versioned.host.exp.exponent.modules.api.components.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
class UseView extends RenderableView {
    private SVGLength mH;
    private String mHref;
    private SVGLength mW;

    public UseView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "href")
    public void setHref(String str) {
        this.mHref = str;
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

    void draw(Canvas canvas, Paint paint, float f) {
        VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.mHref);
        if (definedTemplate != null) {
            boolean z = definedTemplate instanceof RenderableView;
            if (z) {
                ((RenderableView) definedTemplate).mergeProperties(this);
            }
            int saveAndSetupCanvas = definedTemplate.saveAndSetupCanvas(canvas);
            clip(canvas, paint);
            if (definedTemplate instanceof SymbolView) {
                ((SymbolView) definedTemplate).drawSymbol(canvas, paint, f, (float) relativeOnWidth(this.mW), (float) relativeOnHeight(this.mH));
            } else {
                definedTemplate.draw(canvas, paint, f * this.mOpacity);
            }
            setClientRect(definedTemplate.getClientRect());
            definedTemplate.restoreCanvas(canvas, saveAndSetupCanvas);
            if (z) {
                ((RenderableView) definedTemplate).resetProperties();
                return;
            }
            return;
        }
        canvas = ReactConstants.TAG;
        paint = new StringBuilder();
        paint.append("`Use` element expected a pre-defined svg template as `href` prop, template named: ");
        paint.append(this.mHref);
        paint.append(" is not defined.");
        FLog.w(canvas, paint.toString());
    }

    int hitTest(float[] fArr) {
        if (this.mInvertible) {
            if (this.mTransformInvertible) {
                float[] fArr2 = new float[2];
                this.mInvMatrix.mapPoints(fArr2, fArr);
                this.mInvTransform.mapPoints(fArr2);
                fArr = getSvgView().getDefinedTemplate(this.mHref);
                int hitTest = fArr.hitTest(fArr2);
                if (hitTest == -1) {
                    return -1;
                }
                if (!fArr.isResponsible()) {
                    if (hitTest == fArr.getId()) {
                        hitTest = getId();
                    }
                }
                return hitTest;
            }
        }
        return -1;
    }

    Path getPath(Canvas canvas, Paint paint) {
        return new Path();
    }
}
