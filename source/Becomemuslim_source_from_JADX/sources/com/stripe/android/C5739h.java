package com.stripe.android;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.internal.NativeProtocol;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: LoggingUtils */
/* renamed from: com.stripe.android.h */
class C5739h {
    /* renamed from: a */
    static final Set<String> f19101a = new HashSet();

    /* renamed from: b */
    static String m24304b() {
        return "analytics.stripe_android-1.0";
    }

    static {
        f19101a.add("analytics_ua");
        f19101a.add(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING);
        f19101a.add("app_version");
        f19101a.add("bindings_version");
        f19101a.add("device_type");
        f19101a.add("event");
        f19101a.add("os_version");
        f19101a.add("os_name");
        f19101a.add("os_release");
        f19101a.add("product_usage");
        f19101a.add("publishable_key");
        f19101a.add("source_type");
        f19101a.add("token_type");
    }

    /* renamed from: a */
    static Map<String, Object> m24301a(Context context, List<String> list, String str, String str2) {
        return C5739h.m24302a(context, list, null, str2, str, "token_creation");
    }

    /* renamed from: b */
    static Map<String, Object> m24305b(Context context, List<String> list, String str, String str2) {
        return C5739h.m24302a(context, list, str2, null, str, "source_creation");
    }

    /* renamed from: c */
    static Map<String, Object> m24306c(Context context, List<String> list, String str, String str2) {
        return C5739h.m24302a(context, list, str2, null, str, "add_source");
    }

    /* renamed from: a */
    static Map<String, Object> m24302a(Context context, List<String> list, String str, String str2, String str3, String str4) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("analytics_ua", C5739h.m24304b());
        hashMap.put("event", C5739h.m24300a(str4));
        hashMap.put("publishable_key", str3);
        hashMap.put("os_name", VERSION.CODENAME);
        hashMap.put("os_release", VERSION.RELEASE);
        hashMap.put("os_version", Integer.valueOf(VERSION.SDK_INT));
        hashMap.put("device_type", C5739h.m24299a());
        hashMap.put("bindings_version", "6.0.0");
        C5739h.m24303a(hashMap, context);
        if (list != null) {
            hashMap.put("product_usage", list);
        }
        if (str != null) {
            hashMap.put("source_type", str);
        }
        if (str2 != null) {
            hashMap.put("token_type", str2);
        } else if (str == null) {
            hashMap.put("token_type", "unknown");
        }
        return hashMap;
    }

    /* renamed from: a */
    static void m24303a(java.util.Map<java.lang.String, java.lang.Object> r3, android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = r4.getApplicationContext();
        if (r4 == 0) goto L_0x005b;
    L_0x0006:
        r0 = r4.getPackageManager();
        if (r0 == 0) goto L_0x005b;
    L_0x000c:
        r0 = r4.getPackageManager();	 Catch:{ NameNotFoundException -> 0x004c }
        r1 = r4.getPackageName();	 Catch:{ NameNotFoundException -> 0x004c }
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x004c }
        r0 = r0.getPackageInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x004c }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x004c }
        r2 = r0.applicationInfo;	 Catch:{ NameNotFoundException -> 0x004c }
        if (r2 == 0) goto L_0x0033;	 Catch:{ NameNotFoundException -> 0x004c }
    L_0x001e:
        r2 = r0.applicationInfo;	 Catch:{ NameNotFoundException -> 0x004c }
        r4 = r4.getPackageManager();	 Catch:{ NameNotFoundException -> 0x004c }
        r4 = r2.loadLabel(r4);	 Catch:{ NameNotFoundException -> 0x004c }
        if (r4 == 0) goto L_0x002e;	 Catch:{ NameNotFoundException -> 0x004c }
    L_0x002a:
        r1 = r4.toString();	 Catch:{ NameNotFoundException -> 0x004c }
    L_0x002e:
        r4 = "app_name";	 Catch:{ NameNotFoundException -> 0x004c }
        r3.put(r4, r1);	 Catch:{ NameNotFoundException -> 0x004c }
    L_0x0033:
        r4 = com.stripe.android.C5775u.m24419b(r1);	 Catch:{ NameNotFoundException -> 0x004c }
        if (r4 == 0) goto L_0x0040;	 Catch:{ NameNotFoundException -> 0x004c }
    L_0x0039:
        r4 = "app_name";	 Catch:{ NameNotFoundException -> 0x004c }
        r1 = r0.packageName;	 Catch:{ NameNotFoundException -> 0x004c }
        r3.put(r4, r1);	 Catch:{ NameNotFoundException -> 0x004c }
    L_0x0040:
        r4 = "app_version";	 Catch:{ NameNotFoundException -> 0x004c }
        r0 = r0.versionCode;	 Catch:{ NameNotFoundException -> 0x004c }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ NameNotFoundException -> 0x004c }
        r3.put(r4, r0);	 Catch:{ NameNotFoundException -> 0x004c }
        goto L_0x0069;
    L_0x004c:
        r4 = "app_name";
        r0 = "unknown";
        r3.put(r4, r0);
        r4 = "app_version";
        r0 = "unknown";
        r3.put(r4, r0);
        goto L_0x0069;
    L_0x005b:
        r4 = "app_name";
        r0 = "no_context";
        r3.put(r4, r0);
        r4 = "app_version";
        r0 = "no_context";
        r3.put(r4, r0);
    L_0x0069:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.h.a(java.util.Map, android.content.Context):void");
    }

    /* renamed from: a */
    static String m24299a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.MANUFACTURER);
        stringBuilder.append('_');
        stringBuilder.append(Build.BRAND);
        stringBuilder.append('_');
        stringBuilder.append(Build.MODEL);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    static String m24300a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stripe_android.");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
