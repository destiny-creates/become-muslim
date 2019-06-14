package com.google.android.gms.p186f;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.f.m */
final class C4407m<TResult, TContinuationResult> implements C2949b, C2951d, C2952e<TContinuationResult>, C2965w<TResult> {
    /* renamed from: a */
    private final Executor f11762a;
    /* renamed from: b */
    private final C2948a<TResult, C2954g<TContinuationResult>> f11763b;
    /* renamed from: c */
    private final C4412z<TContinuationResult> f11764c;

    public C4407m(Executor executor, C2948a<TResult, C2954g<TContinuationResult>> c2948a, C4412z<TContinuationResult> c4412z) {
        this.f11762a = executor;
        this.f11763b = c2948a;
        this.f11764c = c4412z;
    }

    /* renamed from: a */
    public final void mo2574a(C2954g<TResult> c2954g) {
        this.f11762a.execute(new C2960n(this, c2954g));
    }

    /* renamed from: a */
    public final void mo2577a(TContinuationResult tContinuationResult) {
        this.f11764c.m14673a((Object) tContinuationResult);
    }

    /* renamed from: a */
    public final void mo2576a(Exception exception) {
        this.f11764c.m14672a(exception);
    }

    /* renamed from: a */
    public final void mo2575a() {
        this.f11764c.m14682f();
    }
}
