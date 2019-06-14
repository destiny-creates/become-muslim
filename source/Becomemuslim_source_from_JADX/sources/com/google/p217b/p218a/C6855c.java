package com.google.p217b.p218a;

import com.google.p217b.C5193a;
import com.google.p217b.C5309g;
import com.google.p217b.C5318u;
import com.google.p217b.p218a.p221c.C5187a;
import com.google.p217b.p218a.p221c.C5188c;
import com.google.p217b.p222b.C5202b;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* compiled from: AztecWriter */
/* renamed from: com.google.b.a.c */
public final class C6855c implements C5318u {
    /* renamed from: a */
    public C5202b mo4860a(String str, C5193a c5193a, int i, int i2, Map<C5309g, ?> map) {
        Charset charset;
        int i3;
        int parseInt;
        Charset charset2 = StandardCharsets.ISO_8859_1;
        int i4 = 33;
        if (map != null) {
            if (map.containsKey(C5309g.CHARACTER_SET)) {
                charset2 = Charset.forName(map.get(C5309g.CHARACTER_SET).toString());
            }
            if (map.containsKey(C5309g.ERROR_CORRECTION)) {
                i4 = Integer.parseInt(map.get(C5309g.ERROR_CORRECTION).toString());
            }
            if (map.containsKey(C5309g.AZTEC_LAYERS)) {
                charset = charset2;
                i3 = i4;
                parseInt = Integer.parseInt(map.get(C5309g.AZTEC_LAYERS).toString());
                return C6855c.m32240a(str, c5193a, i, i2, charset, i3, parseInt);
            }
            charset = charset2;
            i3 = i4;
        } else {
            charset = charset2;
            i3 = 33;
        }
        parseInt = 0;
        return C6855c.m32240a(str, c5193a, i, i2, charset, i3, parseInt);
    }

    /* renamed from: a */
    private static C5202b m32240a(String str, C5193a c5193a, int i, int i2, Charset charset, int i3, int i4) {
        if (c5193a == C5193a.AZTEC) {
            return C6855c.m32239a(C5188c.m21916a(str.getBytes(charset), i3, i4), i, i2);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(c5193a)));
    }

    /* renamed from: a */
    private static C5202b m32239a(C5187a c5187a, int i, int i2) {
        c5187a = c5187a.m21909a();
        if (c5187a != null) {
            int f = c5187a.m22010f();
            int g = c5187a.m22011g();
            i = Math.max(i, f);
            i2 = Math.max(i2, g);
            int min = Math.min(i / f, i2 / g);
            int i3 = (i - (f * min)) / 2;
            int i4 = (i2 - (g * min)) / 2;
            C5202b c5202b = new C5202b(i, i2);
            i2 = 0;
            while (i2 < g) {
                int i5 = i3;
                int i6 = 0;
                while (i6 < f) {
                    if (c5187a.m22002a(i6, i2)) {
                        c5202b.m22001a(i5, i4, min, min);
                    }
                    i6++;
                    i5 += min;
                }
                i2++;
                i4 += min;
            }
            return c5202b;
        }
        throw new IllegalStateException();
    }
}
