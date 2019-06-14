package com.google.android.gms.internal.p210i;

import java.util.List;

/* renamed from: com.google.android.gms.internal.i.gf */
final class gf extends gc {
    private gf() {
        super();
    }

    /* renamed from: a */
    final <L> List<L> mo4556a(Object obj, long j) {
        List<L> c = gf.m31604c(obj, j);
        if (c.mo4429a()) {
            return c;
        }
        int size = c.size();
        Object a = c.mo6150a(size == 0 ? 10 : size << 1);
        ih.m20820a(obj, j, a);
        return a;
    }

    /* renamed from: b */
    final void mo4558b(Object obj, long j) {
        gf.m31604c(obj, j).mo4430b();
    }

    /* renamed from: a */
    final <E> void mo4557a(Object obj, Object obj2, long j) {
        fr c = gf.m31604c(obj, j);
        obj2 = gf.m31604c(obj2, j);
        int size = c.size();
        int size2 = obj2.size();
        if (size > 0 && size2 > 0) {
            if (!c.mo4429a()) {
                c = c.mo6150a(size2 + size);
            }
            c.addAll(obj2);
        }
        if (size > 0) {
            obj2 = c;
        }
        ih.m20820a(obj, j, obj2);
    }

    /* renamed from: c */
    private static <E> fr<E> m31604c(Object obj, long j) {
        return (fr) ih.m20843f(obj, j);
    }
}
