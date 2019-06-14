package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.C2603a;
import com.google.android.gms.ads.C2624b;
import com.google.android.gms.ads.C2624b.C2604a;
import com.google.android.gms.ads.C2628c;
import com.google.android.gms.ads.C2628c.C2625a;
import com.google.android.gms.ads.C2631d;
import com.google.android.gms.ads.C2634h;
import com.google.android.gms.ads.C2678k;
import com.google.android.gms.ads.C4263e;
import com.google.android.gms.ads.mediation.C2681a;
import com.google.android.gms.ads.mediation.C2683b.C2682a;
import com.google.android.gms.ads.mediation.C2684c;
import com.google.android.gms.ads.mediation.C2689d;
import com.google.android.gms.ads.mediation.C2690e;
import com.google.android.gms.ads.mediation.C2693k;
import com.google.android.gms.ads.mediation.C2694l;
import com.google.android.gms.ads.mediation.C2695m;
import com.google.android.gms.ads.mediation.C4299g;
import com.google.android.gms.ads.mediation.C4300h;
import com.google.android.gms.ads.mediation.C4301i;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.p167a.C2595a;
import com.google.android.gms.ads.p168b.C2611d;
import com.google.android.gms.ads.p168b.C2612e;
import com.google.android.gms.ads.p168b.C2613f;
import com.google.android.gms.ads.p168b.C2618k;
import com.google.android.gms.ads.p168b.C2618k.C2616a;
import com.google.android.gms.ads.p168b.C2618k.C2617b;
import com.google.android.gms.ads.p168b.C2620m;
import com.google.android.gms.ads.p168b.C2620m.C2619a;
import com.google.android.gms.ads.p168b.C2621n;
import com.google.android.gms.ads.p168b.C4259g;
import com.google.android.gms.ads.p168b.C4259g.C2614a;
import com.google.android.gms.ads.p168b.C4261i;
import com.google.android.gms.ads.p168b.C4261i.C2615a;
import com.google.android.gms.ads.reward.C2699c;
import com.google.android.gms.ads.reward.mediation.C2701a;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.internal.ads.aok;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.aqv;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.mi;
import com.google.android.gms.internal.ads.mt;
import com.google.android.gms.internal.ads.zzatm;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@cm
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, C2693k, C2695m, MediationRewardedVideoAdAdapter, zzatm {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private C4263e zzgw;
    private C2634h zzgx;
    private C2624b zzgy;
    private Context zzgz;
    private C2634h zzha;
    private C2701a zzhb;
    private final C2699c zzhc = new C4066g(this);

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$c */
    static class C4059c extends C2694l {
        /* renamed from: a */
        private final C2620m f10138a;

        public C4059c(C2620m c2620m) {
            this.f10138a = c2620m;
            m7631a(c2620m.m7382a());
            m7632a(c2620m.m7383b());
            m7636b(c2620m.m7384c());
            m7627a(c2620m.m7385d());
            m7639c(c2620m.m7386e());
            m7641d(c2620m.m7387f());
            m7629a(c2620m.m7388g());
            m7643e(c2620m.m7389h());
            m7645f(c2620m.m7390i());
            m7630a(c2620m.m7393l());
            m7633a(true);
            m7637b(true);
            m7628a(c2620m.m7391j());
        }

        /* renamed from: a */
        public final void mo2038a(View view, Map<String, View> map, Map<String, View> map2) {
            if (view instanceof C2621n) {
                ((C2621n) view).setNativeAd(this.f10138a);
                return;
            }
            C2613f c2613f = (C2613f) C2613f.f6657a.get(view);
            if (c2613f != null) {
                c2613f.m7377a(this.f10138a);
            }
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$d */
    static final class C4060d extends C2603a implements C2595a, aok {
        /* renamed from: a */
        private final AbstractAdViewAdapter f10139a;
        /* renamed from: b */
        private final C2684c f10140b;

        public C4060d(AbstractAdViewAdapter abstractAdViewAdapter, C2684c c2684c) {
            this.f10139a = abstractAdViewAdapter;
            this.f10140b = c2684c;
        }

        public final void onAdClicked() {
            this.f10140b.m7588e(this.f10139a);
        }

        public final void onAdClosed() {
            this.f10140b.m7586c(this.f10139a);
        }

        public final void onAdFailedToLoad(int i) {
            this.f10140b.m7583a(this.f10139a, i);
        }

        public final void onAdLeftApplication() {
            this.f10140b.m7587d(this.f10139a);
        }

        public final void onAdLoaded() {
            this.f10140b.m7582a(this.f10139a);
        }

        public final void onAdOpened() {
            this.f10140b.m7585b(this.f10139a);
        }

        public final void onAppEvent(String str, String str2) {
            this.f10140b.m7584a(this.f10139a, str, str2);
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$e */
    static final class C4061e extends C2603a implements aok {
        /* renamed from: a */
        private final AbstractAdViewAdapter f10141a;
        /* renamed from: b */
        private final C2689d f10142b;

        public C4061e(AbstractAdViewAdapter abstractAdViewAdapter, C2689d c2689d) {
            this.f10141a = abstractAdViewAdapter;
            this.f10142b = c2689d;
        }

        public final void onAdClicked() {
            this.f10142b.m7597e(this.f10141a);
        }

        public final void onAdClosed() {
            this.f10142b.m7595c(this.f10141a);
        }

        public final void onAdFailedToLoad(int i) {
            this.f10142b.m7593a(this.f10141a, i);
        }

        public final void onAdLeftApplication() {
            this.f10142b.m7596d(this.f10141a);
        }

        public final void onAdLoaded() {
            this.f10142b.m7592a(this.f10141a);
        }

        public final void onAdOpened() {
            this.f10142b.m7594b(this.f10141a);
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$f */
    static final class C4062f extends C2603a implements C2614a, C2615a, C2616a, C2617b, C2619a {
        /* renamed from: a */
        private final AbstractAdViewAdapter f10143a;
        /* renamed from: b */
        private final C2690e f10144b;

        public C4062f(AbstractAdViewAdapter abstractAdViewAdapter, C2690e c2690e) {
            this.f10143a = abstractAdViewAdapter;
            this.f10144b = c2690e;
        }

        /* renamed from: a */
        public final void mo2044a(C2618k c2618k) {
            this.f10144b.m7600a(this.f10143a, c2618k);
        }

        /* renamed from: a */
        public final void mo2045a(C2618k c2618k, String str) {
            this.f10144b.m7601a(this.f10143a, c2618k, str);
        }

        /* renamed from: a */
        public final void mo2046a(C2620m c2620m) {
            this.f10144b.m7603a(this.f10143a, new C4059c(c2620m));
        }

        public final void onAdClicked() {
            this.f10144b.m7606d(this.f10143a);
        }

        public final void onAdClosed() {
            this.f10144b.m7604b(this.f10143a);
        }

        public final void onAdFailedToLoad(int i) {
            this.f10144b.m7599a(this.f10143a, i);
        }

        public final void onAdImpression() {
            this.f10144b.m7607e(this.f10143a);
        }

        public final void onAdLeftApplication() {
            this.f10144b.m7605c(this.f10143a);
        }

        public final void onAdLoaded() {
        }

        public final void onAdOpened() {
            this.f10144b.m7598a(this.f10143a);
        }

        public final void onAppInstallAdLoaded(C4259g c4259g) {
            this.f10144b.m7602a(this.f10143a, new C4687a(c4259g));
        }

        public final void onContentAdLoaded(C4261i c4261i) {
            this.f10144b.m7602a(this.f10143a, new C4688b(c4261i));
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$a */
    static class C4687a extends C4299g {
        /* renamed from: e */
        private final C4259g f12638e;

        public C4687a(C4259g c4259g) {
            this.f12638e = c4259g;
            m13929a(c4259g.m13877b().toString());
            m13930a(c4259g.m13878c());
            m13931b(c4259g.m13879d().toString());
            m13928a(c4259g.m13880e());
            m13932c(c4259g.m13881f().toString());
            if (c4259g.m13882g() != null) {
                m13927a(c4259g.m13882g().doubleValue());
            }
            if (c4259g.m13883h() != null) {
                m13933d(c4259g.m13883h().toString());
            }
            if (c4259g.m13884i() != null) {
                m13934e(c4259g.m13884i().toString());
            }
            m7611a(true);
            m7614b(true);
            m7610a(c4259g.m13885j());
        }

        /* renamed from: a */
        public final void mo3168a(View view) {
            if (view instanceof C2612e) {
                ((C2612e) view).setNativeAd(this.f12638e);
            }
            C2613f c2613f = (C2613f) C2613f.f6657a.get(view);
            if (c2613f != null) {
                c2613f.m7376a(this.f12638e);
            }
        }
    }

    /* renamed from: com.google.ads.mediation.AbstractAdViewAdapter$b */
    static class C4688b extends C4300h {
        /* renamed from: e */
        private final C4261i f12639e;

        public C4688b(C4261i c4261i) {
            this.f12639e = c4261i;
            m13944a(c4261i.m13886b().toString());
            m13945a(c4261i.m13887c());
            m13946b(c4261i.m13888d().toString());
            if (c4261i.m13889e() != null) {
                m13943a(c4261i.m13889e());
            }
            m13947c(c4261i.m13890f().toString());
            m13948d(c4261i.m13891g().toString());
            m7611a(true);
            m7614b(true);
            m7610a(c4261i.m13892h());
        }

        /* renamed from: a */
        public final void mo3168a(View view) {
            if (view instanceof C2612e) {
                ((C2612e) view).setNativeAd(this.f12639e);
            }
            C2613f c2613f = (C2613f) C2613f.f6657a.get(view);
            if (c2613f != null) {
                c2613f.m7376a(this.f12639e);
            }
        }
    }

    private final C2628c zza(Context context, C2681a c2681a, Bundle bundle, Bundle bundle2) {
        C2625a c2625a = new C2625a();
        Date a = c2681a.m7573a();
        if (a != null) {
            c2625a.m7403a(a);
        }
        int b = c2681a.m7574b();
        if (b != 0) {
            c2625a.m7399a(b);
        }
        Set<String> c = c2681a.m7575c();
        if (c != null) {
            for (String a2 : c) {
                c2625a.m7402a(a2);
            }
        }
        Location d = c2681a.m7576d();
        if (d != null) {
            c2625a.m7400a(d);
        }
        if (c2681a.m7578f()) {
            aph.a();
            c2625a.m7406b(mi.a(context));
        }
        if (c2681a.m7577e() != -1) {
            boolean z = true;
            if (c2681a.m7577e() != 1) {
                z = false;
            }
            c2625a.m7404a(z);
        }
        c2625a.m7407b(c2681a.m7579g());
        c2625a.m7401a(AdMobAdapter.class, zza(bundle, bundle2));
        return c2625a.m7405a();
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    public View getBannerView() {
        return this.zzgw;
    }

    public Bundle getInterstitialAdapterInfo() {
        return new C2682a().m7581a(1).m7580a();
    }

    public aqv getVideoController() {
        if (this.zzgw != null) {
            C2678k videoController = this.zzgw.getVideoController();
            if (videoController != null) {
                return videoController.m7567a();
            }
        }
        return null;
    }

    public void initialize(Context context, C2681a c2681a, String str, C2701a c2701a, Bundle bundle, Bundle bundle2) {
        this.zzgz = context.getApplicationContext();
        this.zzhb = c2701a;
        this.zzhb.m7667a((MediationRewardedVideoAdAdapter) this);
    }

    public boolean isInitialized() {
        return this.zzhb != null;
    }

    public void loadAd(C2681a c2681a, Bundle bundle, Bundle bundle2) {
        if (this.zzgz != null) {
            if (this.zzhb != null) {
                this.zzha = new C2634h(this.zzgz);
                this.zzha.m7425a(true);
                this.zzha.m7424a(getAdUnitId(bundle));
                this.zzha.m7422a(this.zzhc);
                this.zzha.m7423a(new C4067h(this));
                this.zzha.m7421a(zza(this.zzgz, c2681a, bundle2, bundle));
                return;
            }
        }
        mt.c("AdMobAdapter.loadAd called before initialize.");
    }

    public void onDestroy() {
        if (this.zzgw != null) {
            this.zzgw.mo2345c();
            this.zzgw = null;
        }
        if (this.zzgx != null) {
            this.zzgx = null;
        }
        if (this.zzgy != null) {
            this.zzgy = null;
        }
        if (this.zzha != null) {
            this.zzha = null;
        }
    }

    public void onImmersiveModeUpdated(boolean z) {
        if (this.zzgx != null) {
            this.zzgx.m7427b(z);
        }
        if (this.zzha != null) {
            this.zzha.m7427b(z);
        }
    }

    public void onPause() {
        if (this.zzgw != null) {
            this.zzgw.mo2344b();
        }
    }

    public void onResume() {
        if (this.zzgw != null) {
            this.zzgw.mo2342a();
        }
    }

    public void requestBannerAd(Context context, C2684c c2684c, Bundle bundle, C2631d c2631d, C2681a c2681a, Bundle bundle2) {
        this.zzgw = new C4263e(context);
        this.zzgw.setAdSize(new C2631d(c2631d.m7412b(), c2631d.m7410a()));
        this.zzgw.setAdUnitId(getAdUnitId(bundle));
        this.zzgw.setAdListener(new C4060d(this, c2684c));
        this.zzgw.mo2343a(zza(context, c2681a, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, C2689d c2689d, Bundle bundle, C2681a c2681a, Bundle bundle2) {
        this.zzgx = new C2634h(context);
        this.zzgx.m7424a(getAdUnitId(bundle));
        this.zzgx.m7420a(new C4061e(this, c2689d));
        this.zzgx.m7421a(zza(context, c2681a, bundle2, bundle));
    }

    public void requestNativeAd(Context context, C2690e c2690e, Bundle bundle, C4301i c4301i, Bundle bundle2) {
        C2615a c4062f = new C4062f(this, c2690e);
        C2604a a = new C2604a(context, bundle.getString(AD_UNIT_ID_PARAMETER)).m7344a((C2603a) c4062f);
        C2611d h = c4301i.m13955h();
        if (h != null) {
            a.m7345a(h);
        }
        if (c4301i.m13957j()) {
            a.m7348a((C2619a) c4062f);
        }
        if (c4301i.m13956i()) {
            a.m7346a((C2614a) c4062f);
        }
        if (c4301i.m13958k()) {
            a.m7347a(c4062f);
        }
        if (c4301i.m13959l()) {
            for (String str : c4301i.m13960m().keySet()) {
                a.m7349a(str, c4062f, ((Boolean) c4301i.m13960m().get(str)).booleanValue() ? c4062f : null);
            }
        }
        this.zzgy = a.m7350a();
        this.zzgy.m7397a(zza(context, c4301i, bundle2, bundle));
    }

    public void showInterstitial() {
        this.zzgx.m7429c();
    }

    public void showVideo() {
        this.zzha.m7429c();
    }

    protected abstract Bundle zza(Bundle bundle, Bundle bundle2);
}
