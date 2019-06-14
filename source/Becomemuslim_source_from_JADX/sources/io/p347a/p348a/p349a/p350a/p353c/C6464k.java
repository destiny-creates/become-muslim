package io.p347a.p348a.p349a.p350a.p353c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: PriorityThreadPoolExecutor */
/* renamed from: io.a.a.a.a.c.k */
public class C6464k extends ThreadPoolExecutor {
    /* renamed from: a */
    private static final int f20863a = Runtime.getRuntime().availableProcessors();
    /* renamed from: b */
    private static final int f20864b = (f20863a + 1);
    /* renamed from: c */
    private static final int f20865c = ((f20863a * 2) + 1);

    /* compiled from: PriorityThreadPoolExecutor */
    /* renamed from: io.a.a.a.a.c.k$a */
    protected static final class C6463a implements ThreadFactory {
        /* renamed from: a */
        private final int f20862a;

        public C6463a(int i) {
            this.f20862a = i;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(this.f20862a);
            thread.setName("Queue");
            return thread;
        }
    }

    public /* synthetic */ BlockingQueue getQueue() {
        return m26489b();
    }

    <T extends Runnable & C6457b & C6465l & C6462i> C6464k(int i, int i2, long j, TimeUnit timeUnit, C6458c<T> c6458c, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, c6458c, threadFactory);
        prestartAllCoreThreads();
    }

    /* renamed from: a */
    public static <T extends Runnable & C6457b & C6465l & C6462i> C6464k m26488a(int i, int i2) {
        return new C6464k(i, i2, 1, TimeUnit.SECONDS, new C6458c(), new C6463a(10));
    }

    /* renamed from: a */
    public static C6464k m26487a() {
        return C6464k.m26488a(f20864b, f20865c);
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C7612h(runnable, t);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C7612h(callable);
    }

    public void execute(Runnable runnable) {
        if (C7613j.m34366a((Object) runnable)) {
            super.execute(runnable);
        } else {
            super.execute(newTaskFor(runnable, null));
        }
    }

    protected void afterExecute(Runnable runnable, Throwable th) {
        C6465l c6465l = (C6465l) runnable;
        c6465l.mo5442b(true);
        c6465l.mo5440a(th);
        m26489b().m26482d();
        super.afterExecute(runnable, th);
    }

    /* renamed from: b */
    public C6458c m26489b() {
        return (C6458c) super.getQueue();
    }
}
