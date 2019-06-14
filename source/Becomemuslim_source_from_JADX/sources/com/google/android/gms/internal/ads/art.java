package com.google.android.gms.internal.ads;

final class art implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ ars f14888a;

    art(ars ars) {
        this.f14888a = ars;
    }

    public final void run() {
        if (this.f14888a.f28299a != null) {
            try {
                this.f14888a.f28299a.mo4268a(1);
            } catch (Throwable e) {
                mt.m19921c("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
