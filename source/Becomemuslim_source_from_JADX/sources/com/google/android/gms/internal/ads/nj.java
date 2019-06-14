package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

final /* synthetic */ class nj implements Runnable {
    /* renamed from: a */
    private final nz f15830a;
    /* renamed from: b */
    private final no f15831b;
    /* renamed from: c */
    private final Class f15832c;
    /* renamed from: d */
    private final my f15833d;
    /* renamed from: e */
    private final Executor f15834e;

    nj(nz nzVar, no noVar, Class cls, my myVar, Executor executor) {
        this.f15830a = nzVar;
        this.f15831b = noVar;
        this.f15832c = cls;
        this.f15833d = myVar;
        this.f15834e = executor;
    }

    public final void run() {
        nd.m19949a(this.f15830a, this.f15831b, this.f15832c, this.f15833d, this.f15834e);
    }
}
