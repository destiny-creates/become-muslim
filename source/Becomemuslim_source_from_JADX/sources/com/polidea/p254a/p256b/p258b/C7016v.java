package com.polidea.p254a.p256b.p258b;

import com.p071c.p072a.C4536c;
import com.polidea.p254a.aa.C5552a;
import com.polidea.p254a.p255a.C5548g;
import com.polidea.p254a.p255a.C6973f;
import com.polidea.p254a.p255a.C6974l;
import com.polidea.p254a.p256b.p262f.C5610w;
import p289e.C5974e;
import p289e.p291b.C5919g;

/* compiled from: DisconnectionRouter */
/* renamed from: com.polidea.a.b.b.v */
class C7016v implements C5575w {
    /* renamed from: a */
    private final C4536c<C5548g> f24955a = C4536c.b();
    /* renamed from: b */
    private final C5974e<C5548g> f24956b;

    /* compiled from: DisconnectionRouter */
    /* renamed from: com.polidea.a.b.b.v$2 */
    class C70132 implements C5919g<Boolean, Boolean> {
        /* renamed from: a */
        final /* synthetic */ C7016v f24952a;

        C70132(C7016v c7016v) {
            this.f24952a = c7016v;
        }

        /* renamed from: a */
        public Boolean m32853a(Boolean bool) {
            return Boolean.valueOf(bool.booleanValue() ^ 1);
        }
    }

    /* compiled from: DisconnectionRouter */
    /* renamed from: com.polidea.a.b.b.v$3 */
    class C70143 implements C5919g<C5552a, Boolean> {
        /* renamed from: a */
        final /* synthetic */ C7016v f24953a;

        C70143(C7016v c7016v) {
            this.f24953a = c7016v;
        }

        /* renamed from: a */
        public Boolean m32855a(C5552a c5552a) {
            return Boolean.valueOf(c5552a.m23617a());
        }
    }

    /* compiled from: DisconnectionRouter */
    /* renamed from: com.polidea.a.b.b.v$4 */
    class C70154 implements C5919g<C5548g, C5974e<T>> {
        /* renamed from: a */
        final /* synthetic */ C7016v f24954a;

        C70154(C7016v c7016v) {
            this.f24954a = c7016v;
        }

        /* renamed from: a */
        public C5974e<T> m32857a(C5548g c5548g) {
            return C5974e.m24984b((Throwable) c5548g);
        }
    }

    C7016v(final String str, C5610w c5610w, C5974e<C5552a> c5974e) {
        this.f24956b = C5974e.m24986c(this.f24955a, c5974e.m25030e(new C70143(this)).m25026d(Boolean.valueOf(c5610w.m23842b())).m25013b(new C70132(this)).m25030e(new C5919g<Boolean, C5548g>(this) {
            /* renamed from: b */
            final /* synthetic */ C7016v f24951b;

            /* renamed from: a */
            public C5548g m32851a(Boolean bool) {
                return C6973f.m32746a(str);
            }
        })).m25042k().m25036h();
        this.f24956b.m25047o();
    }

    /* renamed from: a */
    public void m32860a(C6973f c6973f) {
        this.f24955a.b(c6973f);
    }

    /* renamed from: a */
    public void m32861a(C6974l c6974l) {
        this.f24955a.b(c6974l);
    }

    /* renamed from: a */
    public C5974e<C5548g> mo4997a() {
        return this.f24956b;
    }

    /* renamed from: b */
    public <T> C5974e<T> m32862b() {
        return this.f24956b.m25019c(new C70154(this));
    }
}
