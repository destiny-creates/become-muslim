package com.google.android.gms.analytics;

import android.util.Log;
import com.google.android.gms.analytics.C2721s.C2718a;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.FutureTask;

/* renamed from: com.google.android.gms.analytics.u */
final class C2723u extends FutureTask<T> {
    /* renamed from: a */
    private final /* synthetic */ C2718a f6991a;

    C2723u(C2718a c2718a, Runnable runnable, Object obj) {
        this.f6991a = c2718a;
        super(runnable, obj);
    }

    protected final void setException(Throwable th) {
        UncaughtExceptionHandler b = this.f6991a.f6980a.f6988g;
        if (b != null) {
            b.uncaughtException(Thread.currentThread(), th);
        } else if (Log.isLoggable("GAv4", 6)) {
            String valueOf = String.valueOf(th);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(valueOf).length() + 37);
            stringBuilder.append("MeasurementExecutor: job failed with ");
            stringBuilder.append(valueOf);
            Log.e("GAv4", stringBuilder.toString());
        }
        super.setException(th);
    }
}
