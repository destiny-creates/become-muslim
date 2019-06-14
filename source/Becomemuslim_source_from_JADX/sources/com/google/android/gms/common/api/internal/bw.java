package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.GoogleApiClient;

final class bw implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ C2814k f7149a;
    /* renamed from: b */
    private final /* synthetic */ bv f7150b;

    bw(bv bvVar, C2814k c2814k) {
        this.f7150b = bvVar;
        this.f7149a = c2814k;
    }

    public final void run() {
        GoogleApiClient googleApiClient;
        try {
            BasePendingResult.f11381c.set(Boolean.valueOf(true));
            this.f7150b.f11480h.sendMessage(this.f7150b.f11480h.obtainMessage(0, this.f7150b.f11473a.m8110a(this.f7149a)));
            BasePendingResult.f11381c.set(Boolean.valueOf(false));
            bv.m14183a(this.f7149a);
            googleApiClient = (GoogleApiClient) this.f7150b.f11479g.get();
            if (googleApiClient != null) {
                googleApiClient.mo2411b(this.f7150b);
            }
        } catch (RuntimeException e) {
            this.f7150b.f11480h.sendMessage(this.f7150b.f11480h.obtainMessage(1, e));
            BasePendingResult.f11381c.set(Boolean.valueOf(false));
            bv.m14183a(this.f7149a);
            googleApiClient = (GoogleApiClient) this.f7150b.f11479g.get();
            if (googleApiClient != null) {
                googleApiClient.mo2411b(this.f7150b);
            }
        } catch (Throwable th) {
            BasePendingResult.f11381c.set(Boolean.valueOf(false));
            bv.m14183a(this.f7149a);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.f7150b.f11479g.get();
            if (googleApiClient2 != null) {
                googleApiClient2.mo2411b(this.f7150b);
            }
            throw th;
        }
    }
}
