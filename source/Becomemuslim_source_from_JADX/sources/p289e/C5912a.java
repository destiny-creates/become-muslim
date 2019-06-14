package p289e;

import java.util.Arrays;
import p289e.C5921b;
import p289e.C5974e.C7335a;
import p289e.C5989l;
import p289e.p290a.C5902a;
import p289e.p290a.C5903b;
import p289e.p291b.C5913a;
import p289e.p291b.C5914b;
import p289e.p291b.C5916d;
import p289e.p291b.C5919g;
import p289e.p292c.p293a.C8094c;
import p289e.p292c.p295e.C5967n;
import p289e.p300f.C5977c;
import p289e.p303i.C5987e;
import p289e.p303i.C7361a;
import p289e.p303i.C7363c;
import p289e.p303i.C7364d;

/* compiled from: Completable */
/* renamed from: e.a */
public class C5912a {
    /* renamed from: a */
    static final C5912a f19631a = new C5912a(new C80411(), false);
    /* renamed from: b */
    static final C5912a f19632b = new C5912a(new C80454(), false);
    /* renamed from: c */
    private final C7228a f19633c;

    /* compiled from: Completable */
    /* renamed from: e.a$a */
    public interface C7228a extends C5914b<C5921b> {
    }

    /* compiled from: Completable */
    /* renamed from: e.a$b */
    public interface C7229b extends C5919g<C5921b, C5921b> {
    }

    /* compiled from: Completable */
    /* renamed from: e.a$c */
    public interface C7230c extends C5919g<C5912a, C5912a> {
    }

    /* compiled from: Completable */
    /* renamed from: e.a$1 */
    static class C80411 implements C7228a {
        C80411() {
        }

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m39072a((C5921b) obj);
        }

