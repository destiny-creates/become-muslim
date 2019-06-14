package com.google.android.gms.internal.ads;

final class cy implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ ob f15273a;
    /* renamed from: b */
    private final /* synthetic */ cp f15274b;

    cy(cp cpVar, ob obVar) {
        this.f15274b = cpVar;
        this.f15273a = obVar;
    }

    public final void run() {
        synchronized (this.f15274b.f28504d) {
            this.f15274b.f28501a = this.f15274b.m37446a(this.f15274b.f28503c.f15311j, this.f15273a);
            if (this.f15274b.f28501a == null) {
                this.f15274b.m37442a(0, "Could not start the ad request service.");
                jw.f15691a.removeCallbacks(this.f15274b.f28509i);
            }
        }
    }
}
