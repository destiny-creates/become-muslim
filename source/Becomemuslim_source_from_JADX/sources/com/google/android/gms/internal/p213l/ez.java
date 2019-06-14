package com.google.android.gms.internal.p213l;

import android.app.job.JobParameters;

/* renamed from: com.google.android.gms.internal.l.ez */
final /* synthetic */ class ez implements Runnable {
    /* renamed from: a */
    private final ex f17216a;
    /* renamed from: b */
    private final bb f17217b;
    /* renamed from: c */
    private final JobParameters f17218c;

    ez(ex exVar, bb bbVar, JobParameters jobParameters) {
        this.f17216a = exVar;
        this.f17217b = bbVar;
        this.f17218c = jobParameters;
    }

    public final void run() {
        this.f17216a.m21352a(this.f17217b, this.f17218c);
    }
}
