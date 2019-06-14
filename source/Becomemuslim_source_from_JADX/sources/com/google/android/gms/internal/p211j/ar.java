package com.google.android.gms.internal.p211j;

import android.app.PendingIntent;
import com.google.android.gms.common.api.C2789g;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.C5073b;

/* renamed from: com.google.android.gms.internal.j.ar */
public final class ar implements C5073b {
    /* renamed from: a */
    public final C2789g<Status> mo4626a(GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent) {
        return googleApiClient.b(new as(this, googleApiClient, j, pendingIntent));
    }
}
