package p289e.p292c.p293a;

import com.facebook.common.time.Clock;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p289e.C5970d;
import p289e.C5974e;
import p289e.C5974e.C7335a;
import p289e.C5974e.C7336b;
import p289e.C5984g;
import p289e.C5986h;
import p289e.C5989l;
import p289e.C7367k;
import p289e.p291b.C5913a;
import p289e.p291b.C5919g;
import p289e.p292c.p386b.C7284a;
import p289e.p299e.C5973e;
import p289e.p301g.C5983a;
import p289e.p302h.C7356d;
import p289e.p302h.C8149a;
import p289e.p303i.C7364d;

/* compiled from: OnSubscribeRedo */
/* renamed from: e.c.a.x */
public final class C8126x<T> implements C7335a<T> {
    /* renamed from: d */
    static final C5919g<C5974e<? extends C5970d<?>>, C5974e<?>> f30248d = new C72771();
    /* renamed from: a */
    final C5974e<T> f30249a;
    /* renamed from: b */
    final boolean f30250b;
    /* renamed from: c */
    final boolean f30251c;
    /* renamed from: e */
    private final C5919g<? super C5974e<? extends C5970d<?>>, ? extends C5974e<?>> f30252e;
    /* renamed from: f */
    private final C5986h f30253f;

    /* compiled from: OnSubscribeRedo */
    /* renamed from: e.c.a.x$1 */
    static class C72771 implements C5919g<C5974e<? extends C5970d<?>>, C5974e<?>> {

        /* compiled from: OnSubscribeRedo */
        /* renamed from: e.c.a.x$1$1 */
        class C72761 implements C5919g<C5970d<?>, C5970d<?>> {
            /* renamed from: a */
            final /* synthetic */ C72771 f25605a;

            C72761(C72771 c72771) {
                this.f25605a = c72771;
            }

            /* renamed from: a */
            public C5970d<?> m33586a(C5970d<?> c5970d) {
                return C5970d.m24952a((Object) null);
            }
        }

        C72771() {
        }

        /* renamed from: a */
        public C5974e<?> m33588a(C5974e<? extends C5970d<?>> c5974e) {
            return c5974e.m25030e(new C72761(this));
        }
    }

    /* compiled from: OnSubscribeRedo */
    /* renamed from: e.c.a.x$3 */
    class C81243 implements C7336b<C5970d<?>, C5970d<?>> {
        /* renamed from: a */
        final /* synthetic */ C8126x f30246a;

        C81243(C8126x c8126x) {
            this.f30246a = c8126x;
        }

        /* renamed from: a */
        public C7367k<? super C5970d<?>> m39464a(final C7367k<? super C5970d<?>> c7367k) {
            return new C7367k<C5970d<?>>(this, c7367k) {
                /* renamed from: b */
                final /* synthetic */ C81243 f30245b;

                public void L_() {
                    c7367k.L_();
                }

                /* renamed from: a */
                public void mo5001a(Throwable th) {
                    c7367k.mo5001a(th);
                }

                /* renamed from: a */
                public void m39460a(C5970d<?> c5970d) {
                    if (c5970d.m24960h() && this.f30245b.f30246a.f30250b) {
                        c7367k.L_();
                    } else if (c5970d.m24959g() && this.f30245b.f30246a.f30251c) {
                        c7367k.mo5001a((Throwable) c5970d.m24954b());
                    } else {
                        c7367k.mo5000a((Object) c5970d);
                    }
                }

                /* renamed from: a */
                public void mo6324a(C5984g c5984g) {
                    c5984g.mo5119a(Clock.MAX_TIME);
                }
            };
        }
    }

    /* renamed from: b */
    public /* synthetic */ void mo4974b(Object obj) {
        m39472a((C7367k) obj);
    }

    /* renamed from: a */
    public static <T> C5974e<T> m39469a(C5974e<T> c5974e) {
        return C8126x.m39470a(c5974e, f30248d);
    }

    /* renamed from: a */
    public static <T> C5974e<T> m39470a(C5974e<T> c5974e, C5919g<? super C5974e<? extends C5970d<?>>, ? extends C5974e<?>> c5919g) {
        return C5974e.m24972a(new C8126x(c5974e, c5919g, true, false, C5983a.m25107a()));
    }

    /* renamed from: b */
    public static <T> C5974e<T> m39471b(C5974e<T> c5974e, C5919g<? super C5974e<? extends C5970d<?>>, ? extends C5974e<?>> c5919g) {
        return C5974e.m24972a(new C8126x(c5974e, c5919g, false, true, C5983a.m25107a()));
    }

