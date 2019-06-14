package com.google.android.exoplayer2.p137e.p143h;

import com.google.android.exoplayer2.p137e.C2327l;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: WavHeader */
/* renamed from: com.google.android.exoplayer2.e.h.b */
final class C4152b implements C2327l {
    /* renamed from: a */
    private final int f10778a;
    /* renamed from: b */
    private final int f10779b;
    /* renamed from: c */
    private final int f10780c;
    /* renamed from: d */
    private final int f10781d;
    /* renamed from: e */
    private final int f10782e;
    /* renamed from: f */
    private final int f10783f;
    /* renamed from: g */
    private long f10784g;
    /* renamed from: h */
    private long f10785h;

    /* renamed from: a */
    public boolean mo2167a() {
        return true;
    }

    public C4152b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f10778a = i;
        this.f10779b = i2;
        this.f10780c = i3;
        this.f10781d = i4;
        this.f10782e = i5;
        this.f10783f = i6;
    }

    /* renamed from: a */
    public void m13203a(long j, long j2) {
        this.f10784g = j;
        this.f10785h = j2;
    }

    /* renamed from: c */
    public boolean m13207c() {
        return (this.f10784g == 0 || this.f10785h == 0) ? false : true;
    }

    /* renamed from: b */
    public long mo2168b() {
        return ((this.f10785h / ((long) this.f10781d)) * 1000000) / ((long) this.f10779b);
    }

    /* renamed from: b */
    public long mo2169b(long j) {
        return this.f10784g + C2541v.m7169a((((j * ((long) this.f10780c)) / 1000000) / ((long) this.f10781d)) * ((long) this.f10781d), 0, this.f10785h - ((long) this.f10781d));
    }

    /* renamed from: a */
    public long m13202a(long j) {
        return (j * 1000000) / ((long) this.f10780c);
    }

    /* renamed from: d */
    public int m13208d() {
        return this.f10781d;
    }

    /* renamed from: e */
    public int m13209e() {
        return (this.f10779b * this.f10782e) * this.f10778a;
    }

    /* renamed from: f */
    public int m13210f() {
        return this.f10779b;
    }

    /* renamed from: g */
    public int m13211g() {
        return this.f10778a;
    }

    /* renamed from: h */
    public int m13212h() {
        return this.f10783f;
    }
}
