package com.facebook.ads.internal.adapters;

import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.ads.internal.p099n.C1418c;
import com.facebook.ads.internal.p099n.C1425f;
import com.facebook.ads.internal.p099n.C1427h;
import com.facebook.ads.internal.p099n.C1428j;
import com.facebook.ads.internal.p099n.C1429k;
import com.facebook.ads.internal.p099n.C1431m;
import com.google.android.gms.ads.p168b.C2609c;
import com.google.android.gms.ads.p168b.C2612e;
import com.google.android.gms.ads.p168b.C4260h;
import com.google.android.gms.ads.p168b.C4261i;
import com.google.android.gms.ads.p168b.C4262j;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.adapters.d */
public class C4558d extends C3572y implements C1340u {
    /* renamed from: a */
    private static final String f12291a = "d";
    /* renamed from: b */
    private View f12292b;
    /* renamed from: c */
    private C2609c f12293c;
    /* renamed from: d */
    private C1346z f12294d;
    /* renamed from: e */
    private C2612e f12295e;
    /* renamed from: f */
    private View f12296f;
    /* renamed from: g */
    private boolean f12297g;
    /* renamed from: h */
    private Uri f12298h;
    /* renamed from: i */
    private Uri f12299i;
    /* renamed from: j */
    private String f12300j;
    /* renamed from: k */
    private String f12301k;
    /* renamed from: l */
    private String f12302l;
    /* renamed from: m */
    private String f12303m;

    /* renamed from: com.facebook.ads.internal.adapters.d$4 */
    class C13254 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C4558d f3852a;

        C13254(C4558d c4558d) {
            this.f3852a = c4558d;
        }

