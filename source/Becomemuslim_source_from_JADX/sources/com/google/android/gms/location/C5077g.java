package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.C2789g;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import java.util.List;

@Deprecated
/* renamed from: com.google.android.gms.location.g */
public interface C5077g {
    /* renamed from: a */
    C2789g<Status> mo4635a(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    /* renamed from: a */
    C2789g<Status> mo4636a(GoogleApiClient googleApiClient, C7835j c7835j, PendingIntent pendingIntent);

    /* renamed from: a */
    C2789g<Status> mo4637a(GoogleApiClient googleApiClient, List<String> list);

    @Deprecated
    /* renamed from: a */
    C2789g<Status> mo4638a(GoogleApiClient googleApiClient, List<C5076f> list, PendingIntent pendingIntent);
}
