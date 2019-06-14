package com.p050a.p051a.p062f;

/* compiled from: ScaleXY */
/* renamed from: com.a.a.f.d */
public class C0953d {
    /* renamed from: a */
    private final float f2664a;
    /* renamed from: b */
    private final float f2665b;

    public C0953d(float f, float f2) {
        this.f2664a = f;
        this.f2665b = f2;
    }

    public C0953d() {
        this(1.0f, 1.0f);
    }

    /* renamed from: a */
    public float m3333a() {
        return this.f2664a;
    }

    /* renamed from: b */
    public float m3334b() {
        return this.f2665b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m3333a());
        stringBuilder.append("x");
        stringBuilder.append(m3334b());
        return stringBuilder.toString();
    }
}
