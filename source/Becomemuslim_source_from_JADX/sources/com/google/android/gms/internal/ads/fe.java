package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.ax;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@cm
public final class fe {
    /* renamed from: A */
    private boolean f15383A = false;
    /* renamed from: B */
    private dr f15384B;
    /* renamed from: C */
    private boolean f15385C = false;
    /* renamed from: D */
    private String f15386D;
    /* renamed from: E */
    private List<String> f15387E;
    /* renamed from: F */
    private boolean f15388F;
    /* renamed from: G */
    private String f15389G;
    /* renamed from: H */
    private ia f15390H;
    /* renamed from: I */
    private boolean f15391I;
    /* renamed from: J */
    private boolean f15392J;
    /* renamed from: K */
    private boolean f15393K;
    /* renamed from: L */
    private boolean f15394L;
    /* renamed from: M */
    private String f15395M;
    /* renamed from: N */
    private final dl f15396N;
    /* renamed from: a */
    private String f15397a;
    /* renamed from: b */
    private String f15398b;
    /* renamed from: c */
    private String f15399c;
    /* renamed from: d */
    private List<String> f15400d;
    /* renamed from: e */
    private String f15401e;
    /* renamed from: f */
    private String f15402f;
    /* renamed from: g */
    private String f15403g;
    /* renamed from: h */
    private List<String> f15404h;
    /* renamed from: i */
    private List<String> f15405i;
    /* renamed from: j */
    private long f15406j = -1;
    /* renamed from: k */
    private boolean f15407k = false;
    /* renamed from: l */
    private final long f15408l = -1;
    /* renamed from: m */
    private List<String> f15409m;
    /* renamed from: n */
    private long f15410n = -1;
    /* renamed from: o */
    private int f15411o = -1;
    /* renamed from: p */
    private boolean f15412p = false;
    /* renamed from: q */
    private boolean f15413q = false;
    /* renamed from: r */
    private boolean f15414r = false;
    /* renamed from: s */
    private boolean f15415s = true;
    /* renamed from: t */
    private boolean f15416t = true;
    /* renamed from: u */
    private String f15417u = "";
    /* renamed from: v */
    private boolean f15418v = false;
    /* renamed from: w */
    private boolean f15419w = false;
    /* renamed from: x */
    private hq f15420x;
    /* renamed from: y */
    private List<String> f15421y;
    /* renamed from: z */
    private List<String> f15422z;

    public fe(dl dlVar, String str) {
        this.f15398b = str;
        this.f15396N = dlVar;
    }

