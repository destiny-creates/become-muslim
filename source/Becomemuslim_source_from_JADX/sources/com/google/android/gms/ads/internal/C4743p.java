package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.ji;
import com.google.android.gms.internal.ads.jw;

@cm
/* renamed from: com.google.android.gms.ads.internal.p */
final class C4743p extends ji {
    /* renamed from: a */
    final /* synthetic */ C4910m f13071a;
    /* renamed from: b */
    private final int f13072b;

    public C4743p(C4910m c4910m, int i) {
        this.f13071a = c4910m;
        this.f13072b = i;
    }

    /* renamed from: a */
    public final void m16598a() {
        C4744r c4744r = new C4744r(this.f13071a.e.f6782J, this.f13071a.m17770I(), this.f13071a.f14112m, this.f13071a.f14113n, this.f13071a.e.f6782J ? this.f13072b : -1, this.f13071a.f14114o, this.f13071a.e.f6799j.f15566L, this.f13071a.e.f6799j.f15569O);
        int requestedOrientation = this.f13071a.e.f6799j.f15575b.getRequestedOrientation();
        if (requestedOrientation == -1) {
            requestedOrientation = this.f13071a.e.f6799j.f15581h;
        }
        jw.f15691a.post(new C2672q(this, new AdOverlayInfoParcel(this.f13071a, this.f13071a, this.f13071a, this.f13071a.e.f6799j.f15575b, requestedOrientation, this.f13071a.e.f6794e, this.f13071a.e.f6799j.f15555A, c4744r)));
    }

    public final void h_() {
    }
}
