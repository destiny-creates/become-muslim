package com.google.android.gms.iid;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.p209h.C4982g;

/* renamed from: com.google.android.gms.iid.i */
final class C4432i extends C4982g {
    /* renamed from: a */
    private final /* synthetic */ C3063h f11798a;

    C4432i(C3063h c3063h, Looper looper) {
        this.f11798a = c3063h;
        super(looper);
    }

    public final void handleMessage(Message message) {
        this.f11798a.m8971a(message);
    }
}
