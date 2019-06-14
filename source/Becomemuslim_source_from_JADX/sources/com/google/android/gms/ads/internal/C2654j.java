package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.aoq;

/* renamed from: com.google.android.gms.ads.internal.j */
final class C2654j implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ aoq f6896a;
    /* renamed from: b */
    private final /* synthetic */ C4737i f6897b;

    C2654j(C4737i c4737i, aoq aoq) {
        this.f6897b = c4737i;
        this.f6896a = aoq;
    }

    public final void run() {
        synchronized (this.f6897b.f13004s) {
            if (this.f6897b.m16535d()) {
                this.f6897b.m16532b(this.f6896a);
            } else {
                this.f6897b.m16533b(this.f6896a, 1);
            }
        }
    }
}
