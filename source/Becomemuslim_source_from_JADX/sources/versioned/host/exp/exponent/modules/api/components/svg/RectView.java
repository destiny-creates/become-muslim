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
class RectView extends RenderableView {
    private SVGLength mH;
    private SVGLength mRx;
    private SVGLength mRy;
    private SVGLength mW;
    private SVGLength mX;
    private SVGLength mY;

    public RectView(ReactContext reactContext) {
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
        Path path = new Path();
        double relativeOnWidth = relativeOnWidth(this.mX);
        double relativeOnHeight = relativeOnHeight(this.mY);
        double relativeOnWidth2 = relativeOnWidth(this.mW);
        double relativeOnHeight2 = relativeOnHeight(this.mH);
        double relativeOnWidth3 = relativeOnWidth(this.mRx);
        double relativeOnHeight3 = relativeOnHeight(this.mRy);
        int i = (relativeOnWidth3 > 0.0d ? 1 : (relativeOnWidth3 == 0.0d ? 0 : -1));
        if (i == 0) {
            if (relativeOnHeight3 == 0.0d) {
                path.addRect((float) relativeOnWidth, (float) relativeOnHeight, (float) (relativeOnWidth + relativeOnWidth2), (float) (relativeOnHeight + relativeOnHeight2), Direction.CW);
                return path;
            }
        }
        if (i == 0) {
            relativeOnWidth3 = relativeOnHeight3;
        } else if (relativeOnHeight3 == 0.0d) {
            relativeOnHeight3 = relativeOnWidth3;
        }
        double d = relativeOnWidth2 / 2.0d;
        if (relativeOnWidth3 > d) {
            relativeOnWidth3 = d;
        }
        double d2 = relativeOnHeight2 / 2.0d;
        if (relativeOnHeight3 <= d2) {
            d2 = relativeOnHeight3;
        }
        path.addRoundRect(new RectF((float) relativeOnWidth, (float) relativeOnHeight, (float) (relativeOnWidth + relativeOnWidth2), (float) (relativeOnHeight + relativeOnHeight2)), (float) relativeOnWidth3, (float) d2, Direction.CW);
        return path;
    }
}
