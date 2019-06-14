package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

final /* synthetic */ class axw implements Runnable {
    /* renamed from: a */
    private final nz f15040a;
    /* renamed from: b */
    private final Future f15041b;

    axw(nz nzVar, Future future) {
        this.f15040a = nzVar;
        this.f15041b = future;
    }

    public final void run() {
        nz nzVar = this.f15040a;
        Future future = this.f15041b;
        if (nzVar.isCancelled()) {
            future.cancel(true);
        }
    }
}
