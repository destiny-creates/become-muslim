package de.p287a.p288a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: PendingPost */
/* renamed from: de.a.a.h */
final class C5889h {
    /* renamed from: d */
    private static final List<C5889h> f19596d = new ArrayList();
    /* renamed from: a */
    Object f19597a;
    /* renamed from: b */
    C5894m f19598b;
    /* renamed from: c */
    C5889h f19599c;

    private C5889h(Object obj, C5894m c5894m) {
        this.f19597a = obj;
        this.f19598b = c5894m;
    }

    /* renamed from: a */
    static C5889h m24772a(C5894m c5894m, Object obj) {
        synchronized (f19596d) {
            int size = f19596d.size();
            if (size > 0) {
                C5889h c5889h = (C5889h) f19596d.remove(size - 1);
                c5889h.f19597a = obj;
                c5889h.f19598b = c5894m;
                c5889h.f19599c = null;
                return c5889h;
            }
            return new C5889h(obj, c5894m);
        }
    }

    /* renamed from: a */
    static void m24773a(C5889h c5889h) {
        c5889h.f19597a = null;
        c5889h.f19598b = null;
        c5889h.f19599c = null;
        synchronized (f19596d) {
            if (f19596d.size() < 10000) {
                f19596d.add(c5889h);
            }
        }
    }
}
