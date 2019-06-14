package com.google.p217b.p231e.p232a.p233a.p234a;

/* compiled from: CurrentParsingState */
/* renamed from: com.google.b.e.a.a.a.m */
final class C5239m {
    /* renamed from: a */
    private int f17682a = 0;
    /* renamed from: b */
    private C5238a f17683b = C5238a.NUMERIC;

    /* compiled from: CurrentParsingState */
    /* renamed from: com.google.b.e.a.a.a.m$a */
    private enum C5238a {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    C5239m() {
    }

    /* renamed from: a */
    int m22185a() {
        return this.f17682a;
    }

    /* renamed from: a */
    void m22186a(int i) {
        this.f17682a = i;
    }

    /* renamed from: b */
    void m22187b(int i) {
        this.f17682a += i;
    }

    /* renamed from: b */
    boolean m22188b() {
        return this.f17683b == C5238a.ALPHA;
    }

    /* renamed from: c */
    boolean m22189c() {
        return this.f17683b == C5238a.ISO_IEC_646;
    }

    /* renamed from: d */
    void m22190d() {
        this.f17683b = C5238a.NUMERIC;
    }

    /* renamed from: e */
    void m22191e() {
        this.f17683b = C5238a.ALPHA;
    }

    /* renamed from: f */
    void m22192f() {
        this.f17683b = C5238a.ISO_IEC_646;
    }
}
