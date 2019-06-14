package versioned.host.exp.exponent.modules.api.components.gesturehandler;

import android.view.MotionEvent;

public interface OnTouchEventListener<T extends GestureHandler> {
    void onStateChange(T t, int i, int i2);

    void onTouchEvent(T t, MotionEvent motionEvent);
}
