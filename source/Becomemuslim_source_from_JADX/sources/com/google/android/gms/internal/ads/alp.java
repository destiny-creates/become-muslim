package com.google.android.gms.internal.ads;

import android.view.View;

final class alp implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ View f14723a;
    /* renamed from: b */
    private final /* synthetic */ alo f14724b;

    alp(alo alo, View view) {
        this.f14724b = alo;
        this.f14723a = view;
    }

    public final void run() {
        this.f14724b.m18603a(this.f14723a);
    }
}
