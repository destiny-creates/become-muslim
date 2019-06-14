package com.google.p217b.p235f;

import com.google.p217b.C5193a;
import com.google.p217b.C5232c;
import com.google.p217b.C5254e;
import com.google.p217b.C5312o;
import com.google.p217b.C5314q;
import com.google.p217b.C5315r;
import com.google.p217b.C5316s;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5205e;
import com.google.p217b.p235f.p236a.C5268j;
import com.google.p217b.p235f.p238b.C5270a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: PDF417Reader */
/* renamed from: com.google.b.f.b */
public final class C6877b implements C5312o {
    /* renamed from: a */
    public C5314q mo4858a(C5232c c5232c, Map<C5254e, ?> map) {
        c5232c = C6877b.m32315a(c5232c, map, false);
        if (c5232c != null && c5232c.length != null && c5232c[0] != null) {
            return c5232c[0];
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    private static C5314q[] m32315a(C5232c c5232c, Map<C5254e, ?> map, boolean z) {
        List arrayList = new ArrayList();
        c5232c = C5270a.m22356a(c5232c, (Map) map, z);
        map = c5232c.m22363b().iterator();
        while (map.hasNext()) {
            C5316s[] c5316sArr = (C5316s[]) map.next();
            C5205e a = C5268j.m22335a(c5232c.m22362a(), c5316sArr[4], c5316sArr[5], c5316sArr[6], c5316sArr[7], C6877b.m32317b(c5316sArr), C6877b.m32314a(c5316sArr));
            C5314q c5314q = new C5314q(a.m22026c(), a.m22023a(), c5316sArr, C5193a.PDF_417);
            c5314q.m22572a(C5315r.ERROR_CORRECTION_LEVEL, a.m22028e());
            C5280c c5280c = (C5280c) a.m22029f();
            if (c5280c != null) {
                c5314q.m22572a(C5315r.PDF417_EXTRA_METADATA, c5280c);
            }
            arrayList.add(c5314q);
        }
        return (C5314q[]) arrayList.toArray(new C5314q[arrayList.size()]);
    }

    /* renamed from: a */
    private static int m32313a(C5316s c5316s, C5316s c5316s2) {
        if (c5316s != null) {
            if (c5316s2 != null) {
                return (int) Math.abs(c5316s.m22582a() - c5316s2.m22582a());
            }
        }
        return null;
    }

    /* renamed from: b */
    private static int m32316b(C5316s c5316s, C5316s c5316s2) {
        if (c5316s != null) {
            if (c5316s2 != null) {
                return (int) Math.abs(c5316s.m22582a() - c5316s2.m22582a());
            }
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: a */
    private static int m32314a(C5316s[] c5316sArr) {
        return Math.max(Math.max(C6877b.m32313a(c5316sArr[0], c5316sArr[4]), (C6877b.m32313a(c5316sArr[6], c5316sArr[2]) * 17) / 18), Math.max(C6877b.m32313a(c5316sArr[1], c5316sArr[5]), (C6877b.m32313a(c5316sArr[7], c5316sArr[3]) * 17) / 18));
    }

    /* renamed from: b */
    private static int m32317b(C5316s[] c5316sArr) {
        return Math.min(Math.min(C6877b.m32316b(c5316sArr[0], c5316sArr[4]), (C6877b.m32316b(c5316sArr[6], c5316sArr[2]) * 17) / 18), Math.min(C6877b.m32316b(c5316sArr[1], c5316sArr[5]), (C6877b.m32316b(c5316sArr[7], c5316sArr[3]) * 17) / 18));
    }
}
