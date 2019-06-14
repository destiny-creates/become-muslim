package com.google.android.gms.internal.p213l;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.l.eo */
final class eo implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ AtomicReference f17188a;
    /* renamed from: b */
    private final /* synthetic */ String f17189b;
    /* renamed from: c */
    private final /* synthetic */ String f17190c;
    /* renamed from: d */
    private final /* synthetic */ String f17191d;
    /* renamed from: e */
    private final /* synthetic */ boolean f17192e;
    /* renamed from: f */
    private final /* synthetic */ C7826u f17193f;
    /* renamed from: g */
    private final /* synthetic */ ed f17194g;

    eo(ed edVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z, C7826u c7826u) {
        this.f17194g = edVar;
        this.f17188a = atomicReference;
        this.f17189b = str;
        this.f17190c = str2;
        this.f17191d = str3;
        this.f17192e = z;
        this.f17193f = c7826u;
    }

    public final void run() {
        synchronized (this.f17188a) {
            Object a;
            try {
                at d = this.f17194g.f32821b;
                if (d == null) {
                    this.f17194g.mo4754r().I_().m21310a("Failed to get user properties", bb.m42550a(this.f17189b), this.f17190c, this.f17191d);
                    this.f17188a.set(Collections.emptyList());
                    this.f17188a.notify();
                    return;
                }
                AtomicReference atomicReference;
                if (TextUtils.isEmpty(this.f17189b)) {
                    atomicReference = this.f17188a;
                    a = d.mo4739a(this.f17190c, this.f17191d, this.f17192e, this.f17193f);
                } else {
                    atomicReference = this.f17188a;
                    a = d.mo4738a(this.f17189b, this.f17190c, this.f17191d, this.f17192e);
                }
                atomicReference.set(a);
                this.f17194g.m44171J();
                a = this.f17188a;
                a.notify();
            } catch (RemoteException e) {
                try {
                    this.f17194g.mo4754r().I_().m21310a("Failed to get user properties", bb.m42550a(this.f17189b), this.f17190c, e);
                    this.f17188a.set(Collections.emptyList());
                    a = this.f17188a;
                } catch (Throwable th) {
                    this.f17188a.notify();
                }
            }
        }
    }
}
