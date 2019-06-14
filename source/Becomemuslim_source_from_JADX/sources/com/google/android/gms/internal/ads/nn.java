package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@cm
final class nn<T> implements no<T> {
    /* renamed from: a */
    private final T f24182a;
    /* renamed from: b */
    private final nq f24183b = new nq();

    nn(T t) {
        this.f24182a = t;
        this.f24183b.m19952a();
    }

    /* renamed from: a */
    public final void mo4319a(Runnable runnable, Executor executor) {
        this.f24183b.m19953a(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        return false;
    }

    public final T get() {
        return this.f24182a;
    }

    public final T get(long j, TimeUnit timeUnit) {
        return this.f24182a;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return true;
    }
}
