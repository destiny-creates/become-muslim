package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.facebook.internal.AnalyticsEvents;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.C2696n;
import com.google.android.gms.ads.mediation.C2681a;
import com.google.android.gms.ads.mediation.C2683b;
import com.google.android.gms.ads.mediation.C2691f;
import com.google.android.gms.ads.mediation.C2692j;
import com.google.android.gms.ads.mediation.C2693k;
import com.google.android.gms.ads.mediation.C2694l;
import com.google.android.gms.ads.mediation.C2695m;
import com.google.android.gms.ads.mediation.C4299g;
import com.google.android.gms.ads.mediation.C4300h;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.p168b.C2618k;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@cm
public final class bdw extends bdc {
    /* renamed from: a */
    private final C2683b f28480a;
    /* renamed from: b */
    private bdx f28481b;

    public bdw(C2683b c2683b) {
        this.f28480a = c2683b;
    }

    /* renamed from: a */
    private final Bundle m37299a(String str, aoq aoq, String str2) {
        String str3 = "Server parameters: ";
        String valueOf = String.valueOf(str);
        mt.m19924e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        try {
            Bundle bundle;
            Bundle bundle2 = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                bundle = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str4 = (String) keys.next();
                    bundle.putString(str4, jSONObject.getString(str4));
                }
            } else {
                bundle = bundle2;
            }
            if (this.f28480a instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (aoq != null) {
                    bundle.putInt("tagForChildDirectedTreatment", aoq.f28267g);
                }
            }
            return bundle;
        } catch (Throwable th) {
            mt.m19919b("", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    /* renamed from: a */
    private static boolean m37300a(aoq aoq) {
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
        if (this.f28480a instanceof MediationBannerAdapter) {
            try {
                return C4757d.a(((MediationBannerAdapter) this.f28480a).getBannerView());
            } catch (Throwable th) {
                mt.m19919b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "Not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f28480a.getClass().getCanonicalName());
            mt.m19924e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo4106a(C2758b c2758b) {
        try {
            ((C2692j) this.f28480a).a((Context) C4757d.a(c2758b));
        } catch (Throwable th) {
            mt.m19921c(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, th);
        }
    }

    /* renamed from: a */
    public final void mo4107a(C2758b c2758b, aoq aoq, String str, bde bde) {
        mo4109a(c2758b, aoq, str, null, bde);
    }

    /* renamed from: a */
    public final void mo4108a(C2758b c2758b, aoq aoq, String str, hm hmVar, String str2) {
        aoq aoq2 = aoq;
        if (this.f28480a instanceof MediationRewardedVideoAdAdapter) {
            mt.m19918b("Initialize rewarded video adapter.");
            try {
                Bundle bundle;
                C2681a c2681a;
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) r1.f28480a;
                Bundle a = m37299a(str2, aoq2, null);
                if (aoq2 != null) {
                    bdv bdv = new bdv(aoq2.f28262b == -1 ? null : new Date(aoq2.f28262b), aoq2.f28264d, aoq2.f28265e != null ? new HashSet(aoq2.f28265e) : null, aoq2.f28271k, m37300a(aoq), aoq2.f28267g, aoq2.f28278r);
                    bundle = aoq2.f28273m != null ? aoq2.f28273m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
                    c2681a = bdv;
                } else {
                    c2681a = null;
                    bundle = c2681a;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) C4757d.a(c2758b), c2681a, str, new hp(hmVar), a, bundle);
            } catch (Throwable th) {
                mt.m19919b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "Not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(r1.f28480a.getClass().getCanonicalName());
            mt.m19924e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo4109a(C2758b c2758b, aoq aoq, String str, String str2, bde bde) {
        aoq aoq2 = aoq;
        if (this.f28480a instanceof MediationInterstitialAdapter) {
            mt.m19918b("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) r1.f28480a;
                Bundle bundle = null;
                bdv bdv = new bdv(aoq2.f28262b == -1 ? null : new Date(aoq2.f28262b), aoq2.f28264d, aoq2.f28265e != null ? new HashSet(aoq2.f28265e) : null, aoq2.f28271k, m37300a(aoq), aoq2.f28267g, aoq2.f28278r);
                if (aoq2.f28273m != null) {
                    bundle = aoq2.f28273m.getBundle(mediationInterstitialAdapter.getClass().getName());
                }
                mediationInterstitialAdapter.requestInterstitialAd((Context) C4757d.a(c2758b), new bdx(bde), m37299a(str, aoq2, str2), bdv, bundle);
            } catch (Throwable th) {
                mt.m19919b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "Not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(r1.f28480a.getClass().getCanonicalName());
            mt.m19924e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo4110a(C2758b c2758b, aoq aoq, String str, String str2, bde bde, aus aus, List<String> list) {
        aoq aoq2 = aoq;
        if (this.f28480a instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) r1.f28480a;
                Bundle bundle = null;
                bea bea = new bea(aoq2.f28262b == -1 ? null : new Date(aoq2.f28262b), aoq2.f28264d, aoq2.f28265e != null ? new HashSet(aoq2.f28265e) : null, aoq2.f28271k, m37300a(aoq), aoq2.f28267g, aus, list, aoq2.f28278r);
                if (aoq2.f28273m != null) {
                    bundle = aoq2.f28273m.getBundle(mediationNativeAdapter.getClass().getName());
                }
                r1.f28481b = new bdx(bde);
                mediationNativeAdapter.requestNativeAd((Context) C4757d.a(c2758b), r1.f28481b, m37299a(str, aoq2, str2), bea, bundle);
            } catch (Throwable th) {
                mt.m19919b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "Not a MediationNativeAdapter: ";
            String valueOf = String.valueOf(r1.f28480a.getClass().getCanonicalName());
            mt.m19924e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo4111a(C2758b c2758b, aou aou, aoq aoq, String str, bde bde) {
        mo4112a(c2758b, aou, aoq, str, null, bde);
    }

    /* renamed from: a */
    public final void mo4112a(C2758b c2758b, aou aou, aoq aoq, String str, String str2, bde bde) {
        aou aou2 = aou;
        aoq aoq2 = aoq;
        if (this.f28480a instanceof MediationBannerAdapter) {
            mt.m19918b("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) r1.f28480a;
                Bundle bundle = null;
                bdv bdv = new bdv(aoq2.f28262b == -1 ? null : new Date(aoq2.f28262b), aoq2.f28264d, aoq2.f28265e != null ? new HashSet(aoq2.f28265e) : null, aoq2.f28271k, m37300a(aoq), aoq2.f28267g, aoq2.f28278r);
                if (aoq2.f28273m != null) {
                    bundle = aoq2.f28273m.getBundle(mediationBannerAdapter.getClass().getName());
                }
                mediationBannerAdapter.requestBannerAd((Context) C4757d.a(c2758b), new bdx(bde), m37299a(str, aoq2, str2), C2696n.a(aou2.f28283e, aou2.f28280b, aou2.f28279a), bdv, bundle);
            } catch (Throwable th) {
                mt.m19919b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "Not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(r1.f28480a.getClass().getCanonicalName());
            mt.m19924e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo4113a(C2758b c2758b, hm hmVar, List<String> list) {
        if (this.f28480a instanceof InitializableMediationRewardedVideoAdAdapter) {
            mt.m19918b("Initialize rewarded video adapter.");
            try {
                InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.f28480a;
                List arrayList = new ArrayList();
                for (String a : list) {
                    arrayList.add(m37299a(a, null, null));
                }
                initializableMediationRewardedVideoAdAdapter.initialize((Context) C4757d.a(c2758b), new hp(hmVar), arrayList);
            } catch (Throwable th) {
                mt.m19921c("Could not initialize rewarded video adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "Not an InitializableMediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f28480a.getClass().getCanonicalName());
            mt.m19924e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo4114a(aoq aoq, String str) {
        mo4115a(aoq, str, null);
    }

    /* renamed from: a */
    public final void mo4115a(aoq aoq, String str, String str2) {
        if (this.f28480a instanceof MediationRewardedVideoAdAdapter) {
            mt.m19918b("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f28480a;
                Bundle bundle = null;
                C2681a bdv = new bdv(aoq.f28262b == -1 ? null : new Date(aoq.f28262b), aoq.f28264d, aoq.f28265e != null ? new HashSet(aoq.f28265e) : null, aoq.f28271k, m37300a(aoq), aoq.f28267g, aoq.f28278r);
                if (aoq.f28273m != null) {
                    bundle = aoq.f28273m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                }
                mediationRewardedVideoAdAdapter.loadAd(bdv, m37299a(str, aoq, str2), bundle);
            } catch (Throwable th) {
                mt.m19919b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "Not a MediationRewardedVideoAdAdapter: ";
            str = String.valueOf(this.f28480a.getClass().getCanonicalName());
            mt.m19924e(str.length() != 0 ? str3.concat(str) : new String(str3));
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public final void mo4116a(boolean z) {
        if (this.f28480a instanceof C2693k) {
            try {
                ((C2693k) this.f28480a).onImmersiveModeUpdated(z);
                return;
            } catch (Throwable th) {
                mt.m19919b("", th);
                return;
            }
        }
        String str = "Not an OnImmersiveModeUpdatedListener: ";
        String valueOf = String.valueOf(this.f28480a.getClass().getCanonicalName());
        mt.m19922d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    /* renamed from: b */
    public final void mo4117b() {
        if (this.f28480a instanceof MediationInterstitialAdapter) {
            mt.m19918b("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.f28480a).showInterstitial();
            } catch (Throwable th) {
                mt.m19919b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "Not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f28480a.getClass().getCanonicalName());
            mt.m19924e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    /* renamed from: c */
    public final void mo4118c() {
        try {
            this.f28480a.onDestroy();
        } catch (Throwable th) {
            mt.m19919b("", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    /* renamed from: d */
    public final void mo4119d() {
        try {
            this.f28480a.onPause();
        } catch (Throwable th) {
            mt.m19919b("", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    /* renamed from: e */
    public final void mo4120e() {
        try {
            this.f28480a.onResume();
        } catch (Throwable th) {
            mt.m19919b("", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    /* renamed from: f */
    public final void mo4121f() {
        if (this.f28480a instanceof MediationRewardedVideoAdAdapter) {
            mt.m19918b("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.f28480a).showVideo();
            } catch (Throwable th) {
                mt.m19919b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "Not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f28480a.getClass().getCanonicalName());
            mt.m19924e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    /* renamed from: g */
    public final boolean mo4122g() {
        if (this.f28480a instanceof MediationRewardedVideoAdAdapter) {
            mt.m19918b("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.f28480a).isInitialized();
            } catch (Throwable th) {
                mt.m19919b("", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "Not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f28480a.getClass().getCanonicalName());
            mt.m19924e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    /* renamed from: h */
    public final bdk mo4123h() {
        C2691f a = this.f28481b.m30588a();
        return a instanceof C4299g ? new bdy((C4299g) a) : null;
    }

    /* renamed from: i */
    public final bdo mo4124i() {
        C2691f a = this.f28481b.m30588a();
        return a instanceof C4300h ? new bdz((C4300h) a) : null;
    }

    /* renamed from: j */
    public final Bundle mo4125j() {
        if (this.f28480a instanceof zzatl) {
            return ((zzatl) this.f28480a).zzmq();
        }
        String str = "Not a v2 MediationBannerAdapter: ";
        String valueOf = String.valueOf(this.f28480a.getClass().getCanonicalName());
        mt.m19924e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        return new Bundle();
    }

    /* renamed from: k */
    public final Bundle mo4126k() {
        if (this.f28480a instanceof zzatm) {
            return ((zzatm) this.f28480a).getInterstitialAdapterInfo();
        }
        String str = "Not a v2 MediationInterstitialAdapter: ";
        String valueOf = String.valueOf(this.f28480a.getClass().getCanonicalName());
        mt.m19924e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        return new Bundle();
    }

    /* renamed from: l */
    public final Bundle mo4127l() {
        return new Bundle();
    }

    /* renamed from: m */
    public final boolean mo4128m() {
        return this.f28480a instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    /* renamed from: n */
    public final awa mo4129n() {
        C2618k c = this.f28481b.m30604c();
        return c instanceof awd ? ((awd) c).m30318b() : null;
    }

    /* renamed from: o */
    public final aqv mo4130o() {
        if (!(this.f28480a instanceof C2695m)) {
            return null;
        }
        try {
            return ((C2695m) this.f28480a).getVideoController();
        } catch (Throwable th) {
            mt.m19919b("", th);
            return null;
        }
    }

    /* renamed from: p */
    public final bdr mo4131p() {
        C2694l b = this.f28481b.m30600b();
        return b != null ? new bei(b) : null;
    }
}
