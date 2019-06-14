package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.p205d.C4956e;

final class at extends C4956e {
    /* renamed from: a */
    private final /* synthetic */ an f11467a;

    at(an anVar, Looper looper) {
        this.f11467a = anVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f11467a.m14140o();
                return;
            case 2:
                this.f11467a.m14139n();
                return;
            default:
                message = message.what;
                StringBuilder stringBuilder = new StringBuilder(31);
                stringBuilder.append("Unknown message id: ");
                stringBuilder.append(message);
                Log.w("GoogleApiClientImpl", stringBuilder.toString());
                return;
        }
    }
}
