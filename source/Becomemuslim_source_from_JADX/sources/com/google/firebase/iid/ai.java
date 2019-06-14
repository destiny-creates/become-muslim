package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

public final class ai extends Binder {
    /* renamed from: a */
    private final ad f18070a;

    ai(ad adVar) {
        this.f18070a = adVar;
    }

    /* renamed from: a */
    public final void m22717a(ag agVar) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "service received new intent via bind strategy");
            }
            if (this.f18070a.mo4896c(agVar.f18064a)) {
                agVar.m22715a();
                return;
            }
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "intent being queued for bg execution");
            }
            this.f18070a.f18053a.execute(new aj(this, agVar));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
