package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.C2173b;
import com.google.ads.mediation.C2175b;
import com.google.ads.mediation.C2176c;
import com.google.ads.mediation.C2183e;
import com.google.ads.mediation.C2184f;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.C2696n;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@cm
public final class beb<NETWORK_EXTRAS extends C2184f, SERVER_PARAMETERS extends C2183e> extends bdc {
    /* renamed from: a */
    private final C2175b<NETWORK_EXTRAS, SERVER_PARAMETERS> f28494a;
    /* renamed from: b */
    private final NETWORK_EXTRAS f28495b;

    public beb(C2175b<NETWORK_EXTRAS, SERVER_PARAMETERS> c2175b, NETWORK_EXTRAS network_extras) {
        this.f28494a = c2175b;
        this.f28495b = network_extras;
    }

    /* renamed from: a */
    private final SERVER_PARAMETERS m37381a(String str, int i, String str2) {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                mt.m19919b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.f28494a.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        C2183e c2183e = (C2183e) serverParametersType.newInstance();
        c2183e.a(hashMap);
        return c2183e;
    }

    /* renamed from: a */
    private static boolean m37382a(aoq aoq) {
        if (!aoq.f28266f) {
            aph.m18683a();
            if (!mi.m19873a()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public final C2758b mo4105a() {
        if (this.f28494a instanceof MediationBannerAdapter) {
            try {
                return C4757d.a(((MediationBannerAdapter) this.f28494a).getBannerView());
            } catch (Throwable th) {
                mt.m19919b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "Not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f28494a.getClass().getCanonicalName());
            mt.m19924e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo4106a(C2758b c2758b) {
    }

    /* renamed from: a */
    public final void mo4107a(C2758b c2758b, aoq aoq, String str, bde bde) {
        mo4109a(c2758b, aoq, str, null, bde);
    }

    /* renamed from: a */
    public final void mo4108a(C2758b c2758b, aoq aoq, String str, hm hmVar, String str2) {
    }

    /* renamed from: a */
    public final void mo4109a(C2758b c2758b, aoq aoq, String str, String str2, bde bde) {
        if (this.f28494a instanceof MediationInterstitialAdapter) {
            mt.m19918b("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.f28494a).requestInterstitialAd(new bec(bde), (Activity) C4757d.a(c2758b), m37381a(str, aoq.f28267g, str2), beg.m19347a(aoq, m37382a(aoq)), this.f28495b);
            } catch (Throwable th) {
                mt.m19919b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "Not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f28494a.getClass().getCanonicalName());
            mt.m19924e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo4110a(C2758b c2758b, aoq aoq, String str, String str2, bde bde, aus aus, List<String> list) {
    }

    /* renamed from: a */
    public final void mo4111a(C2758b c2758b, aou aou, aoq aoq, String str, bde bde) {
        mo4112a(c2758b, aou, aoq, str, null, bde);
    }

    /* renamed from: a */
    public final void mo4112a(C2758b c2758b, aou aou, aoq aoq, String str, String str2, bde bde) {
        if (this.f28494a instanceof MediationBannerAdapter) {
            mt.m19918b("Requesting banner ad from adapter.");
            try {
                C2173b c2173b;
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.f28494a;
                C2176c bec = new bec(bde);
                Activity activity = (Activity) C4757d.a(c2758b);
                C2183e a = m37381a(str, aoq.f28267g, str2);
                r12 = new C2173b[6];
                int i = 0;
                r12[0] = C2173b.f5213a;
                r12[1] = C2173b.f5214b;
                r12[2] = C2173b.f5215c;
                r12[3] = C2173b.f5216d;
                r12[4] = C2173b.f5217e;
                r12[5] = C2173b.f5218f;
                while (i < 6) {
                    if (r12[i].a() == aou.f28283e && r12[i].b() == aou.f28280b) {
                        c2173b = r12[i];
                        break;
                    }
                    i++;
                }
                c2173b = new C2173b(C2696n.a(aou.f28283e, aou.f28280b, aou.f28279a));
                mediationBannerAdapter.requestBannerAd(bec, activity, a, c2173b, beg.m19347a(aoq, m37382a(aoq)), this.f28495b);
            } catch (Throwable th) {
                mt.m19919b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "Not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f28494a.getClass().getCanonicalName());
            mt.m19924e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo4113a(C2758b c2758b, hm hmVar, List<String> list) {
    }

    /* renamed from: a */
    public final void mo4114a(aoq aoq, String str) {
    }

    /* renamed from: a */
    public final void mo4115a(aoq aoq, String str, String str2) {
    }

    /* renamed from: a */
    public final void mo4116a(boolean z) {
    }

    /* renamed from: b */
    public final void mo4117b() {
        if (this.f28494a instanceof MediationInterstitialAdapter) {
            mt.m19918b("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.f28494a).showInterstitial();
            } catch (Throwable th) {
                mt.m19919b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "Not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f28494a.getClass().getCanonicalName());
            mt.m19924e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    /* renamed from: c */
    public final void mo4118c() {
        try {
            this.f28494a.destroy();
        } catch (Throwable th) {
            mt.m19919b("", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    /* renamed from: d */
    public final void mo4119d() {
        throw new RemoteException();
    }

    /* renamed from: e */
    public final void mo4120e() {
        throw new RemoteException();
    }

    /* renamed from: f */
    public final void mo4121f() {
    }

    /* renamed from: g */
    public final boolean mo4122g() {
        return true;
    }

    /* renamed from: h */
    public final bdk mo4123h() {
        return null;
    }

    /* renamed from: i */
    public final bdo mo4124i() {
        return null;
    }

    /* renamed from: j */
    public final Bundle mo4125j() {
        return new Bundle();
    }

    /* renamed from: k */
    public final Bundle mo4126k() {
        return new Bundle();
    }

    /* renamed from: l */
    public final Bundle mo4127l() {
        return new Bundle();
    }

    /* renamed from: m */
    public final boolean mo4128m() {
        return false;
    }

    /* renamed from: n */
    public final awa mo4129n() {
        return null;
    }

    /* renamed from: o */
    public final aqv mo4130o() {
        return null;
    }

    /* renamed from: p */
    public final bdr mo4131p() {
        return null;
    }
}
