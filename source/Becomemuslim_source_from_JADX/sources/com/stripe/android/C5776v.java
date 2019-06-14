package com.stripe.android;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import com.amplitude.api.Constants;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* compiled from: TelemetryClientUtil */
/* renamed from: com.stripe.android.v */
class C5776v {
    /* renamed from: a */
    static java.util.Map<java.lang.String, java.lang.Object> m24423a(android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = new java.util.HashMap;
        r1.<init>();
        r2 = new java.util.HashMap;
        r2.<init>();
        r3 = "v2";
        r4 = 1;
        r4 = java.lang.Integer.valueOf(r4);
        r0.put(r3, r4);
        r3 = "tag";
        r4 = "6.0.0";
        r0.put(r3, r4);
        r3 = "src";
        r4 = "android-sdk";
        r0.put(r3, r4);
        r3 = "c";
        r4 = java.util.Locale.getDefault();
        r4 = r4.toString();
        r4 = com.stripe.android.C5776v.m24424a(r4);
        r1.put(r3, r4);
        r3 = "d";
        r4 = com.stripe.android.C5776v.m24425b();
        r4 = com.stripe.android.C5776v.m24424a(r4);
        r1.put(r3, r4);
        r3 = "f";
        r4 = com.stripe.android.C5776v.m24427c(r5);
        r4 = com.stripe.android.C5776v.m24424a(r4);
        r1.put(r3, r4);
        r3 = "g";
        r4 = com.stripe.android.C5776v.m24422a();
        r4 = com.stripe.android.C5776v.m24424a(r4);
        r1.put(r3, r4);
        r3 = "a";
        r0.put(r3, r1);
        r1 = "d";
        r3 = com.stripe.android.C5776v.m24428d(r5);
        r2.put(r1, r3);
        r1 = com.stripe.android.C5776v.m24429e(r5);
        r3 = "k";
        r2.put(r3, r1);
        r3 = "o";
        r4 = android.os.Build.VERSION.RELEASE;
        r2.put(r3, r4);
        r3 = "p";
        r4 = android.os.Build.VERSION.SDK_INT;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
        r3 = "q";
        r4 = android.os.Build.MANUFACTURER;
        r2.put(r3, r4);
        r3 = "r";
        r4 = android.os.Build.BRAND;
        r2.put(r3, r4);
        r3 = "s";
        r4 = android.os.Build.MODEL;
        r2.put(r3, r4);
        r3 = "t";
        r4 = android.os.Build.TAGS;
        r2.put(r3, r4);
        r3 = r5.getPackageName();
        if (r3 == 0) goto L_0x00ba;
    L_0x00aa:
        r5 = r5.getPackageManager();	 Catch:{ NameNotFoundException -> 0x00ba }
        r3 = 0;	 Catch:{ NameNotFoundException -> 0x00ba }
        r5 = r5.getPackageInfo(r1, r3);	 Catch:{ NameNotFoundException -> 0x00ba }
        r1 = "l";	 Catch:{ NameNotFoundException -> 0x00ba }
        r5 = r5.versionName;	 Catch:{ NameNotFoundException -> 0x00ba }
        r2.put(r1, r5);	 Catch:{ NameNotFoundException -> 0x00ba }
    L_0x00ba:
        r5 = "b";
        r0.put(r5, r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.v.a(android.content.Context):java.util.Map<java.lang.String, java.lang.Object>");
    }

    /* renamed from: a */
    private static Map<String, Object> m24424a(Object obj) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put("v", obj);
        return hashMap;
    }

    /* renamed from: a */
    private static String m24422a() {
        int convert = (int) TimeUnit.MINUTES.convert((long) TimeZone.getDefault().getRawOffset(), TimeUnit.MILLISECONDS);
        if (convert % 60 == 0) {
            return String.valueOf(convert / 60);
        }
        return new BigDecimal(convert).setScale(2, 6).divide(new BigDecimal(60), new MathContext(2)).setScale(2, 6).toString();
    }

    /* renamed from: c */
    private static String m24427c(Context context) {
        if (context.getResources() == null) {
            return "";
        }
        int i = context.getResources().getDisplayMetrics().widthPixels;
        int i2 = context.getResources().getDisplayMetrics().heightPixels;
        context = context.getResources().getDisplayMetrics().densityDpi;
        return String.format(Locale.ENGLISH, "%dw_%dh_%ddpi", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(context)});
    }

    /* renamed from: b */
    private static String m24425b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Constants.PLATFORM);
        stringBuilder.append(" ");
        stringBuilder.append(VERSION.RELEASE);
        stringBuilder.append(" ");
        stringBuilder.append(VERSION.CODENAME);
        stringBuilder.append(" ");
        stringBuilder.append(VERSION.SDK_INT);
        return stringBuilder.toString();
    }

    /* renamed from: b */
    static String m24426b(Context context) {
        context = Secure.getString(context.getContentResolver(), "android_id");
        if (C5775u.m24419b(context)) {
            return "";
        }
        context = C5775u.m24421d(context);
        if (context == null) {
            context = "";
        }
        return context;
    }

    /* renamed from: d */
    private static String m24428d(Context context) {
        String b = C5776v.m24426b(context);
        context = C5776v.m24429e(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context);
        stringBuilder.append(b);
        context = C5775u.m24421d(stringBuilder.toString());
        return context == null ? "" : context;
    }

    /* renamed from: e */
    private static String m24429e(Context context) {
        if (context.getApplicationContext() != null) {
            if (context.getApplicationContext().getPackageName() != null) {
                return context.getApplicationContext().getPackageName();
            }
        }
        return "";
    }
}
