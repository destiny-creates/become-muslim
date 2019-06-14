package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.internal.p087b.C1347b;
import com.facebook.ads.internal.p087b.C1349c;
import com.facebook.ads.internal.p089d.C1359a;
import com.facebook.ads.internal.p089d.C1364b;
import com.facebook.ads.internal.p095j.C1402f;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1513p;
import com.facebook.ads.internal.p105q.p108c.C1535d;
import com.facebook.ads.internal.p105q.p108c.C1535d.C1534a;
import com.facebook.ads.internal.view.p120f.C3640a;
import com.facebook.ads.internal.view.p120f.C3684c;
import com.facebook.ads.internal.view.p120f.C4584b;
import com.facebook.ads.internal.view.p120f.p121a.C1624a;
import com.facebook.ads.internal.view.p120f.p121a.C1625b;
import com.facebook.ads.internal.view.p120f.p122b.C3647a;
import com.facebook.ads.internal.view.p120f.p122b.C3648b;
import com.facebook.ads.internal.view.p120f.p122b.C3650d;
import com.facebook.ads.internal.view.p120f.p122b.C3658l;
import com.facebook.ads.internal.view.p120f.p123c.C3675d;
import com.facebook.ads.internal.view.p120f.p123c.C3675d.C1640a;
import com.facebook.ads.internal.view.p120f.p123c.C4585a;
import com.facebook.ads.internal.view.p120f.p123c.C4589b;
import com.facebook.ads.internal.view.p120f.p123c.C4590c;
import com.facebook.ads.internal.view.p120f.p123c.C4595e;
import com.facebook.ads.internal.view.p120f.p123c.C4603i;
import com.facebook.ads.internal.view.p120f.p123c.C4607k;
import com.facebook.ads.internal.view.p120f.p123c.C4611l;
import com.facebook.ads.p084a.C1288a;
import com.facebook.appevents.UserDataStore;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.j */
public class C4561j extends C3570s implements C1513p<Bundle> {
    /* renamed from: e */
    static final /* synthetic */ boolean f12316e = (C4561j.class.desiredAssertionStatus() ^ 1);
    /* renamed from: a */
    protected C1412c f12317a;
    /* renamed from: b */
    protected C3640a f12318b;
    /* renamed from: c */
    protected JSONObject f12319c;
    /* renamed from: d */
    protected Context f12320d;
    /* renamed from: f */
    private final C1402f<C3648b> f12321f = new C35561(this);
    /* renamed from: g */
    private final C1402f<C3658l> f12322g = new C35572(this);
    /* renamed from: h */
    private final C1402f<C3650d> f12323h = new C35583(this);
    /* renamed from: i */
    private final C1402f<C3647a> f12324i = new C35594(this);
    /* renamed from: j */
    private C1288a f12325j;
    /* renamed from: k */
    private String f12326k;
    /* renamed from: l */
    private boolean f12327l = false;
    /* renamed from: m */
    private C3684c f12328m;
    /* renamed from: n */
    private String f12329n;
    /* renamed from: o */
    private boolean f12330o = false;
    /* renamed from: p */
    private C1364b f12331p;

    /* renamed from: com.facebook.ads.internal.adapters.j$1 */
    class C35561 extends C1402f<C3648b> {
        /* renamed from: a */
        final /* synthetic */ C4561j f9504a;

        C35561(C4561j c4561j) {
            this.f9504a = c4561j;
        }

        /* renamed from: a */
        public Class<C3648b> mo930a() {
            return C3648b.class;
        }

