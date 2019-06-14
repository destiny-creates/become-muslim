package com.google.android.gms.internal.p211j;

import android.app.PendingIntent;
import android.os.Looper;
import com.google.android.gms.common.api.C2789g;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.location.C5074d;
import com.google.android.gms.location.C5081l;
import com.google.android.gms.location.LocationRequest;

/* renamed from: com.google.android.gms.internal.j.ba */
public final class ba implements C5074d {
    /* renamed from: a */
    public final android.location.Location mo4629a(com.google.android.gms.common.api.GoogleApiClient r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r1 = com.google.android.gms.location.C5082m.m21573a(r1);
        r1 = r1.m43889e();	 Catch:{ Exception -> 0x0009 }
        return r1;
    L_0x0009:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.j.ba.a(com.google.android.gms.common.api.GoogleApiClient):android.location.Location");
    }

    /* renamed from: a */
    public final C2789g<Status> mo4630a(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.b(new C8348b(this, googleApiClient, pendingIntent));
    }

    /* renamed from: a */
    public final C2789g<Status> mo4631a(GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return googleApiClient.b(new bd(this, googleApiClient, locationRequest, pendingIntent));
    }

    /* renamed from: a */
    public final C2789g<Status> mo4632a(GoogleApiClient googleApiClient, LocationRequest locationRequest, C5081l c5081l) {
        C2872v.a(Looper.myLooper(), "Calling thread must be a prepared Looper thread.");
        return googleApiClient.b(new bb(this, googleApiClient, locationRequest, c5081l));
    }

    /* renamed from: a */
    public final C2789g<Status> mo4633a(GoogleApiClient googleApiClient, LocationRequest locationRequest, C5081l c5081l, Looper looper) {
        return googleApiClient.b(new bc(this, googleApiClient, locationRequest, c5081l, looper));
    }

    /* renamed from: a */
    public final C2789g<Status> mo4634a(GoogleApiClient googleApiClient, C5081l c5081l) {
        return googleApiClient.b(new be(this, googleApiClient, c5081l));
    }
}
