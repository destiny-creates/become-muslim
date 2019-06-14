package com.facebook.react.modules.systeminfo;

import android.app.UiModeManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "PlatformConstants")
public class AndroidInfoModule extends ReactContextBaseJavaModule {
    private static final String IS_TESTING = "IS_TESTING";

    public String getName() {
        return "PlatformConstants";
    }

    public AndroidInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private String uiMode() {
        int currentModeType = ((UiModeManager) getReactApplicationContext().getSystemService("uimode")).getCurrentModeType();
        if (currentModeType == 6) {
            return "watch";
        }
        switch (currentModeType) {
            case 1:
                return "normal";
            case 2:
                return "desk";
            case 3:
                return "car";
            case 4:
                return "tv";
            default:
                return "unknown";
        }
    }

    public Map<String, Object> getConstants() {
        Map hashMap = new HashMap();
        hashMap.put("Version", Integer.valueOf(VERSION.SDK_INT));
        hashMap.put("Release", VERSION.RELEASE);
        hashMap.put("Serial", Build.SERIAL);
        hashMap.put("Fingerprint", Build.FINGERPRINT);
        hashMap.put("Model", Build.MODEL);
        hashMap.put("ServerHost", AndroidInfoHelpers.getServerHost());
        hashMap.put("isTesting", Boolean.valueOf(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(System.getProperty(IS_TESTING))));
        hashMap.put("reactNativeVersion", ReactNativeVersion.VERSION);
        hashMap.put("uiMode", uiMode());
        hashMap.put("androidID", Secure.getString(getReactApplicationContext().getContentResolver(), "android_id"));
        return hashMap;
    }
}
