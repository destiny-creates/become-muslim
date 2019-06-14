package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

final class au extends bj {
    /* renamed from: a */
    private WeakReference<an> f11468a;

    au(an anVar) {
        this.f11468a = new WeakReference(anVar);
    }

    /* renamed from: a */
    public final void mo2423a() {
        an anVar = (an) this.f11468a.get();
        if (anVar != null) {
            anVar.m14139n();
        }
    }
}
