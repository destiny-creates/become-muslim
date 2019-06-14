package com.google.android.gms.internal.p213l;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.l.dg */
final class dg implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ AtomicReference f17091a;
    /* renamed from: b */
    private final /* synthetic */ df f17092b;

    dg(df dfVar, AtomicReference atomicReference) {
        this.f17092b = dfVar;
        this.f17091a = atomicReference;
    }

    public final void run() {
        synchronized (this.f17091a) {
            try {
                this.f17091a.set(Boolean.valueOf(this.f17092b.mo6215t().m38054h(this.f17092b.mo6743g().m43958C())));
                this.f17091a.notify();
            } catch (Throwable th) {
                this.f17091a.notify();
            }
        }
    }
}
