package com.google.android.gms.p185e;

import android.os.Message;
import com.google.android.gms.internal.p210i.ck;
import com.google.android.gms.p185e.C4391b.C2930a;

/* renamed from: com.google.android.gms.e.fp */
final class fp extends ck {
    /* renamed from: a */
    private final C2930a f11737a;
    /* renamed from: b */
    private final /* synthetic */ fn f11738b;

    public final void handleMessage(Message message) {
        if (message.what != 1) {
            bs.m8582a("Don't know how to handle this message.");
            return;
        }
        this.f11737a.m8567a(this.f11738b, (String) message.obj);
    }
}
