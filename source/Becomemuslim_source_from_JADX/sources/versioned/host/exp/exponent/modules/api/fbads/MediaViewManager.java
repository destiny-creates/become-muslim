package versioned.host.exp.exponent.modules.api.fbads;

import com.facebook.ads.MediaView;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class MediaViewManager extends SimpleViewManager<MediaView> {
    private static final String REACT_CLASS = "MediaView";

    public String getName() {
        return REACT_CLASS;
    }

    protected MediaView createViewInstance(ThemedReactContext themedReactContext) {
        return new MediaView(themedReactContext);
    }
}
