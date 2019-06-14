package com.onesignal;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import com.onesignal.at.C6953b;

public class SyncJobService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        at.m23330a((Context) this, new C6953b(this, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return at.m23333b();
    }
}
