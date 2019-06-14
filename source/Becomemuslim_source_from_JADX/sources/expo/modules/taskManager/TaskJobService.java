package expo.modules.taskManager;

import android.app.job.JobParameters;
import android.app.job.JobService;

public class TaskJobService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        return new TaskService(getApplicationContext()).handleJob(this, jobParameters);
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return new TaskService(getApplicationContext()).cancelJob(this, jobParameters);
    }
}
