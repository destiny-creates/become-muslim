package android.arch.p010a.p011a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: DefaultTaskExecutor */
/* renamed from: android.arch.a.a.b */
public class C3103b extends C0060c {
    /* renamed from: a */
    private final Object f7923a = new Object();
    /* renamed from: b */
    private ExecutorService f7924b = Executors.newFixedThreadPool(2);
    /* renamed from: c */
    private volatile Handler f7925c;

    /* renamed from: a */
    public void mo15a(Runnable runnable) {
        this.f7924b.execute(runnable);
    }

    /* renamed from: b */
    public void mo16b(Runnable runnable) {
        if (this.f7925c == null) {
            synchronized (this.f7923a) {
                if (this.f7925c == null) {
                    this.f7925c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f7925c.post(runnable);
    }

    /* renamed from: b */
    public boolean mo17b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
