package com.google.android.gms.internal.p213l;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.l.dt */
final class dt implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ AtomicReference f17127a;
    /* renamed from: b */
    private final /* synthetic */ df f17128b;

    dt(df dfVar, AtomicReference atomicReference) {
        this.f17128b = dfVar;
        this.f17127a = atomicReference;
    }

    public final void run() {
        synchronized (this.f17127a) {
            try {
                this.f17127a.set(Double.valueOf(this.f17128b.mo6215t().m38042c(this.f17128b.mo6743g().m43958C(), as.f16926T)));
                this.f17127a.notify();
            } catch (Throwable th) {
                this.f17127a.notify();
            }
        }
    }
}
