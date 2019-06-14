package com.google.android.gms.internal.p213l;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.l.l */
final class C5045l {
    /* renamed from: a */
    final int f17295a;
    /* renamed from: b */
    final byte[] f17296b;

    C5045l(int i, byte[] bArr) {
        this.f17295a = i;
        this.f17296b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C5045l)) {
            return false;
        }
        C5045l c5045l = (C5045l) obj;
        return this.f17295a == c5045l.f17295a && Arrays.equals(this.f17296b, c5045l.f17296b);
    }

    public final int hashCode() {
        return ((this.f17295a + 527) * 31) + Arrays.hashCode(this.f17296b);
    }
}
