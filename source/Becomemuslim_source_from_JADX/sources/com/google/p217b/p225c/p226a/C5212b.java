package com.google.p217b.p225c.p226a;

import com.google.p217b.p225c.p226a.C5220e.C5218a;
import com.google.p217b.p225c.p226a.C5220e.C5219b;

/* compiled from: DataBlock */
/* renamed from: com.google.b.c.a.b */
final class C5212b {
    /* renamed from: a */
    private final int f17603a;
    /* renamed from: b */
    private final byte[] f17604b;

    private C5212b(int i, byte[] bArr) {
        this.f17603a = i;
        this.f17604b = bArr;
    }

    /* renamed from: a */
    static C5212b[] m22062a(byte[] bArr, C5220e c5220e) {
        int i;
        C5219b g = c5220e.m22088g();
        C5218a[] b = g.m22079b();
        int i2 = 0;
        for (C5218a a : b) {
            i2 += a.m22076a();
        }
        C5212b[] c5212bArr = new C5212b[i2];
        int length = b.length;
        i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            C5218a c5218a = b[i2];
            int i4 = i3;
            i3 = 0;
            while (i3 < c5218a.m22076a()) {
                int b2 = c5218a.m22077b();
                int i5 = i4 + 1;
                c5212bArr[i4] = new C5212b(b2, new byte[(g.m22078a() + b2)]);
                i3++;
                i4 = i5;
            }
            i2++;
            i3 = i4;
        }
        int length2 = c5212bArr[0].f17604b.length - g.m22078a();
        int i6 = length2 - 1;
        length = 0;
        i2 = 0;
        while (length < i6) {
            i = i2;
            i2 = 0;
            while (i2 < i3) {
                b2 = i + 1;
                c5212bArr[i2].f17604b[length] = bArr[i];
                i2++;
                i = b2;
            }
            length++;
            i2 = i;
        }
        c5220e = c5220e.m22082a() == 24 ? true : null;
        length = c5220e != null ? 8 : i3;
        i = i2;
        i2 = 0;
        while (i2 < length) {
            b2 = i + 1;
            c5212bArr[i2].f17604b[i6] = bArr[i];
            i2++;
            i = b2;
        }
        i6 = c5212bArr[0].f17604b.length;
        while (length2 < i6) {
            length = 0;
            while (length < i3) {
                i2 = c5220e != null ? (length + 8) % i3 : length;
                i4 = (c5220e == null || i2 <= 7) ? length2 : length2 - 1;
                b2 = i + 1;
                c5212bArr[i2].f17604b[i4] = bArr[i];
                length++;
                i = b2;
            }
            length2++;
        }
        if (i == bArr.length) {
            return c5212bArr;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: a */
    int m22063a() {
        return this.f17603a;
    }

    /* renamed from: b */
    byte[] m22064b() {
        return this.f17604b;
    }
}