    private C8126x(C5974e<T> c5974e, C5919g<? super C5974e<? extends C5970d<?>>, ? extends C5974e<?>> c5919g, boolean z, boolean z2, C5986h c5986h) {
        this.f30249a = c5974e;
        this.f30252e = c5919g;
        this.f30250b = z;
        this.f30251c = z2;
        this.f30253f = c5986h;
    }

    /* renamed from: a */
    public void m39472a(C7367k<? super T> c7367k) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong();
        C5989l a = this.f30253f.mo5127a();
        c7367k.m33781a(a);
        final C5989l c7364d = new C7364d();
        c7367k.m33781a(c7364d);
        C7356d c = C8149a.m39535b().m33752c();
        c.m25015b(C5973e.m24964a());
        C7284a c7284a = new C7284a();
        final C7367k<? super T> c7367k2 = c7367k;
        final C7356d c7356d = c;
        final C7284a c7284a2 = c7284a;
        final AtomicLong atomicLong2 = atomicLong;
        C72782 c72782 = new C5913a(this) {
            /* renamed from: f */
            final /* synthetic */ C8126x f25611f;

            /* compiled from: OnSubscribeRedo */
            /* renamed from: e.c.a.x$2$1 */
            class C81221 extends C7367k<T> {
                /* renamed from: a */
                boolean f30242a;
                /* renamed from: b */
                final /* synthetic */ C72782 f30243b;

                C81221(C72782 c72782) {
                    this.f30243b = c72782;
                }

                public void L_() {
                    if (!this.f30242a) {
                        this.f30242a = true;
                        U_();
                        c7356d.mo5000a((Object) C5970d.m24951a());
                    }
                }

                /* renamed from: a */
                public void mo5001a(Throwable th) {
                    if (!this.f30242a) {
                        this.f30242a = true;
                        U_();
                        c7356d.mo5000a((Object) C5970d.m24953a(th));
                    }
                }

                /* renamed from: a */
                public void mo5000a(T t) {
                    if (!this.f30242a) {
                        c7367k2.mo5000a((Object) t);
                        m39456d();
                        c7284a2.m33600b(1);
                    }
                }

                /* renamed from: d */
                private void m39456d() {
                    long j;
                    do {
                        j = atomicLong2.get();
                        if (j == Clock.MAX_TIME) {
                            return;
                        }
                    } while (!atomicLong2.compareAndSet(j, j - 1));
                }

                /* renamed from: a */
                public void mo6324a(C5984g c5984g) {
                    c7284a2.m33599a(c5984g);
                }
            }

            /* renamed from: a */
            public void mo4985a() {
                if (!c7367k2.mo5121b()) {
                    C7367k c81221 = new C81221(this);
                    c7364d.m33770a(c81221);
                    this.f25611f.f30249a.m25007a(c81221);
                }
            }
        };
        final C5974e c5974e = (C5974e) this.f30252e.mo4976a(c.m24997a(new C81243(this)));
        final AtomicLong atomicLong3 = atomicLong;
        final C5989l c5989l = a;
        final C72782 c727822 = c72782;
        final AtomicBoolean atomicBoolean2 = atomicBoolean;
        a.mo6332a(new C5913a(this) {
            /* renamed from: g */
            final /* synthetic */ C8126x f25618g;

            /* renamed from: a */
            public void mo4985a() {
                c5974e.m25007a(new C7367k<Object>(this, c7367k2) {
                    /* renamed from: a */
                    final /* synthetic */ C72794 f30247a;

                    public void L_() {
                        c7367k2.L_();
                    }

                    /* renamed from: a */
                    public void mo5001a(Throwable th) {
                        c7367k2.mo5001a(th);
                    }

                    /* renamed from: a */
                    public void mo5000a(Object obj) {
                        if (c7367k2.mo5121b() != null) {
                            return;
                        }
                        if (atomicLong3.get() > 0) {
                            c5989l.mo6332a(c727822);
                        } else {
                            atomicBoolean2.compareAndSet(false, true);
                        }
                    }

                    /* renamed from: a */
                    public void mo6324a(C5984g c5984g) {
                        c5984g.mo5119a(Clock.MAX_TIME);
                    }
                });
            }
        });
        final AtomicLong atomicLong4 = atomicLong;
        final C7284a c7284a3 = c7284a;
        final AtomicBoolean atomicBoolean3 = atomicBoolean;
        c7367k.mo6324a(new C5984g(this) {
            /* renamed from: f */
            final /* synthetic */ C8126x f25624f;

            /* renamed from: a */
            public void mo5119a(long j) {
                if (j > 0) {
                    C5923a.m24836a(atomicLong4, j);
                    c7284a3.mo5119a(j);
                    if (atomicBoolean3.compareAndSet(true, false) != null) {
                        c5989l.mo6332a(c727822);
                    }
                }
            }
        });
    }
}
