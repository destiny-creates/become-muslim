package com.polidea.p254a;

import com.polidea.p254a.C5550a.C5546a;
import com.polidea.p254a.aa.C5552a;
import com.polidea.p254a.p255a.C6975n;
import com.polidea.p254a.p256b.C5613n;
import com.polidea.p254a.p256b.p260d.C5588h;
import com.polidea.p254a.p256b.p260d.C5589i;
import com.polidea.p254a.p256b.p260d.C5591r;
import com.polidea.p254a.p256b.p260d.C5592s;
import com.polidea.p254a.p256b.p261e.C5593a;
import com.polidea.p254a.p256b.p262f.C5607o;
import com.polidea.p254a.p256b.p262f.C5610w;
import com.polidea.p254a.p256b.p262f.C7076k;
import com.polidea.p254a.p256b.p262f.aa;
import com.polidea.p254a.p263c.C5619b;
import com.polidea.p254a.p263c.C5621d;
import com.polidea.p254a.p263c.C5624e;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import p000a.p001a.C0002a;
import p289e.C5974e;
import p289e.C5986h;
import p289e.p291b.C5918f;
import p289e.p291b.C5919g;

/* compiled from: RxBleClientImpl */
/* renamed from: com.polidea.a.ad */
class ad extends ac {
    /* renamed from: a */
    private final C5593a f24876a;
    /* renamed from: b */
    private final aa f24877b;
    /* renamed from: c */
    private final C5613n f24878c;
    /* renamed from: d */
    private final C5592s f24879d;
    /* renamed from: e */
    private final C5589i f24880e;
    /* renamed from: f */
    private final C5919g<C5588h, C5621d> f24881f;
    /* renamed from: g */
    private final C5546a f24882g;
    /* renamed from: h */
    private final C5986h f24883h;
    /* renamed from: i */
    private final Map<Set<UUID>, C5974e<Object>> f24884i = new HashMap();
    /* renamed from: j */
    private final C5610w f24885j;
    /* renamed from: k */
    private final C5974e<C5552a> f24886k;
    /* renamed from: l */
    private final C5607o f24887l;
    /* renamed from: m */
    private final C0002a<C7076k> f24888m;

    /* compiled from: RxBleClientImpl */
    /* renamed from: com.polidea.a.ad$2 */
    class C69802 implements C5919g<C5552a, C5974e<? extends T>> {
        /* renamed from: a */
        final /* synthetic */ ad f24874a;

        C69802(ad adVar) {
            this.f24874a = adVar;
        }

        /* renamed from: a */
        public C5974e<? extends T> m32766a(C5552a c5552a) {
            return C5974e.m24984b(new C6975n(1));
        }
    }

    /* compiled from: RxBleClientImpl */
    /* renamed from: com.polidea.a.ad$3 */
    class C69813 implements C5919g<C5552a, Boolean> {
        /* renamed from: a */
        final /* synthetic */ ad f24875a;

        C69813(ad adVar) {
            this.f24875a = adVar;
        }

        /* renamed from: a */
        public Boolean m32768a(C5552a c5552a) {
            return Boolean.valueOf(c5552a != C5552a.f18610a ? true : null);
        }
    }

    ad(C5610w c5610w, C5593a c5593a, C5974e<C5552a> c5974e, aa aaVar, C5607o c5607o, C0002a<C7076k> c0002a, C5613n c5613n, C5592s c5592s, C5589i c5589i, C5919g<C5588h, C5621d> c5919g, C5986h c5986h, C5546a c5546a) {
        this.f24877b = aaVar;
        this.f24876a = c5593a;
        this.f24885j = c5610w;
        this.f24886k = c5974e;
        this.f24887l = c5607o;
        this.f24888m = c0002a;
        this.f24878c = c5613n;
        this.f24879d = c5592s;
        this.f24880e = c5589i;
        this.f24881f = c5919g;
        this.f24883h = c5986h;
        this.f24882g = c5546a;
    }

    protected void finalize() {
        this.f24882g.mo4972a();
        super.finalize();
    }

    /* renamed from: a */
    public ah mo4977a(String str) {
        m32773b();
        return this.f24878c.m23857a(str);
    }

    /* renamed from: a */
    public C5974e<C5621d> mo4978a(final C5624e c5624e, final C5619b... c5619bArr) {
        return C5974e.m24971a(new C5918f<C5974e<C5621d>>(this) {
            /* renamed from: c */
            final /* synthetic */ ad f24873c;

            public /* synthetic */ Object call() {
                return m32765a();
            }

            /* renamed from: a */
            public C5974e<C5621d> m32765a() {
                this.f24873c.f24880e.mo5009a();
                C5591r a = this.f24873c.f24879d.mo5015a(c5624e, c5619bArr);
                return this.f24873c.f24876a.mo5016a(a.f18710a).m25020c(this.f24873c.f24883h).m24998a(a.f18711b).m25030e(this.f24873c.f24881f).m25033f(this.f24873c.m32771a());
            }
        });
    }

    /* renamed from: a */
    private <T> C5974e<T> m32771a() {
        return this.f24886k.m25013b(new C69813(this)).m25042k().m25019c(new C69802(this));
    }

    /* renamed from: b */
    private void m32773b() {
        if (!this.f24885j.m23839a()) {
            throw new UnsupportedOperationException("RxAndroidBle library needs a BluetoothAdapter to be available in the system to work. If this is a test on an emulator then you can use 'https://github.com/Polidea/RxAndroidBle/tree/master/mockrxandroidble'");
        }
    }
}
