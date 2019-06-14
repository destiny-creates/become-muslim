package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.C2904o;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.gms.common.api.internal.b */
public final class C2794b implements ActivityLifecycleCallbacks, ComponentCallbacks2 {
    /* renamed from: a */
    private static final C2794b f7126a = new C2794b();
    /* renamed from: b */
    private final AtomicBoolean f7127b = new AtomicBoolean();
    /* renamed from: c */
    private final AtomicBoolean f7128c = new AtomicBoolean();
    /* renamed from: d */
    private final ArrayList<C2793a> f7129d = new ArrayList();
    /* renamed from: e */
    private boolean f7130e = false;

    /* renamed from: com.google.android.gms.common.api.internal.b$a */
    public interface C2793a {
        /* renamed from: a */
        void mo2424a(boolean z);
    }

    private C2794b() {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    /* renamed from: a */
    public static C2794b m7999a() {
        return f7126a;
    }

    /* renamed from: a */
    public static void m8000a(Application application) {
        synchronized (f7126a) {
            if (!f7126a.f7130e) {
                application.registerActivityLifecycleCallbacks(f7126a);
                application.registerComponentCallbacks(f7126a);
                f7126a.f7130e = true;
            }
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    public final boolean m8003a(boolean z) {
        if (!this.f7128c.get()) {
            if (!C2904o.m8458d()) {
                return z;
            }
            z = new RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(z);
            if (!this.f7128c.getAndSet(true) && z.importance > true) {
                this.f7127b.set(true);
            }
        }
        return m8004b();
    }

    /* renamed from: b */
    public final boolean m8004b() {
        return this.f7127b.get();
    }

    /* renamed from: a */
    public final void m8002a(C2793a c2793a) {
        synchronized (f7126a) {
            this.f7129d.add(c2793a);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        activity = this.f7127b.compareAndSet(true, false);
        this.f7128c.set(true);
        if (activity != null) {
            m8001b(false);
        }
    }

    public final void onActivityResumed(Activity activity) {
        activity = this.f7127b.compareAndSet(true, false);
        this.f7128c.set(true);
        if (activity != null) {
            m8001b(false);
        }
    }

    public final void onTrimMemory(int i) {
        if (i == 20 && this.f7127b.compareAndSet(false, true) != 0) {
            this.f7128c.set(true);
            m8001b(true);
        }
    }

    /* renamed from: b */
    private final void m8001b(boolean z) {
        synchronized (f7126a) {
            ArrayList arrayList = this.f7129d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((C2793a) obj).mo2424a(z);
            }
        }
    }
}
