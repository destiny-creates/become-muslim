package com.google.android.gms.internal.ads;

final class auc implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ aub f15003a;

    auc(aub aub) {
        this.f15003a = aub;
    }

    public final void run() {
        if (this.f15003a.f28379q != null) {
            this.f15003a.f28379q.mo3989i();
            this.f15003a.f28379q.mo3988h();
            this.f15003a.f28379q.mo3991k();
        }
        this.f15003a.f28379q = null;
    }
}
