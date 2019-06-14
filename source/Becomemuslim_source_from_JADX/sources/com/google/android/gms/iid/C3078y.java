package com.google.android.gms.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.C2868t;
import java.security.KeyPair;

/* renamed from: com.google.android.gms.iid.y */
final class C3078y {
    /* renamed from: a */
    private final KeyPair f7866a;
    /* renamed from: b */
    private final long f7867b;

    C3078y(KeyPair keyPair, long j) {
        this.f7866a = keyPair;
        this.f7867b = j;
    }

    /* renamed from: a */
    final KeyPair m9018a() {
        return this.f7866a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C3078y)) {
            return false;
        }
        C3078y c3078y = (C3078y) obj;
        if (this.f7867b == c3078y.f7867b && this.f7866a.getPublic().equals(c3078y.f7866a.getPublic()) && this.f7866a.getPrivate().equals(c3078y.f7866a.getPrivate()) != null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return C2868t.m8372a(this.f7866a.getPublic(), this.f7866a.getPrivate(), Long.valueOf(this.f7867b));
    }

    /* renamed from: b */
    private final String m9014b() {
        return Base64.encodeToString(this.f7866a.getPublic().getEncoded(), 11);
    }

    /* renamed from: c */
    private final String m9017c() {
        return Base64.encodeToString(this.f7866a.getPrivate().getEncoded(), 11);
    }
}
