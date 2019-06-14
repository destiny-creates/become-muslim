package com.onesignal;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import com.onesignal.am.C5464i;

/* compiled from: ActivityLifecycleHandler */
/* renamed from: com.onesignal.a */
class C5440a {
    /* renamed from: a */
    static boolean f18257a;
    /* renamed from: b */
    static Activity f18258b;
    /* renamed from: c */
    static C5439c f18259c = new C5439c();
    /* renamed from: d */
    private static C5437a f18260d;

    /* compiled from: ActivityLifecycleHandler */
    /* renamed from: com.onesignal.a$a */
    interface C5437a {
        /* renamed from: a */
        void mo4929a(Activity activity);
    }

    /* compiled from: ActivityLifecycleHandler */
    /* renamed from: com.onesignal.a$b */
    private static class C5438b implements Runnable {
        /* renamed from: a */
        private boolean f18253a;
        /* renamed from: b */
        private boolean f18254b;

        private C5438b() {
        }

        public void run() {
            if (C5440a.f18258b == null) {
                this.f18253a = true;
                am.m23212e();
                this.f18254b = true;
            }
        }
    }

    /* compiled from: ActivityLifecycleHandler */
    /* renamed from: com.onesignal.a$c */
    static class C5439c extends HandlerThread {
        /* renamed from: a */
        Handler f18255a = null;
        /* renamed from: b */
        private C5438b f18256b;

        C5439c() {
            super("FocusHandlerThread");
            start();
            this.f18255a = new Handler(getLooper());
        }

        /* renamed from: a */
        void m23052a() {
            if (this.f18256b != null) {
                this.f18256b.f18253a = false;
            }
        }

        /* renamed from: b */
        void m23054b() {
            this.f18255a.removeCallbacksAndMessages(null);
        }

        /* renamed from: a */
        void m23053a(C5438b c5438b) {
            if (this.f18256b == null || !this.f18256b.f18253a || this.f18256b.f18254b) {
                this.f18256b = c5438b;
                this.f18255a.removeCallbacksAndMessages(null);
                this.f18255a.postDelayed(c5438b, 2000);
            }
        }

        /* renamed from: c */
        boolean m23055c() {
            return this.f18256b != null && this.f18256b.f18253a;
        }
    }

    /* renamed from: a */
    static void m23057a(Activity activity) {
    }

    /* renamed from: b */
    static void m23060b(Activity activity) {
    }

    /* renamed from: a */
    static void m23058a(C5437a c5437a) {
        if (f18258b != null) {
            c5437a.mo4929a(f18258b);
            f18260d = c5437a;
            return;
        }
        f18260d = c5437a;
    }

    /* renamed from: b */
    public static void m23061b(C5437a c5437a) {
        f18260d = null;
    }

    /* renamed from: g */
    private static void m23067g(Activity activity) {
        f18258b = activity;
        if (f18260d != null) {
            f18260d.mo4929a(f18258b);
        }
    }

    /* renamed from: c */
    static void m23063c(Activity activity) {
        C5440a.m23067g(activity);
        C5440a.m23056a();
        C5440a.m23062c();
    }

    /* renamed from: d */
    static void m23064d(Activity activity) {
        if (activity == f18258b) {
            f18258b = null;
            C5440a.m23059b();
        }
        C5440a.m23056a();
    }

    /* renamed from: e */
    static void m23065e(Activity activity) {
        C5464i c5464i = C5464i.DEBUG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityStopped: ");
        stringBuilder.append(activity.getClass().getName());
        am.m23187b(c5464i, stringBuilder.toString());
        if (activity == f18258b) {
            f18258b = null;
            C5440a.m23059b();
        }
        C5440a.m23056a();
    }

    /* renamed from: f */
    static void m23066f(Activity activity) {
        C5464i c5464i = C5464i.DEBUG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityDestroyed: ");
        stringBuilder.append(activity.getClass().getName());
        am.m23187b(c5464i, stringBuilder.toString());
        if (activity == f18258b) {
            f18258b = null;
            C5440a.m23059b();
        }
        C5440a.m23056a();
    }

    /* renamed from: a */
    private static void m23056a() {
        String stringBuilder;
        C5464i c5464i = C5464i.DEBUG;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("curActivity is NOW: ");
        if (f18258b != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("");
            stringBuilder3.append(f18258b.getClass().getName());
            stringBuilder3.append(":");
            stringBuilder3.append(f18258b);
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = "null";
        }
        stringBuilder2.append(stringBuilder);
        am.m23187b(c5464i, stringBuilder2.toString());
    }

    /* renamed from: b */
    private static void m23059b() {
        f18259c.m23053a(new C5438b());
    }

    /* renamed from: c */
    private static void m23062c() {
        if (!f18259c.m23055c()) {
            if (!f18257a) {
                f18259c.m23054b();
                return;
            }
        }
        f18257a = false;
        f18259c.m23052a();
        am.m23222g();
    }
}
