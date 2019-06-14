package com.google.android.gms.p185e;

import android.os.Handler.Callback;
import android.os.Message;

/* renamed from: com.google.android.gms.e.ed */
final class ed implements Callback {
    /* renamed from: a */
    private final /* synthetic */ ec f7562a;

    ed(ec ecVar) {
        this.f7562a = ecVar;
    }

    public final boolean handleMessage(Message message) {
        if (1 == message.what && dy.f11693a.equals(message.obj) != null) {
            this.f7562a.f11708a.mo2549a();
            if (this.f7562a.f11708a.m14549f() == null) {
                this.f7562a.mo2554a((long) this.f7562a.f11708a.f11698e);
            }
        }
        return true;
    }
}
