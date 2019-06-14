package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.atu;
import com.google.android.gms.internal.ads.jn;

final class ai implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ atu f6709a;
    /* renamed from: b */
    private final /* synthetic */ ae f6710b;

    ai(ae aeVar, atu atu) {
        this.f6710b = aeVar;
        this.f6709a = atu;
    }

    public final void run() {
        try {
            if (this.f6710b.e.f6807r != null) {
                this.f6710b.e.f6807r.a(this.f6709a);
                this.f6710b.m17660a(this.f6709a.j());
            }
        } catch (Throwable e) {
            jn.d("#007 Could not call remote method.", e);
        }
    }
}
