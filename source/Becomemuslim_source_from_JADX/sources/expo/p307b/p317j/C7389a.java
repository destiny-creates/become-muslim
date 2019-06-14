package expo.p307b.p317j;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: TaskConsumer */
/* renamed from: expo.b.j.a */
public abstract class C7389a implements C6038b {
    public static int VERSION;
    private WeakReference<Context> mContextRef;
    private C6042f mTaskManagerUtils;

    public boolean didCancelJob(JobService jobService, JobParameters jobParameters) {
        return false;
    }

    public boolean didExecuteJob(JobService jobService, JobParameters jobParameters) {
        return false;
    }

    public void didReceiveBroadcast(Intent intent) {
    }

    public void setOptions(Map<String, Object> map) {
    }

    public C7389a(Context context, C6042f c6042f) {
        this.mContextRef = new WeakReference(context);
        this.mTaskManagerUtils = c6042f;
    }

    protected Context getContext() {
        return this.mContextRef != null ? (Context) this.mContextRef.get() : null;
    }

    protected C6042f getTaskManagerUtils() {
        return this.mTaskManagerUtils;
    }
}
