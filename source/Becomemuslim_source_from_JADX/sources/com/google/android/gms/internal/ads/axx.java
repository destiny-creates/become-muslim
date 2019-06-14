package com.google.android.gms.internal.ads;

import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.internal.C2850d.C2845b;

final class axx implements C2845b {
    /* renamed from: a */
    private final /* synthetic */ nz f23851a;
    /* renamed from: b */
    private final /* synthetic */ axs f23852b;

    axx(axs axs, nz nzVar) {
        this.f23852b = axs;
        this.f23851a = nzVar;
    }

    /* renamed from: a */
    public final void m30384a(C4775b c4775b) {
        synchronized (this.f23852b.f23847d) {
            this.f23851a.m30914a(new RuntimeException("Connection failed."));
        }
    }
}
