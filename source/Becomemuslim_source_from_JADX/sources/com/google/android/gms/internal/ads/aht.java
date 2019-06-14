package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class aht implements ahv {
    /* renamed from: a */
    private final /* synthetic */ Activity f23616a;
    /* renamed from: b */
    private final /* synthetic */ Bundle f23617b;

    aht(ahn ahn, Activity activity, Bundle bundle) {
        this.f23616a = activity;
        this.f23617b = bundle;
    }

    /* renamed from: a */
    public final void mo3816a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.f23616a, this.f23617b);
    }
}
