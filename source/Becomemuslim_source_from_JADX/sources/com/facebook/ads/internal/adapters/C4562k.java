package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.facebook.ads.AdError;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.internal.adapters.p086a.C1315g;
import com.facebook.ads.internal.adapters.p086a.C1316h;
import com.facebook.ads.internal.p085a.C1301e;
import com.facebook.ads.internal.p089d.C1359a;
import com.facebook.ads.internal.p089d.C1364b;
import com.facebook.ads.internal.p093h.C1389d;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.settings.C1550a.C1549a;
import com.facebook.ads.internal.view.C1566a;
import com.facebook.ads.p084a.C1288a;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.k */
public class C4562k extends InterstitialAdapter {
    /* renamed from: a */
    private static final ConcurrentMap<String, C1566a> f12332a = new ConcurrentHashMap();
    /* renamed from: b */
    private final String f12333b = UUID.randomUUID().toString();
    /* renamed from: c */
    private String f12334c;
    /* renamed from: d */
    private long f12335d;
    /* renamed from: e */
    private Context f12336e;
    /* renamed from: f */
    private C1339t f12337f;
    /* renamed from: g */
    private InterstitialAdapterListener f12338g;
    /* renamed from: h */
    private boolean f12339h = false;
    /* renamed from: i */
    private C3568p f12340i;
    /* renamed from: j */
    private C1331a f12341j = C1331a.UNSPECIFIED;
    /* renamed from: k */
    private C1315g f12342k;
    /* renamed from: l */
    private C1549a f12343l;
    /* renamed from: m */
    private boolean f12344m;

    /* renamed from: com.facebook.ads.internal.adapters.k$a */
    public enum C1331a {
        UNSPECIFIED,
        VERTICAL,
        HORIZONTAL;

        /* renamed from: a */
        public static C1331a m4602a(int i) {
            return i == 0 ? UNSPECIFIED : i == 2 ? HORIZONTAL : VERTICAL;
        }
    }

    /* renamed from: com.facebook.ads.internal.adapters.k$4 */
    class C35654 implements C1359a {
        /* renamed from: a */
        final /* synthetic */ C4562k f9516a;

        C35654(C4562k c4562k) {
            this.f9516a = c4562k;
        }

        /* renamed from: c */
        private void m11552c() {
            this.f9516a.f12339h = true;
            this.f9516a.f12338g.onInterstitialAdLoaded(this.f9516a);
        }

        /* renamed from: a */
        public void mo882a() {
            m11552c();
        }

        /* renamed from: b */
        public void mo883b() {
            m11552c();
        }
    }

    /* renamed from: a */
    private int m15578a() {
        int rotation = ((WindowManager) this.f12336e.getSystemService("window")).getDefaultDisplay().getRotation();
        if (this.f12341j == C1331a.UNSPECIFIED) {
            return -1;
        }
        if (this.f12341j != C1331a.HORIZONTAL) {
            return rotation != 2 ? 1 : 9;
        } else {
            switch (rotation) {
                case 2:
                case 3:
                    return 8;
                default:
                    return 0;
            }
        }
    }

    /* renamed from: a */
    public static C1566a m15581a(String str) {
        return (C1566a) f12332a.get(str);
    }

    /* renamed from: a */
    public static void m15582a(C1566a c1566a) {
        for (Entry entry : f12332a.entrySet()) {
            if (entry.getValue() == c1566a) {
                f12332a.remove(entry.getKey());
            }
        }
    }

    /* renamed from: b */
    private static void m15586b(String str, C1566a c1566a) {
        f12332a.put(str, c1566a);
    }

