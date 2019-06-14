package com.polidea.p254a.p256b.p260d;

import com.polidea.p254a.p256b.p259c.C8246r;
import com.polidea.p254a.p256b.p262f.C5610w;
import com.polidea.p254a.p263c.C5619b;
import com.polidea.p254a.p263c.C5624e;
import p289e.C5974e;
import p289e.C5974e.C7337c;

/* compiled from: ScanSetupBuilderImplApi21 */
/* renamed from: com.polidea.a.b.d.v */
public class C7057v implements C5592s {
    /* renamed from: a */
    private final C5610w f25023a;
    /* renamed from: b */
    private final C5587d f25024b;
    /* renamed from: c */
    private final C5590p f25025c;
    /* renamed from: d */
    private final C5585a f25026d;

    C7057v(C5610w c5610w, C5587d c5587d, C5590p c5590p, C5585a c5585a) {
        this.f25023a = c5610w;
        this.f25024b = c5587d;
        this.f25025c = c5590p;
        this.f25026d = c5585a;
    }

    /* renamed from: a */
    public C5591r mo5015a(C5624e c5624e, C5619b... c5619bArr) {
        final C7337c b = this.f25025c.m23798b(c5624e.m23916b());
        return new C5591r(new C8246r(this.f25023a, this.f25024b, this.f25026d, c5624e, new C5586c(c5619bArr), null), new C7337c<C5588h, C5588h>(this) {
            /* renamed from: b */
            final /* synthetic */ C7057v f29697b;

            /* renamed from: a */
            public C5974e<C5588h> m38713a(C5974e<C5588h> c5974e) {
                return c5974e.m24998a(b);
            }
        });
    }
}
