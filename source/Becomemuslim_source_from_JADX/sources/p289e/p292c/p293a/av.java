package p289e.p292c.p293a;

import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C5984g;
import p289e.C5986h;
import p289e.C5986h.C7353a;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p291b.C5913a;

/* compiled from: OperatorSubscribeOn */
/* renamed from: e.c.a.av */
public final class av<T> implements C7335a<T> {
    /* renamed from: a */
    final C5986h f30086a;
    /* renamed from: b */
    final C5974e<T> f30087b;
    /* renamed from: c */
    final boolean f30088c;

    /* compiled from: OperatorSubscribeOn */
    /* renamed from: e.c.a.av$a */
    static final class C8076a<T> extends C7367k<T> implements C5913a {
        /* renamed from: a */
        final C7367k<? super T> f30081a;
        /* renamed from: b */
        final boolean f30082b;
        /* renamed from: c */
        final C7353a f30083c;
        /* renamed from: d */
        C5974e<T> f30084d;
        /* renamed from: e */
        Thread f30085e;

        C8076a(C7367k<? super T> c7367k, boolean z, C7353a c7353a, C5974e<T> c5974e) {
            this.f30081a = c7367k;
            this.f30082b = z;
            this.f30083c = c7353a;
            this.f30084d = c5974e;
        }

        /* renamed from: a */
        public void mo5000a(T t) {
            this.f30081a.mo5000a((Object) t);
        }

        /* renamed from: a */
        public void mo5001a(Throwable th) {
            try {
                this.f30081a.mo5001a(th);
            } finally {
                this.f30083c.U_();
            }
        }

        public void L_() {
            try {
                this.f30081a.L_();
            } finally {
                this.f30083c.U_();
            }
        }

        /* renamed from: a */
        public void mo4985a() {
            C5974e c5974e = this.f30084d;
            this.f30084d = null;
            this.f30085e = Thread.currentThread();
            c5974e.m25007a((C7367k) this);
        }

        /* renamed from: a */
        public void mo6324a(final C5984g c5984g) {
            this.f30081a.mo6324a(new C5984g(this) {
                /* renamed from: b */
                final /* synthetic */ C8076a f25556b;

                /* renamed from: a */
                public void mo5119a(final long j) {
                    if (this.f25556b.f30085e != Thread.currentThread()) {
                        if (this.f25556b.f30082b) {
                            this.f25556b.f30083c.mo6332a(new C5913a(this) {
                                /* renamed from: b */
                                final /* synthetic */ C72561 f25554b;

                                /* renamed from: a */
                                public void mo4985a() {
                                    c5984g.mo5119a(j);
                                }
                            });
                            return;
                        }
                    }
                    c5984g.mo5119a(j);
                }
            });
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39268a((C7367k) obj);
    }

    public av(C5974e<T> c5974e, C5986h c5986h, boolean z) {
        this.f30086a = c5986h;
        this.f30087b = c5974e;
        this.f30088c = z;
    }

    /* renamed from: a */
    public void m39268a(C7367k<? super T> c7367k) {
        C5989l a = this.f30086a.mo5127a();
        C5989l c8076a = new C8076a(c7367k, this.f30088c, a, this.f30087b);
        c7367k.m33781a(c8076a);
        c7367k.m33781a(a);
        a.mo6332a(c8076a);
    }
}
