package com.google.android.gms.gcm;

import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.p209h.C4982g;

/* renamed from: com.google.android.gms.gcm.e */
final class C4427e extends C4982g {
    /* renamed from: a */
    private final /* synthetic */ C3055b f11794a;

    C4427e(C3055b c3055b, Looper looper) {
        this.f11794a = c3055b;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message == null || !(message.obj instanceof Intent)) {
            Log.w("GCM", "Dropping invalid message");
        }
        Intent intent = (Intent) message.obj;
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
            this.f11794a.f7788f.add(intent);
            return;
        }
        if (!this.f11794a.m8918a(intent)) {
            intent.setPackage(this.f11794a.f7785b.getPackageName());
            this.f11794a.f7785b.sendBroadcast(intent);
        }
    }
}
