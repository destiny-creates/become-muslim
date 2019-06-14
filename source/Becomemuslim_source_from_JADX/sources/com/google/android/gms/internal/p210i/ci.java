package com.google.android.gms.internal.p210i;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.i.ci */
final class ci implements cf {
    private ci() {
    }

    /* renamed from: a */
    public final ExecutorService mo4423a(int i) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    /* renamed from: a */
    public final ScheduledExecutorService mo4424a(int i, int i2) {
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
    }
}
