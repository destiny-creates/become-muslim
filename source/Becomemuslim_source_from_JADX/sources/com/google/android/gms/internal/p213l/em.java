package com.google.android.gms.internal.p213l;

import android.os.RemoteException;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.internal.l.em */
final class em implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ boolean f17176a;
    /* renamed from: b */
    private final /* synthetic */ boolean f17177b;
    /* renamed from: c */
    private final /* synthetic */ C7827y f17178c;
    /* renamed from: d */
    private final /* synthetic */ C7826u f17179d;
    /* renamed from: e */
    private final /* synthetic */ C7827y f17180e;
    /* renamed from: f */
    private final /* synthetic */ ed f17181f;

    em(ed edVar, boolean z, boolean z2, C7827y c7827y, C7826u c7826u, C7827y c7827y2) {
        this.f17181f = edVar;
        this.f17176a = z;
        this.f17177b = z2;
        this.f17178c = c7827y;
        this.f17179d = c7826u;
        this.f17180e = c7827y2;
    }

    public final void run() {
        at d = this.f17181f.f32821b;
        if (d == null) {
            this.f17181f.mo4754r().I_().m21307a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f17176a) {
            this.f17181f.m44194a(d, this.f17177b ? null : this.f17178c, this.f17179d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f17180e.f29124a)) {
                    d.mo4746a(this.f17178c, this.f17179d);
                } else {
                    d.mo4745a(this.f17178c);
                }
            } catch (RemoteException e) {
                this.f17181f.mo4754r().I_().m21308a("Failed to send conditional user property to the service", e);
            }
        }
        this.f17181f.m44171J();
    }
}
