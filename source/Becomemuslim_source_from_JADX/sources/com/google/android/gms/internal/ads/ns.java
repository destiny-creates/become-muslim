package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

@cm
final class ns<V> extends FutureTask<V> implements no<V> {
    /* renamed from: a */
    private final nq f24184a = new nq();

    ns(Runnable runnable, V v) {
        super(runnable, v);
    }

    ns(Callable<V> callable) {
        super(callable);
    }

    /* renamed from: a */
    public final void mo4319a(Runnable runnable, Executor executor) {
        this.f24184a.m19953a(runnable, executor);
    }

    protected final void done() {
        this.f24184a.m19952a();
    }
}
