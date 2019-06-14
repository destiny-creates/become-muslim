package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.atw;
import com.google.android.gms.internal.ads.jn;

final class ak implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ atw f6713a;
    /* renamed from: b */
    private final /* synthetic */ ae f6714b;

    ak(ae aeVar, atw atw) {
        this.f6714b = aeVar;
        this.f6713a = atw;
    }

    public final void run() {
        try {
            if (this.f6714b.e.f6808s != null) {
                this.f6714b.e.f6808s.a(this.f6713a);
                this.f6714b.m17660a(this.f6713a.j());
            }
        } catch (Throwable e) {
            jn.d("#007 Could not call remote method.", e);
        }
    }
}
