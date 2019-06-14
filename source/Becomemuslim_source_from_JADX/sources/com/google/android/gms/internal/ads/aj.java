package com.google.android.gms.internal.ads;

final class aj implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ ai f14584a;

    aj(ai aiVar) {
        this.f14584a = aiVar;
    }

    public final void run() {
        if (this.f14584a.f23631h.get()) {
            mt.m19920c("Timed out waiting for WebView to finish loading.");
            this.f14584a.mo3818b();
        }
    }
}
