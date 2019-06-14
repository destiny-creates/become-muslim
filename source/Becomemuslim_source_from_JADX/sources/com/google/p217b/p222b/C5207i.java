package com.google.p217b.p222b;

import com.google.p217b.C6894l;

/* compiled from: GridSampler */
/* renamed from: com.google.b.b.i */
public abstract class C5207i {
    /* renamed from: a */
    private static C5207i f17587a = new C6856f();

    /* renamed from: a */
    public abstract C5202b mo4861a(C5202b c5202b, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16);

    /* renamed from: a */
    public abstract C5202b mo4862a(C5202b c5202b, int i, int i2, C5208k c5208k);

    /* renamed from: a */
    public static C5207i m22035a() {
        return f17587a;
    }

    /* renamed from: a */
    protected static void m22036a(C5202b c5202b, float[] fArr) {
        int i;
        int f = c5202b.m22010f();
        c5202b = c5202b.m22011g();
        Object obj = 1;
        for (i = 0; i < fArr.length && r4 != null; i += 2) {
            int i2 = (int) fArr[i];
            int i3 = i + 1;
            int i4 = (int) fArr[i3];
            if (i2 < -1 || i2 > f || i4 < -1 || i4 > c5202b) {
                throw C6894l.m32349a();
            }
            if (i2 == -1) {
                fArr[i] = 0.0f;
            } else if (i2 == f) {
                fArr[i] = (float) (f - 1);
            } else {
                obj = null;
                if (i4 == -1) {
                    fArr[i3] = 0.0f;
                } else if (i4 != c5202b) {
                    fArr[i3] = (float) (c5202b - 1);
                } else {
                }
                obj = 1;
            }
            obj = 1;
            if (i4 == -1) {
                fArr[i3] = 0.0f;
            } else if (i4 != c5202b) {
            } else {
                fArr[i3] = (float) (c5202b - 1);
            }
            obj = 1;
        }
        obj = 1;
        for (i = fArr.length - 2; i >= 0 && r4 != null; i -= 2) {
            i2 = (int) fArr[i];
            i3 = i + 1;
            i4 = (int) fArr[i3];
            if (i2 < -1 || i2 > f || i4 < -1 || i4 > c5202b) {
                throw C6894l.m32349a();
            }
            if (i2 == -1) {
                fArr[i] = 0.0f;
            } else if (i2 == f) {
                fArr[i] = (float) (f - 1);
            } else {
                obj = null;
                if (i4 == -1) {
                    fArr[i3] = 0.0f;
                } else if (i4 != c5202b) {
                    fArr[i3] = (float) (c5202b - 1);
                } else {
                }
                obj = 1;
            }
            obj = 1;
            if (i4 == -1) {
                fArr[i3] = 0.0f;
            } else if (i4 != c5202b) {
            } else {
                fArr[i3] = (float) (c5202b - 1);
            }
            obj = 1;
        }
    }
}
