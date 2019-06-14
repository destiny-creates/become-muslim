package android.arch.p010a.p011a;

import java.util.concurrent.Executor;

/* compiled from: ArchTaskExecutor */
/* renamed from: android.arch.a.a.a */
public class C3102a extends C0060c {
    /* renamed from: a */
    private static volatile C3102a f7918a;
    /* renamed from: d */
    private static final Executor f7919d = new C00581();
    /* renamed from: e */
    private static final Executor f7920e = new C00592();
    /* renamed from: b */
    private C0060c f7921b = this.f7922c;
    /* renamed from: c */
    private C0060c f7922c = new C3103b();

    /* compiled from: ArchTaskExecutor */
    /* renamed from: android.arch.a.a.a$1 */
    static class C00581 implements Executor {
        C00581() {
        }

        public void execute(Runnable runnable) {
            C3102a.m9096a().mo16b(runnable);
        }
    }

    /* compiled from: ArchTaskExecutor */
    /* renamed from: android.arch.a.a.a$2 */
    static class C00592 implements Executor {
        C00592() {
        }

        public void execute(Runnable runnable) {
            C3102a.m9096a().mo15a(runnable);
        }
    }

    private C3102a() {
    }

    /* renamed from: a */
    public static C3102a m9096a() {
        if (f7918a != null) {
            return f7918a;
        }
        synchronized (C3102a.class) {
            if (f7918a == null) {
                f7918a = new C3102a();
            }
        }
        return f7918a;
    }

    /* renamed from: a */
    public void mo15a(Runnable runnable) {
        this.f7921b.mo15a(runnable);
    }

    /* renamed from: b */
    public void mo16b(Runnable runnable) {
        this.f7921b.mo16b(runnable);
    }

    /* renamed from: b */
    public boolean mo17b() {
        return this.f7921b.mo17b();
    }
}
