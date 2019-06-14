package versioned.host.exp.exponent.modules.api;

import android.app.Activity;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.view.WindowManager.LayoutParams;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class BrightnessModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "ExponentBrightness";
    }

    public BrightnessModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void setBrightnessAsync(final float f, final Promise promise) {
        final Activity currentActivity = getCurrentActivity();
        currentActivity.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    LayoutParams attributes = currentActivity.getWindow().getAttributes();
                    attributes.screenBrightness = f;
                    currentActivity.getWindow().setAttributes(attributes);
                    promise.resolve(null);
                } catch (Exception e) {
                    promise.reject("E_BRIGHTNESS", e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void getBrightnessAsync(Promise promise) {
        promise.resolve(Float.valueOf(getCurrentActivity().getWindow().getAttributes().screenBrightness));
    }

    @ReactMethod
    public void getSystemBrightnessAsync(Promise promise) {
        promise.resolve(Float.valueOf(((float) Integer.parseInt(System.getString(getCurrentActivity().getContentResolver(), "screen_brightness"))) / 255.0f));
    }

    @ReactMethod
    public void setSystemBrightnessAsync(float f, Promise promise) {
        try {
            if ((VERSION.SDK_INT < 23 || !System.canWrite(getCurrentActivity())) && VERSION.SDK_INT >= 23) {
                promise.reject("E_BRIGHTNESS_PERMISSIONS", "WRITE_SETTINGS not granted");
                return;
            }
            System.putInt(getCurrentActivity().getContentResolver(), "screen_brightness_mode", 0);
            System.putInt(getCurrentActivity().getContentResolver(), "screen_brightness", Math.round(f * 255.0f));
            promise.resolve(0.0f);
        } catch (float f2) {
            promise.reject("E_BRIGHTNESS", f2.getMessage());
        }
    }
}
