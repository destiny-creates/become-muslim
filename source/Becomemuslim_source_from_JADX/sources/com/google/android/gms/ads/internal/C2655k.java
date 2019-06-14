package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.aoq;

/* renamed from: com.google.android.gms.ads.internal.k */
final class C2655k implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ aoq f6898a;
    /* renamed from: b */
    private final /* synthetic */ int f6899b;
    /* renamed from: c */
    private final /* synthetic */ C4737i f6900c;

    C2655k(C4737i c4737i, aoq aoq, int i) {
        this.f6900c = c4737i;
        this.f6898a = aoq;
        this.f6899b = i;
    }

    public final void run() {
        synchronized (this.f6900c.f13004s) {
            this.f6900c.m16533b(this.f6898a, this.f6899b);
        }
    }
}
