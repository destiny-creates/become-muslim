package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2781a;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;
import com.google.android.gms.common.internal.C2872v;

public final class co implements C2775b, C2776c {
    /* renamed from: a */
    public final C2781a<?> f11498a;
    /* renamed from: b */
    private final boolean f11499b;
    /* renamed from: c */
    private cp f11500c;

    public co(C2781a<?> c2781a, boolean z) {
        this.f11498a = c2781a;
        this.f11499b = z;
    }

    public final void onConnected(Bundle bundle) {
        m14211a();
        this.f11500c.onConnected(bundle);
    }

    public final void onConnectionSuspended(int i) {
        m14211a();
        this.f11500c.onConnectionSuspended(i);
    }

    public final void onConnectionFailed(C4775b c4775b) {
        m14211a();
        this.f11500c.mo3279a(c4775b, this.f11498a, this.f11499b);
    }

    /* renamed from: a */
    public final void m14212a(cp cpVar) {
        this.f11500c = cpVar;
    }

    /* renamed from: a */
    private final void m14211a() {
        C2872v.m8381a(this.f11500c, (Object) "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }
}
