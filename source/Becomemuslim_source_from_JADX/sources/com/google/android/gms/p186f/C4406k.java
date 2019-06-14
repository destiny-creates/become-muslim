package com.google.android.gms.p186f;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.f.k */
final class C4406k<TResult, TContinuationResult> implements C2965w<TResult> {
    /* renamed from: a */
    private final Executor f11759a;
    /* renamed from: b */
    private final C2948a<TResult, TContinuationResult> f11760b;
    /* renamed from: c */
    private final C4412z<TContinuationResult> f11761c;

    public C4406k(Executor executor, C2948a<TResult, TContinuationResult> c2948a, C4412z<TContinuationResult> c4412z) {
        this.f11759a = executor;
        this.f11760b = c2948a;
        this.f11761c = c4412z;
    }

    /* renamed from: a */
    public final void mo2574a(C2954g<TResult> c2954g) {
        this.f11759a.execute(new C2959l(this, c2954g));
    }
}
