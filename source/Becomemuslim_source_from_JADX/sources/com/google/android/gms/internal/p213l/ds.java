package com.google.android.gms.internal.p213l;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.l.ds */
final class ds implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ AtomicReference f17125a;
    /* renamed from: b */
    private final /* synthetic */ df f17126b;

    ds(df dfVar, AtomicReference atomicReference) {
        this.f17126b = dfVar;
        this.f17125a = atomicReference;
    }

    public final void run() {
        synchronized (this.f17125a) {
            try {
                this.f17125a.set(Integer.valueOf(this.f17126b.mo6215t().m38039b(this.f17126b.mo6743g().m43958C(), as.f16925S)));
                this.f17125a.notify();
            } catch (Throwable th) {
                this.f17125a.notify();
            }
        }
    }
}
