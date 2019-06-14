package com.google.p217b.p240g;

import com.google.p217b.C5193a;
import com.google.p217b.C5309g;
import com.google.p217b.C5318u;
import com.google.p217b.p222b.C5202b;
import com.google.p217b.p240g.p241a.C5288f;
import com.google.p217b.p240g.p243c.C5305c;
import com.google.p217b.p240g.p243c.C5308f;
import java.util.Map;

/* compiled from: QRCodeWriter */
/* renamed from: com.google.b.g.b */
public final class C6890b implements C5318u {
    /* renamed from: a */
    public C5202b mo4860a(String str, C5193a c5193a, int i, int i2, Map<C5309g, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (c5193a != C5193a.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(c5193a)));
        } else if (i < 0 || i2 < 0) {
            c5193a = new StringBuilder("Requested dimensions are too small: ");
            c5193a.append(i);
            c5193a.append(120);
            c5193a.append(i2);
            throw new IllegalArgumentException(c5193a.toString());
        } else {
            C5288f c5288f = C5288f.L;
            int i3 = 4;
            if (map != null) {
                if (map.containsKey(C5309g.ERROR_CORRECTION)) {
                    c5288f = C5288f.valueOf(map.get(C5309g.ERROR_CORRECTION).toString());
                }
                if (map.containsKey(C5309g.MARGIN)) {
                    i3 = Integer.parseInt(map.get(C5309g.MARGIN).toString());
                }
            }
            return C6890b.m32340a(C5305c.m22516a(str, c5288f, (Map) map), i, i2, i3);
        }
    }

    /* renamed from: a */
    private static C5202b m32340a(C5308f c5308f, int i, int i2, int i3) {
        c5308f = c5308f.m22558a();
        if (c5308f != null) {
            int b = c5308f.m22506b();
            int a = c5308f.m22502a();
            i3 <<= 1;
            int i4 = b + i3;
            i3 += a;
            i = Math.max(i, i4);
            i2 = Math.max(i2, i3);
            i3 = Math.min(i / i4, i2 / i3);
            i4 = (i - (b * i3)) / 2;
            int i5 = (i2 - (a * i3)) / 2;
            C5202b c5202b = new C5202b(i, i2);
            i2 = 0;
            while (i2 < a) {
                int i6 = i4;
                int i7 = 0;
                while (i7 < b) {
                    if (c5308f.m22501a(i7, i2) == (byte) 1) {
                        c5202b.m22001a(i6, i5, i3, i3);
                    }
                    i7++;
                    i6 += i3;
                }
                i2++;
                i5 += i3;
            }
            return c5202b;
        }
        throw new IllegalStateException();
    }
}
