package com.facebook.react.modules.vibration;

import android.os.Vibrator;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "Vibration")
public class VibrationModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "Vibration";
    }

    public VibrationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void vibrate(int i) {
        Vibrator vibrator = (Vibrator) getReactApplicationContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate((long) i);
        }
    }

    @ReactMethod
    public void vibrateByPattern(ReadableArray readableArray, int i) {
        long[] jArr = new long[readableArray.size()];
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            jArr[i2] = (long) readableArray.getInt(i2);
        }
        Vibrator vibrator = (Vibrator) getReactApplicationContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(jArr, i);
        }
    }

    @ReactMethod
    public void cancel() {
        Vibrator vibrator = (Vibrator) getReactApplicationContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.cancel();
        }
    }
}
