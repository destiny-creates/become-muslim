package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;

public class RestoreKickoffJobService extends ap {
    public /* bridge */ /* synthetic */ boolean onStartJob(JobParameters jobParameters) {
        return super.onStartJob(jobParameters);
    }

    public /* bridge */ /* synthetic */ boolean onStopJob(JobParameters jobParameters) {
        return super.onStopJob(jobParameters);
    }

    /* renamed from: a */
    void mo4918a(JobService jobService, JobParameters jobParameters) {
        Thread.currentThread().setPriority(10);
        am.m23152a((Context) this);
        C5542w.m23579b(getApplicationContext());
    }
}
