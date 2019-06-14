package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

final /* synthetic */ class ni implements Runnable {
    /* renamed from: a */
    private final Future f15829a;

    ni(Future future) {
        this.f15829a = future;
    }

    public final void run() {
        Future future = this.f15829a;
        if (!future.isDone()) {
            future.cancel(true);
        }
    }
}
