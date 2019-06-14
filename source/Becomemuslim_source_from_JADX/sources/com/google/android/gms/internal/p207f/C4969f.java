package com.google.android.gms.internal.p207f;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.f.f */
final class C4969f extends WeakReference<Throwable> {
    /* renamed from: a */
    private final int f16212a;

    public C4969f(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.f16212a = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final int hashCode() {
        return this.f16212a;
    }

    public final boolean equals(Object obj) {
        if (obj != null) {
            if (obj.getClass() == getClass()) {
                if (this == obj) {
                    return true;
                }
                C4969f c4969f = (C4969f) obj;
                return this.f16212a == c4969f.f16212a && get() == c4969f.get();
            }
        }
        return false;
    }
}
