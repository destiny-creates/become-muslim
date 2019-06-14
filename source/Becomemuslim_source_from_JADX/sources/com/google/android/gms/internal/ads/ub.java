package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class ub {
    /* renamed from: a */
    private xo f16043a;

    private ub(xo xoVar) {
        this.f16043a = xoVar;
    }

    /* renamed from: a */
    static final ub m20134a(xo xoVar) {
        if (xoVar != null && xoVar.m43748c() > 0) {
            return new ub(xoVar);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    /* renamed from: a */
    final xo m20135a() {
        return this.f16043a;
    }

    public final String toString() {
        return uj.m20158a(this.f16043a).toString();
    }
}
