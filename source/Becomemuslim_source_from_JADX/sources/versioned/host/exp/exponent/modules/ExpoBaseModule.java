package versioned.host.exp.exponent.modules;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import host.exp.exponent.p339f.C6330b;

public abstract class ExpoBaseModule extends ReactContextBaseJavaModule {
    protected final C6330b experienceId;

    public ExpoBaseModule(ReactApplicationContext reactApplicationContext, C6330b c6330b) {
        super(reactApplicationContext);
        this.experienceId = c6330b;
    }
}
