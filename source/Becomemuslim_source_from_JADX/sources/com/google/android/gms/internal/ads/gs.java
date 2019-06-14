package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.C2699c;

@cm
public final class gs extends go {
    /* renamed from: a */
    private C2699c f28662a;

    public gs(C2699c c2699c) {
        this.f28662a = c2699c;
    }

    /* renamed from: a */
    public final void mo4267a() {
        if (this.f28662a != null) {
            this.f28662a.onRewardedVideoAdLoaded();
        }
    }

    /* renamed from: a */
    public final void mo4268a(int i) {
        if (this.f28662a != null) {
            this.f28662a.onRewardedVideoAdFailedToLoad(i);
        }
    }

    /* renamed from: a */
    public final void m37503a(C2699c c2699c) {
        this.f28662a = c2699c;
    }

    /* renamed from: a */
    public final void mo4269a(gc gcVar) {
        if (this.f28662a != null) {
            this.f28662a.onRewarded(new gq(gcVar));
        }
    }

    /* renamed from: b */
    public final void mo4270b() {
        if (this.f28662a != null) {
            this.f28662a.onRewardedVideoAdOpened();
        }
    }

    /* renamed from: c */
    public final void mo4271c() {
        if (this.f28662a != null) {
            this.f28662a.onRewardedVideoStarted();
        }
    }

    /* renamed from: d */
    public final void mo4272d() {
        if (this.f28662a != null) {
            this.f28662a.onRewardedVideoAdClosed();
        }
    }

    /* renamed from: e */
    public final void mo4273e() {
        if (this.f28662a != null) {
            this.f28662a.onRewardedVideoAdLeftApplication();
        }
    }

    /* renamed from: f */
    public final void mo4274f() {
        if (this.f28662a != null) {
            this.f28662a.onRewardedVideoCompleted();
        }
    }
}
