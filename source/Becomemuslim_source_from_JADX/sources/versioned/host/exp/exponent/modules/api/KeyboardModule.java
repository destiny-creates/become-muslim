package versioned.host.exp.exponent.modules.api;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class KeyboardModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "ExponentKeyboard";
    }

    public KeyboardModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void hideAsync(Promise promise) {
        Object valueOf = Boolean.valueOf(false);
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) currentActivity.getSystemService("input_method");
            View currentFocus = currentActivity.getCurrentFocus();
            if (currentFocus != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                valueOf = Boolean.valueOf(true);
            }
        }
        promise.resolve(valueOf);
    }
}
