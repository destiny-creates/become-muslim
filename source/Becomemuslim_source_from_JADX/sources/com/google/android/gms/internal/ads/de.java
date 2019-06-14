package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;

@cm
public abstract class de implements dc, kp<Void> {
    /* renamed from: a */
    private final ob<dl> f24062a;
    /* renamed from: b */
    private final dc f24063b;
    /* renamed from: c */
    private final Object f24064c = new Object();

    public de(ob<dl> obVar, dc dcVar) {
        this.f24062a = obVar;
        this.f24063b = dcVar;
    }

    /* renamed from: a */
    public abstract void mo6093a();

    /* renamed from: a */
    public final void mo4235a(dp dpVar) {
        synchronized (this.f24064c) {
            this.f24063b.mo4235a(dpVar);
            mo6093a();
        }
    }

    /* renamed from: a */
    final boolean m30697a(dt dtVar, dl dlVar) {
        try {
            dtVar.mo4237a(dlVar, new C7802do(this));
            return true;
        } catch (Throwable th) {
            mt.m19921c("Could not fetch ad response from ad request service due to an Exception.", th);
            ax.i().m30834a(th, "AdRequestClientTask.getAdResponseFromService");
            this.f24063b.mo4235a(new dp(0));
            return false;
        }
    }

    /* renamed from: b */
    public final void mo3818b() {
        mo6093a();
    }

    /* renamed from: c */
    public final /* synthetic */ Object mo3819c() {
        dt d = mo6094d();
        if (d == null) {
            this.f24063b.mo4235a(new dp(0));
            mo6093a();
            return null;
        }
        this.f24062a.mo4320a(new dg(this, d), new dh(this));
        return null;
    }

    /* renamed from: d */
    public abstract dt mo6094d();
}
