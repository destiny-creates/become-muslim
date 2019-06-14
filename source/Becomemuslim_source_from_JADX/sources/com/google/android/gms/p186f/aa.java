package com.google.android.gms.p186f;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.f.aa */
final class aa implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ C4412z f7589a;
    /* renamed from: b */
    private final /* synthetic */ Callable f7590b;

    aa(C4412z c4412z, Callable callable) {
        this.f7589a = c4412z;
        this.f7590b = callable;
    }

    public final void run() {
        try {
            this.f7589a.m14673a(this.f7590b.call());
        } catch (Exception e) {
            this.f7589a.m14672a(e);
        }
    }
}
