package com.google.android.gms.internal.ads;

final class alm implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ all f14706a;

    alm(all all) {
        this.f14706a = all;
    }

    public final void run() {
        synchronized (this.f14706a.f14698c) {
            if (this.f14706a.f14699d && this.f14706a.f14700e) {
                this.f14706a.f14699d = false;
                mt.m19918b("App went background");
                for (aln a : this.f14706a.f14701f) {
                    try {
                        a.mo3846a(false);
                    } catch (Throwable e) {
                        mt.m19919b("", e);
                    }
                }
            } else {
                mt.m19918b("App is still foreground");
            }
        }
    }
}
