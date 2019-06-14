package versioned.host.exp.exponent.modules.api;

import android.app.Activity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class KeepAwakeModule extends ReactContextBaseJavaModule {
    private boolean mIsActivated = null;

    public String getName() {
        return "ExponentKeepAwake";
    }

    public KeepAwakeModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void activate() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.runOnUiThread(new Runnable() {
                public void run() {
                    currentActivity.getWindow().addFlags(128);
                    KeepAwakeModule.this.mIsActivated = true;
                }
            });
        }
    }

    @ReactMethod
    public void deactivate() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.runOnUiThread(new Runnable() {
                public void run() {
                    KeepAwakeModule.this.mIsActivated = false;
                    currentActivity.getWindow().clearFlags(128);
                }
            });
        }
    }

    public boolean isActivated() {
        return this.mIsActivated;
    }
}
