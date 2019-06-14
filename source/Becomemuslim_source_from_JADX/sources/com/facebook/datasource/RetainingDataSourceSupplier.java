package com.facebook.datasource;

import com.facebook.common.internal.Supplier;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class RetainingDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    private Supplier<DataSource<T>> mCurrentDataSourceSupplier = null;
    private final Set<RetainingDataSource> mDataSources = Collections.newSetFromMap(new WeakHashMap());

    private static class RetainingDataSource<T> extends AbstractDataSource<T> {
        private DataSource<T> mDataSource;

        private class InternalDataSubscriber implements DataSubscriber<T> {
            public void onCancellation(DataSource<T> dataSource) {
            }

            private InternalDataSubscriber() {
            }

            public void onNewResult(DataSource<T> dataSource) {
                if (dataSource.hasResult()) {
                    RetainingDataSource.this.onDataSourceNewResult(dataSource);
                } else if (dataSource.isFinished()) {
                    RetainingDataSource.this.onDataSourceFailed(dataSource);
                }
            }

            public void onFailure(DataSource<T> dataSource) {
                RetainingDataSource.this.onDataSourceFailed(dataSource);
            }

            public void onProgressUpdate(DataSource<T> dataSource) {
                RetainingDataSource.this.onDatasourceProgress(dataSource);
            }
        }

        private void onDataSourceFailed(DataSource<T> dataSource) {
        }

        private RetainingDataSource() {
            this.mDataSource = null;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void setSupplier(com.facebook.common.internal.Supplier<com.facebook.datasource.DataSource<T>> r4) {
            /*
            r3 = this;
            r0 = r3.isClosed();
            if (r0 == 0) goto L_0x0007;
        L_0x0006:
            return;
        L_0x0007:
            r0 = 0;
            if (r4 == 0) goto L_0x0011;
        L_0x000a:
            r4 = r4.get();
            r4 = (com.facebook.datasource.DataSource) r4;
            goto L_0x0012;
        L_0x0011:
            r4 = r0;
        L_0x0012:
            monitor-enter(r3);
            r1 = r3.isClosed();	 Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x001e;
        L_0x0019:
            closeSafely(r4);	 Catch:{ all -> 0x0035 }
            monitor-exit(r3);	 Catch:{ all -> 0x0035 }
            return;
        L_0x001e:
            r1 = r3.mDataSource;	 Catch:{ all -> 0x0035 }
            r3.mDataSource = r4;	 Catch:{ all -> 0x0035 }
            monitor-exit(r3);	 Catch:{ all -> 0x0035 }
            if (r4 == 0) goto L_0x0031;
        L_0x0025:
            r2 = new com.facebook.datasource.RetainingDataSourceSupplier$RetainingDataSource$InternalDataSubscriber;
            r2.<init>();
            r0 = com.facebook.common.executors.CallerThreadExecutor.getInstance();
            r4.subscribe(r2, r0);
        L_0x0031:
            closeSafely(r1);
            return;
        L_0x0035:
            r4 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0035 }
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.RetainingDataSourceSupplier.RetainingDataSource.setSupplier(com.facebook.common.internal.Supplier):void");
        }

        public synchronized T getResult() {
            return this.mDataSource != null ? this.mDataSource.getResult() : null;
        }

        public synchronized boolean hasResult() {
            boolean z;
            z = this.mDataSource != null && this.mDataSource.hasResult();
            return z;
        }

        public boolean close() {
            synchronized (this) {
                if (super.close()) {
                    DataSource dataSource = this.mDataSource;
                    this.mDataSource = null;
                    closeSafely(dataSource);
                    return true;
                }
                return false;
            }
        }

        private void onDataSourceNewResult(DataSource<T> dataSource) {
            if (dataSource == this.mDataSource) {
                setResult(null, false);
            }
        }

        private void onDatasourceProgress(DataSource<T> dataSource) {
            if (dataSource == this.mDataSource) {
                setProgress(dataSource.getProgress());
            }
        }

        private static <T> void closeSafely(DataSource<T> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
        }
    }

    public DataSource<T> get() {
        DataSource retainingDataSource = new RetainingDataSource();
        retainingDataSource.setSupplier(this.mCurrentDataSourceSupplier);
        this.mDataSources.add(retainingDataSource);
        return retainingDataSource;
    }

    public void replaceSupplier(Supplier<DataSource<T>> supplier) {
        this.mCurrentDataSourceSupplier = supplier;
        for (RetainingDataSource retainingDataSource : this.mDataSources) {
            if (!retainingDataSource.isClosed()) {
                retainingDataSource.setSupplier(supplier);
            }
        }
    }
}
