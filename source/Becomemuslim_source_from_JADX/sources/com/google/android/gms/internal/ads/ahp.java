package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class ahp implements ahv {
    /* renamed from: a */
    private final /* synthetic */ Activity f23612a;

    ahp(ahn ahn, Activity activity) {
        this.f23612a = activity;
    }

    /* renamed from: a */
    public final void mo3816a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.f23612a);
    }
}
