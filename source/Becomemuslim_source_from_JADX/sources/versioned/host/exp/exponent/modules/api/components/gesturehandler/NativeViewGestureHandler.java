package versioned.host.exp.exponent.modules.api.components.gesturehandler;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class NativeViewGestureHandler extends GestureHandler<NativeViewGestureHandler> {
    private boolean mDisallowInterruption;
    private boolean mShouldActivateOnStart;

    public NativeViewGestureHandler() {
        setShouldCancelWhenOutside(true);
    }

    public NativeViewGestureHandler setShouldActivateOnStart(boolean z) {
        this.mShouldActivateOnStart = z;
        return this;
    }

    public NativeViewGestureHandler setDisallowInterruption(boolean z) {
        this.mDisallowInterruption = z;
        return this;
    }

    public boolean shouldRequireToWaitForFailure(GestureHandler gestureHandler) {
        return super.shouldRequireToWaitForFailure(gestureHandler);
    }

    public boolean shouldRecognizeSimultaneously(GestureHandler gestureHandler) {
        boolean z = false;
        if (gestureHandler instanceof NativeViewGestureHandler) {
            NativeViewGestureHandler nativeViewGestureHandler = (NativeViewGestureHandler) gestureHandler;
            if (nativeViewGestureHandler.getState() == 4 && nativeViewGestureHandler.mDisallowInterruption) {
                return false;
            }
        }
        int i = this.mDisallowInterruption ^ 1;
        int state = getState();
        gestureHandler = gestureHandler.getState();
        if (state == 4 && gestureHandler == 4 && i != 0) {
            return false;
        }
        if (state == 4 && i != 0) {
            z = true;
        }
        return z;
    }

    public boolean shouldBeCancelledBy(GestureHandler gestureHandler) {
        return this.mDisallowInterruption ^ 1;
    }

    protected void onHandle(MotionEvent motionEvent) {
        View view = getView();
        int state = getState();
        if (motionEvent.getActionMasked() == 1) {
            view.onTouchEvent(motionEvent);
            if ((state == 0 || state == 2) && view.isPressed() != null) {
                activate();
            }
            end();
            return;
        }
        if (state != 0) {
            if (state != 2) {
                if (state == 4) {
                    view.onTouchEvent(motionEvent);
                    return;
                }
                return;
            }
        }
        if (this.mShouldActivateOnStart) {
            tryIntercept(view, motionEvent);
            view.onTouchEvent(motionEvent);
            activate();
        } else if (tryIntercept(view, motionEvent)) {
            view.onTouchEvent(motionEvent);
            activate();
        } else if (state != 2) {
            begin();
        }
    }

    private static boolean tryIntercept(View view, MotionEvent motionEvent) {
        return (!(view instanceof ViewGroup) || ((ViewGroup) view).onInterceptTouchEvent(motionEvent) == null) ? null : true;
    }

    protected void onCancel() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        obtain.setAction(3);
        getView().onTouchEvent(obtain);
    }
}
