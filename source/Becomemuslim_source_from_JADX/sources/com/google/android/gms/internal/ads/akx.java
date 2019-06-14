package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

final class akx implements ActivityLifecycleCallbacks {
    /* renamed from: a */
    private final Application f14670a;
    /* renamed from: b */
    private final WeakReference<ActivityLifecycleCallbacks> f14671b;
    /* renamed from: c */
    private boolean f14672c = false;

    public akx(Application application, ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f14671b = new WeakReference(activityLifecycleCallbacks);
        this.f14670a = application;
    }

    /* renamed from: a */
    private final void m18560a(alg alg) {
        try {
            ActivityLifecycleCallbacks activityLifecycleCallbacks = (ActivityLifecycleCallbacks) this.f14671b.get();
            if (activityLifecycleCallbacks != null) {
                alg.mo3841a(activityLifecycleCallbacks);
                return;
            }
            if (!this.f14672c) {
                this.f14670a.unregisterActivityLifecycleCallbacks(this);
                this.f14672c = true;
            }
        } catch (Throwable e) {
            mt.m19919b("Error while dispatching lifecycle callback.", e);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        m18560a(new aky(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        m18560a(new alf(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        m18560a(new alb(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        m18560a(new ala(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        m18560a(new ale(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        m18560a(new akz(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        m18560a(new alc(this, activity));
    }
}
