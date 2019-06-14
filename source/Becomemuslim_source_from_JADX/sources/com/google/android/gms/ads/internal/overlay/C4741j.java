package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.ji;
import com.google.android.gms.internal.ads.jw;

@cm
/* renamed from: com.google.android.gms.ads.internal.overlay.j */
final class C4741j extends ji {
    /* renamed from: a */
    final /* synthetic */ C4740d f13066a;

    private C4741j(C4740d c4740d) {
        this.f13066a = c4740d;
    }

    /* renamed from: a */
    public final void m16583a() {
        Bitmap a = ax.m7484y().a(Integer.valueOf(this.f13066a.f13047b.f13035o.f13077e));
        if (a != null) {
            jw.f15691a.post(new C2662k(this, ax.m7466g().a(this.f13066a.f13046a, a, this.f13066a.f13047b.f13035o.f13075c, this.f13066a.f13047b.f13035o.f13076d)));
        }
    }

    public final void h_() {
    }
}
