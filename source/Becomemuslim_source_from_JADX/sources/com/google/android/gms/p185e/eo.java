package com.google.android.gms.p185e;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* renamed from: com.google.android.gms.e.eo */
final class eo implements ComponentCallbacks2 {
    /* renamed from: a */
    private final /* synthetic */ C2937d f7563a;

    eo(C2937d c2937d) {
        this.f7563a = c2937d;
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i) {
        if (i == 20) {
            this.f7563a.m8638b();
        }
    }
}
