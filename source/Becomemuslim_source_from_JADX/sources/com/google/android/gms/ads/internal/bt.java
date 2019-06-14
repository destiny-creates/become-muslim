package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.awa;
import com.google.android.gms.internal.ads.awo;
import com.google.android.gms.internal.ads.jn;

final class bt implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ awa f6841a;
    /* renamed from: b */
    private final /* synthetic */ bo f6842b;

    bt(bo boVar, awa awa) {
        this.f6842b = boVar;
        this.f6841a = awa;
    }

    public final void run() {
        try {
            ((awo) this.f6842b.e.f6811v.get(this.f6841a.l())).a(this.f6841a);
        } catch (Throwable e) {
            jn.d("#007 Could not call remote method.", e);
        }
    }
}