        public void onClick(View view) {
            this.f3852a.f12296f.performClick();
        }
    }

    /* renamed from: a */
    private void m15503a(View view) {
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
    }

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
        return C1418c.ADMOB;
    }

    /* renamed from: J */
    public C1328f mo2825J() {
        return C1328f.ADMOB;
    }

    /* renamed from: a */
    public void mo2826a(int i) {
    }

    /* renamed from: a */
    public void mo2827a(final android.content.Context r10, com.facebook.ads.internal.adapters.C1346z r11, com.facebook.ads.internal.p098m.C1412c r12, java.util.Map<java.lang.String, java.lang.Object> r13, com.facebook.ads.internal.p099n.C1425f.C1424c r14) {
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
        r9 = this;
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r14 = r9.mo2825J();
        r14 = com.facebook.ads.internal.adapters.C1342v.m4609a(r14);
        r12.append(r14);
        r14 = " Loading";
        r12.append(r14);
        r12 = r12.toString();
        com.facebook.ads.internal.p105q.p106a.C1496d.m5271a(r10, r12);
        r12 = "data";
        r12 = r13.get(r12);
        r12 = (org.json.JSONObject) r12;
        r13 = "ad_unit_id";
        r13 = r12.optString(r13);
        r14 = "creative_types";
        r12 = r12.optJSONArray(r14);
        r14 = 0;
        r0 = 1;
        if (r12 == 0) goto L_0x009a;
    L_0x0034:
        r1 = r12.length();
        r2 = 0;
        r3 = 0;
        r4 = 0;
    L_0x003b:
        if (r2 >= r1) goto L_0x0098;
    L_0x003d:
        r5 = r12.getString(r2);	 Catch:{ JSONException -> 0x0070 }
        if (r5 == 0) goto L_0x006d;	 Catch:{ JSONException -> 0x0070 }
    L_0x0043:
        r6 = -1;	 Catch:{ JSONException -> 0x0070 }
        r7 = r5.hashCode();	 Catch:{ JSONException -> 0x0070 }
        r8 = 704091517; // 0x29f7957d float:1.09949356E-13 double:3.4786743E-315;	 Catch:{ JSONException -> 0x0070 }
        if (r7 == r8) goto L_0x005d;	 Catch:{ JSONException -> 0x0070 }
    L_0x004d:
        r8 = 883765328; // 0x34ad3050 float:3.2258913E-7 double:4.366380876E-315;	 Catch:{ JSONException -> 0x0070 }
        if (r7 == r8) goto L_0x0053;	 Catch:{ JSONException -> 0x0070 }
    L_0x0052:
        goto L_0x0066;	 Catch:{ JSONException -> 0x0070 }
    L_0x0053:
        r7 = "page_post";	 Catch:{ JSONException -> 0x0070 }
        r5 = r5.equals(r7);	 Catch:{ JSONException -> 0x0070 }
        if (r5 == 0) goto L_0x0066;	 Catch:{ JSONException -> 0x0070 }
    L_0x005b:
        r6 = 1;	 Catch:{ JSONException -> 0x0070 }
        goto L_0x0066;	 Catch:{ JSONException -> 0x0070 }
    L_0x005d:
        r7 = "app_install";	 Catch:{ JSONException -> 0x0070 }
        r5 = r5.equals(r7);	 Catch:{ JSONException -> 0x0070 }
        if (r5 == 0) goto L_0x0066;
    L_0x0065:
        r6 = 0;
    L_0x0066:
        switch(r6) {
            case 0: goto L_0x006c;
            case 1: goto L_0x006a;
            default: goto L_0x0069;
        };
    L_0x0069:
        goto L_0x006d;
    L_0x006a:
        r4 = 1;
        goto L_0x006d;
    L_0x006c:
        r3 = 1;
    L_0x006d:
        r2 = r2 + 1;
        goto L_0x003b;
    L_0x0070:
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r13 = r9.mo2825J();
        r13 = com.facebook.ads.internal.adapters.C1342v.m4609a(r13);
        r12.append(r13);
        r13 = " AN server error";
        r12.append(r13);
        r12 = r12.toString();
        com.facebook.ads.internal.p105q.p106a.C1496d.m5271a(r10, r12);
        r10 = com.facebook.ads.internal.protocol.AdErrorType.SERVER_ERROR;
        r12 = "Server Error";
        r10 = com.facebook.ads.internal.protocol.C1481a.m5241a(r10, r12);
        r11.mo898a(r9, r10);
        return;
    L_0x0098:
        r14 = r3;
        goto L_0x009b;
    L_0x009a:
        r4 = 0;
    L_0x009b:
        r12 = android.text.TextUtils.isEmpty(r13);
        if (r12 != 0) goto L_0x00ec;
    L_0x00a1:
        if (r14 != 0) goto L_0x00a6;
    L_0x00a3:
        if (r4 != 0) goto L_0x00a6;
    L_0x00a5:
        goto L_0x00ec;
    L_0x00a6:
        r9.f12294d = r11;
        r11 = new com.google.android.gms.ads.b$a;
        r11.<init>(r10, r13);
        if (r14 == 0) goto L_0x00b7;
    L_0x00af:
        r12 = new com.facebook.ads.internal.adapters.d$1;
        r12.<init>(r9, r10);
        r11.m7346a(r12);
    L_0x00b7:
        if (r4 == 0) goto L_0x00c1;
    L_0x00b9:
        r12 = new com.facebook.ads.internal.adapters.d$2;
        r12.<init>(r9, r10);
        r11.m7347a(r12);
    L_0x00c1:
        r12 = new com.facebook.ads.internal.adapters.d$3;
        r12.<init>(r9, r10);
        r10 = r11.m7344a(r12);
        r11 = new com.google.android.gms.ads.b.d$a;
        r11.<init>();
        r11 = r11.m7362a(r0);
        r11 = r11.m7363a();
        r10 = r10.m7345a(r11);
        r10 = r10.m7350a();
        r11 = new com.google.android.gms.ads.c$a;
        r11.<init>();
        r11 = r11.m7405a();
        r10.m7397a(r11);
        return;
    L_0x00ec:
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r13 = r9.mo2825J();
        r13 = com.facebook.ads.internal.adapters.C1342v.m4609a(r13);
        r12.append(r13);
        r13 = " AN server error";
        r12.append(r13);
        r12 = r12.toString();
        com.facebook.ads.internal.p105q.p106a.C1496d.m5271a(r10, r12);
        r10 = com.facebook.ads.internal.protocol.AdErrorType.SERVER_ERROR;
        r12 = "Server Error";
        r10 = com.facebook.ads.internal.protocol.C1481a.m5241a(r10, r12);
        r11.mo898a(r9, r10);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.d.a(android.content.Context, com.facebook.ads.internal.adapters.z, com.facebook.ads.internal.m.c, java.util.Map, com.facebook.ads.internal.n.f$c):void");
    }

    /* renamed from: a */
    public void mo2828a(View view, List<View> list) {
        this.f12292b = view;
        if (c_()) {
            if (view != null) {
                ViewGroup viewGroup = null;
                int i = -1;
                do {
                    ViewGroup viewGroup2 = (ViewGroup) view.getParent();
                    if (viewGroup2 != null) {
                        if (viewGroup2 instanceof C2612e) {
                            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
                            if (viewGroup3 != null) {
                                int indexOfChild = viewGroup3.indexOfChild(viewGroup2);
                                viewGroup2.removeView(view);
                                viewGroup3.removeView(viewGroup2);
                                viewGroup3.addView(view, indexOfChild);
                                continue;
                            }
                        } else {
                            i = viewGroup2.indexOfChild(view);
                            viewGroup = viewGroup2;
                            continue;
                        }
                    }
                    Log.e(f12291a, "View must have valid parent for AdMob registration, skipping registration. Impressions and clicks will not be logged.");
                    return;
                } while (viewGroup == null);
                View c4262j = this.f12293c instanceof C4261i ? new C4262j(view.getContext()) : new C4260h(view.getContext());
                if (view instanceof ViewGroup) {
                    c4262j.setLayoutParams(view.getLayoutParams());
                }
                m15503a(view);
                c4262j.addView(view);
                viewGroup.removeView(c4262j);
                viewGroup.addView(c4262j, i);
                this.f12295e = c4262j;
                this.f12295e.setNativeAd(this.f12293c);
                this.f12296f = new View(view.getContext());
                this.f12295e.addView(this.f12296f);
                this.f12296f.setVisibility(8);
                if (this.f12295e instanceof C4262j) {
                    ((C4262j) this.f12295e).setCallToActionView(this.f12296f);
                } else if (this.f12295e instanceof C4260h) {
                    ((C4260h) this.f12295e).setCallToActionView(this.f12296f);
                }
                OnClickListener c13254 = new C13254(this);
                for (View onClickListener : list) {
                    onClickListener.setOnClickListener(c13254);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo2829a(C1346z c1346z) {
        this.f12294d = c1346z;
    }

    /* renamed from: a */
    public void mo2830a(Map<String, String> map) {
        if (c_() && this.f12294d != null) {
            this.f12294d.mo899b(this);
        }
    }

    /* renamed from: b */
    public void mo2831b(Map<String, String> map) {
    }

    public void b_() {
        m15503a(this.f12296f);
        this.f12296f = null;
        if (this.f12292b != null) {
            View view = (ViewGroup) this.f12292b.getParent();
            if ((view instanceof C4262j) || (view instanceof C4260h)) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    int indexOfChild = viewGroup.indexOfChild(view);
                    m15503a(this.f12292b);
                    m15503a(view);
                    viewGroup.addView(this.f12292b, indexOfChild);
                }
            }
            this.f12292b = null;
        }
        this.f12295e = null;
    }

    /* renamed from: c */
    public String mo2833c() {
        return null;
    }

    public boolean c_() {
        return this.f12297g && this.f12293c != null;
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
        return false;
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
        return (!c_() || this.f12299i == null) ? null : new C1427h(this.f12299i.toString(), 50, 50);
    }

    /* renamed from: l */
    public C1427h mo2843l() {
        return (!c_() || this.f12298h == null) ? null : new C1427h(this.f12298h.toString(), 1200, 600);
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
        this.f12294d = null;
        this.f12293c = null;
        this.f12297g = false;
        this.f12298h = null;
        this.f12299i = null;
        this.f12300j = null;
        this.f12301k = null;
        this.f12302l = null;
        this.f12303m = null;
    }

    /* renamed from: p */
    public String mo2848p() {
        return this.f12301k;
    }

    /* renamed from: q */
    public String mo2849q() {
        return this.f12302l;
    }

    /* renamed from: r */
    public String mo2850r() {
        return this.f12303m;
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
        return null;
    }
}
