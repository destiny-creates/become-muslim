package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.C2665n;

final class bez implements C2665n {
    /* renamed from: a */
    private final /* synthetic */ zzzv f23974a;

    bez(zzzv zzzv) {
        this.f23974a = zzzv;
    }

    /* renamed from: d */
    public final void m30630d() {
        mt.m19918b("AdMobCustomTabsAdapter overlay is paused.");
    }

    /* renamed from: e */
    public final void m30631e() {
        mt.m19918b("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void u_() {
        mt.m19918b("AdMobCustomTabsAdapter overlay is closed.");
        this.f23974a.f28780b.c(this.f23974a);
    }

    public final void v_() {
        mt.m19918b("Opening AdMobCustomTabsAdapter overlay.");
        this.f23974a.f28780b.b(this.f23974a);
    }
}
