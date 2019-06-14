package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.C4776d;
import com.google.android.gms.common.api.internal.C2798d.C4771a;
import com.google.android.gms.common.api.internal.C2804h.C2802a;
import com.google.android.gms.p186f.C2955h;

public final class cf extends cc<Boolean> {
    /* renamed from: b */
    private final C2802a<?> f13984b;

    public cf(C2802a<?> c2802a, C2955h<Boolean> c2955h) {
        super(4, c2955h);
        this.f13984b = c2802a;
    }

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo2429a(C2812s c2812s, boolean z) {
    }

    /* renamed from: d */
    public final void mo3459d(C4771a<?> c4771a) {
        bn bnVar = (bn) c4771a.m16791c().remove(this.f13984b);
        if (bnVar != null) {
            bnVar.f7144b.m8097a(c4771a.m16790b(), this.a);
            bnVar.f7143a.m8087a();
            return;
        }
        this.a.m8787b(Boolean.valueOf(false));
    }

    /* renamed from: b */
    public final C4776d[] mo3283b(C4771a<?> c4771a) {
        bn bnVar = (bn) c4771a.m16791c().get(this.f13984b);
        if (bnVar == null) {
            return null;
        }
        return bnVar.f7143a.m8089b();
    }

    /* renamed from: c */
    public final boolean mo3284c(C4771a<?> c4771a) {
        bn bnVar = (bn) c4771a.m16791c().get(this.f13984b);
        return (bnVar == null || bnVar.f7143a.m8090c() == null) ? null : true;
    }
}
