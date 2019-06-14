package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;

/* compiled from: OneSignalJobServiceBase */
abstract class ap extends JobService {
    /* renamed from: a */
    abstract void mo4918a(JobService jobService, JobParameters jobParameters);

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }

    ap() {
    }

    public boolean onStartJob(final JobParameters jobParameters) {
        if (jobParameters.getExtras() == null) {
            return null;
        }
        new Thread(new Runnable(this) {
            /* renamed from: c */
            final /* synthetic */ ap f18431c;

            public void run() {
                this.f18431c.mo4918a(this, jobParameters);
                this.f18431c.jobFinished(jobParameters, false);
            }
        }, "OS_JOBSERVICE_BASE").start();
        return true;
    }
}
