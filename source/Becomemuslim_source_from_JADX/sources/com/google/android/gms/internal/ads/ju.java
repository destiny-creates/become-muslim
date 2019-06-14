package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@cm
public final class ju {
    /* renamed from: a */
    public static final nt f15687a = nu.m19956a(new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10, TimeUnit.SECONDS, new SynchronousQueue(), m19680a("Default")));
    /* renamed from: b */
    private static final nt f15688b;

    static {
        Executor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), m19680a("Loader"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f15688b = nu.m19956a(threadPoolExecutor);
    }

    /* renamed from: a */
    public static no<?> m19678a(Runnable runnable) {
        return f15687a.mo4317a(runnable);
    }

    /* renamed from: a */
    public static <T> no<T> m19679a(Callable<T> callable) {
        return f15687a.mo4318a((Callable) callable);
    }

    /* renamed from: a */
    private static ThreadFactory m19680a(String str) {
        return new jv(str);
    }

    /* renamed from: b */
    public static no<?> m19681b(Runnable runnable) {
        return f15688b.mo4317a(runnable);
    }
}
