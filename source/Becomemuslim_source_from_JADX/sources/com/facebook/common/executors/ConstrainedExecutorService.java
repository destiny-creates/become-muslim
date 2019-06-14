package com.facebook.common.executors;

import com.facebook.common.logging.FLog;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstrainedExecutorService extends AbstractExecutorService {
    private static final Class<?> TAG = ConstrainedExecutorService.class;
    private final Executor mExecutor;
    private volatile int mMaxConcurrency;
    private final AtomicInteger mMaxQueueSize;
    private final String mName;
    private final AtomicInteger mPendingWorkers;
    private final Worker mTaskRunner;
    private final BlockingQueue<Runnable> mWorkQueue;

    private class Worker implements Runnable {
        private Worker() {
        }

        public void run() {
            try {
                Runnable runnable = (Runnable) ConstrainedExecutorService.this.mWorkQueue.poll();
                if (runnable != null) {
                    runnable.run();
                } else {
                    FLog.m5695v(ConstrainedExecutorService.TAG, "%s: Worker has nothing to run", ConstrainedExecutorService.this.mName);
                }
                int decrementAndGet = ConstrainedExecutorService.this.mPendingWorkers.decrementAndGet();
                if (ConstrainedExecutorService.this.mWorkQueue.isEmpty()) {
                    FLog.m5696v(ConstrainedExecutorService.TAG, "%s: worker finished; %d workers left", ConstrainedExecutorService.this.mName, Integer.valueOf(decrementAndGet));
                } else {
                    ConstrainedExecutorService.this.startWorkerIfNeeded();
                }
            } catch (Throwable th) {
                int decrementAndGet2 = ConstrainedExecutorService.this.mPendingWorkers.decrementAndGet();
                if (ConstrainedExecutorService.this.mWorkQueue.isEmpty()) {
                    FLog.m5696v(ConstrainedExecutorService.TAG, "%s: worker finished; %d workers left", ConstrainedExecutorService.this.mName, Integer.valueOf(decrementAndGet2));
                } else {
                    ConstrainedExecutorService.this.startWorkerIfNeeded();
                }
            }
        }
    }

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public ConstrainedExecutorService(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i > 0) {
            this.mName = str;
            this.mExecutor = executor;
            this.mMaxConcurrency = i;
            this.mWorkQueue = blockingQueue;
            this.mTaskRunner = new Worker();
            this.mPendingWorkers = new AtomicInteger(0);
            this.mMaxQueueSize = new AtomicInteger(0);
            return;
        }
        throw new IllegalArgumentException("max concurrency must be > 0");
    }

    public static ConstrainedExecutorService newConstrainedExecutor(String str, int i, int i2, Executor executor) {
        return new ConstrainedExecutorService(str, i, executor, new LinkedBlockingQueue(i2));
    }

    public boolean isIdle() {
        return this.mWorkQueue.isEmpty() && this.mPendingWorkers.get() == 0;
    }

    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        } else if (this.mWorkQueue.offer(runnable) != null) {
            runnable = this.mWorkQueue.size();
            int i = this.mMaxQueueSize.get();
            if (runnable > i && this.mMaxQueueSize.compareAndSet(i, runnable)) {
                FLog.m5696v(TAG, "%s: max pending work in queue = %d", this.mName, Integer.valueOf(runnable));
            }
            startWorkerIfNeeded();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.mName);
            stringBuilder.append(" queue is full, size=");
            stringBuilder.append(this.mWorkQueue.size());
            throw new RejectedExecutionException(stringBuilder.toString());
        }
    }

    private void startWorkerIfNeeded() {
        int i = this.mPendingWorkers.get();
        while (i < this.mMaxConcurrency) {
            int i2 = i + 1;
            if (this.mPendingWorkers.compareAndSet(i, i2)) {
                FLog.m5697v(TAG, "%s: starting worker %d of %d", this.mName, Integer.valueOf(i2), Integer.valueOf(this.mMaxConcurrency));
                this.mExecutor.execute(this.mTaskRunner);
                return;
            }
            FLog.m5695v(TAG, "%s: race in startWorkerIfNeeded; retrying", this.mName);
            i = this.mPendingWorkers.get();
        }
    }

    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }
}
