package com.bugsnag.android;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class NativeInterface {
    @SuppressLint({"StaticFieldLeak"})
    private static C1089j client;

    /* renamed from: com.bugsnag.android.NativeInterface$a */
    public static class C1068a {
        /* renamed from: a */
        public final C1069b f2969a;
        /* renamed from: b */
        public final Object f2970b;

        public C1068a(C1069b c1069b, Object obj) {
            this.f2969a = c1069b;
            this.f2970b = obj;
        }
    }

    /* renamed from: com.bugsnag.android.NativeInterface$b */
    public enum C1069b {
        ADD_BREADCRUMB,
        ADD_METADATA,
        CLEAR_BREADCRUMBS,
        CLEAR_METADATA_TAB,
        DELIVER_PENDING,
        INSTALL,
        NOTIFY_HANDLED,
        REMOVE_METADATA,
        START_SESSION,
        STOP_SESSION,
        UPDATE_APP_VERSION,
        UPDATE_BUILD_UUID,
        UPDATE_CONTEXT,
        UPDATE_IN_FOREGROUND,
        UPDATE_LOW_MEMORY,
        UPDATE_METADATA,
        UPDATE_ORIENTATION,
        UPDATE_RELEASE_STAGE,
        UPDATE_USER_EMAIL,
        UPDATE_USER_NAME,
        UPDATE_USER_ID
    }

    private static C1089j getClient() {
        if (client != null) {
            return client;
        }
        return C1080f.m3779e();
    }

    public static void setClient(C1089j c1089j) {
        if (client != c1089j) {
            client = c1089j;
            configureClientObservers(c1089j);
        }
    }

    public static void configureClientObservers(com.bugsnag.android.C1089j r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = "com.bugsnag.android.ndk.NativeBridge";	 Catch:{ ClassNotFoundException -> 0x001e, InstantiationException -> 0x0017, IllegalAccessException -> 0x0010 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x001e, InstantiationException -> 0x0017, IllegalAccessException -> 0x0010 }
        r0 = r0.newInstance();	 Catch:{ ClassNotFoundException -> 0x001e, InstantiationException -> 0x0017, IllegalAccessException -> 0x0010 }
        r0 = (java.util.Observer) r0;	 Catch:{ ClassNotFoundException -> 0x001e, InstantiationException -> 0x0017, IllegalAccessException -> 0x0010 }
        r2.addObserver(r0);	 Catch:{ ClassNotFoundException -> 0x001e, InstantiationException -> 0x0017, IllegalAccessException -> 0x0010 }
        goto L_0x0023;
    L_0x0010:
        r0 = move-exception;
        r1 = "Could not access NDK observer";
        com.bugsnag.android.ad.m3733a(r1, r0);
        goto L_0x0023;
    L_0x0017:
        r0 = move-exception;
        r1 = "Failed to instantiate NDK observer";
        com.bugsnag.android.ad.m3733a(r1, r0);
        goto L_0x0023;
    L_0x001e:
        r0 = "Bugsnag NDK integration not available";
        com.bugsnag.android.ad.m3732a(r0);
    L_0x0023:
        r2.m3793a();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.NativeInterface.configureClientObservers(com.bugsnag.android.j):void");
    }

    public static String getContext() {
        return getClient().m3815f();
    }

    public static boolean getLoggingEnabled() {
        return ad.m3735a();
    }

    public static String getNativeReportPath() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClient().f3049b.getCacheDir().getAbsolutePath());
        stringBuilder.append("/bugsnag-native/");
        return stringBuilder.toString();
    }

    public static Map<String, String> getUserData() {
        Map hashMap = new HashMap();
        aq g = getClient().m3817g();
        hashMap.put("id", g.m11052a());
        hashMap.put("name", g.m11056c());
        hashMap.put("email", g.m11054b());
        return hashMap;
    }

    public static Map<String, Object> getAppData() {
        Map hashMap = new HashMap();
        C1070a h = getClient().m3819h();
        hashMap.putAll(h.m3703b());
        hashMap.putAll(h.m3704c());
        return hashMap;
    }

    public static Map<String, Object> getDeviceData() {
        Map hashMap = new HashMap();
        C1099r i = getClient().m3820i();
        hashMap.putAll(i.m3899c());
        hashMap.putAll(i.m3898b());
        return hashMap;
    }

    public static String[] getCpuAbi() {
        return getClient().f3050c.f3094e;
    }

    public static Map<String, Object> getMetaData() {
        return new HashMap(getClient().m3822k().f9164a);
    }

    public static List<Breadcrumb> getBreadcrumbs() {
        return new ArrayList(getClient().f3052e.store);
    }

    public static void setUser(String str, String str2, String str3) {
        C1089j client = getClient();
        client.m3812d(str);
        client.m3813e(str2);
        client.m3816f(str3);
    }

    public static void leaveBreadcrumb(String str, BreadcrumbType breadcrumbType) {
        getClient().m3797a(str, breadcrumbType, new HashMap());
    }

    public static void leaveBreadcrumb(String str, String str2, Map<String, String> map) {
        Map hashMap;
        str2 = str2.toUpperCase(Locale.US);
        if (map == null) {
            hashMap = new HashMap();
        }
        getClient().m3797a(str, BreadcrumbType.valueOf(str2), hashMap);
    }

    public static void addToTab(String str, String str2, Object obj) {
        getClient().m3798a(str, str2, obj);
    }

    public static void setReleaseStage(String str) {
        getClient().m3809c(str);
    }

    public static String getReleaseStage() {
        return getClient().m3826o().m3855i();
    }

    public static String getSessionEndpoint() {
        return getClient().m3826o().m3846e();
    }

    public static String getEndpoint() {
        return getClient().m3826o().m3843d();
    }

    public static void setSessionEndpoint(String str) {
        getClient().m3826o().m3844d(str);
    }

    public static void setEndpoint(String str) {
        getClient().m3826o().m3840c(str);
    }

    public static void setContext(String str) {
        getClient().m3806b(str);
    }

    public static void setAppVersion(String str) {
        getClient().m3796a(str);
    }

    public static void setBinaryArch(String str) {
        getClient().m3818g(str);
    }

    public static String getAppVersion() {
        return getClient().m3826o().m3835b();
    }

    public static String[] getNotifyReleaseStages() {
        return getClient().m3826o().m3852g();
    }

    public static void setNotifyReleaseStages(String[] strArr) {
        getClient().m3826o().m3838b(strArr);
    }

    public static void deliverReport(String str, String str2) {
        C1089j client = getClient();
        if (str == null || str.length() == 0 || client.m3826o().m3851g(str) != null) {
            client.m3825n().m3931a(str2);
            client.m3825n().m11086b();
        }
    }

    public static void notify(String str, String str2, final Severity severity, StackTraceElement[] stackTraceElementArr) {
        getClient().m3800a(str, str2, stackTraceElementArr, new C1082i() {
            /* renamed from: a */
            public void mo763a(ai aiVar) {
                aiVar = aiVar.m11039a();
                if (aiVar != null) {
                    if (severity != null) {
                        aiVar.m11064a(severity);
                    }
                    aiVar.m11077h().m11090a("c");
                }
            }
        });
    }
}
