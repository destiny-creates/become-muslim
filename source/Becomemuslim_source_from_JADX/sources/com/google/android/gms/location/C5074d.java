package com.google.android.gms.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.C2789g;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

@Deprecated
/* renamed from: com.google.android.gms.location.d */
public interface C5074d {
    /* renamed from: a */
    Location mo4629a(GoogleApiClient googleApiClient);

    /* renamed from: a */
    C2789g<Status> mo4630a(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    /* renamed from: a */
    C2789g<Status> mo4631a(GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent);

    /* renamed from: a */
    C2789g<Status> mo4632a(GoogleApiClient googleApiClient, LocationRequest locationRequest, C5081l c5081l);

    /* renamed from: a */
    C2789g<Status> mo4633a(GoogleApiClient googleApiClient, LocationRequest locationRequest, C5081l c5081l, Looper looper);

    /* renamed from: a */
    C2789g<Status> mo4634a(GoogleApiClient googleApiClient, C5081l c5081l);
}
