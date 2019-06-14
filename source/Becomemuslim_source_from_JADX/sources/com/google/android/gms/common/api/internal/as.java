package com.google.android.gms.common.api.internal;

import com.google.android.gms.auth.api.signin.internal.C2742c;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.C2815l;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class as implements C2815l<Status> {
    /* renamed from: a */
    private final /* synthetic */ C4773n f11463a;
    /* renamed from: b */
    private final /* synthetic */ boolean f11464b;
    /* renamed from: c */
    private final /* synthetic */ GoogleApiClient f11465c;
    /* renamed from: d */
    private final /* synthetic */ an f11466d;

    as(an anVar, C4773n c4773n, boolean z, GoogleApiClient googleApiClient) {
        this.f11466d = anVar;
        this.f11463a = c4773n;
        this.f11464b = z;
        this.f11465c = googleApiClient;
    }

    public final /* synthetic */ void onResult(C2814k c2814k) {
        Status status = (Status) c2814k;
        C2742c.m7801a(this.f11466d.f11443k).m7811d();
        if (status.m16705d() && this.f11466d.mo2419h()) {
            this.f11466d.mo2417f();
        }
        this.f11463a.m14069b(status);
        if (this.f11464b != null) {
            this.f11465c.disconnect();
        }
    }
}
