package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

/* renamed from: com.google.android.gms.iid.s */
public final class C3073s extends Binder {
    /* renamed from: a */
    private final C3069o f7857a;

    C3073s(C3069o c3069o) {
        this.f7857a = c3069o;
    }

    /* renamed from: a */
    public final void m8992a(C3071q c3071q) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "service received new intent via bind strategy");
            }
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "intent being queued for bg execution");
            }
            this.f7857a.f7843a.execute(new C3074t(this, c3071q));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
