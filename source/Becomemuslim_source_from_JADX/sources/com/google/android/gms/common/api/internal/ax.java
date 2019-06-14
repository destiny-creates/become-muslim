package com.google.android.gms.common.api.internal;

abstract class ax {
    /* renamed from: a */
    private final av f7124a;

    protected ax(av avVar) {
        this.f7124a = avVar;
    }

    /* renamed from: a */
    protected abstract void mo2384a();

    /* renamed from: a */
    public final void m7996a(aw awVar) {
        awVar.f13168f.lock();
        try {
            if (awVar.f13176n == this.f7124a) {
                mo2384a();
                awVar.f13168f.unlock();
            }
        } finally {
            awVar.f13168f.unlock();
        }
    }
}
