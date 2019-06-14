package com.google.p217b.p225c.p226a;

import com.google.p217b.C6891h;
import com.google.p217b.p222b.C5202b;

/* compiled from: BitMatrixParser */
/* renamed from: com.google.b.c.a.a */
final class C5211a {
    /* renamed from: a */
    private final C5202b f17600a;
    /* renamed from: b */
    private final C5202b f17601b;
    /* renamed from: c */
    private final C5220e f17602c;

    C5211a(C5202b c5202b) {
        int g = c5202b.m22011g();
        if (g < 8 || g > 144 || (g & 1) != 0) {
            throw C6891h.m32342a();
        }
        this.f17602c = C5211a.m22053a(c5202b);
        this.f17600a = m22057b(c5202b);
        this.f17601b = new C5202b(this.f17600a.m22010f(), this.f17600a.m22011g());
    }

    /* renamed from: a */
    C5220e m22060a() {
        return this.f17602c;
    }

    /* renamed from: a */
    private static C5220e m22053a(C5202b c5202b) {
        return C5220e.m22080a(c5202b.m22011g(), c5202b.m22010f());
    }

    /* renamed from: b */
    byte[] m22061b() {
        byte[] bArr = new byte[this.f17602c.m22087f()];
        int g = this.f17600a.m22011g();
        int f = this.f17600a.m22010f();
        int i = 4;
        int i2 = 0;
        Object obj = null;
        int i3 = 0;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        while (true) {
            if (i == g && i2 == 0 && r6 == null) {
                int i4 = i3 + 1;
                bArr[i3] = (byte) m22052a(g, f);
                i -= 2;
                i2 += 2;
                i3 = i4;
                obj = 1;
            } else {
                int i5 = g - 2;
                if (i == i5 && i2 == 0 && (f & 3) != 0 && r8 == null) {
                    int i6 = i3 + 1;
                    bArr[i3] = (byte) m22055b(g, f);
                    i -= 2;
                    i2 += 2;
                    i3 = i6;
                    obj2 = 1;
                } else if (i == g + 4 && i2 == 2 && (f & 7) == 0 && r9 == null) {
                    int i7 = i3 + 1;
                    bArr[i3] = (byte) m22058c(g, f);
                    i -= 2;
                    i2 += 2;
                    i3 = i7;
                    obj3 = 1;
                } else if (i == i5 && i2 == 0 && (f & 7) == 4 && r10 == null) {
                    int i8 = i3 + 1;
                    bArr[i3] = (byte) m22059d(g, f);
                    i -= 2;
                    i2 += 2;
                    i3 = i8;
                    obj4 = 1;
                } else {
                    int i9;
                    do {
                        if (i < g && i2 >= 0 && !this.f17601b.m22002a(i2, i)) {
                            i9 = i3 + 1;
                            bArr[i3] = (byte) m22056b(i, i2, g, f);
                            i3 = i9;
                        }
                        i -= 2;
                        i2 += 2;
                        if (i < 0) {
                            break;
                        }
                    } while (i2 < f);
                    i++;
                    i2 += 3;
                    do {
                        if (i >= 0 && i2 < f && !this.f17601b.m22002a(i2, i)) {
                            i9 = i3 + 1;
                            bArr[i3] = (byte) m22056b(i, i2, g, f);
                            i3 = i9;
                        }
                        i += 2;
                        i2 -= 2;
                        if (i >= g) {
                            break;
                        }
                    } while (i2 >= 0);
                    i += 3;
                    i2++;
                }
            }
            if (i >= g && r5 >= f) {
                break;
            }
        }
        if (i3 == this.f17602c.m22087f()) {
            return bArr;
        }
        throw C6891h.m32342a();
    }

