package com.onesignal;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import java.util.ArrayList;
import java.util.HashMap;

abstract class JobIntentService extends Service {
    /* renamed from: h */
    static final Object f18236h = new Object();
    /* renamed from: i */
    static final HashMap<ComponentNameWithWakeful, WorkEnqueuer> f18237i = new HashMap();
    /* renamed from: a */
    CompatJobEngine f18238a;
    /* renamed from: b */
    WorkEnqueuer f18239b;
    /* renamed from: c */
    CommandProcessor f18240c;
    /* renamed from: d */
    boolean f18241d = false;
    /* renamed from: e */
    boolean f18242e = false;
    /* renamed from: f */
    boolean f18243f = false;
    /* renamed from: g */
    final ArrayList<CompatWorkItem> f18244g = new ArrayList();

    final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        CommandProcessor() {
        }

        protected Void doInBackground(Void... voidArr) {
            while (true) {
                voidArr = JobIntentService.this.m23032d();
                if (voidArr == null) {
                    return null;
                }
                JobIntentService.this.mo4930a(voidArr.getIntent());
                voidArr.complete();
            }
        }

        protected void onCancelled(Void voidR) {
            JobIntentService.this.m23031c();
        }

        protected void onPostExecute(Void voidR) {
            JobIntentService.this.m23031c();
        }
    }

    interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    private static class ComponentNameWithWakeful {
        private ComponentName componentName;
        private boolean useWakefulService;

        ComponentNameWithWakeful(ComponentName componentName, boolean z) {
            this.componentName = componentName;
            this.useWakefulService = z;
        }
    }

    interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    static abstract class WorkEnqueuer {
        final ComponentName mComponentName;
        boolean mHasJobId;
        int mJobId;

        abstract void enqueueWork(Intent intent);

        public void serviceProcessingFinished() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceStartReceived() {
        }

        WorkEnqueuer(ComponentName componentName) {
            this.mComponentName = componentName;
        }

        void ensureJobId(int i) {
            if (!this.mHasJobId) {
                this.mHasJobId = true;
                this.mJobId = i;
            } else if (this.mJobId != i) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Given job ID ");
                stringBuilder.append(i);
                stringBuilder.append(" is different than previous ");
                stringBuilder.append(this.mJobId);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    static final class CompatWorkEnqueuer extends WorkEnqueuer {
        private final Context mContext;
        private final WakeLock mLaunchWakeLock;
        boolean mLaunchingService;
        private final WakeLock mRunWakeLock;
        boolean mServiceProcessing;

        CompatWorkEnqueuer(Context context, ComponentName componentName) {
            super(componentName);
            this.mContext = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(componentName.getClassName());
            stringBuilder.append(":launch");
            this.mLaunchWakeLock = powerManager.newWakeLock(1, stringBuilder.toString());
            this.mLaunchWakeLock.setReferenceCounted(false);
            stringBuilder = new StringBuilder();
            stringBuilder.append(componentName.getClassName());
            stringBuilder.append(":run");
            this.mRunWakeLock = powerManager.newWakeLock(1, stringBuilder.toString());
            this.mRunWakeLock.setReferenceCounted(false);
        }

        void enqueueWork(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.mComponentName);
            if (this.mContext.startService(intent2) != null) {
                synchronized (this) {
                    if (this.mLaunchingService == null) {
                        this.mLaunchingService = true;
                        if (this.mServiceProcessing == null) {
                            this.mLaunchWakeLock.acquire(60000);
                        }
                    }
                }
            }
        }

        public void serviceStartReceived() {
            synchronized (this) {
                this.mLaunchingService = false;
            }
        }

        public void serviceProcessingStarted() {
            synchronized (this) {
                if (!this.mServiceProcessing) {
                    this.mServiceProcessing = true;
                    this.mRunWakeLock.acquire(600000);
                    this.mLaunchWakeLock.release();
                }
            }
        }

        public void serviceProcessingFinished() {
            synchronized (this) {
                if (this.mServiceProcessing) {
                    if (this.mLaunchingService) {
                        this.mLaunchWakeLock.acquire(60000);
                    }
                    this.mServiceProcessing = false;
                    this.mRunWakeLock.release();
                }
            }
        }
    }

    final class CompatWorkItem implements GenericWorkItem {
        final Intent mIntent;
        final int mStartId;

        CompatWorkItem(Intent intent, int i) {
            this.mIntent = intent;
            this.mStartId = i;
        }

        public Intent getIntent() {
            return this.mIntent;
        }

        public void complete() {
            JobIntentService.this.stopSelf(this.mStartId);
        }
    }

    static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
        static final boolean DEBUG = false;
        static final String TAG = "JobServiceEngineImpl";
        final Object mLock = new Object();
        JobParameters mParams;
        final JobIntentService mService;

        final class WrapperWorkItem implements GenericWorkItem {
            final JobWorkItem mJobWork;

            WrapperWorkItem(JobWorkItem jobWorkItem) {
                this.mJobWork = jobWorkItem;
            }

            public Intent getIntent() {
                return this.mJobWork.getIntent();
            }

            public void complete() {
                synchronized (JobServiceEngineImpl.this.mLock) {
                    if (JobServiceEngineImpl.this.mParams != null) {
                        JobServiceEngineImpl.this.mParams.completeWork(this.mJobWork);
                    }
                }
            }
        }

        JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.mService = jobIntentService;
        }

        public IBinder compatGetBinder() {
            return getBinder();
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.mParams = jobParameters;
            this.mService.m23028a(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            jobParameters = this.mService.m23030b();
            synchronized (this.mLock) {
                this.mParams = null;
            }
            return jobParameters;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.onesignal.JobIntentService.GenericWorkItem dequeueWork() {
            /*
            r5 = this;
            r0 = r5.mLock;
            monitor-enter(r0);
            r1 = r5.mParams;	 Catch:{ all -> 0x0031 }
            r2 = 0;
            if (r1 != 0) goto L_0x000a;
        L_0x0008:
            monitor-exit(r0);	 Catch:{ all -> 0x0031 }
            return r2;
        L_0x000a:
            r1 = r5.mParams;	 Catch:{ SecurityException -> 0x0027 }
            r1 = r1.dequeueWork();	 Catch:{ SecurityException -> 0x0027 }
            monitor-exit(r0);	 Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x0026;
        L_0x0013:
            r0 = r1.getIntent();
            r2 = r5.mService;
            r2 = r2.getClassLoader();
            r0.setExtrasClassLoader(r2);
            r0 = new com.onesignal.JobIntentService$JobServiceEngineImpl$WrapperWorkItem;
            r0.<init>(r1);
            return r0;
        L_0x0026:
            return r2;
        L_0x0027:
            r1 = move-exception;
            r3 = "JobServiceEngineImpl";
            r4 = "Failed to run mParams.dequeueWork()!";
            android.util.Log.e(r3, r4, r1);	 Catch:{ all -> 0x0031 }
            monitor-exit(r0);	 Catch:{ all -> 0x0031 }
            return r2;
        L_0x0031:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0031 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.JobIntentService.JobServiceEngineImpl.dequeueWork():com.onesignal.JobIntentService$GenericWorkItem");
        }
    }

    static final class JobWorkEnqueuer extends WorkEnqueuer {
        private final JobInfo mJobInfo;
        private final JobScheduler mJobScheduler;

        JobWorkEnqueuer(Context context, ComponentName componentName, int i) {
            super(componentName);
            ensureJobId(i);
            this.mJobInfo = new Builder(i, this.mComponentName).setOverrideDeadline(0).build();
            this.mJobScheduler = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        void enqueueWork(Intent intent) {
            this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(intent));
        }
    }

    /* renamed from: a */
    protected abstract void mo4930a(Intent intent);

    /* renamed from: a */
    public boolean mo4931a() {
        return true;
    }

    public void onCreate() {
        super.onCreate();
        if (VERSION.SDK_INT >= 26) {
            this.f18238a = new JobServiceEngineImpl(this);
            this.f18239b = null;
        }
        this.f18239b = m23025a((Context) this, new ComponentName(this, getClass()), false, 0, true);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        this.f18239b.serviceStartReceived();
        synchronized (this.f18244g) {
            ArrayList arrayList = this.f18244g;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new CompatWorkItem(intent, i2));
            m23028a(true);
        }
        return 3;
    }

    public IBinder onBind(Intent intent) {
        return this.f18238a != null ? this.f18238a.compatGetBinder() : null;
    }

    public void onDestroy() {
        super.onDestroy();
        m23030b();
        synchronized (this.f18244g) {
            this.f18243f = true;
            this.f18239b.serviceProcessingFinished();
        }
    }

    /* renamed from: a */
    public static void m23026a(Context context, ComponentName componentName, int i, Intent intent, boolean z) {
        if (intent != null) {
            synchronized (f18236h) {
                WorkEnqueuer a = m23025a(context, componentName, true, i, z);
                a.ensureJobId(i);
                try {
                    a.enqueueWork(intent);
                } catch (IllegalStateException e) {
                    if (z) {
                        m23025a(context, componentName, true, i, false).enqueueWork(intent);
                    } else {
                        throw e;
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }

    /* renamed from: a */
    static WorkEnqueuer m23025a(Context context, ComponentName componentName, boolean z, int i, boolean z2) {
        ComponentNameWithWakeful componentNameWithWakeful = new ComponentNameWithWakeful(componentName, z2);
        WorkEnqueuer workEnqueuer = (WorkEnqueuer) f18237i.get(componentNameWithWakeful);
        if (workEnqueuer != null) {
            return workEnqueuer;
        }
        if (VERSION.SDK_INT < 26 || z2) {
            z = new CompatWorkEnqueuer(context, componentName);
        } else if (z) {
            z = new JobWorkEnqueuer(context, componentName, i);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        workEnqueuer = z;
        f18237i.put(componentNameWithWakeful, workEnqueuer);
        return workEnqueuer;
    }

    /* renamed from: b */
    boolean m23030b() {
        if (this.f18240c != null) {
            this.f18240c.cancel(this.f18241d);
        }
        this.f18242e = true;
        return mo4931a();
    }

    /* renamed from: a */
    void m23028a(boolean z) {
        if (this.f18240c == null) {
            this.f18240c = new CommandProcessor();
            if (this.f18239b != null && z) {
                this.f18239b.serviceProcessingStarted();
            }
            this.f18240c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* renamed from: c */
    void m23031c() {
        if (this.f18244g != null) {
            synchronized (this.f18244g) {
                this.f18240c = null;
                if (this.f18244g != null && this.f18244g.size() > 0) {
                    m23028a(false);
                } else if (!this.f18243f) {
                    this.f18239b.serviceProcessingFinished();
                }
            }
        }
    }

    /* renamed from: d */
    GenericWorkItem m23032d() {
        if (this.f18238a != null) {
            GenericWorkItem dequeueWork = this.f18238a.dequeueWork();
            if (dequeueWork != null) {
                return dequeueWork;
            }
        }
        synchronized (this.f18244g) {
            if (this.f18244g.size() > 0) {
                GenericWorkItem genericWorkItem = (GenericWorkItem) this.f18244g.remove(0);
                return genericWorkItem;
            }
            return null;
        }
    }
}
