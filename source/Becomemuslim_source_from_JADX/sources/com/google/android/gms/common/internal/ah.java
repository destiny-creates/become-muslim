package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.internal.C2850d.C2844a;

final class ah implements C2844a {
    /* renamed from: a */
    private final /* synthetic */ C2775b f11577a;

    ah(C2775b c2775b) {
        this.f11577a = c2775b;
    }

    /* renamed from: a */
    public final void mo2463a(Bundle bundle) {
        this.f11577a.onConnected(bundle);
    }

    /* renamed from: a */
    public final void mo2462a(int i) {
        this.f11577a.onConnectionSuspended(i);
    }
}
