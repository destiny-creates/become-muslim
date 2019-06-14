package p289e.p292c.p293a;

import com.facebook.common.time.Clock;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p291b.C5919g;
import p289e.p292c.p293a.ae.C8054a;
import p289e.p292c.p386b.C7284a;
import p289e.p292c.p387d.C7307b;
import p289e.p300f.C5977c;

/* compiled from: OnSubscribeTimeoutSelectorWithFallback */
/* renamed from: e.c.a.ad */
public final class ad<T, U, V> implements C7335a<T> {
    /* renamed from: a */
    final C5974e<T> f29892a;
    /* renamed from: b */
    final C5974e<U> f29893b;
    /* renamed from: c */
    final C5919g<? super T, ? extends C5974e<V>> f29894c;
    /* renamed from: d */
    final C5974e<? extends T> f29895d;

    /* compiled from: OnSubscribeTimeoutSelectorWithFallback */
    /* renamed from: e.c.a.ad$a */
    static final class C8053a<T> extends C7367k<T> {
        /* renamed from: a */
        final C7367k<? super T> f29884a;
        /* renamed from: b */
        final C5919g<? super T, ? extends C5974e<?>> f29885b;
        /* renamed from: c */
        final C5974e<? extends T> f29886c;
        /* renamed from: d */
        final C7284a f29887d = new C7284a();
        /* renamed from: e */
        final AtomicLong f29888e = new AtomicLong();
        /* renamed from: f */
        final C7307b f29889f = new C7307b();
        /* renamed from: g */
        final C7307b f29890g = new C7307b(this);
        /* renamed from: h */
        long f29891h;

        /* compiled from: OnSubscribeTimeoutSelectorWithFallback */
        /* renamed from: e.c.a.ad$a$a */
        final class C8052a extends C7367k<Object> {
            /* renamed from: a */
            final long f29881a;
            /* renamed from: b */
            boolean f29882b;
            /* renamed from: c */
            final /* synthetic */ C8053a f29883c;

            C8052a(C8053a c8053a, long j) {
                this.f29883c = c8053a;
                this.f29881a = j;
            }

            /* renamed from: a */
            public void mo5000a(Object obj) {
                if (this.f29882b == null) {
                    this.f29882b = true;
                    U_();
                    this.f29883c.mo6325b(this.f29881a);
                }
            }

            /* renamed from: a */
            public void mo5001a(Throwable th) {
                if (this.f29882b) {
                    C5977c.m25068a(th);
                    return;
                }
                this.f29882b = true;
                this.f29883c.m39107a(this.f29881a, th);
            }

            public void L_() {
                if (!this.f29882b) {
                    this.f29882b = true;
                    this.f29883c.mo6325b(this.f29881a);
                }
            }
        }

        C8053a(C7367k<? super T> c7367k, C5919g<? super T, ? extends C5974e<?>> c5919g, C5974e<? extends T> c5974e) {
            this.f29884a = c7367k;
            this.f29885b = c5919g;
            this.f29886c = c5974e;
            m33781a((C5989l) this.f29889f);
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            long j = this.f29888e.get();
            if (j != Clock.MAX_TIME) {
                long j2 = j + 1;
                if (this.f29888e.compareAndSet(j, j2)) {
                    C5989l c5989l = (C5989l) this.f29889f.get();
                    if (c5989l != null) {
                        c5989l.U_();
                    }
                    this.f29884a.mo5000a((Object) t);
                    this.f29891h++;
                    try {
                        C5974e c5974e = (C5974e) this.f29885b.mo4976a(t);
                        if (c5974e != null) {
                            C7367k c8052a = new C8052a(this, j2);
                            if (this.f29889f.m33639b(c8052a)) {
                                c5974e.m25015b(c8052a);
                            }
                            return;
                        }
                        throw new NullPointerException("The itemTimeoutIndicator returned a null Observable");
                    } catch (T t2) {
                        C5903b.m24794b(t2);
                        U_();
                        this.f29888e.getAndSet(Clock.MAX_TIME);
                        this.f29884a.mo5001a((Throwable) t2);
                    }
                }
            }
        }

        /* renamed from: a */
        void m39108a(C5974e<?> c5974e) {
            if (c5974e != null) {
                C7367k c8052a = new C8052a(this, 0);
                if (this.f29889f.m33639b(c8052a)) {
                    c5974e.m25015b(c8052a);
                }
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (this.f29888e.getAndSet(Clock.MAX_TIME) != Clock.MAX_TIME) {
                this.f29889f.U_();
                this.f29884a.mo5001a(th);
                return;
            }
            C5977c.m25068a(th);
        }

        public void L_() {
            if (this.f29888e.getAndSet(Clock.MAX_TIME) != Clock.MAX_TIME) {
                this.f29889f.U_();
                this.f29884a.L_();
            }
        }

        /* renamed from: a */
        public void mo6324a(C5984g c5984g) {
            this.f29887d.m33599a(c5984g);
        }

        /* renamed from: b */
        void mo6325b(long j) {
            if (this.f29888e.compareAndSet(j, Clock.MAX_TIME) != null) {
                U_();
                if (this.f29886c == null) {
                    this.f29884a.mo5001a(new TimeoutException());
                } else {
                    j = this.f29891h;
                    if (j != 0) {
                        this.f29887d.m33600b(j);
                    }
                    C7367k c8054a = new C8054a(this.f29884a, this.f29887d);
                    if (this.f29890g.m33639b(c8054a)) {
                        this.f29886c.m25015b(c8054a);
                    }
                }
            }
        }

        /* renamed from: a */
        void m39107a(long j, Throwable th) {
            if (this.f29888e.compareAndSet(j, Clock.MAX_TIME) != null) {
                U_();
                this.f29884a.mo5001a(th);
                return;
            }
            C5977c.m25068a(th);
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39113a((C7367k) obj);
    }

    public ad(C5974e<T> c5974e, C5974e<U> c5974e2, C5919g<? super T, ? extends C5974e<V>> c5919g, C5974e<? extends T> c5974e3) {
        this.f29892a = c5974e;
        this.f29893b = c5974e2;
        this.f29894c = c5919g;
        this.f29895d = c5974e3;
    }

    /* renamed from: a */
    public void m39113a(C7367k<? super T> c7367k) {
        C7367k c8053a = new C8053a(c7367k, this.f29894c, this.f29895d);
        c7367k.m33781a(c8053a.f29890g);
        c7367k.mo6324a(c8053a.f29887d);
        c8053a.m39108a(this.f29893b);
        this.f29892a.m25015b(c8053a);
    }
}
