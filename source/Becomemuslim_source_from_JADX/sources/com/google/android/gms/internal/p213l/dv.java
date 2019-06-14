package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.dv */
final class dv implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ long f17131a;
    /* renamed from: b */
    private final /* synthetic */ df f17132b;

    dv(df dfVar, long j) {
        this.f17132b = dfVar;
        this.f17131a = j;
    }

    public final void run() {
        this.f17132b.mo6214s().f32334k.m21319a(this.f17131a);
        this.f17132b.mo4754r().m42578v().m21308a("Minimum session duration set", Long.valueOf(this.f17131a));
    }
}
