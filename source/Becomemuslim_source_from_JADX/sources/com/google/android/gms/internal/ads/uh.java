package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class uh<P> {
    /* renamed from: a */
    private final P f16048a;
    /* renamed from: b */
    private final byte[] f16049b;
    /* renamed from: c */
    private final xi f16050c;
    /* renamed from: d */
    private final yb f16051d;

    public uh(P p, byte[] bArr, xi xiVar, yb ybVar) {
        this.f16048a = p;
        this.f16049b = Arrays.copyOf(bArr, bArr.length);
        this.f16050c = xiVar;
        this.f16051d = ybVar;
    }

    /* renamed from: a */
    public final P m20144a() {
        return this.f16048a;
    }

    /* renamed from: b */
    public final byte[] m20145b() {
        return this.f16049b == null ? null : Arrays.copyOf(this.f16049b, this.f16049b.length);
    }
}
