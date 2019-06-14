package com.google.p217b.p222b;

/* compiled from: PerspectiveTransform */
/* renamed from: com.google.b.b.k */
public final class C5208k {
    /* renamed from: a */
    private final float f17588a;
    /* renamed from: b */
    private final float f17589b;
    /* renamed from: c */
    private final float f17590c;
    /* renamed from: d */
    private final float f17591d;
    /* renamed from: e */
    private final float f17592e;
    /* renamed from: f */
    private final float f17593f;
    /* renamed from: g */
    private final float f17594g;
    /* renamed from: h */
    private final float f17595h;
    /* renamed from: i */
    private final float f17596i;

    private C5208k(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f17588a = f;
        this.f17589b = f4;
        this.f17590c = f7;
        this.f17591d = f2;
        this.f17592e = f5;
        this.f17593f = f8;
        this.f17594g = f3;
        this.f17595h = f6;
        this.f17596i = f9;
    }

    /* renamed from: a */
    public static C5208k m22040a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return C5208k.m22039a(f9, f10, f11, f12, f13, f14, f15, f16).m22043a(C5208k.m22041b(f, f2, f3, f4, f5, f6, f7, f8));
    }

    /* renamed from: a */
    public void m22044a(float[] fArr) {
        float[] fArr2 = fArr;
        int length = fArr2.length;
        float f = this.f17588a;
        float f2 = this.f17589b;
        float f3 = this.f17590c;
        float f4 = this.f17591d;
        float f5 = this.f17592e;
        float f6 = this.f17593f;
        float f7 = this.f17594g;
        float f8 = this.f17595h;
        float f9 = this.f17596i;
        for (int i = 0; i < length; i += 2) {
            float f10 = fArr2[i];
            int i2 = i + 1;
            float f11 = fArr2[i2];
            float f12 = ((f3 * f10) + (f6 * f11)) + f9;
            fArr2[i] = (((f * f10) + (f4 * f11)) + f7) / f12;
            fArr2[i2] = (((f10 * f2) + (f11 * f5)) + f8) / f12;
        }
    }

    /* renamed from: a */
    public static C5208k m22039a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = ((f - f3) + f5) - f7;
        float f10 = ((f2 - f4) + f6) - f8;
        if (f9 == 0.0f && f10 == 0.0f) {
            return new C5208k(f3 - f, f5 - f3, f, f4 - f2, f6 - f4, f2, 0.0f, 0.0f, 1.0f);
        }
        float f11 = f3 - f5;
        float f12 = f7 - f5;
        float f13 = f4 - f6;
        float f14 = f8 - f6;
        float f15 = (f11 * f14) - (f12 * f13);
        float f16 = ((f14 * f9) - (f12 * f10)) / f15;
        f9 = ((f11 * f10) - (f9 * f13)) / f15;
        return new C5208k((f3 - f) + (f16 * f3), (f9 * f7) + (f7 - f), f, (f4 - f2) + (f16 * f4), (f8 - f2) + (f9 * f8), f2, f16, f9, 1.0f);
    }

    /* renamed from: b */
    public static C5208k m22041b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return C5208k.m22039a(f, f2, f3, f4, f5, f6, f7, f8).m22042a();
    }

    /* renamed from: a */
    C5208k m22042a() {
        return new C5208k((this.f17592e * this.f17596i) - (this.f17593f * this.f17595h), (this.f17593f * this.f17594g) - (this.f17591d * this.f17596i), (this.f17591d * this.f17595h) - (this.f17592e * this.f17594g), (this.f17590c * this.f17595h) - (this.f17589b * this.f17596i), (this.f17588a * this.f17596i) - (this.f17590c * this.f17594g), (this.f17589b * this.f17594g) - (this.f17588a * this.f17595h), (this.f17589b * this.f17593f) - (this.f17590c * this.f17592e), (this.f17590c * this.f17591d) - (this.f17588a * this.f17593f), (this.f17588a * this.f17592e) - (this.f17589b * this.f17591d));
    }

    /* renamed from: a */
    C5208k m22043a(C5208k c5208k) {
        return new C5208k((this.f17594g * c5208k.f17590c) + ((this.f17588a * c5208k.f17588a) + (this.f17591d * c5208k.f17589b)), (this.f17594g * c5208k.f17593f) + ((this.f17588a * c5208k.f17591d) + (this.f17591d * c5208k.f17592e)), (this.f17594g * c5208k.f17596i) + ((this.f17588a * c5208k.f17594g) + (this.f17591d * c5208k.f17595h)), (this.f17595h * c5208k.f17590c) + ((this.f17589b * c5208k.f17588a) + (this.f17592e * c5208k.f17589b)), (this.f17595h * c5208k.f17593f) + ((this.f17589b * c5208k.f17591d) + (this.f17592e * c5208k.f17592e)), (this.f17595h * c5208k.f17596i) + ((this.f17589b * c5208k.f17594g) + (this.f17592e * c5208k.f17595h)), (this.f17596i * c5208k.f17590c) + ((this.f17590c * c5208k.f17588a) + (this.f17593f * c5208k.f17589b)), (this.f17596i * c5208k.f17593f) + ((this.f17590c * c5208k.f17591d) + (this.f17593f * c5208k.f17592e)), (this.f17596i * c5208k.f17596i) + ((this.f17590c * c5208k.f17594g) + (this.f17593f * c5208k.f17595h)));
    }
}
