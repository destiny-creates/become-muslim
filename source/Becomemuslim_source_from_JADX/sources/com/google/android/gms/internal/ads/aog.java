package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

final class aog implements Executor {
    /* renamed from: a */
    private final /* synthetic */ Handler f14777a;

    aog(anf anf, Handler handler) {
        this.f14777a = handler;
    }

    public final void execute(Runnable runnable) {
        this.f14777a.post(runnable);
    }
}
