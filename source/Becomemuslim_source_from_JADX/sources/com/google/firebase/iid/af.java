package com.google.firebase.iid;

import android.content.Intent;

final class af implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ Intent f18061a;
    /* renamed from: b */
    private final /* synthetic */ Intent f18062b;
    /* renamed from: c */
    private final /* synthetic */ ad f18063c;

    af(ad adVar, Intent intent, Intent intent2) {
        this.f18063c = adVar;
        this.f18061a = intent;
        this.f18062b = intent2;
    }

    public final void run() {
        this.f18063c.mo4883b(this.f18061a);
        this.f18063c.m22706d(this.f18062b);
    }
}
