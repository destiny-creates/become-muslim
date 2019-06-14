package p289e.p292c.p293a;

import com.facebook.common.time.Clock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C5984g;
import p289e.C5986h;
import p289e.C5986h.C7353a;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p291b.C5913a;
import p289e.p292c.p386b.C7284a;
import p289e.p292c.p387d.C7307b;
import p289e.p300f.C5977c;

/* compiled from: OnSubscribeTimeoutTimedWithFallback */
/* renamed from: e.c.a.ae */
public final class ae<T> implements C7335a<T> {
    /* renamed from: a */
    final C5974e<T> f29908a;
    /* renamed from: b */
    final long f29909b;
    /* renamed from: c */
    final TimeUnit f29910c;
    /* renamed from: d */
    final C5986h f29911d;
    /* renamed from: e */
    final C5974e<? extends T> f29912e;

    /* compiled from: OnSubscribeTimeoutTimedWithFallback */
    /* renamed from: e.c.a.ae$a */
    static final class C8054a<T> extends C7367k<T> {
        /* renamed from: a */
        final C7367k<? super T> f29896a;
        /* renamed from: b */
        final C7284a f29897b;

        C8054a(C7367k<? super T> c7367k, C7284a c7284a) {
            this.f29896a = c7367k;
            this.f29897b = c7284a;
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            this.f29896a.mo5000a((Object) t);
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            this.f29896a.mo5001a(th);
        }

        public void L_() {
            this.f29896a.L_();
        }

        /* renamed from: a */
        public void mo6324a(C5984g c5984g) {
            this.f29897b.m33599a(c5984g);
        }
    }

    /* compiled from: OnSubscribeTimeoutTimedWithFallback */
    /* renamed from: e.c.a.ae$b */
    static final class C8055b<T> extends C7367k<T> {
        /* renamed from: a */
        final C7367k<? super T> f29898a;
        /* renamed from: b */
        final long f29899b;
        /* renamed from: c */
        final TimeUnit f29900c;
        /* renamed from: d */
        final C7353a f29901d;
        /* renamed from: e */
        final C5974e<? extends T> f29902e;
        /* renamed from: f */
        final C7284a f29903f = new C7284a();
        /* renamed from: g */
        final AtomicLong f29904g = new AtomicLong();
        /* renamed from: h */
        final C7307b f29905h = new C7307b();
        /* renamed from: i */
        final C7307b f29906i = new C7307b(this);
        /* renamed from: j */
        long f29907j;

        /* compiled from: OnSubscribeTimeoutTimedWithFallback */
        /* renamed from: e.c.a.ae$b$a */
        final class C7235a implements C5913a {
            /* renamed from: a */
            final long f25517a;
            /* renamed from: b */
            final /* synthetic */ C8055b f25518b;

            C7235a(C8055b c8055b, long j) {
                this.f25518b = c8055b;
                this.f25517a = j;
            }

            /* renamed from: a */
            public void mo4985a() {
                this.f25518b.m39122c(this.f25517a);
            }
        }

        C8055b(C7367k<? super T> c7367k, long j, TimeUnit timeUnit, C7353a c7353a, C5974e<? extends T> c5974e) {
            this.f29898a = c7367k;
            this.f29899b = j;
            this.f29900c = timeUnit;
            this.f29901d = c7353a;
            this.f29902e = c5974e;
            m33781a((C5989l) c7353a);
            m33781a((C5989l) this.f29905h);
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            long j = this.f29904g.get();
            if (j != Clock.MAX_TIME) {
                long j2 = j + 1;
                if (this.f29904g.compareAndSet(j, j2)) {
                    C5989l c5989l = (C5989l) this.f29905h.get();
                    if (c5989l != null) {
                        c5989l.U_();
                    }
                    this.f29907j++;
                    this.f29898a.mo5000a((Object) t);
                    mo6325b(j2);
                }
            }
        }

        /* renamed from: b */
        void mo6325b(long j) {
            this.f29905h.m33639b(this.f29901d.mo6333a(new C7235a(this, j), this.f29899b, this.f29900c));
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (this.f29904g.getAndSet(Clock.MAX_TIME) != Clock.MAX_TIME) {
                this.f29905h.U_();
                this.f29898a.mo5001a(th);
                this.f29901d.U_();
                return;
            }
            C5977c.m25068a(th);
        }

        public void L_() {
            if (this.f29904g.getAndSet(Clock.MAX_TIME) != Clock.MAX_TIME) {
                this.f29905h.U_();
                this.f29898a.L_();
                this.f29901d.U_();
            }
        }

        /* renamed from: a */
        public void mo6324a(C5984g c5984g) {
            this.f29903f.m33599a(c5984g);
        }

        /* renamed from: c */
        void m39122c(long j) {
            if (this.f29904g.compareAndSet(j, Clock.MAX_TIME) != null) {
                U_();
                if (this.f29902e == null) {
                    this.f29898a.mo5001a(new TimeoutException());
                } else {
                    j = this.f29907j;
                    if (j != 0) {
                        this.f29903f.m33600b(j);
                    }
                    C7367k c8054a = new C8054a(this.f29898a, this.f29903f);
                    if (this.f29906i.m33639b(c8054a)) {
                        this.f29902e.m25015b(c8054a);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39123a((C7367k) obj);
    }

    public ae(C5974e<T> c5974e, long j, TimeUnit timeUnit, C5986h c5986h, C5974e<? extends T> c5974e2) {
        this.f29908a = c5974e;
        this.f29909b = j;
        this.f29910c = timeUnit;
        this.f29911d = c5986h;
        this.f29912e = c5974e2;
    }

    /* renamed from: a */
    public void m39123a(C7367k<? super T> c7367k) {
        C7367k c8055b = new C8055b(c7367k, this.f29909b, this.f29910c, this.f29911d.mo5127a(), this.f29912e);
        c7367k.m33781a(c8055b.f29906i);
        c7367k.mo6324a(c8055b.f29903f);
        c8055b.mo6325b(0);
        this.f29908a.m25015b(c8055b);
    }
}
