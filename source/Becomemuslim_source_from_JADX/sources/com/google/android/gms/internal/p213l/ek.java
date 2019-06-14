package com.google.android.gms.internal.p213l;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.l.ek */
final class ek implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ C7826u f17168a;
    /* renamed from: b */
    private final /* synthetic */ ed f17169b;

    ek(ed edVar, C7826u c7826u) {
        this.f17169b = edVar;
        this.f17168a = c7826u;
    }

    public final void run() {
        at d = this.f17169b.f32821b;
        if (d == null) {
            this.f17169b.mo4754r().I_().m21307a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            d.mo4748b(this.f17168a);
            this.f17169b.m44171J();
        } catch (RemoteException e) {
            this.f17169b.mo4754r().I_().m21308a("Failed to send measurementEnabled to the service", e);
        }
    }
}
