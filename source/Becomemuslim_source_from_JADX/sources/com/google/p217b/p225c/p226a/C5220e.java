package com.google.p217b.p225c.p226a;

import com.google.p217b.C6891h;

/* compiled from: Version */
/* renamed from: com.google.b.c.a.e */
public final class C5220e {
    /* renamed from: a */
    private static final C5220e[] f17624a = C5220e.m22081h();
    /* renamed from: b */
    private final int f17625b;
    /* renamed from: c */
    private final int f17626c;
    /* renamed from: d */
    private final int f17627d;
    /* renamed from: e */
    private final int f17628e;
    /* renamed from: f */
    private final int f17629f;
    /* renamed from: g */
    private final C5219b f17630g;
    /* renamed from: h */
    private final int f17631h;

    /* compiled from: Version */
    /* renamed from: com.google.b.c.a.e$a */
    static final class C5218a {
        /* renamed from: a */
        private final int f17620a;
        /* renamed from: b */
        private final int f17621b;

        private C5218a(int i, int i2) {
            this.f17620a = i;
            this.f17621b = i2;
        }

        /* renamed from: a */
        int m22076a() {
            return this.f17620a;
        }

        /* renamed from: b */
        int m22077b() {
            return this.f17621b;
        }
    }

    /* compiled from: Version */
    /* renamed from: com.google.b.c.a.e$b */
    static final class C5219b {
        /* renamed from: a */
        private final int f17622a;
        /* renamed from: b */
        private final C5218a[] f17623b;

        private C5219b(int i, C5218a c5218a) {
            this.f17622a = i;
            this.f17623b = new C5218a[]{c5218a};
        }

        private C5219b(int i, C5218a c5218a, C5218a c5218a2) {
            this.f17622a = i;
            this.f17623b = new C5218a[]{c5218a, c5218a2};
        }

        /* renamed from: a */
        int m22078a() {
            return this.f17622a;
        }

        /* renamed from: b */
        C5218a[] m22079b() {
            return this.f17623b;
        }
    }

    private C5220e(int i, int i2, int i3, int i4, int i5, C5219b c5219b) {
        this.f17625b = i;
        this.f17626c = i2;
        this.f17627d = i3;
        this.f17628e = i4;
        this.f17629f = i5;
        this.f17630g = c5219b;
        i = c5219b.m22078a();
        i5 = 0;
        for (C5219b c5219b2 : c5219b2.m22079b()) {
            i5 += c5219b2.m22076a() * (c5219b2.m22077b() + i);
        }
        this.f17631h = i5;
    }

    /* renamed from: a */
    public int m22082a() {
        return this.f17625b;
    }

    /* renamed from: b */
    public int m22083b() {
        return this.f17626c;
    }

    /* renamed from: c */
    public int m22084c() {
        return this.f17627d;
    }

    /* renamed from: d */
    public int m22085d() {
        return this.f17628e;
    }

    /* renamed from: e */
    public int m22086e() {
        return this.f17629f;
    }

    /* renamed from: f */
    public int m22087f() {
        return this.f17631h;
    }

    /* renamed from: g */
    C5219b m22088g() {
        return this.f17630g;
    }

    /* renamed from: a */
    public static C5220e m22080a(int i, int i2) {
        if ((i & 1) == 0 && (i2 & 1) == 0) {
            for (C5220e c5220e : f17624a) {
                if (c5220e.f17626c == i && c5220e.f17627d == i2) {
                    return c5220e;
                }
            }
            throw C6891h.m32342a();
        }
        throw C6891h.m32342a();
    }

    public String toString() {
        return String.valueOf(this.f17625b);
    }

    /* renamed from: h */
    private static C5220e[] m22081h() {
        r0 = new C5220e[30];
        r0[5] = new C5220e(6, 20, 20, 18, 18, new C5219b(18, new C5218a(1, 22)));
        r0[6] = new C5220e(7, 22, 22, 20, 20, new C5219b(20, new C5218a(1, 30)));
        r0[7] = new C5220e(8, 24, 24, 22, 22, new C5219b(24, new C5218a(1, 36)));
        r0[8] = new C5220e(9, 26, 26, 24, 24, new C5219b(28, new C5218a(1, 44)));
        r0[9] = new C5220e(10, 32, 32, 14, 14, new C5219b(36, new C5218a(1, 62)));
        r0[10] = new C5220e(11, 36, 36, 16, 16, new C5219b(42, new C5218a(1, 86)));
        r0[11] = new C5220e(12, 40, 40, 18, 18, new C5219b(48, new C5218a(1, 114)));
        r0[12] = new C5220e(13, 44, 44, 20, 20, new C5219b(56, new C5218a(1, 144)));
        r0[13] = new C5220e(14, 48, 48, 22, 22, new C5219b(68, new C5218a(1, 174)));
        r0[14] = new C5220e(15, 52, 52, 24, 24, new C5219b(42, new C5218a(2, 102)));
        r0[15] = new C5220e(16, 64, 64, 14, 14, new C5219b(56, new C5218a(2, 140)));
        r0[16] = new C5220e(17, 72, 72, 16, 16, new C5219b(36, new C5218a(4, 92)));
        r0[17] = new C5220e(18, 80, 80, 18, 18, new C5219b(48, new C5218a(4, 114)));
        r0[18] = new C5220e(19, 88, 88, 20, 20, new C5219b(56, new C5218a(4, 144)));
        r0[19] = new C5220e(20, 96, 96, 22, 22, new C5219b(68, new C5218a(4, 174)));
        r0[20] = new C5220e(21, 104, 104, 24, 24, new C5219b(56, new C5218a(6, 136)));
        r0[21] = new C5220e(22, 120, 120, 18, 18, new C5219b(68, new C5218a(6, 175)));
        r0[22] = new C5220e(23, 132, 132, 20, 20, new C5219b(62, new C5218a(8, 163)));
        r0[23] = new C5220e(24, 144, 144, 22, 22, new C5219b(62, new C5218a(8, 156), new C5218a(2, 155)));
        r0[24] = new C5220e(25, 8, 18, 6, 16, new C5219b(7, new C5218a(1, 5)));
        r0[25] = new C5220e(26, 8, 32, 6, 14, new C5219b(11, new C5218a(1, 10)));
        r0[26] = new C5220e(27, 12, 26, 10, 24, new C5219b(14, new C5218a(1, 16)));
        r0[27] = new C5220e(28, 12, 36, 10, 16, new C5219b(18, new C5218a(1, 22)));
        r0[28] = new C5220e(29, 16, 36, 14, 16, new C5219b(24, new C5218a(1, 32)));
        r0[29] = new C5220e(30, 16, 48, 14, 22, new C5219b(28, new C5218a(1, 49)));
        return r0;
    }
}
