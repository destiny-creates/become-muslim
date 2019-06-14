package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class ahq implements ahv {
    /* renamed from: a */
    private final /* synthetic */ Activity f23613a;

    ahq(ahn ahn, Activity activity) {
        this.f23613a = activity;
    }

    /* renamed from: a */
    public final void mo3816a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityResumed(this.f23613a);
    }
}
