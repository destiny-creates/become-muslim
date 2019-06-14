package com.polidea.p254a.p256b.p262f;

import com.polidea.p254a.aa.C5552a;
import com.polidea.p254a.ac.C5553a;
import java.util.concurrent.TimeUnit;
import p289e.C5974e;
import p289e.C5982f;
import p289e.C5986h;
import p289e.C5988i;
import p289e.C5989l;
import p289e.C7332c;
import p289e.C7332c.C5922a;
import p289e.p291b.C5914b;
import p289e.p291b.C5917e;
import p289e.p291b.C5919g;
import p289e.p292c.p293a.C8106m;

/* compiled from: ClientStateObservable */
/* renamed from: com.polidea.a.b.f.k */
public class C7076k extends C5974e<C5553a> {

    /* compiled from: ClientStateObservable */
    /* renamed from: com.polidea.a.b.f.k$1 */
    class C70701 implements C5914b<C7332c<C5553a>> {
        /* renamed from: a */
        final /* synthetic */ C5610w f25045a;
        /* renamed from: b */
        final /* synthetic */ C5607o f25046b;
        /* renamed from: c */
        final /* synthetic */ C5986h f25047c;
        /* renamed from: d */
        final /* synthetic */ C5974e f25048d;
        /* renamed from: e */
        final /* synthetic */ C5974e f25049e;

        /* compiled from: ClientStateObservable */
        /* renamed from: com.polidea.a.b.f.k$1$1 */
        class C70681 implements C5919g<Boolean, C5974e<C5553a>> {
            /* renamed from: a */
            final /* synthetic */ C70701 f25042a;

            C70681(C70701 c70701) {
                this.f25042a = c70701;
            }

            /* renamed from: a */
            public C5974e<C5553a> m32955a(Boolean bool) {
                return C7076k.m32972b(bool, this.f25042a.f25045a, this.f25042a.f25048d, this.f25042a.f25049e);
            }
        }

        C70701(C5610w c5610w, C5607o c5607o, C5986h c5986h, C5974e c5974e, C5974e c5974e2) {
            this.f25045a = c5610w;
            this.f25046b = c5607o;
            this.f25047c = c5986h;
            this.f25048d = c5974e;
            this.f25049e = c5974e2;
        }

        /* renamed from: b */
        public /* synthetic */ void mo4974b(Object obj) {
            m32958a((C7332c) obj);
        }

        /* renamed from: a */
        public void m32958a(C7332c<C5553a> c7332c) {
            if (this.f25045a.m23839a()) {
                final C5989l a = C7076k.m32973b(this.f25046b, this.f25047c).m25122a(new C70681(this)).m25040j().m25006a((C5982f) c7332c);
                c7332c.mo6330a(new C5917e(this) {
                    /* renamed from: b */
                    final /* synthetic */ C70701 f25044b;

                    /* renamed from: a */
                    public void mo4973a() {
                        a.U_();
                    }
                });
                return;
            }
            c7332c.L_();
        }
    }

    /* compiled from: ClientStateObservable */
    /* renamed from: com.polidea.a.b.f.k$2 */
    static class C70712 implements C5919g<Integer, Boolean> {
        C70712() {
        }

        /* renamed from: a */
        public Boolean m32960a(Integer num) {
            return Boolean.valueOf(num.intValue() == null ? true : null);
        }
    }

    /* compiled from: ClientStateObservable */
    /* renamed from: com.polidea.a.b.f.k$3 */
    static class C70723 implements C5919g<Boolean, Boolean> {
        C70723() {
        }

        /* renamed from: a */
        public Boolean m32962a(Boolean bool) {
            return Boolean.valueOf(bool.booleanValue() ^ 1);
        }
    }

    protected C7076k(C5610w c5610w, C5974e<C5552a> c5974e, C5974e<Boolean> c5974e2, C5607o c5607o, C5986h c5986h) {
        super(new C8106m(new C70701(c5610w, c5607o, c5986h, c5974e, c5974e2), C5922a.LATEST));
    }

    /* renamed from: b */
    private static C5988i<Boolean> m32973b(final C5607o c5607o, C5986h c5986h) {
        return C5974e.m24967a(0, 1, TimeUnit.SECONDS, c5986h).m25030e(new C5919g<Long, Boolean>() {
            /* renamed from: a */
            public Boolean m32964a(Long l) {
                return Boolean.valueOf(c5607o.mo5019a());
            }
        }).m25041j(new C70723()).m25038i().m25027d().m25124b(new C70712());
    }

    /* renamed from: b */
    private static C5974e<C5553a> m32972b(Boolean bool, C5610w c5610w, C5974e<C5552a> c5974e, final C5974e<Boolean> c5974e2) {
        c5610w = c5974e.m25026d(c5610w.m23842b() != null ? C5552a.f18610a : C5552a.f18611b).m25037h(new C5919g<C5552a, C5974e<C5553a>>() {

            /* compiled from: ClientStateObservable */
            /* renamed from: com.polidea.a.b.f.k$5$1 */
            class C70741 implements C5919g<Boolean, C5553a> {
                /* renamed from: a */
                final /* synthetic */ C70755 f25051a;

                C70741(C70755 c70755) {
                    this.f25051a = c70755;
                }

                /* renamed from: a */
                public C5553a m32966a(Boolean bool) {
                    return bool.booleanValue() != null ? C5553a.READY : C5553a.LOCATION_SERVICES_NOT_ENABLED;
                }
            }

            /* renamed from: a */
            public C5974e<C5553a> m32968a(C5552a c5552a) {
                if (c5552a != C5552a.f18610a) {
                    return C5974e.m24987c(C5553a.BLUETOOTH_NOT_ENABLED);
                }
                return c5974e2.m25030e(new C70741(this));
            }
        });
        return bool.booleanValue() != null ? c5610w.m25022d(1) : c5610w;
    }
}
