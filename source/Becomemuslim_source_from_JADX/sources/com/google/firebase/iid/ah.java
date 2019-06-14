package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

final /* synthetic */ class ah implements Runnable {
    /* renamed from: a */
    private final ag f18068a;
    /* renamed from: b */
    private final Intent f18069b;

    ah(ag agVar, Intent intent) {
        this.f18068a = agVar;
        this.f18069b = intent;
    }

    public final void run() {
        ag agVar = this.f18068a;
        String action = this.f18069b.getAction();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(action).length() + 61);
        stringBuilder.append("Service took too long to process intent: ");
        stringBuilder.append(action);
        stringBuilder.append(" App may get closed.");
        Log.w("EnhancedIntentService", stringBuilder.toString());
        agVar.m22715a();
    }
}
