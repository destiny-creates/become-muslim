package com.google.android.gms.internal.ads;

final class ei implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ it f15336a;
    /* renamed from: b */
    private final /* synthetic */ eh f15337b;

    ei(eh ehVar, it itVar) {
        this.f15337b = ehVar;
        this.f15336a = itVar;
    }

    public final void run() {
        this.f15337b.f28643h.m19374a(this.f15336a);
        if (this.f15337b.f28647l != null) {
            this.f15337b.f28647l.m37254c();
            this.f15337b.f28647l = null;
        }
    }
}
