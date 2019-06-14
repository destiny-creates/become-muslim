package com.google.android.gms.ads.internal.gmsg;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.internal.ads.azm;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.lw;
import com.google.android.gms.internal.ads.pn;
import com.google.android.gms.internal.ads.pu;
import com.google.android.gms.internal.ads.pv;
import com.google.android.gms.internal.ads.qo;
import com.google.android.gms.internal.ads.rk;
import com.google.android.gms.internal.ads.ru;
import java.util.HashMap;
import java.util.Map;

@cm
/* renamed from: com.google.android.gms.ads.internal.gmsg.o */
public final class C2653o {
    /* renamed from: a */
    public static final ae<qo> f6877a = C4275p.f11304a;
    /* renamed from: b */
    public static final ae<qo> f6878b = C4276q.f11305a;
    /* renamed from: c */
    public static final ae<qo> f6879c = C4277r.f11306a;
    /* renamed from: d */
    public static final ae<qo> f6880d = new C4282w();
    /* renamed from: e */
    public static final ae<qo> f6881e = new C4283x();
    /* renamed from: f */
    public static final ae<qo> f6882f = C4278s.f11307a;
    /* renamed from: g */
    public static final ae<Object> f6883g = new C4284y();
    /* renamed from: h */
    public static final ae<qo> f6884h = new C4285z();
    /* renamed from: i */
    public static final ae<qo> f6885i = C4279t.f11308a;
    /* renamed from: j */
    public static final ae<qo> f6886j = new aa();
    /* renamed from: k */
    public static final ae<qo> f6887k = new ab();
    /* renamed from: l */
    public static final ae<pn> f6888l = new pu();
    /* renamed from: m */
    public static final ae<pn> f6889m = new pv();
    /* renamed from: n */
    public static final ae<qo> f6890n = new C4274n();
    /* renamed from: o */
    public static final C4271g f6891o = new C4271g();
    /* renamed from: p */
    public static final ae<qo> f6892p = new ac();
    /* renamed from: q */
    public static final ae<qo> f6893q = new ad();
    /* renamed from: r */
    public static final ae<qo> f6894r = new C4281v();
    /* renamed from: s */
    private static final ae<Object> f6895s = new C4280u();

    /* renamed from: a */
    static final /* synthetic */ void m7536a(com.google.android.gms.internal.ads.azm r5, java.util.Map r6) {
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
        r0 = "u";
        r6 = r6.get(r0);
        r6 = (java.lang.String) r6;
        if (r6 != 0) goto L_0x0010;
    L_0x000a:
        r5 = "URL missing from click GMSG.";
        com.google.android.gms.internal.ads.jn.e(r5);
        return;
    L_0x0010:
        r0 = android.net.Uri.parse(r6);
        r1 = r5;	 Catch:{ ahj -> 0x003e }
        r1 = (com.google.android.gms.internal.ads.rs) r1;	 Catch:{ ahj -> 0x003e }
        r1 = r1.y();	 Catch:{ ahj -> 0x003e }
        if (r1 == 0) goto L_0x0058;	 Catch:{ ahj -> 0x003e }
    L_0x001d:
        r2 = r1.a(r0);	 Catch:{ ahj -> 0x003e }
        if (r2 == 0) goto L_0x0058;	 Catch:{ ahj -> 0x003e }
    L_0x0023:
        r2 = r5;	 Catch:{ ahj -> 0x003e }
        r2 = (com.google.android.gms.internal.ads.rk) r2;	 Catch:{ ahj -> 0x003e }
        r2 = r2.getContext();	 Catch:{ ahj -> 0x003e }
        r3 = r5;	 Catch:{ ahj -> 0x003e }
        r3 = (com.google.android.gms.internal.ads.rv) r3;	 Catch:{ ahj -> 0x003e }
        r3 = r3.getView();	 Catch:{ ahj -> 0x003e }
        r4 = r5;	 Catch:{ ahj -> 0x003e }
        r4 = (com.google.android.gms.internal.ads.rk) r4;	 Catch:{ ahj -> 0x003e }
        r4 = r4.d();	 Catch:{ ahj -> 0x003e }
        r1 = r1.a(r0, r2, r3, r4);	 Catch:{ ahj -> 0x003e }
        r0 = r1;
        goto L_0x0058;
        r1 = "Unable to append parameter to URL: ";
        r6 = java.lang.String.valueOf(r6);
        r2 = r6.length();
        if (r2 == 0) goto L_0x0050;
    L_0x004b:
        r6 = r1.concat(r6);
        goto L_0x0055;
    L_0x0050:
        r6 = new java.lang.String;
        r6.<init>(r1);
    L_0x0055:
        com.google.android.gms.internal.ads.jn.e(r6);
    L_0x0058:
        r6 = r5;
        r6 = (com.google.android.gms.internal.ads.rk) r6;
        r1 = r6.getContext();
        r0 = com.google.android.gms.internal.ads.im.a(r0, r1);
        r0 = r0.toString();
        r1 = new com.google.android.gms.internal.ads.lw;
        r6 = r6.getContext();
        r5 = (com.google.android.gms.internal.ads.ru) r5;
        r5 = r5.k();
        r5 = r5.f28709a;
        r1.<init>(r6, r5, r0);
        r1.h();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.o.a(com.google.android.gms.internal.ads.azm, java.util.Map):void");
    }

