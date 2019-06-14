package com.google.p217b.p240g.p242b;

import com.google.p217b.C5316s;

/* compiled from: FinderPattern */
/* renamed from: com.google.b.g.b.d */
public final class C6889d extends C5316s {
    /* renamed from: a */
    private final float f24698a;
    /* renamed from: b */
    private final int f24699b;

    C6889d(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    private C6889d(float f, float f2, float f3, int i) {
        super(f, f2);
        this.f24698a = f3;
        this.f24699b = i;
    }

    /* renamed from: c */
    public float m32338c() {
        return this.f24698a;
    }

    /* renamed from: d */
    int m32339d() {
        return this.f24699b;
    }

    /* renamed from: a */
    boolean m32336a(float f, float f2, float f3) {
        if (Math.abs(f2 - m22583b()) > f || Math.abs(f3 - m22582a()) > f) {
            return false;
        }
        f = Math.abs(f - this.f24698a);
        if (f > 1.0f) {
            if (f > this.f24698a) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    C6889d m32337b(float f, float f2, float f3) {
        int i = this.f24699b + 1;
        float a = (((float) this.f24699b) * m22582a()) + f2;
        f2 = (float) i;
        return new C6889d(a / f2, ((((float) this.f24699b) * m22583b()) + f) / f2, ((((float) this.f24699b) * this.f24698a) + f3) / f2, i);
    }
}
