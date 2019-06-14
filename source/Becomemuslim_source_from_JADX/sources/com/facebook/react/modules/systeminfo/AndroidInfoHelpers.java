package com.facebook.react.modules.systeminfo;

import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Locale;

public class AndroidInfoHelpers {
    public static int DEBUG_SERVER_HOST_PORT = 8081;
    public static String DEVICE_LOCALHOST = "localhost";
    public static String EMULATOR_LOCALHOST = "10.0.2.2";
    public static String GENYMOTION_LOCALHOST = "10.0.3.2";
    public static int INSPECTOR_PROXY_PORT = 8082;

    private static boolean isRunningOnGenymotion() {
        return Build.FINGERPRINT.contains("vbox");
    }

    private static boolean isRunningOnStockEmulator() {
        return Build.FINGERPRINT.contains(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE);
    }

    public static String getServerHost() {
        return getServerIpAddress(DEBUG_SERVER_HOST_PORT);
    }

    public static String getInspectorProxyHost() {
        return getServerIpAddress(INSPECTOR_PROXY_PORT);
    }

    public static String getFriendlyDeviceName() {
        if (isRunningOnGenymotion()) {
            return Build.MODEL;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.MODEL);
        stringBuilder.append(" - ");
        stringBuilder.append(VERSION.RELEASE);
        stringBuilder.append(" - API ");
        stringBuilder.append(VERSION.SDK_INT);
        return stringBuilder.toString();
    }

    private static String getServerIpAddress(int i) {
        String str;
        if (isRunningOnGenymotion()) {
            str = GENYMOTION_LOCALHOST;
        } else if (isRunningOnStockEmulator()) {
            str = EMULATOR_LOCALHOST;
        } else {
            str = DEVICE_LOCALHOST;
        }
        return String.format(Locale.US, "%s:%d", new Object[]{str, Integer.valueOf(i)});
    }
}
