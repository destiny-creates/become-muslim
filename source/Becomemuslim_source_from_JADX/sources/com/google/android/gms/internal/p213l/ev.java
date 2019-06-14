package com.google.android.gms.internal.p213l;

import android.content.ComponentName;
import android.content.Context;

/* renamed from: com.google.android.gms.internal.l.ev */
final class ev implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ er f17209a;

    ev(er erVar) {
        this.f17209a = erVar;
    }

    public final void run() {
        ed edVar = this.f17209a.f24601a;
        Context n = this.f17209a.f24601a.mo4752n();
        this.f17209a.f24601a.mo4755u();
        edVar.m44177a(new ComponentName(n, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
