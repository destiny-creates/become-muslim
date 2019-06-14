package com.google.android.gms.internal.ads;

final class aua implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ aty f15002a;

    aua(aty aty) {
        this.f15002a = aty;
    }

    public final void run() {
        if (this.f15002a.f28362h != null) {
            this.f15002a.f28362h.mo3989i();
            this.f15002a.f28362h.mo3988h();
        }
        this.f15002a.f28362h = null;
    }
}
