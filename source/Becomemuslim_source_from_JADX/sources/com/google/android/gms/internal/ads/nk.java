package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

final /* synthetic */ class nk implements Runnable {
    /* renamed from: a */
    private final nz f15835a;
    /* renamed from: b */
    private final no f15836b;

    nk(nz nzVar, no noVar) {
        this.f15835a = nzVar;
        this.f15836b = noVar;
    }

    public final void run() {
        Throwable cause;
        nz nzVar = this.f15835a;
        try {
            nzVar.m30915b(this.f15836b.get());
        } catch (ExecutionException e) {
            cause = e.getCause();
            nzVar.m30914a(cause);
        } catch (InterruptedException e2) {
            cause = e2;
            Thread.currentThread().interrupt();
            nzVar.m30914a(cause);
        } catch (Throwable cause2) {
            nzVar.m30914a(cause2);
        }
    }
}
