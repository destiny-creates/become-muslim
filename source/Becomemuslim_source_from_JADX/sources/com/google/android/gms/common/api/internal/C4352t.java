package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.C2789g.C2788a;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.common.api.internal.t */
final class C4352t implements C2788a {
    /* renamed from: a */
    private final /* synthetic */ BasePendingResult f11553a;
    /* renamed from: b */
    private final /* synthetic */ C2812s f11554b;

    C4352t(C2812s c2812s, BasePendingResult basePendingResult) {
        this.f11554b = c2812s;
        this.f11553a = basePendingResult;
    }

    /* renamed from: a */
    public final void mo2453a(Status status) {
        this.f11554b.f7213a.remove(this.f11553a);
    }
}
