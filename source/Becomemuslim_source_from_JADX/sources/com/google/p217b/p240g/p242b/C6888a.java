package com.google.p217b.p240g.p242b;

import com.google.p217b.C5316s;

/* compiled from: AlignmentPattern */
/* renamed from: com.google.b.g.b.a */
public final class C6888a extends C5316s {
    /* renamed from: a */
    private final float f24697a;

    C6888a(float f, float f2, float f3) {
        super(f, f2);
        this.f24697a = f3;
    }

    /* renamed from: a */
    boolean m32334a(float f, float f2, float f3) {
        if (Math.abs(f2 - m22583b()) > f || Math.abs(f3 - m22582a()) > f) {
            return false;
        }
        f = Math.abs(f - this.f24697a);
        if (f > 1.0f) {
            if (f > this.f24697a) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    C6888a m32335b(float f, float f2, float f3) {
        return new C6888a((m22582a() + f2) / 2.0f, (m22583b() + f) / 2.0f, (this.f24697a + f3) / 2.0f);
    }
}
