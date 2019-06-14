package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.dw */
final class dw implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ long f17133a;
    /* renamed from: b */
    private final /* synthetic */ df f17134b;

    dw(df dfVar, long j) {
        this.f17134b = dfVar;
        this.f17133a = j;
    }

    public final void run() {
        this.f17134b.mo6214s().f32335l.m21319a(this.f17133a);
        this.f17134b.mo4754r().m42578v().m21308a("Session timeout duration set", Long.valueOf(this.f17133a));
    }
}
