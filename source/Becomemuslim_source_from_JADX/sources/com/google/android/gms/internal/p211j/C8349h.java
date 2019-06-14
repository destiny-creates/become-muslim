package com.google.android.gms.internal.p211j;

import android.app.PendingIntent;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.C2796c.C2795b;
import com.google.android.gms.location.C7835j;

/* renamed from: com.google.android.gms.internal.j.h */
final class C8349h extends C8338j {
    /* renamed from: a */
    private final /* synthetic */ C7835j f32882a;
    /* renamed from: b */
    private final /* synthetic */ PendingIntent f32883b;

    C8349h(C6799g c6799g, GoogleApiClient googleApiClient, C7835j c7835j, PendingIntent pendingIntent) {
        this.f32882a = c7835j;
        this.f32883b = pendingIntent;
        super(googleApiClient);
    }

    /* renamed from: a */
    protected final /* synthetic */ void m44428a(C2777b c2777b) {
        ((aa) c2777b).m43887a(this.f32882a, this.f32883b, (C2795b) this);
    }
}
