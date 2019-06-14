package expo.p307b.p317j;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import java.util.Map;

/* compiled from: TaskConsumerInterface */
/* renamed from: expo.b.j.b */
public interface C6038b {
    boolean didCancelJob(JobService jobService, JobParameters jobParameters);

    boolean didExecuteJob(JobService jobService, JobParameters jobParameters);

    void didReceiveBroadcast(Intent intent);

    void didRegister(C6040d c6040d);

    void didUnregister();

    void setOptions(Map<String, Object> map);

    String taskType();
}
