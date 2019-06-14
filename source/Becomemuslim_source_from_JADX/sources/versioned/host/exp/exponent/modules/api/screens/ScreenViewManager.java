package versioned.host.exp.exponent.modules.api.screens;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

@ReactModule(name = "RNSScreen")
public class ScreenViewManager extends ViewGroupManager<Screen> {
    protected static final String REACT_CLASS = "RNSScreen";

    public String getName() {
        return REACT_CLASS;
    }

    protected Screen createViewInstance(ThemedReactContext themedReactContext) {
        return new Screen(themedReactContext);
    }

    @ReactProp(defaultFloat = 0.0f, name = "active")
    public void setActive(Screen screen, float f) {
        screen.setActive(f != 0.0f ? Float.MIN_VALUE : 0.0f);
    }
}
