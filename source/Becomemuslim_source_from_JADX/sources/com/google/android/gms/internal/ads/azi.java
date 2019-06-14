package com.google.android.gms.internal.ads;

import android.os.Bundle;

@cm
public final class azi {
    /* renamed from: a */
    private static azi f15095a = new azi();
    /* renamed from: b */
    private int f15096b;
    /* renamed from: c */
    private int f15097c;
    /* renamed from: d */
    private int f15098d;
    /* renamed from: e */
    private int f15099e;
    /* renamed from: f */
    private int f15100f;

    /* renamed from: a */
    public static azi m19160a() {
        return f15095a;
    }

    /* renamed from: a */
    final void m19161a(int i) {
        this.f15096b += i;
    }

    /* renamed from: b */
    final void m19162b() {
        this.f15097c++;
    }

    /* renamed from: c */
    final void m19163c() {
        this.f15098d++;
    }

    /* renamed from: d */
    final void m19164d() {
        this.f15099e++;
    }

    /* renamed from: e */
    final void m19165e() {
        this.f15100f++;
    }

    /* renamed from: f */
    public final int m19166f() {
        return this.f15097c;
    }

    /* renamed from: g */
    public final int m19167g() {
        return this.f15098d;
    }

    /* renamed from: h */
    public final int m19168h() {
        return this.f15099e;
    }

    /* renamed from: i */
    public final int m19169i() {
        return this.f15100f;
    }

    /* renamed from: j */
    public final Bundle m19170j() {
        Bundle bundle = new Bundle();
        bundle.putInt("ipl", this.f15096b);
        bundle.putInt("ipds", this.f15097c);
        bundle.putInt("ipde", this.f15098d);
        bundle.putInt("iph", this.f15099e);
        bundle.putInt("ipm", this.f15100f);
        return bundle;
    }
}
