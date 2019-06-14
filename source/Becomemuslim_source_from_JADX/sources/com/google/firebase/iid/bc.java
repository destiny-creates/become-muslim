package com.google.firebase.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.C2868t;
import java.security.KeyPair;

final class bc {
    /* renamed from: a */
    private final KeyPair f18092a;
    /* renamed from: b */
    private final long f18093b;

    bc(KeyPair keyPair, long j) {
        this.f18092a = keyPair;
        this.f18093b = j;
    }

    /* renamed from: a */
    final KeyPair m22756a() {
        return this.f18092a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bc)) {
            return false;
        }
        bc bcVar = (bc) obj;
        if (this.f18093b == bcVar.f18093b && this.f18092a.getPublic().equals(bcVar.f18092a.getPublic()) && this.f18092a.getPrivate().equals(bcVar.f18092a.getPrivate()) != null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return C2868t.a(new Object[]{this.f18092a.getPublic(), this.f18092a.getPrivate(), Long.valueOf(this.f18093b)});
    }

    /* renamed from: b */
    private final String m22752b() {
        return Base64.encodeToString(this.f18092a.getPublic().getEncoded(), 11);
    }

    /* renamed from: c */
    private final String m22755c() {
        return Base64.encodeToString(this.f18092a.getPrivate().getEncoded(), 11);
    }
}
