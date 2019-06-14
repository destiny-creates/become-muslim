package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.facebook.ads.internal.p085a.C1297b;
import com.facebook.ads.internal.p085a.C1298c;
import com.facebook.ads.internal.p085a.C1299d;
import com.facebook.ads.internal.p085a.C1301e;
import com.facebook.ads.internal.p085a.C1301e.C1300a;
import com.facebook.ads.internal.p093h.C1389d;
import com.facebook.ads.internal.p095j.C1397a;
import com.facebook.ads.internal.p095j.C1397a.C1395a;
import com.facebook.ads.internal.p095j.C1398b;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p099n.C1418c;
import com.facebook.ads.internal.p099n.C1425f;
import com.facebook.ads.internal.p099n.C1425f.C1424c;
import com.facebook.ads.internal.p099n.C1427h;
import com.facebook.ads.internal.p099n.C1428j;
import com.facebook.ads.internal.p099n.C1429k;
import com.facebook.ads.internal.p099n.C1431m;
import com.facebook.ads.internal.p105q.p106a.C1496d;
import com.facebook.ads.internal.p105q.p106a.C1508k;
import com.facebook.ads.internal.p105q.p106a.C1514q;
import com.facebook.ads.internal.p105q.p106a.C1525y;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.C1481a;
import com.facebook.appevents.UserDataStore;
import com.facebook.stetho.server.http.HttpStatus;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.m */
public class C4563m extends C3572y implements C1300a {
    /* renamed from: a */
    private static final String f12345a = "m";
    /* renamed from: A */
    private int f12346A;
    /* renamed from: B */
    private String f12347B;
    /* renamed from: C */
    private String f12348C;
    /* renamed from: D */
    private C1431m f12349D;
    /* renamed from: E */
    private int f12350E = HttpStatus.HTTP_OK;
    /* renamed from: F */
    private String f12351F;
    /* renamed from: G */
    private C1427h f12352G;
    /* renamed from: H */
    private String f12353H;
    /* renamed from: I */
    private String f12354I;
    /* renamed from: J */
    private C1429k f12355J;
    /* renamed from: K */
    private List<C1425f> f12356K;
    /* renamed from: L */
    private int f12357L = -1;
    /* renamed from: M */
    private int f12358M;
    /* renamed from: N */
    private String f12359N;
    /* renamed from: O */
    private boolean f12360O;
    /* renamed from: P */
    private boolean f12361P;
    /* renamed from: Q */
    private boolean f12362Q;
    /* renamed from: R */
    private boolean f12363R;
    /* renamed from: S */
    private boolean f12364S;
    /* renamed from: T */
    private long f12365T = 0;
    /* renamed from: U */
    private C1395a f12366U = null;
    /* renamed from: V */
    private C1412c f12367V;
    /* renamed from: W */
    private C1424c f12368W;
    /* renamed from: b */
    private Context f12369b;
    /* renamed from: c */
    private C1346z f12370c;
    /* renamed from: d */
    private Uri f12371d;
    /* renamed from: e */
    private String f12372e;
    /* renamed from: f */
    private String f12373f;
    /* renamed from: g */
    private String f12374g;
    /* renamed from: h */
    private String f12375h;
    /* renamed from: i */
    private String f12376i;
    /* renamed from: j */
    private String f12377j;
    /* renamed from: k */
    private String f12378k;
    /* renamed from: l */
    private String f12379l;
    /* renamed from: m */
    private String f12380m;
    /* renamed from: n */
    private String f12381n;
    /* renamed from: o */
    private String f12382o;
    /* renamed from: p */
    private C1427h f12383p;
    /* renamed from: q */
    private C1427h f12384q;
    /* renamed from: r */
    private C1428j f12385r;
    /* renamed from: s */
    private String f12386s;
    /* renamed from: t */
    private C1299d f12387t;
    /* renamed from: u */
    private Collection<String> f12388u;
    /* renamed from: v */
    private boolean f12389v;
    /* renamed from: w */
    private boolean f12390w;
    /* renamed from: x */
    private int f12391x;
    /* renamed from: y */
    private int f12392y;
    /* renamed from: z */
    private int f12393z;

