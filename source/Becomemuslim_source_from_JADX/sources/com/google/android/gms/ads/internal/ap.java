package com.google.android.gms.ads.internal;

import android.os.Handler;

public final class ap {
    /* renamed from: a */
    private final Handler f6728a;

    public ap(Handler handler) {
        this.f6728a = handler;
    }

    /* renamed from: a */
    public final void m7446a(Runnable runnable) {
        this.f6728a.removeCallbacks(runnable);
    }

    /* renamed from: a */
    public final boolean m7447a(Runnable runnable, long j) {
        return this.f6728a.postDelayed(runnable, j);
    }
}
