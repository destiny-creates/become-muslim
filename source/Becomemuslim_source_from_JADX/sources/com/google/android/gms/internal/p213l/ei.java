package com.google.android.gms.internal.p213l;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.l.ei */
final class ei implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ dz f17166a;
    /* renamed from: b */
    private final /* synthetic */ ed f17167b;

    ei(ed edVar, dz dzVar) {
        this.f17167b = edVar;
        this.f17166a = dzVar;
    }

    public final void run() {
        at d = this.f17167b.f32821b;
        if (d == null) {
            this.f17167b.mo4754r().I_().m21307a("Failed to send current screen to service");
            return;
        }
        try {
            long j;
            String str;
            String str2;
            String packageName;
            if (this.f17166a == null) {
                j = 0;
                str = null;
                str2 = null;
                packageName = this.f17167b.mo4752n().getPackageName();
            } else {
                j = this.f17166a.f17147c;
                str = this.f17166a.f17145a;
                str2 = this.f17166a.f17146b;
                packageName = this.f17167b.mo4752n().getPackageName();
            }
            d.mo4740a(j, str, str2, packageName);
            this.f17167b.m44171J();
        } catch (RemoteException e) {
            this.f17167b.mo4754r().I_().m21308a("Failed to send current screen to the service", e);
        }
    }
}