    /* renamed from: M */
    private boolean m15588M() {
        return (!(this.f12360O || TextUtils.isEmpty(this.f12372e)) || (!TextUtils.isEmpty(this.f12373f) && this.f12360O)) && ((this.f12383p != null || this.f12360O) && (this.f12384q != null || getPlacementType() == AdPlacementType.NATIVE_BANNER));
    }

    /* renamed from: N */
    private void m15589N() {
        if (!this.f12364S) {
            if (this.f12367V != null) {
                this.f12367V.mo944a(this.f12386s);
            }
            this.f12364S = true;
        }
    }

    /* renamed from: a */
    private void m15591a(Context context, JSONObject jSONObject, C1412c c1412c, String str, int i, int i2) {
        this.f12360O = true;
        this.f12369b = context;
        this.f12367V = c1412c;
        this.f12357L = i;
        this.f12358M = i2;
        m15593a(jSONObject, str);
    }

    /* renamed from: a */
    private void m15592a(java.util.Map<java.lang.String, java.lang.String> r3, final java.util.Map<java.lang.String, java.lang.String> r4) {
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
        r2 = this;
        r3 = r2.m15595c(r3);	 Catch:{ Exception -> 0x0016 }
        r0 = new android.os.Handler;	 Catch:{ Exception -> 0x0016 }
        r0.<init>();	 Catch:{ Exception -> 0x0016 }
        r1 = new com.facebook.ads.internal.adapters.m$1;	 Catch:{ Exception -> 0x0016 }
        r1.<init>(r2, r4, r3);	 Catch:{ Exception -> 0x0016 }
        r3 = r2.f12391x;	 Catch:{ Exception -> 0x0016 }
        r3 = r3 * 1000;	 Catch:{ Exception -> 0x0016 }
        r3 = (long) r3;	 Catch:{ Exception -> 0x0016 }
        r0.postDelayed(r1, r3);	 Catch:{ Exception -> 0x0016 }
    L_0x0016:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.m.a(java.util.Map, java.util.Map):void");
    }

