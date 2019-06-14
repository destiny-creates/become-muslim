package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

final class auv implements aud {
    /* renamed from: a */
    private final /* synthetic */ View f23824a;
    /* renamed from: b */
    private final /* synthetic */ auu f23825b;

    auv(auu auu, View view) {
        this.f23825b = auu;
        this.f23824a = view;
    }

    /* renamed from: a */
    public final void mo3967a() {
        this.f23825b.onClick(this.f23824a);
    }

    /* renamed from: a */
    public final void mo3968a(MotionEvent motionEvent) {
        this.f23825b.onTouch(null, motionEvent);
    }
}
