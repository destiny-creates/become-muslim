package com.google.android.gms.common.internal;

import android.content.Intent;
import android.support.v4.app.C3178i;

final class af extends C2855h {
    /* renamed from: a */
    private final /* synthetic */ Intent f11571a;
    /* renamed from: b */
    private final /* synthetic */ C3178i f11572b;
    /* renamed from: c */
    private final /* synthetic */ int f11573c;

    af(Intent intent, C3178i c3178i, int i) {
        this.f11571a = intent;
        this.f11572b = c3178i;
        this.f11573c = i;
    }

    /* renamed from: a */
    public final void mo2461a() {
        if (this.f11571a != null) {
            this.f11572b.startActivityForResult(this.f11571a, this.f11573c);
        }
    }
}
