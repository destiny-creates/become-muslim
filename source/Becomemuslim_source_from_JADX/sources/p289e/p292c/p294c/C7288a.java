package p289e.p292c.p294c;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p289e.C5986h;
import p289e.C5986h.C7353a;
import p289e.C5989l;
import p289e.p291b.C5913a;
import p289e.p292c.p295e.C5966k;
import p289e.p303i.C5987e;
import p289e.p303i.C7362b;

/* compiled from: CachedThreadScheduler */
/* renamed from: e.c.c.a */
public final class C7288a extends C5986h implements C5948k {
    /* renamed from: a */
    static final C8255c f25643a = new C8255c(C5966k.f19732a);
    /* renamed from: b */
    static final C5942a f25644b = new C5942a(null, 0, null);
    /* renamed from: e */
    private static final long f25645e = ((long) Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue());
    /* renamed from: f */
    private static final TimeUnit f25646f = TimeUnit.SECONDS;
    /* renamed from: c */
    final ThreadFactory f25647c;
    /* renamed from: d */
    final AtomicReference<C5942a> f25648d = new AtomicReference(f25644b);

    /* compiled from: CachedThreadScheduler */
    /* renamed from: e.c.c.a$a */
    static final class C5942a {
        /* renamed from: a */
        private final ThreadFactory f19663a;
        /* renamed from: b */
        private final long f19664b;
        /* renamed from: c */
        private final ConcurrentLinkedQueue<C8255c> f19665c;
        /* renamed from: d */
        private final C7362b f19666d;
        /* renamed from: e */
        private final ScheduledExecutorService f19667e;
        /* renamed from: f */
        private final Future<?> f19668f;

        /* compiled from: CachedThreadScheduler */
        /* renamed from: e.c.c.a$a$2 */
        class C59412 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C5942a f19662a;

            C59412(C5942a c5942a) {
                this.f19662a = c5942a;
            }

            public void run() {
                this.f19662a.m24859b();
            }
        }

        C5942a(final ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            this.f19663a = threadFactory;
            this.f19664b = timeUnit != null ? timeUnit.toNanos(j) : 0;
            this.f19665c = new ConcurrentLinkedQueue();
            this.f19666d = new C7362b();
            j = null;
            if (timeUnit != null) {
                threadFactory = Executors.newScheduledThreadPool(1, new ThreadFactory(this) {
                    /* renamed from: b */
                    final /* synthetic */ C5942a f19661b;

                    public Thread newThread(Runnable runnable) {
                        runnable = threadFactory.newThread(runnable);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(runnable.getName());
                        stringBuilder.append(" (Evictor)");
                        runnable.setName(stringBuilder.toString());
                        return runnable;
                    }
                });
                C8134h.m39500b(threadFactory);
                j = threadFactory.scheduleWithFixedDelay(new C59412(this), this.f19664b, this.f19664b, TimeUnit.NANOSECONDS);
            } else {
                threadFactory = null;
            }
            this.f19667e = threadFactory;
            this.f19668f = j;
        }

        /* renamed from: a */
        C8255c m24857a() {
            if (this.f19666d.mo5121b()) {
                return C7288a.f25643a;
            }
            while (!this.f19665c.isEmpty()) {
                C8255c c8255c = (C8255c) this.f19665c.poll();
                if (c8255c != null) {
                    return c8255c;
                }
            }
            C5989l c8255c2 = new C8255c(this.f19663a);
            this.f19666d.m33765a(c8255c2);
            return c8255c2;
        }

        /* renamed from: a */
        void m24858a(C8255c c8255c) {
            c8255c.m42863a(m24860c() + this.f19664b);
            this.f19665c.offer(c8255c);
        }

        /* renamed from: b */
        void m24859b() {
            if (!this.f19665c.isEmpty()) {
                long c = m24860c();
                Iterator it = this.f19665c.iterator();
                while (it.hasNext()) {
                    C8255c c8255c = (C8255c) it.next();
                    if (c8255c.m42864c() > c) {
                        return;
                    }
                    if (this.f19665c.remove(c8255c)) {
                        this.f19666d.m33766b(c8255c);
                    }
                }
            }
        }

        /* renamed from: c */
        long m24860c() {
            return System.nanoTime();
        }

        /* renamed from: d */
        void m24861d() {
            try {
                if (this.f19668f != null) {
                    this.f19668f.cancel(true);
                }
                if (this.f19667e != null) {
                    this.f19667e.shutdownNow();
                }
                this.f19666d.U_();
            } catch (Throwable th) {
                this.f19666d.U_();
            }
        }
    }

    /* compiled from: CachedThreadScheduler */
    /* renamed from: e.c.c.a$b */
    static final class C8130b extends C7353a implements C5913a {
        /* renamed from: a */
        final AtomicBoolean f30264a;
        /* renamed from: b */
        private final C7362b f30265b = new C7362b();
        /* renamed from: c */
        private final C5942a f30266c;
        /* renamed from: d */
        private final C8255c f30267d;

        C8130b(C5942a c5942a) {
            this.f30266c = c5942a;
            this.f30264a = new AtomicBoolean();
            this.f30267d = c5942a.m24857a();
        }

        public void U_() {
            if (this.f30264a.compareAndSet(false, true)) {
                this.f30267d.mo6332a((C5913a) this);
            }
            this.f30265b.U_();
        }

        /* renamed from: a */
        public void mo4985a() {
            this.f30266c.m24858a(this.f30267d);
        }

        /* renamed from: b */
        public boolean mo5121b() {
            return this.f30265b.mo5121b();
        }

        /* renamed from: a */
        public C5989l mo6332a(C5913a c5913a) {
            return mo6333a(c5913a, 0, null);
        }

        /* renamed from: a */
        public C5989l mo6333a(final C5913a c5913a, long j, TimeUnit timeUnit) {
            if (this.f30265b.mo5121b()) {
                return C5987e.m25119b();
            }
            C5989l b = this.f30267d.m39507b(new C5913a(this) {
                /* renamed from: b */
                final /* synthetic */ C8130b f25642b;

                /* renamed from: a */
                public void mo4985a() {
                    if (!this.f25642b.mo5121b()) {
                        c5913a.mo4985a();
                    }
                }
            }, j, timeUnit);
            this.f30265b.m33765a(b);
            b.m33627a(this.f30265b);
            return b;
        }
    }

    /* compiled from: CachedThreadScheduler */
    /* renamed from: e.c.c.a$c */
    static final class C8255c extends C8134h {
        /* renamed from: c */
        private long f32446c = 0;

        C8255c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        /* renamed from: c */
        public long m42864c() {
            return this.f32446c;
        }

        /* renamed from: a */
        public void m42863a(long j) {
            this.f32446c = j;
        }
    }

    static {
        f25643a.U_();
        f25644b.m24861d();
    }

    public C7288a(ThreadFactory threadFactory) {
        this.f25647c = threadFactory;
        m33607c();
    }

    /* renamed from: c */
    public void m33607c() {
        C5942a c5942a = new C5942a(this.f25647c, f25645e, f25646f);
        if (!this.f25648d.compareAndSet(f25644b, c5942a)) {
            c5942a.m24861d();
        }
    }

    /* renamed from: d */
    public void mo5128d() {
        C5942a c5942a;
        do {
            c5942a = (C5942a) this.f25648d.get();
            if (c5942a == f25644b) {
                return;
            }
        } while (!this.f25648d.compareAndSet(c5942a, f25644b));
        c5942a.m24861d();
    }

    /* renamed from: a */
    public C7353a mo5127a() {
        return new C8130b((C5942a) this.f25648d.get());
    }
}
