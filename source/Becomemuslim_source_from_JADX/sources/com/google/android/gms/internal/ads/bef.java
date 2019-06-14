package com.google.android.gms.internal.ads;

import com.google.ads.C2172a.C2170a;

final class bef implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ C2170a f15234a;
    /* renamed from: b */
    private final /* synthetic */ bec f15235b;

    bef(bec bec, C2170a c2170a) {
        this.f15235b = bec;
        this.f15234a = c2170a;
    }

    public final void run() {
        try {
            this.f15235b.f23968a.mo4133a(beg.m19346a(this.f15234a));
        } catch (Throwable e) {
            mt.m19923d("#007 Could not call remote method.", e);
        }
    }
}
