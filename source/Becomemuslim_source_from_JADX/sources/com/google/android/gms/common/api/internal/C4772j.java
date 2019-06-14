package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.C2789g;
import com.google.android.gms.common.api.C2789g.C2788a;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.C2815l;
import com.google.android.gms.common.api.C4345f;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.common.api.internal.j */
public final class C4772j<R extends C2814k> extends C4345f<R> {
    /* renamed from: a */
    private final BasePendingResult<R> f13203a;

    public C4772j(C2789g<R> c2789g) {
        this.f13203a = (BasePendingResult) c2789g;
    }

    /* renamed from: a */
    public final R mo2376a(long j, TimeUnit timeUnit) {
        return this.f13203a.mo2376a(j, timeUnit);
    }

    /* renamed from: a */
    public final void mo2377a() {
        this.f13203a.mo2377a();
    }

    /* renamed from: b */
    public final boolean mo2381b() {
        return this.f13203a.mo2381b();
    }

    /* renamed from: a */
    public final void mo2379a(C2815l<? super R> c2815l) {
        this.f13203a.mo2379a((C2815l) c2815l);
    }

    /* renamed from: a */
    public final void mo2380a(C2815l<? super R> c2815l, long j, TimeUnit timeUnit) {
        this.f13203a.mo2380a(c2815l, j, timeUnit);
    }

    /* renamed from: a */
    public final void mo2378a(C2788a c2788a) {
        this.f13203a.mo2378a(c2788a);
    }

    /* renamed from: c */
    public final Integer mo2382c() {
        return this.f13203a.mo2382c();
    }
}
