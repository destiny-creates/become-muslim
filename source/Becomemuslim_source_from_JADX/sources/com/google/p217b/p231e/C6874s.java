package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.C5309g;
import com.google.p217b.C5318u;
import com.google.p217b.p222b.C5202b;
import java.util.Map;

/* compiled from: OneDimensionalCodeWriter */
/* renamed from: com.google.b.e.s */
public abstract class C6874s implements C5318u {
    /* renamed from: a */
    public int mo6262a() {
        return 10;
    }

    /* renamed from: a */
    public abstract boolean[] mo6261a(String str);

    /* renamed from: a */
    public C5202b mo4860a(String str, C5193a c5193a, int i, int i2, Map<C5309g, ?> map) {
        if (str.isEmpty() != null) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i < 0 || i2 < 0) {
            c5193a = new StringBuilder("Negative size is not allowed. Input: ");
            c5193a.append(i);
            c5193a.append(120);
            c5193a.append(i2);
            throw new IllegalArgumentException(c5193a.toString());
        } else {
            int a = mo6262a();
            if (map != null && map.containsKey(C5309g.MARGIN)) {
                a = Integer.parseInt(map.get(C5309g.MARGIN).toString());
            }
            return C6874s.m32301a(mo6261a(str), i, i2, a);
        }
    }

    /* renamed from: a */
    private static C5202b m32301a(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        i3 += length;
        i = Math.max(i, i3);
        i2 = Math.max(1, i2);
        i3 = i / i3;
        int i4 = (i - (length * i3)) / 2;
        C5202b c5202b = new C5202b(i, i2);
        int i5 = i4;
        i4 = 0;
        while (i4 < length) {
            if (zArr[i4]) {
                c5202b.m22001a(i5, 0, i3, i2);
            }
            i4++;
            i5 += i3;
        }
        return c5202b;
    }

    /* renamed from: a */
    protected static int m32300a(boolean[] zArr, int i, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = i;
        boolean z2 = z;
        i = 0;
        z = false;
        while (i < length) {
            int i3 = iArr[i];
            int i4 = i2;
            i2 = 0;
            while (i2 < i3) {
                int i5 = i4 + 1;
                zArr[i4] = z2;
                i2++;
                i4 = i5;
            }
            z += i3;
            z2 = !z2;
            i++;
            i2 = i4;
        }
        return z;
    }
}
