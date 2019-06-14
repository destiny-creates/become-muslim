package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.ads.internal.ax;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
final class all implements ActivityLifecycleCallbacks {
    /* renamed from: a */
    private Activity f14696a;
    /* renamed from: b */
    private Context f14697b;
    /* renamed from: c */
    private final Object f14698c = new Object();
    /* renamed from: d */
    private boolean f14699d = true;
    /* renamed from: e */
    private boolean f14700e = false;
    /* renamed from: f */
    private final List<aln> f14701f = new ArrayList();
    /* renamed from: g */
    private final List<ama> f14702g = new ArrayList();
    /* renamed from: h */
    private Runnable f14703h;
    /* renamed from: i */
    private boolean f14704i = false;
    /* renamed from: j */
    private long f14705j;

    all() {
    }

    /* renamed from: a */
    private final void m18589a(Activity activity) {
        synchronized (this.f14698c) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.f14696a = activity;
            }
        }
    }

    /* renamed from: a */
    public final Activity m18594a() {
        return this.f14696a;
    }

    /* renamed from: a */
    public final void m18595a(Application application, Context context) {
        if (!this.f14704i) {
            application.registerActivityLifecycleCallbacks(this);
            if (context instanceof Activity) {
                m18589a((Activity) context);
            }
            this.f14697b = application;
            this.f14705j = ((Long) aph.m18688f().m18889a(asp.aH)).longValue();
            this.f14704i = true;
        }
    }

    /* renamed from: a */
    public final void m18596a(aln aln) {
        synchronized (this.f14698c) {
            this.f14701f.add(aln);
        }
    }

    /* renamed from: b */
    public final Context m18597b() {
        return this.f14697b;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.f14698c) {
            if (this.f14696a == null) {
                return;
            }
            if (this.f14696a.equals(activity)) {
                this.f14696a = null;
            }
            Iterator it = this.f14702g.iterator();
            while (it.hasNext()) {
                try {
                    if (((ama) it.next()).m18622c(activity)) {
                        it.remove();
                    }
                } catch (Throwable e) {
                    ax.i().m30834a(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                    mt.m19919b("", e);
                }
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        m18589a(activity);
        synchronized (this.f14698c) {
            for (ama b : this.f14702g) {
                try {
                    b.m18621b(activity);
                } catch (Throwable e) {
                    ax.i().m30834a(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    mt.m19919b("", e);
                }
            }
        }
        this.f14700e = true;
        if (this.f14703h != null) {
            jw.f15691a.removeCallbacks(this.f14703h);
        }
        Handler handler = jw.f15691a;
        Runnable alm = new alm(this);
        this.f14703h = alm;
        handler.postDelayed(alm, this.f14705j);
    }

    public final void onActivityResumed(Activity activity) {
        m18589a(activity);
        this.f14700e = false;
        int i = this.f14699d ^ 1;
        this.f14699d = true;
        if (this.f14703h != null) {
            jw.f15691a.removeCallbacks(this.f14703h);
        }
        synchronized (this.f14698c) {
            for (ama a : this.f14702g) {
                try {
                    a.m18620a(activity);
                } catch (Throwable e) {
                    ax.i().m30834a(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    mt.m19919b("", e);
                }
            }
            if (i != 0) {
                for (aln a2 : this.f14701f) {
                    try {
                        a2.mo3846a(true);
                    } catch (Throwable e2) {
                        mt.m19919b("", e2);
                    }
                }
            } else {
                mt.m19918b("App is still foreground.");
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        m18589a(activity);
    }

    public final void onActivityStopped(Activity activity) {
    }
}
