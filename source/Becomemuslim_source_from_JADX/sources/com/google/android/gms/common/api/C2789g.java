package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.common.api.g */
public abstract class C2789g<R extends C2814k> {

    /* renamed from: com.google.android.gms.common.api.g$a */
    public interface C2788a {
        /* renamed from: a */
        void mo2453a(Status status);
    }

    /* renamed from: a */
    public abstract R mo2376a(long j, TimeUnit timeUnit);

    /* renamed from: a */
    public abstract void mo2377a();

    /* renamed from: a */
    public abstract void mo2379a(C2815l<? super R> c2815l);

    /* renamed from: a */
    public abstract void mo2380a(C2815l<? super R> c2815l, long j, TimeUnit timeUnit);

    /* renamed from: b */
    public abstract boolean mo2381b();

    /* renamed from: a */
    public void mo2378a(C2788a c2788a) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: c */
    public Integer mo2382c() {
        throw new UnsupportedOperationException();
    }
}
