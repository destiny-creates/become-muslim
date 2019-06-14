package com.google.android.gms.common.api.internal;

final class db implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ LifecycleCallback f7192a;
    /* renamed from: b */
    private final /* synthetic */ String f7193b;
    /* renamed from: c */
    private final /* synthetic */ da f7194c;

    db(da daVar, LifecycleCallback lifecycleCallback, String str) {
        this.f7194c = daVar;
        this.f7192a = lifecycleCallback;
        this.f7193b = str;
    }

    public final void run() {
        if (this.f7194c.f13201c > 0) {
            this.f7192a.mo2432a(this.f7194c.f13202d != null ? this.f7194c.f13202d.getBundle(this.f7193b) : null);
        }
        if (this.f7194c.f13201c >= 2) {
            this.f7192a.mo2433b();
        }
        if (this.f7194c.f13201c >= 3) {
            this.f7192a.mo3289c();
        }
        if (this.f7194c.f13201c >= 4) {
            this.f7192a.mo2435d();
        }
        if (this.f7194c.f13201c >= 5) {
            this.f7192a.m7979e();
        }
    }
}
