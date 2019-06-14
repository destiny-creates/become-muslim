package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.p205d.C4956e;

final class ay extends C4956e {
    /* renamed from: a */
    private final /* synthetic */ aw f11469a;

    ay(aw awVar, Looper looper) {
        this.f11469a = awVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                ((ax) message.obj).m7996a(this.f11469a);
                return;
            case 2:
                throw ((RuntimeException) message.obj);
            default:
                message = message.what;
                StringBuilder stringBuilder = new StringBuilder(31);
                stringBuilder.append("Unknown message id: ");
                stringBuilder.append(message);
                Log.w("GACStateManager", stringBuilder.toString());
                return;
        }
    }
}
