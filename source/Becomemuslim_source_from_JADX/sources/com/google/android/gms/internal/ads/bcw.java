package com.google.android.gms.internal.ads;

final class bcw implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ bcp f15231a;

    bcw(bcv bcv, bcp bcp) {
        this.f15231a = bcp;
    }

    public final void run() {
        try {
            this.f15231a.f15222c.mo4118c();
        } catch (Throwable e) {
            mt.m19921c("Could not destroy mediation adapter.", e);
        }
    }
}
