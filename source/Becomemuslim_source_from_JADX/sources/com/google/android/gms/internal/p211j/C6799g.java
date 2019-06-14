package com.google.android.gms.internal.p211j;

import android.app.PendingIntent;
import com.google.android.gms.common.api.C2789g;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.C5076f;
import com.google.android.gms.location.C5077g;
import com.google.android.gms.location.C7835j;
import com.google.android.gms.location.C7835j.C5079a;
import com.google.android.gms.location.ae;
import java.util.List;

/* renamed from: com.google.android.gms.internal.j.g */
public final class C6799g implements C5077g {
    /* renamed from: a */
    private final C2789g<Status> m31812a(GoogleApiClient googleApiClient, ae aeVar) {
        return googleApiClient.b(new C8350i(this, googleApiClient, aeVar));
    }

    /* renamed from: a */
    public final C2789g<Status> mo4635a(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return m31812a(googleApiClient, ae.m38219a(pendingIntent));
    }

    /* renamed from: a */
    public final C2789g<Status> mo4636a(GoogleApiClient googleApiClient, C7835j c7835j, PendingIntent pendingIntent) {
        return googleApiClient.b(new C8349h(this, googleApiClient, c7835j, pendingIntent));
    }

    /* renamed from: a */
    public final C2789g<Status> mo4637a(GoogleApiClient googleApiClient, List<String> list) {
        return m31812a(googleApiClient, ae.m38220a((List) list));
    }

    @Deprecated
    /* renamed from: a */
    public final C2789g<Status> mo4638a(GoogleApiClient googleApiClient, List<C5076f> list, PendingIntent pendingIntent) {
        C5079a c5079a = new C5079a();
        c5079a.m21568a((List) list);
        c5079a.m21566a(5);
        return mo4636a(googleApiClient, c5079a.m21569a(), pendingIntent);
    }
}
