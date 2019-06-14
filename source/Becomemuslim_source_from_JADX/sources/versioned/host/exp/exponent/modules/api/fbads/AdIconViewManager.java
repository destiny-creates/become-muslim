package versioned.host.exp.exponent.modules.api.fbads;

import com.facebook.ads.AdIconView;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class AdIconViewManager extends SimpleViewManager<AdIconView> {
    private static final String REACT_CLASS = "AdIconView";

    public String getName() {
        return REACT_CLASS;
    }

    protected AdIconView createViewInstance(ThemedReactContext themedReactContext) {
        return new AdIconView(themedReactContext);
    }
}
