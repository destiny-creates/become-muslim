package com.google.android.gms.internal.p211j;

import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.C2805i;
import com.google.android.gms.location.C5081l;
import com.google.android.gms.location.LocationRequest;

/* renamed from: com.google.android.gms.internal.j.bb */
final class bb extends C8337c {
    /* renamed from: a */
    private final /* synthetic */ LocationRequest f32874a;
    /* renamed from: b */
    private final /* synthetic */ C5081l f32875b;

    bb(ba baVar, GoogleApiClient googleApiClient, LocationRequest locationRequest, C5081l c5081l) {
        this.f32874a = locationRequest;
        this.f32875b = c5081l;
        super(googleApiClient);
    }

    /* renamed from: a */
    protected final /* synthetic */ void m44424a(C2777b c2777b) {
        ((aa) c2777b).m43885a(this.f32874a, C2805i.a(this.f32875b, ao.m21093a(), C5081l.class.getSimpleName()), new C7820d(this));
    }
}
