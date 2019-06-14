package com.google.android.gms.internal.p210i;

import android.app.job.JobParameters;

/* renamed from: com.google.android.gms.internal.i.bv */
final /* synthetic */ class bv implements Runnable {
    /* renamed from: a */
    private final bt f16444a;
    /* renamed from: b */
    private final bl f16445b;
    /* renamed from: c */
    private final JobParameters f16446c;

    bv(bt btVar, bl blVar, JobParameters jobParameters) {
        this.f16444a = btVar;
        this.f16445b = blVar;
        this.f16446c = jobParameters;
    }

    public final void run() {
        this.f16444a.m20360a(this.f16445b, this.f16446c);
    }
}
