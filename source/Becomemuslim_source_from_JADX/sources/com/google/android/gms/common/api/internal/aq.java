package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.api.Status;

final class aq implements C2776c {
    /* renamed from: a */
    private final /* synthetic */ C4773n f11462a;

    aq(an anVar, C4773n c4773n) {
        this.f11462a = c4773n;
    }

    public final void onConnectionFailed(C4775b c4775b) {
        this.f11462a.m14069b(new Status(8));
    }
}
