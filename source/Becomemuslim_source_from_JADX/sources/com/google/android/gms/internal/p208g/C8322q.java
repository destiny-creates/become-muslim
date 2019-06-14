package com.google.android.gms.internal.p208g;

import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.g.q */
abstract class C8322q extends C8215o<Status> {
    C8322q(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* renamed from: a */
    protected /* synthetic */ C2814k m43838a(Status status) {
        C2872v.b(status.d() ^ 1);
        return status;
    }
}
