package com.google.android.gms.internal.ads;

import android.view.View;

final class qr implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ View f15958a;
    /* renamed from: b */
    private final /* synthetic */ id f15959b;
    /* renamed from: c */
    private final /* synthetic */ int f15960c;
    /* renamed from: d */
    private final /* synthetic */ qp f15961d;

    qr(qp qpVar, View view, id idVar, int i) {
        this.f15961d = qpVar;
        this.f15958a = view;
        this.f15959b = idVar;
        this.f15960c = i;
    }

    public final void run() {
        this.f15961d.m31005a(this.f15958a, this.f15959b, this.f15960c - 1);
    }
}
