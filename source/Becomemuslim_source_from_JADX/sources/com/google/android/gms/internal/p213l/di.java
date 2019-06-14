package com.google.android.gms.internal.p213l;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.l.di */
final class di implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ AtomicReference f17098a;
    /* renamed from: b */
    private final /* synthetic */ boolean f17099b;
    /* renamed from: c */
    private final /* synthetic */ df f17100c;

    di(df dfVar, AtomicReference atomicReference, boolean z) {
        this.f17100c = dfVar;
        this.f17098a = atomicReference;
        this.f17099b = z;
    }

    public final void run() {
        this.f17100c.mo6744h().m44201a(this.f17098a, this.f17099b);
    }
}
