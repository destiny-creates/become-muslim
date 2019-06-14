package com.bugsnag.android;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.Map;

/* compiled from: Bugsnag */
/* renamed from: com.bugsnag.android.f */
public final class C1080f {
    @SuppressLint({"StaticFieldLeak"})
    /* renamed from: a */
    static C1089j f3035a;
    /* renamed from: b */
    private static final Object f3036b = new Object();

    /* renamed from: a */
    public static C1089j m3768a(Context context) {
        return C1080f.m3771a(context, null, true);
    }

    /* renamed from: a */
    public static C1089j m3770a(Context context, String str) {
        return C1080f.m3771a(context, str, true);
    }

    /* renamed from: a */
    public static C1089j m3771a(Context context, String str, boolean z) {
        return C1080f.m3769a(context, C1090k.m3827a(context, str, z));
    }

    /* renamed from: a */
    public static C1089j m3769a(Context context, C1091l c1091l) {
        synchronized (f3036b) {
            if (f3035a == null) {
                f3035a = new C1089j(context, c1091l);
                NativeInterface.configureClientObservers(f3035a);
            } else {
                C1080f.m3780f();
            }
        }
        return f3035a;
    }

    /* renamed from: f */
    private static void m3780f() {
        ad.m3736b("It appears that Bugsnag.init() was called more than once. Subsequent calls have no effect, but may indicate that Bugsnag is not integrated in an Application subclass, which can lead to undesired behaviour.");
    }

    /* renamed from: a */
    public static void m3774a(String str, String str2, String str3) {
        C1080f.m3779e().m3799a(str, str2, str3);
    }

    /* renamed from: a */
    public static void m3772a() {
        C1080f.m3779e().m3821j();
    }

    /* renamed from: a */
    public static void m3775a(Throwable th, Map<String, Object> map, boolean z, C1082i c1082i) {
        C1080f.m3779e().m3802a(th, (Map) map, z, c1082i);
    }

    /* renamed from: a */
    public static void m3773a(String str, BreadcrumbType breadcrumbType, Map<String, String> map) {
        C1080f.m3779e().m3797a(str, breadcrumbType, (Map) map);
    }

    /* renamed from: b */
    public static void m3776b() {
        C1080f.m3779e().m3808c();
    }

    /* renamed from: c */
    public static boolean m3777c() {
        return C1080f.m3779e().m3814e();
    }

    /* renamed from: d */
    public static void m3778d() {
        C1080f.m3779e().m3811d();
    }

    /* renamed from: e */
    public static C1089j m3779e() {
        if (f3035a != null) {
            return f3035a;
        }
        throw new IllegalStateException("You must call Bugsnag.init before any other Bugsnag methods");
    }
}
