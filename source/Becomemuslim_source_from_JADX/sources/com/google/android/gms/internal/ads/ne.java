package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

final /* synthetic */ class ne implements Runnable {
    /* renamed from: a */
    private final na f15820a;
    /* renamed from: b */
    private final no f15821b;

    ne(na naVar, no noVar) {
        this.f15820a = naVar;
        this.f15821b = noVar;
    }

    public final void run() {
        Throwable cause;
        na naVar = this.f15820a;
        try {
            naVar.mo4229a(this.f15821b.get());
        } catch (ExecutionException e) {
            cause = e.getCause();
            naVar.mo4230a(cause);
        } catch (InterruptedException e2) {
            cause = e2;
            Thread.currentThread().interrupt();
            naVar.mo4230a(cause);
        } catch (Exception e3) {
            cause = e3;
            naVar.mo4230a(cause);
        }
    }
}