    /* renamed from: a */
    private void m15593a(org.json.JSONObject r13, java.lang.String r14) {
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
        r12 = this;
        r0 = r12.f12361P;
        if (r0 != 0) goto L_0x01c7;
    L_0x0004:
        if (r13 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r12.f12369b;
        r1 = "Audience Network Loaded";
        com.facebook.ads.internal.p105q.p106a.C1496d.m5271a(r0, r1);
        r12.f12359N = r14;
        r0 = "fbad_command";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r1 = android.text.TextUtils.isEmpty(r0);
        r2 = 0;
        if (r1 == 0) goto L_0x001f;
    L_0x001d:
        r0 = r2;
        goto L_0x0023;
    L_0x001f:
        r0 = android.net.Uri.parse(r0);
    L_0x0023:
        r12.f12371d = r0;
        r0 = "advertiser_name";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r12.f12372e = r0;
        r0 = "title";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r12.f12373f = r0;
        r0 = "subtitle";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r12.f12374g = r0;
        r0 = "headline";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r12.f12375h = r0;
        r0 = "body";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r12.f12376i = r0;
        r0 = "call_to_action";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r12.f12377j = r0;
        r0 = r12.f12377j;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x005f;
    L_0x005d:
        r12.f12377j = r2;
    L_0x005f:
        r0 = "social_context";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r12.f12378k = r0;
        r0 = "link_description";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r12.f12379l = r0;
        r0 = "sponsored_translation";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r12.f12380m = r0;
        r0 = "ad_translation";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r12.f12381n = r0;
        r0 = "promoted_translation";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r12.f12382o = r0;
        r0 = "icon";
        r0 = r13.optJSONObject(r0);
        r0 = com.facebook.ads.internal.p099n.C1427h.m5021a(r0);
        r12.f12383p = r0;
        r0 = "image";
        r0 = r13.optJSONObject(r0);
        r0 = com.facebook.ads.internal.p099n.C1427h.m5021a(r0);
        r12.f12384q = r0;
        r0 = "star_rating";
        r0 = r13.optJSONObject(r0);
        r0 = com.facebook.ads.internal.p099n.C1428j.m5025a(r0);
        r12.f12385r = r0;
        r0 = "used_report_url";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r12.f12386s = r0;
        r0 = "enable_view_log";
        r0 = r13.optBoolean(r0);
        r12.f12389v = r0;
        r0 = "enable_snapshot_log";
        r0 = r13.optBoolean(r0);
        r12.f12390w = r0;
        r0 = "snapshot_log_delay_second";
        r1 = 4;
        r0 = r13.optInt(r0, r1);
        r12.f12391x = r0;
        r0 = "snapshot_compress_quality";
        r1 = 0;
        r0 = r13.optInt(r0, r1);
        r12.f12392y = r0;
        r0 = "viewability_check_initial_delay";
        r0 = r13.optInt(r0, r1);
        r12.f12393z = r0;
        r0 = "viewability_check_interval";
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r13.optInt(r0, r3);
        r12.f12346A = r0;
        r0 = "ad_choices_icon";
        r0 = r13.optJSONObject(r0);
        r3 = "native_ui_config";
        r3 = r13.optJSONObject(r3);
        if (r3 == 0) goto L_0x0102;
    L_0x00f5:
        r4 = r3.length();	 Catch:{ JSONException -> 0x0106 }
        if (r4 != 0) goto L_0x00fc;	 Catch:{ JSONException -> 0x0106 }
    L_0x00fb:
        goto L_0x0102;	 Catch:{ JSONException -> 0x0106 }
    L_0x00fc:
        r4 = new com.facebook.ads.internal.n.k;	 Catch:{ JSONException -> 0x0106 }
        r4.<init>(r3);	 Catch:{ JSONException -> 0x0106 }
        goto L_0x0103;	 Catch:{ JSONException -> 0x0106 }
    L_0x0102:
        r4 = r2;	 Catch:{ JSONException -> 0x0106 }
    L_0x0103:
        r12.f12355J = r4;	 Catch:{ JSONException -> 0x0106 }
        goto L_0x0108;
    L_0x0106:
        r12.f12355J = r2;
    L_0x0108:
        if (r0 == 0) goto L_0x0110;
    L_0x010a:
        r0 = com.facebook.ads.internal.p099n.C1427h.m5021a(r0);
        r12.f12352G = r0;
    L_0x0110:
        r0 = "ad_choices_link_url";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r12.f12353H = r0;
        r0 = "request_id";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r12.f12354I = r0;
        r0 = "invalidation_behavior";
        r0 = r13.optString(r0);
        r0 = com.facebook.ads.internal.p085a.C1299d.m4446a(r0);
        r12.f12387t = r0;
        r0 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0138 }
        r3 = "detection_strings";	 Catch:{ JSONException -> 0x0138 }
        r3 = r13.optString(r3);	 Catch:{ JSONException -> 0x0138 }
        r0.<init>(r3);	 Catch:{ JSONException -> 0x0138 }
        goto L_0x013d;
    L_0x0138:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r2;
    L_0x013d:
        r0 = com.facebook.ads.internal.p085a.C1301e.m4450a(r0);
        r12.f12388u = r0;
        r0 = "video_url";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r12.f12347B = r0;
        r0 = "video_mpd";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r12.f12348C = r0;
        r0 = "video_autoplay_enabled";
        r0 = r13.has(r0);
        if (r0 != 0) goto L_0x0160;
    L_0x015b:
        r0 = com.facebook.ads.internal.p099n.C1431m.DEFAULT;
    L_0x015d:
        r12.f12349D = r0;
        goto L_0x016e;
    L_0x0160:
        r0 = "video_autoplay_enabled";
        r0 = r13.optBoolean(r0);
        if (r0 == 0) goto L_0x016b;
    L_0x0168:
        r0 = com.facebook.ads.internal.p099n.C1431m.ON;
        goto L_0x015d;
    L_0x016b:
        r0 = com.facebook.ads.internal.p099n.C1431m.OFF;
        goto L_0x015d;
    L_0x016e:
        r0 = "video_report_url";
        r0 = com.facebook.ads.internal.p105q.p106a.C1508k.m5307a(r13, r0);
        r12.f12351F = r0;
        r0 = "carousel";	 Catch:{ JSONException -> 0x01b5 }
        r13 = r13.optJSONArray(r0);	 Catch:{ JSONException -> 0x01b5 }
        if (r13 == 0) goto L_0x01bd;	 Catch:{ JSONException -> 0x01b5 }
    L_0x017e:
        r0 = r13.length();	 Catch:{ JSONException -> 0x01b5 }
        if (r0 <= 0) goto L_0x01bd;	 Catch:{ JSONException -> 0x01b5 }
    L_0x0184:
        r0 = r13.length();	 Catch:{ JSONException -> 0x01b5 }
        r10 = new java.util.ArrayList;	 Catch:{ JSONException -> 0x01b5 }
        r10.<init>(r0);	 Catch:{ JSONException -> 0x01b5 }
    L_0x018d:
        if (r1 >= r0) goto L_0x01b2;	 Catch:{ JSONException -> 0x01b5 }
    L_0x018f:
        r11 = new com.facebook.ads.internal.adapters.m;	 Catch:{ JSONException -> 0x01b5 }
        r11.<init>();	 Catch:{ JSONException -> 0x01b5 }
        r4 = r12.f12369b;	 Catch:{ JSONException -> 0x01b5 }
        r5 = r13.getJSONObject(r1);	 Catch:{ JSONException -> 0x01b5 }
        r6 = r12.f12367V;	 Catch:{ JSONException -> 0x01b5 }
        r3 = r11;	 Catch:{ JSONException -> 0x01b5 }
        r7 = r14;	 Catch:{ JSONException -> 0x01b5 }
        r8 = r1;	 Catch:{ JSONException -> 0x01b5 }
        r9 = r0;	 Catch:{ JSONException -> 0x01b5 }
        r3.m15591a(r4, r5, r6, r7, r8, r9);	 Catch:{ JSONException -> 0x01b5 }
        r3 = new com.facebook.ads.internal.n.f;	 Catch:{ JSONException -> 0x01b5 }
        r4 = r12.f12369b;	 Catch:{ JSONException -> 0x01b5 }
        r5 = r12.f12368W;	 Catch:{ JSONException -> 0x01b5 }
        r3.<init>(r4, r11, r2, r5);	 Catch:{ JSONException -> 0x01b5 }
        r10.add(r3);	 Catch:{ JSONException -> 0x01b5 }
        r1 = r1 + 1;	 Catch:{ JSONException -> 0x01b5 }
        goto L_0x018d;	 Catch:{ JSONException -> 0x01b5 }
    L_0x01b2:
        r12.f12356K = r10;	 Catch:{ JSONException -> 0x01b5 }
        goto L_0x01bd;
    L_0x01b5:
        r13 = move-exception;
        r14 = f12345a;
        r0 = "Unable to parse carousel data.";
        android.util.Log.e(r14, r0, r13);
    L_0x01bd:
        r13 = 1;
        r12.f12361P = r13;
        r13 = r12.m15588M();
        r12.f12362Q = r13;
        return;
    L_0x01c7:
        r13 = new java.lang.IllegalStateException;
        r14 = "Adapter already loaded data";
        r13.<init>(r14);
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.m.a(org.json.JSONObject, java.lang.String):void");
    }

