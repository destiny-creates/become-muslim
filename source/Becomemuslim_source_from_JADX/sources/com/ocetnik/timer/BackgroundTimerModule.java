package com.ocetnik.timer;

import android.os.Handler;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;

public class BackgroundTimerModule extends ReactContextBaseJavaModule {
    private Handler handler;
    private ReactContext reactContext;
    private Runnable runnable;

    /* renamed from: com.ocetnik.timer.BackgroundTimerModule$1 */
    class C54341 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ BackgroundTimerModule f18233a;

        C54341(BackgroundTimerModule backgroundTimerModule) {
            this.f18233a = backgroundTimerModule;
        }

        public void run() {
            this.f18233a.sendEvent(this.f18233a.reactContext, "backgroundTimer");
        }
    }

    public String getName() {
        return "RNBackgroundTimer";
    }

    public BackgroundTimerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod
    public void start(int i) {
        this.handler = new Handler();
        this.runnable = new C54341(this);
        this.handler.post(this.runnable);
    }

    @ReactMethod
    public void stop() {
        if (this.handler != null) {
            this.handler.removeCallbacks(this.runnable);
        }
    }

    private void sendEvent(ReactContext reactContext, String str) {
        ((RCTDeviceEventEmitter) reactContext.getJSModule(RCTDeviceEventEmitter.class)).emit(str, null);
    }

    @ReactMethod
    public void setTimeout(final int i, int i2) {
        new Handler().postDelayed(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ BackgroundTimerModule f18235b;

            public void run() {
                if (this.f18235b.getReactApplicationContext().hasActiveCatalystInstance()) {
                    ((RCTDeviceEventEmitter) this.f18235b.getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("backgroundTimer.timeout", Integer.valueOf(i));
                }
            }
        }, (long) i2);
    }
}