    public void loadInterstitialAd(Context context, InterstitialAdapterListener interstitialAdapterListener, Map<String, Object> map, C1412c c1412c, final EnumSet<CacheFlag> enumSet) {
        this.f12336e = context;
        this.f12338g = interstitialAdapterListener;
        this.f12334c = (String) map.get(AudienceNetworkActivity.PLACEMENT_ID);
        this.f12335d = ((Long) map.get(AudienceNetworkActivity.REQUEST_TIME)).longValue();
        JSONObject jSONObject = (JSONObject) map.get("data");
        C1389d c1389d = (C1389d) map.get("definition");
        if (jSONObject.has("markup")) {
            this.f12343l = C1549a.INTERSTITIAL_WEB_VIEW;
            this.f12340i = C3568p.m11559a(jSONObject);
            if (C1301e.m4451a(context, this.f12340i, c1412c)) {
                interstitialAdapterListener.onInterstitialError(this, AdError.NO_FILL);
                return;
            }
            this.f12337f = new C1339t(context, this.f12333b, this, this.f12338g);
            this.f12337f.m4606a();
            Map f = this.f12340i.m11567f();
            if (f.containsKey("orientation")) {
                this.f12341j = C1331a.m4602a(Integer.parseInt((String) f.get("orientation")));
            }
            this.f12339h = true;
            if (this.f12338g != null) {
                this.f12338g.onInterstitialAdLoaded(this);
            }
        } else if (jSONObject.has("video")) {
            this.f12343l = C1549a.INTERSTITIAL_OLD_NATIVE_VIDEO;
            this.f12337f = new C1339t(context, this.f12333b, this, this.f12338g);
            this.f12337f.m4606a();
            final C4844l c4844l = new C4844l();
            c4844l.mo2860a(context, new C1288a(this) {
                /* renamed from: b */
                final /* synthetic */ C4562k f9511b;

                /* renamed from: a */
                public void mo861a(C3570s c3570s) {
                    this.f9511b.f12339h = true;
                    if (this.f9511b.f12338g != null) {
                        this.f9511b.f12338g.onInterstitialAdLoaded(this.f9511b);
                    }
                }

                /* renamed from: a */
                public void mo862a(C3570s c3570s, View view) {
                    this.f9511b.f12341j = c4844l.m17230k();
                    C4562k.m15586b(this.f9511b.f12333b, c4844l);
                }

                /* renamed from: a */
                public void mo863a(C3570s c3570s, AdError adError) {
                    c4844l.m17231l();
                    this.f9511b.f12338g.onInterstitialError(this.f9511b, adError);
                }

                /* renamed from: b */
                public void mo864b(C3570s c3570s) {
                    this.f9511b.f12338g.onInterstitialAdClicked(this.f9511b, "", true);
                }

                /* renamed from: c */
                public void mo865c(C3570s c3570s) {
                    this.f9511b.f12338g.onInterstitialLoggingImpression(this.f9511b);
                }

                /* renamed from: d */
                public void mo866d(C3570s c3570s) {
                }
            }, (Map) map, c1412c, (EnumSet) enumSet);
        } else {
            C1364b c1364b;
            C1359a c35632;
            this.f12342k = C1315g.m4521a(jSONObject, context);
            if (c1389d != null) {
                this.f12342k.m4524a(c1389d.m4776k());
            }
            if (this.f12342k.m4527d().size() == 0) {
                this.f12338g.onInterstitialError(this, AdError.NO_FILL);
            }
            this.f12337f = new C1339t(context, this.f12333b, this, this.f12338g);
            this.f12337f.m4606a();
            if (jSONObject.has("carousel")) {
                this.f12343l = C1549a.INTERSTITIAL_NATIVE_CAROUSEL;
                c1364b = new C1364b(context);
                c1364b.m4659a(this.f12342k.m4523a().m4546b(), -1, -1);
                List<C1316h> d = this.f12342k.m4527d();
                boolean contains = enumSet.contains(CacheFlag.VIDEO);
                for (C1316h c1316h : d) {
                    c1364b.m4659a(c1316h.m4535c().m4491g(), c1316h.m4535c().m4493i(), c1316h.m4535c().m4492h());
                    if (contains && !TextUtils.isEmpty(c1316h.m4535c().m4484a())) {
                        c1364b.m4658a(c1316h.m4535c().m4491g());
                    }
                }
                c35632 = new C1359a(this) {
                    /* renamed from: b */
                    final /* synthetic */ C4562k f9513b;

                    /* renamed from: a */
                    private void m11546a(boolean z) {
                        int contains = enumSet.contains(CacheFlag.NONE) ^ 1;
                        C4562k c4562k = this.f9513b;
                        z = z && contains != 0;
                        c4562k.f12344m = z;
                        this.f9513b.f12339h = true;
                        this.f9513b.f12338g.onInterstitialAdLoaded(this.f9513b);
                    }

                    /* renamed from: a */
                    public void mo882a() {
                        m11546a(true);
                    }

                    /* renamed from: b */
                    public void mo883b() {
                        m11546a(false);
                    }
                };
            } else if (jSONObject.has("video_url")) {
                this.f12343l = C1549a.INTERSTITIAL_NATIVE_VIDEO;
                c1364b = new C1364b(context);
                r7 = ((C1316h) this.f12342k.m4527d().get(0)).m4535c();
                c1364b.m4659a(r7.m4491g(), r7.m4493i(), r7.m4492h());
                c1364b.m4659a(this.f12342k.m4523a().m4546b(), -1, -1);
                if (enumSet.contains(CacheFlag.VIDEO)) {
                    c1364b.m4658a(r7.m4484a());
                }
                c35632 = new C1359a(this) {
                    /* renamed from: b */
                    final /* synthetic */ C4562k f9515b;

                    /* renamed from: a */
                    private void m11549a(boolean z) {
                        this.f9515b.f12344m = z;
                        this.f9515b.f12339h = true;
                        this.f9515b.f12338g.onInterstitialAdLoaded(this.f9515b);
                    }

                    /* renamed from: a */
                    public void mo882a() {
                        m11549a(enumSet.contains(CacheFlag.VIDEO));
                    }

                    /* renamed from: b */
                    public void mo883b() {
                        m11549a(false);
                    }
                };
            } else {
                this.f12343l = C1549a.INTERSTITIAL_NATIVE_IMAGE;
                c1364b = new C1364b(context);
                r7 = ((C1316h) this.f12342k.m4527d().get(0)).m4535c();
                c1364b.m4659a(r7.m4491g(), r7.m4493i(), r7.m4492h());
                c1364b.m4659a(this.f12342k.m4523a().m4546b(), -1, -1);
                c35632 = new C35654(this);
            }
            c1364b.m4657a(c35632);
        }
    }

