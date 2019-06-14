package com.google.p217b.p240g.p241a;

import com.google.p217b.p240g.p241a.C5294j.C5292a;

/* compiled from: DataBlock */
/* renamed from: com.google.b.g.a.b */
final class C5283b {
    /* renamed from: a */
    private final int f17838a;
    /* renamed from: b */
    private final byte[] f17839b;

    private C5283b(int i, byte[] bArr) {
        this.f17838a = i;
        this.f17839b = bArr;
    }

    /* renamed from: a */
    static C5283b[] m22422a(byte[] bArr, C5294j c5294j, C5288f c5288f) {
        if (bArr.length == c5294j.m22462c()) {
            int i;
            int b;
            int i2;
            c5294j = c5294j.m22460a(c5288f);
            c5288f = c5294j.m22454d();
            int i3 = 0;
            for (C5292a a : c5288f) {
                i3 += a.m22449a();
            }
            C5283b[] c5283bArr = new C5283b[i3];
            int length = c5288f.length;
            i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                C5292a c5292a = c5288f[i3];
                i = i4;
                i4 = 0;
                while (i4 < c5292a.m22449a()) {
                    b = c5292a.m22450b();
                    int i5 = i + 1;
                    c5283bArr[i] = new C5283b(b, new byte[(c5294j.m22451a() + b)]);
                    i4++;
                    i = i5;
                }
                i3++;
                i4 = i;
            }
            c5288f = c5283bArr[0].f17839b.length;
            length = c5283bArr.length - 1;
            while (length >= 0 && c5283bArr[length].f17839b.length != c5288f) {
                length--;
            }
            length++;
            c5288f -= c5294j.m22451a();
            c5294j = null;
            i3 = 0;
            while (c5294j < c5288f) {
                i2 = i3;
                i3 = 0;
                while (i3 < i4) {
                    b = i2 + 1;
                    c5283bArr[i3].f17839b[c5294j] = bArr[i2];
                    i3++;
                    i2 = b;
                }
                c5294j++;
                i3 = i2;
            }
            c5294j = length;
            while (c5294j < i4) {
                i = i3 + 1;
                c5283bArr[c5294j].f17839b[c5288f] = bArr[i3];
                c5294j++;
                i3 = i;
            }
            C5288f length2 = c5283bArr[0].f17839b.length;
            while (c5288f < length2) {
                i2 = i3;
                i3 = 0;
                while (i3 < i4) {
                    int i6 = i2 + 1;
                    c5283bArr[i3].f17839b[i3 < length ? c5288f : c5288f + 1] = bArr[i2];
                    i3++;
                    i2 = i6;
                }
                c5288f++;
                i3 = i2;
            }
            return c5283bArr;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    int m22423a() {
        return this.f17838a;
    }

    /* renamed from: b */
    byte[] m22424b() {
        return this.f17839b;
    }
}
