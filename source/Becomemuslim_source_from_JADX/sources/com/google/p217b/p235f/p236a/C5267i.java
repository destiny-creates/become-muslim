package com.google.p217b.p235f.p236a;

import com.google.p217b.p222b.p223a.C5194a;
import com.google.p217b.p235f.C5269a;
import java.lang.reflect.Array;

/* compiled from: PDF417CodewordDecoder */
/* renamed from: com.google.b.f.a.i */
final class C5267i {
    /* renamed from: a */
    private static final float[][] f17779a = ((float[][]) Array.newInstance(float.class, new int[]{C5269a.f17781a.length, 8}));

    static {
        for (int i = 0; i < C5269a.f17781a.length; i++) {
            int i2 = C5269a.f17781a[i];
            int i3 = i2 & 1;
            int i4 = i2;
            i2 = 0;
            while (i2 < 8) {
                int i5;
                float f = 0.0f;
                while (true) {
                    i5 = i4 & 1;
                    if (i5 != i3) {
                        break;
                    }
                    f += 1.0f;
                    i4 >>= 1;
                }
                f17779a[i][(8 - i2) - 1] = f / 17.0f;
                i2++;
                i3 = i5;
            }
        }
    }

    /* renamed from: a */
    static int m22325a(int[] iArr) {
        int c = C5267i.m22327c(C5267i.m22326b(iArr));
        if (c != -1) {
            return c;
        }
        return C5267i.m22329e(iArr);
    }

    /* renamed from: b */
    private static int[] m22326b(int[] iArr) {
        float a = (float) C5194a.m21947a(iArr);
        int[] iArr2 = new int[8];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            if (((float) (iArr[i2] + i)) <= (a / 34.0f) + ((((float) i3) * a) / 17.0f)) {
                i += iArr[i2];
                i2++;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        return iArr2;
    }

    /* renamed from: c */
    private static int m22327c(int[] iArr) {
        int d = C5267i.m22328d(iArr);
        return C5269a.m22353a(d) == -1 ? -1 : d;
    }

    /* renamed from: d */
    private static int m22328d(int[] iArr) {
        long j = 0;
        int i = 0;
        while (i < iArr.length) {
            long j2 = j;
            for (int i2 = 0; i2 < iArr[i]; i2++) {
                int i3 = 1;
                j2 <<= 1;
                if (i % 2 != 0) {
                    i3 = 0;
                }
                j2 |= (long) i3;
            }
            i++;
            j = j2;
        }
        return (int) j;
    }

    /* renamed from: e */
    private static int m22329e(int[] iArr) {
        int a = C5194a.m21947a(iArr);
        float[] fArr = new float[8];
        if (a > 1) {
            for (int i = 0; i < 8; i++) {
                fArr[i] = ((float) iArr[i]) / ((float) a);
            }
        }
        a = -1;
        float f = Float.MAX_VALUE;
        for (iArr = null; iArr < f17779a.length; iArr++) {
            float[] fArr2 = f17779a[iArr];
            float f2 = 0.0f;
            for (int i2 = 0; i2 < 8; i2++) {
                float f3 = fArr2[i2] - fArr[i2];
                f2 += f3 * f3;
                if (f2 >= f) {
                    break;
                }
            }
            if (f2 < f) {
                a = C5269a.f17781a[iArr];
                f = f2;
            }
        }
        return a;
    }
}
