package com.google.android.gms.internal.p213l;

import android.os.RemoteException;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.internal.l.el */
final class el implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ boolean f17170a;
    /* renamed from: b */
    private final /* synthetic */ boolean f17171b;
    /* renamed from: c */
    private final /* synthetic */ aq f17172c;
    /* renamed from: d */
    private final /* synthetic */ C7826u f17173d;
    /* renamed from: e */
    private final /* synthetic */ String f17174e;
    /* renamed from: f */
    private final /* synthetic */ ed f17175f;

    el(ed edVar, boolean z, boolean z2, aq aqVar, C7826u c7826u, String str) {
        this.f17175f = edVar;
        this.f17170a = z;
        this.f17171b = z2;
        this.f17172c = aqVar;
        this.f17173d = c7826u;
        this.f17174e = str;
    }

    public final void run() {
        at d = this.f17175f.f32821b;
        if (d == null) {
            this.f17175f.mo4754r().I_().m21307a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f17170a) {
            this.f17175f.m44194a(d, this.f17171b ? null : this.f17172c, this.f17173d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f17174e)) {
                    d.mo4741a(this.f17172c, this.f17173d);
                } else {
                    d.mo4742a(this.f17172c, this.f17174e, this.f17175f.mo4754r().m42580x());
                }
            } catch (RemoteException e) {
                this.f17175f.mo4754r().I_().m21308a("Failed to send event to the service", e);
            }
        }
        this.f17175f.m44171J();
    }
}
