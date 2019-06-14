package com.google.android.gms.internal.ads;

import android.database.ContentObserver;
import android.os.Handler;

final class ajy extends ContentObserver {
    /* renamed from: a */
    private final /* synthetic */ ajv f14638a;

    public ajy(ajv ajv, Handler handler) {
        this.f14638a = ajv;
        super(handler);
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        this.f14638a.m18530a();
    }
}
