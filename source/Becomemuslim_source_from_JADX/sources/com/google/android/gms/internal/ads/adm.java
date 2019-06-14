package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;

final class adm implements acv {
    /* renamed from: a */
    private final acx f23563a;
    /* renamed from: b */
    private final String f23564b;
    /* renamed from: c */
    private final adn f23565c;

    adm(acx acx, String str, Object[] objArr) {
        this.f23563a = acx;
        this.f23564b = str;
        this.f23565c = new adn(acx.getClass(), str, objArr);
    }

    /* renamed from: a */
    public final int mo3764a() {
        return (this.f23565c.f14287d & 1) == 1 ? C4918e.f14229h : C4918e.f14230i;
    }

    /* renamed from: b */
    public final boolean mo3765b() {
        return (this.f23565c.f14287d & 2) == 2;
    }

    /* renamed from: c */
    public final acx mo3766c() {
        return this.f23563a;
    }

    /* renamed from: d */
    final adn m29833d() {
        return this.f23565c;
    }

    /* renamed from: e */
    public final int m29834e() {
        return this.f23565c.f14291h;
    }

    /* renamed from: f */
    public final int m29835f() {
        return this.f23565c.f14292i;
    }

    /* renamed from: g */
    public final int m29836g() {
        return this.f23565c.f14288e;
    }

    /* renamed from: h */
    public final int m29837h() {
        return this.f23565c.f14293j;
    }

    /* renamed from: i */
    public final int m29838i() {
        return this.f23565c.f14296m;
    }

    /* renamed from: j */
    final int[] m29839j() {
        return this.f23565c.f14297n;
    }

    /* renamed from: k */
    public final int m29840k() {
        return this.f23565c.f14295l;
    }

    /* renamed from: l */
    public final int m29841l() {
        return this.f23565c.f14294k;
    }
}
