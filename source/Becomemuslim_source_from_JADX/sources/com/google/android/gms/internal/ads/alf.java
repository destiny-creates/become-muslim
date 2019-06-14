package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class alf implements alg {
    /* renamed from: a */
    private final /* synthetic */ Activity f23716a;

    alf(akx akx, Activity activity) {
        this.f23716a = activity;
    }

    /* renamed from: a */
    public final void mo3841a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.f23716a);
    }
}
