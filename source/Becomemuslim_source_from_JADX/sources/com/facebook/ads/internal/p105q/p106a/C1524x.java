package com.facebook.ads.internal.p105q.p106a;

import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.internal.q.a.x */
public abstract class C1524x<T> implements Runnable {
    /* renamed from: a */
    private final WeakReference<T> f4505a;

    public C1524x(T t) {
        this.f4505a = new WeakReference(t);
    }

    /* renamed from: a */
    public T m5347a() {
        return this.f4505a.get();
    }
}
