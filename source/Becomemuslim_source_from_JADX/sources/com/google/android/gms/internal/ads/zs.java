package com.google.android.gms.internal.ads;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class zs {
    /* renamed from: a */
    private final ConcurrentHashMap<zt, List<Throwable>> f16130a = new ConcurrentHashMap(16, 0.75f, 10);
    /* renamed from: b */
    private final ReferenceQueue<Throwable> f16131b = new ReferenceQueue();

    zs() {
    }

    /* renamed from: a */
    public final List<Throwable> m20205a(Throwable th, boolean z) {
        while (true) {
            Reference poll = this.f16131b.poll();
            if (poll != null) {
                this.f16130a.remove(poll);
            } else {
                return (List) this.f16130a.get(new zt(th, null));
            }
        }
    }
}
