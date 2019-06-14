package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.awa;
import com.google.android.gms.internal.ads.awo;
import com.google.android.gms.internal.ads.jn;

final class am implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ awa f6718a;
    /* renamed from: b */
    private final /* synthetic */ ae f6719b;

    am(ae aeVar, awa awa) {
        this.f6719b = aeVar;
        this.f6718a = awa;
    }

    public final void run() {
        try {
            ((awo) this.f6719b.e.f6811v.get(this.f6718a.l())).a(this.f6718a);
        } catch (Throwable e) {
            jn.d("#007 Could not call remote method.", e);
        }
    }
}
