package p289e.p292c.p295e;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: RxThreadFactory */
/* renamed from: e.c.e.k */
public final class C5966k extends AtomicLong implements ThreadFactory {
    /* renamed from: a */
    public static final ThreadFactory f19732a = new C59651();
    private static final long serialVersionUID = -8841098858898482335L;
    /* renamed from: b */
    final String f19733b;

    /* compiled from: RxThreadFactory */
    /* renamed from: e.c.e.k$1 */
    static class C59651 implements ThreadFactory {
        C59651() {
        }

        public Thread newThread(Runnable runnable) {
            throw new AssertionError("No threads allowed.");
        }
    }

    public C5966k(String str) {
        this.f19733b = str;
    }

    public Thread newThread(Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f19733b);
        stringBuilder.append(incrementAndGet());
        Thread thread = new Thread(runnable, stringBuilder.toString());
        thread.setDaemon(true);
        return thread;
    }
}
