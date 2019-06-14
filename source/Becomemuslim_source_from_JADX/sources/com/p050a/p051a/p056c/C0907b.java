package com.p050a.p051a.p056c;

/* compiled from: DocumentData */
/* renamed from: com.a.a.c.b */
public class C0907b {
    /* renamed from: a */
    public final String f2551a;
    /* renamed from: b */
    public final String f2552b;
    /* renamed from: c */
    public final double f2553c;
    /* renamed from: d */
    final int f2554d;
    /* renamed from: e */
    public final int f2555e;
    /* renamed from: f */
    final double f2556f;
    /* renamed from: g */
    public final double f2557g;
    /* renamed from: h */
    public final int f2558h;
    /* renamed from: i */
    public final int f2559i;
    /* renamed from: j */
    public final int f2560j;
    /* renamed from: k */
    public final boolean f2561k;

    public C0907b(String str, String str2, double d, int i, int i2, double d2, double d3, int i3, int i4, int i5, boolean z) {
        this.f2551a = str;
        this.f2552b = str2;
        this.f2553c = d;
        this.f2554d = i;
        this.f2555e = i2;
        this.f2556f = d2;
        this.f2557g = d3;
        this.f2558h = i3;
        this.f2559i = i4;
        this.f2560j = i5;
        this.f2561k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) (((double) (((this.f2551a.hashCode() * 31) + this.f2552b.hashCode()) * 31)) + this.f2553c)) * 31) + this.f2554d) * 31) + this.f2555e;
        long doubleToLongBits = Double.doubleToLongBits(this.f2556f);
        return (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f2558h;
    }
}
