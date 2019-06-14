package com.google.android.gms.common.api.internal;

import com.google.android.gms.p186f.C2950c;
import com.google.android.gms.p186f.C2954g;
import com.google.android.gms.p186f.C2955h;

/* renamed from: com.google.android.gms.common.api.internal.u */
final class C4353u implements C2950c<TResult> {
    /* renamed from: a */
    private final /* synthetic */ C2955h f11555a;
    /* renamed from: b */
    private final /* synthetic */ C2812s f11556b;

    C4353u(C2812s c2812s, C2955h c2955h) {
        this.f11556b = c2812s;
        this.f11555a = c2955h;
    }

    public final void onComplete(C2954g<TResult> c2954g) {
        this.f11556b.f7214b.remove(this.f11555a);
    }
}
