package p043b;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: BoltsExecutors */
/* renamed from: b.d */
final class C0819d {
    /* renamed from: a */
    private static final C0819d f2276a = new C0819d();
    /* renamed from: b */
    private final ExecutorService f2277b;
    /* renamed from: c */
    private final ScheduledExecutorService f2278c;
    /* renamed from: d */
    private final Executor f2279d;

    /* compiled from: BoltsExecutors */
    /* renamed from: b.d$a */
    private static class C0818a implements Executor {
        /* renamed from: a */
        private ThreadLocal<Integer> f2275a;

        private C0818a() {
            this.f2275a = new ThreadLocal();
        }

        /* renamed from: a */
        private int m2966a() {
            Integer num = (Integer) this.f2275a.get();
            if (num == null) {
                num = Integer.valueOf(0);
            }
            int intValue = num.intValue() + 1;
            this.f2275a.set(Integer.valueOf(intValue));
            return intValue;
        }

        /* renamed from: b */
        private int m2967b() {
            Integer num = (Integer) this.f2275a.get();
            if (num == null) {
                num = Integer.valueOf(0);
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f2275a.remove();
            } else {
                this.f2275a.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        public void execute(Runnable runnable) {
            if (m2966a() <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    m2967b();
                }
            } else {
                C0819d.m2968a().execute(runnable);
            }
            m2967b();
        }
    }

    /* renamed from: c */
    private static boolean m2970c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private C0819d() {
        this.f2277b = !C0819d.m2970c() ? Executors.newCachedThreadPool() : C0813a.m2961a();
        this.f2278c = Executors.newSingleThreadScheduledExecutor();
        this.f2279d = new C0818a();
    }

    /* renamed from: a */
    public static ExecutorService m2968a() {
        return f2276a.f2277b;
    }

    /* renamed from: b */
    static Executor m2969b() {
        return f2276a.f2279d;
    }
}
