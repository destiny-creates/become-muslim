package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

final class sg implements OnAttachStateChangeListener {
    /* renamed from: a */
    private final /* synthetic */ id f15999a;
    /* renamed from: b */
    private final /* synthetic */ sd f16000b;

    sg(sd sdVar, id idVar) {
        this.f16000b = sdVar;
        this.f15999a = idVar;
    }

    public final void onViewAttachedToWindow(View view) {
        this.f16000b.m31048a(view, this.f15999a, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
