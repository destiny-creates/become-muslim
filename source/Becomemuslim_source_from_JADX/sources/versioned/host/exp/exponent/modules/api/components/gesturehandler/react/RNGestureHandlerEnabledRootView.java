package versioned.host.exp.exponent.modules.api.components.gesturehandler.react;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;

public class RNGestureHandlerEnabledRootView extends ReactRootView {
    private RNGestureHandlerRootHelper mGestureRootHelper;
    private ReactInstanceManager mReactInstanceManager;

    public RNGestureHandlerEnabledRootView(Context context) {
        super(context);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (this.mGestureRootHelper != null) {
            this.mGestureRootHelper.requestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureRootHelper == null || !this.mGestureRootHelper.dispatchTouchEvent(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void initialize() {
        if (this.mGestureRootHelper == null) {
            this.mGestureRootHelper = new RNGestureHandlerRootHelper(this.mReactInstanceManager.getCurrentReactContext(), this);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GestureHandler already initialized for root view ");
        stringBuilder.append(this);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public void tearDown() {
        if (this.mGestureRootHelper != null) {
            this.mGestureRootHelper.tearDown();
            this.mGestureRootHelper = null;
        }
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str, Bundle bundle) {
        super.startReactApplication(reactInstanceManager, str, bundle);
        this.mReactInstanceManager = reactInstanceManager;
    }
}
