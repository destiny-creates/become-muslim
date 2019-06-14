package com.facebook.marketing;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.facebook.marketing.internal.ButtonIndexer;

public class CodelessActivityLifecycleTracker {
    private static final String TAG = CodelessActivityLifecycleTracker.class.getCanonicalName();
    private static final ButtonIndexer buttonIndexer = new ButtonIndexer();
    private static Boolean isAppIndexingEnabled = Boolean.valueOf(false);

    /* renamed from: com.facebook.marketing.CodelessActivityLifecycleTracker$1 */
    static class C18431 implements ActivityLifecycleCallbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        C18431() {
        }

        public void onActivityResumed(Activity activity) {
            CodelessActivityLifecycleTracker.buttonIndexer.add(activity);
        }

        public void onActivityPaused(Activity activity) {
            CodelessActivityLifecycleTracker.buttonIndexer.remove(activity);
        }
    }

    public static void startTracking(Application application) {
        application.registerActivityLifecycleCallbacks(new C18431());
    }

    public static boolean getIsAppIndexingEnabled() {
        return isAppIndexingEnabled.booleanValue();
    }

    public static void updateAppIndexing(Boolean bool) {
        isAppIndexingEnabled = bool;
    }
}
