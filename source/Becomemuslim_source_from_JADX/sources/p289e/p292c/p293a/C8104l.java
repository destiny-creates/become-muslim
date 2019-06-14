package p289e.p292c.p293a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p290a.C5904c;
import p289e.p291b.C5919g;
import p289e.p292c.p295e.C5960d;
import p289e.p292c.p295e.C7328l;
import p289e.p292c.p295e.p296a.C7309d;
import p289e.p292c.p295e.p297b.C8364q;
import p289e.p292c.p295e.p297b.ae;
import p289e.p292c.p386b.C7284a;
import p289e.p299e.C8146d;
import p289e.p300f.C5977c;
import p289e.p303i.C7364d;

/* compiled from: OnSubscribeConcatMap */
/* renamed from: e.c.a.l */
public final class C8104l<T, R> implements C7335a<R> {
    /* renamed from: a */
    final C5974e<? extends T> f30196a;
    /* renamed from: b */
    final C5919g<? super T, ? extends C5974e<? extends R>> f30197b;
    /* renamed from: c */
    final int f30198c;
    /* renamed from: d */
    final int f30199d;

    /* compiled from: OnSubscribeConcatMap */
    /* renamed from: e.c.a.l$a */
    static final class C7272a<T, R> implements C5984g {
        /* renamed from: a */
        final R f25594a;
        /* renamed from: b */
        final C8103c<T, R> f25595b;
        /* renamed from: c */
        boolean f25596c;

        public C7272a(R r, C8103c<T, R> c8103c) {
            this.f25594a = r;
            this.f25595b = c8103c;
        }

        /* renamed from: a */
        public void mo5119a(long j) {
            if (!this.f25596c && j > 0) {
                this.f25596c = 1;
                j = this.f25595b;
                j.m39397b(this.f25594a);
                j.m39399c(1);
            }
        }
    }

    /* compiled from: OnSubscribeConcatMap */
    /* renamed from: e.c.a.l$b */
    static final class C8102b<T, R> extends C7367k<R> {
        /* renamed from: a */
        final C8103c<T, R> f30184a;
        /* renamed from: b */
        long f30185b;

        public C8102b(C8103c<T, R> c8103c) {
            this.f30184a = c8103c;
        }

        /* renamed from: a */
        public void mo6324a(C5984g c5984g) {
            this.f30184a.f30189d.m33599a(c5984g);
        }

        /* renamed from: a */
        public void mo5000a(R r) {
            this.f30185b++;
            this.f30184a.m39397b((Object) r);
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            this.f30184a.m39395a(th, this.f30185b);
        }

        public void L_() {
            this.f30184a.m39399c(this.f30185b);
        }
    }

    /* compiled from: OnSubscribeConcatMap */
    /* renamed from: e.c.a.l$c */
    static final class C8103c<T, R> extends C7367k<T> {
        /* renamed from: a */
        final C7367k<? super R> f30186a;
        /* renamed from: b */
        final C5919g<? super T, ? extends C5974e<? extends R>> f30187b;
        /* renamed from: c */
        final int f30188c;
        /* renamed from: d */
        final C7284a f30189d = new C7284a();
        /* renamed from: e */
        final Queue<Object> f30190e;
        /* renamed from: f */
        final AtomicInteger f30191f = new AtomicInteger();
        /* renamed from: g */
        final AtomicReference<Throwable> f30192g = new AtomicReference();
        /* renamed from: h */
        final C7364d f30193h;
        /* renamed from: i */
        volatile boolean f30194i;
        /* renamed from: j */
        volatile boolean f30195j;

        public C8103c(C7367k<? super R> c7367k, C5919g<? super T, ? extends C5974e<? extends R>> c5919g, int i, int i2) {
            this.f30186a = c7367k;
            this.f30187b = c5919g;
            this.f30188c = i2;
            if (ae.m24923a() != null) {
                c7367k = new C8364q(i);
            } else {
                c7367k = new C7309d(i);
            }
            this.f30190e = c7367k;
            this.f30193h = new C7364d();
            m33779a((long) (long) i);
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            if (this.f30190e.offer(C5937h.m24848a((Object) t)) == null) {
                U_();
                mo5001a(new C5904c());
                return;
            }
            m39401d();
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            if (C5960d.m24929a(this.f30192g, th)) {
                this.f30194i = true;
                if (this.f30188c == null) {
                    th = C5960d.m24927a(this.f30192g);
                    if (!C5960d.m24928a(th)) {
                        this.f30186a.mo5001a(th);
                    }
                    this.f30193h.U_();
                    return;
                }
                m39401d();
                return;
            }
            m39398b(th);
        }

