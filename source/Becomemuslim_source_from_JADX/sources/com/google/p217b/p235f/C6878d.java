package com.google.p217b.p235f;

import com.google.p217b.C5193a;
import com.google.p217b.C5309g;
import com.google.p217b.C5318u;
import com.google.p217b.p222b.C5202b;
import com.google.p217b.p235f.p239c.C5274c;
import com.google.p217b.p235f.p239c.C5275d;
import com.google.p217b.p235f.p239c.C5276e;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* compiled from: PDF417Writer */
/* renamed from: com.google.b.f.d */
public final class C6878d implements C5318u {
    /* renamed from: a */
    public C5202b mo4860a(String str, C5193a c5193a, int i, int i2, Map<C5309g, ?> map) {
        if (c5193a == C5193a.PDF_417) {
            int i3;
            int i4;
            C5276e c5276e = new C5276e();
            c5193a = 30;
            int i5 = 2;
            if (map != null) {
                if (map.containsKey(C5309g.PDF417_COMPACT)) {
                    c5276e.m22384a(Boolean.valueOf(map.get(C5309g.PDF417_COMPACT).toString()).booleanValue());
                }
                if (map.containsKey(C5309g.PDF417_COMPACTION)) {
                    c5276e.m22381a(C5274c.valueOf(map.get(C5309g.PDF417_COMPACTION).toString()));
                }
                if (map.containsKey(C5309g.PDF417_DIMENSIONS)) {
                    C5275d c5275d = (C5275d) map.get(C5309g.PDF417_DIMENSIONS);
                    c5276e.m22380a(c5275d.m22371b(), c5275d.m22370a(), c5275d.m22373d(), c5275d.m22372c());
                }
                if (map.containsKey(C5309g.MARGIN)) {
                    c5193a = Integer.parseInt(map.get(C5309g.MARGIN).toString());
                }
                if (map.containsKey(C5309g.ERROR_CORRECTION)) {
                    i5 = Integer.parseInt(map.get(C5309g.ERROR_CORRECTION).toString());
                }
                if (map.containsKey(C5309g.CHARACTER_SET)) {
                    c5276e.m22383a(Charset.forName(map.get(C5309g.CHARACTER_SET).toString()));
                }
                i3 = c5193a;
                i4 = i5;
            } else {
                i4 = 2;
                i3 = 30;
            }
            return C6878d.m32319a(c5276e, str, i4, i, i2, i3);
        }
        throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(c5193a)));
    }

    /* renamed from: a */
    private static C5202b m32319a(C5276e c5276e, String str, int i, int i2, int i3, int i4) {
        Object obj;
        c5276e.m22382a(str, i);
        str = c5276e.m22379a().m22365a(1, 4);
        if ((i3 > i2 ? 1 : null) != (str[0].length < str.length ? 1 : null)) {
            str = C6878d.m32321a(str);
            obj = 1;
        } else {
            obj = null;
        }
        i2 /= str[0].length;
        i3 /= str.length;
        if (i2 >= i3) {
            i2 = i3;
        }
        if (i2 <= 1) {
            return C6878d.m32320a(str, i4);
        }
        c5276e = c5276e.m22379a().m22365a(i2, i2 << 2);
        if (obj != null) {
            c5276e = C6878d.m32321a(c5276e);
        }
        return C6878d.m32320a(c5276e, i4);
    }

    /* renamed from: a */
    private static C5202b m32320a(byte[][] bArr, int i) {
        int i2 = i * 2;
        C5202b c5202b = new C5202b(bArr[0].length + i2, bArr.length + i2);
        c5202b.m22000a();
        int g = (c5202b.m22011g() - i) - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            byte[] bArr2 = bArr[i3];
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                if (bArr2[i4] == (byte) 1) {
                    c5202b.m22004b(i4 + i, g);
                }
            }
            i3++;
            g--;
        }
        return c5202b;
    }

    /* renamed from: a */
    private static byte[][] m32321a(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance(byte.class, new int[]{bArr[0].length, bArr.length});
        for (int i = 0; i < bArr.length; i++) {
            int length = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length] = bArr[i][i2];
            }
        }
        return bArr2;
    }
}
