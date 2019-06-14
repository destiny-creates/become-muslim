package p289e.p292c.p293a;

import java.util.concurrent.atomic.AtomicInteger;
import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C5984g;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p292c.p386b.C7284a;
import p289e.p303i.C7364d;

/* compiled from: OnSubscribeSwitchIfEmpty */
/* renamed from: e.c.a.ab */
public final class ab<T> implements C7335a<T> {
    /* renamed from: a */
    final C5974e<? extends T> f29878a;
    /* renamed from: b */
    final C5974e<? extends T> f29879b;

    /* compiled from: OnSubscribeSwitchIfEmpty */
    /* renamed from: e.c.a.ab$a */
    static final class C8050a<T> extends C7367k<T> {
        /* renamed from: a */
        private final C7284a f29869a;
        /* renamed from: b */
        private final C7367k<? super T> f29870b;

        C8050a(C7367k<? super T> c7367k, C7284a c7284a) {
            this.f29870b = c7367k;
            this.f29869a = c7284a;
        }

        /* renamed from: a */
        public void mo6324a(C5984g c5984g) {
            this.f29869a.m33599a(c5984g);
        }

        public void L_() {
            this.f29870b.L_();
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            this.f29870b.mo5001a(th);
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            this.f29870b.mo5000a((Object) t);
            this.f29869a.m33600b(1);
        }
    }

    /* compiled from: OnSubscribeSwitchIfEmpty */
    /* renamed from: e.c.a.ab$b */
    static final class C8051b<T> extends C7367k<T> {
        /* renamed from: a */
        final AtomicInteger f29871a;
        /* renamed from: b */
        volatile boolean f29872b;
        /* renamed from: c */
        private boolean f29873c = true;
        /* renamed from: d */
        private final C7367k<? super T> f29874d;
        /* renamed from: e */
        private final C7364d f29875e;
        /* renamed from: f */
        private final C7284a f29876f;
        /* renamed from: g */
        private final C5974e<? extends T> f29877g;

        C8051b(C7367k<? super T> c7367k, C7364d c7364d, C7284a c7284a, C5974e<? extends T> c5974e) {
            this.f29874d = c7367k;
            this.f29875e = c7364d;
            this.f29876f = c7284a;
            this.f29877g = c5974e;
            this.f29871a = new AtomicInteger();
        }

        /* renamed from: a */
        public void mo6324a(C5984g c5984g) {
            this.f29876f.m33599a(c5984g);
        }

        public void L_() {
            if (!this.f29873c) {
                this.f29874d.L_();
            } else if (!this.f29874d.mo5121b()) {
                this.f29872b = false;
                m39097a(null);
            }
        }

        /* renamed from: a */
        void m39097a(C5974e<? extends T> c5974e) {
            if (this.f29871a.getAndIncrement() == 0) {
                while (!this.f29874d.mo5121b()) {
                    if (!this.f29872b) {
                        if (c5974e == null) {
                            C7367k c8050a = new C8050a(this.f29874d, this.f29876f);
                            this.f29875e.m33770a(c8050a);
                            this.f29872b = true;
                            this.f29877g.m25007a(c8050a);
                        } else {
                            this.f29872b = true;
                            c5974e.m25007a((C7367k) this);
                            c5974e = null;
                        }
                    }
                    if (this.f29871a.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            this.f29874d.mo5001a(th);
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            this.f29873c = false;
            this.f29874d.mo5000a((Object) t);
            this.f29876f.m33600b(1);
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39101a((C7367k) obj);
    }

    public ab(C5974e<? extends T> c5974e, C5974e<? extends T> c5974e2) {
        this.f29878a = c5974e;
        this.f29879b = c5974e2;
    }

    /* renamed from: a */
    public void m39101a(C7367k<? super T> c7367k) {
        C5989l c7364d = new C7364d();
        C5984g c7284a = new C7284a();
        Object c8051b = new C8051b(c7367k, c7364d, c7284a, this.f29879b);
        c7364d.m33770a(c8051b);
        c7367k.m33781a(c7364d);
        c7367k.mo6324a(c7284a);
        c8051b.m39097a(this.f29878a);
    }
}
