package com.google.android.gms.internal.p213l;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.l.dr */
final class dr implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ AtomicReference f17123a;
    /* renamed from: b */
    private final /* synthetic */ df f17124b;

    dr(df dfVar, AtomicReference atomicReference) {
        this.f17124b = dfVar;
        this.f17123a = atomicReference;
    }

    public final void run() {
        synchronized (this.f17123a) {
            try {
                this.f17123a.set(Long.valueOf(this.f17124b.mo6215t().m38036a(this.f17124b.mo6743g().m43958C(), as.f16924R)));
                this.f17123a.notify();
            } catch (Throwable th) {
                this.f17123a.notify();
            }
        }
    }
}
