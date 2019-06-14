package com.google.android.gms.internal.p210i;

import android.os.Looper;

/* renamed from: com.google.android.gms.internal.i.av */
final class av implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ au f16363a;

    av(au auVar) {
        this.f16363a = auVar;
    }

    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f16363a.f16360a.m21065g().a(this);
            return;
        }
        boolean c = this.f16363a.m20306c();
        this.f16363a.f16362d = 0;
        if (c) {
            this.f16363a.mo4412a();
        }
    }
}
