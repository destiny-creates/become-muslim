package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.internal.p210i.bt;
import com.google.android.gms.internal.p210i.bx;

@TargetApi(24)
public final class AnalyticsJobService extends JobService implements bx {
    /* renamed from: a */
    private bt<AnalyticsJobService> f11351a;

    /* renamed from: a */
    private final bt<AnalyticsJobService> m13961a() {
        if (this.f11351a == null) {
            this.f11351a = new bt(this);
        }
        return this.f11351a;
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public final void onCreate() {
        super.onCreate();
        m13961a().a();
    }

    public final void onDestroy() {
        m13961a().b();
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        return m13961a().a(intent, i, i2);
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        return m13961a().a(jobParameters);
    }

    /* renamed from: a */
    public final boolean m13963a(int i) {
        return stopSelfResult(i);
    }

    @TargetApi(24)
    /* renamed from: a */
    public final void m13962a(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }
}
