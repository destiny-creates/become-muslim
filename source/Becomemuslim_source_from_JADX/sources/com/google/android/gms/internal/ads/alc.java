package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class alc implements alg {
    /* renamed from: a */
    private final /* synthetic */ Activity f23713a;

    alc(akx akx, Activity activity) {
        this.f23713a = activity;
    }

    /* renamed from: a */
    public final void mo3841a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.f23713a);
    }
}
