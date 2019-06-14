package com.google.p217b;

import com.google.p217b.p222b.p223a.C5194a;

/* compiled from: ResultPoint */
/* renamed from: com.google.b.s */
public class C5316s {
    /* renamed from: a */
    private final float f17960a;
    /* renamed from: b */
    private final float f17961b;

    public C5316s(float f, float f2) {
        this.f17960a = f;
        this.f17961b = f2;
    }

    /* renamed from: a */
    public final float m22582a() {
        return this.f17960a;
    }

    /* renamed from: b */
    public final float m22583b() {
        return this.f17961b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C5316s)) {
            return false;
        }
        C5316s c5316s = (C5316s) obj;
        if (this.f17960a == c5316s.f17960a && this.f17961b == c5316s.f17961b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f17960a) * 31) + Float.floatToIntBits(this.f17961b);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("(");
        stringBuilder.append(this.f17960a);
        stringBuilder.append(',');
        stringBuilder.append(this.f17961b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static void m22581a(C5316s[] c5316sArr) {
        C5316s c5316s;
        C5316s c5316s2;
        C5316s c5316s3;
        float a = C5316s.m22579a(c5316sArr[0], c5316sArr[1]);
        float a2 = C5316s.m22579a(c5316sArr[1], c5316sArr[2]);
        float a3 = C5316s.m22579a(c5316sArr[0], c5316sArr[2]);
        if (a2 >= a && a2 >= a3) {
            c5316s = c5316sArr[0];
            c5316s2 = c5316sArr[1];
            c5316s3 = c5316sArr[2];
        } else if (a3 < a2 || a3 < a) {
            c5316s = c5316sArr[2];
            c5316s2 = c5316sArr[0];
            c5316s3 = c5316sArr[1];
        } else {
            c5316s = c5316sArr[1];
            c5316s2 = c5316sArr[0];
            c5316s3 = c5316sArr[2];
        }
        if (C5316s.m22580a(c5316s2, c5316s, c5316s3) < 0.0f) {
            C5316s c5316s4 = c5316s3;
            c5316s3 = c5316s2;
            c5316s2 = c5316s4;
        }
        c5316sArr[0] = c5316s2;
        c5316sArr[1] = c5316s;
        c5316sArr[2] = c5316s3;
    }

    /* renamed from: a */
    public static float m22579a(C5316s c5316s, C5316s c5316s2) {
        return C5194a.m21944a(c5316s.f17960a, c5316s.f17961b, c5316s2.f17960a, c5316s2.f17961b);
    }

    /* renamed from: a */
    private static float m22580a(C5316s c5316s, C5316s c5316s2, C5316s c5316s3) {
        float f = c5316s2.f17960a;
        c5316s2 = c5316s2.f17961b;
        return ((c5316s3.f17960a - f) * (c5316s.f17961b - c5316s2)) - ((c5316s3.f17961b - c5316s2) * (c5316s.f17960a - f));
    }
}
