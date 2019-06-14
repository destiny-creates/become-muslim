package com.google.android.gms.internal.p210i;

import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: com.google.android.gms.internal.i.r */
final class C5009r implements UncaughtExceptionHandler {
    /* renamed from: a */
    private final /* synthetic */ C5008q f16831a;

    C5009r(C5008q c5008q) {
        this.f16831a = c5008q;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        thread = this.f16831a.m21064f();
        if (thread != null) {
            thread.m21037e("Job execution failed", th);
        }
    }
}
