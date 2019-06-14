package com.google.p217b.p225c;

import com.google.p217b.C5193a;
import com.google.p217b.C5281f;
import com.google.p217b.C5309g;
import com.google.p217b.C5318u;
import com.google.p217b.p222b.C5202b;
import com.google.p217b.p225c.p228c.C5225e;
import com.google.p217b.p225c.p228c.C5228i;
import com.google.p217b.p225c.p228c.C5229j;
import com.google.p217b.p225c.p228c.C5230k;
import com.google.p217b.p225c.p228c.C5231l;
import com.google.p217b.p240g.p243c.C5303b;
import java.util.Map;

/* compiled from: DataMatrixWriter */
/* renamed from: com.google.b.c.b */
public final class C6859b implements C5318u {
    /* renamed from: a */
    public C5202b mo4860a(String str, C5193a c5193a, int i, int i2, Map<C5309g, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (c5193a != C5193a.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(c5193a)));
        } else if (i < 0 || i2 < 0) {
            c5193a = new StringBuilder("Requested dimensions can't be negative: ");
            c5193a.append(i);
            c5193a.append(120);
            c5193a.append(i2);
            throw new IllegalArgumentException(c5193a.toString());
        } else {
            C5281f c5281f;
            C5231l c5231l = C5231l.FORCE_NONE;
            C5281f c5281f2 = null;
            if (map != null) {
                C5231l c5231l2 = (C5231l) map.get(C5309g.DATA_MATRIX_SHAPE);
                if (c5231l2 != null) {
                    c5231l = c5231l2;
                }
                c5281f = (C5281f) map.get(C5309g.MIN_SIZE);
                if (c5281f == null) {
                    c5281f = null;
                }
                C5281f c5281f3 = (C5281f) map.get(C5309g.MAX_SIZE);
                if (c5281f3 != null) {
                    c5281f2 = c5281f3;
                }
            } else {
                c5281f = null;
            }
            str = C5229j.m22139a(str, c5231l, c5281f, c5281f2);
            C5230k a = C5230k.m22149a(str.length(), c5231l, c5281f, c5281f2, true);
            map = new C5225e(C5228i.m22133a(str, a), a.m22154b(), a.m22156c());
            map.m22109a();
            return C6859b.m32252a(map, a, i, i2);
        }
    }

    /* renamed from: a */
    private static C5202b m32252a(C5225e c5225e, C5230k c5230k, int i, int i2) {
        int b = c5230k.m22154b();
        int c = c5230k.m22156c();
        C5303b c5303b = new C5303b(c5230k.m22157d(), c5230k.m22158e());
        int i3 = 0;
        for (int i4 = 0; i4 < c; i4++) {
            int i5;
            int i6;
            if (i4 % c5230k.f17657c == 0) {
                i5 = 0;
                for (i6 = 0; i6 < c5230k.m22157d(); i6++) {
                    c5303b.m22505a(i5, i3, i6 % 2 == 0);
                    i5++;
                }
                i3++;
            }
            i5 = 0;
            for (i6 = 0; i6 < b; i6++) {
                if (i6 % c5230k.f17656b == 0) {
                    c5303b.m22505a(i5, i3, true);
                    i5++;
                }
                c5303b.m22505a(i5, i3, c5225e.m22110a(i6, i4));
                i5++;
                if (i6 % c5230k.f17656b == c5230k.f17656b - 1) {
                    c5303b.m22505a(i5, i3, i4 % 2 == 0);
                    i5++;
                }
            }
            i3++;
            if (i4 % c5230k.f17657c == c5230k.f17657c - 1) {
                i5 = 0;
                for (i6 = 0; i6 < c5230k.m22157d(); i6++) {
                    c5303b.m22505a(i5, i3, true);
                    i5++;
                }
                i3++;
            }
        }
        return C6859b.m32253a(c5303b, i, i2);
    }

    /* renamed from: a */
    private static C5202b m32253a(C5303b c5303b, int i, int i2) {
        C5202b c5202b;
        int i3;
        int b = c5303b.m22506b();
        int a = c5303b.m22502a();
        int max = Math.max(i, b);
        int max2 = Math.max(i2, a);
        int min = Math.min(max / b, max2 / a);
        max = (max - (b * min)) / 2;
        max2 = (max2 - (a * min)) / 2;
        if (i2 >= a) {
            if (i >= b) {
                c5202b = new C5202b(i, i2);
                c5202b.m22000a();
                i = 0;
                while (i < a) {
                    i3 = max;
                    i2 = 0;
                    while (i2 < b) {
                        if (c5303b.m22501a(i2, i) == (byte) 1) {
                            c5202b.m22001a(i3, max2, min, min);
                        }
                        i2++;
                        i3 += min;
                    }
                    i++;
                    max2 += min;
                }
                return c5202b;
            }
        }
        c5202b = new C5202b(b, a);
        max = 0;
        max2 = 0;
        c5202b.m22000a();
        i = 0;
        while (i < a) {
            i3 = max;
            i2 = 0;
            while (i2 < b) {
                if (c5303b.m22501a(i2, i) == (byte) 1) {
                    c5202b.m22001a(i3, max2, min, min);
                }
                i2++;
                i3 += min;
            }
            i++;
            max2 += min;
        }
        return c5202b;
    }
}
