package com.google.android.gms.internal.p209h;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.h.p */
final class C4990p extends WeakReference<Throwable> {
    /* renamed from: a */
    private final int f16232a;

    public C4990p(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.f16232a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final int hashCode() {
        return this.f16232a;
    }

    public final boolean equals(Object obj) {
        if (obj != null) {
            if (obj.getClass() == getClass()) {
                if (this == obj) {
                    return true;
                }
                C4990p c4990p = (C4990p) obj;
                return this.f16232a == c4990p.f16232a && get() == c4990p.get();
            }
        }
        return false;
    }
}
