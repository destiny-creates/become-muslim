package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.C1322a;
import com.facebook.ads.internal.p105q.p109d.C1540a;
import com.facebook.ads.internal.p105q.p109d.C1541b;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.C1481a;
import com.facebook.ads.internal.protocol.C1482b;
import com.facebook.ads.internal.protocol.C1485d;
import com.facebook.ads.internal.protocol.C1486e;
import com.facebook.ads.internal.protocol.C1488g;
import java.util.EnumSet;

public class InterstitialAd implements Ad {
    /* renamed from: a */
    private static final C1485d f9378a = C1485d.ADS;
    /* renamed from: b */
    private final Context f9379b;
    /* renamed from: c */
    private final String f9380c;
    /* renamed from: d */
    private DisplayAdController f9381d;
    /* renamed from: e */
    private boolean f9382e;
    /* renamed from: f */
    private boolean f9383f;
    /* renamed from: g */
    private InterstitialAdListener f9384g;

    /* renamed from: com.facebook.ads.InterstitialAd$1 */
    class C35271 extends C1322a {
        /* renamed from: a */
        final /* synthetic */ InterstitialAd f9377a;

        C35271(InterstitialAd interstitialAd) {
            this.f9377a = interstitialAd;
        }

        /* renamed from: a */
        public void mo843a() {
            if (this.f9377a.f9384g != null) {
                this.f9377a.f9384g.onAdClicked(this.f9377a);
            }
        }

        /* renamed from: a */
        public void mo844a(View view) {
        }

        /* renamed from: a */
        public void mo845a(AdAdapter adAdapter) {
            this.f9377a.f9382e = true;
            if (this.f9377a.f9384g != null) {
                this.f9377a.f9384g.onAdLoaded(this.f9377a);
            }
        }

        /* renamed from: a */
        public void mo846a(C1481a c1481a) {
            if (this.f9377a.f9384g != null) {
                this.f9377a.f9384g.onError(this.f9377a, AdError.getAdErrorFromWrapper(c1481a));
            }
        }

        /* renamed from: b */
        public void mo847b() {
            if (this.f9377a.f9384g != null) {
                this.f9377a.f9384g.onLoggingImpression(this.f9377a);
            }
        }

        /* renamed from: d */
        public void mo867d() {
            if (this.f9377a.f9384g != null) {
                this.f9377a.f9384g.onInterstitialDisplayed(this.f9377a);
            }
        }

        /* renamed from: e */
        public void mo868e() {
            this.f9377a.f9383f = false;
            if (this.f9377a.f9381d != null) {
                this.f9377a.f9381d.m11484c();
                this.f9377a.f9381d = null;
            }
            if (this.f9377a.f9384g != null) {
                this.f9377a.f9384g.onInterstitialDismissed(this.f9377a);
            }
        }
    }

    public InterstitialAd(Context context, String str) {
        this.f9379b = context;
        this.f9380c = str;
    }

    /* renamed from: a */
    private void m11371a(EnumSet<CacheFlag> enumSet, String str) {
        this.f9382e = false;
        if (this.f9383f) {
            C1540a.m5396a(this.f9379b, "api", C1541b.f4561f, new C1482b(AdErrorType.NO_ADAPTER_ON_LOAD, "Interstitial load called while showing interstitial."));
            if (this.f9384g != null) {
                this.f9384g.onError(this, new AdError(AdErrorType.LOAD_CALLED_WHILE_SHOWING_AD.getErrorCode(), AdErrorType.LOAD_CALLED_WHILE_SHOWING_AD.getDefaultErrorMessage()));
            }
            return;
        }
        if (this.f9381d != null) {
            this.f9381d.m11484c();
            this.f9381d = null;
        }
        this.f9381d = new DisplayAdController(this.f9379b, this.f9380c, C1488g.m5254a(this.f9379b.getResources().getDisplayMetrics()), AdPlacementType.INTERSTITIAL, C1486e.INTERSTITIAL, f9378a, 1, true, enumSet);
        this.f9381d.m11477a(new C35271(this));
        this.f9381d.m11480a(str);
    }

    public void destroy() {
        if (this.f9381d != null) {
            this.f9381d.m11483b(true);
            this.f9381d = null;
        }
    }

    public String getPlacementId() {
        return this.f9380c;
    }

    public boolean isAdInvalidated() {
        if (this.f9381d != null) {
            if (!this.f9381d.m11485d()) {
                return false;
            }
        }
        return true;
    }

    public boolean isAdLoaded() {
        return this.f9382e;
    }

    public void loadAd() {
        loadAd(EnumSet.of(CacheFlag.NONE));
    }

    public void loadAd(EnumSet<CacheFlag> enumSet) {
        m11371a((EnumSet) enumSet, null);
    }

    public void loadAdFromBid(String str) {
        m11371a(EnumSet.of(CacheFlag.NONE), str);
    }

    public void loadAdFromBid(EnumSet<CacheFlag> enumSet, String str) {
        m11371a((EnumSet) enumSet, str);
    }

    public void setAdListener(InterstitialAdListener interstitialAdListener) {
        this.f9384g = interstitialAdListener;
    }

    public boolean show() {
        if (!this.f9382e) {
            if (this.f9384g != null) {
                this.f9384g.onError(this, AdError.INTERNAL_ERROR);
            }
            return false;
        } else if (this.f9381d == null) {
            C1540a.m5396a(this.f9379b, "api", C1541b.f4562g, new C1482b(AdErrorType.INTERSTITIAL_CONTROLLER_IS_NULL, AdErrorType.INTERSTITIAL_CONTROLLER_IS_NULL.getDefaultErrorMessage()));
            if (this.f9384g != null) {
                this.f9384g.onError(this, AdError.INTERNAL_ERROR);
            }
            return false;
        } else {
            this.f9381d.m11482b();
            this.f9383f = true;
            this.f9382e = false;
            return true;
        }
    }
}
