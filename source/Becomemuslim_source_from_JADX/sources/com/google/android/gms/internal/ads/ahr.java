package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class ahr implements ahv {
    /* renamed from: a */
    private final /* synthetic */ Activity f23614a;

    ahr(ahn ahn, Activity activity) {
        this.f23614a = activity;
    }

    /* renamed from: a */
    public final void mo3816a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityPaused(this.f23614a);
    }
}
