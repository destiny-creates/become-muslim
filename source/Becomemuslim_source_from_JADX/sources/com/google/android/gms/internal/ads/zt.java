package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zt extends WeakReference<Throwable> {
    /* renamed from: a */
    private final int f16132a;

    public zt(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, null);
        if (th != null) {
            this.f16132a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null) {
            if (obj.getClass() == getClass()) {
                if (this == obj) {
                    return true;
                }
                zt ztVar = (zt) obj;
                return this.f16132a == ztVar.f16132a && get() == ztVar.get();
            }
        }
    }

    public final int hashCode() {
        return this.f16132a;
    }
}
