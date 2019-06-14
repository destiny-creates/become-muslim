package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLog;

public abstract class BaseConsumer<T> implements Consumer<T> {
    private boolean mIsFinished = false;

    public static boolean isLast(int i) {
        return (i & 1) == 1;
    }

    public static int simpleStatusForIsLast(boolean z) {
        return z;
    }

    public static boolean statusHasAnyFlag(int i, int i2) {
        return (i & i2) != 0;
    }

    public static boolean statusHasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    public static int turnOffStatusFlag(int i, int i2) {
        return i & (~i2);
    }

    public static int turnOnStatusFlag(int i, int i2) {
        return i | i2;
    }

    protected abstract void onCancellationImpl();

    protected abstract void onFailureImpl(Throwable th);

    protected abstract void onNewResultImpl(T t, int i);

    protected void onProgressUpdateImpl(float f) {
    }

    public static boolean isNotLast(int i) {
        return isLast(i) ^ 1;
    }

    public synchronized void onNewResult(T t, int i) {
        if (!this.mIsFinished) {
            this.mIsFinished = isLast(i);
            try {
                onNewResultImpl(t, i);
            } catch (T t2) {
                onUnhandledException(t2);
            }
        } else {
            return;
        }
        return;
    }

    public synchronized void onFailure(Throwable th) {
        if (!this.mIsFinished) {
            this.mIsFinished = true;
            try {
                onFailureImpl(th);
            } catch (Throwable th2) {
                onUnhandledException(th2);
            }
        } else {
            return;
        }
        return;
    }

    public synchronized void onCancellation() {
        if (!this.mIsFinished) {
            this.mIsFinished = true;
            try {
                onCancellationImpl();
            } catch (Exception e) {
                onUnhandledException(e);
            }
        } else {
            return;
        }
        return;
    }

    public synchronized void onProgressUpdate(float f) {
        if (!this.mIsFinished) {
            try {
                onProgressUpdateImpl(f);
            } catch (float f2) {
                onUnhandledException(f2);
            }
        } else {
            return;
        }
    }

    protected void onUnhandledException(Exception exception) {
        FLog.wtf(getClass(), "unhandled exception", (Throwable) exception);
    }
}
