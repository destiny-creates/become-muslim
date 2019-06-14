package com.facebook.ads;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.ads.NativeAdBase.MediaCacheFlag;
import com.facebook.ads.internal.C3548a;
import com.facebook.ads.internal.C3548a.C1295a;
import com.facebook.ads.internal.adapters.C3572y;
import com.facebook.ads.internal.p089d.C1359a;
import com.facebook.ads.internal.p089d.C1364b;
import com.facebook.ads.internal.protocol.C1481a;
import com.facebook.ads.internal.protocol.C1485d;
import com.facebook.ads.internal.protocol.C1487f;
import java.util.ArrayList;
import java.util.List;

public class NativeAdsManager {
    /* renamed from: a */
    private static final String f3707a = "NativeAdsManager";
    /* renamed from: b */
    private static final C1485d f3708b = C1485d.ADS;
    /* renamed from: c */
    private final Context f3709c;
    /* renamed from: d */
    private final String f3710d;
    /* renamed from: e */
    private final int f3711e;
    /* renamed from: f */
    private final List<NativeAd> f3712f;
    /* renamed from: g */
    private int f3713g;
    /* renamed from: h */
    private Listener f3714h;
    /* renamed from: i */
    private C3548a f3715i;
    /* renamed from: j */
    private boolean f3716j;
    /* renamed from: k */
    private boolean f3717k;

    public interface Listener {
        void onAdError(AdError adError);

        void onAdsLoaded();
    }

    public NativeAdsManager(Context context, String str, int i) {
        if (context != null) {
            this.f3709c = context;
            this.f3710d = str;
            this.f3711e = Math.max(i, 0);
            this.f3712f = new ArrayList(i);
            this.f3713g = -1;
            this.f3717k = false;
            this.f3716j = false;
            try {
                CookieManager.getInstance();
                if (VERSION.SDK_INT < 21) {
                    CookieSyncManager.createInstance(context);
                    return;
                }
                return;
            } catch (Throwable e) {
                Log.w(f3707a, "Failed to initialize CookieManager.", e);
                return;
            }
        }
        throw new IllegalArgumentException("context can not be null");
    }

    public void disableAutoRefresh() {
        this.f3716j = true;
        if (this.f3715i != null) {
            this.f3715i.m11508c();
        }
    }

    public int getUniqueNativeAdCount() {
        return this.f3712f.size();
    }

    public boolean isLoaded() {
        return this.f3717k;
    }

    public void loadAds() {
        loadAds(MediaCacheFlag.ALL);
    }

    public void loadAds(final MediaCacheFlag mediaCacheFlag) {
        C1487f c1487f = C1487f.NATIVE_UNKNOWN;
        int i = this.f3711e;
        if (this.f3715i != null) {
            this.f3715i.m11507b();
        }
        this.f3715i = new C3548a(this.f3709c, this.f3710d, c1487f, null, f3708b, i);
        if (this.f3716j) {
            this.f3715i.m11508c();
        }
        this.f3715i.m11504a(new C1295a(this) {
            /* renamed from: b */
            final /* synthetic */ NativeAdsManager f9408b;

            /* renamed from: a */
            public void mo884a(C1481a c1481a) {
                if (this.f9408b.f3714h != null) {
                    this.f9408b.f3714h.onAdError(AdError.getAdErrorFromWrapper(c1481a));
                }
            }

            /* renamed from: a */
            public void mo885a(final List<C3572y> list) {
                C1364b c1364b = new C1364b(this.f9408b.f3709c);
                for (C3572y c3572y : list) {
                    if (mediaCacheFlag.equals(MediaCacheFlag.ALL)) {
                        if (c3572y.mo2842k() != null) {
                            c1364b.m4659a(c3572y.mo2842k().m5022a(), c3572y.mo2842k().m5024c(), c3572y.mo2842k().m5023b());
                        }
                        if (c3572y.mo2843l() != null) {
                            c1364b.m4659a(c3572y.mo2843l().m5022a(), c3572y.mo2843l().m5024c(), c3572y.mo2843l().m5023b());
                        }
                        if (!TextUtils.isEmpty(c3572y.mo2816A())) {
                            c1364b.m4658a(c3572y.mo2816A());
                        }
                    }
                }
                c1364b.m4657a(new C1359a(this) {
                    /* renamed from: b */
                    final /* synthetic */ C35351 f9406b;

                    /* renamed from: c */
                    private void m11399c() {
                        this.f9406b.f9408b.f3717k = true;
                        this.f9406b.f9408b.f3712f.clear();
                        this.f9406b.f9408b.f3713g = 0;
                        for (C3572y nativeAd : list) {
                            this.f9406b.f9408b.f3712f.add(new NativeAd(this.f9406b.f9408b.f3709c, nativeAd, null));
                        }
                        if (this.f9406b.f9408b.f3714h != null) {
                            this.f9406b.f9408b.f3714h.onAdsLoaded();
                        }
                    }

                    /* renamed from: a */
                    public void mo882a() {
                        m11399c();
                    }

                    /* renamed from: b */
                    public void mo883b() {
                        m11399c();
                    }
                });
            }
        });
        this.f3715i.m11503a();
    }

    public NativeAd nextNativeAd() {
        if (this.f3712f.size() == 0) {
            return null;
        }
        int i = this.f3713g;
        this.f3713g = i + 1;
        NativeAdBase nativeAdBase = (NativeAd) this.f3712f.get(i % this.f3712f.size());
        return i >= this.f3712f.size() ? new NativeAd(nativeAdBase) : nativeAdBase;
    }

    public void setListener(Listener listener) {
        this.f3714h = listener;
    }
}
