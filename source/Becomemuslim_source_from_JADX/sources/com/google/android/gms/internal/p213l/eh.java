package com.google.android.gms.internal.p213l;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.l.eh */
final class eh implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ C7826u f17164a;
    /* renamed from: b */
    private final /* synthetic */ ed f17165b;

    eh(ed edVar, C7826u c7826u) {
        this.f17165b = edVar;
        this.f17164a = c7826u;
    }

    public final void run() {
        at d = this.f17165b.f32821b;
        if (d == null) {
            this.f17165b.mo4754r().I_().m21307a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            d.mo4744a(this.f17164a);
            this.f17165b.m44194a(d, null, this.f17164a);
            this.f17165b.m44171J();
        } catch (RemoteException e) {
            this.f17165b.mo4754r().I_().m21308a("Failed to send app launch to the service", e);
        }
    }
}
