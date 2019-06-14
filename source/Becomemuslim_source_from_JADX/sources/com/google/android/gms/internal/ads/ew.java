package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;

final class ew implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ dl f15367a;
    /* renamed from: b */
    private final /* synthetic */ dw f15368b;
    /* renamed from: c */
    private final /* synthetic */ eu f15369c;

    ew(eu euVar, dl dlVar, dw dwVar) {
        this.f15369c = euVar;
        this.f15367a = dlVar;
        this.f15368b = dwVar;
    }

    public final void run() {
        dp a;
        try {
            a = this.f15369c.mo4236a(this.f15367a);
        } catch (Throwable e) {
            ax.i().m30834a(e, "AdRequestServiceImpl.loadAdAsync");
            mt.m19921c("Could not fetch ad response due to an Exception.", e);
            a = null;
        }
        if (a == null) {
            a = new dp(0);
        }
        try {
            this.f15368b.mo4240a(a);
        } catch (Throwable e2) {
            mt.m19921c("Fail to forward ad response.", e2);
        }
    }
}
