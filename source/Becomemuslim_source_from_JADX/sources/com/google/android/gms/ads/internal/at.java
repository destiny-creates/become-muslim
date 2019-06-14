package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class at implements OnTouchListener {
    /* renamed from: a */
    private final /* synthetic */ ar f6730a;

    at(ar arVar) {
        this.f6730a = arVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f6730a.f12984h != null) {
            this.f6730a.f12984h.a(motionEvent);
        }
        return false;
    }
}
