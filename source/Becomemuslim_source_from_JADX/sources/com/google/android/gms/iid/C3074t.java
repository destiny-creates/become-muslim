package com.google.android.gms.iid;

import android.util.Log;

/* renamed from: com.google.android.gms.iid.t */
final class C3074t implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ C3071q f7858a;
    /* renamed from: b */
    private final /* synthetic */ C3073s f7859b;

    C3074t(C3073s c3073s, C3071q c3071q) {
        this.f7859b = c3073s;
        this.f7858a = c3071q;
    }

    public final void run() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        this.f7859b.f7857a.handleIntent(this.f7858a.f7851a);
        this.f7858a.m8990a();
    }
}
