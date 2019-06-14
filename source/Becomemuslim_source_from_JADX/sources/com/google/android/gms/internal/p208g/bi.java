package com.google.android.gms.internal.p208g;

import com.google.android.gms.common.api.C2789g;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.C3011f;
import com.google.android.gms.fitness.data.C4805g;
import com.google.android.gms.fitness.data.C4805g.C2993a;
import com.google.android.gms.fitness.data.DataType;

/* renamed from: com.google.android.gms.internal.g.bi */
public final class bi implements C3011f {
    /* renamed from: a */
    private final C2789g<Status> m31285a(GoogleApiClient googleApiClient, C4805g c4805g) {
        return googleApiClient.a(new bj(this, googleApiClient, c4805g));
    }

    /* renamed from: a */
    public final C2789g<Status> m31286a(GoogleApiClient googleApiClient, DataType dataType) {
        return m31285a(googleApiClient, new C2993a().a(dataType).a());
    }
}
