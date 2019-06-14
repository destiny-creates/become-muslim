package com.p050a.p051a.p061e;

/* compiled from: MeanCalculator */
/* renamed from: com.a.a.e.d */
public class C0946d {
    /* renamed from: a */
    private float f2636a;
    /* renamed from: b */
    private int f2637b;

    /* renamed from: a */
    public void m3300a(float f) {
        this.f2636a += f;
        this.f2637b++;
        if (this.f2637b == Integer.MAX_VALUE) {
            this.f2636a /= 2.0f;
            this.f2637b /= 2;
        }
    }
}
