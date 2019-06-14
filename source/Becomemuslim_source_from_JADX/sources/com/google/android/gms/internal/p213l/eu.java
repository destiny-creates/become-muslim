package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.eu */
final class eu implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ at f17207a;
    /* renamed from: b */
    private final /* synthetic */ er f17208b;

    eu(er erVar, at atVar) {
        this.f17208b = erVar;
        this.f17207a = atVar;
    }

    public final void run() {
        synchronized (this.f17208b) {
            this.f17208b.f24602b = false;
            if (!this.f17208b.f24601a.m44184B()) {
                this.f17208b.f24601a.mo4754r().m42578v().m21307a("Connected to remote service");
                this.f17208b.f24601a.m44193a(this.f17207a);
            }
        }
    }
}
