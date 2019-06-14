package com.facebook.datasource;

import com.facebook.common.internal.Supplier;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class DataSources {

    /* renamed from: com.facebook.datasource.DataSources$3 */
    static class C17383 implements Executor {
        C17383() {
        }

        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    private static class ValueHolder<T> {
        public T value;

        private ValueHolder() {
            this.value = null;
        }
    }

    private DataSources() {
    }

    public static <T> DataSource<T> immediateFailedDataSource(Throwable th) {
        DataSource create = SimpleDataSource.create();
        create.setFailure(th);
        return create;
    }

    public static <T> DataSource<T> immediateDataSource(T t) {
        DataSource create = SimpleDataSource.create();
        create.setResult(t);
        return create;
    }

    public static <T> Supplier<DataSource<T>> getFailedDataSourceSupplier(final Throwable th) {
        return new Supplier<DataSource<T>>() {
            public DataSource<T> get() {
                return DataSources.immediateFailedDataSource(th);
            }
        };
    }

    public static <T> T waitForFinalResult(DataSource<T> dataSource) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ValueHolder valueHolder = new ValueHolder();
        final ValueHolder valueHolder2 = new ValueHolder();
        dataSource.subscribe(new DataSubscriber<T>() {
            public void onProgressUpdate(DataSource<T> dataSource) {
            }

            public void onNewResult(DataSource<T> dataSource) {
                if (dataSource.isFinished()) {
                    try {
                        valueHolder.value = dataSource.getResult();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }

            public void onFailure(DataSource<T> dataSource) {
                try {
                    valueHolder2.value = dataSource.getFailureCause();
                } finally {
                    countDownLatch.countDown();
                }
            }

            public void onCancellation(DataSource<T> dataSource) {
                countDownLatch.countDown();
            }
        }, new C17383());
        countDownLatch.await();
        if (valueHolder2.value == null) {
            return valueHolder.value;
        }
        throw ((Throwable) valueHolder2.value);
    }
}
