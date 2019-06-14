package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.es */
final class es implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ at f17203a;
    /* renamed from: b */
    private final /* synthetic */ er f17204b;

    es(er erVar, at atVar) {
        this.f17204b = erVar;
        this.f17203a = atVar;
    }

    public final void run() {
        synchronized (this.f17204b) {
            this.f17204b.f24602b = false;
            if (!this.f17204b.f24601a.m44184B()) {
                this.f17204b.f24601a.mo4754r().m42579w().m21307a("Connected to service");
                this.f17204b.f24601a.m44193a(this.f17203a);
            }
        }
    }
}
