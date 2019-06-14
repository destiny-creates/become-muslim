package versioned.host.exp.exponent.modules.api.components.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
class EllipseView extends RenderableView {
    private SVGLength mCx;
    private SVGLength mCy;
    private SVGLength mRx;
    private SVGLength mRy;

    public EllipseView(ReactContext reactContext) {
        super(reactContext);
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

    Path getPath(Canvas canvas, Paint paint) {
        canvas = new Path();
        double relativeOnWidth = relativeOnWidth(this.mCx);
        double relativeOnHeight = relativeOnHeight(this.mCy);
        double relativeOnWidth2 = relativeOnWidth(this.mRx);
        double relativeOnHeight2 = relativeOnHeight(this.mRy);
        canvas.addOval(new RectF((float) (relativeOnWidth - relativeOnWidth2), (float) (relativeOnHeight - relativeOnHeight2), (float) (relativeOnWidth + relativeOnWidth2), (float) (relativeOnHeight + relativeOnHeight2)), Direction.CW);
        return canvas;
    }
}
