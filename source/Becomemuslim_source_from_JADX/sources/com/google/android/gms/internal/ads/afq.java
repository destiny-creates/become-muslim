package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class afq {
    /* renamed from: a */
    final int f14432a;
    /* renamed from: b */
    final byte[] f14433b;

    afq(int i, byte[] bArr) {
        this.f14432a = i;
        this.f14433b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof afq)) {
            return false;
        }
        afq afq = (afq) obj;
        return this.f14432a == afq.f14432a && Arrays.equals(this.f14433b, afq.f14433b);
    }

    public final int hashCode() {
        return ((this.f14432a + 527) * 31) + Arrays.hashCode(this.f14433b);
    }
}
