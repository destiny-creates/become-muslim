package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.atw;
import com.google.android.gms.internal.ads.jn;

final class bs implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ atw f6839a;
    /* renamed from: b */
    private final /* synthetic */ bo f6840b;

    bs(bo boVar, atw atw) {
        this.f6840b = boVar;
        this.f6839a = atw;
    }

    public final void run() {
        try {
            if (this.f6840b.e.f6808s != null) {
                this.f6840b.e.f6808s.a(this.f6839a);
                this.f6840b.m17703a(this.f6839a.j());
            }
        } catch (Throwable e) {
            jn.d("#007 Could not call remote method.", e);
        }
    }
}
