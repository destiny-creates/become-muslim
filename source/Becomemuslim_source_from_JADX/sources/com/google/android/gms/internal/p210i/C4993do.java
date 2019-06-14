package com.google.android.gms.internal.p210i;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.i.do */
final class C4993do extends WeakReference<Throwable> {
    /* renamed from: a */
    private final int f16510a;

    public C4993do(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, null);
        if (th != null) {
            this.f16510a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final int hashCode() {
        return this.f16510a;
    }

    public final boolean equals(Object obj) {
        if (obj != null) {
            if (obj.getClass() == getClass()) {
                if (this == obj) {
                    return true;
                }
                C4993do c4993do = (C4993do) obj;
                return this.f16510a == c4993do.f16510a && get() == c4993do.get();
            }
        }
        return false;
    }
}
