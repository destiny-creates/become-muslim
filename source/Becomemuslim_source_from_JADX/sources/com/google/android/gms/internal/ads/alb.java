package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class alb implements alg {
    /* renamed from: a */
    private final /* synthetic */ Activity f23712a;

    alb(akx akx, Activity activity) {
        this.f23712a = activity;
    }

    /* renamed from: a */
    public final void mo3841a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.f23712a);
    }
}
