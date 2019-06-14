package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.ax;
import java.util.concurrent.Executor;

final class nv implements Executor {
    /* renamed from: a */
    private final Handler f15850a = new jo(Looper.getMainLooper());

    nv() {
    }

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
            } catch (Throwable th) {
                ax.e();
                jw.m19700a(ax.i().m30848m(), th);
            }
        } else {
            this.f15850a.post(runnable);
        }
    }
}
