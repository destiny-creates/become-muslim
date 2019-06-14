package versioned.host.exp.exponent.modules.api;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p339f.p340a.C6327b;
import versioned.host.exp.exponent.ReadableObjectUtils;
import versioned.host.exp.exponent.modules.ExpoBaseModule;

public class ErrorRecoveryModule extends ExpoBaseModule {
    public String getName() {
        return "ExponentErrorRecovery";
    }

    public ErrorRecoveryModule(ReactApplicationContext reactApplicationContext, C6330b c6330b) {
        super(reactApplicationContext, c6330b);
    }

    @ReactMethod
    public void setRecoveryProps(ReadableMap readableMap) {
        C6327b.m26024a(this.experienceId).m26027a(ReadableObjectUtils.readableToJson(readableMap));
    }
}
