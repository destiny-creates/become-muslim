package com.google.android.gms.internal.p213l;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.l.en */
final class en implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ AtomicReference f17182a;
    /* renamed from: b */
    private final /* synthetic */ String f17183b;
    /* renamed from: c */
    private final /* synthetic */ String f17184c;
    /* renamed from: d */
    private final /* synthetic */ String f17185d;
    /* renamed from: e */
    private final /* synthetic */ C7826u f17186e;
    /* renamed from: f */
    private final /* synthetic */ ed f17187f;

    en(ed edVar, AtomicReference atomicReference, String str, String str2, String str3, C7826u c7826u) {
        this.f17187f = edVar;
        this.f17182a = atomicReference;
        this.f17183b = str;
        this.f17184c = str2;
        this.f17185d = str3;
        this.f17186e = c7826u;
    }

    public final void run() {
        synchronized (this.f17182a) {
            Object a;
            try {
                at d = this.f17187f.f32821b;
                if (d == null) {
                    this.f17187f.mo4754r().I_().m21310a("Failed to get conditional properties", bb.m42550a(this.f17183b), this.f17184c, this.f17185d);
                    this.f17182a.set(Collections.emptyList());
                    this.f17182a.notify();
                    return;
                }
                AtomicReference atomicReference;
                if (TextUtils.isEmpty(this.f17183b)) {
                    atomicReference = this.f17182a;
                    a = d.mo4736a(this.f17184c, this.f17185d, this.f17186e);
                } else {
                    atomicReference = this.f17182a;
                    a = d.mo4737a(this.f17183b, this.f17184c, this.f17185d);
                }
                atomicReference.set(a);
                this.f17187f.m44171J();
                a = this.f17182a;
                a.notify();
            } catch (RemoteException e) {
                try {
                    this.f17187f.mo4754r().I_().m21310a("Failed to get conditional properties", bb.m42550a(this.f17183b), this.f17184c, e);
                    this.f17182a.set(Collections.emptyList());
                    a = this.f17182a;
                } catch (Throwable th) {
                    this.f17182a.notify();
                }
            }
        }
    }
}
