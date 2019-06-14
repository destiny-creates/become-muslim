package versioned.host.exp.exponent.modules.api;

import android.hardware.SensorManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.common.ShakeDetector;
import com.facebook.react.common.ShakeDetector.ShakeListener;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import host.exp.exponent.p334a.C6289b;

public class ShakeModule extends ReactContextBaseJavaModule {
    private static final String TAG = "ShakeModule";
    private ShakeDetector mShakeDetector = new ShakeDetector(new C77491());

    /* renamed from: versioned.host.exp.exponent.modules.api.ShakeModule$1 */
    class C77491 implements ShakeListener {
        C77491() {
        }

        public void onShake() {
            ShakeModule.this.onShake();
        }
    }

    public String getName() {
        return "ExponentShake";
    }

    public ShakeModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mShakeDetector.start((SensorManager) reactApplicationContext.getSystemService("sensor"));
    }

    private void onShake() {
        try {
            ((RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("Exponent.shake", null);
        } catch (Throwable th) {
            C6289b.m25950a(TAG, th);
        }
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        this.mShakeDetector.stop();
    }
}
