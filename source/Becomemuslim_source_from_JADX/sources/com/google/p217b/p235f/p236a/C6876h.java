package com.google.p217b.p235f.p236a;

import com.google.p217b.C5316s;

/* compiled from: DetectionResultRowIndicatorColumn */
/* renamed from: com.google.b.f.a.h */
final class C6876h extends C5266g {
    /* renamed from: a */
    private final boolean f24694a;

    C6876h(C5260c c5260c, boolean z) {
        super(c5260c);
        this.f24694a = z;
    }

    /* renamed from: f */
    private void m32308f() {
        for (C5261d c5261d : m22323b()) {
            if (c5261d != null) {
                c5261d.m22287b();
            }
        }
    }

    /* renamed from: a */
    void m32309a(C5258a c5258a) {
        C5261d[] b = m22323b();
        m32308f();
        m32306a(b, c5258a);
        C5260c a = m22319a();
        C5316s e = this.f24694a ? a.m22281e() : a.m22282f();
        C5316s g = this.f24694a ? a.m22283g() : a.m22284h();
        int b2 = m22322b((int) e.m22583b());
        int b3 = m22322b((int) g.m22583b());
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        while (b2 < b3) {
            if (b[b2] != null) {
                C5261d c5261d = b[b2];
                int h = c5261d.m22294h() - i;
                if (h == 0) {
                    i2++;
                } else {
                    if (h == 1) {
                        i3 = Math.max(i3, i2);
                        i = c5261d.m22294h();
                    } else {
                        if (h >= 0 && c5261d.m22294h() < c5258a.m22270c()) {
                            if (h <= b2) {
                                if (i3 > 2) {
                                    h *= i3 - 2;
                                }
                                Object obj = h >= b2 ? 1 : null;
                                for (int i4 = 1; i4 <= h && obj == null; i4++) {
                                    obj = b[b2 - i4] != null ? 1 : null;
                                }
                                if (obj != null) {
                                    b[b2] = null;
                                } else {
                                    i = c5261d.m22294h();
                                }
                            }
                        }
                        b[b2] = null;
                    }
                    i2 = 1;
                }
            }
            b2++;
        }
    }

    /* renamed from: c */
    int[] m32310c() {
        C5258a d = m32311d();
        if (d == null) {
            return null;
        }
        m32307b(d);
        int[] iArr = new int[d.m22270c()];
        for (C5261d c5261d : m22323b()) {
            if (c5261d != null) {
                int h = c5261d.m22294h();
                if (h < iArr.length) {
                    iArr[h] = iArr[h] + 1;
                }
            }
        }
        return iArr;
    }

    /* renamed from: b */
    private void m32307b(C5258a c5258a) {
        C5260c a = m22319a();
        C5316s e = this.f24694a ? a.m22281e() : a.m22282f();
        C5316s g = this.f24694a ? a.m22283g() : a.m22284h();
        int b = m22322b((int) g.m22583b());
        C5261d[] b2 = m22323b();
        int i = -1;
        int i2 = 0;
        int i3 = 1;
        for (int b3 = m22322b((int) e.m22583b()); b3 < b; b3++) {
            if (b2[b3] != null) {
                C5261d c5261d = b2[b3];
                c5261d.m22287b();
                int h = c5261d.m22294h() - i;
                if (h == 0) {
                    i2++;
                } else {
                    if (h == 1) {
                        i3 = Math.max(i3, i2);
                        i = c5261d.m22294h();
                    } else if (c5261d.m22294h() >= c5258a.m22270c()) {
                        b2[b3] = null;
                    } else {
                        i = c5261d.m22294h();
                    }
                    i2 = 1;
                }
            }
        }
    }

    /* renamed from: d */
    C5258a m32311d() {
        C5261d[] b = m22323b();
        C5259b c5259b = new C5259b();
        C5259b c5259b2 = new C5259b();
        C5259b c5259b3 = new C5259b();
        C5259b c5259b4 = new C5259b();
        for (C5261d c5261d : b) {
            if (c5261d != null) {
                c5261d.m22287b();
                int g = c5261d.m22293g() % 30;
                int h = c5261d.m22294h();
                if (!this.f24694a) {
                    h += 2;
                }
                switch (h % 3) {
                    case 0:
                        c5259b2.m22273a((g * 3) + 1);
                        break;
                    case 1:
                        c5259b4.m22273a(g / 3);
                        c5259b3.m22273a(g % 3);
                        break;
                    case 2:
                        c5259b.m22273a(g + 1);
                        break;
                    default:
                        break;
                }
            }
        }
        if (!(c5259b.m22274a().length == 0 || c5259b2.m22274a().length == 0 || c5259b3.m22274a().length == 0 || c5259b4.m22274a().length == 0 || c5259b.m22274a()[0] <= 0 || c5259b2.m22274a()[0] + c5259b3.m22274a()[0] < 3)) {
            if (c5259b2.m22274a()[0] + c5259b3.m22274a()[0] <= 90) {
                C5258a c5258a = new C5258a(c5259b.m22274a()[0], c5259b2.m22274a()[0], c5259b3.m22274a()[0], c5259b4.m22274a()[0]);
                m32306a(b, c5258a);
                return c5258a;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m32306a(C5261d[] c5261dArr, C5258a c5258a) {
        for (int i = 0; i < c5261dArr.length; i++) {
            C5261d c5261d = c5261dArr[i];
            if (c5261dArr[i] != null) {
                int g = c5261d.m22293g() % 30;
                int h = c5261d.m22294h();
                if (h <= c5258a.m22270c()) {
                    if (!this.f24694a) {
                        h += 2;
                    }
                    switch (h % 3) {
                        case 0:
                            if ((g * 3) + 1 == c5258a.m22271d()) {
                                break;
                            }
                            c5261dArr[i] = null;
                            break;
                        case 1:
                            if (g / 3 != c5258a.m22269b() || g % 3 != c5258a.m22272e()) {
                                c5261dArr[i] = null;
                                break;
                            }
                            break;
                        case 2:
                            if (g + 1 == c5258a.m22268a()) {
                                break;
                            }
                            c5261dArr[i] = null;
                            break;
                        default:
                            break;
                    }
                }
                c5261dArr[i] = null;
            }
        }
    }

    /* renamed from: e */
    boolean m32312e() {
        return this.f24694a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IsLeft: ");
        stringBuilder.append(this.f24694a);
        stringBuilder.append('\n');
        stringBuilder.append(super.toString());
        return stringBuilder.toString();
    }
}
