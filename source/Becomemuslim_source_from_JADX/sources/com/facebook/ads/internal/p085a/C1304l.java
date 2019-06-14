package com.facebook.ads.internal.p085a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.ads.internal.p098m.C1412c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.a.l */
public class C1304l {
    /* renamed from: a */
    private final C1412c f3760a;
    /* renamed from: b */
    private Application f3761b;
    /* renamed from: c */
    private C1303a f3762c;
    /* renamed from: d */
    private long f3763d = 0;
    /* renamed from: e */
    private String f3764e = null;
    /* renamed from: f */
    private C1296a f3765f = null;

    @TargetApi(14)
    /* renamed from: com.facebook.ads.internal.a.l$a */
    private static class C1303a implements ActivityLifecycleCallbacks {
        /* renamed from: a */
        private final WeakReference<Activity> f3758a;
        /* renamed from: b */
        private C1304l f3759b;

        public C1303a(Activity activity, C1304l c1304l) {
            this.f3758a = new WeakReference(activity);
            this.f3759b = c1304l;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
            if (this.f3759b != null) {
                Activity activity2 = (Activity) this.f3758a.get();
                if (activity2 == null || (activity2 != null && activity.equals(activity2))) {
                    this.f3759b.m4460a();
                    this.f3759b = null;
                }
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    private C1304l(C1412c c1412c, Activity activity, int i) {
        this.f3760a = c1412c;
        this.f3761b = activity.getApplication();
        this.f3762c = new C1303a(activity, this);
    }

    /* renamed from: a */
    public static C1304l m4457a(C1412c c1412c, Activity activity) {
        return C1304l.m4458a(c1412c, activity, VERSION.SDK_INT);
    }

    /* renamed from: a */
    protected static C1304l m4458a(C1412c c1412c, Activity activity, int i) {
        return (activity == null || i < 14) ? null : new C1304l(c1412c, activity, i);
    }

    /* renamed from: a */
    private void m4459a(String str, long j, long j2, C1296a c1296a) {
        Map hashMap = new HashMap();
        hashMap.put("leave_time", Long.toString(j));
        hashMap.put("back_time", Long.toString(j2));
        if (c1296a != null) {
            hashMap.put("outcome", c1296a.name());
        }
        this.f3760a.mo955j(str, hashMap);
    }

    @TargetApi(14)
    /* renamed from: a */
    public void m4460a() {
        m4459a(this.f3764e, this.f3763d, System.currentTimeMillis(), this.f3765f);
        if (this.f3761b != null && this.f3762c != null) {
            this.f3761b.unregisterActivityLifecycleCallbacks(this.f3762c);
            this.f3762c = null;
            this.f3761b = null;
        }
    }

    /* renamed from: a */
    public void m4461a(C1296a c1296a) {
        this.f3765f = c1296a;
    }

    @TargetApi(14)
    /* renamed from: a */
    public void m4462a(String str) {
        this.f3764e = str;
        if (this.f3762c == null || this.f3761b == null) {
            m4459a(str, -1, -1, C1296a.CANNOT_TRACK);
            return;
        }
        this.f3763d = System.currentTimeMillis();
        this.f3761b.registerActivityLifecycleCallbacks(this.f3762c);
    }
}
