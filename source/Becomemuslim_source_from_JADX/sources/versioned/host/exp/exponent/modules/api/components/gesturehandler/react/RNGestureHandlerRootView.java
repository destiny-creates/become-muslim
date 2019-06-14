package versioned.host.exp.exponent.modules.api.components.gesturehandler.react;

import android.content.Context;
import android.view.MotionEvent;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.views.view.ReactViewGroup;

public class RNGestureHandlerRootView extends ReactViewGroup {
    private RNGestureHandlerRootHelper mRootHelper;

    public RNGestureHandlerRootView(Context context) {
        super(context);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mRootHelper == null) {
            this.mRootHelper = new RNGestureHandlerRootHelper((ReactContext) getContext(), this);
        }
    }

    public void tearDown() {
        if (this.mRootHelper != null) {
            this.mRootHelper.tearDown();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (((RNGestureHandlerRootHelper) Assertions.assertNotNull(this.mRootHelper)).dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        ((RNGestureHandlerRootHelper) Assertions.assertNotNull(this.mRootHelper)).requestDisallowInterceptTouchEvent(z);
        super.requestDisallowInterceptTouchEvent(z);
    }
}
