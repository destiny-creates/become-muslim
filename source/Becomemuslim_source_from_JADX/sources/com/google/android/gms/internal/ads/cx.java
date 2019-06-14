package com.google.android.gms.internal.ads;

final class cx implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ cp f15272a;

    cx(cp cpVar) {
        this.f15272a = cpVar;
    }

    public final void run() {
        synchronized (this.f15272a.f28504d) {
            if (this.f15272a.f28501a == null) {
                return;
            }
            this.f15272a.h_();
            this.f15272a.m37442a(2, "Timed out waiting for ad response.");
        }
    }
}
