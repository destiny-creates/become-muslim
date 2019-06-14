package com.google.android.gms.internal.p211j;

import android.app.PendingIntent;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

/* renamed from: com.google.android.gms.internal.j.bd */
final class bd extends C8337c {
    /* renamed from: a */
    private final /* synthetic */ LocationRequest f32879a;
    /* renamed from: b */
    private final /* synthetic */ PendingIntent f32880b;

    bd(ba baVar, GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        this.f32879a = locationRequest;
        this.f32880b = pendingIntent;
        super(googleApiClient);
    }

    /* renamed from: a */
    protected final /* synthetic */ void m44426a(C2777b c2777b) {
        ((aa) c2777b).m43884a(this.f32879a, this.f32880b, new C7820d(this));
    }
}
