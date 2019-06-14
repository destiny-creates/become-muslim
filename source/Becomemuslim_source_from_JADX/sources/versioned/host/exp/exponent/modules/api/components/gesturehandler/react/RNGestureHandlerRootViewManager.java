package versioned.host.exp.exponent.modules.api.components.gesturehandler.react;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import java.util.Map;

@ReactModule(name = "GestureHandlerRootView")
public class RNGestureHandlerRootViewManager extends ViewGroupManager<RNGestureHandlerRootView> {
    public static final String REACT_CLASS = "GestureHandlerRootView";

    public String getName() {
        return REACT_CLASS;
    }

    protected RNGestureHandlerRootView createViewInstance(ThemedReactContext themedReactContext) {
        return new RNGestureHandlerRootView(themedReactContext);
    }

    public void onDropViewInstance(RNGestureHandlerRootView rNGestureHandlerRootView) {
        rNGestureHandlerRootView.tearDown();
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(RNGestureHandlerEvent.EVENT_NAME, MapBuilder.of("registrationName", RNGestureHandlerEvent.EVENT_NAME), RNGestureHandlerStateChangeEvent.EVENT_NAME, MapBuilder.of("registrationName", RNGestureHandlerStateChangeEvent.EVENT_NAME));
    }
}
