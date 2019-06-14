package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class aho implements ahv {
    /* renamed from: a */
    private final /* synthetic */ Activity f23610a;
    /* renamed from: b */
    private final /* synthetic */ Bundle f23611b;

    aho(ahn ahn, Activity activity, Bundle bundle) {
        this.f23610a = activity;
        this.f23611b = bundle;
    }

    /* renamed from: a */
    public final void mo3816a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.f23610a, this.f23611b);
    }
}
