package versioned.host.exp.exponent.modules.api.fbads;

import com.facebook.ads.AdSize;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

public class BannerViewManager extends SimpleViewManager<BannerView> {
    public String getName() {
        return "CTKBannerView";
    }

    @ReactProp(name = "placementId")
    public void setPlacementId(BannerView bannerView, String str) {
        bannerView.setPlacementId(str);
    }

    @ReactProp(name = "size")
    public void setSize(BannerView bannerView, int i) {
        if (i != 90) {
            if (i == 250) {
                i = AdSize.RECTANGLE_HEIGHT_250;
            }
            i = AdSize.BANNER_HEIGHT_50;
        } else {
            i = AdSize.BANNER_HEIGHT_90;
        }
        bannerView.setSize(i);
    }

    protected BannerView createViewInstance(ThemedReactContext themedReactContext) {
        return new BannerView(themedReactContext);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("onAdPress", MapBuilder.of("registrationName", "onAdPress"), "onAdError", MapBuilder.of("registrationName", "onAdError"), "onLoggingImpression", MapBuilder.of("registrationName", "onLoggingImpression"));
    }
}
