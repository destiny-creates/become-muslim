package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.C2663l;

final class bfa implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ AdOverlayInfoParcel f15239a;
    /* renamed from: b */
    private final /* synthetic */ zzzv f15240b;

    bfa(zzzv zzzv, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f15240b = zzzv;
        this.f15239a = adOverlayInfoParcel;
    }

    public final void run() {
        ax.c();
        C2663l.a(this.f15240b.f28779a, this.f15239a, true);
    }
}
