package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class aky implements alg {
    /* renamed from: a */
    private final /* synthetic */ Activity f23708a;
    /* renamed from: b */
    private final /* synthetic */ Bundle f23709b;

    aky(akx akx, Activity activity, Bundle bundle) {
        this.f23708a = activity;
        this.f23709b = bundle;
    }

    /* renamed from: a */
    public final void mo3841a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.f23708a, this.f23709b);
    }
}
