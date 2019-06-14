package com.google.android.gms.internal.ads;

import com.google.ads.C2172a.C2170a;
import com.google.ads.mediation.C2176c;
import com.google.ads.mediation.C2180d;
import com.google.ads.mediation.C2183e;
import com.google.ads.mediation.C2184f;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;

@cm
public final class bec<NETWORK_EXTRAS extends C2184f, SERVER_PARAMETERS extends C2183e> implements C2176c, C2180d {
    /* renamed from: a */
    private final bde f23968a;

    public bec(bde bde) {
        this.f23968a = bde;
    }

    /* renamed from: a */
    public final void m30616a(MediationBannerAdapter<?, ?> mediationBannerAdapter, C2170a c2170a) {
        String valueOf = String.valueOf(c2170a);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 47);
        stringBuilder.append("Adapter called onFailedToReceiveAd with error. ");
        stringBuilder.append(valueOf);
        mt.m19918b(stringBuilder.toString());
        aph.m18683a();
        if (mi.m19877b()) {
            try {
                this.f23968a.mo4133a(beg.m19346a(c2170a));
                return;
            } catch (Throwable e) {
                mt.m19923d("#007 Could not call remote method.", e);
                return;
            }
        }
        mt.m19923d("#008 Must be called on the main UI thread.", null);
        mi.f15796a.post(new bed(this, c2170a));
    }

    /* renamed from: a */
    public final void m30617a(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, C2170a c2170a) {
        String valueOf = String.valueOf(c2170a);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 47);
        stringBuilder.append("Adapter called onFailedToReceiveAd with error ");
        stringBuilder.append(valueOf);
        stringBuilder.append(".");
        mt.m19918b(stringBuilder.toString());
        aph.m18683a();
        if (mi.m19877b()) {
            try {
                this.f23968a.mo4133a(beg.m19346a(c2170a));
                return;
            } catch (Throwable e) {
                mt.m19923d("#007 Could not call remote method.", e);
                return;
            }
        }
        mt.m19923d("#008 Must be called on the main UI thread.", null);
        mi.f15796a.post(new bef(this, c2170a));
    }
}
