package com.google.android.gms.common.api.internal;

import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.C2789g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p205d.C4956e;

final class bx extends C4956e {
    /* renamed from: a */
    private final /* synthetic */ bv f11482a;

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                C2789g c2789g = (C2789g) message.obj;
                synchronized (this.f11482a.f11477e) {
                    if (c2789g == null) {
                        this.f11482a.f11474b.m14180a(new Status(13, "Transform returned null"));
                    } else if (c2789g instanceof bq) {
                        this.f11482a.f11474b.m14180a(((bq) c2789g).m14178d());
                    } else {
                        this.f11482a.f11474b.m14192a(c2789g);
                    }
                }
                return;
            case 1:
                RuntimeException runtimeException = (RuntimeException) message.obj;
                String str = "Runtime exception on the transformation worker thread: ";
                String valueOf = String.valueOf(runtimeException.getMessage());
                Log.e("TransformedResultImpl", valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
                throw runtimeException;
            default:
                message = message.what;
                StringBuilder stringBuilder = new StringBuilder(70);
                stringBuilder.append("TransformationResultHandler received unknown message type: ");
                stringBuilder.append(message);
                Log.e("TransformedResultImpl", stringBuilder.toString());
                return;
        }
    }
}
