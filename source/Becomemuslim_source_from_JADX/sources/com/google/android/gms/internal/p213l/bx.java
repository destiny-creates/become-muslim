package com.google.android.gms.internal.p213l;

/* renamed from: com.google.android.gms.internal.l.bx */
final class bx implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ cg f17016a;
    /* renamed from: b */
    private final /* synthetic */ bb f17017b;

    bx(bw bwVar, cg cgVar, bb bbVar) {
        this.f17016a = cgVar;
        this.f17017b = bbVar;
    }

    public final void run() {
        if (this.f17016a.m31964f() == null) {
            this.f17017b.I_().m21307a("Install Referrer Reporter is null");
        } else {
            this.f17016a.m31964f().m21328a();
        }
    }
}
