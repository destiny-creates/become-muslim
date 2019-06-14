package io.p347a.p348a.p349a.p350a.p352b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ExecutorUtils */
/* renamed from: io.a.a.a.a.b.n */
public final class C6434n {
    /* renamed from: a */
    public static ExecutorService m26396a(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(C6434n.m26400c(str));
        C6434n.m26397a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    /* renamed from: b */
    public static ScheduledExecutorService m26399b(String str) {
        Object newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(C6434n.m26400c(str));
        C6434n.m26397a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    /* renamed from: c */
    public static final ThreadFactory m26400c(final String str) {
        final AtomicLong atomicLong = new AtomicLong(1);
        return new ThreadFactory() {
            public Thread newThread(final Runnable runnable) {
                runnable = Executors.defaultThreadFactory().newThread(new C6425h(this) {
                    /* renamed from: b */
                    final /* synthetic */ C64331 f26299b;

                    /* renamed from: a */
                    public void mo5434a() {
                        runnable.run();
                    }
                });
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(atomicLong.getAndIncrement());
                runnable.setName(stringBuilder.toString());
                return runnable;
            }
        };
    }

    /* renamed from: a */
    private static final void m26397a(String str, ExecutorService executorService) {
        C6434n.m26398a(str, executorService, 2, TimeUnit.SECONDS);
    }

    /* renamed from: a */
    public static final void m26398a(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        final String str2 = str;
        final ExecutorService executorService2 = executorService;
        final long j2 = j;
        final TimeUnit timeUnit2 = timeUnit;
        Runnable c76042 = new C6425h() {
            /* renamed from: a */
            public void mo5434a() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r7 = this;
                r0 = io.p347a.p348a.p349a.C6514c.m26634h();	 Catch:{ InterruptedException -> 0x0054 }
                r1 = "Fabric";	 Catch:{ InterruptedException -> 0x0054 }
                r2 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x0054 }
                r2.<init>();	 Catch:{ InterruptedException -> 0x0054 }
                r3 = "Executing shutdown hook for ";	 Catch:{ InterruptedException -> 0x0054 }
                r2.append(r3);	 Catch:{ InterruptedException -> 0x0054 }
                r3 = r3;	 Catch:{ InterruptedException -> 0x0054 }
                r2.append(r3);	 Catch:{ InterruptedException -> 0x0054 }
                r2 = r2.toString();	 Catch:{ InterruptedException -> 0x0054 }
                r0.mo5472a(r1, r2);	 Catch:{ InterruptedException -> 0x0054 }
                r0 = r4;	 Catch:{ InterruptedException -> 0x0054 }
                r0.shutdown();	 Catch:{ InterruptedException -> 0x0054 }
                r0 = r4;	 Catch:{ InterruptedException -> 0x0054 }
                r1 = r5;	 Catch:{ InterruptedException -> 0x0054 }
                r3 = r7;	 Catch:{ InterruptedException -> 0x0054 }
                r0 = r0.awaitTermination(r1, r3);	 Catch:{ InterruptedException -> 0x0054 }
                if (r0 != 0) goto L_0x0072;	 Catch:{ InterruptedException -> 0x0054 }
            L_0x002d:
                r0 = io.p347a.p348a.p349a.C6514c.m26634h();	 Catch:{ InterruptedException -> 0x0054 }
                r1 = "Fabric";	 Catch:{ InterruptedException -> 0x0054 }
                r2 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x0054 }
                r2.<init>();	 Catch:{ InterruptedException -> 0x0054 }
                r3 = r3;	 Catch:{ InterruptedException -> 0x0054 }
                r2.append(r3);	 Catch:{ InterruptedException -> 0x0054 }
                r3 = " did not shut down in the";	 Catch:{ InterruptedException -> 0x0054 }
                r2.append(r3);	 Catch:{ InterruptedException -> 0x0054 }
                r3 = " allocated time. Requesting immediate shutdown.";	 Catch:{ InterruptedException -> 0x0054 }
                r2.append(r3);	 Catch:{ InterruptedException -> 0x0054 }
                r2 = r2.toString();	 Catch:{ InterruptedException -> 0x0054 }
                r0.mo5472a(r1, r2);	 Catch:{ InterruptedException -> 0x0054 }
                r0 = r4;	 Catch:{ InterruptedException -> 0x0054 }
                r0.shutdownNow();	 Catch:{ InterruptedException -> 0x0054 }
                goto L_0x0072;
            L_0x0054:
                r0 = io.p347a.p348a.p349a.C6514c.m26634h();
                r1 = "Fabric";
                r2 = java.util.Locale.US;
                r3 = "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.";
                r4 = 1;
                r4 = new java.lang.Object[r4];
                r5 = 0;
                r6 = r3;
                r4[r5] = r6;
                r2 = java.lang.String.format(r2, r3, r4);
                r0.mo5472a(r1, r2);
                r0 = r4;
                r0.shutdownNow();
            L_0x0072:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.b.n.2.a():void");
            }
        };
        executorService = new StringBuilder();
        executorService.append("Crashlytics Shutdown Hook for ");
        executorService.append(str);
        runtime.addShutdownHook(new Thread(c76042, executorService.toString()));
    }
}
