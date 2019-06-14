package com.google.android.gms.internal.p213l;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

@TargetApi(14)
/* renamed from: com.google.android.gms.internal.l.dy */
final class dy implements ActivityLifecycleCallbacks {
    /* renamed from: a */
    private final /* synthetic */ df f17144a;

    private dy(df dfVar) {
        this.f17144a = dfVar;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.f17144a.mo4754r().m42579w().m21307a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null && data.isHierarchical()) {
                    if (bundle == null) {
                        Bundle a = this.f17144a.mo6213p().m42656a(data);
                        this.f17144a.mo6213p();
                        String str = fw.m42641a(intent) ? "gs" : "auto";
                        if (a != null) {
                            this.f17144a.m44099a(str, "_cmp", a);
                        }
                    }
                    Object queryParameter = data.getQueryParameter("referrer");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        Object obj = (queryParameter.contains("gclid") && (queryParameter.contains("utm_campaign") || queryParameter.contains("utm_source") || queryParameter.contains("utm_medium") || queryParameter.contains("utm_term") || queryParameter.contains("utm_content"))) ? 1 : null;
                        if (obj == null) {
                            this.f17144a.mo4754r().m42578v().m21307a("Activity created with data 'referrer' param without gclid and at least one utm field");
                            return;
                        }
                        this.f17144a.mo4754r().m42578v().m21308a("Activity created with referrer", queryParameter);
                        if (!TextUtils.isEmpty(queryParameter)) {
                            this.f17144a.m44102a("auto", "_ldl", queryParameter);
                        }
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception e) {
            this.f17144a.mo4754r().I_().m21308a("Throwable caught in onActivityCreated", e);
        }
        this.f17144a.mo6745i().m44143a(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.f17144a.mo6745i().m44150c(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.f17144a.mo6745i().m44147b(activity);
        db k = this.f17144a.mo6747k();
        k.mo4753q().m42612a(new fg(k, k.mo4751m().b()));
    }

    public final void onActivityResumed(Activity activity) {
        this.f17144a.mo6745i().m44142a(activity);
        db k = this.f17144a.mo6747k();
        k.mo4753q().m42612a(new ff(k, k.mo4751m().b()));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f17144a.mo6745i().m44148b(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
