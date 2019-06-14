package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

@cm
/* renamed from: com.google.android.gms.internal.ads.do */
public final class C7802do extends dx {
    /* renamed from: a */
    private final WeakReference<dc> f28571a;

    public C7802do(dc dcVar) {
        this.f28571a = new WeakReference(dcVar);
    }

    /* renamed from: a */
    public final void mo4240a(dp dpVar) {
        dc dcVar = (dc) this.f28571a.get();
        if (dcVar != null) {
            dcVar.mo4235a(dpVar);
        }
    }
}
