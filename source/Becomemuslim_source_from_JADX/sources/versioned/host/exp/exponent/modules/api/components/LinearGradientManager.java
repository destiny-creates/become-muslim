package versioned.host.exp.exponent.modules.api.components;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class LinearGradientManager extends SimpleViewManager<LinearGradientView> {
    public static final String PROP_BORDER_RADII = "borderRadii";
    public static final String PROP_COLORS = "colors";
    public static final String PROP_END_POS = "endPoint";
    public static final String PROP_LOCATIONS = "locations";
    public static final String PROP_START_POS = "startPoint";
    public static final String REACT_CLASS = "ExponentLinearGradient";

    public String getName() {
        return REACT_CLASS;
    }

    protected LinearGradientView createViewInstance(ThemedReactContext themedReactContext) {
        return new LinearGradientView(themedReactContext);
    }

    @ReactProp(name = "colors")
    public void setColors(LinearGradientView linearGradientView, ReadableArray readableArray) {
        linearGradientView.setColors(readableArray);
    }

    @ReactProp(name = "locations")
    public void setLocations(LinearGradientView linearGradientView, ReadableArray readableArray) {
        if (readableArray != null) {
            linearGradientView.setLocations(readableArray);
        }
    }

    @ReactProp(name = "startPoint")
    public void setStartPosition(LinearGradientView linearGradientView, ReadableArray readableArray) {
        linearGradientView.setStartPosition(readableArray);
    }

    @ReactProp(name = "endPoint")
    public void setEndPosition(LinearGradientView linearGradientView, ReadableArray readableArray) {
        linearGradientView.setEndPosition(readableArray);
    }

    @ReactProp(name = "borderRadii")
    public void setBorderRadii(LinearGradientView linearGradientView, ReadableArray readableArray) {
        linearGradientView.setBorderRadii(readableArray);
    }
}
