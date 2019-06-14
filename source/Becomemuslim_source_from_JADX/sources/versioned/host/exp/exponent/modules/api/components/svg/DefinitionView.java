package versioned.host.exp.exponent.modules.api.components.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.ReactContext;

@SuppressLint({"ViewConstructor"})
class DefinitionView extends VirtualView {
    void draw(Canvas canvas, Paint paint, float f) {
    }

    Path getPath(Canvas canvas, Paint paint) {
        return null;
    }

    int hitTest(float[] fArr) {
        return -1;
    }

    boolean isResponsible() {
        return false;
    }

    DefinitionView(ReactContext reactContext) {
        super(reactContext);
    }
}
