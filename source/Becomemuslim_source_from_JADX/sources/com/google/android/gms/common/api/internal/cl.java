package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.C4361e;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.GoogleApiActivity;

final class cl implements Runnable {
    /* renamed from: a */
    final /* synthetic */ cj f7167a;
    /* renamed from: b */
    private final ck f7168b;

    cl(cj cjVar, ck ckVar) {
        this.f7167a = cjVar;
        this.f7168b = ckVar;
    }

    public final void run() {
        if (this.f7167a.f11492b) {
            C4775b b = this.f7168b.m8036b();
            if (b.m16825a()) {
                this.f7167a.a.startActivityForResult(GoogleApiActivity.m7900a(this.f7167a.m7971a(), b.m16828d(), this.f7168b.m8035a(), false), 1);
            } else if (this.f7167a.f11494d.mo2458a(b.m16827c())) {
                this.f7167a.f11494d.m14345a(this.f7167a.m7971a(), this.f7167a.a, b.m16827c(), 2, this.f7167a);
            } else if (b.m16827c() == 18) {
                this.f7167a.f11494d.m14342a(this.f7167a.m7971a().getApplicationContext(), new cm(this, C4361e.m14330a(this.f7167a.m7971a(), this.f7167a)));
            } else {
                this.f7167a.mo3285a(b, this.f7168b.m8035a());
            }
        }
    }
}
