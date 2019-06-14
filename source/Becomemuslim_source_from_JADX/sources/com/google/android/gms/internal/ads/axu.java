package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.C2850d.C2844a;

final class axu implements C2844a {
    /* renamed from: a */
    final /* synthetic */ axs f23848a;
    /* renamed from: b */
    private final /* synthetic */ nz f23849b;
    /* renamed from: c */
    private final /* synthetic */ axm f23850c;

    axu(axs axs, nz nzVar, axm axm) {
        this.f23848a = axs;
        this.f23849b = nzVar;
        this.f23850c = axm;
    }

    /* renamed from: a */
    public final void m30382a(int i) {
    }

    /* renamed from: a */
    public final void m30383a(Bundle bundle) {
        synchronized (this.f23848a.f23847d) {
            if (this.f23848a.f23845b) {
                return;
            }
            this.f23848a.f23845b = true;
            axl d = this.f23848a.f23844a;
            if (d == null) {
                return;
            }
            this.f23849b.mo4319a(new axw(this.f23849b, ju.m19678a(new axv(this, d, this.f23849b, this.f23850c))), nu.f15847b);
        }
    }
}
