package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.nu;

final /* synthetic */ class aa implements Runnable {
    /* renamed from: a */
    private final C4745z f6691a;
    /* renamed from: b */
    private final Runnable f6692b;

    aa(C4745z c4745z, Runnable runnable) {
        this.f6691a = c4745z;
        this.f6692b = runnable;
    }

    public final void run() {
        nu.f15846a.execute(new ac(this.f6691a, this.f6692b));
    }
}
