package com.google.android.gms.internal.p213l;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.l.ef */
final class ef implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ C7826u f17159a;
    /* renamed from: b */
    private final /* synthetic */ ed f17160b;

    ef(ed edVar, C7826u c7826u) {
        this.f17160b = edVar;
        this.f17159a = c7826u;
    }

    public final void run() {
        at d = this.f17160b.f32821b;
        if (d == null) {
            this.f17160b.mo4754r().I_().m21307a("Failed to reset data on the service; null service");
            return;
        }
        try {
            d.mo4750d(this.f17159a);
        } catch (RemoteException e) {
            this.f17160b.mo4754r().I_().m21308a("Failed to reset data on the service", e);
        }
        this.f17160b.m44171J();
    }
}
