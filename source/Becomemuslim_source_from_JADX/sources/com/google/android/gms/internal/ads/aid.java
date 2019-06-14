package com.google.android.gms.internal.ads;

final class aid implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ int f14561a;
    /* renamed from: b */
    private final /* synthetic */ boolean f14562b;
    /* renamed from: c */
    private final /* synthetic */ ahz f14563c;

    aid(ahz ahz, int i, boolean z) {
        this.f14563c = ahz;
        this.f14561a = i;
        this.f14562b = z;
    }

    public final void run() {
        aaa b = this.f14563c.m18458b(this.f14561a, this.f14562b);
        this.f14563c.f14543k = b;
        if (ahz.m18450b(this.f14561a, b)) {
            this.f14563c.m18456a(this.f14561a + 1, this.f14562b);
        }
    }
}
