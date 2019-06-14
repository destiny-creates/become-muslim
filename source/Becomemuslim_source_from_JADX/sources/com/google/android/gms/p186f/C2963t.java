package com.google.android.gms.p186f;

/* renamed from: com.google.android.gms.f.t */
final class C2963t implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ C2954g f7602a;
    /* renamed from: b */
    private final /* synthetic */ C4410s f7603b;

    C2963t(C4410s c4410s, C2954g c2954g) {
        this.f7603b = c4410s;
        this.f7602a = c2954g;
    }

    public final void run() {
        synchronized (this.f7603b.f11772b) {
            if (this.f7603b.f11773c != null) {
                this.f7603b.f11773c.mo2576a(this.f7602a.mo2592e());
            }
        }
    }
}
