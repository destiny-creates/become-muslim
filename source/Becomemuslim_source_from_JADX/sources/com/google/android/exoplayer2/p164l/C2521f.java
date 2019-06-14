package com.google.android.exoplayer2.p164l;

/* compiled from: FlacStreamInfo */
/* renamed from: com.google.android.exoplayer2.l.f */
public final class C2521f {
    /* renamed from: a */
    public final int f6410a;
    /* renamed from: b */
    public final int f6411b;
    /* renamed from: c */
    public final int f6412c;
    /* renamed from: d */
    public final int f6413d;
    /* renamed from: e */
    public final int f6414e;
    /* renamed from: f */
    public final int f6415f;
    /* renamed from: g */
    public final int f6416g;
    /* renamed from: h */
    public final long f6417h;

    public C2521f(byte[] bArr, int i) {
        C2528k c2528k = new C2528k(bArr);
        c2528k.m7073a(i * 8);
        this.f6410a = c2528k.m7081c(16);
        this.f6411b = c2528k.m7081c(16);
        this.f6412c = c2528k.m7081c(24);
        this.f6413d = c2528k.m7081c(24);
        this.f6414e = c2528k.m7081c(20);
        this.f6415f = c2528k.m7081c(3) + 1;
        this.f6416g = c2528k.m7081c(5) + 1;
        this.f6417h = ((((long) c2528k.m7081c(4)) & 15) << 32) | (((long) c2528k.m7081c(32)) & 4294967295L);
    }

    /* renamed from: a */
    public int m7041a() {
        return this.f6416g * this.f6414e;
    }

    /* renamed from: b */
    public long m7042b() {
        return (this.f6417h * 1000000) / ((long) this.f6414e);
    }
}