        public void L_() {
            this.f30194i = true;
            m39401d();
        }

        /* renamed from: b */
        void mo6325b(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i > 0) {
                this.f30189d.mo5119a(j);
            } else if (i < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("n >= 0 required but it was ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }

        /* renamed from: b */
        void m39397b(R r) {
            this.f30186a.mo5000a((Object) r);
        }

        /* renamed from: a */
        void m39395a(Throwable th, long j) {
            if (!C5960d.m24929a(this.f30192g, th)) {
                m39398b(th);
            } else if (this.f30188c == null) {
                th = C5960d.m24927a(this.f30192g);
                if (C5960d.m24928a(th) == null) {
                    this.f30186a.mo5001a(th);
                }
                U_();
            } else {
                if (j != 0) {
                    this.f30189d.m33600b(j);
                }
                this.f30195j = null;
                m39401d();
            }
        }

        /* renamed from: c */
        void m39399c(long j) {
            if (j != 0) {
                this.f30189d.m33600b(j);
            }
            this.f30195j = 0;
            m39401d();
        }

        /* renamed from: b */
        void m39398b(Throwable th) {
            C5977c.m25068a(th);
        }

        /* renamed from: d */
        void m39401d() {
            if (this.f30191f.getAndIncrement() == 0) {
                int i = this.f30188c;
                while (!this.f30186a.mo5121b()) {
                    if (!this.f30195j) {
                        Throwable a;
                        if (i != 1 || this.f30192g.get() == null) {
                            boolean z = this.f30194i;
                            Object poll = this.f30190e.poll();
                            Object obj = poll == null ? 1 : null;
                            if (z && obj != null) {
                                a = C5960d.m24927a(this.f30192g);
                                if (a == null) {
                                    this.f30186a.L_();
                                } else if (!C5960d.m24928a(a)) {
                                    this.f30186a.mo5001a(a);
                                }
                                return;
                            } else if (obj == null) {
                                try {
                                    C5974e c5974e = (C5974e) this.f30187b.mo4976a(C5937h.m24853d(poll));
                                    if (c5974e == null) {
                                        m39400c(new NullPointerException("The source returned by the mapper was null"));
                                        return;
                                    } else if (c5974e != C5974e.m24988f()) {
                                        if (c5974e instanceof C7328l) {
                                            C7328l c7328l = (C7328l) c5974e;
                                            this.f30195j = true;
                                            this.f30189d.m33599a(new C7272a(c7328l.m33689a(), this));
                                        } else {
                                            C7367k c8102b = new C8102b(this);
                                            this.f30193h.m33770a(c8102b);
                                            if (!c8102b.mo5121b()) {
                                                this.f30195j = true;
                                                c5974e.m25007a(c8102b);
                                            } else {
                                                return;
                                            }
                                        }
                                        m33779a(1);
                                    } else {
                                        m33779a(1);
                                    }
                                } catch (Throwable a2) {
                                    C5903b.m24794b(a2);
                                    m39400c(a2);
                                    return;
                                }
                            }
                        }
                        a2 = C5960d.m24927a(this.f30192g);
                        if (!C5960d.m24928a(a2)) {
                            this.f30186a.mo5001a(a2);
                        }
                        return;
                    }
                    if (this.f30191f.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        /* renamed from: c */
        void m39400c(Throwable th) {
            U_();
            if (C5960d.m24929a(this.f30192g, th)) {
                th = C5960d.m24927a(this.f30192g);
                if (!C5960d.m24928a(th)) {
                    this.f30186a.mo5001a(th);
                    return;
                }
                return;
            }
            m39398b(th);
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39402a((C7367k) obj);
    }

    public C8104l(C5974e<? extends T> c5974e, C5919g<? super T, ? extends C5974e<? extends R>> c5919g, int i, int i2) {
        this.f30196a = c5974e;
        this.f30197b = c5919g;
        this.f30198c = i;
        this.f30199d = i2;
    }

    /* renamed from: a */
    public void m39402a(C7367k<? super R> c7367k) {
        final C7367k c8103c = new C8103c(this.f30199d == 0 ? new C8146d(c7367k) : c7367k, this.f30197b, this.f30198c, this.f30199d);
        c7367k.m33781a((C5989l) c8103c);
        c7367k.m33781a(c8103c.f30193h);
        c7367k.mo6324a(new C5984g(this) {
            /* renamed from: b */
            final /* synthetic */ C8104l f25593b;

            /* renamed from: a */
            public void mo5119a(long j) {
                c8103c.mo6325b(j);
            }
        });
        if (c7367k.mo5121b() == null) {
            this.f30196a.m25007a(c8103c);
        }
    }
}
