package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.aub;
import com.google.android.gms.internal.ads.jn;

final class bq implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ aub f6835a;
    /* renamed from: b */
    private final /* synthetic */ bo f6836b;

    bq(bo boVar, aub aub) {
        this.f6836b = boVar;
        this.f6835a = aub;
    }

    public final void run() {
        try {
            if (this.f6836b.e.f6809t != null) {
                this.f6836b.e.f6809t.a(this.f6835a);
                this.f6836b.m17703a(this.f6835a.n());
            }
        } catch (Throwable e) {
            jn.d("#007 Could not call remote method.", e);
        }
    }
}