        /* renamed from: a */
        public void m39072a(C5921b c5921b) {
            c5921b.mo5115a(C5987e.m25119b());
            c5921b.mo5114a();
        }
    }

    /* compiled from: Completable */
    /* renamed from: e.a$4 */
    static class C80454 implements C7228a {
        C80454() {
        }

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m39080a((C5921b) obj);
        }

        /* renamed from: a */
        public void m39080a(C5921b c5921b) {
            c5921b.mo5115a(C5987e.m25119b());
        }
    }

    /* compiled from: Completable */
    /* renamed from: e.a$9 */
    class C80489 implements C7335a<T> {
        /* renamed from: a */
        final /* synthetic */ C5912a f29862a;

        C80489(C5912a c5912a) {
            this.f29862a = c5912a;
        }

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m39086a((C7367k) obj);
        }

        /* renamed from: a */
        public void m39086a(C7367k<? super T> c7367k) {
            this.f29862a.m24816a((C7367k) c7367k);
        }
    }

    /* renamed from: a */
    public static C5912a m24800a() {
        C7228a a = C5977c.m25057a(f19631a.f19633c);
        if (a == f19631a.f19633c) {
            return f19631a;
        }
        return new C5912a(a, false);
    }

    /* renamed from: a */
    public static C5912a m24805a(C5912a... c5912aArr) {
        C5912a.m24806a((Object) c5912aArr);
        if (c5912aArr.length == 0) {
            return C5912a.m24800a();
        }
        if (c5912aArr.length == 1) {
            return c5912aArr[0];
        }
        return C5912a.m24801a(new C8094c(c5912aArr));
    }

    /* renamed from: a */
    public static C5912a m24801a(C7228a c7228a) {
        C5912a.m24806a((Object) c7228a);
        try {
            return new C5912a(c7228a);
        } catch (C7228a c7228a2) {
            throw c7228a2;
        } catch (Throwable th) {
            C5977c.m25068a(th);
            c7228a2 = C5912a.m24808b(th);
        }
    }

    /* renamed from: a */
    public static C5912a m24804a(final Throwable th) {
        C5912a.m24806a((Object) th);
        return C5912a.m24801a(new C7228a() {
            /* renamed from: b */
            public /* synthetic */ void mo4974b(Object obj) {
                m39068a((C5921b) obj);
            }

            /* renamed from: a */
            public void m39068a(C5921b c5921b) {
                c5921b.mo5115a(C5987e.m25119b());
                c5921b.mo5116a(th);
            }
        });
    }

    /* renamed from: a */
    public static C5912a m24802a(final C5913a c5913a) {
        C5912a.m24806a((Object) c5913a);
        return C5912a.m24801a(new C7228a() {
            /* renamed from: b */
            public /* synthetic */ void mo4974b(Object obj) {
                m39070a((C5921b) obj);
            }

            /* renamed from: a */
            public void m39070a(C5921b c5921b) {
                C5989l c7361a = new C7361a();
                c5921b.mo5115a(c7361a);
                try {
                    c5913a.mo4985a();
                    if (!c7361a.mo5121b()) {
                        c5921b.mo5114a();
                    }
                } catch (Throwable th) {
                    if (!c7361a.mo5121b()) {
                        c5921b.mo5116a(th);
                    }
                }
            }
        });
    }

    /* renamed from: a */
    public static C5912a m24803a(final C5974e<?> c5974e) {
        C5912a.m24806a((Object) c5974e);
        return C5912a.m24801a(new C7228a() {
            /* renamed from: b */
            public /* synthetic */ void mo4974b(Object obj) {
                m39076a((C5921b) obj);
            }

            /* renamed from: a */
            public void m39076a(final C5921b c5921b) {
                C7367k c80421 = new C7367k<Object>(this) {
                    /* renamed from: b */
                    final /* synthetic */ C80432 f29850b;

                    /* renamed from: a */
                    public void mo5000a(Object obj) {
                    }

                    public void L_() {
                        c5921b.mo5114a();
                    }

                    /* renamed from: a */
                    public void mo5001a(Throwable th) {
                        c5921b.mo5116a(th);
                    }
                };
                c5921b.mo5115a((C5989l) c80421);
                c5974e.m25007a(c80421);
            }
        });
    }

    /* renamed from: a */
    static <T> T m24806a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* renamed from: b */
    static NullPointerException m24808b(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    protected C5912a(C7228a c7228a) {
        this.f19633c = C5977c.m25057a(c7228a);
    }

    protected C5912a(C7228a c7228a, boolean z) {
        if (z) {
            c7228a = C5977c.m25057a(c7228a);
        }
        this.f19633c = c7228a;
    }

    /* renamed from: a */
    public final C5912a m24810a(C7230c c7230c) {
        return (C5912a) m24823c((C5919g) c7230c);
    }

    /* renamed from: b */
    public final <T> C5974e<T> m24821b(C5974e<T> c5974e) {
        C5912a.m24806a((Object) c5974e);
        return c5974e.m25031e(m24822c());
    }

    /* renamed from: a */
    public final C5912a m24811a(C5912a c5912a) {
        return m24818b(c5912a);
    }

    /* renamed from: b */
    public final C5912a m24818b(C5912a c5912a) {
        C5912a.m24806a((Object) c5912a);
        return C5912a.m24805a(this, c5912a);
    }

    /* renamed from: b */
    public final C5912a m24819b(C5913a c5913a) {
        return m24812a(C5916d.m24828a(), C5916d.m24828a(), C5916d.m24828a(), C5916d.m24828a(), c5913a);
    }

    /* renamed from: a */
    protected final C5912a m24812a(C5914b<? super C5989l> c5914b, C5914b<? super Throwable> c5914b2, C5913a c5913a, C5913a c5913a2, C5913a c5913a3) {
        C5912a.m24806a((Object) c5914b);
        C5912a.m24806a((Object) c5914b2);
        C5912a.m24806a((Object) c5913a);
        C5912a.m24806a((Object) c5913a2);
        C5912a.m24806a((Object) c5913a3);
        final C5913a c5913a4 = c5913a;
        final C5913a c5913a5 = c5913a2;
        final C5914b<? super Throwable> c5914b3 = c5914b2;
        final C5914b<? super C5989l> c5914b4 = c5914b;
        final C5913a c5913a6 = c5913a3;
        return C5912a.m24801a(new C7228a(this) {
            /* renamed from: f */
            final /* synthetic */ C5912a f29857f;

            /* renamed from: b */
            public /* synthetic */ void mo4974b(Object obj) {
                m39078a((C5921b) obj);
            }

            /* renamed from: a */
            public void m39078a(final C5921b c5921b) {
                this.f29857f.m24815a(new C5921b(this) {
                    /* renamed from: b */
                    final /* synthetic */ C80443 f25500b;

                    /* renamed from: a */
                    public void mo5114a() {
                        try {
                            c5913a4.mo4985a();
                            c5921b.mo5114a();
                            try {
                                c5913a5.mo4985a();
                            } catch (Throwable th) {
                                C5977c.m25068a(th);
                            }
                        } catch (Throwable th2) {
                            c5921b.mo5116a(th2);
                        }
                    }

                    /* renamed from: a */
                    public void mo5116a(Throwable th) {
                        try {
                            c5914b3.mo4974b(th);
                        } catch (Throwable th2) {
                            th = new C5902a(Arrays.asList(new Throwable[]{th, th2}));
                        }
                        c5921b.mo5116a(th);
                        try {
                            c5913a5.mo4985a();
                        } catch (Throwable th3) {
                            C5977c.m25068a(th3);
                        }
                    }

                    /* renamed from: a */
                    public void mo5115a(final C5989l c5989l) {
                        try {
                            c5914b4.mo4974b(c5989l);
                            c5921b.mo5115a(C5987e.m25118a(new C5913a(this) {
                                /* renamed from: b */
                                final /* synthetic */ C72221 f25498b;

                                /* renamed from: a */
                                public void mo4985a() {
                                    try {
                                        c5913a6.mo4985a();
                                    } catch (Throwable th) {
                                        C5977c.m25068a(th);
                                    }
                                    c5989l.U_();
                                }
                            }));
                        } catch (Throwable th) {
                            c5989l.U_();
                            c5921b.mo5115a(C5987e.m25119b());
                            c5921b.mo5116a(th);
                        }
                    }
                });
            }
        });
    }

    /* renamed from: b */
    public final C5912a m24817b() {
        return m24813a(C5967n.m24946a());
    }

    /* renamed from: a */
    public final C5912a m24813a(final C5919g<? super Throwable, Boolean> c5919g) {
        C5912a.m24806a((Object) c5919g);
        return C5912a.m24801a(new C7228a(this) {
            /* renamed from: b */
            final /* synthetic */ C5912a f29859b;

            /* renamed from: b */
            public /* synthetic */ void mo4974b(Object obj) {
                m39082a((C5921b) obj);
            }

            /* renamed from: a */
            public void m39082a(final C5921b c5921b) {
                this.f29859b.m24815a(new C5921b(this) {
                    /* renamed from: b */
                    final /* synthetic */ C80465 f25502b;

                    /* renamed from: a */
                    public void mo5114a() {
                        c5921b.mo5114a();
                    }

                    /* renamed from: a */
                    public void mo5116a(Throwable th) {
                        int i = 0;
                        try {
                            i = ((Boolean) c5919g.mo4976a(th)).booleanValue();
                        } catch (Throwable th2) {
                            C5903b.m24794b(th2);
                            th = new C5902a(Arrays.asList(new Throwable[]{th, th2}));
                        }
                        if (i != 0) {
                            c5921b.mo5114a();
                        } else {
                            c5921b.mo5116a(th);
                        }
                    }

                    /* renamed from: a */
                    public void mo5115a(C5989l c5989l) {
                        c5921b.mo5115a(c5989l);
                    }
                });
            }
        });
    }

    /* renamed from: b */
    public final C5912a m24820b(final C5919g<? super Throwable, ? extends C5912a> c5919g) {
        C5912a.m24806a((Object) c5919g);
        return C5912a.m24801a(new C7228a(this) {
            /* renamed from: b */
            final /* synthetic */ C5912a f29861b;

            /* renamed from: b */
            public /* synthetic */ void mo4974b(Object obj) {
                m39084a((C5921b) obj);
            }

            /* renamed from: a */
            public void m39084a(final C5921b c5921b) {
                final C5989l c7364d = new C7364d();
                c5921b.mo5115a(c7364d);
                this.f29861b.m24815a(new C5921b(this) {
                    /* renamed from: c */
                    final /* synthetic */ C80476 f25506c;

                    /* compiled from: Completable */
                    /* renamed from: e.a$6$1$1 */
                    class C72241 implements C5921b {
                        /* renamed from: a */
                        final /* synthetic */ C72251 f25503a;

                        C72241(C72251 c72251) {
                            this.f25503a = c72251;
                        }

                        /* renamed from: a */
                        public void mo5114a() {
                            c5921b.mo5114a();
                        }

                        /* renamed from: a */
                        public void mo5116a(Throwable th) {
                            c5921b.mo5116a(th);
                        }

                        /* renamed from: a */
                        public void mo5115a(C5989l c5989l) {
                            c7364d.m33770a(c5989l);
                        }
                    }

                    /* renamed from: a */
                    public void mo5114a() {
                        c5921b.mo5114a();
                    }

                    /* renamed from: a */
                    public void mo5116a(Throwable th) {
                        try {
                            C5912a c5912a = (C5912a) c5919g.mo4976a(th);
                            if (c5912a == null) {
                                NullPointerException nullPointerException = new NullPointerException("The completable returned is null");
                                c5921b.mo5116a(new C5902a(Arrays.asList(new Throwable[]{th, nullPointerException})));
                                return;
                            }
                            c5912a.m24815a(new C72241(this));
                        } catch (Throwable th2) {
                            c5921b.mo5116a(new C5902a(Arrays.asList(new Throwable[]{th, th2})));
                        }
                    }

                    /* renamed from: a */
                    public void mo5115a(C5989l c5989l) {
                        c7364d.m33770a(c5989l);
                    }
                });
            }
        });
    }

    /* renamed from: a */
    public final C5989l m24814a(final C5913a c5913a, final C5914b<? super Throwable> c5914b) {
        C5912a.m24806a((Object) c5913a);
        C5912a.m24806a((Object) c5914b);
        final C5989l c7363c = new C7363c();
        m24815a(new C5921b(this) {
            /* renamed from: a */
            boolean f25507a;
            /* renamed from: e */
            final /* synthetic */ C5912a f25511e;

            /* renamed from: a */
            public void mo5114a() {
                if (!this.f25507a) {
                    this.f25507a = true;
                    try {
                        c5913a.mo4985a();
                        c7363c.U_();
                    } catch (Throwable th) {
                        m33495b(th);
                    }
                }
            }

            /* renamed from: a */
            public void mo5116a(Throwable th) {
                if (this.f25507a) {
                    C5977c.m25068a(th);
                    C5912a.m24809c(th);
                    return;
                }
                this.f25507a = true;
                m33495b(th);
            }

            /* renamed from: b */
            void m33495b(Throwable th) {
                try {
                    c5914b.mo4974b(th);
                } catch (Throwable th2) {
                    c7363c.U_();
                }
                c7363c.U_();
            }

            /* renamed from: a */
            public void mo5115a(C5989l c5989l) {
                c7363c.m33768a(c5989l);
            }
        });
        return c7363c;
    }

    /* renamed from: c */
    static void m24809c(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    /* renamed from: a */
    public final void m24815a(C5921b c5921b) {
        C5912a.m24806a((Object) c5921b);
        try {
            C5977c.m25058a(this, this.f19633c).mo4974b(c5921b);
        } catch (C5921b c5921b2) {
            throw c5921b2;
        } catch (C5921b c5921b22) {
            C5903b.m24794b(c5921b22);
            Throwable e = C5977c.m25076e(c5921b22);
            C5977c.m25068a(e);
            c5921b22 = C5912a.m24808b(e);
        }
    }

    /* renamed from: a */
    public final <T> void m24816a(C7367k<T> c7367k) {
        m24807a((C7367k) c7367k, true);
    }

    /* renamed from: a */
    private <T> void m24807a(final C7367k<T> c7367k, boolean z) {
        C5912a.m24806a((Object) c7367k);
        if (z) {
            try {
                c7367k.mo6323c();
            } catch (C7367k<T> c7367k2) {
                throw c7367k2;
            } catch (C7367k<T> c7367k22) {
                C5903b.m24794b(c7367k22);
                Throwable c = C5977c.m25074c(c7367k22);
                C5977c.m25068a(c);
                c7367k22 = C5912a.m24808b(c);
            }
        }
        m24815a(new C5921b(this) {
            /* renamed from: b */
            final /* synthetic */ C5912a f25513b;

            /* renamed from: a */
            public void mo5114a() {
                c7367k22.L_();
            }

            /* renamed from: a */
            public void mo5116a(Throwable th) {
                c7367k22.mo5001a(th);
            }

            /* renamed from: a */
            public void mo5115a(C5989l c5989l) {
                c7367k22.m33781a(c5989l);
            }
        });
        C5977c.m25066a((C5989l) c7367k22);
    }

    /* renamed from: c */
    public final <R> R m24823c(C5919g<? super C5912a, R> c5919g) {
        return c5919g.mo4976a(this);
    }

    /* renamed from: c */
    public final <T> C5974e<T> m24822c() {
        return C5974e.m24972a(new C80489(this));
    }
}
