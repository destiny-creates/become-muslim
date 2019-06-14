package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final class aso implements Callable<T> {
    /* renamed from: a */
    private final /* synthetic */ asf f14908a;
    /* renamed from: b */
    private final /* synthetic */ asn f14909b;

    aso(asn asn, asf asf) {
        this.f14909b = asn;
        this.f14908a = asf;
    }

    public final T call() {
        return this.f14908a.mo3955a(this.f14909b.f14906d);
    }
}
