package com.p050a.p051a.p056c.p058b;

import com.p050a.p051a.p061e.C0945b;
import com.p050a.p051a.p061e.C0947e;

/* compiled from: GradientColor */
/* renamed from: com.a.a.c.b.c */
public class C0896c {
    /* renamed from: a */
    private final float[] f2513a;
    /* renamed from: b */
    private final int[] f2514b;

    public C0896c(float[] fArr, int[] iArr) {
        this.f2513a = fArr;
        this.f2514b = iArr;
    }

    /* renamed from: a */
    public float[] m3173a() {
        return this.f2513a;
    }

    /* renamed from: b */
    public int[] m3174b() {
        return this.f2514b;
    }

    /* renamed from: c */
    public int m3175c() {
        return this.f2514b.length;
    }

    /* renamed from: a */
    public void m3172a(C0896c c0896c, C0896c c0896c2, float f) {
        if (c0896c.f2514b.length == c0896c2.f2514b.length) {
            for (int i = 0; i < c0896c.f2514b.length; i++) {
                this.f2513a[i] = C0947e.m3302a(c0896c.f2513a[i], c0896c2.f2513a[i], f);
                this.f2514b[i] = C0945b.m3298a(f, c0896c.f2514b[i], c0896c2.f2514b[i]);
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot interpolate between gradients. Lengths vary (");
        stringBuilder.append(c0896c.f2514b.length);
        stringBuilder.append(" vs ");
        stringBuilder.append(c0896c2.f2514b.length);
        stringBuilder.append(")");
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
