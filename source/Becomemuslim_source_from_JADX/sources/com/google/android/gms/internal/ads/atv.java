package com.google.android.gms.internal.ads;

final class atv implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ atu f15000a;

    atv(atu atu) {
        this.f15000a = atu;
    }

    public final void run() {
        if (this.f15000a.f28340p != null) {
            this.f15000a.f28340p.mo3989i();
            this.f15000a.f28340p.mo3988h();
            this.f15000a.f28340p.mo3991k();
        }
        this.f15000a.f28340p = null;
    }
}
