package p289e.p292c.p294c;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p289e.C5989l;
import p289e.p291b.C5913a;
import p289e.p292c.p295e.C7329m;
import p289e.p300f.C5977c;
import p289e.p303i.C7362b;

/* compiled from: ScheduledAction */
/* renamed from: e.c.c.j */
public final class C7302j extends AtomicReference<Thread> implements C5989l, Runnable {
    private static final long serialVersionUID = -3962399486978279857L;
    /* renamed from: a */
    final C7329m f25688a;
    /* renamed from: b */
    final C5913a f25689b;

    /* compiled from: ScheduledAction */
    /* renamed from: e.c.c.j$a */
    final class C7299a implements C5989l {
        /* renamed from: a */
        final /* synthetic */ C7302j f25682a;
        /* renamed from: b */
        private final Future<?> f25683b;

        C7299a(C7302j c7302j, Future<?> future) {
            this.f25682a = c7302j;
            this.f25683b = future;
        }

        public void U_() {
            if (this.f25682a.get() != Thread.currentThread()) {
                this.f25683b.cancel(true);
            } else {
                this.f25683b.cancel(false);
            }
        }

        /* renamed from: b */
        public boolean mo5121b() {
            return this.f25683b.isCancelled();
        }
    }

    /* compiled from: ScheduledAction */
    /* renamed from: e.c.c.j$b */
    static final class C7300b extends AtomicBoolean implements C5989l {
        private static final long serialVersionUID = 247232374289553518L;
        /* renamed from: a */
        final C7302j f25684a;
        /* renamed from: b */
        final C7362b f25685b;

        public C7300b(C7302j c7302j, C7362b c7362b) {
            this.f25684a = c7302j;
            this.f25685b = c7362b;
        }

        /* renamed from: b */
        public boolean mo5121b() {
            return this.f25684a.mo5121b();
        }

        public void U_() {
            if (compareAndSet(false, true)) {
                this.f25685b.m33766b(this.f25684a);
            }
        }
    }

    /* compiled from: ScheduledAction */
    /* renamed from: e.c.c.j$c */
    static final class C7301c extends AtomicBoolean implements C5989l {
        private static final long serialVersionUID = 247232374289553518L;
        /* renamed from: a */
        final C7302j f25686a;
        /* renamed from: b */
        final C7329m f25687b;

        public C7301c(C7302j c7302j, C7329m c7329m) {
            this.f25686a = c7302j;
            this.f25687b = c7329m;
        }

        /* renamed from: b */
        public boolean mo5121b() {
            return this.f25686a.mo5121b();
        }

        public void U_() {
            if (compareAndSet(false, true)) {
                this.f25687b.m33694b(this.f25686a);
            }
        }
    }

    public C7302j(C5913a c5913a) {
        this.f25689b = c5913a;
        this.f25688a = new C7329m();
    }

    public C7302j(C5913a c5913a, C7362b c7362b) {
        this.f25689b = c5913a;
        this.f25688a = new C7329m(new C7300b(this, c7362b));
    }

    public C7302j(C5913a c5913a, C7329m c7329m) {
        this.f25689b = c5913a;
        this.f25688a = new C7329m(new C7301c(this, c7329m));
    }

    public void run() {
        try {
            lazySet(Thread.currentThread());
            this.f25689b.mo4985a();
        } catch (Throwable e) {
            m33629a(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e));
        } catch (Throwable th) {
            U_();
        }
        U_();
    }

    /* renamed from: a */
    void m33629a(Throwable th) {
        C5977c.m25068a(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    /* renamed from: b */
    public boolean mo5121b() {
        return this.f25688a.mo5121b();
    }

    public void U_() {
        if (!this.f25688a.mo5121b()) {
            this.f25688a.U_();
        }
    }

    /* renamed from: a */
    public void m33628a(C5989l c5989l) {
        this.f25688a.m33693a(c5989l);
    }

    /* renamed from: a */
    public void m33630a(Future<?> future) {
        this.f25688a.m33693a(new C7299a(this, future));
    }

    /* renamed from: a */
    public void m33627a(C7362b c7362b) {
        this.f25688a.m33693a(new C7300b(this, c7362b));
    }
}
