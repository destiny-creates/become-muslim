package com.google.android.gms.iid;

import android.content.Intent;

/* renamed from: com.google.android.gms.iid.p */
final class C3070p implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ Intent f7848a;
    /* renamed from: b */
    private final /* synthetic */ Intent f7849b;
    /* renamed from: c */
    private final /* synthetic */ C3069o f7850c;

    C3070p(C3069o c3069o, Intent intent, Intent intent2) {
        this.f7850c = c3069o;
        this.f7848a = intent;
        this.f7849b = intent2;
    }

    public final void run() {
        this.f7850c.handleIntent(this.f7848a);
        this.f7850c.m8988a(this.f7849b);
    }
}
