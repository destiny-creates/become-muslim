package com.facebook.common.executors;

import android.os.Handler;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class HandlerExecutorServiceImpl extends AbstractExecutorService implements HandlerExecutorService {
    private final Handler mHandler;

    public boolean isShutdown() {
        return false;
    }

    public boolean isTerminated() {
        return false;
    }

    public HandlerExecutorServiceImpl(Handler handler) {
        this.mHandler = handler;
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

    public void execute(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    protected <T> ScheduledFutureImpl<T> newTaskFor(Runnable runnable, T t) {
        return new ScheduledFutureImpl(this.mHandler, runnable, t);
    }

    protected <T> ScheduledFutureImpl<T> newTaskFor(Callable<T> callable) {
        return new ScheduledFutureImpl(this.mHandler, callable);
    }

    public ScheduledFuture<?> submit(Runnable runnable) {
        return submit(runnable, (Void) null);
    }

    public <T> ScheduledFuture<T> submit(Runnable runnable, T t) {
        if (runnable != null) {
            runnable = newTaskFor(runnable, (Object) t);
            execute(runnable);
            return runnable;
        }
        throw new NullPointerException();
    }

    public <T> ScheduledFuture<T> submit(Callable<T> callable) {
        if (callable != null) {
            callable = newTaskFor((Callable) callable);
            execute(callable);
            return callable;
        }
        throw new NullPointerException();
    }

    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        runnable = newTaskFor(runnable, null);
        this.mHandler.postDelayed(runnable, timeUnit.toMillis(j));
        return runnable;
    }

    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        callable = newTaskFor((Callable) callable);
        this.mHandler.postDelayed(callable, timeUnit.toMillis(j));
        return callable;
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public void quit() {
        this.mHandler.getLooper().quit();
    }

    public boolean isHandlerThread() {
        return Thread.currentThread() == this.mHandler.getLooper().getThread();
    }
}
