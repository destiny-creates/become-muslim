package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.C5232c;
import com.google.p217b.C5254e;
import com.google.p217b.C5314q;
import com.google.p217b.C6891h;
import com.google.p217b.p222b.C5196a;
import java.util.Map;

/* compiled from: UPCAReader */
/* renamed from: com.google.b.e.t */
public final class C8238t extends C7913y {
    /* renamed from: a */
    private final C7913y f32406a = new C8234i();

    /* renamed from: a */
    public C5314q mo6754a(int i, C5196a c5196a, int[] iArr, Map<C5254e, ?> map) {
        return C8238t.m42792a(this.f32406a.mo6754a(i, c5196a, iArr, (Map) map));
    }

    /* renamed from: a */
    public C5314q mo6260a(int i, C5196a c5196a, Map<C5254e, ?> map) {
        return C8238t.m42792a(this.f32406a.mo6260a(i, c5196a, (Map) map));
    }

    /* renamed from: a */
    public C5314q mo4858a(C5232c c5232c, Map<C5254e, ?> map) {
        return C8238t.m42792a(this.f32406a.mo4858a(c5232c, map));
    }

    /* renamed from: a */
    C5193a mo6751a() {
        return C5193a.UPC_A;
    }

    /* renamed from: a */
    protected int mo6750a(C5196a c5196a, int[] iArr, StringBuilder stringBuilder) {
        return this.f32406a.mo6750a(c5196a, iArr, stringBuilder);
    }

    /* renamed from: a */
    private static C5314q m42792a(C5314q c5314q) {
        String a = c5314q.m22571a();
        if (a.charAt(0) == '0') {
            C5314q c5314q2 = new C5314q(a.substring(1), null, c5314q.m22576c(), C5193a.UPC_A);
            if (c5314q.m22578e() != null) {
                c5314q2.m22573a(c5314q.m22578e());
            }
            return c5314q2;
        }
        throw C6891h.m32342a();
    }
}
