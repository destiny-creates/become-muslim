package com.bugsnag.android;

import android.util.Log;

/* compiled from: Logger */
final class ad {
    /* renamed from: a */
    private static volatile boolean f3013a = true;

    /* renamed from: a */
    static void m3732a(String str) {
        if (f3013a) {
            Log.i("Bugsnag", str);
        }
    }

    /* renamed from: b */
    static void m3736b(String str) {
        if (f3013a) {
            Log.w("Bugsnag", str);
        }
    }

    /* renamed from: a */
    static void m3733a(String str, Throwable th) {
        if (f3013a) {
            Log.w("Bugsnag", str, th);
        }
    }

    /* renamed from: a */
    static void m3734a(boolean z) {
        f3013a = z;
    }

    /* renamed from: a */
    static boolean m3735a() {
        return f3013a;
    }
}
