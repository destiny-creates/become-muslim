package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p099n.C1418c;
import com.facebook.ads.internal.p099n.C1425f;
import com.facebook.ads.internal.p099n.C1425f.C1424c;
import com.facebook.ads.internal.p099n.C1427h;
import com.facebook.ads.internal.p099n.C1428j;
import com.facebook.ads.internal.p099n.C1429k;
import com.facebook.ads.internal.p099n.C1431m;
import com.facebook.ads.internal.p105q.p106a.C1496d;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.C1481a;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.InMobiNative.NativeAdListener;
import com.inmobi.sdk.InMobiSdk;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.r */
public class C4566r extends C3572y implements C1340u {
    /* renamed from: a */
    private C1346z f12417a;
    /* renamed from: b */
    private InMobiNative f12418b;
    /* renamed from: c */
    private boolean f12419c;
    /* renamed from: d */
    private View f12420d;
    /* renamed from: e */
    private String f12421e;
    /* renamed from: f */
    private String f12422f;
    /* renamed from: g */
    private String f12423g;
    /* renamed from: h */
    private C1428j f12424h;
    /* renamed from: i */
    private C1427h f12425i;
    /* renamed from: j */
    private C1427h f12426j;

    /* renamed from: A */
    public String mo2816A() {
        return null;
    }

    /* renamed from: B */
    public String mo2817B() {
        return null;
    }

    /* renamed from: C */
    public C1431m mo2818C() {
        return C1431m.DEFAULT;
    }

    /* renamed from: D */
    public int mo2819D() {
        return 0;
    }

    /* renamed from: E */
    public String mo2820E() {
        return null;
    }

    /* renamed from: F */
    public List<C1425f> mo2821F() {
        return null;
    }

    /* renamed from: G */
    public int mo2822G() {
        return 0;
    }

    /* renamed from: H */
    public int mo2823H() {
        return 0;
    }

    /* renamed from: I */
    public C1418c mo2824I() {
        return C1418c.INMOBI;
    }

    /* renamed from: J */
    public C1328f mo2825J() {
        return C1328f.INMOBI;
    }

    /* renamed from: a */
    public void mo2826a(int i) {
    }

