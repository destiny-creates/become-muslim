package p289e.p292c.p294c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p289e.C5986h;
import p289e.C5986h.C7353a;
import p289e.C5989l;
import p289e.p291b.C5913a;
import p289e.p292c.p295e.C5966k;
import p289e.p292c.p295e.C7329m;
import p289e.p303i.C5987e;
import p289e.p303i.C7362b;

/* compiled from: EventLoopsScheduler */
/* renamed from: e.c.c.b */
public final class C7291b extends C5986h implements C5948k {
    /* renamed from: a */
    static final int f25653a;
    /* renamed from: b */
    static final C8256c f25654b = new C8256c(C5966k.f19732a);
    /* renamed from: c */
    static final C5943b f25655c = new C5943b(null, 0);
    /* renamed from: d */
    final ThreadFactory f25656d;
    /* renamed from: e */
    final AtomicReference<C5943b> f25657e = new AtomicReference(f25655c);

    /* compiled from: EventLoopsScheduler */
    /* renamed from: e.c.c.b$b */
    static final class C5943b {
        /* renamed from: a */
        final int f19669a;
        /* renamed from: b */
        final C8256c[] f19670b;
        /* renamed from: c */
        long f19671c;

        C5943b(ThreadFactory threadFactory, int i) {
            this.f19669a = i;
            this.f19670b = new C8256c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f19670b[i2] = new C8256c(threadFactory);
            }
        }

        /* renamed from: a */
        public C8256c m24862a() {
            int i = this.f19669a;
            if (i == 0) {
                return C7291b.f25654b;
            }
            C8256c[] c8256cArr = this.f19670b;
            long j = this.f19671c;
            this.f19671c = 1 + j;
            return c8256cArr[(int) (j % ((long) i))];
        }

        /* renamed from: b */
        public void m24863b() {
            for (C8256c U_ : this.f19670b) {
                U_.U_();
            }
        }
    }

    /* compiled from: EventLoopsScheduler */
    /* renamed from: e.c.c.b$a */
    static final class C8131a extends C7353a {
        /* renamed from: a */
        private final C7329m f30268a = new C7329m();
        /* renamed from: b */
        private final C7362b f30269b = new C7362b();
        /* renamed from: c */
        private final C7329m f30270c = new C7329m(this.f30268a, this.f30269b);
        /* renamed from: d */
        private final C8256c f30271d;

        C8131a(C8256c c8256c) {
            this.f30271d = c8256c;
        }

        public void U_() {
            this.f30270c.U_();
        }

        /* renamed from: b */
        public boolean mo5121b() {
            return this.f30270c.mo5121b();
        }

        /* renamed from: a */
        public C5989l mo6332a(final C5913a c5913a) {
            if (mo5121b()) {
                return C5987e.m25119b();
            }
            return this.f30271d.m39503a(new C5913a(this) {
                /* renamed from: b */
                final /* synthetic */ C8131a f25650b;

                /* renamed from: a */
                public void mo4985a() {
                    if (!this.f25650b.mo5121b()) {
                        c5913a.mo4985a();
                    }
                }
            }, 0, null, this.f30268a);
        }

        /* renamed from: a */
        public C5989l mo6333a(final C5913a c5913a, long j, TimeUnit timeUnit) {
            if (mo5121b()) {
                return C5987e.m25119b();
            }
            return this.f30271d.m39504a(new C5913a(this) {
                /* renamed from: b */
                final /* synthetic */ C8131a f25652b;

                /* renamed from: a */
                public void mo4985a() {
                    if (!this.f25652b.mo5121b()) {
                        c5913a.mo4985a();
                    }
                }
            }, j, timeUnit, this.f30269b);
        }
    }

    /* compiled from: EventLoopsScheduler */
    /* renamed from: e.c.c.b$c */
    static final class C8256c extends C8134h {
        C8256c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        f25653a = intValue;
        f25654b.U_();
    }

    public C7291b(ThreadFactory threadFactory) {
        this.f25656d = threadFactory;
        m33613c();
    }

    /* renamed from: a */
    public C7353a mo5127a() {
        return new C8131a(((C5943b) this.f25657e.get()).m24862a());
    }

    /* renamed from: c */
    public void m33613c() {
        C5943b c5943b = new C5943b(this.f25656d, f25653a);
        if (!this.f25657e.compareAndSet(f25655c, c5943b)) {
            c5943b.m24863b();
        }
    }

    /* renamed from: d */
    public void mo5128d() {
        C5943b c5943b;
        do {
            c5943b = (C5943b) this.f25657e.get();
            if (c5943b == f25655c) {
                return;
            }
        } while (!this.f25657e.compareAndSet(c5943b, f25655c));
        c5943b.m24863b();
    }

    /* renamed from: a */
    public C5989l m33612a(C5913a c5913a) {
        return ((C5943b) this.f25657e.get()).m24862a().m39507b(c5913a, -1, TimeUnit.NANOSECONDS);
    }
}
