package com.google.android.gms.internal.ads;

import java.util.List;

final class ack extends ach {
    private ack() {
        super();
    }

    /* renamed from: c */
    private static <E> abv<E> m29738c(Object obj, long j) {
        return (abv) aep.m18251f(obj, j);
    }

    /* renamed from: a */
    final <L> List<L> mo3741a(Object obj, long j) {
        List c = m29738c(obj, j);
        if (c.mo3614a()) {
            return c;
        }
        int size = c.size();
        Object a = c.mo6027a(size == 0 ? 10 : size << 1);
        aep.m18229a(obj, j, a);
        return a;
    }

    /* renamed from: a */
    final <E> void mo3742a(Object obj, Object obj2, long j) {
        abv c = m29738c(obj, j);
        obj2 = m29738c(obj2, j);
        int size = c.size();
        int size2 = obj2.size();
        if (size > 0 && size2 > 0) {
            if (!c.mo3614a()) {
                c = c.mo6027a(size2 + size);
            }
            c.addAll(obj2);
        }
        if (size > 0) {
            obj2 = c;
        }
        aep.m18229a(obj, j, obj2);
    }

    /* renamed from: b */
    final void mo3743b(Object obj, long j) {
        m29738c(obj, j).mo3615b();
    }
}
