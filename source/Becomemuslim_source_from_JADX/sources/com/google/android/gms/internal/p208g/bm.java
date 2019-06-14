package com.google.android.gms.internal.p208g;

import android.app.PendingIntent;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.C3009y;
import com.google.android.gms.fitness.p187a.C2972d;
import com.google.android.gms.fitness.p187a.C4795h;

/* renamed from: com.google.android.gms.internal.g.bm */
final class bm extends C8324w {
    /* renamed from: a */
    private final /* synthetic */ C2972d f32866a;
    /* renamed from: b */
    private final /* synthetic */ C3009y f32867b;
    /* renamed from: d */
    private final /* synthetic */ PendingIntent f32868d;

    bm(bk bkVar, GoogleApiClient googleApiClient, C2972d c2972d, C3009y c3009y, PendingIntent pendingIntent) {
        this.f32866a = c2972d;
        this.f32867b = c3009y;
        this.f32868d = pendingIntent;
        super(googleApiClient);
    }

    /* renamed from: a */
    protected final /* synthetic */ C2814k mo6870a(Status status) {
        return mo6871d(status);
    }

    /* renamed from: a */
    protected final /* synthetic */ void m44417a(C2777b c2777b) {
        ((at) ((C8323r) c2777b).w()).mo4405a(new C4795h(this.f32866a, this.f32867b, this.f32868d, new bp(this)));
    }

    /* renamed from: d */
    protected final Status mo6871d(Status status) {
        return status;
    }
}