    /* renamed from: a */
    private static String m19409a(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    /* renamed from: b */
    private static long m19410b(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r2, java.lang.String r3) {
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
        r2 = r2.get(r3);
        r2 = (java.util.List) r2;
        if (r2 == 0) goto L_0x004e;
    L_0x0008:
        r0 = r2.isEmpty();
        if (r0 != 0) goto L_0x004e;
    L_0x000e:
        r0 = 0;
        r2 = r2.get(r0);
        r2 = (java.lang.String) r2;
        r0 = java.lang.Float.parseFloat(r2);	 Catch:{ NumberFormatException -> 0x001f }
        r2 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
        r0 = r0 * r2;
        r2 = (long) r0;
        return r2;
    L_0x001f:
        r0 = java.lang.String.valueOf(r3);
        r0 = r0.length();
        r0 = r0 + 36;
        r1 = java.lang.String.valueOf(r2);
        r1 = r1.length();
        r0 = r0 + r1;
        r1 = new java.lang.StringBuilder;
        r1.<init>(r0);
        r0 = "Could not parse float from ";
        r1.append(r0);
        r1.append(r3);
        r3 = " header: ";
        r1.append(r3);
        r1.append(r2);
        r2 = r1.toString();
        com.google.android.gms.internal.ads.mt.m19924e(r2);
    L_0x004e:
        r2 = -1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.fe.b(java.util.Map, java.lang.String):long");
    }

    /* renamed from: c */
    private static List<String> m19411c(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    /* renamed from: d */
    private static boolean m19412d(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (list != null) {
            if (!list.isEmpty()) {
                return Boolean.valueOf((String) list.get(0)).booleanValue();
            }
        }
        return false;
    }

    /* renamed from: a */
    public final dp m19413a(long j, boolean z) {
        String str;
        int i;
        dl dlVar = this.f15396N;
        String str2 = this.f15398b;
        String str3 = this.f15399c;
        List list = this.f15400d;
        List list2 = this.f15404h;
        long j2 = this.f15406j;
        boolean z2 = this.f15407k;
        List list3 = this.f15409m;
        long j3 = this.f15410n;
        int i2 = this.f15411o;
        String str4 = this.f15397a;
        String str5 = this.f15402f;
        String str6 = this.f15403g;
        String str7 = str5;
        boolean z3 = this.f15412p;
        boolean z4 = this.f15413q;
        boolean z5 = this.f15414r;
        boolean z6 = this.f15415s;
        String str8 = this.f15417u;
        boolean z7 = this.f15418v;
        boolean z8 = this.f15419w;
        hq hqVar = this.f15420x;
        List list4 = this.f15421y;
        List list5 = this.f15422z;
        boolean z9 = this.f15383A;
        dr drVar = this.f15384B;
        boolean z10 = this.f15385C;
        String str9 = this.f15386D;
        List list6 = this.f15387E;
        boolean z11 = this.f15388F;
        String str10 = this.f15389G;
        ia iaVar = this.f15390H;
        String str11 = this.f15401e;
        boolean z12 = this.f15416t;
        boolean z13 = this.f15391I;
        boolean z14 = this.f15392J;
        if (z) {
            str = str4;
            i = 2;
        } else {
            str = str4;
            i = 1;
        }
        boolean z15 = z14;
        return new dp(dlVar, str2, str3, list, list2, j2, z2, -1, list3, j3, i2, str, j, str7, str6, z3, z4, z5, z6, false, str8, z7, z8, hqVar, list4, list5, z9, drVar, z10, str9, list6, z11, str10, iaVar, str11, z12, z13, z15, i, r0.f15393K, r0.f15405i, r0.f15394L, r0.f15395M);
    }

    /* renamed from: a */
    public final void m19414a(String str, Map<String, List<String>> map, String str2) {
        this.f15399c = str2;
        m19415a(map);
    }

    /* renamed from: a */
    public final void m19415a(Map<String, List<String>> map) {
        String str;
        this.f15397a = m19409a((Map) map, "X-Afma-Ad-Size");
        this.f15389G = m19409a((Map) map, "X-Afma-Ad-Slot-Size");
        List c = m19411c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.f15400d = c;
        }
        this.f15401e = m19409a((Map) map, "X-Afma-Debug-Signals");
        c = (List) map.get("X-Afma-Debug-Dialog");
        if (!(c == null || c.isEmpty())) {
            this.f15402f = (String) c.get(0);
        }
        c = m19411c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.f15404h = c;
        }
        c = m19411c(map, "X-Afma-Downloaded-Impression-Urls");
        if (c != null) {
            this.f15405i = c;
        }
        long b = m19410b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1) {
            this.f15406j = b;
        }
        this.f15407k |= m19412d(map, "X-Afma-Mediation");
        c = m19411c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.f15409m = c;
        }
        b = m19410b(map, "X-Afma-Refresh-Rate");
        if (b != -1) {
            this.f15410n = b;
        }
        c = (List) map.get("X-Afma-Orientation");
        if (!(c == null || c.isEmpty())) {
            int b2;
            str = (String) c.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                b2 = ax.g().mo4309b();
            } else if ("landscape".equalsIgnoreCase(str)) {
                b2 = ax.g().mo4307a();
            }
            this.f15411o = b2;
        }
        this.f15403g = m19409a((Map) map, "X-Afma-ActiveView");
        c = (List) map.get("X-Afma-Use-HTTPS");
        if (!(c == null || c.isEmpty())) {
            this.f15414r = Boolean.valueOf((String) c.get(0)).booleanValue();
        }
        this.f15412p |= m19412d(map, "X-Afma-Custom-Rendering-Allowed");
        this.f15413q = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(m19409a((Map) map, "X-Afma-Ad-Format"));
        c = (List) map.get("X-Afma-Content-Url-Opted-Out");
        if (!(c == null || c.isEmpty())) {
            this.f15415s = Boolean.valueOf((String) c.get(0)).booleanValue();
        }
        c = (List) map.get("X-Afma-Content-Vertical-Opted-Out");
        if (!(c == null || c.isEmpty())) {
            this.f15416t = Boolean.valueOf((String) c.get(0)).booleanValue();
        }
        c = (List) map.get("X-Afma-Gws-Query-Id");
        if (!(c == null || c.isEmpty())) {
            this.f15417u = (String) c.get(0);
        }
        str = m19409a((Map) map, "X-Afma-Fluid");
        if (str != null && str.equals("height")) {
            this.f15418v = true;
        }
        this.f15419w = "native_express".equals(m19409a((Map) map, "X-Afma-Ad-Format"));
        this.f15420x = hq.m37546a(m19409a((Map) map, "X-Afma-Rewards"));
        if (this.f15421y == null) {
            this.f15421y = m19411c(map, "X-Afma-Reward-Video-Start-Urls");
        }
        if (this.f15422z == null) {
            this.f15422z = m19411c(map, "X-Afma-Reward-Video-Complete-Urls");
        }
        this.f15383A |= m19412d(map, "X-Afma-Use-Displayed-Impression");
        this.f15385C |= m19412d(map, "X-Afma-Auto-Collect-Location");
        this.f15386D = m19409a((Map) map, "Set-Cookie");
        Object a = m19409a((Map) map, "X-Afma-Auto-Protection-Configuration");
        if (a != null) {
            if (!TextUtils.isEmpty(a)) {
                try {
                    this.f15384B = dr.m37459a(new JSONObject(a));
                } catch (Throwable e) {
                    mt.m19921c("Error parsing configuration JSON", e);
                    this.f15384B = new dr();
                }
                c = m19411c(map, "X-Afma-Remote-Ping-Urls");
                if (c != null) {
                    this.f15387E = c;
                }
                a = m19409a((Map) map, "X-Afma-Safe-Browsing");
                if (!TextUtils.isEmpty(a)) {
                    try {
                        this.f15390H = ia.m37548a(new JSONObject(a));
                    } catch (Throwable e2) {
                        mt.m19921c("Error parsing safe browsing header", e2);
                    }
                }
                this.f15388F |= m19412d(map, "X-Afma-Render-In-Browser");
                a = m19409a((Map) map, "X-Afma-Pool");
                if (!TextUtils.isEmpty(a)) {
                    try {
                        this.f15391I = new JSONObject(a).getBoolean("never_pool");
                    } catch (Throwable e22) {
                        mt.m19921c("Error parsing interstitial pool header", e22);
                    }
                }
                this.f15392J = m19412d(map, "X-Afma-Custom-Close-Blocked");
                this.f15393K = m19412d(map, "X-Afma-Enable-Omid");
                this.f15394L = m19412d(map, "X-Afma-Disable-Closable-Area");
                this.f15395M = m19409a((Map) map, "X-Afma-Omid-Settings");
            }
        }
        Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
        buildUpon.appendQueryParameter("id", "gmob-apps-blocked-navigation");
        if (!TextUtils.isEmpty(this.f15402f)) {
            buildUpon.appendQueryParameter("debugDialog", this.f15402f);
        }
        boolean booleanValue = ((Boolean) aph.m18688f().m18889a(asp.f14943g)).booleanValue();
        String[] strArr = new String[1];
        str = buildUpon.toString();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 31);
        stringBuilder.append(str);
        stringBuilder.append("&navigationURL={NAVIGATION_URL}");
        strArr[0] = stringBuilder.toString();
        this.f15384B = new dr(booleanValue, Arrays.asList(strArr));
        c = m19411c(map, "X-Afma-Remote-Ping-Urls");
        if (c != null) {
            this.f15387E = c;
        }
        a = m19409a((Map) map, "X-Afma-Safe-Browsing");
        if (TextUtils.isEmpty(a)) {
            this.f15390H = ia.m37548a(new JSONObject(a));
        }
        this.f15388F |= m19412d(map, "X-Afma-Render-In-Browser");
        a = m19409a((Map) map, "X-Afma-Pool");
        if (TextUtils.isEmpty(a)) {
            this.f15391I = new JSONObject(a).getBoolean("never_pool");
        }
        this.f15392J = m19412d(map, "X-Afma-Custom-Close-Blocked");
        this.f15393K = m19412d(map, "X-Afma-Enable-Omid");
        this.f15394L = m19412d(map, "X-Afma-Disable-Closable-Area");
        this.f15395M = m19409a((Map) map, "X-Afma-Omid-Settings");
    }
}
