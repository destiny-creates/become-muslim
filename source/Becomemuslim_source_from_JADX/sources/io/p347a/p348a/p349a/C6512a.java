package io.p347a.p348a.p349a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ActivityLifecycleManager */
/* renamed from: io.a.a.a.a */
public class C6512a {
    /* renamed from: a */
    private final Application f20988a;
    /* renamed from: b */
    private C6413a f20989b;

    /* compiled from: ActivityLifecycleManager */
    /* renamed from: io.a.a.a.a$a */
    private static class C6413a {
        /* renamed from: a */
        private final Set<ActivityLifecycleCallbacks> f20740a = new HashSet();
        /* renamed from: b */
        private final Application f20741b;

        C6413a(Application application) {
            this.f20741b = application;
        }

        @TargetApi(14)
        /* renamed from: a */
        private void m26309a() {
            for (ActivityLifecycleCallbacks unregisterActivityLifecycleCallbacks : this.f20740a) {
                this.f20741b.unregisterActivityLifecycleCallbacks(unregisterActivityLifecycleCallbacks);
            }
        }

        @TargetApi(14)
        /* renamed from: a */
        private boolean m26312a(final C6414b c6414b) {
            if (this.f20741b == null) {
                return null;
            }
            ActivityLifecycleCallbacks c64121 = new ActivityLifecycleCallbacks(this) {
                /* renamed from: b */
                final /* synthetic */ C6413a f20739b;

                public void onActivityCreated(Activity activity, Bundle bundle) {
                    c6414b.mo5482a(activity, bundle);
                }

                public void onActivityStarted(Activity activity) {
                    c6414b.mo5481a(activity);
                }

                public void onActivityResumed(Activity activity) {
                    c6414b.mo5483b(activity);
                }

                public void onActivityPaused(Activity activity) {
                    c6414b.m26317c(activity);
                }

                public void onActivityStopped(Activity activity) {
                    c6414b.m26318d(activity);
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    c6414b.m26316b(activity, bundle);
                }

                public void onActivityDestroyed(Activity activity) {
                    c6414b.m26319e(activity);
                }
            };
            this.f20741b.registerActivityLifecycleCallbacks(c64121);
            this.f20740a.add(c64121);
            return true;
        }
    }

    /* compiled from: ActivityLifecycleManager */
    /* renamed from: io.a.a.a.a$b */
    public static abstract class C6414b {
        /* renamed from: a */
        public void mo5481a(Activity activity) {
        }

        /* renamed from: a */
        public void mo5482a(Activity activity, Bundle bundle) {
        }

        /* renamed from: b */
        public void mo5483b(Activity activity) {
        }

        /* renamed from: b */
        public void m26316b(Activity activity, Bundle bundle) {
        }

        /* renamed from: c */
        public void m26317c(Activity activity) {
        }

        /* renamed from: d */
        public void m26318d(Activity activity) {
        }

        /* renamed from: e */
        public void m26319e(Activity activity) {
        }
    }

    public C6512a(Context context) {
        this.f20988a = (Application) context.getApplicationContext();
        if (VERSION.SDK_INT >= 14) {
            this.f20989b = new C6413a(this.f20988a);
        }
    }

    /* renamed from: a */
    public boolean m26621a(C6414b c6414b) {
        return (this.f20989b == null || this.f20989b.m26312a(c6414b) == null) ? null : true;
    }

    /* renamed from: a */
    public void m26620a() {
        if (this.f20989b != null) {
            this.f20989b.m26309a();
        }
    }
}
