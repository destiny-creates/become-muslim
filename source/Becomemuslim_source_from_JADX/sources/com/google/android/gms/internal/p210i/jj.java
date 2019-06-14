package com.google.android.gms.internal.p210i;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.i.jj */
final class jj {
    /* renamed from: a */
    final int f16794a;
    /* renamed from: b */
    final byte[] f16795b;

    jj(int i, byte[] bArr) {
        this.f16794a = i;
        this.f16795b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof jj)) {
            return false;
        }
        jj jjVar = (jj) obj;
        return this.f16794a == jjVar.f16794a && Arrays.equals(this.f16795b, jjVar.f16795b) != null;
    }

    public final int hashCode() {
        return ((this.f16794a + 527) * 31) + Arrays.hashCode(this.f16795b);
    }
}
