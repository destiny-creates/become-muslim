package com.google.android.gms.internal.p208g;

import android.app.PendingIntent;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.C3009y;
import com.google.android.gms.fitness.p187a.C4796k;

/* renamed from: com.google.android.gms.internal.g.bn */
final class bn extends C8324w {
    /* renamed from: a */
    private final /* synthetic */ C3009y f32869a;
    /* renamed from: b */
    private final /* synthetic */ PendingIntent f32870b;

    bn(bk bkVar, GoogleApiClient googleApiClient, C3009y c3009y, PendingIntent pendingIntent) {
        this.f32869a = c3009y;
        this.f32870b = pendingIntent;
        super(googleApiClient);
    }

    /* renamed from: a */
    protected final /* synthetic */ C2814k mo6870a(Status status) {
        return mo6871d(status);
    }

    /* renamed from: a */
    protected final /* synthetic */ void m44420a(C2777b c2777b) {
        ((at) ((C8323r) c2777b).w()).mo4406a(new C4796k(this.f32869a, this.f32870b, new bp(this)));
    }

    /* renamed from: d */
    protected final Status mo6871d(Status status) {
        return status;
    }
}
