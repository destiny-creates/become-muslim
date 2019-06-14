package com.facebook.ads.internal.p094i;

import android.os.Build;
import com.facebook.share.internal.MessengerShareContentUtility;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.i.b */
class C1392b {
    /* renamed from: a */
    private static final String f4066a = "b";

    C1392b() {
    }

    /* renamed from: a */
    static String m4780a() {
        JSONObject jSONObject = new JSONObject();
        C1392b.m4781a(jSONObject, "is_emu", String.valueOf(C1392b.m4782b()));
        return jSONObject.toString();
    }

    /* renamed from: a */
    private static void m4781a(org.json.JSONObject r0, java.lang.String r1, java.lang.String r2) {
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
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0003 }
    L_0x0003:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.i.b.a(org.json.JSONObject, java.lang.String, java.lang.String):void");
    }

    /* renamed from: b */
    private static boolean m4782b() {
        if (!(Build.FINGERPRINT.contains(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) && Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)))) {
            if (!"google_sdk".equals(Build.PRODUCT)) {
                return false;
            }
        }
        return true;
    }
}
