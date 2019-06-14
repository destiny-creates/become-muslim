package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class akz implements alg {
    /* renamed from: a */
    private final /* synthetic */ Activity f23710a;

    akz(akx akx, Activity activity) {
        this.f23710a = activity;
    }

    /* renamed from: a */
    public final void mo3841a(ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityStarted(this.f23710a);
    }
}
