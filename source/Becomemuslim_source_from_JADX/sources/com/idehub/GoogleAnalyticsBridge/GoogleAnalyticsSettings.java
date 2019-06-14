package com.idehub.GoogleAnalyticsBridge;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.google.android.gms.analytics.C4746d;

public class GoogleAnalyticsSettings extends ReactContextBaseJavaModule {
    public String getName() {
        return "GoogleAnalyticsSettings";
    }

    public GoogleAnalyticsSettings(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    synchronized C4746d getAnalyticsInstance() {
        return C4746d.a(getReactApplicationContext());
    }

    @ReactMethod
    public void setDryRun(Boolean bool) {
        C4746d analyticsInstance = getAnalyticsInstance();
        if (analyticsInstance != null) {
            analyticsInstance.a(bool.booleanValue());
        }
    }

    @ReactMethod
    public void setDispatchInterval(Integer num) {
        C4746d analyticsInstance = getAnalyticsInstance();
        if (analyticsInstance != null) {
            analyticsInstance.a(num.intValue());
        }
    }

    @ReactMethod
    public void setOptOut(Boolean bool) {
        C4746d analyticsInstance = getAnalyticsInstance();
        if (analyticsInstance != null) {
            analyticsInstance.b(bool.booleanValue());
        }
    }
}
