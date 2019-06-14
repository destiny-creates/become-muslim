package com.google.android.gms.internal.ads;

import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.internal.C2850d.C2845b;

final class amm implements C2845b {
    /* renamed from: a */
    private final /* synthetic */ ami f23727a;

    amm(ami ami) {
        this.f23727a = ami;
    }

    /* renamed from: a */
    public final void m30043a(C4775b c4775b) {
        synchronized (this.f23727a.f14761b) {
            this.f23727a.f14764e = null;
            if (this.f23727a.f14762c != null) {
                this.f23727a.f14762c = null;
            }
            this.f23727a.f14761b.notifyAll();
        }
    }
}
