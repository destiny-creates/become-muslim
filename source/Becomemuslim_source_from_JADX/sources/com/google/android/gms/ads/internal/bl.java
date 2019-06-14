package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class bl implements OnTouchListener {
    /* renamed from: a */
    private final /* synthetic */ bv f6830a;
    /* renamed from: b */
    private final /* synthetic */ bj f6831b;

    bl(bj bjVar, bv bvVar) {
        this.f6831b = bjVar;
        this.f6830a = bvVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.f6830a.m7506a();
        if (this.f6831b.f6826b != null) {
            this.f6831b.f6826b.c();
        }
        return false;
    }
}
