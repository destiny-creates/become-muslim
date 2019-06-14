package p289e.p292c.p295e;

import java.util.concurrent.atomic.AtomicBoolean;
import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C5982f;
import p289e.C5984g;
import p289e.C5986h;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p290a.C5903b;
import p289e.p291b.C5913a;
import p289e.p291b.C5919g;
import p289e.p292c.p294c.C7291b;
import p289e.p292c.p386b.C7286c;
import p289e.p299e.C5973e;
import p289e.p300f.C5977c;

/* compiled from: ScalarSynchronousObservable */
/* renamed from: e.c.e.l */
public final class C7328l<T> extends C5974e<T> {
    /* renamed from: c */
    static final boolean f25734c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    /* renamed from: b */
    final T f25735b;

    /* compiled from: ScalarSynchronousObservable */
    /* renamed from: e.c.e.l$c */
    static final class C7326c<T> extends AtomicBoolean implements C5913a, C5984g {
        private static final long serialVersionUID = -2466317989629281651L;
        /* renamed from: a */
        final C7367k<? super T> f25728a;
        /* renamed from: b */
        final T f25729b;
        /* renamed from: c */
        final C5919g<C5913a, C5989l> f25730c;

        public C7326c(C7367k<? super T> c7367k, T t, C5919g<C5913a, C5989l> c5919g) {
            this.f25728a = c7367k;
            this.f25729b = t;
            this.f25730c = c5919g;
        }

        /* renamed from: a */
        public void mo5119a(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("n >= 0 required but it was ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (i != 0 && compareAndSet(0, true) != null) {
                this.f25728a.m33781a((C5989l) this.f25730c.mo4976a(this));
            }
        }

        /* renamed from: a */
        public void mo4985a() {
            C5982f c5982f = this.f25728a;
            if (!c5982f.mo5121b()) {
                Object obj = this.f25729b;
                try {
                    c5982f.mo5000a(obj);
                    if (!c5982f.mo5121b()) {
                        c5982f.L_();
                    }
                } catch (Throwable th) {
                    C5903b.m24790a(th, c5982f, obj);
                }
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ScalarAsyncProducer[");
            stringBuilder.append(this.f25729b);
            stringBuilder.append(", ");
            stringBuilder.append(get());
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* compiled from: ScalarSynchronousObservable */
    /* renamed from: e.c.e.l$d */
    static final class C7327d<T> implements C5984g {
        /* renamed from: a */
        final C7367k<? super T> f25731a;
        /* renamed from: b */
        final T f25732b;
        /* renamed from: c */
        boolean f25733c;

        public C7327d(C7367k<? super T> c7367k, T t) {
            this.f25731a = c7367k;
            this.f25732b = t;
        }

        /* renamed from: a */
        public void mo5119a(long j) {
            if (!this.f25733c) {
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("n >= required but it was ");
                    stringBuilder.append(j);
                    throw new IllegalStateException(stringBuilder.toString());
                } else if (i != 0) {
                    this.f25733c = 1;
                    j = this.f25731a;
                    if (!j.mo5121b()) {
                        Object obj = this.f25732b;
                        try {
                            j.mo5000a(obj);
                            if (!j.mo5121b()) {
                                j.L_();
                            }
                        } catch (Throwable th) {
                            C5903b.m24790a(th, j, obj);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: ScalarSynchronousObservable */
    /* renamed from: e.c.e.l$a */
    static final class C8142a<T> implements C7335a<T> {
        /* renamed from: a */
        final T f30299a;

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m39519a((C7367k) obj);
        }

        C8142a(T t) {
            this.f30299a = t;
        }

        /* renamed from: a */
        public void m39519a(C7367k<? super T> c7367k) {
            c7367k.mo6324a(C7328l.m33688a(c7367k, this.f30299a));
        }
    }

    /* compiled from: ScalarSynchronousObservable */
    /* renamed from: e.c.e.l$b */
    static final class C8143b<T> implements C7335a<T> {
        /* renamed from: a */
        final T f30300a;
        /* renamed from: b */
        final C5919g<C5913a, C5989l> f30301b;

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m39521a((C7367k) obj);
        }

        C8143b(T t, C5919g<C5913a, C5989l> c5919g) {
            this.f30300a = t;
            this.f30301b = c5919g;
        }

        /* renamed from: a */
        public void m39521a(C7367k<? super T> c7367k) {
            c7367k.mo6324a(new C7326c(c7367k, this.f30300a, this.f30301b));
        }
    }

    /* renamed from: a */
    static <T> C5984g m33688a(C7367k<? super T> c7367k, T t) {
        if (f25734c) {
            return new C7286c(c7367k, t);
        }
        return new C7327d(c7367k, t);
    }

    /* renamed from: a */
    public static <T> C7328l<T> m33687a(T t) {
        return new C7328l(t);
    }

    protected C7328l(T t) {
        super(C5977c.m25060a(new C8142a(t)));
        this.f25735b = t;
    }

    /* renamed from: a */
    public T m33689a() {
        return this.f25735b;
    }

    /* renamed from: d */
    public C5974e<T> m33690d(final C5986h c5986h) {
        C5919g c73231;
        if (c5986h instanceof C7291b) {
            final C7291b c7291b = (C7291b) c5986h;
            c73231 = new C5919g<C5913a, C5989l>(this) {
                /* renamed from: b */
                final /* synthetic */ C7328l f25722b;

                /* renamed from: a */
                public C5989l m33679a(C5913a c5913a) {
                    return c7291b.m33612a(c5913a);
                }
            };
        } else {
            c73231 = new C5919g<C5913a, C5989l>(this) {
                /* renamed from: b */
                final /* synthetic */ C7328l f25727b;

                /* renamed from: a */
                public C5989l m33682a(final C5913a c5913a) {
                    final C5989l a = c5986h.mo5127a();
                    a.mo6332a(new C5913a(this) {
                        /* renamed from: c */
                        final /* synthetic */ C73252 f25725c;

                        /* renamed from: a */
                        public void mo4985a() {
                            try {
                                c5913a.mo4985a();
                            } finally {
                                a.U_();
                            }
                        }
                    });
                    return a;
                }
            };
        }
        return C5974e.m24972a((C7335a) new C8143b(this.f25735b, c73231));
    }

    /* renamed from: l */
    public <R> C5974e<R> m33691l(final C5919g<? super T, ? extends C5974e<? extends R>> c5919g) {
        return C5974e.m24972a(new C7335a<R>(this) {
            /* renamed from: b */
            final /* synthetic */ C7328l f30298b;

            /* renamed from: b */
            public /* synthetic */ void mo4974b(Object obj) {
                m39517a((C7367k) obj);
            }

            /* renamed from: a */
            public void m39517a(C7367k<? super R> c7367k) {
                C5974e c5974e = (C5974e) c5919g.mo4976a(this.f30298b.f25735b);
                if (c5974e instanceof C7328l) {
                    c7367k.mo6324a(C7328l.m33688a(c7367k, ((C7328l) c5974e).f25735b));
                } else {
                    c5974e.m25007a(C5973e.m24966a((C7367k) c7367k));
                }
            }
        });
    }
}
