package com.google.android.gms.internal.ads;

final class ayy implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ ayz f15062a;
    /* renamed from: b */
    private final /* synthetic */ aza f15063b;

    ayy(axz axz, ayz ayz, aza aza) {
        this.f15062a = ayz;
        this.f15063b = aza;
    }

    public final void run() {
        try {
            this.f15062a.mo4085a(this.f15063b);
        } catch (Throwable e) {
            mt.m19921c("Could not propagate interstitial ad event.", e);
        }
    }
}
