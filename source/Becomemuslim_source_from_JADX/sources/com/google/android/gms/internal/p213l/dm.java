package com.google.android.gms.internal.p213l;

import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;

/* renamed from: com.google.android.gms.internal.l.dm */
final class dm implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ ConditionalUserProperty f17106a;
    /* renamed from: b */
    private final /* synthetic */ df f17107b;

    dm(df dfVar, ConditionalUserProperty conditionalUserProperty) {
        this.f17107b = dfVar;
        this.f17106a = conditionalUserProperty;
    }

    public final void run() {
        this.f17107b.m44078d(this.f17106a);
    }
}
