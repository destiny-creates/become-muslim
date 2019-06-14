package versioned.host.exp.exponent.modules.api.components.maps;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

public class AirMapCalloutManager extends ViewGroupManager<AirMapCallout> {
    public String getName() {
        return "AIRMapCallout";
    }

    public AirMapCallout createViewInstance(ThemedReactContext themedReactContext) {
        return new AirMapCallout(themedReactContext);
    }

    @ReactProp(defaultBoolean = false, name = "tooltip")
    public void setTooltip(AirMapCallout airMapCallout, boolean z) {
        airMapCallout.setTooltip(z);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("onPress", MapBuilder.of("registrationName", "onPress"));
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new SizeReportingShadowNode();
    }

    public void updateExtraData(AirMapCallout airMapCallout, Object obj) {
        Map map = (Map) obj;
        float floatValue = ((Float) map.get("width")).floatValue();
        obj = ((Float) map.get("height")).floatValue();
        airMapCallout.width = (int) floatValue;
        airMapCallout.height = (int) obj;
    }
}
