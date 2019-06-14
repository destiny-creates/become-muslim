package com.google.android.gms.common.api.internal;

final class cr implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ cq f7169a;

    cr(cq cqVar) {
        this.f7169a = cqVar;
    }

    public final void run() {
        this.f7169a.f11513m.lock();
        try {
            this.f7169a.m14230e();
        } finally {
            this.f7169a.f11513m.unlock();
        }
    }
}
