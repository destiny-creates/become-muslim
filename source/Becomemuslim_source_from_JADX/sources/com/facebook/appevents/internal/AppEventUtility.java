package com.facebook.appevents.internal;

import android.os.Build;
import android.os.Looper;
import com.facebook.share.internal.MessengerShareContentUtility;

public class AppEventUtility {
    private static final String regex = "[-+]*\\d+([\\,\\.]\\d+)*([\\.\\,]\\d+)?";

    public static void assertIsMainThread() {
    }

    public static void assertIsNotMainThread() {
    }

    public static double normalizePrice(java.lang.String r4) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = 0;
        r2 = "[-+]*\\d+([\\,\\.]\\d+)*([\\.\\,]\\d+)?";	 Catch:{ ParseException -> 0x002b }
        r3 = 8;	 Catch:{ ParseException -> 0x002b }
        r2 = java.util.regex.Pattern.compile(r2, r3);	 Catch:{ ParseException -> 0x002b }
        r4 = r2.matcher(r4);	 Catch:{ ParseException -> 0x002b }
        r2 = r4.find();	 Catch:{ ParseException -> 0x002b }
        if (r2 == 0) goto L_0x002a;	 Catch:{ ParseException -> 0x002b }
    L_0x0014:
        r2 = 0;	 Catch:{ ParseException -> 0x002b }
        r4 = r4.group(r2);	 Catch:{ ParseException -> 0x002b }
        r2 = com.facebook.internal.Utility.getCurrentLocale();	 Catch:{ ParseException -> 0x002b }
        r2 = java.text.NumberFormat.getNumberInstance(r2);	 Catch:{ ParseException -> 0x002b }
        r4 = r2.parse(r4);	 Catch:{ ParseException -> 0x002b }
        r2 = r4.doubleValue();	 Catch:{ ParseException -> 0x002b }
        return r2;
    L_0x002a:
        return r0;
    L_0x002b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.AppEventUtility.normalizePrice(java.lang.String):double");
    }

    public static String bytesToHex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString();
    }

    public static boolean isEmulator() {
        if (!(Build.FINGERPRINT.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) && Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)))) {
            if (!"google_sdk".equals(Build.PRODUCT)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static java.lang.String getAppVersion() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = com.facebook.FacebookSdk.getApplicationContext();
        r1 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0014 }
        r0 = r0.getPackageName();	 Catch:{ NameNotFoundException -> 0x0014 }
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x0014 }
        r0 = r1.getPackageInfo(r0, r2);	 Catch:{ NameNotFoundException -> 0x0014 }
        r0 = r0.versionName;	 Catch:{ NameNotFoundException -> 0x0014 }
        return r0;
    L_0x0014:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.AppEventUtility.getAppVersion():java.lang.String");
    }
}
