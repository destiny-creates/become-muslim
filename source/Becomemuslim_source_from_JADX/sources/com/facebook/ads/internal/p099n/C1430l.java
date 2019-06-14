package com.facebook.ads.internal.p099n;

/* renamed from: com.facebook.ads.internal.n.l */
public enum C1430l {
    HEIGHT_100(-1, 100),
    HEIGHT_120(-1, 120),
    HEIGHT_300(-1, 300),
    HEIGHT_400(-1, 400);
    
    /* renamed from: e */
    private final int f4236e;
    /* renamed from: f */
    private final int f4237f;

    private C1430l(int i, int i2) {
        this.f4236e = i;
        this.f4237f = i2;
    }

    /* renamed from: a */
    public int m5048a() {
        return this.f4236e;
    }

    /* renamed from: b */
    public int m5049b() {
        return this.f4237f;
    }

    /* renamed from: c */
    public int m5050c() {
        int i = this.f4237f;
        return i != 100 ? i != 120 ? i != 300 ? i != 400 ? -1 : 4 : 3 : 2 : 1;
    }
}
