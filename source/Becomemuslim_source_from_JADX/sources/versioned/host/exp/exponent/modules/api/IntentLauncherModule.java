package versioned.host.exp.exponent.modules.api;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

public class IntentLauncherModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private Promise pendingPromise;

    public String getName() {
        return "ExponentIntentLauncher";
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    public IntentLauncherModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    @ReactMethod
    public void startActivity(String str, ReadableMap readableMap, String str2, Promise promise) {
        if (this.pendingPromise != null) {
            this.pendingPromise.reject("ERR_INTERRUPTED", "A new activity was started");
            this.pendingPromise = null;
        }
        if (str != null) {
            if (!str.isEmpty()) {
                try {
                    Activity currentActivity = getCurrentActivity();
                    Intent intent = new Intent(str);
                    if (readableMap != null) {
                        intent.putExtras(Arguments.toBundle(readableMap));
                    }
                    if (str2 != null && str2.isEmpty() == null) {
                        intent.setData(Uri.parse(str2));
                    }
                    if (currentActivity != null) {
                        currentActivity.startActivity(intent);
                    } else {
                        intent.addFlags(268435456);
                        getReactApplicationContext().startActivity(intent);
                    }
                    this.pendingPromise = promise;
                } catch (String str3) {
                    promise.reject("ERR_LAUNCHING_ACTIVITY", str3);
                }
                return;
            }
        }
        promise.reject("ERR_EMPTY_ACTIVITY", "Specified activity was empty");
    }

    private void onReturn() {
        if (this.pendingPromise != null) {
            this.pendingPromise.resolve(Boolean.valueOf(true));
            this.pendingPromise = null;
        }
    }

    public void onHostResume() {
        onReturn();
    }
}