    /* renamed from: a */
    static final /* synthetic */ void m7537a(rk rkVar, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            jn.e("URL missing from httpTrack GMSG.");
        } else {
            new lw(rkVar.getContext(), ((ru) rkVar).k().f28709a, str).h();
        }
    }

    /* renamed from: a */
    static final /* synthetic */ void m7538a(com.google.android.gms.internal.ads.rs r3, java.util.Map r4) {
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
        r0 = "tx";
        r0 = r4.get(r0);
        r0 = (java.lang.String) r0;
        r1 = "ty";
        r1 = r4.get(r1);
        r1 = (java.lang.String) r1;
        r2 = "td";
        r4 = r4.get(r2);
        r4 = (java.lang.String) r4;
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0032 }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x0032 }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ NumberFormatException -> 0x0032 }
        r3 = r3.y();	 Catch:{ NumberFormatException -> 0x0032 }
        if (r3 == 0) goto L_0x0031;	 Catch:{ NumberFormatException -> 0x0032 }
    L_0x002a:
        r3 = r3.a();	 Catch:{ NumberFormatException -> 0x0032 }
        r3.a(r0, r1, r4);	 Catch:{ NumberFormatException -> 0x0032 }
    L_0x0031:
        return;
    L_0x0032:
        r3 = "Could not parse touch parameters from gmsg.";
        com.google.android.gms.internal.ads.jn.e(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.o.a(com.google.android.gms.internal.ads.rs, java.util.Map):void");
    }

    /* renamed from: b */
    static final /* synthetic */ void m7539b(com.google.android.gms.internal.ads.rk r17, java.util.Map r18) {
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
        r0 = r17.getContext();
        r2 = r0.getPackageManager();
        r0 = "data";
        r3 = r18;
        r0 = r3.get(r0);
        r0 = (java.lang.String) r0;
        r3 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x010e }
        r3.<init>(r0);	 Catch:{ JSONException -> 0x010e }
        r0 = "intents";	 Catch:{ JSONException -> 0x00ff }
        r3 = r3.getJSONArray(r0);	 Catch:{ JSONException -> 0x00ff }
        r4 = new org.json.JSONObject;
        r4.<init>();
        r5 = 0;
        r6 = 0;
    L_0x0024:
        r0 = r3.length();
        if (r6 >= r0) goto L_0x00f5;
    L_0x002a:
        r0 = r3.getJSONObject(r6);	 Catch:{ JSONException -> 0x00ea }
        r7 = "id";
        r7 = r0.optString(r7);
        r8 = "u";
        r8 = r0.optString(r8);
        r9 = "i";
        r9 = r0.optString(r9);
        r10 = "m";
        r10 = r0.optString(r10);
        r11 = "p";
        r11 = r0.optString(r11);
        r12 = "c";
        r12 = r0.optString(r12);
        r13 = "f";
        r0.optString(r13);
        r13 = "e";
        r0.optString(r13);
        r13 = "intent_url";
        r13 = r0.optString(r13);
        r14 = 0;
        r0 = android.text.TextUtils.isEmpty(r13);
        if (r0 != 0) goto L_0x008b;
    L_0x0069:
        r0 = android.content.Intent.parseUri(r13, r5);	 Catch:{ URISyntaxException -> 0x006f }
        r14 = r0;
        goto L_0x008b;
    L_0x006f:
        r0 = move-exception;
        r15 = r0;
        r0 = "Error parsing the url: ";
        r13 = java.lang.String.valueOf(r13);
        r16 = r13.length();
        if (r16 == 0) goto L_0x0082;
    L_0x007d:
        r0 = r0.concat(r13);
        goto L_0x0088;
    L_0x0082:
        r13 = new java.lang.String;
        r13.<init>(r0);
        r0 = r13;
    L_0x0088:
        com.google.android.gms.internal.ads.jn.b(r0, r15);
    L_0x008b:
        r0 = 1;
        if (r14 != 0) goto L_0x00d7;
    L_0x008e:
        r14 = new android.content.Intent;
        r14.<init>();
        r13 = android.text.TextUtils.isEmpty(r8);
        if (r13 != 0) goto L_0x00a0;
    L_0x0099:
        r8 = android.net.Uri.parse(r8);
        r14.setData(r8);
    L_0x00a0:
        r8 = android.text.TextUtils.isEmpty(r9);
        if (r8 != 0) goto L_0x00a9;
    L_0x00a6:
        r14.setAction(r9);
    L_0x00a9:
        r8 = android.text.TextUtils.isEmpty(r10);
        if (r8 != 0) goto L_0x00b2;
    L_0x00af:
        r14.setType(r10);
    L_0x00b2:
        r8 = android.text.TextUtils.isEmpty(r11);
        if (r8 != 0) goto L_0x00bb;
    L_0x00b8:
        r14.setPackage(r11);
    L_0x00bb:
        r8 = android.text.TextUtils.isEmpty(r12);
        if (r8 != 0) goto L_0x00d7;
    L_0x00c1:
        r8 = "/";
        r9 = 2;
        r8 = r12.split(r8, r9);
        r10 = r8.length;
        if (r10 != r9) goto L_0x00d7;
    L_0x00cb:
        r9 = new android.content.ComponentName;
        r10 = r8[r5];
        r8 = r8[r0];
        r9.<init>(r10, r8);
        r14.setComponent(r9);
    L_0x00d7:
        r8 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r8 = r2.resolveActivity(r14, r8);
        if (r8 == 0) goto L_0x00e0;
    L_0x00df:
        goto L_0x00e1;
    L_0x00e0:
        r0 = 0;
    L_0x00e1:
        r4.put(r7, r0);	 Catch:{ JSONException -> 0x00e5 }
        goto L_0x00f1;
    L_0x00e5:
        r0 = move-exception;
        r7 = r0;
        r0 = "Error constructing openable urls response.";
        goto L_0x00ee;
    L_0x00ea:
        r0 = move-exception;
        r7 = r0;
        r0 = "Error parsing the intent data.";
    L_0x00ee:
        com.google.android.gms.internal.ads.jn.b(r0, r7);
    L_0x00f1:
        r6 = r6 + 1;
        goto L_0x0024;
    L_0x00f5:
        r0 = r17;
        r0 = (com.google.android.gms.internal.ads.azm) r0;
        r1 = "openableIntents";
        r0.a(r1, r4);
        return;
    L_0x00ff:
        r0 = r17;
        r0 = (com.google.android.gms.internal.ads.azm) r0;
        r1 = "openableIntents";
        r2 = new org.json.JSONObject;
        r2.<init>();
        r0.a(r1, r2);
        return;
    L_0x010e:
        r0 = r17;
        r0 = (com.google.android.gms.internal.ads.azm) r0;
        r1 = "openableIntents";
        r2 = new org.json.JSONObject;
        r2.<init>();
        r0.a(r1, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.gmsg.o.b(com.google.android.gms.internal.ads.rk, java.util.Map):void");
    }

    /* renamed from: c */
    static final /* synthetic */ void m7540c(rk rkVar, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            jn.e("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        Map hashMap = new HashMap();
        PackageManager packageManager = rkVar.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) == null) {
                z = false;
            }
            hashMap.put(str2, Boolean.valueOf(z));
        }
        ((azm) rkVar).a("openableURLs", hashMap);
    }
}
