package versioned.host.exp.exponent.modules.api.components.gesturehandler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class GestureHandlerViewWrapper extends FrameLayout {
    private final GestureHandlerOrchestrator mOrchestrator = new GestureHandlerOrchestrator(this, this.mRegistry, new ViewConfigurationHelperImpl());
    private final GestureHandlerRegistryImpl mRegistry = new GestureHandlerRegistryImpl();

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public GestureHandlerViewWrapper(Context context) {
        super(context);
    }

    public GestureHandlerViewWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GestureHandlerViewWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public GestureHandlerRegistryImpl getRegistry() {
        return this.mRegistry;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mOrchestrator.onTouchEvent(motionEvent);
    }
}
