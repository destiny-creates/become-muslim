package p289e.p292c.p294c;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: GenericScheduledExecutorService */
/* renamed from: e.c.c.d */
public final class C7295d implements C5948k {
    /* renamed from: a */
    public static final C7295d f25665a = new C7295d();
    /* renamed from: b */
    private static final ScheduledExecutorService[] f25666b = new ScheduledExecutorService[0];
    /* renamed from: c */
    private static final ScheduledExecutorService f25667c = Executors.newScheduledThreadPool(0);
    /* renamed from: e */
    private static int f25668e;
    /* renamed from: d */
    private final AtomicReference<ScheduledExecutorService[]> f25669d = new AtomicReference(f25666b);

    static {
        f25667c.shutdown();
    }

    private C7295d() {
        m33619a();
    }

    /* renamed from: a */
    public void m33619a() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 4) {
            availableProcessors /= 2;
        }
        if (availableProcessors > 8) {
            availableProcessors = 8;
        }
        Object obj = new ScheduledExecutorService[availableProcessors];
        int i = 0;
        for (int i2 = 0; i2 < availableProcessors; i2++) {
            obj[i2] = C5944e.m24865b();
        }
        if (this.f25669d.compareAndSet(f25666b, obj)) {
            availableProcessors = obj.length;
            while (i < availableProcessors) {
                ScheduledExecutorService scheduledExecutorService = obj[i];
                if (!C8134h.m39500b(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                    C8134h.m39499a((ScheduledThreadPoolExecutor) scheduledExecutorService);
                }
                i++;
            }
            return;
        }
        availableProcessors = obj.length;
        while (i < availableProcessors) {
            obj[i].shutdownNow();
            i++;
        }
    }

    /* renamed from: d */
    public void mo5128d() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        do {
            scheduledExecutorServiceArr = (ScheduledExecutorService[]) this.f25669d.get();
            if (scheduledExecutorServiceArr == f25666b) {
                return;
            }
        } while (!this.f25669d.compareAndSet(scheduledExecutorServiceArr, f25666b));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            C8134h.m39498a(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    /* renamed from: b */
    public static ScheduledExecutorService m33618b() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = (ScheduledExecutorService[]) f25665a.f25669d.get();
        if (scheduledExecutorServiceArr == f25666b) {
            return f25667c;
        }
        int i = f25668e + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        f25668e = i;
        return scheduledExecutorServiceArr[i];
    }
}
