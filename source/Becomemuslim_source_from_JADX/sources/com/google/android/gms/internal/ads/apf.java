package com.google.android.gms.internal.ads;

final class apf implements Runnable {
    /* renamed from: a */
    private final awi f14808a;
    /* renamed from: b */
    private final bck f14809b;
    /* renamed from: c */
    private final Runnable f14810c;

    public apf(anf anf, awi awi, bck bck, Runnable runnable) {
        this.f14808a = awi;
        this.f14809b = bck;
        this.f14810c = runnable;
    }

    public final void run() {
        this.f14808a.m19067g();
        if ((this.f14809b.f15216c == null ? 1 : null) != null) {
            this.f14808a.mo4315a(this.f14809b.f15214a);
        } else {
            this.f14808a.m19057a(this.f14809b.f15216c);
        }
        if (this.f14809b.f15217d) {
            this.f14808a.m19061b("intermediate-response");
        } else {
            this.f14808a.m19063c("done");
        }
        if (this.f14810c != null) {
            this.f14810c.run();
        }
    }
}
