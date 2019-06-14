package p043b;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: AndroidExecutors */
/* renamed from: b.a */
final class C0813a {
    /* renamed from: a */
    static final int f2263a = (f2266e + 1);
    /* renamed from: b */
    static final int f2264b = ((f2266e * 2) + 1);
    /* renamed from: c */
    private static final C0813a f2265c = new C0813a();
    /* renamed from: e */
    private static final int f2266e = Runtime.getRuntime().availableProcessors();
    /* renamed from: d */
    private final Executor f2267d = new C0812a();

    /* compiled from: AndroidExecutors */
    /* renamed from: b.a$a */
    private static class C0812a implements Executor {
        private C0812a() {
        }

        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    private C0813a() {
    }

    /* renamed from: a */
    public static ExecutorService m2961a() {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(f2263a, f2264b, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        C0813a.m2962a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m2962a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        if (VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(z);
        }
    }

    /* renamed from: b */
    public static Executor m2963b() {
        return f2265c.f2267d;
    }
}
