package com.google.android.gms.internal.p213l;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.l.eq */
final class eq implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ AtomicReference f17199a;
    /* renamed from: b */
    private final /* synthetic */ C7826u f17200b;
    /* renamed from: c */
    private final /* synthetic */ boolean f17201c;
    /* renamed from: d */
    private final /* synthetic */ ed f17202d;

    eq(ed edVar, AtomicReference atomicReference, C7826u c7826u, boolean z) {
        this.f17202d = edVar;
        this.f17199a = atomicReference;
        this.f17200b = c7826u;
        this.f17201c = z;
    }

    public final void run() {
        synchronized (this.f17199a) {
            Object obj;
            try {
                at d = this.f17202d.f32821b;
                if (d == null) {
                    this.f17202d.mo4754r().I_().m21307a("Failed to get user properties");
                    this.f17199a.notify();
                    return;
                }
                this.f17199a.set(d.mo4735a(this.f17200b, this.f17201c));
                this.f17202d.m44171J();
                obj = this.f17199a;
                obj.notify();
            } catch (RemoteException e) {
                try {
                    this.f17202d.mo4754r().I_().m21308a("Failed to get user properties", e);
                    obj = this.f17199a;
                } catch (Throwable th) {
                    this.f17199a.notify();
                }
            }
        }
    }
}
