package com.google.p217b.p240g.p241a;

/* compiled from: ErrorCorrectionLevel */
/* renamed from: com.google.b.g.a.f */
public enum C5288f {
    L(1),
    M(0),
    Q(3),
    H(2);
    
    /* renamed from: e */
    private static final C5288f[] f17856e = null;
    /* renamed from: f */
    private final int f17858f;

    static {
        f17856e = new C5288f[]{M, L, H, Q};
    }

    private C5288f(int i) {
        this.f17858f = i;
    }

    /* renamed from: a */
    public int m22439a() {
        return this.f17858f;
    }

    /* renamed from: a */
    public static C5288f m22438a(int i) {
        if (i >= 0 && i < f17856e.length) {
            return f17856e[i];
        }
        throw new IllegalArgumentException();
    }
}
