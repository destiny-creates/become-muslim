package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.C5309g;
import com.google.p217b.p222b.C5202b;
import java.util.Map;

/* compiled from: Code93Writer */
/* renamed from: com.google.b.e.h */
public class C7908h extends C6874s {
    /* renamed from: a */
    public C5202b mo4860a(String str, C5193a c5193a, int i, int i2, Map<C5309g, ?> map) {
        if (c5193a == C5193a.CODE_93) {
            return super.mo4860a(str, c5193a, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(c5193a)));
    }

    /* renamed from: a */
    public boolean[] mo6261a(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            int length2 = (((str.length() + 2) + 2) * 9) + 1;
            C7908h.m38482a(C7907g.f29506a[47], iArr);
            boolean[] zArr = new boolean[length2];
            int i = 0;
            int a = C7908h.m38481a(zArr, 0, iArr);
            while (i < length) {
                C7908h.m38482a(C7907g.f29506a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i))], iArr);
                a += C7908h.m38481a(zArr, a, iArr);
                i++;
            }
            length = C7908h.m38480a(str, 20);
            C7908h.m38482a(C7907g.f29506a[length], iArr);
            a += C7908h.m38481a(zArr, a, iArr);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(length));
            C7908h.m38482a(C7907g.f29506a[C7908h.m38480a(stringBuilder.toString(), 15)], iArr);
            a += C7908h.m38481a(zArr, a, iArr);
            C7908h.m38482a(C7907g.f29506a[47], iArr);
            zArr[a + C7908h.m38481a(zArr, a, iArr)] = true;
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }

    /* renamed from: a */
    private static void m38482a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            }
            iArr[i2] = i3;
        }
    }

    /* renamed from: a */
    private static int m38481a(boolean[] zArr, int i, int[] iArr) {
        int length = iArr.length;
        int i2 = i;
        i = 0;
        while (i < length) {
            int i3 = i2 + 1;
            zArr[i2] = iArr[i] != 0;
            i++;
            i2 = i3;
        }
        return 9;
    }

    /* renamed from: a */
    private static int m38480a(String str, int i) {
        int i2 = 0;
        int i3 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i3;
            i3++;
            if (i3 > i) {
                i3 = 1;
            }
        }
        return i2 % 47;
    }
}
