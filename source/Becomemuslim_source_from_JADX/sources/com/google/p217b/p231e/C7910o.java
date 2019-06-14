package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.C5309g;
import com.google.p217b.p222b.C5202b;
import java.util.Map;

/* compiled from: ITFWriter */
/* renamed from: com.google.b.e.o */
public final class C7910o extends C6874s {
    /* renamed from: a */
    private static final int[] f29516a = new int[]{1, 1, 1, 1};
    /* renamed from: b */
    private static final int[] f29517b = new int[]{3, 1, 1};
    /* renamed from: c */
    private static final int[][] f29518c = new int[][]{new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: a */
    public C5202b mo4860a(String str, C5193a c5193a, int i, int i2, Map<C5309g, ?> map) {
        if (c5193a == C5193a.ITF) {
            return super.mo4860a(str, c5193a, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(c5193a)));
    }

    /* renamed from: a */
    public boolean[] mo6261a(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        } else if (length <= 80) {
            boolean[] zArr = new boolean[((length * 9) + 9)];
            int a = C6874s.m32300a(zArr, 0, f29516a, true);
            for (int i = 0; i < length; i += 2) {
                int digit = Character.digit(str.charAt(i), 10);
                int digit2 = Character.digit(str.charAt(i + 1), 10);
                int[] iArr = new int[10];
                for (int i2 = 0; i2 < 5; i2++) {
                    int i3 = i2 * 2;
                    iArr[i3] = f29518c[digit][i2];
                    iArr[i3 + 1] = f29518c[digit2][i2];
                }
                a += C6874s.m32300a(zArr, a, iArr, true);
            }
            C6874s.m32300a(zArr, a, (int[]) f29517b, true);
            return zArr;
        } else {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
    }
}
