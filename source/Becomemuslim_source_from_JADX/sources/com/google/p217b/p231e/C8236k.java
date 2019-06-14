package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.p222b.C5196a;

/* compiled from: EAN8Reader */
/* renamed from: com.google.b.e.k */
public final class C8236k extends C7913y {
    /* renamed from: a */
    private final int[] f32405a = new int[4];

    /* renamed from: a */
    protected int mo6750a(C5196a c5196a, int[] iArr, StringBuilder stringBuilder) {
        int[] iArr2 = this.f32405a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = c5196a.m21954a();
        int i = iArr[1];
        iArr = null;
        while (iArr < 4 && i < a) {
            stringBuilder.append((char) (C7913y.m38497a(c5196a, iArr2, i, e) + 48));
            int i2 = i;
            for (int i3 : iArr2) {
                i2 += i3;
            }
            iArr++;
            i = i2;
        }
        int i4 = C7913y.m38500a(c5196a, i, true, c)[1];
        iArr = null;
        while (iArr < 4 && i4 < a) {
            stringBuilder.append((char) (C7913y.m38497a(c5196a, iArr2, i4, e) + 48));
            i2 = i4;
            for (int i32 : iArr2) {
                i2 += i32;
            }
            iArr++;
            i4 = i2;
        }
        return i4;
    }

    /* renamed from: a */
    C5193a mo6751a() {
        return C5193a.EAN_8;
    }
}
