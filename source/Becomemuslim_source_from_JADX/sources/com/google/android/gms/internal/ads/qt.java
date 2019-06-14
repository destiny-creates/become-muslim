package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

final class qt implements OnAttachStateChangeListener {
    /* renamed from: a */
    private final /* synthetic */ id f15962a;
    /* renamed from: b */
    private final /* synthetic */ qp f15963b;

    qt(qp qpVar, id idVar) {
        this.f15963b = qpVar;
        this.f15962a = idVar;
    }

    public final void onViewAttachedToWindow(View view) {
        this.f15963b.m31005a(view, this.f15962a, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
