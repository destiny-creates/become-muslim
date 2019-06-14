package com.google.android.gms.p186f;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.f.g */
public abstract class C2954g<TResult> {
    /* renamed from: a */
    public abstract C2954g<TResult> mo2579a(C2951d c2951d);

    /* renamed from: a */
    public abstract C2954g<TResult> mo2580a(C2952e<? super TResult> c2952e);

    /* renamed from: a */
    public abstract C2954g<TResult> mo2584a(Executor executor, C2951d c2951d);

    /* renamed from: a */
    public abstract C2954g<TResult> mo2585a(Executor executor, C2952e<? super TResult> c2952e);

    /* renamed from: a */
    public abstract <X extends Throwable> TResult mo2586a(Class<X> cls);

    /* renamed from: a */
    public abstract boolean mo2587a();

    /* renamed from: b */
    public abstract boolean mo2589b();

    /* renamed from: c */
    public abstract boolean mo2590c();

    /* renamed from: d */
    public abstract TResult mo2591d();

    /* renamed from: e */
    public abstract Exception mo2592e();

    /* renamed from: a */
    public C2954g<TResult> mo2578a(C2950c<TResult> c2950c) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    /* renamed from: a */
    public C2954g<TResult> mo2583a(Executor executor, C2950c<TResult> c2950c) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    /* renamed from: a */
    public C2954g<TResult> mo2582a(Executor executor, C2949b c2949b) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    /* renamed from: a */
    public <TContinuationResult> C2954g<TContinuationResult> mo2581a(Executor executor, C2948a<TResult, TContinuationResult> c2948a) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    /* renamed from: b */
    public <TContinuationResult> C2954g<TContinuationResult> mo2588b(Executor executor, C2948a<TResult, C2954g<TContinuationResult>> c2948a) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }
}
