package com.facebook.react.modules.deviceinfo;

import android.content.Context;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "DeviceInfo")
public class DeviceInfoModule extends BaseJavaModule implements LifecycleEventListener {
    static final String sModuleName = "DeviceInfo";
    private float mFontScale;
    private ReactApplicationContext mReactApplicationContext;

    public String getName() {
        return sModuleName;
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    public DeviceInfoModule(ReactApplicationContext reactApplicationContext) {
        this((Context) reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        this.mReactApplicationContext.addLifecycleEventListener(this);
    }

    public DeviceInfoModule(Context context) {
        this.mReactApplicationContext = null;
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(context);
        this.mFontScale = context.getResources().getConfiguration().fontScale;
    }

    public Map<String, Object> getConstants() {
        Map hashMap = new HashMap();
        hashMap.put("Dimensions", DisplayMetricsHolder.getDisplayMetricsMap((double) this.mFontScale));
        return hashMap;
    }

    public void onHostResume() {
        if (this.mReactApplicationContext != null) {
            float f = this.mReactApplicationContext.getResources().getConfiguration().fontScale;
            if (this.mFontScale != f) {
                this.mFontScale = f;
                emitUpdateDimensionsEvent();
            }
        }
    }

    public void emitUpdateDimensionsEvent() {
        if (this.mReactApplicationContext != null) {
            ((RCTDeviceEventEmitter) this.mReactApplicationContext.getJSModule(RCTDeviceEventEmitter.class)).emit("didUpdateDimensions", DisplayMetricsHolder.getDisplayMetricsNativeMap((double) this.mFontScale));
        }
    }
}
