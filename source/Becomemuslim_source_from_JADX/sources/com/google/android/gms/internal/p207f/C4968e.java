package com.google.android.gms.internal.p207f;

import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.f.e */
final class C4968e {
    /* renamed from: a */
    private final ConcurrentHashMap<C4969f, List<Throwable>> f16210a = new ConcurrentHashMap(16, 0.75f, 10);
    /* renamed from: b */
    private final ReferenceQueue<Throwable> f16211b = new ReferenceQueue();

    C4968e() {
    }

    /* renamed from: a */
    public final List<Throwable> m20247a(Throwable th, boolean z) {
        z = this.f16211b.poll();
        while (z) {
            this.f16210a.remove(z);
            z = this.f16211b.poll();
        }
        List list = (List) this.f16210a.get(new C4969f(th, null));
        if (list != null) {
            return list;
        }
        z = new Vector(2);
        List list2 = (List) this.f16210a.putIfAbsent(new C4969f(th, this.f16211b), z);
        return list2 == null ? z : list2;
    }
}
