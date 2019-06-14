package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

final /* synthetic */ class nr implements Runnable {
    /* renamed from: a */
    private final Executor f15844a;
    /* renamed from: b */
    private final Runnable f15845b;

    nr(Executor executor, Runnable runnable) {
        this.f15844a = executor;
        this.f15845b = runnable;
    }

    public final void run() {
        this.f15844a.execute(this.f15845b);
    }
}
