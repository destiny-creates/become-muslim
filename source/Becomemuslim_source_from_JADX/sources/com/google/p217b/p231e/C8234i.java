package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5196a;

/* compiled from: EAN13Reader */
/* renamed from: com.google.b.e.i */
public final class C8234i extends C7913y {
    /* renamed from: a */
    static final int[] f32403a = new int[]{0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    /* renamed from: g */
    private final int[] f32404g = new int[4];

    /* renamed from: a */
    protected int mo6750a(C5196a c5196a, int[] iArr, StringBuilder stringBuilder) {
        int[] iArr2 = this.f32404g;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = c5196a.m21954a();
        int i = iArr[1];
        iArr = null;
        int i2 = 0;
        while (iArr < 6 && i < a) {
            int a2 = C7913y.m38497a(c5196a, iArr2, i, f);
            stringBuilder.append((char) ((a2 % 10) + 48));
            int i3 = i;
            for (int i4 : iArr2) {
                i3 += i4;
            }
            if (a2 >= 10) {
                i2 = (1 << (5 - iArr)) | i2;
            }
            iArr++;
            i = i3;
        }
        C8234i.m42783a(stringBuilder, i2);
        int i5 = C7913y.m38500a(c5196a, i, true, c)[1];
        iArr = null;
        while (iArr < 6 && i5 < a) {
            stringBuilder.append((char) (C7913y.m38497a(c5196a, iArr2, i5, e) + 48));
            i2 = i5;
            for (int i6 : iArr2) {
                i2 += i6;
            }
            iArr++;
            i5 = i2;
        }
        return i5;
    }

    /* renamed from: a */
    C5193a mo6751a() {
        return C5193a.EAN_13;
    }

    /* renamed from: a */
    private static void m42783a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f32403a[i2]) {
                stringBuilder.insert(0, (char) (i2 + 48));
                return;
            }
        }
        throw C6894l.m32349a();
    }
}
