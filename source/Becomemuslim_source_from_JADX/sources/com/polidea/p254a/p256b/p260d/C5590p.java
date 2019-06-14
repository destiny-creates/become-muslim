package com.polidea.p254a.p256b.p260d;

import com.facebook.stetho.server.http.HttpStatus;
import com.polidea.p254a.p256b.C5615p;
import com.polidea.p254a.p256b.p262f.C5608t;
import com.polidea.p254a.p263c.C5616a;
import java.util.concurrent.TimeUnit;
import p289e.C5974e;
import p289e.C5974e.C7337c;
import p289e.C5986h;
import p289e.p291b.C5918f;
import p289e.p291b.C5919g;
import p289e.p298d.C7334c;

/* compiled from: ScanSettingsEmulator */
/* renamed from: com.polidea.a.b.d.p */
public class C5590p {
    /* renamed from: a */
    private final C5986h f18706a;
    /* renamed from: b */
    private C7337c<C5588h, C5588h> f18707b;
    /* renamed from: c */
    private C7337c<C5588h, C5588h> f18708c = new C79695(this);
    /* renamed from: d */
    private C7337c<C5588h, C5588h> f18709d = new C79707(this);

    /* compiled from: ScanSettingsEmulator */
    /* renamed from: com.polidea.a.b.d.p$4 */
    class C70534 implements C5919g<C5588h, C5588h> {
        /* renamed from: a */
        final /* synthetic */ C5590p f25017a;

        C70534(C5590p c5590p) {
            this.f25017a = c5590p;
        }

        /* renamed from: a */
        public C5588h m32934a(C5588h c5588h) {
            return new C5588h(c5588h.m23780a(), c5588h.m23781b(), c5588h.m23783d(), c5588h.m23782c(), C5616a.CALLBACK_TYPE_FIRST_MATCH);
        }
    }

    /* compiled from: ScanSettingsEmulator */
    /* renamed from: com.polidea.a.b.d.p$6 */
    class C70546 implements C5919g<C5588h, C5588h> {
        /* renamed from: a */
        final /* synthetic */ C5590p f25018a;

        C70546(C5590p c5590p) {
            this.f25018a = c5590p;
        }

        /* renamed from: a */
        public C5588h m32936a(C5588h c5588h) {
            return new C5588h(c5588h.m23780a(), c5588h.m23781b(), c5588h.m23783d(), c5588h.m23782c(), C5616a.CALLBACK_TYPE_MATCH_LOST);
        }
    }

    /* compiled from: ScanSettingsEmulator */
    /* renamed from: com.polidea.a.b.d.p$5 */
    class C79695 implements C7337c<C5588h, C5588h> {
        /* renamed from: a */
        final /* synthetic */ C5590p f29687a;

        C79695(C5590p c5590p) {
            this.f29687a = c5590p;
        }

        /* renamed from: a */
        public C5974e<C5588h> m38701a(C5974e<C5588h> c5974e) {
            return c5974e.m25009b(10, TimeUnit.SECONDS, this.f29687a.f18706a).m25030e(this.f29687a.m23794d());
        }
    }

    /* compiled from: ScanSettingsEmulator */
    /* renamed from: com.polidea.a.b.d.p$7 */
    class C79707 implements C7337c<C5588h, C5588h> {
        /* renamed from: a */
        final /* synthetic */ C5590p f29688a;

        /* compiled from: ScanSettingsEmulator */
        /* renamed from: com.polidea.a.b.d.p$7$1 */
        class C70551 implements C5919g<C5974e<C5588h>, C5974e<C5588h>> {
            /* renamed from: a */
            final /* synthetic */ C79707 f25019a;

            C70551(C79707 c79707) {
                this.f25019a = c79707;
            }

            /* renamed from: a */
            public C5974e<C5588h> m32938a(C5974e<C5588h> c5974e) {
                return C5974e.m24986c(c5974e.m24998a(this.f25019a.f29688a.f18707b), c5974e.m24998a(this.f25019a.f29688a.f18708c));
            }
        }

        C79707(C5590p c5590p) {
            this.f29688a = c5590p;
        }

        /* renamed from: a */
        public C5974e<C5588h> m38703a(C5974e<C5588h> c5974e) {
            return c5974e.m25032f(new C70551(this));
        }
    }

