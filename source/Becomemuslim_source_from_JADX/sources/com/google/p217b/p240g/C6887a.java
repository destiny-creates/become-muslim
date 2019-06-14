package com.google.p217b.p240g;

import com.google.p217b.C5193a;
import com.google.p217b.C5232c;
import com.google.p217b.C5254e;
import com.google.p217b.C5312o;
import com.google.p217b.C5314q;
import com.google.p217b.C5315r;
import com.google.p217b.C5316s;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5202b;
import com.google.p217b.p240g.p241a.C5287e;
import com.google.p217b.p240g.p241a.C5291i;
import com.google.p217b.p240g.p242b.C5296c;
import java.util.Map;

/* compiled from: QRCodeReader */
/* renamed from: com.google.b.g.a */
public class C6887a implements C5312o {
    /* renamed from: a */
    private static final C5316s[] f24695a = new C5316s[0];
    /* renamed from: b */
    private final C5287e f24696b = new C5287e();

    /* renamed from: a */
    public final C5314q mo4858a(C5232c c5232c, Map<C5254e, ?> map) {
        if (map == null || !map.containsKey(C5254e.PURE_BARCODE)) {
            c5232c = new C5296c(c5232c.m22164c()).m22478a((Map) map);
            Map<C5254e, ?> a = this.f24696b.m22437a(c5232c.m22033d(), (Map) map);
            map = c5232c.m22034e();
            c5232c = a;
        } else {
            c5232c = this.f24696b.m22437a(C6887a.m32332a(c5232c.m22164c()), (Map) map);
            map = f24695a;
        }
        if (c5232c.m22029f() instanceof C5291i) {
            ((C5291i) c5232c.m22029f()).m22448a(map);
        }
        C5314q c5314q = new C5314q(c5232c.m22026c(), c5232c.m22023a(), map, C5193a.QR_CODE);
        map = c5232c.m22027d();
        if (map != null) {
            c5314q.m22572a(C5315r.BYTE_SEGMENTS, map);
        }
        map = c5232c.m22028e();
        if (map != null) {
            c5314q.m22572a(C5315r.ERROR_CORRECTION_LEVEL, map);
        }
        if (c5232c.m22030g() != null) {
            c5314q.m22572a(C5315r.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(c5232c.m22032i()));
            c5314q.m22572a(C5315r.STRUCTURED_APPEND_PARITY, Integer.valueOf(c5232c.m22031h()));
        }
        return c5314q;
    }

    /* renamed from: a */
    private static C5202b m32332a(C5202b c5202b) {
        int[] d = c5202b.m22008d();
        int[] e = c5202b.m22009e();
        if (d == null || e == null) {
            throw C6894l.m32349a();
        }
        float a = C6887a.m32331a(d, c5202b);
        int i = d[1];
        int i2 = e[1];
        int i3 = d[0];
        int i4 = e[0];
        if (i3 >= i4 || i >= i2) {
            throw C6894l.m32349a();
        }
        int i5 = i2 - i;
        if (i5 != i4 - i3) {
            i4 = i3 + i5;
            if (i4 >= c5202b.m22010f()) {
                throw C6894l.m32349a();
            }
        }
        int round = Math.round(((float) ((i4 - i3) + 1)) / a);
        int round2 = Math.round(((float) (i5 + 1)) / a);
        if (round <= 0 || round2 <= 0) {
            throw C6894l.m32349a();
        } else if (round2 == round) {
            i5 = (int) (a / 2.0f);
            i += i5;
            i3 += i5;
            int i6 = (((int) (((float) (round - 1)) * a)) + i3) - i4;
            if (i6 > 0) {
                if (i6 <= i5) {
                    i3 -= i6;
                } else {
                    throw C6894l.m32349a();
                }
            }
            i4 = (((int) (((float) (round2 - 1)) * a)) + i) - i2;
            if (i4 > 0) {
                if (i4 <= i5) {
                    i -= i4;
                } else {
                    throw C6894l.m32349a();
                }
            }
            C5202b c5202b2 = new C5202b(round, round2);
            for (i2 = 0; i2 < round2; i2++) {
                i5 = ((int) (((float) i2) * a)) + i;
                for (i6 = 0; i6 < round; i6++) {
                    if (c5202b.m22002a(((int) (((float) i6) * a)) + i3, i5)) {
                        c5202b2.m22004b(i6, i2);
                    }
                }
            }
            return c5202b2;
        } else {
            throw C6894l.m32349a();
        }
    }

    /* renamed from: a */
    private static float m32331a(int[] iArr, C5202b c5202b) {
        int g = c5202b.m22011g();
        int f = c5202b.m22010f();
        int i = iArr[0];
        int i2 = 1;
        int i3 = iArr[1];
        int i4 = 0;
        while (i < f && i3 < g) {
            if (i2 != c5202b.m22002a(i, i3)) {
                i4++;
                if (i4 == 5) {
                    break;
                }
                i2 ^= 1;
            }
            i++;
            i3++;
        }
        if (i != f && i3 != g) {
            return ((float) (i - iArr[0])) / 1088421888;
        }
        throw C6894l.m32349a();
    }
}