        /* renamed from: a */
        public void m11527a(C3648b c3648b) {
            if (this.f9504a.f12325j != null) {
                this.f9504a.f12325j.mo866d(this.f9504a);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.adapters.j$2 */
    class C35572 extends C1402f<C3658l> {
        /* renamed from: a */
        final /* synthetic */ C4561j f9505a;

        C35572(C4561j c4561j) {
            this.f9505a = c4561j;
        }

        /* renamed from: a */
        public Class<C3658l> mo930a() {
            return C3658l.class;
        }

        /* renamed from: a */
        public void m11530a(C3658l c3658l) {
            this.f9505a.f12327l = true;
            if (this.f9505a.f12325j != null) {
                this.f9505a.f12325j.mo861a(this.f9505a);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.adapters.j$3 */
    class C35583 extends C1402f<C3650d> {
        /* renamed from: a */
        final /* synthetic */ C4561j f9506a;

        C35583(C4561j c4561j) {
            this.f9506a = c4561j;
        }

        /* renamed from: a */
        public Class<C3650d> mo930a() {
            return C3650d.class;
        }

        /* renamed from: a */
        public void m11533a(C3650d c3650d) {
            if (this.f9506a.f12325j != null) {
                this.f9506a.f12325j.mo863a(this.f9506a, AdError.INTERNAL_ERROR);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.adapters.j$4 */
    class C35594 extends C1402f<C3647a> {
        /* renamed from: a */
        final /* synthetic */ C4561j f9507a;

        C35594(C4561j c4561j) {
            this.f9507a = c4561j;
        }

        /* renamed from: a */
        public Class<C3647a> mo930a() {
            return C3647a.class;
        }

        /* renamed from: a */
        public void m11536a(C3647a c3647a) {
            if (this.f9507a.f12325j != null) {
                this.f9507a.f12325j.mo864b(this.f9507a);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.adapters.j$6 */
    class C35616 implements C1359a {
        /* renamed from: a */
        final /* synthetic */ C4561j f9509a;

        C35616(C4561j c4561j) {
            this.f9509a = c4561j;
        }

        /* renamed from: a */
        public void mo882a() {
            this.f9509a.f12318b.setVideoURI(this.f9509a.mo3349h());
        }

        /* renamed from: b */
        public void mo883b() {
            this.f9509a.f12318b.setVideoURI(this.f9509a.mo3349h());
        }
    }

    /* renamed from: a */
    private void m15565a(Context context, C1288a c1288a, JSONObject jSONObject, C1412c c1412c, Bundle bundle, EnumSet<CacheFlag> enumSet, int i) {
        Context context2 = context;
        JSONObject jSONObject2 = jSONObject;
        Bundle bundle2 = bundle;
        this.f12320d = context2;
        this.f12325j = c1288a;
        this.f12317a = c1412c;
        this.f12319c = jSONObject2;
        this.f12327l = false;
        JSONObject jSONObject3 = jSONObject2.getJSONObject("video");
        this.f12329n = jSONObject2.optString(UserDataStore.CITY);
        this.f12318b = new C3640a(context2);
        this.f12318b.setVideoProgressReportIntervalMs(i);
        mo3348a();
        this.f12318b.getEventBus().m4804a(this.f12321f, this.f12322g, this.f12323h, this.f12324i);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1347b(this, 1.0E-7d, -1.0d, 0.001d, false) {
            /* renamed from: a */
            final /* synthetic */ C4561j f9508a;

            /* renamed from: a */
            protected void mo932a(boolean z, boolean z2, C1349c c1349c) {
                this.f9508a.m15576f();
            }
        });
        if (bundle2 != null) {
            r9.f12328m = new C4584b(context, c1412c, r9.f12318b, arrayList, r9.f12329n, bundle2.getBundle("logger"), null);
        } else {
            r9.f12328m = new C4584b(context, c1412c, r9.f12318b, (List) arrayList, r9.f12329n);
        }
        r9.f12325j.mo862a(r9, r9.f12318b);
        String str = (C1535d.m5375c(context) == C1534a.MOBILE_INTERNET && jSONObject3.has("videoHDURL") && !jSONObject3.isNull("videoHDURL")) ? "videoHDURL" : AudienceNetworkActivity.VIDEO_URL;
        r9.f12326k = jSONObject3.getString(str);
        if (enumSet.contains(CacheFlag.VIDEO)) {
            r9.f12331p = new C1364b(context2);
            r9.f12331p.m4658a(r9.f12326k);
            r9.f12331p.m4657a(new C35616(r9));
            return;
        }
        r9.f12318b.setVideoURI(mo3349h());
    }

    /* renamed from: h */
    private String mo3349h() {
        Object obj = "";
        if (!(this.f12331p == null || this.f12326k == null)) {
            obj = this.f12331p.m4660b(this.f12326k);
        }
        return TextUtils.isEmpty(obj) ? this.f12326k : obj;
    }

    /* renamed from: a */
    protected void mo3348a() {
        if (!f12316e) {
            if (this.f12320d == null) {
                throw new AssertionError();
            }
        }
        if (!f12316e) {
            if (this.f12319c == null) {
                throw new AssertionError();
            }
        }
        JSONObject optJSONObject = this.f12319c.optJSONObject("text");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        this.f12318b.m11915a(new C4607k(this.f12320d));
        C1625b c4611l = new C4611l(this.f12320d);
        this.f12318b.m11915a(c4611l);
        this.f12318b.m11915a(new C3675d(c4611l, C1640a.INVSIBLE));
        this.f12318b.m11915a(new C4589b(this.f12320d));
        String b = m15572b();
        if (b != null) {
            C1625b c4590c = new C4590c(this.f12320d, b);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            c4590c.setLayoutParams(layoutParams);
            c4590c.setCountdownTextColor(-1);
            this.f12318b.m11915a(c4590c);
        }
        if (this.f12319c.has("cta") && !this.f12319c.isNull("cta")) {
            JSONObject jSONObject = this.f12319c.getJSONObject("cta");
            C1625b c4595e = new C4595e(this.f12320d, jSONObject.getString("url"), this.f12317a, this.f12329n, jSONObject.getString("text"));
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            c4595e.setLayoutParams(layoutParams);
            this.f12318b.m11915a(c4595e);
        }
        Object d = m15574d();
        if (!TextUtils.isEmpty(d)) {
            this.f12318b.m11915a(new C4585a(this.f12320d, d, this.f12329n, new float[]{0.0f, 0.0f, 8.0f, 0.0f}));
        }
        int c = m15573c();
        if (c > 0) {
            c4595e = new C4603i(this.f12320d, c, optJSONObject.optString("skipAdIn", "Skip Ad in"), optJSONObject.optString("skipAd", "Skip Ad"));
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(12);
            layoutParams2.addRule(11);
            c4595e.setLayoutParams(layoutParams2);
            c4595e.setPadding(0, 0, 0, 30);
            this.f12318b.m11915a(c4595e);
        }
    }

    /* renamed from: a */
    public final void m15570a(android.content.Context r9, com.facebook.ads.p084a.C1288a r10, com.facebook.ads.internal.p098m.C1412c r11, android.os.Bundle r12, java.util.EnumSet<com.facebook.ads.CacheFlag> r13) {
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
        r8 = this;
        r3 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x001d }
        r0 = "ad_response";	 Catch:{ JSONException -> 0x001d }
        r0 = r12.getString(r0);	 Catch:{ JSONException -> 0x001d }
        r3.<init>(r0);	 Catch:{ JSONException -> 0x001d }
        r0 = "video_time_polling_interval";	 Catch:{ JSONException -> 0x001d }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ JSONException -> 0x001d }
        r7 = r3.optInt(r0, r1);	 Catch:{ JSONException -> 0x001d }
        r0 = r8;	 Catch:{ JSONException -> 0x001d }
        r1 = r9;	 Catch:{ JSONException -> 0x001d }
        r2 = r10;	 Catch:{ JSONException -> 0x001d }
        r4 = r11;	 Catch:{ JSONException -> 0x001d }
        r5 = r12;	 Catch:{ JSONException -> 0x001d }
        r6 = r13;	 Catch:{ JSONException -> 0x001d }
        r0.m15565a(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ JSONException -> 0x001d }
        goto L_0x0022;
    L_0x001d:
        r9 = com.facebook.ads.AdError.INTERNAL_ERROR;
        r10.mo863a(r8, r9);
    L_0x0022:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.j.a(android.content.Context, com.facebook.ads.a.a, com.facebook.ads.internal.m.c, android.os.Bundle, java.util.EnumSet):void");
    }

    /* renamed from: a */
    public final void mo2860a(android.content.Context r10, com.facebook.ads.p084a.C1288a r11, java.util.Map<java.lang.String, java.lang.Object> r12, com.facebook.ads.internal.p098m.C1412c r13, java.util.EnumSet<com.facebook.ads.CacheFlag> r14) {
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
        r9 = this;
        r0 = "data";	 Catch:{ JSONException -> 0x0027 }
        r0 = r12.get(r0);	 Catch:{ JSONException -> 0x0027 }
        r4 = r0;	 Catch:{ JSONException -> 0x0027 }
        r4 = (org.json.JSONObject) r4;	 Catch:{ JSONException -> 0x0027 }
        r0 = "definition";	 Catch:{ JSONException -> 0x0027 }
        r12 = r12.get(r0);	 Catch:{ JSONException -> 0x0027 }
        r12 = (com.facebook.ads.internal.p093h.C1389d) r12;	 Catch:{ JSONException -> 0x0027 }
        if (r12 != 0) goto L_0x0018;	 Catch:{ JSONException -> 0x0027 }
    L_0x0013:
        r12 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ JSONException -> 0x0027 }
        r8 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ JSONException -> 0x0027 }
        goto L_0x001d;	 Catch:{ JSONException -> 0x0027 }
    L_0x0018:
        r12 = r12.m4776k();	 Catch:{ JSONException -> 0x0027 }
        r8 = r12;	 Catch:{ JSONException -> 0x0027 }
    L_0x001d:
        r6 = 0;	 Catch:{ JSONException -> 0x0027 }
        r1 = r9;	 Catch:{ JSONException -> 0x0027 }
        r2 = r10;	 Catch:{ JSONException -> 0x0027 }
        r3 = r11;	 Catch:{ JSONException -> 0x0027 }
        r5 = r13;	 Catch:{ JSONException -> 0x0027 }
        r7 = r14;	 Catch:{ JSONException -> 0x0027 }
        r1.m15565a(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ JSONException -> 0x0027 }
        goto L_0x002c;
    L_0x0027:
        r10 = com.facebook.ads.AdError.INTERNAL_ERROR;
        r11.mo863a(r9, r10);
    L_0x002c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.j.a(android.content.Context, com.facebook.ads.a.a, java.util.Map, com.facebook.ads.internal.m.c, java.util.EnumSet):void");
    }

    /* renamed from: b */
    protected String m15572b() {
        if (!f12316e) {
            if (this.f12319c == null) {
                throw new AssertionError();
            }
        }
        try {
            JSONObject jSONObject = this.f12319c.getJSONObject("capabilities");
            if (jSONObject.has("countdown")) {
                if (!jSONObject.isNull("countdown")) {
                    jSONObject = jSONObject.getJSONObject("countdown");
                    if (jSONObject.has("format")) {
                        return jSONObject.optString("format");
                    }
                }
            }
            return null;
        } catch (Throwable e) {
            Log.w(String.valueOf(C4561j.class), "Invalid JSON", e);
            return null;
        }
    }

    /* renamed from: c */
    protected int m15573c() {
        if (!f12316e) {
            if (this.f12319c == null) {
                throw new AssertionError();
            }
        }
        try {
            JSONObject jSONObject = this.f12319c.getJSONObject("capabilities");
            if (jSONObject.has("skipButton")) {
                if (!jSONObject.isNull("skipButton")) {
                    jSONObject = jSONObject.getJSONObject("skipButton");
                    if (jSONObject.has("skippableSeconds")) {
                        return jSONObject.getInt("skippableSeconds");
                    }
                }
            }
            return -1;
        } catch (Throwable e) {
            Log.w(String.valueOf(C4561j.class), "Invalid JSON", e);
            return -1;
        }
    }

    /* renamed from: d */
    protected String m15574d() {
        if (!f12316e) {
            if (this.f12319c == null) {
                throw new AssertionError();
            }
        }
        try {
            JSONObject jSONObject = this.f12319c.getJSONObject("capabilities");
            if (jSONObject.has("adChoices")) {
                if (!jSONObject.isNull("adChoices")) {
                    jSONObject = jSONObject.getJSONObject("adChoices");
                    if (jSONObject.has("url")) {
                        return jSONObject.getString("url");
                    }
                }
            }
            return null;
        } catch (Throwable e) {
            Log.w(String.valueOf(C4561j.class), "Invalid JSON", e);
            return null;
        }
    }

    /* renamed from: e */
    public boolean mo2861e() {
        if (this.f12327l) {
            if (this.f12318b != null) {
                if (this.f12328m.m12062j() > 0) {
                    this.f12318b.m11912a(this.f12328m.m12062j());
                }
                this.f12318b.m11914a(C1624a.AUTO_STARTED);
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    protected void m15576f() {
        if (this.f12317a != null && !this.f12330o) {
            this.f12330o = true;
            this.f12317a.mo945a(this.f12329n, new HashMap());
            if (this.f12325j != null) {
                this.f12325j.mo865c(this);
            }
        }
    }

    /* renamed from: g */
    public Bundle mo937g() {
        if (this.f12328m != null) {
            if (this.f12319c != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("logger", this.f12328m.mo937g());
                bundle.putString("ad_response", this.f12319c.toString());
                return bundle;
            }
        }
        return null;
    }

    public void onDestroy() {
        if (this.f12318b != null) {
            this.f12318b.m11921f();
            this.f12318b.m11926k();
        }
        this.f12325j = null;
        this.f12317a = null;
        this.f12326k = null;
        this.f12327l = false;
        this.f12329n = null;
        this.f12318b = null;
        this.f12328m = null;
        this.f12319c = null;
        this.f12320d = null;
        this.f12330o = false;
    }
}
