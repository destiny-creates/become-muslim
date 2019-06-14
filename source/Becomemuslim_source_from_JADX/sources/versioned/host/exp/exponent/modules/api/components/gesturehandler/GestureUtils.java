package versioned.host.exp.exponent.modules.api.components.gesturehandler;

import android.view.MotionEvent;

public class GestureUtils {
    public static float getLastPointerX(MotionEvent motionEvent, boolean z) {
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        boolean actionIndex = motionEvent.getActionMasked() == 6 ? motionEvent.getActionIndex() : true;
        if (z) {
            z = false;
            boolean pointerCount = motionEvent.getPointerCount();
            int i = 0;
            for (boolean z2 = false; z2 < pointerCount; z2++) {
                if (z2 != actionIndex) {
                    z += motionEvent.getX(z2) + rawX;
                    i++;
                }
            }
            return z / ((float) i);
        }
        z = motionEvent.getPointerCount() - 1;
        if (z == actionIndex) {
            z--;
        }
        return motionEvent.getX(z) + rawX;
    }

    public static float getLastPointerY(MotionEvent motionEvent, boolean z) {
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        boolean actionIndex = motionEvent.getActionMasked() == 6 ? motionEvent.getActionIndex() : true;
        if (z) {
            z = false;
            boolean pointerCount = motionEvent.getPointerCount();
            int i = 0;
            for (boolean z2 = false; z2 < pointerCount; z2++) {
                if (z2 != actionIndex) {
                    z += motionEvent.getY(z2) + rawY;
                    i++;
                }
            }
            return z / ((float) i);
        }
        z = motionEvent.getPointerCount() - 1;
        if (z == actionIndex) {
            z--;
        }
        return motionEvent.getY(z) + rawY;
    }
}
