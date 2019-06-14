package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.ep */
final class ep implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ boolean f17195a;
    /* renamed from: b */
    private final /* synthetic */ ft f17196b;
    /* renamed from: c */
    private final /* synthetic */ C7826u f17197c;
    /* renamed from: d */
    private final /* synthetic */ ed f17198d;

    ep(ed edVar, boolean z, ft ftVar, C7826u c7826u) {
        this.f17198d = edVar;
        this.f17195a = z;
        this.f17196b = ftVar;
        this.f17197c = c7826u;
    }

    public final void run() {
        at d = this.f17198d.f32821b;
        if (d == null) {
            this.f17198d.mo4754r().I_().m21307a("Discarding data. Failed to set user attribute");
            return;
        }
        this.f17198d.m44194a(d, this.f17195a ? null : this.f17196b, this.f17197c);
        this.f17198d.m44171J();
    }
}
