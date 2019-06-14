package com.google.p217b.p225c;

import com.google.p217b.C5193a;
import com.google.p217b.C5232c;
import com.google.p217b.C5254e;
import com.google.p217b.C5312o;
import com.google.p217b.C5314q;
import com.google.p217b.C5315r;
import com.google.p217b.C5316s;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5202b;
import com.google.p217b.p225c.p226a.C5216d;
import com.google.p217b.p225c.p227b.C5224a;
import java.util.Map;

/* compiled from: DataMatrixReader */
/* renamed from: com.google.b.c.a */
public final class C6858a implements C5312o {
    /* renamed from: a */
    private static final C5316s[] f24680a = new C5316s[0];
    /* renamed from: b */
    private final C5216d f24681b = new C5216d();

    /* renamed from: a */
    public C5314q mo4858a(C5232c c5232c, Map<C5254e, ?> map) {
        if (map == null || map.containsKey(C5254e.PURE_BARCODE) == null) {
            c5232c = new C5224a(c5232c.m22164c()).m22100a();
            Map<C5254e, ?> a = this.f24681b.m22075a(c5232c.m22033d());
            map = c5232c.m22034e();
            c5232c = a;
        } else {
            c5232c = this.f24681b.m22075a(C6858a.m32250a(c5232c.m22164c()));
            map = f24680a;
        }
        C5314q c5314q = new C5314q(c5232c.m22026c(), c5232c.m22023a(), map, C5193a.DATA_MATRIX);
        map = c5232c.m22027d();
        if (map != null) {
            c5314q.m22572a(C5315r.BYTE_SEGMENTS, map);
        }
        c5232c = c5232c.m22028e();
        if (c5232c != null) {
            c5314q.m22572a(C5315r.ERROR_CORRECTION_LEVEL, c5232c);
        }
        return c5314q;
    }

    /* renamed from: a */
    private static C5202b m32250a(C5202b c5202b) {
        int[] d = c5202b.m22008d();
        int[] e = c5202b.m22009e();
        if (d == null || e == null) {
            throw C6894l.m32349a();
        }
        int a = C6858a.m32249a(d, c5202b);
        int i = d[1];
        int i2 = e[1];
        int i3 = d[0];
        int i4 = ((e[0] - i3) + 1) / a;
        i2 = ((i2 - i) + 1) / a;
        if (i4 <= 0 || i2 <= 0) {
            throw C6894l.m32349a();
        }
        int i5 = a / 2;
        i += i5;
        i3 += i5;
        C5202b c5202b2 = new C5202b(i4, i2);
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i6 * a) + i;
            for (int i8 = 0; i8 < i4; i8++) {
                if (c5202b.m22002a((i8 * a) + i3, i7)) {
                    c5202b2.m22004b(i8, i6);
                }
            }
        }
        return c5202b2;
    }

    /* renamed from: a */
    private static int m32249a(int[] iArr, C5202b c5202b) {
        int f = c5202b.m22010f();
        int i = iArr[0];
        int i2 = iArr[1];
        while (i < f && c5202b.m22002a(i, i2)) {
            i++;
        }
        if (i != f) {
            i -= iArr[0];
            if (i != 0) {
                return i;
            }
            throw C6894l.m32349a();
        }
        throw C6894l.m32349a();
    }
}
