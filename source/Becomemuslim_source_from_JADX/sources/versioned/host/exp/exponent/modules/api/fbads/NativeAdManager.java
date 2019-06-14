package versioned.host.exp.exponent.modules.api.fbads;

import android.util.Log;
import com.facebook.ads.AdError;
import com.facebook.ads.AdIconView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.NativeAdsManager.Listener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NativeAdManager extends ReactContextBaseJavaModule implements Listener {
    private Map<String, NativeAdsManager> mAdsManagers = new HashMap();

    public String getName() {
        return "CTKNativeAdManager";
    }

    public void onAdError(AdError adError) {
    }

    public NativeAdManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void init(final String str, final int i) {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                NativeAdsManager nativeAdsManager = new NativeAdsManager(reactApplicationContext, str, i);
                nativeAdsManager.setListener(NativeAdManager.this);
                NativeAdManager.this.mAdsManagers.put(str, nativeAdsManager);
                nativeAdsManager.loadAds();
            }
        });
    }

    @ReactMethod
    public void disableAutoRefresh(String str) {
        ((NativeAdsManager) this.mAdsManagers.get(str)).disableAutoRefresh();
    }

    @ReactMethod
    public void setMediaCachePolicy(String str, String str2) {
        Log.w("NativeAdManager", "This method is not supported on Android");
    }

    public void onAdsLoaded() {
        WritableMap createMap = Arguments.createMap();
        for (String str : this.mAdsManagers.keySet()) {
            createMap.putBoolean(str, ((NativeAdsManager) this.mAdsManagers.get(str)).isLoaded());
        }
        sendAppEvent("CTKNativeAdsManagersChanged", createMap);
    }

    public NativeAdsManager getFBAdsManager(String str) {
        return (NativeAdsManager) this.mAdsManagers.get(str);
    }

    private void sendAppEvent(String str, Object obj) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext != null) {
            if (reactApplicationContext.hasActiveCatalystInstance()) {
                ((RCTNativeAppEventEmitter) reactApplicationContext.getJSModule(RCTNativeAppEventEmitter.class)).emit(str, obj);
            }
        }
    }

    @ReactMethod
    public void triggerEvent(final int i, final Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    ((NativeAdView) nativeViewHierarchyManager.resolveView(i)).triggerClick();
                    promise.resolve(null);
                } catch (NativeViewHierarchyManager nativeViewHierarchyManager2) {
                    promise.reject("E_CANNOT_CAST", nativeViewHierarchyManager2);
                } catch (NativeViewHierarchyManager nativeViewHierarchyManager22) {
                    promise.reject("E_INVALID_TAG_ERROR", nativeViewHierarchyManager22);
                } catch (NativeViewHierarchyManager nativeViewHierarchyManager222) {
                    promise.reject("E_NO_NATIVE_AD_VIEW", nativeViewHierarchyManager222);
                } catch (NativeViewHierarchyManager nativeViewHierarchyManager2222) {
                    promise.reject("E_AD_REGISTER_ERROR", nativeViewHierarchyManager2222);
                }
            }
        });
    }

    @ReactMethod
    public void registerViewsForInteraction(int i, int i2, int i3, ReadableArray readableArray, Promise promise) {
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final Promise promise2 = promise;
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    (i4 != -1 ? (NativeAdView) nativeViewHierarchyManager.resolveView(i4) : null).registerViewsForInteraction(i5 != -1 ? (MediaView) nativeViewHierarchyManager.resolveView(i5) : null, i6 != -1 ? (AdIconView) nativeViewHierarchyManager.resolveView(i6) : null, new ArrayList());
                    promise2.resolve(null);
                } catch (NativeViewHierarchyManager nativeViewHierarchyManager2) {
                    promise2.reject("E_CANNOT_CAST", nativeViewHierarchyManager2);
                } catch (NativeViewHierarchyManager nativeViewHierarchyManager22) {
                    promise2.reject("E_INVALID_TAG_ERROR", nativeViewHierarchyManager22);
                } catch (NativeViewHierarchyManager nativeViewHierarchyManager222) {
                    promise2.reject("E_NO_NATIVE_AD_VIEW", nativeViewHierarchyManager222);
                } catch (NativeViewHierarchyManager nativeViewHierarchyManager2222) {
                    promise2.reject("E_AD_REGISTER_ERROR", nativeViewHierarchyManager2222);
                }
            }
        });
    }
}
