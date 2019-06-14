package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

final class ex implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ Future f15370a;

    ex(eu euVar, Future future) {
        this.f15370a = future;
    }

    public final void run() {
        if (!this.f15370a.isDone()) {
            this.f15370a.cancel(true);
        }
    }
}
