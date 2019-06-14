package com.bugsnag.android;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Async */
/* renamed from: com.bugsnag.android.b */
class C1076b {
    /* renamed from: a */
    static final BlockingQueue<Runnable> f3029a = new LinkedBlockingQueue(128);
    /* renamed from: b */
    private static final int f3030b = Runtime.getRuntime().availableProcessors();
    /* renamed from: c */
    private static final int f3031c = Math.max(1, Math.min(f3030b - 1, 4));
    /* renamed from: d */
    private static final int f3032d = ((f3030b * 2) + 1);
    /* renamed from: e */
    private static final ThreadFactory f3033e = new C10751();
    /* renamed from: f */
    private static final ThreadPoolExecutor f3034f = new ThreadPoolExecutor(f3031c, f3032d, 30, TimeUnit.SECONDS, f3029a, f3033e);

    /* compiled from: Async */
    /* renamed from: com.bugsnag.android.b$1 */
    static class C10751 implements ThreadFactory {
        /* renamed from: a */
        private final AtomicInteger f3028a = new AtomicInteger(1);

        C10751() {
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Bugsnag Thread #");
            stringBuilder.append(this.f3028a.getAndIncrement());
            return new Thread(runnable, stringBuilder.toString());
        }
    }

    /* renamed from: a */
    static void m3764a(Runnable runnable) {
        f3034f.execute(runnable);
    }
}
