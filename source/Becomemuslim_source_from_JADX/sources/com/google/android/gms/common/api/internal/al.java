package com.google.android.gms.common.api.internal;

abstract class al implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ ab f7122a;

    private al(ab abVar) {
        this.f7122a = abVar;
    }

    /* renamed from: a */
    protected abstract void mo2394a();

    public void run() {
        this.f7122a.f11399b.lock();
        try {
            if (!Thread.interrupted()) {
                mo2394a();
                this.f7122a.f11399b.unlock();
            }
        } catch (RuntimeException e) {
            this.f7122a.f11398a.m16719a(e);
        } finally {
            this.f7122a.f11399b.unlock();
        }
    }
}
