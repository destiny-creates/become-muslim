package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.kq;

@cm
/* renamed from: com.google.android.gms.ads.internal.overlay.h */
final class C2660h extends RelativeLayout {
    /* renamed from: a */
    boolean f6902a;
    /* renamed from: b */
    private kq f6903b;

    public C2660h(Context context, String str, String str2) {
        super(context);
        this.f6903b = new kq(context, str);
        this.f6903b.b(str2);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f6902a) {
            this.f6903b.a(motionEvent);
        }
        return false;
    }
}
