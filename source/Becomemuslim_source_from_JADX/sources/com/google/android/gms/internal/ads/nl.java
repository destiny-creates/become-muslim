package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

final /* synthetic */ class nl implements Runnable {
    /* renamed from: a */
    private final no f15837a;
    /* renamed from: b */
    private final Future f15838b;

    nl(no noVar, Future future) {
        this.f15837a = noVar;
        this.f15838b = future;
    }

    public final void run() {
        no noVar = this.f15837a;
        Future future = this.f15838b;
        if (noVar.isCancelled()) {
            future.cancel(true);
        }
    }
}
