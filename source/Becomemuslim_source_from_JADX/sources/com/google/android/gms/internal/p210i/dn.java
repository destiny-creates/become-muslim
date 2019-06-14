package com.google.android.gms.internal.p210i;

import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.i.dn */
final class dn {
    /* renamed from: a */
    private final ConcurrentHashMap<C4993do, List<Throwable>> f16508a = new ConcurrentHashMap(16, 0.75f, 10);
    /* renamed from: b */
    private final ReferenceQueue<Throwable> f16509b = new ReferenceQueue();

    dn() {
    }

    /* renamed from: a */
    public final List<Throwable> m20445a(Throwable th, boolean z) {
        z = this.f16509b.poll();
        while (z) {
            this.f16508a.remove(z);
            z = this.f16509b.poll();
        }
        return (List) this.f16508a.get(new C4993do(th, null));
    }
}
