package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.internal.p213l.ex;
import com.google.android.gms.internal.p213l.fb;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements fb {
    /* renamed from: a */
    private ex<AppMeasurementJobService> f24659a;

    /* renamed from: a */
    private final ex<AppMeasurementJobService> m32215a() {
        if (this.f24659a == null) {
            this.f24659a = new ex(this);
        }
        return this.f24659a;
    }

    @TargetApi(24)
    /* renamed from: a */
    public final void mo4855a(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    /* renamed from: a */
    public final void mo4856a(Intent intent) {
    }

    /* renamed from: a */
    public final boolean mo4857a(int i) {
        throw new UnsupportedOperationException();
    }

    public final void onCreate() {
        super.onCreate();
        m32215a().m21350a();
    }

    public final void onDestroy() {
        m32215a().m21354b();
        super.onDestroy();
    }

    public final void onRebind(Intent intent) {
        m32215a().m21356c(intent);
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        return m32215a().m21353a(jobParameters);
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    public final boolean onUnbind(Intent intent) {
        return m32215a().m21355b(intent);
    }
}
