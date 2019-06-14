package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

final class auy implements aud {
    /* renamed from: a */
    private final /* synthetic */ View f23826a;
    /* renamed from: b */
    private final /* synthetic */ auw f23827b;

    auy(auw auw, View view) {
        this.f23827b = auw;
        this.f23826a = view;
    }

    /* renamed from: a */
    public final void mo3967a() {
        if (this.f23827b.m37157a(auw.f28406a)) {
            this.f23827b.onClick(this.f23826a);
        }
    }

    /* renamed from: a */
    public final void mo3968a(MotionEvent motionEvent) {
        this.f23827b.onTouch(null, motionEvent);
    }
}
