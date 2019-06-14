package com.google.android.gms.analytics;

import android.content.BroadcastReceiver.PendingResult;

/* renamed from: com.google.android.gms.analytics.k */
final class C2711k implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ PendingResult f6965a;

    C2711k(C2705a c2705a, PendingResult pendingResult) {
        this.f6965a = pendingResult;
    }

    public final void run() {
        if (this.f6965a != null) {
            this.f6965a.finish();
        }
    }
}
