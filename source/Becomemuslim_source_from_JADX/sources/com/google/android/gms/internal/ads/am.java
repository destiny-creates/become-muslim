package com.google.android.gms.internal.ads;

final class am implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ is f14746a;
    /* renamed from: b */
    private final /* synthetic */ ak f14747b;

    am(ak akVar, is isVar) {
        this.f14747b = akVar;
        this.f14746a = isVar;
    }

    public final void run() {
        synchronized (this.f14747b.f28112c) {
            ak akVar = this.f14747b;
            akVar.f28110a.m18682b(this.f14746a);
        }
    }
}
