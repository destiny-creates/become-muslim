package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.List;

public class FirstAvailableDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    private final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

    private class FirstAvailableDataSource extends AbstractDataSource<T> {
        private DataSource<T> mCurrentDataSource = null;
        private DataSource<T> mDataSourceWithResult = null;
        private int mIndex = null;

        private class InternalDataSubscriber implements DataSubscriber<T> {
            public void onCancellation(DataSource<T> dataSource) {
            }

            private InternalDataSubscriber() {
            }

            public void onFailure(DataSource<T> dataSource) {
                FirstAvailableDataSource.this.onDataSourceFailed(dataSource);
            }

            public void onNewResult(DataSource<T> dataSource) {
                if (dataSource.hasResult()) {
                    FirstAvailableDataSource.this.onDataSourceNewResult(dataSource);
                } else if (dataSource.isFinished()) {
                    FirstAvailableDataSource.this.onDataSourceFailed(dataSource);
                }
            }

            public void onProgressUpdate(DataSource<T> dataSource) {
                FirstAvailableDataSource.this.setProgress(Math.max(FirstAvailableDataSource.this.getProgress(), dataSource.getProgress()));
            }
        }

        public FirstAvailableDataSource() {
            if (startNextDataSource() == null) {
                setFailure(new RuntimeException("No data source supplier or supplier returned null."));
            }
        }

        public synchronized T getResult() {
            DataSource dataSourceWithResult;
            dataSourceWithResult = getDataSourceWithResult();
            return dataSourceWithResult != null ? dataSourceWithResult.getResult() : null;
        }

        public synchronized boolean hasResult() {
            boolean z;
            DataSource dataSourceWithResult = getDataSourceWithResult();
            z = dataSourceWithResult != null && dataSourceWithResult.hasResult();
            return z;
        }

        public boolean close() {
            synchronized (this) {
                if (super.close()) {
                    DataSource dataSource = this.mCurrentDataSource;
                    this.mCurrentDataSource = null;
                    DataSource dataSource2 = this.mDataSourceWithResult;
                    this.mDataSourceWithResult = null;
                    closeSafely(dataSource2);
                    closeSafely(dataSource);
                    return true;
                }
                return false;
            }
        }

        private boolean startNextDataSource() {
            Supplier nextSupplier = getNextSupplier();
            DataSource dataSource = nextSupplier != null ? (DataSource) nextSupplier.get() : null;
            if (!setCurrentDataSource(dataSource) || dataSource == null) {
                closeSafely(dataSource);
                return false;
            }
            dataSource.subscribe(new InternalDataSubscriber(), CallerThreadExecutor.getInstance());
            return true;
        }

        private synchronized Supplier<DataSource<T>> getNextSupplier() {
            if (isClosed() || this.mIndex >= FirstAvailableDataSourceSupplier.this.mDataSourceSuppliers.size()) {
                return null;
            }
            List access$100 = FirstAvailableDataSourceSupplier.this.mDataSourceSuppliers;
            int i = this.mIndex;
            this.mIndex = i + 1;
            return (Supplier) access$100.get(i);
        }

        private synchronized boolean setCurrentDataSource(DataSource<T> dataSource) {
            if (isClosed()) {
                return null;
            }
            this.mCurrentDataSource = dataSource;
            return true;
        }

        private synchronized boolean clearCurrentDataSource(DataSource<T> dataSource) {
            if (!isClosed()) {
                if (dataSource == this.mCurrentDataSource) {
                    this.mCurrentDataSource = null;
                    return true;
                }
            }
            return null;
        }

        private synchronized DataSource<T> getDataSourceWithResult() {
            return this.mDataSourceWithResult;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void maybeSetDataSourceWithResult(com.facebook.datasource.DataSource<T> r2, boolean r3) {
            /*
            r1 = this;
            monitor-enter(r1);
            r0 = r1.mCurrentDataSource;	 Catch:{ all -> 0x001f }
            if (r2 != r0) goto L_0x001d;
        L_0x0005:
            r0 = r1.mDataSourceWithResult;	 Catch:{ all -> 0x001f }
            if (r2 != r0) goto L_0x000a;
        L_0x0009:
            goto L_0x001d;
        L_0x000a:
            r0 = r1.mDataSourceWithResult;	 Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x0013;
        L_0x000e:
            if (r3 == 0) goto L_0x0011;
        L_0x0010:
            goto L_0x0013;
        L_0x0011:
            r2 = 0;
            goto L_0x0018;
        L_0x0013:
            r3 = r1.mDataSourceWithResult;	 Catch:{ all -> 0x001f }
            r1.mDataSourceWithResult = r2;	 Catch:{ all -> 0x001f }
            r2 = r3;
        L_0x0018:
            monitor-exit(r1);	 Catch:{ all -> 0x001f }
            r1.closeSafely(r2);
            return;
        L_0x001d:
            monitor-exit(r1);	 Catch:{ all -> 0x001f }
            return;
        L_0x001f:
            r2 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x001f }
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.FirstAvailableDataSourceSupplier.FirstAvailableDataSource.maybeSetDataSourceWithResult(com.facebook.datasource.DataSource, boolean):void");
        }

        private void onDataSourceFailed(DataSource<T> dataSource) {
            if (clearCurrentDataSource(dataSource)) {
                if (dataSource != getDataSourceWithResult()) {
                    closeSafely(dataSource);
                }
                if (!startNextDataSource()) {
                    setFailure(dataSource.getFailureCause());
                }
            }
        }

        private void onDataSourceNewResult(DataSource<T> dataSource) {
            maybeSetDataSourceWithResult(dataSource, dataSource.isFinished());
            if (dataSource == getDataSourceWithResult()) {
                setResult(null, dataSource.isFinished());
            }
        }

        private void closeSafely(DataSource<T> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
        }
    }

    private FirstAvailableDataSourceSupplier(List<Supplier<DataSource<T>>> list) {
        Preconditions.checkArgument(list.isEmpty() ^ 1, "List of suppliers is empty!");
        this.mDataSourceSuppliers = list;
    }

    public static <T> FirstAvailableDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> list) {
        return new FirstAvailableDataSourceSupplier(list);
    }

    public DataSource<T> get() {
        return new FirstAvailableDataSource();
    }

    public int hashCode() {
        return this.mDataSourceSuppliers.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirstAvailableDataSourceSupplier)) {
            return null;
        }
        return Objects.equal(this.mDataSourceSuppliers, ((FirstAvailableDataSourceSupplier) obj).mDataSourceSuppliers);
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("list", this.mDataSourceSuppliers).toString();
    }
}
