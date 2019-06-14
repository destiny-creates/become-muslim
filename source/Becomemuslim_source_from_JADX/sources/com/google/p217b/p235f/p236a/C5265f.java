package com.google.p217b.p235f.p236a;

import java.util.Formatter;

/* compiled from: DetectionResult */
/* renamed from: com.google.b.f.a.f */
final class C5265f {
    /* renamed from: a */
    private final C5258a f17773a;
    /* renamed from: b */
    private final C5266g[] f17774b = new C5266g[(this.f17776d + 2)];
    /* renamed from: c */
    private C5260c f17775c;
    /* renamed from: d */
    private final int f17776d;

    C5265f(C5258a c5258a, C5260c c5260c) {
        this.f17773a = c5258a;
        this.f17776d = c5258a.m22268a();
        this.f17775c = c5260c;
    }

    /* renamed from: a */
    C5266g[] m22314a() {
        m22304a(this.f17774b[0]);
        m22304a(this.f17774b[this.f17776d + 1]);
        int i = 928;
        while (true) {
            int f = m22306f();
            if (f <= 0) {
                break;
            } else if (f >= i) {
                break;
            } else {
                i = f;
            }
        }
        return this.f17774b;
    }

    /* renamed from: a */
    private void m22304a(C5266g c5266g) {
        if (c5266g != null) {
            ((C6876h) c5266g).m32309a(this.f17773a);
        }
    }

    /* renamed from: f */
    private int m22306f() {
        int g = m22307g();
        if (g == 0) {
            return 0;
        }
        for (int i = 1; i < this.f17776d + 1; i++) {
            C5261d[] b = this.f17774b[i].m22323b();
            int i2 = 0;
            while (i2 < b.length) {
                if (!(b[i2] == null || b[i2].m22285a())) {
                    m22303a(i, i2, b);
                }
                i2++;
            }
        }
        return g;
    }

    /* renamed from: g */
    private int m22307g() {
        m22308h();
        return m22310j() + m22309i();
    }

    /* renamed from: h */
    private void m22308h() {
        int i = 0;
        if (this.f17774b[0] != null) {
            if (this.f17774b[this.f17776d + 1] != null) {
                C5261d[] b = this.f17774b[0].m22323b();
                C5261d[] b2 = this.f17774b[this.f17776d + 1].m22323b();
                while (i < b.length) {
                    if (!(b[i] == null || b2[i] == null || b[i].m22294h() != b2[i].m22294h())) {
                        for (int i2 = 1; i2 <= this.f17776d; i2++) {
                            C5261d c5261d = this.f17774b[i2].m22323b()[i];
                            if (c5261d != null) {
                                c5261d.m22288b(b[i].m22294h());
                                if (!c5261d.m22285a()) {
                                    this.f17774b[i2].m22323b()[i] = null;
                                }
                            }
                        }
                    }
                    i++;
                }
            }
        }
    }

    /* renamed from: i */
    private int m22309i() {
        if (this.f17774b[this.f17776d + 1] == null) {
            return 0;
        }
        C5261d[] b = this.f17774b[this.f17776d + 1].m22323b();
        int i = 0;
        for (int i2 = 0; i2 < b.length; i2++) {
            if (b[i2] != null) {
                int h = b[i2].m22294h();
                int i3 = i;
                i = 0;
                for (int i4 = this.f17776d + 1; i4 > 0 && i < 2; i4--) {
                    C5261d c5261d = this.f17774b[i4].m22323b()[i2];
                    if (c5261d != null) {
                        i = C5265f.m22302a(h, i, c5261d);
                        if (!c5261d.m22285a()) {
                            i3++;
                        }
                    }
                }
                i = i3;
            }
        }
        return i;
    }

    /* renamed from: j */
    private int m22310j() {
        if (this.f17774b[0] == null) {
            return 0;
        }
        C5261d[] b = this.f17774b[0].m22323b();
        int i = 0;
        for (int i2 = 0; i2 < b.length; i2++) {
            if (b[i2] != null) {
                int h = b[i2].m22294h();
                int i3 = i;
                int i4 = 0;
                for (i = 1; i < this.f17776d + 1 && i4 < 2; i++) {
                    C5261d c5261d = this.f17774b[i].m22323b()[i2];
                    if (c5261d != null) {
                        i4 = C5265f.m22302a(h, i4, c5261d);
                        if (!c5261d.m22285a()) {
                            i3++;
                        }
                    }
                }
                i = i3;
            }
        }
        return i;
    }

