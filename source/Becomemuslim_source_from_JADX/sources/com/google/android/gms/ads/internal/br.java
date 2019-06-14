package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.atu;
import com.google.android.gms.internal.ads.jn;

final class br implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ atu f6837a;
    /* renamed from: b */
    private final /* synthetic */ bo f6838b;

    br(bo boVar, atu atu) {
        this.f6838b = boVar;
        this.f6837a = atu;
    }

    public final void run() {
        try {
            if (this.f6838b.e.f6807r != null) {
                this.f6838b.e.f6807r.a(this.f6837a);
                this.f6838b.m17703a(this.f6837a.j());
            }
        } catch (Throwable e) {
            jn.d("#007 Could not call remote method.", e);
        }
    }
}
