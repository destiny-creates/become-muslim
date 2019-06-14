package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.C2872v;

@cm
public final class lu {
    /* renamed from: a */
    private HandlerThread f15765a = null;
    /* renamed from: b */
    private Handler f15766b = null;
    /* renamed from: c */
    private int f15767c = 0;
    /* renamed from: d */
    private final Object f15768d = new Object();

    /* renamed from: a */
    public final Looper m19837a() {
        Looper looper;
        synchronized (this.f15768d) {
            if (this.f15767c != 0) {
                C2872v.a(this.f15765a, "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.f15765a == null) {
                jn.m30864a("Starting the looper thread.");
                this.f15765a = new HandlerThread("LooperProvider");
                this.f15765a.start();
                this.f15766b = new Handler(this.f15765a.getLooper());
                jn.m30864a("Looper thread started.");
            } else {
                jn.m30864a("Resuming the looper thread");
                this.f15768d.notifyAll();
            }
            this.f15767c++;
            looper = this.f15765a.getLooper();
        }
        return looper;
    }

    /* renamed from: b */
    public final Handler m19838b() {
        return this.f15766b;
    }
}
