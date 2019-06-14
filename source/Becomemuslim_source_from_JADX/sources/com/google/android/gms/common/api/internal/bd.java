package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.internal.C2798d.C4771a;

final class bd implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ C4775b f7133a;
    /* renamed from: b */
    private final /* synthetic */ C4771a f7134b;

    bd(C4771a c4771a, C4775b c4775b) {
        this.f7134b = c4771a;
        this.f7133a = c4775b;
    }

    public final void run() {
        this.f7134b.onConnectionFailed(this.f7133a);
    }
}
