package com.google.android.gms.internal.p211j;

import android.os.Looper;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.C2805i;
import com.google.android.gms.location.C5081l;
import com.google.android.gms.location.LocationRequest;

/* renamed from: com.google.android.gms.internal.j.bc */
final class bc extends C8337c {
    /* renamed from: a */
    private final /* synthetic */ LocationRequest f32876a;
    /* renamed from: b */
    private final /* synthetic */ C5081l f32877b;
    /* renamed from: d */
    private final /* synthetic */ Looper f32878d;

    bc(ba baVar, GoogleApiClient googleApiClient, LocationRequest locationRequest, C5081l c5081l, Looper looper) {
        this.f32876a = locationRequest;
        this.f32877b = c5081l;
        this.f32878d = looper;
        super(googleApiClient);
    }

    /* renamed from: a */
    protected final /* synthetic */ void m44425a(C2777b c2777b) {
        ((aa) c2777b).m43885a(this.f32876a, C2805i.a(this.f32877b, ao.m21094a(this.f32878d), C5081l.class.getSimpleName()), new C7820d(this));
    }
}
