package com.facebook.datasource;

import android.util.Pair;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

public abstract class AbstractDataSource<T> implements DataSource<T> {
    private DataSourceStatus mDataSourceStatus = DataSourceStatus.IN_PROGRESS;
    private Throwable mFailureThrowable = null;
    private boolean mIsClosed = false;
    private float mProgress = 0.0f;
    private T mResult = null;
    private final ConcurrentLinkedQueue<Pair<DataSubscriber<T>, Executor>> mSubscribers = new ConcurrentLinkedQueue();

    private enum DataSourceStatus {
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    protected void closeResult(T t) {
    }

    protected AbstractDataSource() {
    }

    public synchronized boolean isClosed() {
        return this.mIsClosed;
    }

    public synchronized boolean isFinished() {
        return this.mDataSourceStatus != DataSourceStatus.IN_PROGRESS;
    }

    public synchronized boolean hasResult() {
        return this.mResult != null;
    }

    public synchronized T getResult() {
        return this.mResult;
    }

    public synchronized boolean hasFailed() {
        return this.mDataSourceStatus == DataSourceStatus.FAILURE;
    }

    public synchronized Throwable getFailureCause() {
        return this.mFailureThrowable;
    }

    public synchronized float getProgress() {
        return this.mProgress;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean close() {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.mIsClosed;	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x0008;
    L_0x0005:
        r0 = 0;
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        return r0;
    L_0x0008:
        r0 = 1;
        r3.mIsClosed = r0;	 Catch:{ all -> 0x002a }
        r1 = r3.mResult;	 Catch:{ all -> 0x002a }
        r2 = 0;
        r3.mResult = r2;	 Catch:{ all -> 0x002a }
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        if (r1 == 0) goto L_0x0016;
    L_0x0013:
        r3.closeResult(r1);
    L_0x0016:
        r1 = r3.isFinished();
        if (r1 != 0) goto L_0x001f;
    L_0x001c:
        r3.notifyDataSubscribers();
    L_0x001f:
        monitor-enter(r3);
        r1 = r3.mSubscribers;	 Catch:{ all -> 0x0027 }
        r1.clear();	 Catch:{ all -> 0x0027 }
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        return r0;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.AbstractDataSource.close():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void subscribe(com.facebook.datasource.DataSubscriber<T> r3, java.util.concurrent.Executor r4) {
        /*
        r2 = this;
        com.facebook.common.internal.Preconditions.checkNotNull(r3);
        com.facebook.common.internal.Preconditions.checkNotNull(r4);
        monitor-enter(r2);
        r0 = r2.mIsClosed;	 Catch:{ all -> 0x0041 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r2);	 Catch:{ all -> 0x0041 }
        return;
    L_0x000d:
        r0 = r2.mDataSourceStatus;	 Catch:{ all -> 0x0041 }
        r1 = com.facebook.datasource.AbstractDataSource.DataSourceStatus.IN_PROGRESS;	 Catch:{ all -> 0x0041 }
        if (r0 != r1) goto L_0x001c;
    L_0x0013:
        r0 = r2.mSubscribers;	 Catch:{ all -> 0x0041 }
        r1 = android.util.Pair.create(r3, r4);	 Catch:{ all -> 0x0041 }
        r0.add(r1);	 Catch:{ all -> 0x0041 }
    L_0x001c:
        r0 = r2.hasResult();	 Catch:{ all -> 0x0041 }
        if (r0 != 0) goto L_0x0031;
    L_0x0022:
        r0 = r2.isFinished();	 Catch:{ all -> 0x0041 }
        if (r0 != 0) goto L_0x0031;
    L_0x0028:
        r0 = r2.wasCancelled();	 Catch:{ all -> 0x0041 }
        if (r0 == 0) goto L_0x002f;
    L_0x002e:
        goto L_0x0031;
    L_0x002f:
        r0 = 0;
        goto L_0x0032;
    L_0x0031:
        r0 = 1;
    L_0x0032:
        monitor-exit(r2);	 Catch:{ all -> 0x0041 }
        if (r0 == 0) goto L_0x0040;
    L_0x0035:
        r0 = r2.hasFailed();
        r1 = r2.wasCancelled();
        r2.notifyDataSubscriber(r3, r4, r0, r1);
    L_0x0040:
        return;
    L_0x0041:
        r3 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0041 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.AbstractDataSource.subscribe(com.facebook.datasource.DataSubscriber, java.util.concurrent.Executor):void");
    }

    private void notifyDataSubscribers() {
        boolean hasFailed = hasFailed();
        boolean wasCancelled = wasCancelled();
        Iterator it = this.mSubscribers.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            notifyDataSubscriber((DataSubscriber) pair.first, (Executor) pair.second, hasFailed, wasCancelled);
        }
    }

    private void notifyDataSubscriber(final DataSubscriber<T> dataSubscriber, Executor executor, final boolean z, final boolean z2) {
        executor.execute(new Runnable() {
            public void run() {
                if (z) {
                    dataSubscriber.onFailure(AbstractDataSource.this);
                } else if (z2) {
                    dataSubscriber.onCancellation(AbstractDataSource.this);
                } else {
                    dataSubscriber.onNewResult(AbstractDataSource.this);
                }
            }
        });
    }

    private synchronized boolean wasCancelled() {
        boolean z;
        z = isClosed() && !isFinished();
        return z;
    }

    protected boolean setResult(T t, boolean z) {
        t = setResultInternal(t, z);
        if (t != null) {
            notifyDataSubscribers();
        }
        return t;
    }

    protected boolean setFailure(Throwable th) {
        th = setFailureInternal(th);
        if (th != null) {
            notifyDataSubscribers();
        }
        return th;
    }

    protected boolean setProgress(float f) {
        f = setProgressInternal(f);
        if (f != null) {
            notifyProgressUpdate();
        }
        return f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean setResultInternal(T r4, boolean r5) {
        /*
        r3 = this;
        r0 = 0;
        monitor-enter(r3);	 Catch:{ all -> 0x003c }
        r1 = r3.mIsClosed;	 Catch:{ all -> 0x0039 }
        if (r1 != 0) goto L_0x002d;
    L_0x0006:
        r1 = r3.mDataSourceStatus;	 Catch:{ all -> 0x0039 }
        r2 = com.facebook.datasource.AbstractDataSource.DataSourceStatus.IN_PROGRESS;	 Catch:{ all -> 0x0039 }
        if (r1 == r2) goto L_0x000d;
    L_0x000c:
        goto L_0x002d;
    L_0x000d:
        if (r5 == 0) goto L_0x0017;
    L_0x000f:
        r5 = com.facebook.datasource.AbstractDataSource.DataSourceStatus.SUCCESS;	 Catch:{ all -> 0x0039 }
        r3.mDataSourceStatus = r5;	 Catch:{ all -> 0x0039 }
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3.mProgress = r5;	 Catch:{ all -> 0x0039 }
    L_0x0017:
        r5 = r3.mResult;	 Catch:{ all -> 0x0039 }
        if (r5 == r4) goto L_0x0024;
    L_0x001b:
        r5 = r3.mResult;	 Catch:{ all -> 0x0039 }
        r3.mResult = r4;	 Catch:{ all -> 0x0021 }
        r4 = r5;
        goto L_0x0025;
    L_0x0021:
        r4 = move-exception;
        r0 = r5;
        goto L_0x003a;
    L_0x0024:
        r4 = r0;
    L_0x0025:
        r5 = 1;
        monitor-exit(r3);	 Catch:{ all -> 0x0035 }
        if (r4 == 0) goto L_0x002c;
    L_0x0029:
        r3.closeResult(r4);
    L_0x002c:
        return r5;
    L_0x002d:
        r5 = 0;
        monitor-exit(r3);	 Catch:{ all -> 0x0035 }
        if (r4 == 0) goto L_0x0034;
    L_0x0031:
        r3.closeResult(r4);
    L_0x0034:
        return r5;
    L_0x0035:
        r5 = move-exception;
        r0 = r4;
        r4 = r5;
        goto L_0x003a;
    L_0x0039:
        r4 = move-exception;
    L_0x003a:
        monitor-exit(r3);	 Catch:{ all -> 0x0039 }
        throw r4;	 Catch:{ all -> 0x003c }
    L_0x003c:
        r4 = move-exception;
        if (r0 == 0) goto L_0x0042;
    L_0x003f:
        r3.closeResult(r0);
    L_0x0042:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.AbstractDataSource.setResultInternal(java.lang.Object, boolean):boolean");
    }

    private synchronized boolean setFailureInternal(Throwable th) {
        if (!this.mIsClosed) {
            if (this.mDataSourceStatus == DataSourceStatus.IN_PROGRESS) {
                this.mDataSourceStatus = DataSourceStatus.FAILURE;
                this.mFailureThrowable = th;
                return true;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean setProgressInternal(float r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.mIsClosed;	 Catch:{ all -> 0x001c }
        r1 = 0;
        if (r0 != 0) goto L_0x001a;
    L_0x0006:
        r0 = r3.mDataSourceStatus;	 Catch:{ all -> 0x001c }
        r2 = com.facebook.datasource.AbstractDataSource.DataSourceStatus.IN_PROGRESS;	 Catch:{ all -> 0x001c }
        if (r0 == r2) goto L_0x000d;
    L_0x000c:
        goto L_0x001a;
    L_0x000d:
        r0 = r3.mProgress;	 Catch:{ all -> 0x001c }
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x0015;
    L_0x0013:
        monitor-exit(r3);
        return r1;
    L_0x0015:
        r3.mProgress = r4;	 Catch:{ all -> 0x001c }
        r4 = 1;
        monitor-exit(r3);
        return r4;
    L_0x001a:
        monitor-exit(r3);
        return r1;
    L_0x001c:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.AbstractDataSource.setProgressInternal(float):boolean");
    }

    protected void notifyProgressUpdate() {
        Iterator it = this.mSubscribers.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            final DataSubscriber dataSubscriber = (DataSubscriber) pair.first;
            ((Executor) pair.second).execute(new Runnable() {
                public void run() {
                    dataSubscriber.onProgressUpdate(AbstractDataSource.this);
                }
            });
        }
    }
}