    /* renamed from: c */
    private Map<String, String> m15595c(Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        if (map.containsKey("view")) {
            hashMap.put("view", map.get("view"));
        }
        if (map.containsKey("snapshot")) {
            hashMap.put("snapshot", map.get("snapshot"));
        }
        return hashMap;
    }

    /* renamed from: A */
    public String mo2816A() {
        return !c_() ? null : this.f12347B;
    }

    /* renamed from: B */
    public String mo2817B() {
        return !c_() ? null : this.f12348C;
    }

    /* renamed from: C */
    public C1431m mo2818C() {
        return !c_() ? C1431m.DEFAULT : this.f12349D;
    }

    /* renamed from: D */
    public int mo2819D() {
        return this.f12350E;
    }

    /* renamed from: E */
    public String mo2820E() {
        return this.f12351F;
    }

    /* renamed from: F */
    public List<C1425f> mo2821F() {
        return !c_() ? null : this.f12356K;
    }

    /* renamed from: G */
    public int mo2822G() {
        return this.f12357L;
    }

    /* renamed from: H */
    public int mo2823H() {
        return this.f12358M;
    }

    /* renamed from: I */
    public C1418c mo2824I() {
        return C1418c.AN;
    }

    /* renamed from: K */
    public String mo2864K() {
        if (!c_()) {
            return null;
        }
        m15589N();
        return this.f12376i;
    }

