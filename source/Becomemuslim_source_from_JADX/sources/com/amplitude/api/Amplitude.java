package com.amplitude.api;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class Amplitude {
    static final Map<String, AmplitudeClient> instances = new HashMap();

    @Deprecated
    public static void endSession() {
    }

    @Deprecated
    public static void startSession() {
    }

    public static AmplitudeClient getInstance() {
        return getInstance(null);
    }

    public static synchronized AmplitudeClient getInstance(String str) {
        AmplitudeClient amplitudeClient;
        synchronized (Amplitude.class) {
            str = Utils.normalizeInstanceName(str);
            amplitudeClient = (AmplitudeClient) instances.get(str);
            if (amplitudeClient == null) {
                amplitudeClient = new AmplitudeClient(str);
                instances.put(str, amplitudeClient);
            }
        }
        return amplitudeClient;
    }

    @Deprecated
    public static void initialize(Context context, String str) {
        getInstance().initialize(context, str);
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2) {
        getInstance().initialize(context, str, str2);
    }

    @Deprecated
    public static void enableNewDeviceIdPerInstall(boolean z) {
        getInstance().enableNewDeviceIdPerInstall(z);
    }

    @Deprecated
    public static void useAdvertisingIdForDeviceId() {
        getInstance().useAdvertisingIdForDeviceId();
    }

    @Deprecated
    public static void enableLocationListening() {
        getInstance().enableLocationListening();
    }

    @Deprecated
    public static void disableLocationListening() {
        getInstance().disableLocationListening();
    }

    @Deprecated
    public static void setSessionTimeoutMillis(long j) {
        getInstance().setSessionTimeoutMillis(j);
    }

    @Deprecated
    public static void setOptOut(boolean z) {
        getInstance().setOptOut(z);
    }

    @Deprecated
    public static void logEvent(String str) {
        getInstance().logEvent(str);
    }

    @Deprecated
    public static void logEvent(String str, JSONObject jSONObject) {
        getInstance().logEvent(str, jSONObject);
    }

    @Deprecated
    public static void uploadEvents() {
        getInstance().uploadEvents();
    }

    @Deprecated
    public static void logRevenue(double d) {
        getInstance().logRevenue(d);
    }

    @Deprecated
    public static void logRevenue(String str, int i, double d) {
        getInstance().logRevenue(str, i, d);
    }

    @Deprecated
    public static void logRevenue(String str, int i, double d, String str2, String str3) {
        getInstance().logRevenue(str, i, d, str2, str3);
    }

    @Deprecated
    public static void setUserProperties(JSONObject jSONObject) {
        getInstance().setUserProperties(jSONObject);
    }

    @Deprecated
    public static void setUserProperties(JSONObject jSONObject, boolean z) {
        getInstance().setUserProperties(jSONObject, z);
    }

    @Deprecated
    public static void setUserId(String str) {
        getInstance().setUserId(str);
    }

    @Deprecated
    public static String getDeviceId() {
        return getInstance().getDeviceId();
    }
}
