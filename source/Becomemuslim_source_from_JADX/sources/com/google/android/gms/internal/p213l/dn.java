package com.google.android.gms.internal.p213l;

import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;

/* renamed from: com.google.android.gms.internal.l.dn */
final class dn implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ ConditionalUserProperty f17108a;
    /* renamed from: b */
    private final /* synthetic */ df f17109b;

    dn(df dfVar, ConditionalUserProperty conditionalUserProperty) {
        this.f17109b = dfVar;
        this.f17108a = conditionalUserProperty;
    }

    public final void run() {
        this.f17109b.m44079e(this.f17108a);
    }
}
