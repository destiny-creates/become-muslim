package com.google.android.gms.common.api.internal;

final class cz implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ LifecycleCallback f7170a;
    /* renamed from: b */
    private final /* synthetic */ String f7171b;
    /* renamed from: c */
    private final /* synthetic */ cy f7172c;

    cz(cy cyVar, LifecycleCallback lifecycleCallback, String str) {
        this.f7172c = cyVar;
        this.f7170a = lifecycleCallback;
        this.f7171b = str;
    }

    public final void run() {
        if (this.f7172c.f11542c > 0) {
            this.f7170a.mo2432a(this.f7172c.f11543d != null ? this.f7172c.f11543d.getBundle(this.f7171b) : null);
        }
        if (this.f7172c.f11542c >= 2) {
            this.f7170a.mo2433b();
        }
        if (this.f7172c.f11542c >= 3) {
            this.f7170a.mo3289c();
        }
        if (this.f7172c.f11542c >= 4) {
            this.f7170a.mo2435d();
        }
        if (this.f7172c.f11542c >= 5) {
            this.f7170a.m7979e();
        }
    }
}
