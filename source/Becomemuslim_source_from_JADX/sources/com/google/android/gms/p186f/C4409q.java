package com.google.android.gms.p186f;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.f.q */
final class C4409q<TResult> implements C2965w<TResult> {
    /* renamed from: a */
    private final Executor f11768a;
    /* renamed from: b */
    private final Object f11769b = new Object();
    /* renamed from: c */
    private C2950c<TResult> f11770c;

    public C4409q(Executor executor, C2950c<TResult> c2950c) {
        this.f11768a = executor;
        this.f11770c = c2950c;
    }

    /* renamed from: a */
    public final void mo2574a(C2954g<TResult> c2954g) {
        synchronized (this.f11769b) {
            if (this.f11770c == null) {
                return;
            }
            this.f11768a.execute(new C2962r(this, c2954g));
        }
    }
}
