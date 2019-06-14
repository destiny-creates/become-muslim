package p289e.p292c.p294c;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p289e.C5986h;
import p289e.C5986h.C7353a;
import p289e.C5989l;
import p289e.p291b.C5913a;
import p289e.p300f.C5977c;
import p289e.p303i.C5987e;
import p289e.p303i.C7362b;
import p289e.p303i.C7363c;

/* compiled from: ExecutorScheduler */
/* renamed from: e.c.c.c */
public final class C7294c extends C5986h {
    /* renamed from: a */
    final Executor f25664a;

    /* compiled from: ExecutorScheduler */
    /* renamed from: e.c.c.c$a */
    static final class C8132a extends C7353a implements Runnable {
        /* renamed from: a */
        final Executor f30272a;
        /* renamed from: b */
        final C7362b f30273b = new C7362b();
        /* renamed from: c */
        final ConcurrentLinkedQueue<C7302j> f30274c = new ConcurrentLinkedQueue();
        /* renamed from: d */
        final AtomicInteger f30275d = new AtomicInteger();
        /* renamed from: e */
        final ScheduledExecutorService f30276e = C7295d.m33618b();

        public C8132a(Executor executor) {
            this.f30272a = executor;
        }

        /* renamed from: a */
        public C5989l mo6332a(C5913a c5913a) {
            if (mo5121b()) {
                return C5987e.m25119b();
            }
            C5989l c7302j = new C7302j(C5977c.m25059a(c5913a), this.f30273b);
            this.f30273b.m33765a(c7302j);
            this.f30274c.offer(c7302j);
            if (this.f30275d.getAndIncrement() == null) {
                try {
                    this.f30272a.execute(this);
                } catch (Throwable e) {
                    this.f30273b.m33766b(c7302j);
                    this.f30275d.decrementAndGet();
                    C5977c.m25068a(e);
                    throw e;
                }
            }
            return c7302j;
        }

        public void run() {
            while (!this.f30273b.mo5121b()) {
                C7302j c7302j = (C7302j) this.f30274c.poll();
                if (c7302j != null) {
                    if (!c7302j.mo5121b()) {
                        if (this.f30273b.mo5121b()) {
                            this.f30274c.clear();
                            return;
                        }
                        c7302j.run();
                    }
                    if (this.f30275d.decrementAndGet() == 0) {
                        return;
                    }
                }
                return;
            }
            this.f30274c.clear();
        }

        /* renamed from: a */
        public C5989l mo6333a(C5913a c5913a, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return mo6332a(c5913a);
            }
            if (mo5121b()) {
                return C5987e.m25119b();
            }
            c5913a = C5977c.m25059a(c5913a);
            Object c7363c = new C7363c();
            final C5989l c7363c2 = new C7363c();
            c7363c2.m33768a(c7363c);
            this.f30273b.m33765a(c7363c2);
            final C5989l a = C5987e.m25118a(new C5913a(this) {
                /* renamed from: b */
                final /* synthetic */ C8132a f25659b;

                /* renamed from: a */
                public void mo4985a() {
                    this.f25659b.f30273b.m33766b(c7363c2);
                }
            });
            C7302j c7302j = new C7302j(new C5913a(this) {
                /* renamed from: d */
                final /* synthetic */ C8132a f25663d;

                /* renamed from: a */
                public void mo4985a() {
                    if (!c7363c2.mo5121b()) {
                        C5989l a = this.f25663d.mo6332a(c5913a);
                        c7363c2.m33768a(a);
                        if (a.getClass() == C7302j.class) {
                            ((C7302j) a).m33628a(a);
                        }
                    }
                }
            });
            c7363c.m33768a(c7302j);
            try {
                c7302j.m33630a(this.f30276e.schedule(c7302j, j, timeUnit));
                return a;
            } catch (Throwable e) {
                C5977c.m25068a(e);
                throw e;
            }
        }

        /* renamed from: b */
        public boolean mo5121b() {
            return this.f30273b.mo5121b();
        }

        public void U_() {
            this.f30273b.U_();
            this.f30274c.clear();
        }
    }

    public C7294c(Executor executor) {
        this.f25664a = executor;
    }

    /* renamed from: a */
    public C7353a mo5127a() {
        return new C8132a(this.f25664a);
    }
}
