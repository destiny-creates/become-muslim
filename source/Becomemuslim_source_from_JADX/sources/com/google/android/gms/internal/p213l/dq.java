package com.google.android.gms.internal.p213l;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.l.dq */
final class dq implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ AtomicReference f17121a;
    /* renamed from: b */
    private final /* synthetic */ df f17122b;

    dq(df dfVar, AtomicReference atomicReference) {
        this.f17122b = dfVar;
        this.f17121a = atomicReference;
    }

    public final void run() {
        synchronized (this.f17121a) {
            try {
                this.f17121a.set(this.f17122b.mo6215t().m38056i(this.f17122b.mo6743g().m43958C()));
                this.f17121a.notify();
            } catch (Throwable th) {
                this.f17121a.notify();
            }
        }
    }
}
