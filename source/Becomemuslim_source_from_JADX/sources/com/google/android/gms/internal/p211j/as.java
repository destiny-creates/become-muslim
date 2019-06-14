package com.google.android.gms.internal.p211j;

import android.app.PendingIntent;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.j.as */
final class as extends at {
    /* renamed from: a */
    private final /* synthetic */ long f32871a;
    /* renamed from: b */
    private final /* synthetic */ PendingIntent f32872b;

    as(ar arVar, GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent) {
        this.f32871a = j;
        this.f32872b = pendingIntent;
        super(googleApiClient);
    }

    /* renamed from: a */
    protected final /* synthetic */ void m44422a(C2777b c2777b) {
        ((aa) c2777b).m43881a(this.f32871a, this.f32872b);
        b(Status.f13151a);
    }
}
