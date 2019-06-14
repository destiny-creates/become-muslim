package versioned.host.exp.exponent.modules.api.fbads;

import android.util.Log;
import com.facebook.ads.AdSettings;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class AdSettingsManager extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private static final String TAG = "versioned.host.exp.exponent.modules.api.fbads.AdSettingsManager";
    private boolean mIsChildDirected = false;
    private String mMediationService = null;
    private HashSet<String> mTestDeviceHashes = new HashSet();
    private String mUrlPrefix = null;

    public String getName() {
        return "CTKAdSettingsManager";
    }

    public AdSettingsManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    @ReactMethod
    public void addTestDevice(String str) {
        AdSettings.addTestDevice(str);
        this.mTestDeviceHashes.add(str);
    }

    @ReactMethod
    public void clearTestDevices() {
        AdSettings.clearTestDevices();
        this.mTestDeviceHashes.clear();
    }

    @ReactMethod
    public void setLogLevel(String str) {
        Log.w(TAG, "This method is not supported on Android");
    }

    @ReactMethod
    public void setIsChildDirected(boolean z) {
        AdSettings.setIsChildDirected(z);
        this.mIsChildDirected = z;
    }

    @ReactMethod
    public void setMediationService(String str) {
        AdSettings.setMediationService(str);
        this.mMediationService = str;
    }

    @ReactMethod
    public void setUrlPrefix(String str) {
        AdSettings.setUrlPrefix(str);
        this.mUrlPrefix = str;
    }

    private void restoreSettings() {
        Iterator it = this.mTestDeviceHashes.iterator();
        while (it.hasNext()) {
            AdSettings.addTestDevice((String) it.next());
        }
        AdSettings.setIsChildDirected(this.mIsChildDirected);
        AdSettings.setMediationService(this.mMediationService);
        AdSettings.setUrlPrefix(this.mUrlPrefix);
    }

    private void clearSettings() {
        AdSettings.clearTestDevices();
        AdSettings.setIsChildDirected(false);
        AdSettings.setMediationService(null);
        AdSettings.setUrlPrefix(null);
    }

    public void onHostResume() {
        restoreSettings();
    }

    public void onHostPause() {
        clearSettings();
    }

    public void onHostDestroy() {
        clearSettings();
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("currentDeviceHash", getReactApplicationContext().getSharedPreferences("FBAdPrefs", 0).getString("deviceIdHash", null));
        return hashMap;
    }
}
