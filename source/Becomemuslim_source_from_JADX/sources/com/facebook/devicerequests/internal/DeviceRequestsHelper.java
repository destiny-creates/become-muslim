package com.facebook.devicerequests.internal;

import android.annotation.TargetApi;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.RegistrationListener;
import android.net.nsd.NsdServiceInfo;
import android.os.Build.VERSION;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import java.util.HashMap;

public class DeviceRequestsHelper {
    static final String DEVICE_INFO_DEVICE = "device";
    static final String DEVICE_INFO_MODEL = "model";
    public static final String DEVICE_INFO_PARAM = "device_info";
    public static final String DEVICE_TARGET_USER_ID = "target_user_id";
    static final String SDK_FLAVOR = "android";
    static final String SDK_HEADER = "fbsdk";
    static final String SERVICE_TYPE = "_fb._tcp.";
    private static final String TAG = DeviceRequestsHelper.class.getCanonicalName();
    private static HashMap<String, RegistrationListener> deviceRequestsListeners = new HashMap();

    public static java.lang.String getDeviceInfo() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "device";	 Catch:{ JSONException -> 0x0013 }
        r2 = android.os.Build.DEVICE;	 Catch:{ JSONException -> 0x0013 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0013 }
        r1 = "model";	 Catch:{ JSONException -> 0x0013 }
        r2 = android.os.Build.MODEL;	 Catch:{ JSONException -> 0x0013 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0013 }
    L_0x0013:
        r0 = r0.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.devicerequests.internal.DeviceRequestsHelper.getDeviceInfo():java.lang.String");
    }

    public static boolean startAdvertisementService(String str) {
        return isAvailable() ? startAdvertisementServiceImpl(str) : null;
    }

    public static boolean isAvailable() {
        return VERSION.SDK_INT >= 16 && FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.Enabled);
    }

    public static android.graphics.Bitmap generateQRCode(java.lang.String r15) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r5 = new java.util.EnumMap;
        r0 = com.google.p217b.C5309g.class;
        r5.<init>(r0);
        r0 = com.google.p217b.C5309g.f17928f;
        r1 = 2;
        r1 = java.lang.Integer.valueOf(r1);
        r5.put(r0, r1);
        r6 = 0;
        r0 = new com.google.b.k;	 Catch:{ v -> 0x005a }
        r0.<init>();	 Catch:{ v -> 0x005a }
        r2 = com.google.p217b.C5193a.f17500l;	 Catch:{ v -> 0x005a }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ v -> 0x005a }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ v -> 0x005a }
        r1 = r15;	 Catch:{ v -> 0x005a }
        r15 = r0.a(r1, r2, r3, r4, r5);	 Catch:{ v -> 0x005a }
        r14 = r15.g();	 Catch:{ v -> 0x005a }
        r13 = r15.f();	 Catch:{ v -> 0x005a }
        r0 = r14 * r13;	 Catch:{ v -> 0x005a }
        r8 = new int[r0];	 Catch:{ v -> 0x005a }
        r0 = 0;	 Catch:{ v -> 0x005a }
        r1 = 0;	 Catch:{ v -> 0x005a }
    L_0x0030:
        if (r1 >= r14) goto L_0x004b;	 Catch:{ v -> 0x005a }
    L_0x0032:
        r2 = r1 * r13;	 Catch:{ v -> 0x005a }
        r3 = 0;	 Catch:{ v -> 0x005a }
    L_0x0035:
        if (r3 >= r13) goto L_0x0048;	 Catch:{ v -> 0x005a }
    L_0x0037:
        r4 = r2 + r3;	 Catch:{ v -> 0x005a }
        r5 = r15.a(r3, r1);	 Catch:{ v -> 0x005a }
        if (r5 == 0) goto L_0x0042;	 Catch:{ v -> 0x005a }
    L_0x003f:
        r5 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;	 Catch:{ v -> 0x005a }
        goto L_0x0043;	 Catch:{ v -> 0x005a }
    L_0x0042:
        r5 = -1;	 Catch:{ v -> 0x005a }
    L_0x0043:
        r8[r4] = r5;	 Catch:{ v -> 0x005a }
        r3 = r3 + 1;	 Catch:{ v -> 0x005a }
        goto L_0x0035;	 Catch:{ v -> 0x005a }
    L_0x0048:
        r1 = r1 + 1;	 Catch:{ v -> 0x005a }
        goto L_0x0030;	 Catch:{ v -> 0x005a }
    L_0x004b:
        r15 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ v -> 0x005a }
        r15 = android.graphics.Bitmap.createBitmap(r13, r14, r15);	 Catch:{ v -> 0x005a }
        r9 = 0;
        r11 = 0;
        r12 = 0;
        r7 = r15;
        r10 = r13;
        r7.setPixels(r8, r9, r10, r11, r12, r13, r14);	 Catch:{ v -> 0x005b }
        goto L_0x005b;
    L_0x005a:
        r15 = r6;
    L_0x005b:
        return r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.devicerequests.internal.DeviceRequestsHelper.generateQRCode(java.lang.String):android.graphics.Bitmap");
    }

    public static void cleanUpAdvertisementService(String str) {
        cleanUpAdvertisementServiceImpl(str);
    }

    @TargetApi(16)
    private static boolean startAdvertisementServiceImpl(final String str) {
        if (deviceRequestsListeners.containsKey(str)) {
            return true;
        }
        String replace = FacebookSdk.getSdkVersion().replace('.', '|');
        r3 = new Object[3];
        r3[1] = String.format("%s-%s", new Object[]{"android", replace});
        r3[2] = str;
        replace = String.format("%s_%s_%s", r3);
        NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
        nsdServiceInfo.setServiceType(SERVICE_TYPE);
        nsdServiceInfo.setServiceName(replace);
        nsdServiceInfo.setPort(80);
        NsdManager nsdManager = (NsdManager) FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
        RegistrationListener c17421 = new RegistrationListener() {
            public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
            }

            public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
            }

            public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
                if (replace.equals(nsdServiceInfo.getServiceName()) == null) {
                    DeviceRequestsHelper.cleanUpAdvertisementService(str);
                }
            }

            public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
                DeviceRequestsHelper.cleanUpAdvertisementService(str);
            }
        };
        deviceRequestsListeners.put(str, c17421);
        nsdManager.registerService(nsdServiceInfo, 1, c17421);
        return true;
    }

    @TargetApi(16)
    private static void cleanUpAdvertisementServiceImpl(String str) {
        RegistrationListener registrationListener = (RegistrationListener) deviceRequestsListeners.get(str);
        if (registrationListener != null) {
            try {
                ((NsdManager) FacebookSdk.getApplicationContext().getSystemService("servicediscovery")).unregisterService(registrationListener);
            } catch (Exception e) {
                Utility.logd(TAG, e);
            }
            deviceRequestsListeners.remove(str);
        }
    }
}
