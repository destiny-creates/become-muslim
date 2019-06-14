package com.google.android.gms.internal.ads;

import android.content.Context;

final class jy implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ Context f15699a;
    /* renamed from: b */
    private final /* synthetic */ jw f15700b;

    jy(jw jwVar, Context context) {
        this.f15700b = jwVar;
        this.f15699a = context;
    }

    public final void run() {
        synchronized (this.f15700b.f15692b) {
            this.f15700b.f15694d = jw.m19723d(this.f15699a);
            this.f15700b.f15692b.notifyAll();
        }
    }
}
