package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.reward.C2697a;
import com.google.android.gms.ads.reward.mediation.C2701a;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.p174b.C4757d;

@cm
public final class hp implements C2701a {
    /* renamed from: a */
    private final hm f24088a;

    public hp(hm hmVar) {
        this.f24088a = hmVar;
    }

    /* renamed from: a */
    public final void m30780a(Bundle bundle) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdMetadataChanged.");
        try {
            this.f24088a.mo4276a(bundle);
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m30781a(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onInitializationSucceeded.");
        try {
            this.f24088a.mo4277a(C4757d.a(mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m30782a(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdFailedToLoad.");
        try {
            this.f24088a.mo4281b(C4757d.a(mediationRewardedVideoAdAdapter), i);
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void m30783a(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, C2697a c2697a) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onRewarded.");
        if (c2697a != null) {
            try {
                this.f24088a.mo4279a(C4757d.a(mediationRewardedVideoAdAdapter), new hq(c2697a));
                return;
            } catch (Throwable e) {
                mt.m19923d("#007 Could not call remote method.", e);
                return;
            }
        }
        this.f24088a.mo4279a(C4757d.a(mediationRewardedVideoAdAdapter), new hq("", 1));
    }

    /* renamed from: b */
    public final void m30784b(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdLoaded.");
        try {
            this.f24088a.mo4280b(C4757d.a(mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: c */
    public final void m30785c(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdOpened.");
        try {
            this.f24088a.mo4282c(C4757d.a(mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: d */
    public final void m30786d(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onVideoStarted.");
        try {
            this.f24088a.mo4283d(C4757d.a(mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: e */
    public final void m30787e(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdClosed.");
        try {
            this.f24088a.mo4284e(C4757d.a(mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: f */
    public final void m30788f(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onAdLeftApplication.");
        try {
            this.f24088a.mo4286g(C4757d.a(mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: g */
    public final void m30789g(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        C2872v.b("#008 Must be called on the main UI thread.");
        mt.m19918b("Adapter called onVideoCompleted.");
        try {
            this.f24088a.mo4287h(C4757d.a(mediationRewardedVideoAdAdapter));
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }
}
