package p289e.p292c.p294c;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p289e.C5986h.C7353a;
import p289e.C5989l;
import p289e.p290a.C5903b;
import p289e.p291b.C5913a;
import p289e.p292c.p295e.C5964i;
import p289e.p292c.p295e.C5966k;
import p289e.p292c.p295e.C7329m;
import p289e.p300f.C5977c;
import p289e.p303i.C5987e;
import p289e.p303i.C7362b;

/* compiled from: NewThreadWorker */
/* renamed from: e.c.c.h */
public class C8134h extends C7353a implements C5989l {
    /* renamed from: b */
    public static final int f30279b = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();
    /* renamed from: d */
    private static final boolean f30280d;
    /* renamed from: e */
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f30281e = new ConcurrentHashMap();
    /* renamed from: f */
    private static final AtomicReference<ScheduledExecutorService> f30282f = new AtomicReference();
    /* renamed from: g */
    private static volatile Object f30283g;
    /* renamed from: h */
    private static final Object f30284h = new Object();
    /* renamed from: a */
    volatile boolean f30285a;
    /* renamed from: c */
    private final ScheduledExecutorService f30286c;

    /* compiled from: NewThreadWorker */
    /* renamed from: e.c.c.h$1 */
    static class C59451 implements Runnable {
        C59451() {
        }

        public void run() {
            C8134h.m39502d();
        }
    }

    static {
        boolean z = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int b = C5964i.m24944b();
        z = !z && (b == 0 || b >= 21);
        f30280d = z;
    }

    /* renamed from: a */
    public static void m39499a(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (((ScheduledExecutorService) f30282f.get()) == null) {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new C5966k("RxSchedulerPurge-"));
            if (f30282f.compareAndSet(null, newScheduledThreadPool)) {
                newScheduledThreadPool.scheduleAtFixedRate(new C59451(), (long) f30279b, (long) f30279b, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        f30281e.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    /* renamed from: a */
    public static void m39498a(ScheduledExecutorService scheduledExecutorService) {
        f30281e.remove(scheduledExecutorService);
    }

    /* renamed from: d */
    static void m39502d() {
        try {
            Iterator it = f30281e.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    it.remove();
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        } catch (Throwable th) {
            C5903b.m24794b(th);
            C5977c.m25068a(th);
        }
    }

    /* renamed from: b */
    public static boolean m39500b(ScheduledExecutorService scheduledExecutorService) {
        if (f30280d) {
            Method c;
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = f30283g;
                if (obj == f30284h) {
                    return false;
                }
                if (obj == null) {
                    Object obj2;
                    c = C8134h.m39501c(scheduledExecutorService);
                    if (c != null) {
                        obj2 = c;
                    } else {
                        obj2 = f30284h;
                    }
                    f30283g = obj2;
                } else {
                    c = (Method) obj;
                }
            } else {
                c = C8134h.m39501c(scheduledExecutorService);
            }
            if (c != null) {
                try {
                    c.invoke(scheduledExecutorService, new Object[]{Boolean.valueOf(true)});
                    return true;
                } catch (Throwable e) {
                    C5977c.m25068a(e);
                } catch (Throwable e2) {
                    C5977c.m25068a(e2);
                } catch (Throwable e22) {
                    C5977c.m25068a(e22);
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    static Method m39501c(ScheduledExecutorService scheduledExecutorService) {
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    public C8134h(ThreadFactory threadFactory) {
        threadFactory = Executors.newScheduledThreadPool(1, threadFactory);
        if (!C8134h.m39500b(threadFactory) && (threadFactory instanceof ScheduledThreadPoolExecutor)) {
            C8134h.m39499a((ScheduledThreadPoolExecutor) threadFactory);
        }
        this.f30286c = threadFactory;
    }

    /* renamed from: a */
    public C5989l mo6332a(C5913a c5913a) {
        return mo6333a(c5913a, 0, null);
    }

    /* renamed from: a */
    public C5989l mo6333a(C5913a c5913a, long j, TimeUnit timeUnit) {
        if (this.f30285a) {
            return C5987e.m25119b();
        }
        return m39507b(c5913a, j, timeUnit);
    }

    /* renamed from: b */
    public C7302j m39507b(C5913a c5913a, long j, TimeUnit timeUnit) {
        Future submit;
        C7302j c7302j = new C7302j(C5977c.m25059a(c5913a));
        if (j <= 0) {
            submit = this.f30286c.submit(c7302j);
        } else {
            submit = this.f30286c.schedule(c7302j, j, timeUnit);
        }
        c7302j.m33630a(submit);
        return c7302j;
    }

    /* renamed from: a */
    public C7302j m39504a(C5913a c5913a, long j, TimeUnit timeUnit, C7362b c7362b) {
        Future submit;
        C5989l c7302j = new C7302j(C5977c.m25059a(c5913a), c7362b);
        c7362b.m33765a(c7302j);
        if (j <= 0) {
            submit = this.f30286c.submit(c7302j);
        } else {
            submit = this.f30286c.schedule(c7302j, j, timeUnit);
        }
        c7302j.m33630a(submit);
        return c7302j;
    }

    /* renamed from: a */
    public C7302j m39503a(C5913a c5913a, long j, TimeUnit timeUnit, C7329m c7329m) {
        Future submit;
        C5989l c7302j = new C7302j(C5977c.m25059a(c5913a), c7329m);
        c7329m.m33693a(c7302j);
        if (j <= 0) {
            submit = this.f30286c.submit(c7302j);
        } else {
            submit = this.f30286c.schedule(c7302j, j, timeUnit);
        }
        c7302j.m33630a(submit);
        return c7302j;
    }

    public void U_() {
        this.f30285a = true;
        this.f30286c.shutdownNow();
        C8134h.m39498a(this.f30286c);
    }

    /* renamed from: b */
    public boolean mo5121b() {
        return this.f30285a;
    }
}
