package com.google.android.gms.internal.p208g;

import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.g.w */
abstract class C8324w extends C8216u<Status> {
    C8324w(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* renamed from: a */
    protected /* synthetic */ C2814k mo6870a(Status status) {
        return mo6871d(status);
    }

    /* renamed from: d */
    protected Status mo6871d(Status status) {
        C2872v.b(status.d() ^ 1);
        return status;
    }
}
