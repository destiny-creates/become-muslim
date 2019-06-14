package com.google.android.gms.p186f;

/* renamed from: com.google.android.gms.f.r */
final class C2962r implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ C2954g f7600a;
    /* renamed from: b */
    private final /* synthetic */ C4409q f7601b;

    C2962r(C4409q c4409q, C2954g c2954g) {
        this.f7601b = c4409q;
        this.f7600a = c2954g;
    }

    public final void run() {
        synchronized (this.f7601b.f11769b) {
            if (this.f7601b.f11770c != null) {
                this.f7601b.f11770c.onComplete(this.f7600a);
            }
        }
    }
}
