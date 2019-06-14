package com.google.firebase.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class ag {
    /* renamed from: a */
    final Intent f18064a;
    /* renamed from: b */
    private final PendingResult f18065b;
    /* renamed from: c */
    private boolean f18066c = false;
    /* renamed from: d */
    private final ScheduledFuture<?> f18067d;

    ag(Intent intent, PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.f18064a = intent;
        this.f18065b = pendingResult;
        this.f18067d = scheduledExecutorService.schedule(new ah(this, intent), 9000, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    final synchronized void m22715a() {
        if (!this.f18066c) {
            this.f18065b.finish();
            this.f18067d.cancel(false);
            this.f18066c = true;
        }
    }
}
