package com.google.p217b.p222b.p223a;

/* compiled from: MathUtils */
/* renamed from: com.google.b.b.a.a */
public final class C5194a {
    /* renamed from: a */
    public static int m21946a(float f) {
        return (int) (f + (f < 0.0f ? -0.5f : 0.5f));
    }

    /* renamed from: a */
    public static float m21944a(float f, float f2, float f3, float f4) {
        f -= f3;
        f2 -= f4;
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }

    /* renamed from: a */
    public static float m21945a(int i, int i2, int i3, int i4) {
        i -= i3;
        i2 -= i4;
        return (float) Math.sqrt((double) ((i * i) + (i2 * i2)));
    }

    /* renamed from: a */
    public static int m21947a(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }
}
