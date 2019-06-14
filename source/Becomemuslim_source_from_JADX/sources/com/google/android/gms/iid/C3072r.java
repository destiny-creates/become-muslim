package com.google.android.gms.iid;

import android.content.Intent;
import android.util.Log;

/* renamed from: com.google.android.gms.iid.r */
final class C3072r implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ Intent f7855a;
    /* renamed from: b */
    private final /* synthetic */ C3071q f7856b;

    C3072r(C3071q c3071q, Intent intent) {
        this.f7856b = c3071q;
        this.f7855a = intent;
    }

    public final void run() {
        String action = this.f7855a.getAction();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(action).length() + 61);
        stringBuilder.append("Service took too long to process intent: ");
        stringBuilder.append(action);
        stringBuilder.append(" App may get closed.");
        Log.w("EnhancedIntentService", stringBuilder.toString());
        this.f7856b.m8990a();
    }
}
