package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

final class nx extends mx {
    /* renamed from: a */
    private final Executor f28714a;

    private nx(Executor executor) {
        this.f28714a = executor;
    }

    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public final void execute(Runnable runnable) {
        this.f28714a.execute(runnable);
    }

    public final boolean isShutdown() {
        return false;
    }

    public final boolean isTerminated() {
        return false;
    }

    public final void shutdown() {
        throw new UnsupportedOperationException();
    }

    public final List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }
}
