package com.google.android.gms.internal.ads;

import org.json.JSONObject;

public final /* synthetic */ class azx {
    /* renamed from: a */
    public static void m19177a(azw azw, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + 3) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append("(");
        stringBuilder.append(str2);
        stringBuilder.append(");");
        azw.mo4090b(stringBuilder.toString());
    }

    /* renamed from: a */
    public static void m19178a(com.google.android.gms.internal.ads.azw r1, java.lang.String r2, java.util.Map r3) {
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
        r0 = com.google.android.gms.ads.internal.ax.e();	 Catch:{ JSONException -> 0x000c }
        r3 = r0.m19737a(r3);	 Catch:{ JSONException -> 0x000c }
        r1.mo4089a(r2, r3);
        return;
    L_0x000c:
        r1 = "Could not convert parameters to JSON.";
        com.google.android.gms.internal.ads.mt.m19924e(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.azx.a(com.google.android.gms.internal.ads.azw, java.lang.String, java.util.Map):void");
    }

    /* renamed from: a */
    public static void m19179a(azw azw, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        azw.mo6649a(str, jSONObject.toString());
    }

    /* renamed from: b */
    public static void m19180b(azw azw, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(window.AFMA_ReceiveMessage || function() {})('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        str = "Dispatching AFMA event: ";
        jSONObject2 = String.valueOf(stringBuilder.toString());
        mt.m19918b(jSONObject2.length() != 0 ? str.concat(jSONObject2) : new String(str));
        azw.mo4090b(stringBuilder.toString());
    }
}
