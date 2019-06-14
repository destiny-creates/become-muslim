package com.github.yamill.orientation;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.util.Log;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import java.util.HashMap;
import java.util.Map;

public class OrientationModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    final BroadcastReceiver receiver;

    private String getOrientationString(int i) {
        return i == 2 ? "LANDSCAPE" : i == 1 ? "PORTRAIT" : i == 0 ? "UNKNOWN" : "null";
    }

    public String getName() {
        return "Orientation";
    }

    public void onHostDestroy() {
    }

    public OrientationModule(final ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.receiver = new BroadcastReceiver(this) {
            /* renamed from: b */
            final /* synthetic */ OrientationModule f5045b;

            public void onReceive(Context context, Intent intent) {
                Configuration configuration = (Configuration) intent.getParcelableExtra("newConfig");
                Log.d("receiver", String.valueOf(configuration.orientation));
                context = configuration.orientation == 1 ? "PORTRAIT" : "LANDSCAPE";
                intent = Arguments.createMap();
                intent.putString("orientation", context);
                if (reactApplicationContext.hasActiveCatalystInstance() != null) {
                    ((RCTDeviceEventEmitter) reactApplicationContext.getJSModule(RCTDeviceEventEmitter.class)).emit("orientationDidChange", intent);
                }
            }
        };
        reactApplicationContext.addLifecycleEventListener(this);
    }

    @ReactMethod
    public void getOrientation(Callback callback) {
        if (getOrientationString(getReactApplicationContext().getResources().getConfiguration().orientation) == "null") {
            callback.invoke(Integer.valueOf(getReactApplicationContext().getResources().getConfiguration().orientation), null);
            return;
        }
        callback.invoke(null, getOrientationString(getReactApplicationContext().getResources().getConfiguration().orientation));
    }

    @ReactMethod
    public void lockToPortrait() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.setRequestedOrientation(1);
        }
    }

    @ReactMethod
    public void lockToLandscape() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.setRequestedOrientation(6);
        }
    }

    @ReactMethod
    public void lockToLandscapeLeft() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.setRequestedOrientation(0);
        }
    }

    @ReactMethod
    public void lockToLandscapeRight() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.setRequestedOrientation(8);
        }
    }

    @ReactMethod
    public void unlockAllOrientations() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.setRequestedOrientation(4);
        }
    }

    public Map<String, Object> getConstants() {
        Map hashMap = new HashMap();
        String orientationString = getOrientationString(getReactApplicationContext().getResources().getConfiguration().orientation);
        if (orientationString == "null") {
            hashMap.put("initialOrientation", null);
        } else {
            hashMap.put("initialOrientation", orientationString);
        }
        return hashMap;
    }

    public void onHostResume() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.m5674e(ReactConstants.TAG, "no activity to register receiver");
        } else {
            currentActivity.registerReceiver(this.receiver, new IntentFilter("onConfigurationChanged"));
        }
    }

    public void onHostPause() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            try {
                currentActivity.unregisterReceiver(this.receiver);
            } catch (Throwable e) {
                FLog.m5675e(ReactConstants.TAG, "receiver already unregistered", e);
            }
        }
    }
}