    /* renamed from: a */
    private static int m22302a(int i, int i2, C5261d c5261d) {
        if (c5261d == null) {
            return i2;
        }
        if (!c5261d.m22285a()) {
            if (c5261d.m22286a(i)) {
                c5261d.m22288b(i);
                i2 = 0;
            } else {
                i2++;
            }
        }
        return i2;
    }

    /* renamed from: a */
    private void m22303a(int i, int i2, C5261d[] c5261dArr) {
        C5261d c5261d = c5261dArr[i2];
        C5261d[] b = this.f17774b[i - 1].m22323b();
        i++;
        i = this.f17774b[i] != null ? this.f17774b[i].m22323b() : b;
        C5261d[] c5261dArr2 = new C5261d[14];
        c5261dArr2[2] = b[i2];
        c5261dArr2[3] = i[i2];
        int i3 = 0;
        if (i2 > 0) {
            int i4 = i2 - 1;
            c5261dArr2[0] = c5261dArr[i4];
            c5261dArr2[4] = b[i4];
            c5261dArr2[5] = i[i4];
        }
        if (i2 > 1) {
            int i5 = i2 - 2;
            c5261dArr2[8] = c5261dArr[i5];
            c5261dArr2[10] = b[i5];
            c5261dArr2[11] = i[i5];
        }
        if (i2 < c5261dArr.length - 1) {
            i4 = i2 + 1;
            c5261dArr2[1] = c5261dArr[i4];
            c5261dArr2[6] = b[i4];
            c5261dArr2[7] = i[i4];
        }
        if (i2 < c5261dArr.length - 2) {
            i2 += 2;
            c5261dArr2[9] = c5261dArr[i2];
            c5261dArr2[12] = b[i2];
            c5261dArr2[13] = i[i2];
        }
        while (i3 < 14 && C5265f.m22305a(c5261d, c5261dArr2[i3]) == 0) {
            i3++;
        }
    }

    /* renamed from: a */
    private static boolean m22305a(C5261d c5261d, C5261d c5261d2) {
        if (c5261d2 == null || !c5261d2.m22285a() || c5261d2.m22292f() != c5261d.m22292f()) {
            return false;
        }
        c5261d.m22288b(c5261d2.m22294h());
        return true;
    }

    /* renamed from: b */
    int m22315b() {
        return this.f17776d;
    }

    /* renamed from: c */
    int m22316c() {
        return this.f17773a.m22270c();
    }

    /* renamed from: d */
    int m22317d() {
        return this.f17773a.m22269b();
    }

    /* renamed from: a */
    void m22313a(C5260c c5260c) {
        this.f17775c = c5260c;
    }

    /* renamed from: e */
    C5260c m22318e() {
        return this.f17775c;
    }

    /* renamed from: a */
    void m22312a(int i, C5266g c5266g) {
        this.f17774b[i] = c5266g;
    }

    /* renamed from: a */
    C5266g m22311a(int i) {
        return this.f17774b[i];
    }

    public String toString() {
        Throwable th;
        C5266g c5266g = this.f17774b[0];
        if (c5266g == null) {
            c5266g = this.f17774b[this.f17776d + 1];
        }
        Formatter formatter = new Formatter();
        int i = 0;
        while (i < c5266g.m22323b().length) {
            try {
                formatter.format("CW %3d:", new Object[]{Integer.valueOf(i)});
                for (int i2 = 0; i2 < this.f17776d + 2; i2++) {
                    if (this.f17774b[i2] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        if (this.f17774b[i2].m22323b()[i] == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", new Object[]{Integer.valueOf(this.f17774b[i2].m22323b()[i].m22294h()), Integer.valueOf(this.f17774b[i2].m22323b()[i].m22293g())});
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
                i++;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
