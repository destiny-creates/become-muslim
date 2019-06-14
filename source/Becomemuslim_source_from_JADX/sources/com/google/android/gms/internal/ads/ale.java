package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

final class ale implements alg {
    /* renamed from: a */
    private final /* synthetic */ Activity f23714a;
    /* renamed from: b */
    private final /* synthetic */ Bundle f23715b;

    ale(akx akx, Activity activity, Bundle bundle) {
        this.f23714a = activity;
        this.f23715b = bundle;
    }

    /* renamed from: a */
    public final void mo3841a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.f23714a, this.f23715b);
    }
}
