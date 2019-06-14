package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class ahu implements ahv {
    /* renamed from: a */
    private final /* synthetic */ Activity f23618a;

    ahu(ahn ahn, Activity activity) {
        this.f23618a = activity;
    }

    /* renamed from: a */
    public final void mo3816a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityDestroyed(this.f23618a);
    }
}
