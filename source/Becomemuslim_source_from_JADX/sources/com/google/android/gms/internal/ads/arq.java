package com.google.android.gms.internal.ads;

final class arq implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ arp f14887a;

    arq(arp arp) {
        this.f14887a = arp;
    }

    public final void run() {
        if (this.f14887a.f28298a != null) {
            try {
                this.f14887a.f28298a.mo3859a(1);
            } catch (Throwable e) {
                mt.m19921c("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
