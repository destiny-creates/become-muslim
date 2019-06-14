package com.facebook.ads.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.amplitude.api.Constants;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSettings.TestAdType;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.BannerAdapter;
import com.facebook.ads.internal.adapters.BannerAdapterListener;
import com.facebook.ads.internal.adapters.C1322a;
import com.facebook.ads.internal.adapters.C1327e;
import com.facebook.ads.internal.adapters.C1340u;
import com.facebook.ads.internal.adapters.C1342v;
import com.facebook.ads.internal.adapters.C1346z;
import com.facebook.ads.internal.adapters.C3570s;
import com.facebook.ads.internal.adapters.C3572y;
import com.facebook.ads.internal.adapters.InterstitialAdapter;
import com.facebook.ads.internal.adapters.InterstitialAdapterListener;
import com.facebook.ads.internal.adapters.ab;
import com.facebook.ads.internal.adapters.ac;
import com.facebook.ads.internal.p093h.C1386a;
import com.facebook.ads.internal.p093h.C1388c;
import com.facebook.ads.internal.p093h.C1389d;
import com.facebook.ads.internal.p093h.C1390e;
import com.facebook.ads.internal.p094i.C1391a;
import com.facebook.ads.internal.p094i.C1394c;
import com.facebook.ads.internal.p095j.C1397a;
import com.facebook.ads.internal.p095j.C1398b;
import com.facebook.ads.internal.p097l.C1405a;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p098m.C3580d;
import com.facebook.ads.internal.p100o.C1434b;
import com.facebook.ads.internal.p100o.C1438c;
import com.facebook.ads.internal.p100o.C1438c.C1437a;
import com.facebook.ads.internal.p100o.C3593g;
import com.facebook.ads.internal.p105q.p106a.C1496d;
import com.facebook.ads.internal.p105q.p106a.C1509l;
import com.facebook.ads.internal.p105q.p106a.C1512o;
import com.facebook.ads.internal.p105q.p106a.C1524x;
import com.facebook.ads.internal.p105q.p108c.C1537e;
import com.facebook.ads.internal.p105q.p109d.C1540a;
import com.facebook.ads.internal.p105q.p109d.C1541b;
import com.facebook.ads.internal.p105q.p110e.C1542a;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.C1481a;
import com.facebook.ads.internal.protocol.C1482b;
import com.facebook.ads.internal.protocol.C1484c;
import com.facebook.ads.internal.protocol.C1485d;
import com.facebook.ads.internal.protocol.C1486e;
import com.facebook.ads.internal.protocol.C1487f;
import com.facebook.ads.internal.protocol.C1491h;
import com.facebook.ads.p084a.C1288a;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayAdController implements C1437a {
    /* renamed from: b */
    private static final String f9431b = DisplayAdController.class.getSimpleName();
    /* renamed from: h */
    private static final Handler f9432h = new Handler(Looper.getMainLooper());
    /* renamed from: i */
    private static boolean f9433i = false;
    /* renamed from: A */
    private boolean f9434A;
    /* renamed from: B */
    private final C1412c f9435B;
    /* renamed from: C */
    private final EnumSet<CacheFlag> f9436C;
    /* renamed from: a */
    protected C1322a f9437a;
    /* renamed from: c */
    private final Context f9438c;
    /* renamed from: d */
    private final String f9439d;
    /* renamed from: e */
    private final AdPlacementType f9440e;
    /* renamed from: f */
    private final C1438c f9441f;
    /* renamed from: g */
    private final Handler f9442g;
    /* renamed from: j */
    private final Runnable f9443j;
    /* renamed from: k */
    private final Runnable f9444k;
    /* renamed from: l */
    private volatile boolean f9445l;
    /* renamed from: m */
    private boolean f9446m;
    /* renamed from: n */
    private volatile boolean f9447n;
    /* renamed from: o */
    private AdAdapter f9448o;
    /* renamed from: p */
    private AdAdapter f9449p;
    /* renamed from: q */
    private View f9450q;
    /* renamed from: r */
    private C1388c f9451r;
    /* renamed from: s */
    private C1434b f9452s;
    /* renamed from: t */
    private C1487f f9453t;
    /* renamed from: u */
    private C1485d f9454u;
    /* renamed from: v */
    private C1486e f9455v;
    /* renamed from: w */
    private int f9456w;
    /* renamed from: x */
    private boolean f9457x;
    /* renamed from: y */
    private int f9458y;
    /* renamed from: z */
    private final C1294c f9459z;

    /* renamed from: com.facebook.ads.internal.DisplayAdController$5 */
    class C12925 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ DisplayAdController f3737a;

        C12925(DisplayAdController displayAdController) {
            this.f3737a = displayAdController;
        }

        public void run() {
            try {
                this.f3737a.m11469k();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.DisplayAdController$c */
    private class C1294c extends BroadcastReceiver {
        /* renamed from: a */
        final /* synthetic */ DisplayAdController f3740a;

        private C1294c(DisplayAdController displayAdController) {
            this.f3740a = displayAdController;
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                this.f3740a.m11471m();
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                this.f3740a.m11470l();
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.DisplayAdController$6 */
    class C35386 implements C1288a {
        /* renamed from: a */
        final /* synthetic */ DisplayAdController f9427a;

        C35386(DisplayAdController displayAdController) {
            this.f9427a = displayAdController;
        }

        /* renamed from: a */
        public void mo861a(C3570s c3570s) {
            this.f9427a.f9449p = c3570s;
            this.f9427a.f9447n = false;
            this.f9427a.f9437a.mo845a((AdAdapter) c3570s);
        }

        /* renamed from: a */
        public void mo862a(C3570s c3570s, View view) {
            this.f9427a.f9437a.mo844a(view);
        }

        /* renamed from: a */
        public void mo863a(C3570s c3570s, AdError adError) {
            this.f9427a.f9437a.mo846a(new C1481a(adError.getErrorCode(), adError.getErrorMessage()));
        }

        /* renamed from: b */
        public void mo864b(C3570s c3570s) {
            this.f9427a.f9437a.mo843a();
        }

        /* renamed from: c */
        public void mo865c(C3570s c3570s) {
            this.f9427a.f9437a.mo847b();
        }

        /* renamed from: d */
        public void mo866d(C3570s c3570s) {
            this.f9427a.f9437a.mo860c();
        }
    }

    /* renamed from: com.facebook.ads.internal.DisplayAdController$7 */
    class C35397 implements ac {
        /* renamed from: a */
        final /* synthetic */ DisplayAdController f9428a;

        C35397(DisplayAdController displayAdController) {
            this.f9428a = displayAdController;
        }

        /* renamed from: a */
        public void mo901a() {
            this.f9428a.f9437a.mo887g();
        }

        /* renamed from: a */
        public void mo902a(ab abVar) {
            this.f9428a.f9449p = abVar;
            this.f9428a.f9437a.mo845a((AdAdapter) abVar);
        }

        /* renamed from: a */
        public void mo903a(ab abVar, AdError adError) {
            this.f9428a.f9437a.mo846a(new C1481a(AdErrorType.INTERNAL_ERROR, null));
            this.f9428a.m11445a((AdAdapter) abVar);
            this.f9428a.m11467j();
        }

        /* renamed from: b */
        public void mo904b(ab abVar) {
            this.f9428a.f9437a.mo843a();
        }

        /* renamed from: c */
        public void mo905c(ab abVar) {
            this.f9428a.f9437a.mo847b();
        }

        /* renamed from: d */
        public void mo906d(ab abVar) {
            this.f9428a.f9437a.mo886f();
        }

        /* renamed from: e */
        public void mo907e(ab abVar) {
            this.f9428a.f9437a.mo888h();
        }

        /* renamed from: f */
        public void mo908f(ab abVar) {
            this.f9428a.f9437a.mo889i();
        }
    }

    /* renamed from: com.facebook.ads.internal.DisplayAdController$a */
    private static final class C3541a extends C1524x<DisplayAdController> {
        public C3541a(DisplayAdController displayAdController) {
            super(displayAdController);
        }

        public void run() {
            DisplayAdController displayAdController = (DisplayAdController) m5347a();
            if (displayAdController != null) {
                displayAdController.f9445l = false;
                displayAdController.m11455b(null);
            }
        }
    }

    /* renamed from: com.facebook.ads.internal.DisplayAdController$b */
    private static final class C3542b extends C1524x<DisplayAdController> {
        public C3542b(DisplayAdController displayAdController) {
            super(displayAdController);
        }

        public void run() {
            DisplayAdController displayAdController = (DisplayAdController) m5347a();
            if (displayAdController != null) {
                displayAdController.m11470l();
            }
        }
    }

    static {
        C1496d.m5270a();
    }

    public DisplayAdController(Context context, String str, C1487f c1487f, AdPlacementType adPlacementType, C1486e c1486e, C1485d c1485d, int i, boolean z) {
        this(context, str, c1487f, adPlacementType, c1486e, c1485d, i, z, EnumSet.of(CacheFlag.NONE));
    }

    public DisplayAdController(Context context, String str, C1487f c1487f, AdPlacementType adPlacementType, C1486e c1486e, C1485d c1485d, int i, boolean z, EnumSet<CacheFlag> enumSet) {
        this.f9442g = new Handler();
        this.f9457x = false;
        this.f9458y = -1;
        this.f9438c = context.getApplicationContext();
        this.f9439d = str;
        this.f9453t = c1487f;
        this.f9440e = adPlacementType;
        this.f9455v = c1486e;
        this.f9454u = c1485d;
        this.f9456w = i;
        this.f9459z = new C1294c();
        this.f9436C = enumSet;
        this.f9441f = new C1438c(this.f9438c);
        this.f9441f.m5084a((C1437a) this);
        this.f9443j = new C3541a(this);
        this.f9444k = new C3542b(this);
        this.f9446m = z;
        m11461g();
        try {
            CookieManager.getInstance();
            if (VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(this.f9438c);
            }
        } catch (Throwable e) {
            Log.w(f9431b, "Failed to initialize CookieManager.", e);
        }
        C1391a.m4778a(this.f9438c).m4779a();
        this.f9435B = C3580d.m11662a(this.f9438c);
    }

    /* renamed from: a */
    private Map<String, String> m11440a(long j) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("delay", String.valueOf(System.currentTimeMillis() - j));
        return hashMap;
    }

    /* renamed from: a */
    private void m11445a(AdAdapter adAdapter) {
        if (adAdapter != null) {
            adAdapter.onDestroy();
        }
    }

    /* renamed from: a */
    private void m11446a(final BannerAdapter bannerAdapter, C1388c c1388c, Map<String, Object> map) {
        final Runnable c12938 = new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ DisplayAdController f3739b;

            public void run() {
                this.f3739b.m11445a(bannerAdapter);
                this.f3739b.m11467j();
            }
        };
        this.f9442g.postDelayed(c12938, (long) c1388c.m4759a().m4775j());
        bannerAdapter.loadBannerAd(this.f9438c, this.f9435B, this.f9455v, new BannerAdapterListener(this) {
            /* renamed from: b */
            final /* synthetic */ DisplayAdController f9430b;

            public void onBannerAdClicked(BannerAdapter bannerAdapter) {
                this.f9430b.f9437a.mo843a();
            }

            public void onBannerAdExpanded(BannerAdapter bannerAdapter) {
            }

            public void onBannerAdLoaded(BannerAdapter bannerAdapter, View view) {
                if (bannerAdapter == this.f9430b.f9448o) {
                    this.f9430b.f9442g.removeCallbacks(c12938);
                    AdAdapter f = this.f9430b.f9449p;
                    this.f9430b.f9449p = bannerAdapter;
                    this.f9430b.f9450q = view;
                    if (this.f9430b.f9447n) {
                        this.f9430b.f9437a.mo844a(view);
                        this.f9430b.m11445a(f);
                    } else {
                        this.f9430b.f9437a.mo845a((AdAdapter) bannerAdapter);
                    }
                }
            }

            public void onBannerAdMinimized(BannerAdapter bannerAdapter) {
            }

            public void onBannerError(BannerAdapter bannerAdapter, AdError adError) {
                if (bannerAdapter == this.f9430b.f9448o) {
                    this.f9430b.f9442g.removeCallbacks(c12938);
                    this.f9430b.m11445a((AdAdapter) bannerAdapter);
                    this.f9430b.m11467j();
                }
            }

            public void onBannerLoggingImpression(BannerAdapter bannerAdapter) {
                this.f9430b.f9437a.mo847b();
            }
        }, map);
    }

    /* renamed from: a */
    private void m11447a(final InterstitialAdapter interstitialAdapter, C1388c c1388c, Map<String, Object> map) {
        final Runnable anonymousClass10 = new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ DisplayAdController f3727b;

            public void run() {
                this.f3727b.m11445a(interstitialAdapter);
                this.f3727b.m11467j();
            }
        };
        this.f9442g.postDelayed(anonymousClass10, (long) c1388c.m4759a().m4775j());
        interstitialAdapter.loadInterstitialAd(this.f9438c, new InterstitialAdapterListener(this) {
            /* renamed from: b */
            final /* synthetic */ DisplayAdController f9419b;

            public void onInterstitialAdClicked(InterstitialAdapter interstitialAdapter, String str, boolean z) {
                this.f9419b.f9437a.mo843a();
                int isEmpty = TextUtils.isEmpty(str) ^ 1;
                if (z && isEmpty != 0) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    if (!(this.f9419b.f9452s.f4247b instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    intent.setData(Uri.parse(str));
                    this.f9419b.f9452s.f4247b.startActivity(intent);
                }
            }

            public void onInterstitialAdDismissed(InterstitialAdapter interstitialAdapter) {
                this.f9419b.f9437a.mo868e();
            }

            public void onInterstitialAdDisplayed(InterstitialAdapter interstitialAdapter) {
                this.f9419b.f9437a.mo867d();
            }

            public void onInterstitialAdLoaded(InterstitialAdapter interstitialAdapter) {
                if (interstitialAdapter == this.f9419b.f9448o) {
                    if (interstitialAdapter == null) {
                        C1540a.m5396a(this.f9419b.f9438c, "api", C1541b.f4557b, new C1482b(AdErrorType.NO_ADAPTER_ON_LOAD, "Adapter is null on loadInterstitialAd"));
                        onInterstitialError(interstitialAdapter, AdError.INTERNAL_ERROR);
                        return;
                    }
                    this.f9419b.f9442g.removeCallbacks(anonymousClass10);
                    this.f9419b.f9449p = interstitialAdapter;
                    this.f9419b.f9437a.mo845a((AdAdapter) interstitialAdapter);
                    this.f9419b.m11470l();
                }
            }

            public void onInterstitialError(InterstitialAdapter interstitialAdapter, AdError adError) {
                if (interstitialAdapter == this.f9419b.f9448o) {
                    this.f9419b.f9442g.removeCallbacks(anonymousClass10);
                    this.f9419b.m11445a((AdAdapter) interstitialAdapter);
                    this.f9419b.m11467j();
                    this.f9419b.f9437a.mo846a(new C1481a(adError.getErrorCode(), adError.getErrorMessage()));
                }
            }

            public void onInterstitialLoggingImpression(InterstitialAdapter interstitialAdapter) {
                this.f9419b.f9437a.mo847b();
            }
        }, map, this.f9435B, this.f9436C);
    }

    /* renamed from: a */
    private void m11448a(ab abVar, C1388c c1388c, Map<String, Object> map) {
        abVar.mo2867a(this.f9438c, new C35397(this), map, this.f9457x);
    }

    /* renamed from: a */
    private void m11449a(C3570s c3570s, C1388c c1388c, Map<String, Object> map) {
        c3570s.mo2860a(this.f9438c, new C35386(this), map, this.f9435B, this.f9436C);
    }

    /* renamed from: a */
    private void m11450a(C3572y c3572y, C1388c c1388c, C1386a c1386a, Map<String, Object> map) {
        final C3572y c3572y2 = c3572y;
        final long currentTimeMillis = System.currentTimeMillis();
        final C1386a c1386a2 = c1386a;
        Runnable anonymousClass12 = new Runnable(this) {
            /* renamed from: d */
            final /* synthetic */ DisplayAdController f3731d;

            public void run() {
                this.f3731d.m11445a(c3572y2);
                if (c3572y2 instanceof C1340u) {
                    Context h = this.f3731d.f9438c;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(C1342v.m4609a(((C1340u) c3572y2).mo2825J()));
                    stringBuilder.append(" Failed. Ad request timed out");
                    C1496d.m5271a(h, stringBuilder.toString());
                }
                Map a = this.f3731d.m11440a(currentTimeMillis);
                a.put("error", "-1");
                a.put("msg", "timeout");
                this.f3731d.m11451a(c1386a2.m4754a(C1390e.REQUEST), a);
                this.f3731d.m11467j();
            }
        };
        this.f9442g.postDelayed(anonymousClass12, (long) c1388c.m4759a().m4775j());
        final Runnable runnable = anonymousClass12;
        c3572y.mo2827a(this.f9438c, new C1346z(this) {
            /* renamed from: a */
            boolean f9420a = false;
            /* renamed from: b */
            boolean f9421b = false;
            /* renamed from: c */
            boolean f9422c = false;
            /* renamed from: g */
            final /* synthetic */ DisplayAdController f9426g;

            /* renamed from: a */
            public void mo897a(C3572y c3572y) {
                if (c3572y == this.f9426g.f9448o) {
                    this.f9426g.f9442g.removeCallbacks(runnable);
                    this.f9426g.f9449p = c3572y;
                    this.f9426g.f9437a.mo845a((AdAdapter) c3572y);
                    if (!this.f9420a) {
                        this.f9420a = true;
                        this.f9426g.m11451a(c1386a2.m4754a(C1390e.REQUEST), this.f9426g.m11440a(currentTimeMillis));
                    }
                }
            }

            /* renamed from: a */
            public void mo898a(C3572y c3572y, C1481a c1481a) {
                if (c3572y == this.f9426g.f9448o) {
                    this.f9426g.f9442g.removeCallbacks(runnable);
                    this.f9426g.m11445a((AdAdapter) c3572y);
                    if (!this.f9420a) {
                        this.f9420a = true;
                        Map a = this.f9426g.m11440a(currentTimeMillis);
                        a.put("error", String.valueOf(c1481a.m5243a().getErrorCode()));
                        a.put("msg", String.valueOf(c1481a.m5244b()));
                        this.f9426g.m11451a(c1386a2.m4754a(C1390e.REQUEST), a);
                    }
                    this.f9426g.m11467j();
                }
            }

            /* renamed from: b */
            public void mo899b(C3572y c3572y) {
                if (!this.f9421b) {
                    this.f9421b = true;
                    this.f9426g.m11451a(c1386a2.m4754a(C1390e.IMPRESSION), null);
                }
            }

            /* renamed from: c */
            public void mo900c(C3572y c3572y) {
                if (!this.f9422c) {
                    this.f9422c = true;
                    this.f9426g.m11451a(c1386a2.m4754a(C1390e.CLICK), null);
                }
                if (this.f9426g.f9437a != null) {
                    this.f9426g.f9437a.mo843a();
                }
            }
        }, this.f9435B, map, NativeAdBase.getViewTraversalPredicate());
    }

    /* renamed from: a */
    private void m11451a(List<String> list, Map<String, String> map) {
        if (list == null) {
            return;
        }
        if (!list.isEmpty()) {
            for (String str : list) {
                new C1537e(this.f9438c, map).execute(new String[]{str});
            }
        }
    }

    /* renamed from: b */
    private void m11455b(String str) {
        try {
            r1.f9452s = new C1434b(r1.f9438c, new C1394c(r1.f9438c, false), r1.f9439d, r1.f9455v != null ? new C1509l(r1.f9455v.m5252b(), r1.f9455v.m5251a()) : null, r1.f9453t, r1.f9454u, AdSettings.getTestAdType() != TestAdType.DEFAULT ? AdSettings.getTestAdType().getAdTypeString() : null, C1327e.m4597a(C1484c.m5247a(r1.f9453t).m5248a()), r1.f9456w, AdSettings.isTestMode(r1.f9438c), AdSettings.isChildDirected(), new C1491h(this.f9438c, str, r1.f9439d, r1.f9453t), C1512o.m5316a(C1405a.m4837r(r1.f9438c)));
            r1.f9441f.m5083a(r1.f9452s);
        } catch (C1482b e) {
            mo916a(C1481a.m5242a(e));
        }
    }

    /* renamed from: g */
    private void m11461g() {
        if (!this.f9446m) {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.f9438c.registerReceiver(this.f9459z, intentFilter);
            this.f9434A = true;
        }
    }

    /* renamed from: h */
    private void m11464h() {
        if (this.f9434A) {
            try {
                this.f9438c.unregisterReceiver(this.f9459z);
                this.f9434A = false;
            } catch (Throwable e) {
                C1398b.m4797a(C1397a.m4794a(e, "Error unregistering screen state receiever"));
            }
        }
    }

    /* renamed from: i */
    private AdPlacementType m11466i() {
        return this.f9440e != null ? this.f9440e : this.f9455v == null ? AdPlacementType.NATIVE : this.f9455v == C1486e.INTERSTITIAL ? AdPlacementType.INTERSTITIAL : AdPlacementType.BANNER;
    }

    /* renamed from: j */
    private synchronized void m11467j() {
        f9432h.post(new C12925(this));
    }

    /* renamed from: k */
    private void m11469k() {
        this.f9448o = null;
        C1388c c1388c = this.f9451r;
        C1386a d = c1388c.m4763d();
        if (d == null) {
            this.f9437a.mo846a(C1481a.m5241a(AdErrorType.NO_FILL, ""));
            m11470l();
            return;
        }
        String a = d.m4753a();
        AdAdapter a2 = C1327e.m4596a(a, c1388c.m4759a().m4767b());
        if (a2 == null) {
            String str = f9431b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Adapter does not exist: ");
            stringBuilder.append(a);
            Log.e(str, stringBuilder.toString());
            m11467j();
        } else if (m11466i() != a2.getPlacementType()) {
            this.f9437a.mo846a(C1481a.m5241a(AdErrorType.INTERNAL_ERROR, ""));
        } else {
            this.f9448o = a2;
            Map hashMap = new HashMap();
            C1389d a3 = c1388c.m4759a();
            hashMap.put("data", d.m4755b());
            hashMap.put("definition", a3);
            hashMap.put(AudienceNetworkActivity.PLACEMENT_ID, this.f9439d);
            hashMap.put(AudienceNetworkActivity.REQUEST_TIME, Long.valueOf(a3.m4766a()));
            if (this.f9452s == null) {
                this.f9437a.mo846a(C1481a.m5241a(AdErrorType.UNKNOWN_ERROR, "environment is empty"));
                return;
            }
            switch (a2.getPlacementType()) {
                case INTERSTITIAL:
                    m11447a((InterstitialAdapter) a2, c1388c, hashMap);
                    break;
                case BANNER:
                    m11446a((BannerAdapter) a2, c1388c, hashMap);
                    break;
                case NATIVE:
                case NATIVE_BANNER:
                    m11450a((C3572y) a2, c1388c, d, hashMap);
                    break;
                case INSTREAM:
                    m11449a((C3570s) a2, c1388c, hashMap);
                    break;
                case REWARDED_VIDEO:
                    m11448a((ab) a2, c1388c, hashMap);
                    break;
                default:
                    Log.e(f9431b, "attempt unexpected adapter type");
                    break;
            }
        }
    }

    /* renamed from: l */
    private void m11470l() {
        if (!this.f9446m) {
            if (!this.f9445l) {
                if (C12914.f3736a[m11466i().ordinal()] == 1) {
                    if (!C1542a.m5399a(this.f9438c)) {
                        this.f9442g.postDelayed(this.f9444k, 1000);
                    }
                    long c = this.f9451r == null ? Constants.EVENT_UPLOAD_PERIOD_MILLIS : this.f9451r.m4759a().m4768c();
                    if (c > 0) {
                        this.f9442g.postDelayed(this.f9443j, c);
                        this.f9445l = true;
                    }
                }
            }
        }
    }

    /* renamed from: m */
    private void m11471m() {
        if (this.f9445l) {
            this.f9442g.removeCallbacks(this.f9443j);
            this.f9445l = false;
        }
    }

    /* renamed from: n */
    private Handler m11472n() {
        return !m11473o() ? this.f9442g : f9432h;
    }

    /* renamed from: o */
    private static synchronized boolean m11473o() {
        boolean z;
        synchronized (DisplayAdController.class) {
            z = f9433i;
        }
        return z;
    }

    protected static synchronized void setMainThreadForced(boolean z) {
        synchronized (DisplayAdController.class) {
            String str = f9431b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DisplayAdController changed main thread forced from ");
            stringBuilder.append(f9433i);
            stringBuilder.append(" to ");
            stringBuilder.append(z);
            Log.d(str, stringBuilder.toString());
            f9433i = z;
        }
    }

    /* renamed from: a */
    public C1389d m11474a() {
        return this.f9451r == null ? null : this.f9451r.m4759a();
    }

    /* renamed from: a */
    public void m11475a(int i) {
        this.f9458y = i;
    }

    /* renamed from: a */
    public void m11476a(RewardData rewardData) {
        if (this.f9449p == null) {
            throw new IllegalStateException("no adapter ready to set reward on");
        } else if (this.f9449p.getPlacementType() == AdPlacementType.REWARDED_VIDEO) {
            ((ab) this.f9449p).m11514a(rewardData);
        } else {
            throw new IllegalStateException("can only set on rewarded video ads");
        }
    }

    /* renamed from: a */
    public void m11477a(C1322a c1322a) {
        this.f9437a = c1322a;
    }

    /* renamed from: a */
    public synchronized void mo915a(final C3593g c3593g) {
        m11472n().post(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ DisplayAdController f3733b;

            public void run() {
                C1388c a = c3593g.mo968a();
                if (a == null || a.m4759a() == null) {
                    throw new IllegalStateException("invalid placement in response");
                }
                this.f3733b.f9451r = a;
                this.f3733b.m11467j();
            }
        });
    }

    /* renamed from: a */
    public synchronized void mo916a(final C1481a c1481a) {
        m11472n().post(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ DisplayAdController f3735b;

            public void run() {
                this.f3735b.f9437a.mo846a(c1481a);
            }
        });
    }

    /* renamed from: a */
    public void m11480a(String str) {
        m11455b(str);
    }

    /* renamed from: a */
    public void m11481a(boolean z) {
        this.f9457x = z;
    }

    /* renamed from: b */
    public void m11482b() {
        C1322a c1322a;
        AdErrorType adErrorType;
        AdErrorType adErrorType2;
        if (this.f9449p == null) {
            C1540a.m5396a(this.f9438c, "api", C1541b.f4560e, new C1482b(AdErrorType.NO_ADAPTER_ON_START, "Adapter is null on startAd"));
            c1322a = this.f9437a;
            adErrorType = AdErrorType.INTERNAL_ERROR;
            adErrorType2 = AdErrorType.INTERNAL_ERROR;
        } else if (this.f9447n) {
            C1540a.m5396a(this.f9438c, "api", C1541b.f4558c, new C1482b(AdErrorType.AD_ALREADY_STARTED, "ad already started"));
            c1322a = this.f9437a;
            adErrorType = AdErrorType.AD_ALREADY_STARTED;
            adErrorType2 = AdErrorType.AD_ALREADY_STARTED;
        } else {
            this.f9447n = true;
            switch (this.f9449p.getPlacementType()) {
                case INTERSTITIAL:
                    ((InterstitialAdapter) this.f9449p).show();
                    break;
                case BANNER:
                    if (this.f9450q != null) {
                        this.f9437a.mo844a(this.f9450q);
                        break;
                    }
                    break;
                case NATIVE:
                case NATIVE_BANNER:
                    C3572y c3572y = (C3572y) this.f9449p;
                    if (c3572y.c_()) {
                        this.f9437a.mo963a(c3572y);
                        break;
                    }
                    throw new IllegalStateException("ad is not ready or already displayed");
                case INSTREAM:
                    ((C3570s) this.f9449p).mo2861e();
                    break;
                case REWARDED_VIDEO:
                    ab abVar = (ab) this.f9449p;
                    abVar.m11512a(this.f9458y);
                    abVar.mo2868b();
                    break;
                default:
                    Log.e(f9431b, "start unexpected adapter type");
                    break;
            }
            return;
        }
        c1322a.mo846a(C1481a.m5241a(adErrorType, adErrorType2.getDefaultErrorMessage()));
    }

    /* renamed from: b */
    public void m11483b(boolean z) {
        m11464h();
        if (z || this.f9447n) {
            m11471m();
            m11445a(this.f9449p);
            this.f9441f.m5082a();
            this.f9450q = null;
            this.f9447n = false;
        }
    }

    /* renamed from: c */
    public void m11484c() {
        m11483b(false);
    }

    /* renamed from: d */
    public boolean m11485d() {
        if (this.f9451r != null) {
            if (!this.f9451r.m4764e()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    public C1412c m11486e() {
        return this.f9435B;
    }

    /* renamed from: f */
    public AdAdapter m11487f() {
        return this.f9449p;
    }
}
