package com.google.firebase.iid;

import android.util.Log;

final class aj implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ ag f18071a;
    /* renamed from: b */
    private final /* synthetic */ ai f18072b;

    aj(ai aiVar, ag agVar) {
        this.f18072b = aiVar;
        this.f18071a = agVar;
    }

    public final void run() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        this.f18072b.f18070a.mo4883b(this.f18071a.f18064a);
        this.f18071a.m22715a();
    }
}
