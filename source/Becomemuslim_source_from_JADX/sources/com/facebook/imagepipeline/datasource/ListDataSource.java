package com.facebook.imagepipeline.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSubscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;

public class ListDataSource<T> extends AbstractDataSource<List<CloseableReference<T>>> {
    private final DataSource<CloseableReference<T>>[] mDataSources;
    private int mFinishedDataSources = null;

    private class InternalDataSubscriber implements DataSubscriber<CloseableReference<T>> {
        boolean mFinished;

        private InternalDataSubscriber() {
            this.mFinished = null;
        }

        private synchronized boolean tryFinish() {
            if (this.mFinished) {
                return false;
            }
            this.mFinished = true;
            return true;
        }

        public void onFailure(DataSource<CloseableReference<T>> dataSource) {
            ListDataSource.this.onDataSourceFailed(dataSource);
        }

        public void onCancellation(DataSource<CloseableReference<T>> dataSource) {
            ListDataSource.this.onDataSourceCancelled();
        }

        public void onNewResult(DataSource<CloseableReference<T>> dataSource) {
            if (dataSource.isFinished() != null && tryFinish() != null) {
                ListDataSource.this.onDataSourceFinished();
            }
        }

        public void onProgressUpdate(DataSource<CloseableReference<T>> dataSource) {
            ListDataSource.this.onDataSourceProgress();
        }
    }

    protected ListDataSource(DataSource<CloseableReference<T>>[] dataSourceArr) {
        this.mDataSources = dataSourceArr;
    }

    public static <T> ListDataSource<T> create(DataSource<CloseableReference<T>>... dataSourceArr) {
        Preconditions.checkNotNull(dataSourceArr);
        Preconditions.checkState(dataSourceArr.length > 0);
        ListDataSource<T> listDataSource = new ListDataSource(dataSourceArr);
        for (DataSource dataSource : dataSourceArr) {
            if (dataSource != null) {
                listDataSource.getClass();
                dataSource.subscribe(new InternalDataSubscriber(), CallerThreadExecutor.getInstance());
            }
        }
        return listDataSource;
    }

    public synchronized List<CloseableReference<T>> getResult() {
        if (!hasResult()) {
            return null;
        }
        List<CloseableReference<T>> arrayList = new ArrayList(this.mDataSources.length);
        for (DataSource result : this.mDataSources) {
            arrayList.add(result.getResult());
        }
        return arrayList;
    }

    public synchronized boolean hasResult() {
        boolean z;
        z = !isClosed() && this.mFinishedDataSources == this.mDataSources.length;
        return z;
    }

    public boolean close() {
        int i = 0;
        if (!super.close()) {
            return false;
        }
        DataSource[] dataSourceArr = this.mDataSources;
        int length = dataSourceArr.length;
        while (i < length) {
            dataSourceArr[i].close();
            i++;
        }
        return true;
    }

    private void onDataSourceFinished() {
        if (increaseAndCheckIfLast()) {
            setResult(null, true);
        }
    }

    private synchronized boolean increaseAndCheckIfLast() {
        boolean z;
        z = true;
        int i = this.mFinishedDataSources + 1;
        this.mFinishedDataSources = i;
        if (i != this.mDataSources.length) {
            z = false;
        }
        return z;
    }

    private void onDataSourceFailed(DataSource<CloseableReference<T>> dataSource) {
        setFailure(dataSource.getFailureCause());
    }

    private void onDataSourceCancelled() {
        setFailure(new CancellationException());
    }

    private void onDataSourceProgress() {
        float f = 0.0f;
        for (DataSource progress : this.mDataSources) {
            f += progress.getProgress();
        }
        setProgress(f / ((float) this.mDataSources.length));
    }
}
