package com.facebook.ads.internal.p093h;

import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.stetho.server.http.HttpStatus;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.h.d */
public class C1389d {
    /* renamed from: c */
    private static final String f4041c = "d";
    /* renamed from: d */
    private static final AdPlacementType f4042d = AdPlacementType.UNKNOWN;
    /* renamed from: a */
    public int f4043a = -1;
    /* renamed from: b */
    public int f4044b = -1;
    /* renamed from: e */
    private final long f4045e = System.currentTimeMillis();
    /* renamed from: f */
    private AdPlacementType f4046f = f4042d;
    /* renamed from: g */
    private int f4047g = 1;
    /* renamed from: h */
    private int f4048h = 0;
    /* renamed from: i */
    private int f4049i = 0;
    /* renamed from: j */
    private int f4050j = 20;
    /* renamed from: k */
    private int f4051k = 0;
    /* renamed from: l */
    private int f4052l = 1000;
    /* renamed from: m */
    private int f4053m = 10000;
    /* renamed from: n */
    private int f4054n = HttpStatus.HTTP_OK;
    /* renamed from: o */
    private int f4055o = 3600;
    /* renamed from: p */
    private boolean f4056p = false;
    /* renamed from: q */
    private List<C1387b> f4057q = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C1389d(java.util.Map<java.lang.String, java.lang.String> r11) {
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
        r10 = this;
        r10.<init>();
        r0 = -1;
        r10.f4043a = r0;
        r10.f4044b = r0;
        r1 = f4042d;
        r10.f4046f = r1;
        r1 = 1;
        r10.f4047g = r1;
        r2 = 0;
        r10.f4048h = r2;
        r10.f4049i = r2;
        r3 = 20;
        r10.f4050j = r3;
        r10.f4051k = r2;
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r10.f4052l = r3;
        r3 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r10.f4053m = r3;
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r10.f4054n = r3;
        r4 = 3600; // 0xe10 float:5.045E-42 double:1.7786E-320;
        r10.f4055o = r4;
        r10.f4056p = r2;
        r4 = 0;
        r10.f4057q = r4;
        r4 = java.lang.System.currentTimeMillis();
        r10.f4045e = r4;
        r11 = r11.entrySet();
        r11 = r11.iterator();
    L_0x003d:
        r4 = r11.hasNext();
        if (r4 == 0) goto L_0x0236;
    L_0x0043:
        r4 = r11.next();
        r4 = (java.util.Map.Entry) r4;
        r5 = r4.getKey();
        r5 = (java.lang.String) r5;
        r6 = r5.hashCode();
        switch(r6) {
            case -1899431321: goto L_0x00e3;
            case -1561601017: goto L_0x00d9;
            case -856794442: goto L_0x00ce;
            case -726276175: goto L_0x00c3;
            case -634541425: goto L_0x00b9;
            case -553208868: goto L_0x00af;
            case 3575610: goto L_0x00a5;
            case 700812481: goto L_0x009b;
            case 858630459: goto L_0x0091;
            case 986744879: goto L_0x0086;
            case 1085444827: goto L_0x007b;
            case 1183549815: goto L_0x006f;
            case 1503616961: goto L_0x0063;
            case 2002133996: goto L_0x0058;
            default: goto L_0x0056;
        };
    L_0x0056:
        goto L_0x00ee;
    L_0x0058:
        r6 = "placement_width";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x00ee;
    L_0x0060:
        r5 = 7;
        goto L_0x00ef;
    L_0x0063:
        r6 = "placement_height";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x00ee;
    L_0x006b:
        r5 = 8;
        goto L_0x00ef;
    L_0x006f:
        r6 = "viewability_check_initial_delay";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x00ee;
    L_0x0077:
        r5 = 9;
        goto L_0x00ef;
    L_0x007b:
        r6 = "refresh";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x00ee;
    L_0x0083:
        r5 = 3;
        goto L_0x00ef;
    L_0x0086:
        r6 = "video_time_polling_interval";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x00ee;
    L_0x008e:
        r5 = 13;
        goto L_0x00ef;
    L_0x0091:
        r6 = "viewability_check_ticker";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x00ee;
    L_0x0099:
        r5 = 2;
        goto L_0x00ef;
    L_0x009b:
        r6 = "min_viewability_percentage";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x00ee;
    L_0x00a3:
        r5 = 1;
        goto L_0x00ef;
    L_0x00a5:
        r6 = "type";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x00ee;
    L_0x00ad:
        r5 = 0;
        goto L_0x00ef;
    L_0x00af:
        r6 = "cacheable";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x00ee;
    L_0x00b7:
        r5 = 6;
        goto L_0x00ef;
    L_0x00b9:
        r6 = "invalidation_duration_in_seconds";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x00ee;
    L_0x00c1:
        r5 = 5;
        goto L_0x00ef;
    L_0x00c3:
        r6 = "request_timeout";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x00ee;
    L_0x00cb:
        r5 = 11;
        goto L_0x00ef;
    L_0x00ce:
        r6 = "viewability_check_interval";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x00ee;
    L_0x00d6:
        r5 = 10;
        goto L_0x00ef;
    L_0x00d9:
        r6 = "refresh_threshold";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x00ee;
    L_0x00e1:
        r5 = 4;
        goto L_0x00ef;
    L_0x00e3:
        r6 = "conv_tracking_data";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x00ee;
    L_0x00eb:
        r5 = 12;
        goto L_0x00ef;
    L_0x00ee:
        r5 = -1;
    L_0x00ef:
        switch(r5) {
            case 0: goto L_0x0228;
            case 1: goto L_0x021a;
            case 2: goto L_0x020c;
            case 3: goto L_0x01fe;
            case 4: goto L_0x01f0;
            case 5: goto L_0x01e2;
            case 6: goto L_0x01d0;
            case 7: goto L_0x01c2;
            case 8: goto L_0x01b4;
            case 9: goto L_0x01a6;
            case 10: goto L_0x0198;
            case 11: goto L_0x018a;
            case 12: goto L_0x0106;
            case 13: goto L_0x00f4;
            default: goto L_0x00f2;
        };
    L_0x00f2:
        goto L_0x003d;
    L_0x00f4:
        r4 = r4.getValue();	 Catch:{ NumberFormatException -> 0x0102 }
        r4 = (java.lang.String) r4;	 Catch:{ NumberFormatException -> 0x0102 }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ NumberFormatException -> 0x0102 }
        r10.f4054n = r4;	 Catch:{ NumberFormatException -> 0x0102 }
        goto L_0x003d;
    L_0x0102:
        r10.f4054n = r3;
        goto L_0x003d;
    L_0x0106:
        r4 = r4.getValue();
        r4 = (java.lang.String) r4;
        r4 = com.facebook.ads.internal.p093h.C1387b.m4756a(r4);
        r10.f4057q = r4;
        r4 = android.webkit.CookieManager.getInstance();	 Catch:{ Exception -> 0x0180 }
        r5 = r4.acceptCookie();	 Catch:{ Exception -> 0x0180 }
        r4.setAcceptCookie(r1);	 Catch:{ Exception -> 0x0180 }
        r6 = r10.f4057q;	 Catch:{ Exception -> 0x0180 }
        r6 = r6.iterator();	 Catch:{ Exception -> 0x0180 }
    L_0x0123:
        r7 = r6.hasNext();	 Catch:{ Exception -> 0x0180 }
        if (r7 == 0) goto L_0x016e;	 Catch:{ Exception -> 0x0180 }
    L_0x0129:
        r7 = r6.next();	 Catch:{ Exception -> 0x0180 }
        r7 = (com.facebook.ads.internal.p093h.C1387b) r7;	 Catch:{ Exception -> 0x0180 }
        r8 = r7.m4758b();	 Catch:{ Exception -> 0x0180 }
        if (r8 == 0) goto L_0x0123;	 Catch:{ Exception -> 0x0180 }
    L_0x0135:
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0180 }
        r8.<init>();	 Catch:{ Exception -> 0x0180 }
        r9 = r7.f4033b;	 Catch:{ Exception -> 0x0180 }
        r8.append(r9);	 Catch:{ Exception -> 0x0180 }
        r9 = "=";	 Catch:{ Exception -> 0x0180 }
        r8.append(r9);	 Catch:{ Exception -> 0x0180 }
        r9 = r7.f4034c;	 Catch:{ Exception -> 0x0180 }
        r8.append(r9);	 Catch:{ Exception -> 0x0180 }
        r9 = ";Domain=";	 Catch:{ Exception -> 0x0180 }
        r8.append(r9);	 Catch:{ Exception -> 0x0180 }
        r9 = r7.f4032a;	 Catch:{ Exception -> 0x0180 }
        r8.append(r9);	 Catch:{ Exception -> 0x0180 }
        r9 = ";Expires=";	 Catch:{ Exception -> 0x0180 }
        r8.append(r9);	 Catch:{ Exception -> 0x0180 }
        r9 = r7.m4757a();	 Catch:{ Exception -> 0x0180 }
        r8.append(r9);	 Catch:{ Exception -> 0x0180 }
        r9 = ";path=/";	 Catch:{ Exception -> 0x0180 }
        r8.append(r9);	 Catch:{ Exception -> 0x0180 }
        r8 = r8.toString();	 Catch:{ Exception -> 0x0180 }
        r7 = r7.f4032a;	 Catch:{ Exception -> 0x0180 }
        r4.setCookie(r7, r8);	 Catch:{ Exception -> 0x0180 }
        goto L_0x0123;	 Catch:{ Exception -> 0x0180 }
    L_0x016e:
        r6 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0180 }
        r7 = 21;	 Catch:{ Exception -> 0x0180 }
        if (r6 >= r7) goto L_0x017b;	 Catch:{ Exception -> 0x0180 }
    L_0x0174:
        r6 = android.webkit.CookieSyncManager.getInstance();	 Catch:{ Exception -> 0x0180 }
        r6.startSync();	 Catch:{ Exception -> 0x0180 }
    L_0x017b:
        r4.setAcceptCookie(r5);	 Catch:{ Exception -> 0x0180 }
        goto L_0x003d;
    L_0x0180:
        r4 = move-exception;
        r5 = f4041c;
        r6 = "Failed to set cookie.";
        android.util.Log.w(r5, r6, r4);
        goto L_0x003d;
    L_0x018a:
        r4 = r4.getValue();
        r4 = (java.lang.String) r4;
        r4 = java.lang.Integer.parseInt(r4);
        r10.f4053m = r4;
        goto L_0x003d;
    L_0x0198:
        r4 = r4.getValue();
        r4 = (java.lang.String) r4;
        r4 = java.lang.Integer.parseInt(r4);
        r10.f4052l = r4;
        goto L_0x003d;
    L_0x01a6:
        r4 = r4.getValue();
        r4 = (java.lang.String) r4;
        r4 = java.lang.Integer.parseInt(r4);
        r10.f4051k = r4;
        goto L_0x003d;
    L_0x01b4:
        r4 = r4.getValue();
        r4 = (java.lang.String) r4;
        r4 = java.lang.Integer.parseInt(r4);
        r10.f4044b = r4;
        goto L_0x003d;
    L_0x01c2:
        r4 = r4.getValue();
        r4 = (java.lang.String) r4;
        r4 = java.lang.Integer.parseInt(r4);
        r10.f4043a = r4;
        goto L_0x003d;
    L_0x01d0:
        r4 = r4.getValue();
        r4 = (java.lang.String) r4;
        r4 = java.lang.Boolean.valueOf(r4);
        r4 = r4.booleanValue();
        r10.f4056p = r4;
        goto L_0x003d;
    L_0x01e2:
        r4 = r4.getValue();
        r4 = (java.lang.String) r4;
        r4 = java.lang.Integer.parseInt(r4);
        r10.f4055o = r4;
        goto L_0x003d;
    L_0x01f0:
        r4 = r4.getValue();
        r4 = (java.lang.String) r4;
        r4 = java.lang.Integer.parseInt(r4);
        r10.f4050j = r4;
        goto L_0x003d;
    L_0x01fe:
        r4 = r4.getValue();
        r4 = (java.lang.String) r4;
        r4 = java.lang.Integer.parseInt(r4);
        r10.f4049i = r4;
        goto L_0x003d;
    L_0x020c:
        r4 = r4.getValue();
        r4 = (java.lang.String) r4;
        r4 = java.lang.Integer.parseInt(r4);
        r10.f4048h = r4;
        goto L_0x003d;
    L_0x021a:
        r4 = r4.getValue();
        r4 = (java.lang.String) r4;
        r4 = java.lang.Integer.parseInt(r4);
        r10.f4047g = r4;
        goto L_0x003d;
    L_0x0228:
        r4 = r4.getValue();
        r4 = (java.lang.String) r4;
        r4 = com.facebook.ads.internal.protocol.AdPlacementType.fromString(r4);
        r10.f4046f = r4;
        goto L_0x003d;
    L_0x0236:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.h.d.<init>(java.util.Map):void");
    }

    /* renamed from: a */
    public static C1389d m4765a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator keys = jSONObject.keys();
        Map hashMap = new HashMap();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, String.valueOf(jSONObject.opt(str)));
        }
        return new C1389d(hashMap);
    }

    /* renamed from: a */
    public long m4766a() {
        return this.f4045e;
    }

    /* renamed from: b */
    public AdPlacementType m4767b() {
        return this.f4046f;
    }

    /* renamed from: c */
    public long m4768c() {
        return (long) (this.f4049i * 1000);
    }

    /* renamed from: d */
    public long m4769d() {
        return (long) (this.f4050j * 1000);
    }

    /* renamed from: e */
    public boolean m4770e() {
        return this.f4056p;
    }

    /* renamed from: f */
    public int m4771f() {
        return this.f4047g;
    }

    /* renamed from: g */
    public int m4772g() {
        return this.f4048h;
    }

    /* renamed from: h */
    public int m4773h() {
        return this.f4051k;
    }

    /* renamed from: i */
    public int m4774i() {
        return this.f4052l;
    }

    /* renamed from: j */
    public int m4775j() {
        return this.f4053m;
    }

    /* renamed from: k */
    public int m4776k() {
        return this.f4054n;
    }

    /* renamed from: l */
    public int m4777l() {
        return this.f4055o * 1000;
    }
}
