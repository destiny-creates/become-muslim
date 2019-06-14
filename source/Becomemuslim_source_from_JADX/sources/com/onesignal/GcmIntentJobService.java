package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import com.onesignal.C6965s.C5531a;

public class GcmIntentJobService extends ap {
    public /* bridge */ /* synthetic */ boolean onStartJob(JobParameters jobParameters) {
        return super.onStartJob(jobParameters);
    }

    public /* bridge */ /* synthetic */ boolean onStopJob(JobParameters jobParameters) {
        return super.onStopJob(jobParameters);
    }

    /* renamed from: a */
    void mo4918a(JobService jobService, JobParameters jobParameters) {
        C5529q.m23534a((Context) jobService, new C6962j(jobParameters.getExtras()), (C5531a) null);
    }
}
