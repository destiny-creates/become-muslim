package com.facebook.react.common;

import android.text.TextUtils;
import com.facebook.common.logging.FLog;
import com.facebook.react.devsupport.StackTraceHelper;
import org.json.JSONObject;

public class DebugServerException extends RuntimeException {
    private static final String GENERIC_ERROR_MESSAGE = "\n\nTry the following to fix the issue:\n• Ensure that the packager server is running\n• Ensure that your device/emulator is connected to your machine and has USB debugging enabled - run 'adb devices' to see a list of connected devices\n• Ensure Airplane Mode is disabled\n• If you're on a physical device connected to the same machine, run 'adb reverse tcp:8081 tcp:8081' to forward requests from your device\n• If your device is on the same Wi-Fi network, set 'Debug server host & port for device' in 'Dev settings' to your machine's IP address and the port of the local dev server - e.g. 10.0.1.1:8081\n\n";

    public static DebugServerException makeGeneric(String str, Throwable th) {
        return makeGeneric(str, "", th);
    }

    public static DebugServerException makeGeneric(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(GENERIC_ERROR_MESSAGE);
        stringBuilder.append(str2);
        return new DebugServerException(stringBuilder.toString(), th);
    }

    private DebugServerException(String str, String str2, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("\n  at ");
        stringBuilder.append(str2);
        stringBuilder.append(":");
        stringBuilder.append(i);
        stringBuilder.append(":");
        stringBuilder.append(i2);
        super(stringBuilder.toString());
    }

    public DebugServerException(String str) {
        super(str);
    }

    public DebugServerException(String str, Throwable th) {
        super(str, th);
    }

    public static DebugServerException parse(String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String string2;
            JSONObject jSONObject = new JSONObject(str);
            string = jSONObject.getString("filename");
            if (jSONObject.has("description")) {
                string2 = jSONObject.getString("description");
            } else {
                string2 = jSONObject.getJSONArray("errors").getJSONObject(0).getString("description");
            }
            return new DebugServerException(string2, shortenFileName(string), jSONObject.getInt(StackTraceHelper.LINE_NUMBER_KEY), jSONObject.getInt(StackTraceHelper.COLUMN_KEY));
        } catch (Throwable e) {
            string = ReactConstants.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not parse DebugServerException from: ");
            stringBuilder.append(str);
            FLog.m5715w(string, stringBuilder.toString(), e);
            return null;
        }
    }

    private static String shortenFileName(String str) {
        str = str.split("/");
        return str[str.length - 1];
    }
}
