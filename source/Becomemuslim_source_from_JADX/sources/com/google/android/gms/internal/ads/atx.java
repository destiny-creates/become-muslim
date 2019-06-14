package com.google.android.gms.internal.ads;

final class atx implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ atw f15001a;

    atx(atw atw) {
        this.f15001a = atw;
    }

    public final void run() {
        if (this.f15001a.f28354n != null) {
            this.f15001a.f28354n.mo3989i();
            this.f15001a.f28354n.mo3988h();
            this.f15001a.f28354n.mo3991k();
        }
        this.f15001a.f28354n = null;
    }
}
