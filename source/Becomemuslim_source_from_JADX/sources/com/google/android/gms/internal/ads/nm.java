package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@cm
final class nm<T> implements no<T> {
    /* renamed from: a */
    private final Throwable f24180a;
    /* renamed from: b */
    private final nq f24181b = new nq();

    nm(Throwable th) {
        this.f24180a = th;
        this.f24181b.m19952a();
    }

    /* renamed from: a */
    public final void mo4319a(Runnable runnable, Executor executor) {
        this.f24181b.m19953a(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        return false;
    }

    public final T get() {
        throw new ExecutionException(this.f24180a);
    }

    public final T get(long j, TimeUnit timeUnit) {
        throw new ExecutionException(this.f24180a);
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return true;
    }
}
