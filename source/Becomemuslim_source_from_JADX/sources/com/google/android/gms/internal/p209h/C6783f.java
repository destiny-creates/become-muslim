package com.google.android.gms.internal.p209h;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.h.f */
final class C6783f implements C4979c {
    private C6783f() {
    }

    /* renamed from: b */
    public final ExecutorService m31294b(int i, ThreadFactory threadFactory, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(1);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    /* renamed from: a */
    public final ExecutorService mo4408a(ThreadFactory threadFactory, int i) {
        return m31294b(1, threadFactory, 9);
    }

    /* renamed from: a */
    public final ScheduledExecutorService mo4409a(int i, ThreadFactory threadFactory, int i2) {
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, threadFactory));
    }
}
