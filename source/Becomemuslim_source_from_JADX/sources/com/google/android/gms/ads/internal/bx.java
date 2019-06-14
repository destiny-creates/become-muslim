package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.is;
import com.google.android.gms.internal.ads.jw;
import com.google.android.gms.internal.ads.sa;

final /* synthetic */ class bx implements sa {
    /* renamed from: a */
    private final is f11278a;
    /* renamed from: b */
    private final Runnable f11279b;

    bx(is isVar, Runnable runnable) {
        this.f11278a = isVar;
        this.f11279b = runnable;
    }

    /* renamed from: a */
    public final void m13899a() {
        is isVar = this.f11278a;
        Runnable runnable = this.f11279b;
        if (!isVar.f15586m) {
            ax.m7464e();
            jw.a(runnable);
        }
    }
}
