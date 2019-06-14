package versioned.host.exp.exponent.modules.api.components.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;

@SuppressLint({"ViewConstructor"})
class ClipPathView extends GroupView {
    int hitTest(float[] fArr) {
        return -1;
    }

    boolean isResponsible() {
        return false;
    }

    void mergeProperties(RenderableView renderableView) {
    }

    void resetProperties() {
    }

    public ClipPathView(ReactContext reactContext) {
        super(reactContext);
        this.mClipRule = 1;
    }

    void draw(Canvas canvas, Paint paint, float f) {
        FLog.w(ReactConstants.TAG, "RNSVG: ClipPath can't be drawn, it should be defined as a child component for `Defs` ");
    }

    void saveDefinition() {
        getSvgView().defineClipPath(this, this.mName);
    }
}
