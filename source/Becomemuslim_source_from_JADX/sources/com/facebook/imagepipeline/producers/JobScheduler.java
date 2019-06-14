package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JobScheduler {
    static final String QUEUE_TIME_KEY = "queueTime";
    private final Runnable mDoJobRunnable = new C17801();
    @VisibleForTesting
    EncodedImage mEncodedImage = null;
    private final Executor mExecutor;
    private final JobRunnable mJobRunnable;
    @VisibleForTesting
    long mJobStartTime = 0;
    @VisibleForTesting
    JobState mJobState = JobState.IDLE;
    @VisibleForTesting
    long mJobSubmitTime = 0;
    private final int mMinimumJobIntervalMs;
    @VisibleForTesting
    int mStatus = null;
    private final Runnable mSubmitJobRunnable = new C17812();

    /* renamed from: com.facebook.imagepipeline.producers.JobScheduler$1 */
    class C17801 implements Runnable {
        C17801() {
        }

        public void run() {
            JobScheduler.this.doJob();
        }
    }

    /* renamed from: com.facebook.imagepipeline.producers.JobScheduler$2 */
    class C17812 implements Runnable {
        C17812() {
        }

        public void run() {
            JobScheduler.this.submitJob();
        }
    }

    public interface JobRunnable {
        void run(EncodedImage encodedImage, int i);
    }

    @VisibleForTesting
    static class JobStartExecutorSupplier {
        private static ScheduledExecutorService sJobStarterExecutor;

        JobStartExecutorSupplier() {
        }

        static ScheduledExecutorService get() {
            if (sJobStarterExecutor == null) {
                sJobStarterExecutor = Executors.newSingleThreadScheduledExecutor();
            }
            return sJobStarterExecutor;
        }
    }

    @VisibleForTesting
    enum JobState {
        IDLE,
        QUEUED,
        RUNNING,
        RUNNING_AND_PENDING
    }

    public JobScheduler(Executor executor, JobRunnable jobRunnable, int i) {
        this.mExecutor = executor;
        this.mJobRunnable = jobRunnable;
        this.mMinimumJobIntervalMs = i;
    }

    public void clearJob() {
        EncodedImage encodedImage;
        synchronized (this) {
            encodedImage = this.mEncodedImage;
            this.mEncodedImage = null;
            this.mStatus = 0;
        }
        EncodedImage.closeSafely(encodedImage);
    }

    public boolean updateJob(EncodedImage encodedImage, int i) {
        if (!shouldProcess(encodedImage, i)) {
            return null;
        }
        EncodedImage encodedImage2;
        synchronized (this) {
            encodedImage2 = this.mEncodedImage;
            this.mEncodedImage = EncodedImage.cloneOrNull(encodedImage);
            this.mStatus = i;
        }
        EncodedImage.closeSafely(encodedImage2);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean scheduleJob() {
        /*
        r7 = this;
        r0 = android.os.SystemClock.uptimeMillis();
        monitor-enter(r7);
        r2 = r7.mEncodedImage;	 Catch:{ all -> 0x0043 }
        r3 = r7.mStatus;	 Catch:{ all -> 0x0043 }
        r2 = shouldProcess(r2, r3);	 Catch:{ all -> 0x0043 }
        r3 = 0;
        if (r2 != 0) goto L_0x0012;
    L_0x0010:
        monitor-exit(r7);	 Catch:{ all -> 0x0043 }
        return r3;
    L_0x0012:
        r2 = com.facebook.imagepipeline.producers.JobScheduler.C17823.f4987xca5c4655;	 Catch:{ all -> 0x0043 }
        r4 = r7.mJobState;	 Catch:{ all -> 0x0043 }
        r4 = r4.ordinal();	 Catch:{ all -> 0x0043 }
        r2 = r2[r4];	 Catch:{ all -> 0x0043 }
        r4 = 1;
        switch(r2) {
            case 1: goto L_0x0026;
            case 2: goto L_0x0039;
            case 3: goto L_0x0021;
            default: goto L_0x0020;
        };	 Catch:{ all -> 0x0043 }
    L_0x0020:
        goto L_0x0039;
    L_0x0021:
        r2 = com.facebook.imagepipeline.producers.JobScheduler.JobState.RUNNING_AND_PENDING;	 Catch:{ all -> 0x0043 }
        r7.mJobState = r2;	 Catch:{ all -> 0x0043 }
        goto L_0x0039;
    L_0x0026:
        r2 = r7.mJobStartTime;	 Catch:{ all -> 0x0043 }
        r5 = r7.mMinimumJobIntervalMs;	 Catch:{ all -> 0x0043 }
        r5 = (long) r5;	 Catch:{ all -> 0x0043 }
        r2 = r2 + r5;
        r2 = java.lang.Math.max(r2, r0);	 Catch:{ all -> 0x0043 }
        r7.mJobSubmitTime = r0;	 Catch:{ all -> 0x0043 }
        r5 = com.facebook.imagepipeline.producers.JobScheduler.JobState.QUEUED;	 Catch:{ all -> 0x0043 }
        r7.mJobState = r5;	 Catch:{ all -> 0x0043 }
        r5 = r2;
        r3 = 1;
        goto L_0x003b;
    L_0x0039:
        r5 = 0;
    L_0x003b:
        monitor-exit(r7);	 Catch:{ all -> 0x0043 }
        if (r3 == 0) goto L_0x0042;
    L_0x003e:
        r5 = r5 - r0;
        r7.enqueueJob(r5);
    L_0x0042:
        return r4;
    L_0x0043:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x0043 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.JobScheduler.scheduleJob():boolean");
    }

    private void enqueueJob(long j) {
        if (j > 0) {
            JobStartExecutorSupplier.get().schedule(this.mSubmitJobRunnable, j, TimeUnit.MILLISECONDS);
        } else {
            this.mSubmitJobRunnable.run();
        }
    }

    private void submitJob() {
        this.mExecutor.execute(this.mDoJobRunnable);
    }

    private void doJob() {
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            EncodedImage encodedImage = this.mEncodedImage;
            int i = this.mStatus;
            this.mEncodedImage = null;
            this.mStatus = 0;
            this.mJobState = JobState.RUNNING;
            this.mJobStartTime = uptimeMillis;
        }
        try {
            if (shouldProcess(encodedImage, i)) {
                this.mJobRunnable.run(encodedImage, i);
            }
            EncodedImage.closeSafely(encodedImage);
            onJobFinished();
        } catch (Throwable th) {
            EncodedImage.closeSafely(encodedImage);
            onJobFinished();
        }
    }

    private void onJobFinished() {
        long max;
        Object obj;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            if (this.mJobState == JobState.RUNNING_AND_PENDING) {
                max = Math.max(this.mJobStartTime + ((long) this.mMinimumJobIntervalMs), uptimeMillis);
                obj = 1;
                this.mJobSubmitTime = uptimeMillis;
                this.mJobState = JobState.QUEUED;
            } else {
                this.mJobState = JobState.IDLE;
                max = 0;
                obj = null;
            }
        }
        if (obj != null) {
            enqueueJob(max - uptimeMillis);
        }
    }

    private static boolean shouldProcess(EncodedImage encodedImage, int i) {
        if (!BaseConsumer.isLast(i) && BaseConsumer.statusHasFlag(i, 4) == 0) {
            if (EncodedImage.isValid(encodedImage) == null) {
                return null;
            }
        }
        return true;
    }

    public synchronized long getQueuedTime() {
        return this.mJobStartTime - this.mJobSubmitTime;
    }
}
