package com.google.android.gms.internal.p208g;

import android.app.PendingIntent;
import com.google.android.gms.common.api.C2789g;
import com.google.android.gms.common.api.C2790h;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.C3012g;
import com.google.android.gms.fitness.data.C3009y;
import com.google.android.gms.fitness.p187a.C2970c;
import com.google.android.gms.fitness.p187a.C2972d;
import com.google.android.gms.fitness.p187a.C2973g;
import com.google.android.gms.fitness.p187a.C4793b;
import com.google.android.gms.fitness.p188b.C4800b;

/* renamed from: com.google.android.gms.internal.g.bk */
public final class bk implements C3012g {
    /* renamed from: a */
    private final C2789g<Status> m31287a(GoogleApiClient googleApiClient, C2972d c2972d, C3009y c3009y, PendingIntent pendingIntent) {
        return googleApiClient.a(new bm(this, googleApiClient, c2972d, c3009y, pendingIntent));
    }

    /* renamed from: a */
    private final C2789g<Status> m31288a(GoogleApiClient googleApiClient, C3009y c3009y, PendingIntent pendingIntent) {
        return googleApiClient.b(new bn(this, googleApiClient, c3009y, pendingIntent));
    }

    /* renamed from: a */
    public final C2789g<C4800b> m31289a(GoogleApiClient googleApiClient, C4793b c4793b) {
        return googleApiClient.a(new bl(this, googleApiClient, c4793b));
    }

    /* renamed from: a */
    public final C2789g<Status> m31290a(GoogleApiClient googleApiClient, C2970c c2970c) {
        C3009y b = C2973g.a().b(c2970c);
        return b == null ? C2790h.a(Status.f13151a, googleApiClient) : m31288a(googleApiClient, b, null);
    }

    /* renamed from: a */
    public final C2789g<Status> m31291a(GoogleApiClient googleApiClient, C2972d c2972d, C2970c c2970c) {
        return m31287a(googleApiClient, c2972d, C2973g.a().a(c2970c), null);
    }
}
