package versioned.host.exp.exponent.modules.api;

import com.amplitude.api.AmplitudeClient;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import host.exp.exponent.p334a.C6288a;
import host.exp.exponent.p346j.C6393j;
import versioned.host.exp.exponent.ReadableObjectUtils;

public class AmplitudeModule extends ReactContextBaseJavaModule {
    private AmplitudeClient mClient;
    private C6393j mScopedContext;

    public String getName() {
        return "ExponentAmplitude";
    }

    public AmplitudeModule(ReactApplicationContext reactApplicationContext, C6393j c6393j) {
        super(reactApplicationContext);
        this.mScopedContext = c6393j;
    }

    @ReactMethod
    public void initialize(String str) {
        C6288a.m25947b();
        this.mClient = new AmplitudeClient();
        this.mClient.initialize(this.mScopedContext, str);
    }

    @ReactMethod
    public void setUserId(String str) {
        if (this.mClient != null) {
            this.mClient.setUserId(str);
        }
    }

    @ReactMethod
    public void setUserProperties(ReadableMap readableMap) {
        if (this.mClient != null) {
            this.mClient.setUserProperties(ReadableObjectUtils.readableToJson(readableMap));
        }
    }

    @ReactMethod
    public void clearUserProperties() {
        if (this.mClient != null) {
            this.mClient.clearUserProperties();
        }
    }

    @ReactMethod
    public void logEvent(String str) {
        if (this.mClient != null) {
            this.mClient.logEvent(str);
        }
    }

    @ReactMethod
    public void logEventWithProperties(String str, ReadableMap readableMap) {
        if (this.mClient != null) {
            this.mClient.logEvent(str, ReadableObjectUtils.readableToJson(readableMap));
        }
    }

    @ReactMethod
    public void setGroup(String str, ReadableArray readableArray) {
        if (this.mClient != null) {
            this.mClient.setGroup(str, ReadableObjectUtils.readableToJson(readableArray));
        }
    }
}
