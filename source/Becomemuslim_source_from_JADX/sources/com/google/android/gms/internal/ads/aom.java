package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.C2603a;

@cm
public final class aom extends apo {
    /* renamed from: a */
    private final C2603a f28259a;

    public aom(C2603a c2603a) {
        this.f28259a = c2603a;
    }

    /* renamed from: a */
    public final void mo3858a() {
        this.f28259a.onAdClosed();
    }

    /* renamed from: a */
    public final void mo3859a(int i) {
        this.f28259a.onAdFailedToLoad(i);
    }

    /* renamed from: b */
    public final void mo3860b() {
        this.f28259a.onAdLeftApplication();
    }

    /* renamed from: c */
    public final void mo3861c() {
        this.f28259a.onAdLoaded();
    }

    /* renamed from: d */
    public final void mo3862d() {
        this.f28259a.onAdOpened();
    }

    /* renamed from: e */
    public final void mo3863e() {
        this.f28259a.onAdClicked();
    }

    /* renamed from: f */
    public final void mo3864f() {
        this.f28259a.onAdImpression();
    }
}
