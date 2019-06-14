package com.google.android.gms.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.iid.q */
final class C3071q {
    /* renamed from: a */
    final Intent f7851a;
    /* renamed from: b */
    private final PendingResult f7852b;
    /* renamed from: c */
    private boolean f7853c = false;
    /* renamed from: d */
    private final ScheduledFuture<?> f7854d;

    C3071q(Intent intent, PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.f7851a = intent;
        this.f7852b = pendingResult;
        this.f7854d = scheduledExecutorService.schedule(new C3072r(this, intent), 9500, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    final synchronized void m8990a() {
        if (!this.f7853c) {
            this.f7852b.finish();
            this.f7854d.cancel(false);
            this.f7853c = true;
        }
    }
}
