package com.google.android.gms.common.util.p183a;

import android.os.Process;

/* renamed from: com.google.android.gms.common.util.a.d */
final class C2890d implements Runnable {
    /* renamed from: a */
    private final Runnable f7376a;
    /* renamed from: b */
    private final int f7377b;

    public C2890d(Runnable runnable, int i) {
        this.f7376a = runnable;
        this.f7377b = i;
    }

    public final void run() {
        Process.setThreadPriority(this.f7377b);
        this.f7376a.run();
    }
}