    public void onDestroy() {
        if (this.f12337f != null) {
            this.f12337f.m4607b();
        }
    }

    public boolean show() {
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
        r4 = this;
        r0 = r4.f12339h;
        if (r0 != 0) goto L_0x0011;
    L_0x0004:
        r0 = r4.f12338g;
        if (r0 == 0) goto L_0x000f;
    L_0x0008:
        r0 = r4.f12338g;
        r1 = com.facebook.ads.AdError.INTERNAL_ERROR;
        r0.onInterstitialError(r4, r1);
    L_0x000f:
        r0 = 0;
        return r0;
    L_0x0011:
        r0 = new android.content.Intent;
        r1 = r4.f12336e;
        r2 = com.facebook.ads.AudienceNetworkActivity.class;
        r0.<init>(r1, r2);
        r1 = "predefinedOrientationKey";
        r2 = r4.m15578a();
        r0.putExtra(r1, r2);
        r1 = "uniqueId";
        r2 = r4.f12333b;
        r0.putExtra(r1, r2);
        r1 = "placementId";
        r2 = r4.f12334c;
        r0.putExtra(r1, r2);
        r1 = "requestTime";
        r2 = r4.f12335d;
        r0.putExtra(r1, r2);
        r1 = "viewType";
        r2 = r4.f12343l;
        r0.putExtra(r1, r2);
        r1 = "useCache";
        r2 = r4.f12344m;
        r0.putExtra(r1, r2);
        r1 = r4.f12342k;
        if (r1 == 0) goto L_0x0052;
    L_0x004a:
        r1 = "ad_data_bundle";
        r2 = r4.f12342k;
        r0.putExtra(r1, r2);
        goto L_0x005b;
    L_0x0052:
        r1 = r4.f12340i;
        if (r1 == 0) goto L_0x005b;
    L_0x0056:
        r1 = r4.f12340i;
        r1.m11562a(r0);
    L_0x005b:
        r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.addFlags(r1);
        r1 = r4.f12336e;	 Catch:{ ActivityNotFoundException -> 0x0066 }
        r1.startActivity(r0);	 Catch:{ ActivityNotFoundException -> 0x0066 }
        goto L_0x0072;
    L_0x0066:
        r1 = r4.f12336e;
        r2 = com.facebook.ads.InterstitialAdActivity.class;
        r0.setClass(r1, r2);
        r1 = r4.f12336e;
        r1.startActivity(r0);
    L_0x0072:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.adapters.k.show():boolean");
    }
}