    /* renamed from: a */
    public void mo2827a(final Context context, C1346z c1346z, C1412c c1412c, Map<String, Object> map, C1424c c1424c) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C1342v.m4609a(mo2825J()));
        stringBuilder.append(" Loading");
        C1496d.m5271a(context, stringBuilder.toString());
        JSONObject jSONObject = (JSONObject) map.get("data");
        Object optString = jSONObject.optString("account_id");
        Long valueOf = Long.valueOf(jSONObject.optLong("placement_id"));
        if (!TextUtils.isEmpty(optString)) {
            if (valueOf != null) {
                this.f12417a = c1346z;
                InMobiSdk.init(context, optString);
                this.f12418b = new InMobiNative(valueOf.longValue(), new NativeAdListener(this) {
                    /* renamed from: b */
                    final /* synthetic */ C4566r f3893b;

                    public void onAdDismissed(InMobiNative inMobiNative) {
                    }

                    public void onAdDisplayed(InMobiNative inMobiNative) {
                    }

                    public void onAdLoadFailed(InMobiNative inMobiNative, InMobiAdRequestStatus inMobiAdRequestStatus) {
                        Context context = context;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(C1342v.m4609a(this.f3893b.mo2825J()));
                        stringBuilder.append(" Failed with InMobi error: ");
                        stringBuilder.append(inMobiAdRequestStatus.getMessage());
                        C1496d.m5271a(context, stringBuilder.toString());
                        if (this.f3893b.f12417a != null) {
                            this.f3893b.f12417a.mo898a(this.f3893b, new C1481a(AdErrorType.MEDIATION_ERROR.getErrorCode(), inMobiAdRequestStatus.getMessage()));
                        }
                    }

                    public void onAdLoadSucceeded(com.inmobi.ads.InMobiNative r7) {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
                        /*
                        r6 = this;
                        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00da }
                        r1 = r7.getAdContent();	 Catch:{ Exception -> 0x00da }
                        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x00da }
                        r0.<init>(r1);	 Catch:{ Exception -> 0x00da }
                        r1 = r6.f3893b;	 Catch:{ Exception -> 0x00da }
                        r2 = "title";	 Catch:{ Exception -> 0x00da }
                        r2 = r0.optString(r2);	 Catch:{ Exception -> 0x00da }
                        r1.f12421e = r2;	 Catch:{ Exception -> 0x00da }
                        r1 = r6.f3893b;	 Catch:{ Exception -> 0x00da }
                        r2 = "description";	 Catch:{ Exception -> 0x00da }
                        r2 = r0.optString(r2);	 Catch:{ Exception -> 0x00da }
                        r1.f12422f = r2;	 Catch:{ Exception -> 0x00da }
                        r1 = r6.f3893b;	 Catch:{ Exception -> 0x00da }
                        r2 = "cta";	 Catch:{ Exception -> 0x00da }
                        r2 = r0.optString(r2);	 Catch:{ Exception -> 0x00da }
                        r1.f12423g = r2;	 Catch:{ Exception -> 0x00da }
                        r1 = "icon";	 Catch:{ Exception -> 0x00da }
                        r1 = r0.optJSONObject(r1);	 Catch:{ Exception -> 0x00da }
                        if (r1 == 0) goto L_0x0050;	 Catch:{ Exception -> 0x00da }
                    L_0x0034:
                        r2 = "width";	 Catch:{ Exception -> 0x00da }
                        r2 = r1.optInt(r2);	 Catch:{ Exception -> 0x00da }
                        r3 = "height";	 Catch:{ Exception -> 0x00da }
                        r3 = r1.optInt(r3);	 Catch:{ Exception -> 0x00da }
                        r4 = "url";	 Catch:{ Exception -> 0x00da }
                        r1 = r1.optString(r4);	 Catch:{ Exception -> 0x00da }
                        r4 = r6.f3893b;	 Catch:{ Exception -> 0x00da }
                        r5 = new com.facebook.ads.internal.n.h;	 Catch:{ Exception -> 0x00da }
                        r5.<init>(r1, r2, r3);	 Catch:{ Exception -> 0x00da }
                        r4.f12425i = r5;	 Catch:{ Exception -> 0x00da }
                    L_0x0050:
                        r1 = "screenshots";	 Catch:{ Exception -> 0x00da }
                        r1 = r0.optJSONObject(r1);	 Catch:{ Exception -> 0x00da }
                        if (r1 == 0) goto L_0x0074;	 Catch:{ Exception -> 0x00da }
                    L_0x0058:
                        r2 = "width";	 Catch:{ Exception -> 0x00da }
                        r2 = r1.optInt(r2);	 Catch:{ Exception -> 0x00da }
                        r3 = "height";	 Catch:{ Exception -> 0x00da }
                        r3 = r1.optInt(r3);	 Catch:{ Exception -> 0x00da }
                        r4 = "url";	 Catch:{ Exception -> 0x00da }
                        r1 = r1.optString(r4);	 Catch:{ Exception -> 0x00da }
                        r4 = r6.f3893b;	 Catch:{ Exception -> 0x00da }
                        r5 = new com.facebook.ads.internal.n.h;	 Catch:{ Exception -> 0x00da }
                        r5.<init>(r1, r2, r3);	 Catch:{ Exception -> 0x00da }
                        r4.f12426j = r5;	 Catch:{ Exception -> 0x00da }
                    L_0x0074:
                        r1 = "rating";	 Catch:{ Exception -> 0x00da }
                        r0 = r0.optString(r1);	 Catch:{ Exception -> 0x00da }
                        r0 = java.lang.Double.parseDouble(r0);	 Catch:{ Exception -> 0x008a }
                        r2 = r6.f3893b;	 Catch:{ Exception -> 0x008a }
                        r3 = new com.facebook.ads.internal.n.j;	 Catch:{ Exception -> 0x008a }
                        r4 = 4617315517961601024; // 0x4014000000000000 float:0.0 double:5.0;	 Catch:{ Exception -> 0x008a }
                        r3.<init>(r0, r4);	 Catch:{ Exception -> 0x008a }
                        r2.f12424h = r3;	 Catch:{ Exception -> 0x008a }
                    L_0x008a:
                        r0 = r6.f3893b;	 Catch:{ Exception -> 0x00da }
                        r1 = 1;	 Catch:{ Exception -> 0x00da }
                        r0.f12419c = r1;	 Catch:{ Exception -> 0x00da }
                        r0 = r6.f3893b;	 Catch:{ Exception -> 0x00da }
                        r0 = r0.f12420d;	 Catch:{ Exception -> 0x00da }
                        if (r0 == 0) goto L_0x00a6;	 Catch:{ Exception -> 0x00da }
                    L_0x0098:
                        r0 = r6.f3893b;	 Catch:{ Exception -> 0x00da }
                        r0.f12418b;	 Catch:{ Exception -> 0x00da }
                        r0 = r6.f3893b;	 Catch:{ Exception -> 0x00da }
                        r0 = r0.f12420d;	 Catch:{ Exception -> 0x00da }
                        com.inmobi.ads.InMobiNative.bind(r0, r7);	 Catch:{ Exception -> 0x00da }
                    L_0x00a6:
                        r7 = r6.f3893b;	 Catch:{ Exception -> 0x00da }
                        r7 = r7.f12417a;	 Catch:{ Exception -> 0x00da }
                        if (r7 == 0) goto L_0x0116;	 Catch:{ Exception -> 0x00da }
                    L_0x00ae:
                        r7 = r3;	 Catch:{ Exception -> 0x00da }
                        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00da }
                        r0.<init>();	 Catch:{ Exception -> 0x00da }
                        r1 = r6.f3893b;	 Catch:{ Exception -> 0x00da }
                        r1 = r1.mo2825J();	 Catch:{ Exception -> 0x00da }
                        r1 = com.facebook.ads.internal.adapters.C1342v.m4609a(r1);	 Catch:{ Exception -> 0x00da }
                        r0.append(r1);	 Catch:{ Exception -> 0x00da }
                        r1 = " Loaded";	 Catch:{ Exception -> 0x00da }
                        r0.append(r1);	 Catch:{ Exception -> 0x00da }
                        r0 = r0.toString();	 Catch:{ Exception -> 0x00da }
                        com.facebook.ads.internal.p105q.p106a.C1496d.m5271a(r7, r0);	 Catch:{ Exception -> 0x00da }
                        r7 = r6.f3893b;	 Catch:{ Exception -> 0x00da }
                        r7 = r7.f12417a;	 Catch:{ Exception -> 0x00da }
                        r0 = r6.f3893b;	 Catch:{ Exception -> 0x00da }
                        r7.mo897a(r0);	 Catch:{ Exception -> 0x00da }
                        goto L_0x0116;
                        r7 = r6.f3893b;
                        r7 = r7.f12417a;
                        if (r7 == 0) goto L_0x0116;
                    L_0x00e3:
                        r7 = r3;
                        r0 = new java.lang.StringBuilder;
                        r0.<init>();
                        r1 = r6.f3893b;
                        r1 = r1.mo2825J();
                        r1 = com.facebook.ads.internal.adapters.C1342v.m4609a(r1);
                        r0.append(r1);
                        r1 = " Failed. Internal AN SDK error";
                        r0.append(r1);
                        r0 = r0.toString();
                        com.facebook.ads.internal.p105q.p106a.C1496d.m5271a(r7, r0);
                        r7 = r6.f3893b;
                        r7 = r7.f12417a;
                        r0 = r6.f3893b;
                        r1 = com.facebook.ads.internal.protocol.AdErrorType.INTERNAL_ERROR;
                        r2 = "Internal Error";
                        r1 = com.facebook.ads.internal.protocol.C1481a.m5241a(r1, r2);
                        r7.mo898a(r0, r1);
                    L_0x0116:
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.r.1.onAdLoadSucceeded(com.inmobi.ads.InMobiNative):void");
                    }

                    public void onUserLeftApplication(InMobiNative inMobiNative) {
                    }
                });
                this.f12418b.load();
                return;
            }
        }
        c1346z.mo898a(this, new C1481a(AdErrorType.MEDIATION_ERROR, "Mediation Error"));
    }

    /* renamed from: a */
    public void mo2828a(View view, List<View> list) {
        this.f12420d = view;
        if (c_()) {
            InMobiNative inMobiNative = this.f12418b;
            InMobiNative.bind(this.f12420d, this.f12418b);
        }
    }

    /* renamed from: a */
    public void mo2829a(C1346z c1346z) {
        this.f12417a = c1346z;
    }

    /* renamed from: a */
    public void mo2830a(Map<String, String> map) {
        this.f12417a.mo899b(this);
    }

    /* renamed from: b */
    public void mo2831b(Map<String, String> map) {
        if (c_()) {
            this.f12417a.mo900c(this);
            this.f12418b.reportAdClickAndOpenLandingPage(null);
        }
    }

    public void b_() {
        if (c_()) {
            InMobiNative inMobiNative = this.f12418b;
            InMobiNative.unbind(this.f12420d);
        }
        this.f12420d = null;
    }

    /* renamed from: c */
    public String mo2833c() {
        return null;
    }

    public boolean c_() {
        return this.f12418b != null && this.f12419c;
    }

    /* renamed from: d */
    public boolean mo2835d() {
        return false;
    }

    /* renamed from: e */
    public boolean mo2836e() {
        return false;
    }

    /* renamed from: f */
    public boolean mo2837f() {
        return false;
    }

    /* renamed from: g */
    public boolean mo2838g() {
        return true;
    }

    /* renamed from: h */
    public int mo2839h() {
        return 0;
    }

    /* renamed from: i */
    public int mo2840i() {
        return 0;
    }

    /* renamed from: j */
    public int mo2841j() {
        return 0;
    }

    /* renamed from: k */
    public C1427h mo2842k() {
        return this.f12425i;
    }

    /* renamed from: l */
    public C1427h mo2843l() {
        return this.f12426j;
    }

    /* renamed from: m */
    public C1429k mo2844m() {
        return null;
    }

    /* renamed from: n */
    public String mo2845n() {
        return null;
    }

    /* renamed from: o */
    public String mo2846o() {
        return null;
    }

    public void onDestroy() {
        b_();
        this.f12418b = null;
        this.f12417a = null;
    }

    /* renamed from: p */
    public String mo2848p() {
        return this.f12422f;
    }

    /* renamed from: q */
    public String mo2849q() {
        return this.f12423g;
    }

    /* renamed from: r */
    public String mo2850r() {
        return null;
    }

    /* renamed from: s */
    public String mo2851s() {
        return null;
    }

    /* renamed from: t */
    public String mo2852t() {
        return null;
    }

    /* renamed from: u */
    public String mo2853u() {
        return null;
    }

    /* renamed from: v */
    public String mo2854v() {
        return null;
    }

    /* renamed from: w */
    public C1428j mo2855w() {
        return null;
    }

    /* renamed from: x */
    public C1427h mo2856x() {
        return null;
    }

    /* renamed from: y */
    public String mo2857y() {
        return null;
    }

    /* renamed from: z */
    public String mo2858z() {
        return "Ad";
    }
}
