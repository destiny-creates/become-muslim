package com.google.android.gms.internal.ads;

final class aro implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ arn f14886a;

    aro(arn arn) {
        this.f14886a = arn;
    }

    public final void run() {
        if (this.f14886a.f28297a.f28296a != null) {
            try {
                this.f14886a.f28297a.f28296a.mo3859a(1);
            } catch (Throwable e) {
                mt.m19921c("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
