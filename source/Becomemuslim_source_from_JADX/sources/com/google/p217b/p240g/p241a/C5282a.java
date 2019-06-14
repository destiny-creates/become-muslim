package com.google.p217b.p240g.p241a;

import com.google.p217b.C6891h;
import com.google.p217b.p222b.C5202b;

/* compiled from: BitMatrixParser */
/* renamed from: com.google.b.g.a.a */
final class C5282a {
    /* renamed from: a */
    private final C5202b f17834a;
    /* renamed from: b */
    private C5294j f17835b;
    /* renamed from: c */
    private C5289g f17836c;
    /* renamed from: d */
    private boolean f17837d;

    C5282a(C5202b c5202b) {
        int g = c5202b.m22011g();
        if (g < 21 || (g & 3) != 1) {
            throw C6891h.m32342a();
        }
        this.f17834a = c5202b;
    }

    /* renamed from: a */
    C5289g m22416a() {
        if (this.f17836c != null) {
            return this.f17836c;
        }
        int i;
        int i2 = 0;
        int i3 = 0;
        for (i = 0; i < 6; i++) {
            i3 = m22415a(i, 8, i3);
        }
        i = m22415a(8, 7, m22415a(8, 8, m22415a(7, 8, i3)));
        for (i3 = 5; i3 >= 0; i3--) {
            i = m22415a(8, i3, i);
        }
        i3 = this.f17834a.m22011g();
        int i4 = i3 - 7;
        for (int i5 = i3 - 1; i5 >= i4; i5--) {
            i2 = m22415a(8, i5, i2);
        }
        for (i4 = i3 - 8; i4 < i3; i4++) {
            i2 = m22415a(i4, 8, i2);
        }
        this.f17836c = C5289g.m22441b(i, i2);
        if (this.f17836c != null) {
            return this.f17836c;
        }
        throw C6891h.m32342a();
    }

    /* renamed from: b */
    C5294j m22418b() {
        if (this.f17835b != null) {
            return this.f17835b;
        }
        int g = this.f17834a.m22011g();
        int i = (g - 17) / 4;
        if (i <= 6) {
            return C5294j.m22456b(i);
        }
        int i2;
        i = g - 11;
        int i3 = 5;
        int i4 = 0;
        int i5 = 0;
        for (i2 = 5; i2 >= 0; i2--) {
            for (int i6 = g - 9; i6 >= i; i6--) {
                i5 = m22415a(i6, i2, i5);
            }
        }
        C5294j c = C5294j.m22457c(i5);
        if (c == null || c.m22463d() != g) {
            while (i3 >= 0) {
                for (i2 = g - 9; i2 >= i; i2--) {
                    i4 = m22415a(i3, i2, i4);
                }
                i3--;
            }
            C5294j c2 = C5294j.m22457c(i4);
            if (c2 == null || c2.m22463d() != g) {
                throw C6891h.m32342a();
            }
            this.f17835b = c2;
            return c2;
        }
        this.f17835b = c;
        return c;
    }

    /* renamed from: a */
    private int m22415a(int i, int i2, int i3) {
        return (this.f17837d ? this.f17834a.m22002a(i2, i) : this.f17834a.m22002a(i, i2)) != 0 ? (i3 << 1) | 1 : i3 << 1;
    }

    /* renamed from: c */
    byte[] m22419c() {
        C5289g a = m22416a();
        C5294j b = m22418b();
        C5284c c5284c = C5284c.values()[a.m22444b()];
        int g = this.f17834a.m22011g();
        c5284c.m22425a(this.f17834a, g);
        C5202b e = b.m22464e();
        byte[] bArr = new byte[b.m22462c()];
        int i = g - 1;
        int i2 = i;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        int i6 = 0;
        while (i2 > 0) {
            if (i2 == 6) {
                i2--;
            }
            int i7 = i6;
            i6 = i5;
            i5 = i3;
            i3 = 0;
            while (i3 < g) {
                int i8 = i4 != 0 ? i - i3 : i3;
                int i9 = i6;
                i6 = i5;
                for (i5 = 0; i5 < 2; i5++) {
                    int i10 = i2 - i5;
                    if (!e.m22002a(i10, i8)) {
                        i7++;
                        i9 <<= 1;
                        int i11 = r0.f17834a.m22002a(i10, i8) ? i9 | 1 : i9;
                        if (i7 == 8) {
                            i7 = i6 + 1;
                            bArr[i6] = (byte) i11;
                            i6 = i7;
                            i7 = 0;
                            i9 = 0;
                        } else {
                            i9 = i11;
                        }
                    }
                }
                i3++;
                i5 = i6;
                i6 = i9;
            }
            i4 ^= 1;
            i2 -= 2;
            i3 = i5;
            i5 = i6;
            i6 = i7;
        }
        if (i3 == b.m22462c()) {
            return bArr;
        }
        throw C6891h.m32342a();
    }

    /* renamed from: d */
    void m22420d() {
        if (this.f17836c != null) {
            C5284c.values()[this.f17836c.m22444b()].m22425a(this.f17834a, this.f17834a.m22011g());
        }
    }

    /* renamed from: a */
    void m22417a(boolean z) {
        this.f17835b = null;
        this.f17836c = null;
        this.f17837d = z;
    }

    /* renamed from: e */
    void m22421e() {
        int i = 0;
        while (i < this.f17834a.m22010f()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.f17834a.m22011g(); i3++) {
                if (this.f17834a.m22002a(i, i3) != this.f17834a.m22002a(i3, i)) {
                    this.f17834a.m22006c(i3, i);
                    this.f17834a.m22006c(i, i3);
                }
            }
            i = i2;
        }
    }
}
