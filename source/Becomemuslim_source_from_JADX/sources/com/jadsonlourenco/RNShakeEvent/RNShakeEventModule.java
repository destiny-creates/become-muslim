package com.jadsonlourenco.RNShakeEvent;

import android.hardware.SensorManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.p079e.p081b.C1250a;
import com.p079e.p081b.C1250a.C1246a;

public class RNShakeEventModule extends ReactContextBaseJavaModule implements C1246a {
    public String getName() {
        return "RNShakeEvent";
    }

    public RNShakeEventModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        new C1250a(this).a((SensorManager) reactApplicationContext.getSystemService("sensor"));
    }

    public void hearShake() {
        sendEvent(getReactApplicationContext(), "ShakeEvent", null);
    }

    private void sendEvent(ReactContext reactContext, String str, WritableMap writableMap) {
        if (reactContext.hasActiveCatalystInstance()) {
            ((RCTDeviceEventEmitter) reactContext.getJSModule(RCTDeviceEventEmitter.class)).emit(str, writableMap);
        }
    }
}
