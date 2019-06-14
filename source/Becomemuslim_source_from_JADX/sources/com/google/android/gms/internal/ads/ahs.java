package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class ahs implements ahv {
    /* renamed from: a */
    private final /* synthetic */ Activity f23615a;

    ahs(ahn ahn, Activity activity) {
        this.f23615a = activity;
    }

    /* renamed from: a */
    public final void mo3816a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStopped(this.f23615a);
    }
}
