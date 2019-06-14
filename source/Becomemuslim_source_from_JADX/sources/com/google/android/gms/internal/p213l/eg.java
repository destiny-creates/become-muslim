package com.google.android.gms.internal.p213l;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.l.eg */
final class eg implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ AtomicReference f17161a;
    /* renamed from: b */
    private final /* synthetic */ C7826u f17162b;
    /* renamed from: c */
    private final /* synthetic */ ed f17163c;

    eg(ed edVar, AtomicReference atomicReference, C7826u c7826u) {
        this.f17163c = edVar;
        this.f17161a = atomicReference;
        this.f17162b = c7826u;
    }

    public final void run() {
        synchronized (this.f17161a) {
            Object obj;
            try {
                at d = this.f17163c.f32821b;
                if (d == null) {
                    this.f17163c.mo4754r().I_().m21307a("Failed to get app instance id");
                    this.f17161a.notify();
                    return;
                }
                this.f17161a.set(d.mo4749c(this.f17162b));
                String str = (String) this.f17161a.get();
                if (str != null) {
                    this.f17163c.mo6742f().m44098a(str);
                    this.f17163c.mo6214s().f32333j.m21325a(str);
                }
                this.f17163c.m44171J();
                obj = this.f17161a;
                obj.notify();
            } catch (RemoteException e) {
                try {
                    this.f17163c.mo4754r().I_().m21308a("Failed to get app instance id", e);
                    obj = this.f17161a;
                } catch (Throwable th) {
                    this.f17161a.notify();
                }
            }
        }
    }
}