    /* renamed from: a */
    private boolean m22054a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        this.f17601b.m22004b(i2, i);
        return this.f17600a.m22002a(i2, i);
    }

    /* renamed from: b */
    private int m22056b(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int a = m22054a(i5, i6, i3, i4) << 1;
        int i7 = i2 - 1;
        if (m22054a(i5, i7, i3, i4)) {
            a |= 1;
        }
        i5 = a << 1;
        a = i - 1;
        if (m22054a(a, i6, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (m22054a(a, i7, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (m22054a(a, i2, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (m22054a(i, i6, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        if (m22054a(i, i7, i3, i4)) {
            i5 |= 1;
        }
        i5 <<= 1;
        return m22054a(i, i2, i3, i4) != 0 ? i5 | 1 : i5;
    }

    /* renamed from: a */
    private int m22052a(int i, int i2) {
        int i3 = i - 1;
        int a = m22054a(i3, 0, i, i2) << 1;
        if (m22054a(i3, 1, i, i2)) {
            a |= 1;
        }
        a <<= 1;
        if (m22054a(i3, 2, i, i2)) {
            a |= 1;
        }
        i3 = a << 1;
        if (m22054a(0, i2 - 2, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        a = i2 - 1;
        if (m22054a(0, a, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m22054a(1, a, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m22054a(2, a, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        return m22054a(3, a, i, i2) != 0 ? i3 | 1 : i3;
    }

    /* renamed from: b */
    private int m22055b(int i, int i2) {
        int a = m22054a(i - 3, 0, i, i2) << 1;
        if (m22054a(i - 2, 0, i, i2)) {
            a |= 1;
        }
        a <<= 1;
        if (m22054a(i - 1, 0, i, i2)) {
            a |= 1;
        }
        a <<= 1;
        if (m22054a(0, i2 - 4, i, i2)) {
            a |= 1;
        }
        a <<= 1;
        if (m22054a(0, i2 - 3, i, i2)) {
            a |= 1;
        }
        a <<= 1;
        if (m22054a(0, i2 - 2, i, i2)) {
            a |= 1;
        }
        a <<= 1;
        int i3 = i2 - 1;
        if (m22054a(0, i3, i, i2)) {
            a |= 1;
        }
        a <<= 1;
        return m22054a(1, i3, i, i2) != 0 ? a | 1 : a;
    }

    /* renamed from: c */
    private int m22058c(int i, int i2) {
        int i3 = i - 1;
        int a = m22054a(i3, 0, i, i2) << 1;
        int i4 = i2 - 1;
        if (m22054a(i3, i4, i, i2)) {
            a |= 1;
        }
        i3 = a << 1;
        a = i2 - 3;
        if (m22054a(0, a, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        int i5 = i2 - 2;
        if (m22054a(0, i5, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m22054a(0, i4, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m22054a(1, a, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        if (m22054a(1, i5, i, i2)) {
            i3 |= 1;
        }
        i3 <<= 1;
        return m22054a(1, i4, i, i2) != 0 ? i3 | 1 : i3;
    }

    /* renamed from: d */
    private int m22059d(int i, int i2) {
        int a = m22054a(i - 3, 0, i, i2) << 1;
        if (m22054a(i - 2, 0, i, i2)) {
            a |= 1;
        }
        a <<= 1;
        if (m22054a(i - 1, 0, i, i2)) {
            a |= 1;
        }
        a <<= 1;
        if (m22054a(0, i2 - 2, i, i2)) {
            a |= 1;
        }
        a <<= 1;
        int i3 = i2 - 1;
        if (m22054a(0, i3, i, i2)) {
            a |= 1;
        }
        a <<= 1;
        if (m22054a(1, i3, i, i2)) {
            a |= 1;
        }
        a <<= 1;
        if (m22054a(2, i3, i, i2)) {
            a |= 1;
        }
        a <<= 1;
        return m22054a(3, i3, i, i2) != 0 ? a | 1 : a;
    }

    /* renamed from: b */
    private C5202b m22057b(C5202b c5202b) {
        int b = this.f17602c.m22083b();
        int c = this.f17602c.m22084c();
        if (c5202b.m22011g() == b) {
            int d = r0.f17602c.m22085d();
            int e = r0.f17602c.m22086e();
            b /= d;
            c /= e;
            C5202b c5202b2 = new C5202b(c * e, b * d);
            for (int i = 0; i < b; i++) {
                C5202b c5202b3;
                int i2 = i * d;
                for (int i3 = 0; i3 < c; i3++) {
                    int i4 = i3 * e;
                    for (int i5 = 0; i5 < d; i5++) {
                        int i6 = (((d + 2) * i) + 1) + i5;
                        int i7 = i2 + i5;
                        for (int i8 = 0; i8 < e; i8++) {
                            if (c5202b.m22002a((((e + 2) * i3) + 1) + i8, i6)) {
                                c5202b2.m22004b(i4 + i8, i7);
                            }
                        }
                        c5202b3 = c5202b;
                    }
                    c5202b3 = c5202b;
                }
                c5202b3 = c5202b;
            }
            return c5202b2;
        }
        throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
    }
}
