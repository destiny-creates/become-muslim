package com.google.android.gms.ads.internal;

import android.view.View;
import android.view.View.OnClickListener;

final class bm implements OnClickListener {
    /* renamed from: a */
    private final /* synthetic */ bv f6832a;
    /* renamed from: b */
    private final /* synthetic */ bj f6833b;

    bm(bj bjVar, bv bvVar) {
        this.f6833b = bjVar;
        this.f6832a = bvVar;
    }

    public final void onClick(View view) {
        this.f6832a.m7506a();
        if (this.f6833b.f6826b != null) {
            this.f6833b.f6826b.c();
        }
    }
}
