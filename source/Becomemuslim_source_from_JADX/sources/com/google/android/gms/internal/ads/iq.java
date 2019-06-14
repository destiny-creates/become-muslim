package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

final class iq implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ Context f15553a;
    /* renamed from: b */
    private final /* synthetic */ nz f15554b;

    iq(ip ipVar, Context context, nz nzVar) {
        this.f15553a = context;
        this.f15554b = nzVar;
    }

    public final void run() {
        try {
            this.f15554b.m30915b(AdvertisingIdClient.getAdvertisingIdInfo(this.f15553a));
        } catch (Throwable e) {
            this.f15554b.m30914a(e);
            mt.m19919b("Exception while getting advertising Id info", e);
        }
    }
}
