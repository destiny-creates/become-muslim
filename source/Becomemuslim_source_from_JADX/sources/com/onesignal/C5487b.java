package com.onesignal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* compiled from: ActivityLifecycleListener */
/* renamed from: com.onesignal.b */
class C5487b implements ActivityLifecycleCallbacks {
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    C5487b() {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        C5440a.m23057a(activity);
    }

    public void onActivityStarted(Activity activity) {
        C5440a.m23060b(activity);
    }

    public void onActivityResumed(Activity activity) {
        C5440a.m23063c(activity);
    }

    public void onActivityPaused(Activity activity) {
        C5440a.m23064d(activity);
    }

    public void onActivityStopped(Activity activity) {
        C5440a.m23065e(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        C5440a.m23066f(activity);
    }
}
