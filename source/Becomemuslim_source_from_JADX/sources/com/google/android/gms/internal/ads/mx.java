package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

@cm
public abstract class mx extends AbstractExecutorService implements nt {
    /* renamed from: a */
    public final no<?> mo4317a(Runnable runnable) {
        return (no) super.submit(runnable);
    }

    /* renamed from: a */
    public final <T> no<T> mo4318a(Callable<T> callable) {
        return (no) super.submit(callable);
    }

    protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new ns(runnable, t);
    }

    protected final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new ns(callable);
    }

    public /* synthetic */ Future submit(Runnable runnable) {
        return mo4317a(runnable);
    }

    public /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return (no) super.submit(runnable, obj);
    }

    public /* synthetic */ Future submit(Callable callable) {
        return mo4318a(callable);
    }
}
