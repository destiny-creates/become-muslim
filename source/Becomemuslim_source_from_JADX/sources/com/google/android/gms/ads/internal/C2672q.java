package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.C2663l;

/* renamed from: com.google.android.gms.ads.internal.q */
final class C2672q implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ AdOverlayInfoParcel f6917a;
    /* renamed from: b */
    private final /* synthetic */ C4743p f6918b;

    C2672q(C4743p c4743p, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f6918b = c4743p;
        this.f6917a = adOverlayInfoParcel;
    }

    public final void run() {
        ax.m7462c();
        C2663l.m7543a(this.f6918b.f13071a.e.f6792c, this.f6917a, true);
    }
}
