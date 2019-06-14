package com.polidea.p254a.p256b.p260d;

import com.polidea.p254a.p256b.p259c.C8246r;
import com.polidea.p254a.p256b.p262f.C5610w;
import com.polidea.p254a.p263c.C5619b;
import com.polidea.p254a.p263c.C5624e;
import p289e.C5974e;
import p289e.C5974e.C7337c;

/* compiled from: ScanSetupBuilderImplApi23 */
/* renamed from: com.polidea.a.b.d.x */
public class C7058x implements C5592s {
    /* renamed from: a */
    private final C5610w f25027a;
    /* renamed from: b */
    private final C5587d f25028b;
    /* renamed from: c */
    private final C5585a f25029c;

    /* compiled from: ScanSetupBuilderImplApi23 */
    /* renamed from: com.polidea.a.b.d.x$1 */
    class C79761 implements C7337c<C5588h, C5588h> {
        /* renamed from: a */
        final /* synthetic */ C7058x f29702a;

        /* renamed from: a */
        public C5974e<C5588h> m38718a(C5974e<C5588h> c5974e) {
            return c5974e;
        }

        C79761(C7058x c7058x) {
            this.f29702a = c7058x;
        }
    }

    C7058x(C5610w c5610w, C5587d c5587d, C5585a c5585a) {
        this.f25027a = c5610w;
        this.f25028b = c5587d;
        this.f25029c = c5585a;
    }

    /* renamed from: a */
    public C5591r mo5015a(C5624e c5624e, C5619b... c5619bArr) {
        if (c5624e.m23916b() != 1 && c5619bArr.length == 0) {
            c5619bArr = new C5619b[]{C5619b.m23889k()};
        }
        return new C5591r(new C8246r(this.f25027a, this.f25028b, this.f25029c, c5624e, new C5586c(new C5619b[0]), c5619bArr), new C79761(this));
    }
}
