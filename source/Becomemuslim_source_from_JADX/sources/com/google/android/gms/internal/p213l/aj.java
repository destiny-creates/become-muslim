package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.aj */
final class aj implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ dd f16883a;
    /* renamed from: b */
    private final /* synthetic */ ai f16884b;

    aj(ai aiVar, dd ddVar) {
        this.f16884b = aiVar;
        this.f16883a = ddVar;
    }

    public final void run() {
        this.f16883a.mo4755u();
        if (C5052x.m21503a()) {
            this.f16883a.mo4753q().m42612a((Runnable) this);
            return;
        }
        boolean b = this.f16884b.m21243b();
        this.f16884b.f16882d = 0;
        if (b) {
            this.f16884b.mo4760a();
        }
    }
}
