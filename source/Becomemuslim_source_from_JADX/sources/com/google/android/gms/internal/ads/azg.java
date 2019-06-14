package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.C4736a;
import com.google.android.gms.ads.internal.C4910m;
import com.google.android.gms.ads.internal.ax;

final class azg {
    /* renamed from: a */
    C4910m f15083a;
    /* renamed from: b */
    aoq f15084b;
    /* renamed from: c */
    axz f15085c;
    /* renamed from: d */
    long f15086d;
    /* renamed from: e */
    boolean f15087e;
    /* renamed from: f */
    boolean f15088f;
    /* renamed from: g */
    private final /* synthetic */ azf f15089g;

    azg(azf azf, axy axy) {
        this.f15089g = azf;
        this.f15083a = axy.m19104b(azf.f15080c);
        this.f15085c = new axz();
        axz axz = this.f15085c;
        C4736a c4736a = this.f15083a;
        c4736a.a(new aya(axz));
        c4736a.a(new ayj(axz));
        c4736a.a(new ayl(axz));
        c4736a.a(new ayn(axz));
        c4736a.a(new ayp(axz));
    }

    azg(azf azf, axy axy, aoq aoq) {
        this(azf, axy);
        this.f15084b = aoq;
    }

    /* renamed from: a */
    final boolean m19159a() {
        if (this.f15087e) {
            return false;
        }
        this.f15088f = this.f15083a.b(azd.m19136b(this.f15084b != null ? this.f15084b : this.f15089g.f15079b));
        this.f15087e = true;
        this.f15086d = ax.l().a();
        return true;
    }
}
