package com.google.android.gms.p186f;

/* renamed from: com.google.android.gms.f.v */
final class C2964v implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ C2954g f7604a;
    /* renamed from: b */
    private final /* synthetic */ C4411u f7605b;

    C2964v(C4411u c4411u, C2954g c2954g) {
        this.f7605b = c4411u;
        this.f7604a = c2954g;
    }

    public final void run() {
        synchronized (this.f7605b.f11775b) {
            if (this.f7605b.f11776c != null) {
                this.f7605b.f11776c.mo2577a(this.f7604a.mo2591d());
            }
        }
    }
}
