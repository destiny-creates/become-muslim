package com.google.android.gms.fitness.p187a;

import com.google.android.gms.common.api.internal.C2804h;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.fitness.data.C4414z;
import com.google.android.gms.fitness.data.DataPoint;

/* renamed from: com.google.android.gms.fitness.a.e */
public final class C4794e extends C4414z {
    /* renamed from: a */
    private final C2804h<C2970c> f13344a;

    private C4794e(C2804h<C2970c> c2804h) {
        this.f13344a = (C2804h) C2872v.m8380a((Object) c2804h);
    }

    /* renamed from: a */
    public final void m16947a() {
        this.f13344a.m8080a();
    }

    /* renamed from: a */
    public final void mo2595a(DataPoint dataPoint) {
        this.f13344a.m8081a(new C4413f(this, dataPoint));
    }
}
