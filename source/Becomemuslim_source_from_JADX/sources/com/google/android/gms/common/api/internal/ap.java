package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import java.util.concurrent.atomic.AtomicReference;

final class ap implements C2775b {
    /* renamed from: a */
    private final /* synthetic */ AtomicReference f11459a;
    /* renamed from: b */
    private final /* synthetic */ C4773n f11460b;
    /* renamed from: c */
    private final /* synthetic */ an f11461c;

    ap(an anVar, AtomicReference atomicReference, C4773n c4773n) {
        this.f11461c = anVar;
        this.f11459a = atomicReference;
        this.f11460b = c4773n;
    }

    public final void onConnectionSuspended(int i) {
    }

    public final void onConnected(Bundle bundle) {
        this.f11461c.m14131a((GoogleApiClient) this.f11459a.get(), this.f11460b, true);
    }
}
