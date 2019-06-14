package com.polidea.p254a.p256b.p260d;

import com.polidea.p254a.p256b.p259c.C8245q;
import com.polidea.p254a.p256b.p262f.C5610w;
import com.polidea.p254a.p263c.C5619b;
import com.polidea.p254a.p263c.C5624e;
import p289e.C5974e;
import p289e.C5974e.C7337c;

/* compiled from: ScanSetupBuilderImplApi18 */
/* renamed from: com.polidea.a.b.d.t */
public class C7056t implements C5592s {
    /* renamed from: a */
    private final C5610w f25020a;
    /* renamed from: b */
    private final C5587d f25021b;
    /* renamed from: c */
    private final C5590p f25022c;

    C7056t(C5610w c5610w, C5587d c5587d, C5590p c5590p) {
        this.f25020a = c5610w;
        this.f25021b = c5587d;
        this.f25022c = c5590p;
    }

    /* renamed from: a */
    public C5591r mo5015a(C5624e c5624e, C5619b... c5619bArr) {
        final C7337c a = this.f25022c.m23797a(c5624e.m23915a());
        c5624e = this.f25022c.m23798b(c5624e.m23916b());
        return new C5591r(new C8245q(this.f25020a, this.f25021b, new C5586c(c5619bArr)), new C7337c<C5588h, C5588h>(this) {
            /* renamed from: c */
            final /* synthetic */ C7056t f29692c;

            /* renamed from: a */
            public C5974e<C5588h> m38708a(C5974e<C5588h> c5974e) {
                return c5974e.m24998a(a).m24998a(c5624e);
            }
        });
    }
}