    public C5590p(final C5986h c5986h) {
        this.f18706a = c5986h;
        this.f18707b = new C7337c<C5588h, C5588h>(this) {
            /* renamed from: b */
            final /* synthetic */ C5590p f29677b;
            /* renamed from: c */
            private C5919g<C5588h, C5588h> f29678c = this.f29677b.m23791c();
            /* renamed from: d */
            private final C5974e<Long> f29679d = C5974e.m24969a(10, TimeUnit.SECONDS, c5986h);
            /* renamed from: e */
            private final C5919g<C5588h, C5974e<?>> f29680e = new C70461(this);
            /* renamed from: f */
            private final C5919g<C5974e<C5588h>, C5974e<C5588h>> f29681f = new C70472(this);

            /* compiled from: ScanSettingsEmulator */
            /* renamed from: com.polidea.a.b.d.p$1$1 */
            class C70461 implements C5919g<C5588h, C5974e<?>> {
                /* renamed from: a */
                final /* synthetic */ C79661 f25009a;

                C70461(C79661 c79661) {
                    this.f25009a = c79661;
                }

                /* renamed from: a */
                public C5974e<?> m32921a(C5588h c5588h) {
                    return this.f25009a.f29679d;
                }
            }

            /* compiled from: ScanSettingsEmulator */
            /* renamed from: com.polidea.a.b.d.p$1$2 */
            class C70472 implements C5919g<C5974e<C5588h>, C5974e<C5588h>> {
                /* renamed from: a */
                final /* synthetic */ C79661 f25010a;

                C70472(C79661 c79661) {
                    this.f25010a = c79661;
                }

                /* renamed from: a */
                public C5974e<C5588h> m32923a(C5974e<C5588h> c5974e) {
                    return c5974e.m25029e(1);
                }
            }

            /* compiled from: ScanSettingsEmulator */
            /* renamed from: com.polidea.a.b.d.p$1$3 */
            class C70493 implements C5919g<C5974e<C5588h>, C5974e<C5588h>> {
                /* renamed from: a */
                final /* synthetic */ C79661 f25013a;

                C70493(C79661 c79661) {
                    this.f25013a = c79661;
                }

                /* renamed from: a */
                public C5974e<C5588h> m32926a(final C5974e<C5588h> c5974e) {
                    return c5974e.m25012b(new C5918f<C5974e<?>>(this) {
                        /* renamed from: b */
                        final /* synthetic */ C70493 f25012b;

                        public /* synthetic */ Object call() {
                            return m32925a();
                        }

                        /* renamed from: a */
                        public C5974e<?> m32925a() {
                            return c5974e.m25037h(this.f25012b.f25013a.f29680e);
                        }
                    }).m25019c(this.f25013a.f29681f).m25030e(this.f25013a.f29678c);
                }
            }

            /* renamed from: a */
            public C5974e<C5588h> m38695a(C5974e<C5588h> c5974e) {
                return c5974e.m25032f(new C70493(this));
            }
        };
    }

    /* renamed from: a */
    C7337c<C5588h, C5588h> m23797a(int i) {
        switch (i) {
            case -1:
                C5615p.m23865b("Cannot emulate opportunistic scan mode since it is OS dependent - fallthrough to low power", new Object[0]);
                break;
            case 0:
                break;
            case 1:
                return m23787a();
            default:
                return C5608t.m23830a();
        }
        return m23789b();
    }

    /* renamed from: a */
    private C7337c<C5588h, C5588h> m23787a() {
        return m23793c(2500);
    }

    /* renamed from: b */
    private C7337c<C5588h, C5588h> m23789b() {
        return m23793c((int) HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
    }

    /* renamed from: c */
    private C7337c<C5588h, C5588h> m23793c(final int i) {
        final long max = Math.max(TimeUnit.SECONDS.toMillis(5) - ((long) i), 0);
        return new C7337c<C5588h, C5588h>(this) {
            /* renamed from: c */
            final /* synthetic */ C5590p f29684c;

            /* compiled from: ScanSettingsEmulator */
            /* renamed from: com.polidea.a.b.d.p$2$1 */
            class C70501 implements C5919g<C5974e<? extends Void>, C5974e<?>> {
                /* renamed from: a */
                final /* synthetic */ C79672 f25014a;

                C70501(C79672 c79672) {
                    this.f25014a = c79672;
                }

                /* renamed from: a */
                public C5974e<?> m32928a(C5974e<? extends Void> c5974e) {
                    return c5974e.m25017c(max, TimeUnit.MILLISECONDS, this.f25014a.f29684c.f18706a);
                }
            }

            /* renamed from: a */
            public C5974e<C5588h> m38697a(C5974e<C5588h> c5974e) {
                return c5974e.m25023d((long) i, TimeUnit.MILLISECONDS, this.f29684c.f18706a).m25034g(new C70501(this));
            }
        };
    }

    /* renamed from: b */
    C7337c<C5588h, C5588h> m23798b(int i) {
        if (i == 2) {
            return m23788a(this.f18707b);
        }
        if (i == 4) {
            return m23788a(this.f18708c);
        }
        if (i != 6) {
            return C5608t.m23830a();
        }
        return m23788a(this.f18709d);
    }

    /* renamed from: a */
    private C7337c<C5588h, C5588h> m23788a(final C7337c<C5588h, C5588h> c7337c) {
        return new C7337c<C5588h, C5588h>(this) {
            /* renamed from: b */
            final /* synthetic */ C5590p f29686b;

            /* compiled from: ScanSettingsEmulator */
            /* renamed from: com.polidea.a.b.d.p$3$1 */
            class C70511 implements C5919g<C7334c<String, C5588h>, C5974e<C5588h>> {
                /* renamed from: a */
                final /* synthetic */ C79683 f25015a;

                C70511(C79683 c79683) {
                    this.f25015a = c79683;
                }

                /* renamed from: a */
                public C5974e<C5588h> m32930a(C7334c<String, C5588h> c7334c) {
                    return c7334c.m24998a(c7337c);
                }
            }

            /* compiled from: ScanSettingsEmulator */
            /* renamed from: com.polidea.a.b.d.p$3$2 */
            class C70522 implements C5919g<C5588h, String> {
                /* renamed from: a */
                final /* synthetic */ C79683 f25016a;

                C70522(C79683 c79683) {
                    this.f25016a = c79683;
                }

                /* renamed from: a */
                public String m32933a(C5588h c5588h) {
                    return c5588h.m23780a().getAddress();
                }
            }

            /* renamed from: a */
            public C5974e<C5588h> m38699a(C5974e<C5588h> c5974e) {
                return c5974e.m25024d(new C70522(this)).m25019c(new C70511(this));
            }
        };
    }

    /* renamed from: c */
    private C5919g<C5588h, C5588h> m23791c() {
        return new C70534(this);
    }

    /* renamed from: d */
    private C5919g<C5588h, C5588h> m23794d() {
        return new C70546(this);
    }
}
