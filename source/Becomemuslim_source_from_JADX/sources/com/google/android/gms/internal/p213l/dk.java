package com.google.android.gms.internal.p213l;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.l.dk */
final class dk implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ AtomicReference f17102a;
    /* renamed from: b */
    private final /* synthetic */ df f17103b;

    dk(df dfVar, AtomicReference atomicReference) {
        this.f17103b = dfVar;
        this.f17102a = atomicReference;
    }

    public final void run() {
        this.f17103b.mo6744h().m44198a(this.f17102a);
    }
}
