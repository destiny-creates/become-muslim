package com.facebook.react.packagerconnection;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import expolib_v1.com.facebook.infer.annotation.Assertions;

public class PackagerConnectionSettings {
    private static final String PREFS_DEBUG_SERVER_HOST_KEY = "debug_http_host";
    private static final String TAG = "PackagerConnectionSettings";
    private final String mPackageName;
    private final SharedPreferences mPreferences;

    public PackagerConnectionSettings(Context context) {
        this.mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.mPackageName = context.getPackageName();
    }

    public String getDebugServerHost() {
        CharSequence string = this.mPreferences.getString(PREFS_DEBUG_SERVER_HOST_KEY, null);
        if (!TextUtils.isEmpty(string)) {
            return (String) Assertions.assertNotNull(string);
        }
        String serverHost = AndroidInfoHelpers.getServerHost();
        if (serverHost.equals(AndroidInfoHelpers.DEVICE_LOCALHOST)) {
            FLog.m5714w(TAG, "You seem to be running on device. Run 'adb reverse tcp:8081 tcp:8081' to forward the debug server's port to the device.");
        }
        return serverHost;
    }

    public String getInspectorServerHost() {
        return AndroidInfoHelpers.getInspectorProxyHost();
    }

    public String getPackageName() {
        return this.mPackageName;
    }
}