    /* renamed from: L */
    public boolean m15606L() {
        return this.f12360O;
    }

    /* renamed from: a */
    public C1299d mo934a() {
        return this.f12387t;
    }

    /* renamed from: a */
    public void mo2826a(int i) {
        if (c_() && i == 0 && this.f12365T > 0 && this.f12366U != null) {
            C1398b.m4797a(C1397a.m4792a(this.f12365T, this.f12366U, this.f12354I));
            this.f12365T = 0;
            this.f12366U = null;
        }
    }

    /* renamed from: a */
    public void mo2827a(Context context, C1346z c1346z, C1412c c1412c, Map<String, Object> map, C1424c c1424c) {
        this.f12369b = context;
        this.f12370c = c1346z;
        this.f12367V = c1412c;
        this.f12368W = c1424c;
        JSONObject jSONObject = (JSONObject) map.get("data");
        C1389d c1389d = (C1389d) map.get("definition");
        this.f12350E = c1389d != null ? c1389d.m4776k() : HttpStatus.HTTP_OK;
        m15593a(jSONObject, C1508k.m5307a(jSONObject, UserDataStore.CITY));
        if (C1301e.m4451a(context, this, c1412c)) {
            c1346z.mo898a(this, new C1481a(AdErrorType.NO_FILL, "No Fill"));
            return;
        }
        if (c1346z != null) {
            c1346z.mo897a(this);
        }
        C1397a.f4086a = this.f12354I;
    }

    /* renamed from: a */
    public void mo2828a(View view, List<View> list) {
    }

    /* renamed from: a */
    public void mo2829a(C1346z c1346z) {
        this.f12370c = c1346z;
    }

    /* renamed from: a */
    public void mo2830a(Map<String, String> map) {
        if (c_() && !this.f12363R) {
            if (this.f12370c != null) {
                this.f12370c.mo899b(this);
            }
            Map hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            if (this.f12360O) {
                hashMap.put("cardind", String.valueOf(this.f12357L));
                hashMap.put("cardcnt", String.valueOf(this.f12358M));
            }
            if (!(TextUtils.isEmpty(mo2833c()) || this.f12367V == null)) {
                this.f12367V.mo945a(mo2833c(), hashMap);
            }
            if (mo2836e() || mo2835d()) {
                m15592a((Map) map, hashMap);
            }
            this.f12363R = true;
        }
    }

    public boolean a_() {
        return c_() && this.f12371d != null;
    }

    /* renamed from: b */
    public Collection<String> mo935b() {
        return this.f12388u;
    }

