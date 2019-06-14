package com.google.android.gms.internal.ads;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.C2678k;
import com.google.android.gms.ads.mediation.C2684c;
import com.google.android.gms.ads.mediation.C2689d;
import com.google.android.gms.ads.mediation.C2690e;
import com.google.android.gms.ads.mediation.C2691f;
import com.google.android.gms.ads.mediation.C2694l;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.p168b.C2618k;
import com.google.android.gms.common.internal.C2872v;

@cm
public final class bdx implements C2684c, C2689d, C2690e {
    /* renamed from: a */
    private final bde f23956a;
    /* renamed from: b */
    private C2691f f23957b;
    /* renamed from: c */
    private C2694l f23958c;
    /* renamed from: d */
    private C2618k f23959d;

    public bdx(bde bde) {
        this.f23956a = bde;
    }

    /* renamed from: a */
    private static void m30587a(MediationNativeAdapter mediationNativeAdapter, C2694l c2694l, C2691f c2691f) {
        if (!(mediationNativeAdapter instanceof AdMobAdapter)) {
            C2678k c2678k = new C2678k();
            c2678k.a(new bdu());
            if (c2694l != null && c2694l.k()) {
                c2694l.a(c2678k);
            }
            if (c2691f != null && c2691f.h()) {
                c2691f.a(c2678k);
            }
        }
    }

    /* renamed from: a */
    public final C2691f m30588a() {
        return this.f23957b;
    }

    /* renamed from: a */
    public final void m30589a(MediationBannerAdapter mediationBannerAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdLoaded.");
        try {
            this.f23956a.mo4141e();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m30590a(MediationBannerAdapter mediationBannerAdapter, int i) {
        C2872v.b("#008 Must be called on the main UI thread.");
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("Adapter called onAdFailedToLoad with error. ");
        stringBuilder.append(i);
        mt.m19918b(stringBuilder.toString());
        try {
            this.f23956a.mo4133a(i);
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m30591a(MediationBannerAdapter mediationBannerAdapter, String str, String str2) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAppEvent.");
        try {
            this.f23956a.mo4137a(str, str2);
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m30592a(MediationInterstitialAdapter mediationInterstitialAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdLoaded.");
        try {
            this.f23956a.mo4141e();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m30593a(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        C2872v.b("#008 Must be called on the main UI thread.");
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("Adapter called onAdFailedToLoad with error ");
        stringBuilder.append(i);
        stringBuilder.append(".");
        mt.m19918b(stringBuilder.toString());
        try {
            this.f23956a.mo4133a(i);
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m30594a(MediationNativeAdapter mediationNativeAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdOpened.");
        try {
            this.f23956a.mo4140d();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m30595a(MediationNativeAdapter mediationNativeAdapter, int i) {
        C2872v.b("#008 Must be called on the main UI thread.");
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("Adapter called onAdFailedToLoad with error ");
        stringBuilder.append(i);
        stringBuilder.append(".");
        mt.m19918b(stringBuilder.toString());
        try {
            this.f23956a.mo4133a(i);
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m30596a(MediationNativeAdapter mediationNativeAdapter, C2618k c2618k) {
        C2872v.b("#008 Must be called on the main UI thread.");
        String str = "Adapter called onAdLoaded with template id ";
        String valueOf = String.valueOf(c2618k.a());
        mt.m19918b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        this.f23959d = c2618k;
        try {
            this.f23956a.mo4141e();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m30597a(MediationNativeAdapter mediationNativeAdapter, C2618k c2618k, String str) {
        if (c2618k instanceof awd) {
            try {
                this.f23956a.mo4134a(((awd) c2618k).m30318b(), str);
                return;
            } catch (Throwable e) {
                mt.m19923d("#007 Could not call remote method.", e);
                return;
            }
        }
        mt.m19924e("Unexpected native custom template ad type.");
    }

    /* renamed from: a */
    public final void m30598a(MediationNativeAdapter mediationNativeAdapter, C2691f c2691f) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdLoaded.");
        this.f23957b = c2691f;
        this.f23958c = null;
        m30587a(mediationNativeAdapter, this.f23958c, this.f23957b);
        try {
            this.f23956a.mo4141e();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m30599a(MediationNativeAdapter mediationNativeAdapter, C2694l c2694l) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdLoaded.");
        this.f23958c = c2694l;
        this.f23957b = null;
        m30587a(mediationNativeAdapter, this.f23958c, this.f23957b);
        try {
            this.f23956a.mo4141e();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: b */
    public final C2694l m30600b() {
        return this.f23958c;
    }

    /* renamed from: b */
    public final void m30601b(MediationBannerAdapter mediationBannerAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdOpened.");
        try {
            this.f23956a.mo4140d();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: b */
    public final void m30602b(MediationInterstitialAdapter mediationInterstitialAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdOpened.");
        try {
            this.f23956a.mo4140d();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: b */
    public final void m30603b(MediationNativeAdapter mediationNativeAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdClosed.");
        try {
            this.f23956a.mo4138b();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: c */
    public final C2618k m30604c() {
        return this.f23959d;
    }

    /* renamed from: c */
    public final void m30605c(MediationBannerAdapter mediationBannerAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdClosed.");
        try {
            this.f23956a.mo4138b();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: c */
    public final void m30606c(MediationInterstitialAdapter mediationInterstitialAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdClosed.");
        try {
            this.f23956a.mo4138b();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: c */
    public final void m30607c(MediationNativeAdapter mediationNativeAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdLeftApplication.");
        try {
            this.f23956a.mo4139c();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: d */
    public final void m30608d(MediationBannerAdapter mediationBannerAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdLeftApplication.");
        try {
            this.f23956a.mo4139c();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: d */
    public final void m30609d(MediationInterstitialAdapter mediationInterstitialAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdLeftApplication.");
        try {
            this.f23956a.mo4139c();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: d */
    public final void m30610d(MediationNativeAdapter mediationNativeAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        C2691f c2691f = this.f23957b;
        C2694l c2694l = this.f23958c;
        if (this.f23959d == null) {
            if (c2691f == null && c2694l == null) {
                mt.m19923d("#007 Could not call remote method.", null);
                return;
            } else if (c2694l != null && !c2694l.q()) {
                mt.m19918b("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            } else if (!(c2691f == null || c2691f.b())) {
                mt.m19918b("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            }
        }
        mt.m19918b("Adapter called onAdClicked.");
        try {
            this.f23956a.mo4132a();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: e */
    public final void m30611e(MediationBannerAdapter mediationBannerAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdClicked.");
        try {
            this.f23956a.mo4132a();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: e */
    public final void m30612e(MediationInterstitialAdapter mediationInterstitialAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdClicked.");
        try {
            this.f23956a.mo4132a();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: e */
    public final void m30613e(MediationNativeAdapter mediationNativeAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        C2691f c2691f = this.f23957b;
        C2694l c2694l = this.f23958c;
        if (this.f23959d == null) {
            if (c2691f == null && c2694l == null) {
                mt.m19923d("#007 Could not call remote method.", null);
                return;
            } else if (c2694l != null && !c2694l.p()) {
                mt.m19918b("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            } else if (!(c2691f == null || c2691f.a())) {
                mt.m19918b("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            }
        }
        mt.m19918b("Adapter called onAdImpression.");
        try {
            this.f23956a.mo4142f();
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }
}
