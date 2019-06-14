package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.eh */
final class eh {
    /* renamed from: a */
    private final eq f16517a;
    /* renamed from: b */
    private final byte[] f16518b;

    private eh(int i) {
        this.f16518b = new byte[i];
        this.f16517a = eq.m31437a(this.f16518b);
    }

    /* renamed from: a */
    public final dy m20469a() {
        if (this.f16517a.mo6185b() == 0) {
            return new ej(this.f16518b);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    /* renamed from: b */
    public final eq m20470b() {
        return this.f16517a;
    }
}
