package com.learnium.RNDeviceInfo;

import android.app.KeyguardManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.format.DateFormat;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import com.facebook.places.model.PlaceFields;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Locale;

public class RNDeviceModule extends ReactContextBaseJavaModule {
    ReactApplicationContext reactContext;
    WifiInfo wifiInfo;

    public String getName() {
        return "RNDeviceInfo";
    }

    public RNDeviceModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    private WifiInfo getWifiInfo() {
        if (this.wifiInfo == null) {
            this.wifiInfo = ((WifiManager) this.reactContext.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        }
        return this.wifiInfo;
    }

    private String getCurrentLanguage() {
        Locale locale = getReactApplicationContext().getResources().getConfiguration().locale;
        if (VERSION.SDK_INT >= 21) {
            return locale.toLanguageTag();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage());
        if (locale.getCountry() != null) {
            stringBuilder.append("-");
            stringBuilder.append(locale.getCountry());
        }
        return stringBuilder.toString();
    }

    private String getCurrentCountry() {
        return getReactApplicationContext().getResources().getConfiguration().locale.getCountry();
    }

    private Boolean isEmulator() {
        boolean z;
        if (!(Build.FINGERPRINT.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) && Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)))) {
            if (!"google_sdk".equals(Build.PRODUCT)) {
                z = false;
                return Boolean.valueOf(z);
            }
        }
        z = true;
        return Boolean.valueOf(z);
    }

    private Boolean isTablet() {
        int i = getReactApplicationContext().getResources().getConfiguration().screenLayout & 15;
        if (i != 3 && i != 4) {
            return Boolean.valueOf(false);
        }
        DisplayMetrics displayMetrics = getReactApplicationContext().getResources().getDisplayMetrics();
        if (!(displayMetrics.densityDpi == 160 || displayMetrics.densityDpi == 240 || displayMetrics.densityDpi == 160 || displayMetrics.densityDpi == 213)) {
            if (displayMetrics.densityDpi != 320) {
                return Boolean.valueOf(false);
            }
        }
        return Boolean.valueOf(true);
    }

    private float fontScale() {
        return getReactApplicationContext().getResources().getConfiguration().fontScale;
    }

    private Boolean is24Hour() {
        return Boolean.valueOf(DateFormat.is24HourFormat(this.reactContext.getApplicationContext()));
    }

    @ReactMethod
    public void isPinOrFingerprintSet(Callback callback) {
        callback.invoke(new Object[]{Boolean.valueOf(((KeyguardManager) this.reactContext.getApplicationContext().getSystemService("keyguard")).isKeyguardSecure())});
    }

    @ReactMethod
    public void getIpAddress(Promise promise) {
        promise.resolve(Formatter.formatIpAddress(getWifiInfo().getIpAddress()));
    }

    @com.facebook.react.bridge.ReactMethod
    public void getMacAddress(com.facebook.react.bridge.Promise r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = r10.getWifiInfo();
        r0 = r0.getMacAddress();
        r1 = "android.permission.INTERNET";
        r2 = r10.reactContext;
        r1 = r2.checkCallingOrSelfPermission(r1);
        if (r1 != 0) goto L_0x0075;
    L_0x0012:
        r1 = java.net.NetworkInterface.getNetworkInterfaces();	 Catch:{ Exception -> 0x0075 }
        r1 = java.util.Collections.list(r1);	 Catch:{ Exception -> 0x0075 }
        r1 = r1.iterator();	 Catch:{ Exception -> 0x0075 }
    L_0x001e:
        r2 = r1.hasNext();	 Catch:{ Exception -> 0x0075 }
        if (r2 == 0) goto L_0x0075;	 Catch:{ Exception -> 0x0075 }
    L_0x0024:
        r2 = r1.next();	 Catch:{ Exception -> 0x0075 }
        r2 = (java.net.NetworkInterface) r2;	 Catch:{ Exception -> 0x0075 }
        r3 = r2.getName();	 Catch:{ Exception -> 0x0075 }
        r4 = "wlan0";	 Catch:{ Exception -> 0x0075 }
        r3 = r3.equalsIgnoreCase(r4);	 Catch:{ Exception -> 0x0075 }
        if (r3 != 0) goto L_0x0037;	 Catch:{ Exception -> 0x0075 }
    L_0x0036:
        goto L_0x001e;	 Catch:{ Exception -> 0x0075 }
    L_0x0037:
        r2 = r2.getHardwareAddress();	 Catch:{ Exception -> 0x0075 }
        if (r2 != 0) goto L_0x0041;	 Catch:{ Exception -> 0x0075 }
    L_0x003d:
        r2 = "";	 Catch:{ Exception -> 0x0075 }
    L_0x003f:
        r0 = r2;	 Catch:{ Exception -> 0x0075 }
        goto L_0x001e;	 Catch:{ Exception -> 0x0075 }
    L_0x0041:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0075 }
        r3.<init>();	 Catch:{ Exception -> 0x0075 }
        r4 = r2.length;	 Catch:{ Exception -> 0x0075 }
        r5 = 0;	 Catch:{ Exception -> 0x0075 }
        r6 = 0;	 Catch:{ Exception -> 0x0075 }
    L_0x0049:
        r7 = 1;	 Catch:{ Exception -> 0x0075 }
        if (r6 >= r4) goto L_0x0062;	 Catch:{ Exception -> 0x0075 }
    L_0x004c:
        r8 = r2[r6];	 Catch:{ Exception -> 0x0075 }
        r9 = "%02X:";	 Catch:{ Exception -> 0x0075 }
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0075 }
        r8 = java.lang.Byte.valueOf(r8);	 Catch:{ Exception -> 0x0075 }
        r7[r5] = r8;	 Catch:{ Exception -> 0x0075 }
        r7 = java.lang.String.format(r9, r7);	 Catch:{ Exception -> 0x0075 }
        r3.append(r7);	 Catch:{ Exception -> 0x0075 }
        r6 = r6 + 1;	 Catch:{ Exception -> 0x0075 }
        goto L_0x0049;	 Catch:{ Exception -> 0x0075 }
    L_0x0062:
        r2 = r3.length();	 Catch:{ Exception -> 0x0075 }
        if (r2 <= 0) goto L_0x0070;	 Catch:{ Exception -> 0x0075 }
    L_0x0068:
        r2 = r3.length();	 Catch:{ Exception -> 0x0075 }
        r2 = r2 - r7;	 Catch:{ Exception -> 0x0075 }
        r3.deleteCharAt(r2);	 Catch:{ Exception -> 0x0075 }
    L_0x0070:
        r2 = r3.toString();	 Catch:{ Exception -> 0x0075 }
        goto L_0x003f;
    L_0x0075:
        r11.resolve(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.learnium.RNDeviceInfo.RNDeviceModule.getMacAddress(com.facebook.react.bridge.Promise):void");
    }

    @ReactMethod
    public String getCarrier() {
        return ((TelephonyManager) this.reactContext.getSystemService(PlaceFields.PHONE)).getNetworkOperatorName();
    }

    @ReactMethod
    public Integer getTotalDiskCapacity() {
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            return Integer.valueOf(statFs.getBlockCount() * statFs.getBlockSize());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ReactMethod
    public Integer getFreeDiskStorage() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            return Integer.valueOf(statFs.getAvailableBlocks() * statFs.getBlockSize());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ReactMethod
    public void getBatteryLevel(Promise promise) {
        Intent registerReceiver = this.reactContext.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        promise.resolve(Float.valueOf(((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1))));
    }

    public String getInstallReferrer() {
        return getReactApplicationContext().getSharedPreferences("react-native-device-info", 0).getString("installReferrer", null);
    }

    public java.util.Map<java.lang.String, java.lang.Object> getConstants() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = r8.reactContext;
        r1 = r1.getPackageManager();
        r2 = r8.reactContext;
        r2 = r2.getPackageName();
        r3 = r1.getInstallerPackageName(r2);
        r4 = "appVersion";
        r5 = "not available";
        r0.put(r4, r5);
        r4 = "appName";
        r5 = "not available";
        r0.put(r4, r5);
        r4 = "buildVersion";
        r5 = "not available";
        r0.put(r4, r5);
        r4 = "buildNumber";
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r5);
        r0.put(r4, r6);
        r1.getPackageInfo(r2, r5);	 Catch:{ NameNotFoundException -> 0x007d }
        r1 = r1.getPackageInfo(r2, r5);	 Catch:{ NameNotFoundException -> 0x007d }
        r4 = r8.reactContext;	 Catch:{ NameNotFoundException -> 0x007d }
        r4 = r4.getApplicationInfo();	 Catch:{ NameNotFoundException -> 0x007d }
        r5 = r8.reactContext;	 Catch:{ NameNotFoundException -> 0x007d }
        r5 = r5.getPackageManager();	 Catch:{ NameNotFoundException -> 0x007d }
        r4 = r4.loadLabel(r5);	 Catch:{ NameNotFoundException -> 0x007d }
        r4 = r4.toString();	 Catch:{ NameNotFoundException -> 0x007d }
        r5 = "appVersion";	 Catch:{ NameNotFoundException -> 0x007d }
        r6 = r1.versionName;	 Catch:{ NameNotFoundException -> 0x007d }
        r0.put(r5, r6);	 Catch:{ NameNotFoundException -> 0x007d }
        r5 = "buildNumber";	 Catch:{ NameNotFoundException -> 0x007d }
        r6 = r1.versionCode;	 Catch:{ NameNotFoundException -> 0x007d }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ NameNotFoundException -> 0x007d }
        r0.put(r5, r6);	 Catch:{ NameNotFoundException -> 0x007d }
        r5 = "firstInstallTime";	 Catch:{ NameNotFoundException -> 0x007d }
        r6 = r1.firstInstallTime;	 Catch:{ NameNotFoundException -> 0x007d }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ NameNotFoundException -> 0x007d }
        r0.put(r5, r6);	 Catch:{ NameNotFoundException -> 0x007d }
        r5 = "lastUpdateTime";	 Catch:{ NameNotFoundException -> 0x007d }
        r6 = r1.lastUpdateTime;	 Catch:{ NameNotFoundException -> 0x007d }
        r1 = java.lang.Long.valueOf(r6);	 Catch:{ NameNotFoundException -> 0x007d }
        r0.put(r5, r1);	 Catch:{ NameNotFoundException -> 0x007d }
        r1 = "appName";	 Catch:{ NameNotFoundException -> 0x007d }
        r0.put(r1, r4);	 Catch:{ NameNotFoundException -> 0x007d }
        goto L_0x0081;
    L_0x007d:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x0081:
        r1 = "Unknown";
        r4 = "android.permission.BLUETOOTH";
        r5 = r8.reactContext;
        r4 = r5.checkCallingOrSelfPermission(r4);
        if (r4 != 0) goto L_0x009d;
    L_0x008d:
        r4 = android.bluetooth.BluetoothAdapter.getDefaultAdapter();	 Catch:{ Exception -> 0x0099 }
        if (r4 == 0) goto L_0x009d;	 Catch:{ Exception -> 0x0099 }
    L_0x0093:
        r4 = r4.getName();	 Catch:{ Exception -> 0x0099 }
        r1 = r4;
        goto L_0x009d;
    L_0x0099:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x009d:
        r4 = "com.google.android.gms.iid.a";	 Catch:{ ClassNotFoundException -> 0x00b5 }
        r4 = java.lang.Class.forName(r4);	 Catch:{ ClassNotFoundException -> 0x00b5 }
        if (r4 == 0) goto L_0x00bc;	 Catch:{ ClassNotFoundException -> 0x00b5 }
    L_0x00a5:
        r4 = "instanceId";	 Catch:{ ClassNotFoundException -> 0x00b5 }
        r5 = r8.reactContext;	 Catch:{ ClassNotFoundException -> 0x00b5 }
        r5 = com.google.android.gms.iid.C3060a.c(r5);	 Catch:{ ClassNotFoundException -> 0x00b5 }
        r5 = r5.a();	 Catch:{ ClassNotFoundException -> 0x00b5 }
        r0.put(r4, r5);	 Catch:{ ClassNotFoundException -> 0x00b5 }
        goto L_0x00bc;
    L_0x00b5:
        r4 = "instanceId";
        r5 = "N/A: Add com.google.android.gms:play-services-gcm to your project.";
        r0.put(r4, r5);
    L_0x00bc:
        r4 = "serialNumber";
        r5 = android.os.Build.SERIAL;
        r0.put(r4, r5);
        r4 = "deviceName";
        r0.put(r4, r1);
        r1 = "systemName";
        r4 = "Android";
        r0.put(r1, r4);
        r1 = "systemVersion";
        r4 = android.os.Build.VERSION.RELEASE;
        r0.put(r1, r4);
        r1 = "model";
        r4 = android.os.Build.MODEL;
        r0.put(r1, r4);
        r1 = "brand";
        r4 = android.os.Build.BRAND;
        r0.put(r1, r4);
        r1 = "deviceId";
        r4 = android.os.Build.BOARD;
        r0.put(r1, r4);
        r1 = "apiLevel";
        r4 = android.os.Build.VERSION.SDK_INT;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r1, r4);
        r1 = "deviceLocale";
        r4 = r8.getCurrentLanguage();
        r0.put(r1, r4);
        r1 = "deviceCountry";
        r4 = r8.getCurrentCountry();
        r0.put(r1, r4);
        r1 = "uniqueId";
        r4 = r8.reactContext;
        r4 = r4.getContentResolver();
        r5 = "android_id";
        r4 = android.provider.Settings.Secure.getString(r4, r5);
        r0.put(r1, r4);
        r1 = "systemManufacturer";
        r4 = android.os.Build.MANUFACTURER;
        r0.put(r1, r4);
        r1 = "bundleId";
        r0.put(r1, r2);
        r1 = "installerPackageName";
        r0.put(r1, r3);
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 17;
        if (r1 < r2) goto L_0x0147;
    L_0x0130:
        r1 = "userAgent";	 Catch:{ RuntimeException -> 0x013c }
        r2 = r8.reactContext;	 Catch:{ RuntimeException -> 0x013c }
        r2 = android.webkit.WebSettings.getDefaultUserAgent(r2);	 Catch:{ RuntimeException -> 0x013c }
        r0.put(r1, r2);	 Catch:{ RuntimeException -> 0x013c }
        goto L_0x0147;
    L_0x013c:
        r1 = "userAgent";
        r2 = "http.agent";
        r2 = java.lang.System.getProperty(r2);
        r0.put(r1, r2);
    L_0x0147:
        r1 = "timezone";
        r2 = java.util.TimeZone.getDefault();
        r2 = r2.getID();
        r0.put(r1, r2);
        r1 = "isEmulator";
        r2 = r8.isEmulator();
        r0.put(r1, r2);
        r1 = "isTablet";
        r2 = r8.isTablet();
        r0.put(r1, r2);
        r1 = "fontScale";
        r2 = r8.fontScale();
        r2 = java.lang.Float.valueOf(r2);
        r0.put(r1, r2);
        r1 = "is24Hour";
        r2 = r8.is24Hour();
        r0.put(r1, r2);
        r1 = r8.getCurrentActivity();
        if (r1 == 0) goto L_0x01bd;
    L_0x0182:
        r1 = r8.getCurrentActivity();
        r2 = "android.permission.READ_PHONE_STATE";
        r1 = r1.checkCallingOrSelfPermission(r2);
        if (r1 == 0) goto L_0x01a6;
    L_0x018e:
        r1 = r8.getCurrentActivity();
        r2 = "android.permission.READ_SMS";
        r1 = r1.checkCallingOrSelfPermission(r2);
        if (r1 == 0) goto L_0x01a6;
    L_0x019a:
        r1 = r8.getCurrentActivity();
        r2 = "android.permission.READ_PHONE_NUMBERS";
        r1 = r1.checkCallingOrSelfPermission(r2);
        if (r1 != 0) goto L_0x01bd;
    L_0x01a6:
        r1 = r8.reactContext;
        r1 = r1.getApplicationContext();
        r2 = "phone";
        r1 = r1.getSystemService(r2);
        r1 = (android.telephony.TelephonyManager) r1;
        r2 = "phoneNumber";
        r1 = r1.getLine1Number();
        r0.put(r2, r1);
    L_0x01bd:
        r1 = "carrier";
        r2 = r8.getCarrier();
        r0.put(r1, r2);
        r1 = "totalDiskCapacity";
        r2 = r8.getTotalDiskCapacity();
        r0.put(r1, r2);
        r1 = "freeDiskStorage";
        r2 = r8.getFreeDiskStorage();
        r0.put(r1, r2);
        r1 = "installReferrer";
        r2 = r8.getInstallReferrer();
        r0.put(r1, r2);
        r1 = java.lang.Runtime.getRuntime();
        r2 = "maxMemory";
        r3 = r1.maxMemory();
        r1 = java.lang.Long.valueOf(r3);
        r0.put(r2, r1);
        r1 = r8.reactContext;
        r2 = "activity";
        r1 = r1.getSystemService(r2);
        r1 = (android.app.ActivityManager) r1;
        r2 = new android.app.ActivityManager$MemoryInfo;
        r2.<init>();
        r1.getMemoryInfo(r2);
        r1 = "totalMemory";
        r2 = r2.totalMem;
        r2 = java.lang.Long.valueOf(r2);
        r0.put(r1, r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.learnium.RNDeviceInfo.RNDeviceModule.getConstants():java.util.Map<java.lang.String, java.lang.Object>");
    }
}
