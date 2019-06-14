package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

/* renamed from: com.google.android.gms.ads.internal.overlay.k */
final class C2662k implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ Drawable f6908a;
    /* renamed from: b */
    private final /* synthetic */ C4741j f6909b;

    C2662k(C4741j c4741j, Drawable drawable) {
        this.f6909b = c4741j;
        this.f6908a = drawable;
    }

    public final void run() {
        this.f6909b.f13066a.f13046a.getWindow().setBackgroundDrawable(this.f6908a);
    }
}
