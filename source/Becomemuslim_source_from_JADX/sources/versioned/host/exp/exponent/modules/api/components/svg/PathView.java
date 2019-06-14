package versioned.host.exp.exponent.modules.api.components.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
class PathView extends RenderableView {
    private Path mPath;

    public PathView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "d")
    public void setD(String str) {
        this.mPath = new PathParser(str, this.mScale).getPath();
        invalidate();
    }

    Path getPath(Canvas canvas, Paint paint) {
        return this.mPath;
    }
}
