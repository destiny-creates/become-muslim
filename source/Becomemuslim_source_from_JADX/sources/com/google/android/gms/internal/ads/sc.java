package com.google.android.gms.internal.ads;

@cm
public final class sc {
    /* renamed from: a */
    public final int f15991a;
    /* renamed from: b */
    public final int f15992b;
    /* renamed from: c */
    private final int f15993c;

    private sc(int i, int i2, int i3) {
        this.f15993c = i;
        this.f15992b = i2;
        this.f15991a = i3;
    }

    /* renamed from: a */
    public static sc m20088a() {
        return new sc(0, 0, 0);
    }

    /* renamed from: a */
    public static sc m20089a(int i, int i2) {
        return new sc(1, i, i2);
    }

    /* renamed from: a */
    public static sc m20090a(aou aou) {
        return aou.f28282d ? new sc(3, 0, 0) : aou.f28287i ? new sc(2, 0, 0) : aou.f28286h ? m20088a() : m20089a(aou.f28284f, aou.f28281c);
    }

    /* renamed from: b */
    public static sc m20091b() {
        return new sc(4, 0, 0);
    }

    /* renamed from: c */
    public final boolean m20092c() {
        return this.f15993c == 2;
    }

    /* renamed from: d */
    public final boolean m20093d() {
        return this.f15993c == 3;
    }

    /* renamed from: e */
    public final boolean m20094e() {
        return this.f15993c == 0;
    }

    /* renamed from: f */
    public final boolean m20095f() {
        return this.f15993c == 4;
    }
}
