package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IncreasingQualityDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    private final boolean mDataSourceLazy;
    private final List<Supplier<DataSource<T>>> mDataSourceSuppliers;

    private class IncreasingQualityDataSource extends AbstractDataSource<T> {
        private ArrayList<DataSource<T>> mDataSources;
        private Throwable mDelayedError;
        private AtomicInteger mFinishedDataSources;
        private int mIndexOfDataSourceWithResult;
        private int mNumberOfDataSources;

        private class InternalDataSubscriber implements DataSubscriber<T> {
            private int mIndex;

            public void onCancellation(DataSource<T> dataSource) {
            }

            public InternalDataSubscriber(int i) {
                this.mIndex = i;
            }

            public void onNewResult(DataSource<T> dataSource) {
                if (dataSource.hasResult()) {
                    IncreasingQualityDataSource.this.onDataSourceNewResult(this.mIndex, dataSource);
                } else if (dataSource.isFinished()) {
                    IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, dataSource);
                }
            }

            public void onFailure(DataSource<T> dataSource) {
                IncreasingQualityDataSource.this.onDataSourceFailed(this.mIndex, dataSource);
            }

            public void onProgressUpdate(DataSource<T> dataSource) {
                if (this.mIndex == 0) {
                    IncreasingQualityDataSource.this.setProgress(dataSource.getProgress());
                }
            }
        }

        public IncreasingQualityDataSource() {
            if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy == null) {
                ensureDataSourceInitialized();
            }
        }

        private void ensureDataSourceInitialized() {
            if (this.mFinishedDataSources == null) {
                synchronized (this) {
                    if (this.mFinishedDataSources == null) {
                        int i = 0;
                        this.mFinishedDataSources = new AtomicInteger(0);
                        int size = IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.size();
                        this.mNumberOfDataSources = size;
                        this.mIndexOfDataSourceWithResult = size;
                        this.mDataSources = new ArrayList(size);
                        while (i < size) {
                            DataSource dataSource = (DataSource) ((Supplier) IncreasingQualityDataSourceSupplier.this.mDataSourceSuppliers.get(i)).get();
                            this.mDataSources.add(dataSource);
                            dataSource.subscribe(new InternalDataSubscriber(i), CallerThreadExecutor.getInstance());
                            if (dataSource.hasResult()) {
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
        }

        private synchronized DataSource<T> getDataSource(int i) {
            i = (this.mDataSources == null || i >= this.mDataSources.size()) ? 0 : (DataSource) this.mDataSources.get(i);
            return i;
        }

        private synchronized DataSource<T> getAndClearDataSource(int i) {
            DataSource<T> dataSource;
            dataSource = null;
            if (this.mDataSources != null && i < this.mDataSources.size()) {
                dataSource = (DataSource) this.mDataSources.set(i, null);
            }
            return dataSource;
        }

        private synchronized DataSource<T> getDataSourceWithResult() {
            return getDataSource(this.mIndexOfDataSourceWithResult);
        }

        public synchronized T getResult() {
            T result;
            if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
            DataSource dataSourceWithResult = getDataSourceWithResult();
            if (dataSourceWithResult != null) {
                result = dataSourceWithResult.getResult();
            } else {
                result = null;
            }
            return result;
        }

        public synchronized boolean hasResult() {
            boolean z;
            if (IncreasingQualityDataSourceSupplier.this.mDataSourceLazy) {
                ensureDataSourceInitialized();
            }
            DataSource dataSourceWithResult = getDataSourceWithResult();
            z = dataSourceWithResult != null && dataSourceWithResult.hasResult();
            return z;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean close() {
            /*
            r3 = this;
            r0 = com.facebook.datasource.IncreasingQualityDataSourceSupplier.this;
            r0 = r0.mDataSourceLazy;
            if (r0 == 0) goto L_0x000b;
        L_0x0008:
            r3.ensureDataSourceInitialized();
        L_0x000b:
            monitor-enter(r3);
            r0 = super.close();	 Catch:{ all -> 0x0031 }
            r1 = 0;
            if (r0 != 0) goto L_0x0015;
        L_0x0013:
            monitor-exit(r3);	 Catch:{ all -> 0x0031 }
            return r1;
        L_0x0015:
            r0 = r3.mDataSources;	 Catch:{ all -> 0x0031 }
            r2 = 0;
            r3.mDataSources = r2;	 Catch:{ all -> 0x0031 }
            monitor-exit(r3);	 Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x002f;
        L_0x001d:
            r2 = r0.size();
            if (r1 >= r2) goto L_0x002f;
        L_0x0023:
            r2 = r0.get(r1);
            r2 = (com.facebook.datasource.DataSource) r2;
            r3.closeSafely(r2);
            r1 = r1 + 1;
            goto L_0x001d;
        L_0x002f:
            r0 = 1;
            return r0;
        L_0x0031:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0031 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.close():boolean");
        }

        private void onDataSourceNewResult(int i, DataSource<T> dataSource) {
            maybeSetIndexOfDataSourceWithResult(i, dataSource, dataSource.isFinished());
            if (dataSource == getDataSourceWithResult()) {
                i = (i != 0 || dataSource.isFinished() == 0) ? 0 : 1;
                setResult(null, i);
            }
            maybeSetFailure();
        }

        private void onDataSourceFailed(int i, DataSource<T> dataSource) {
            closeSafely(tryGetAndClearDataSource(i, dataSource));
            if (i == 0) {
                this.mDelayedError = dataSource.getFailureCause();
            }
            maybeSetFailure();
        }

        private void maybeSetFailure() {
            if (this.mFinishedDataSources.incrementAndGet() == this.mNumberOfDataSources && this.mDelayedError != null) {
                setFailure(this.mDelayedError);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void maybeSetIndexOfDataSourceWithResult(int r4, com.facebook.datasource.DataSource<T> r5, boolean r6) {
            /*
            r3 = this;
            monitor-enter(r3);
            r0 = r3.mIndexOfDataSourceWithResult;	 Catch:{ all -> 0x0031 }
            r1 = r3.mIndexOfDataSourceWithResult;	 Catch:{ all -> 0x0031 }
            r2 = r3.getDataSource(r4);	 Catch:{ all -> 0x0031 }
            if (r5 != r2) goto L_0x002f;
        L_0x000b:
            r5 = r3.mIndexOfDataSourceWithResult;	 Catch:{ all -> 0x0031 }
            if (r4 != r5) goto L_0x0010;
        L_0x000f:
            goto L_0x002f;
        L_0x0010:
            r5 = r3.getDataSourceWithResult();	 Catch:{ all -> 0x0031 }
            if (r5 == 0) goto L_0x001f;
        L_0x0016:
            if (r6 == 0) goto L_0x001d;
        L_0x0018:
            r5 = r3.mIndexOfDataSourceWithResult;	 Catch:{ all -> 0x0031 }
            if (r4 >= r5) goto L_0x001d;
        L_0x001c:
            goto L_0x001f;
        L_0x001d:
            r4 = r1;
            goto L_0x0021;
        L_0x001f:
            r3.mIndexOfDataSourceWithResult = r4;	 Catch:{ all -> 0x0031 }
        L_0x0021:
            monitor-exit(r3);	 Catch:{ all -> 0x0031 }
        L_0x0022:
            if (r0 <= r4) goto L_0x002e;
        L_0x0024:
            r5 = r3.getAndClearDataSource(r0);
            r3.closeSafely(r5);
            r0 = r0 + -1;
            goto L_0x0022;
        L_0x002e:
            return;
        L_0x002f:
            monitor-exit(r3);	 Catch:{ all -> 0x0031 }
            return;
        L_0x0031:
            r4 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x0031 }
            throw r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.datasource.IncreasingQualityDataSourceSupplier.IncreasingQualityDataSource.maybeSetIndexOfDataSourceWithResult(int, com.facebook.datasource.DataSource, boolean):void");
        }

        private synchronized DataSource<T> tryGetAndClearDataSource(int i, DataSource<T> dataSource) {
            if (dataSource == getDataSourceWithResult()) {
                return 0;
            }
            if (dataSource != getDataSource(i)) {
                return dataSource;
            }
            return getAndClearDataSource(i);
        }

        private void closeSafely(DataSource<T> dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
        }
    }

    private IncreasingQualityDataSourceSupplier(List<Supplier<DataSource<T>>> list, boolean z) {
        Preconditions.checkArgument(list.isEmpty() ^ 1, "List of suppliers is empty!");
        this.mDataSourceSuppliers = list;
        this.mDataSourceLazy = z;
    }

    public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> list) {
        return create(list, false);
    }

    public static <T> IncreasingQualityDataSourceSupplier<T> create(List<Supplier<DataSource<T>>> list, boolean z) {
        return new IncreasingQualityDataSourceSupplier(list, z);
    }

    public DataSource<T> get() {
        return new IncreasingQualityDataSource();
    }

    public int hashCode() {
        return this.mDataSourceSuppliers.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IncreasingQualityDataSourceSupplier)) {
            return null;
        }
        return Objects.equal(this.mDataSourceSuppliers, ((IncreasingQualityDataSourceSupplier) obj).mDataSourceSuppliers);
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("list", this.mDataSourceSuppliers).toString();
    }
}
