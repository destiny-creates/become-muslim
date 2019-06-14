package versioned.host.exp.exponent.modules.api.components.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
class LineView extends RenderableView {
    private SVGLength mX1;
    private SVGLength mX2;
    private SVGLength mY1;
    private SVGLength mY2;

    public LineView(ReactContext reactContext) {
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

    Path getPath(Canvas canvas, Paint paint) {
        canvas = new Path();
        double relativeOnWidth = relativeOnWidth(this.mX1);
        double relativeOnHeight = relativeOnHeight(this.mY1);
        double relativeOnWidth2 = relativeOnWidth(this.mX2);
        double relativeOnHeight2 = relativeOnHeight(this.mY2);
        canvas.moveTo((float) relativeOnWidth, (float) relativeOnHeight);
        canvas.lineTo((float) relativeOnWidth2, (float) relativeOnHeight2);
        return canvas;
    }
}
