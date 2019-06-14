package versioned.host.exp.exponent.modules.api.components.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
class CircleView extends RenderableView {
    private SVGLength mCx;
    private SVGLength mCy;
    private SVGLength mR;

    public CircleView(ReactContext reactContext) {
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

    @ReactProp(name = "r")
    public void setR(Dynamic dynamic) {
        this.mR = getLengthFromDynamic(dynamic);
        invalidate();
    }

    Path getPath(Canvas canvas, Paint paint) {
        canvas = new Path();
        canvas.addCircle((float) relativeOnWidth(this.mCx), (float) relativeOnHeight(this.mCy), (float) relativeOnOther(this.mR), Direction.CW);
        return canvas;
    }
}
