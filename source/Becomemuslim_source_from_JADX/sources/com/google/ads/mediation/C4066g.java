package com.google.ads.mediation;

import com.google.android.gms.ads.reward.C2697a;
import com.google.android.gms.ads.reward.C2699c;

/* renamed from: com.google.ads.mediation.g */
final class C4066g implements C2699c {
    /* renamed from: a */
    private final /* synthetic */ AbstractAdViewAdapter f10153a;

    C4066g(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.f10153a = abstractAdViewAdapter;
    }

    public final void onRewarded(C2697a c2697a) {
        this.f10153a.zzhb.m7669a(this.f10153a, c2697a);
    }

    public final void onRewardedVideoAdClosed() {
        this.f10153a.zzhb.m7673e(this.f10153a);
        this.f10153a.zzha = null;
    }

    public final void onRewardedVideoAdFailedToLoad(int i) {
        this.f10153a.zzhb.m7668a(this.f10153a, i);
    }

    public final void onRewardedVideoAdLeftApplication() {
        this.f10153a.zzhb.m7674f(this.f10153a);
    }

    public final void onRewardedVideoAdLoaded() {
        this.f10153a.zzhb.m7670b(this.f10153a);
    }

    public final void onRewardedVideoAdOpened() {
        this.f10153a.zzhb.m7671c(this.f10153a);
    }

    public final void onRewardedVideoCompleted() {
        this.f10153a.zzhb.m7675g(this.f10153a);
    }

    public final void onRewardedVideoStarted() {
        this.f10153a.zzhb.m7672d(this.f10153a);
    }
}
