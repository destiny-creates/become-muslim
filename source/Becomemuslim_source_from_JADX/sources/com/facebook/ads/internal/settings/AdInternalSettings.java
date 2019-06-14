package com.facebook.ads.internal.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

public class AdInternalSettings {
    /* renamed from: a */
    static volatile boolean f4617a = false;
    /* renamed from: b */
    private static final String f4618b = "AdInternalSettings";
    /* renamed from: c */
    private static final Collection<String> f4619c = new HashSet();
    /* renamed from: d */
    private static final Collection<String> f4620d = new HashSet();
    /* renamed from: e */
    private static boolean f4621e;
    /* renamed from: f */
    private static boolean f4622f;
    /* renamed from: g */
    private static String f4623g;
    /* renamed from: h */
    private static String f4624h;
    /* renamed from: i */
    private static String f4625i;
    /* renamed from: j */
    private static boolean f4626j = false;
    /* renamed from: k */
    private static boolean f4627k;
    /* renamed from: l */
    private static boolean f4628l;

    static {
        f4620d.add(ServerProtocol.DIALOG_PARAM_SDK_VERSION);
        f4620d.add("google_sdk");
        f4620d.add("vbox86p");
        f4620d.add("vbox86tp");
    }

    /* renamed from: a */
    private static void m5447a(String str) {
        if (!f4617a) {
            f4617a = true;
            String str2 = f4618b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Test mode device hash: ");
            stringBuilder.append(str);
            Log.d(str2, stringBuilder.toString());
            str2 = f4618b;
            stringBuilder = new StringBuilder();
            stringBuilder.append("When testing your app with Facebook's ad units you must specify the device hashed ID to ensure the delivery of test ads, add the following code before loading an ad: AdSettings.addTestDevice(\"");
            stringBuilder.append(str);
            stringBuilder.append("\");");
            Log.d(str2, stringBuilder.toString());
        }
    }

    public static void addTestDevice(String str) {
        f4619c.add(str);
    }

    public static void addTestDevices(Collection<String> collection) {
        f4619c.addAll(collection);
    }

    public static void clearTestDevices() {
        f4619c.clear();
    }

    public static String getMediationService() {
        return f4624h;
    }

    public static String getUrlPrefix() {
        return f4623g;
    }

    public static boolean isDebugBuild() {
        return f4626j;
    }

    public static boolean isExplicitTestMode() {
        return f4621e;
    }

    public static boolean isTestMode(Context context) {
        if (!(f4626j || isExplicitTestMode())) {
            if (!f4620d.contains(Build.PRODUCT)) {
                if (f4625i == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("FBAdPrefs", 0);
                    f4625i = sharedPreferences.getString("deviceIdHash", null);
                    if (TextUtils.isEmpty(f4625i)) {
                        f4625i = UUID.randomUUID().toString();
                        sharedPreferences.edit().putString("deviceIdHash", f4625i).apply();
                    }
                }
                if (f4619c.contains(f4625i)) {
                    return true;
                }
                m5447a(f4625i);
                return false;
            }
        }
        return true;
    }

    public static boolean isVideoAutoplay() {
        return f4627k;
    }

    public static boolean isVideoAutoplayOnMobile() {
        return f4628l;
    }

    public static boolean isVisibleAnimation() {
        return f4622f;
    }

    public static void setDebugBuild(boolean z) {
        f4626j = z;
    }

    public static void setMediationService(String str) {
        f4624h = str;
    }

    public static void setTestMode(boolean z) {
        f4621e = z;
    }

    public static void setUrlPrefix(String str) {
        f4623g = str;
    }

    public static void setVideoAutoplay(boolean z) {
        f4627k = z;
    }

    public static void setVideoAutoplayOnMobile(boolean z) {
        f4628l = z;
    }

    public static void setVisibleAnimation(boolean z) {
        f4622f = z;
    }
}
