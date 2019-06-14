package versioned.host.exp.exponent.modules.api.fbads;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

public class NativeAdViewManager extends ViewGroupManager<NativeAdView> {
    private static String NAME = "CTKNativeAd";

    public String getName() {
        return NAME;
    }

    protected NativeAdView createViewInstance(ThemedReactContext themedReactContext) {
        return new NativeAdView(themedReactContext);
    }

    @ReactProp(name = "adsManager")
    public void setAdsManager(NativeAdView nativeAdView, String str) {
        Context context = nativeAdView.getContext();
        if (context instanceof ReactContext) {
            nativeAdView.setNativeAd(((NativeAdManager) ((ReactContext) context).getNativeModule(NativeAdManager.class)).getFBAdsManager(str).nextNativeAd());
        } else {
            Log.e("E_NOT_RCT_CONTEXT", "View's context is not a ReactContext, so it's not possible to get NativeAdManager.");
        }
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("onAdLoaded", MapBuilder.of("registrationName", "onAdLoaded"), "onAdFailed", MapBuilder.of("registrationName", "onAdFailed"));
    }

    public void addView(NativeAdView nativeAdView, View view, int i) {
        nativeAdView.addView(view, i);
    }

    public int getChildCount(NativeAdView nativeAdView) {
        return nativeAdView.getChildCount();
    }

    public View getChildAt(NativeAdView nativeAdView, int i) {
        return nativeAdView.getChildAt(i);
    }

    public void removeViewAt(NativeAdView nativeAdView, int i) {
        nativeAdView.removeViewAt(i);
    }
}
