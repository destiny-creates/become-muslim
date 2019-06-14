package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.aub;
import com.google.android.gms.internal.ads.jn;

final class aj implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ aub f6711a;
    /* renamed from: b */
    private final /* synthetic */ ae f6712b;

    aj(ae aeVar, aub aub) {
        this.f6712b = aeVar;
        this.f6711a = aub;
    }

    public final void run() {
        try {
            if (this.f6712b.e.f6809t != null) {
                this.f6712b.e.f6809t.a(this.f6711a);
                this.f6712b.m17660a(this.f6711a.n());
            }
        } catch (Throwable e) {
            jn.d("#007 Could not call remote method.", e);
        }
    }
}
