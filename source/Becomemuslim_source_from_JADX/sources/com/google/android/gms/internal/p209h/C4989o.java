package com.google.android.gms.internal.p209h;

import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.h.o */
final class C4989o {
    /* renamed from: a */
    private final ConcurrentHashMap<C4990p, List<Throwable>> f16230a = new ConcurrentHashMap(16, 0.75f, 10);
    /* renamed from: b */
    private final ReferenceQueue<Throwable> f16231b = new ReferenceQueue();

    C4989o() {
    }

    /* renamed from: a */
    public final List<Throwable> m20275a(Throwable th, boolean z) {
        z = this.f16231b.poll();
        while (z) {
            this.f16230a.remove(z);
            z = this.f16231b.poll();
        }
        List list = (List) this.f16230a.get(new C4990p(th, null));
        if (list != null) {
            return list;
        }
        z = new Vector(2);
        List list2 = (List) this.f16230a.putIfAbsent(new C4990p(th, this.f16231b), z);
        return list2 == null ? z : list2;
    }
}