    /* renamed from: b */
    public void mo2831b(Map<String, String> map) {
        if (!c_()) {
            return;
        }
        if (C1405a.m4822c(this.f12369b) && C1525y.m5349a((Map) map)) {
            Log.e(f12345a, "Click happened on lockscreen ad");
            return;
        }
        Map hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        C1496d.m5271a(this.f12369b, "Click logged");
        if (this.f12370c != null) {
            this.f12370c.mo900c(this);
        }
        if (this.f12360O) {
            hashMap.put("cardind", String.valueOf(this.f12357L));
            hashMap.put("cardcnt", String.valueOf(this.f12358M));
        }
        C1297b a = C1298c.m4444a(this.f12369b, this.f12367V, this.f12359N, this.f12371d, hashMap);
        if (a != null) {
            try {
                this.f12365T = System.currentTimeMillis();
                this.f12366U = a.mo918a();
                a.mo917b();
            } catch (Throwable e) {
                Log.e(f12345a, "Error executing action", e);
            }
        }
    }

    public void b_() {
        if (this.f12356K != null && !this.f12356K.isEmpty()) {
            for (C1425f J : this.f12356K) {
                J.m4980J();
            }
        }
    }

    /* renamed from: c */
    public String mo2833c() {
        return this.f12359N;
    }

    public boolean c_() {
        return this.f12361P && this.f12362Q;
    }

    /* renamed from: d */
    public boolean mo2835d() {
        return c_() && this.f12390w;
    }

    /* renamed from: e */
    public boolean mo2836e() {
        return c_() && this.f12389v;
    }

    /* renamed from: f */
    public boolean mo2837f() {
        return c_() && this.f12355J != null;
    }

    /* renamed from: g */
    public boolean mo2838g() {
        return true;
    }

    /* renamed from: h */
    public int mo2839h() {
        if (this.f12392y >= 0) {
            if (this.f12392y <= 100) {
                return this.f12392y;
            }
        }
        return 0;
    }

    /* renamed from: i */
    public int mo2840i() {
        return this.f12393z;
    }

    /* renamed from: j */
    public int mo2841j() {
        return this.f12346A;
    }

    /* renamed from: k */
    public C1427h mo2842k() {
        return !c_() ? null : this.f12383p;
    }

    /* renamed from: l */
    public C1427h mo2843l() {
        return !c_() ? null : this.f12384q;
    }

    /* renamed from: m */
    public C1429k mo2844m() {
        return !c_() ? null : this.f12355J;
    }

    /* renamed from: n */
    public String mo2845n() {
        if (!c_()) {
            return null;
        }
        m15589N();
        return this.f12372e;
    }

    /* renamed from: o */
    public String mo2846o() {
        if (!c_()) {
            return null;
        }
        m15589N();
        return this.f12375h;
    }

    public void onDestroy() {
    }

    /* renamed from: p */
    public String mo2848p() {
        if (!c_()) {
            return null;
        }
        m15589N();
        return C1514q.m5318a(this.f12376i);
    }

    /* renamed from: q */
    public String mo2849q() {
        if (!c_()) {
            return null;
        }
        m15589N();
        return this.f12377j;
    }

    /* renamed from: r */
    public String mo2850r() {
        if (!c_()) {
            return null;
        }
        m15589N();
        return this.f12378k;
    }

    /* renamed from: s */
    public String mo2851s() {
        if (!c_()) {
            return null;
        }
        m15589N();
        return this.f12379l;
    }

    /* renamed from: t */
    public String mo2852t() {
        if (!c_()) {
            return null;
        }
        m15589N();
        return this.f12380m;
    }

    /* renamed from: u */
    public String mo2853u() {
        if (!c_()) {
            return null;
        }
        m15589N();
        return this.f12381n;
    }

    /* renamed from: v */
    public String mo2854v() {
        if (!c_()) {
            return null;
        }
        m15589N();
        return this.f12382o;
    }

    /* renamed from: w */
    public C1428j mo2855w() {
        if (!c_()) {
            return null;
        }
        m15589N();
        return this.f12385r;
    }

    /* renamed from: x */
    public C1427h mo2856x() {
        return !c_() ? null : this.f12352G;
    }

    /* renamed from: y */
    public String mo2857y() {
        return !c_() ? null : this.f12353H;
    }

    /* renamed from: z */
    public String mo2858z() {
        return !c_() ? null : "AdChoices";
    }
}
