package com.onesignal;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.imageutils.JfifUtil;
import com.facebook.places.model.PlaceFields;
import com.facebook.stetho.common.Utf8Charset;
import com.onesignal.am.C5464i;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: OSUtils */
class al {
    al() {
    }

    /* renamed from: a */
    int m23104a(Context context, int i, String str) {
        try {
            UUID.fromString(str);
            if ("b2f7f966-d8cc-11e4-bed1-df8f05be55ba".equals(str) || "5eb5a37e-b458-11e3-ac11-000c2940e62c".equals(str) != null) {
                am.m23187b(C5464i.ERROR, "OneSignal Example AppID detected, please update to your app's id found on OneSignal.com");
            }
            str = true;
            if (i == 1) {
                i = m23105b();
                if (i != 0) {
                    str = i.intValue();
                }
            }
            context = m23098c(context);
            if (context != null) {
                str = context.intValue();
            }
            return str;
        } catch (Throwable th) {
            am.m23161a(C5464i.FATAL, "OneSignal AppId format is invalid.\nExample: 'b2f7f966-d8cc-11e4-bed1-df8f05be55ba'\n", th);
            return -999;
        }
    }

    /* renamed from: a */
    static boolean m23091a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.google.firebase.messaging.C5372a.class;	 Catch:{ Throwable -> 0x0004 }
        r0 = 1;
        return r0;
    L_0x0004:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.al.a():boolean");
    }

    /* renamed from: g */
    private static boolean m23100g() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.google.android.gms.gcm.C3055b.class;	 Catch:{ Throwable -> 0x0004 }
        r0 = 1;
        return r0;
    L_0x0004:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.al.g():boolean");
    }

    /* renamed from: b */
    Integer m23105b() {
        boolean a = m23091a();
        boolean g = m23100g();
        if (a || g) {
            if (g && !a) {
                am.m23187b(C5464i.WARN, "GCM Library detected, please upgrade to Firebase FCM library as GCM is deprecated!");
            }
            if (g && a) {
                am.m23187b(C5464i.WARN, "Both GCM & FCM Libraries detected! Please remove the deprecated GCM library.");
            }
            return null;
        }
        am.m23187b(C5464i.FATAL, "The Firebase FCM library is missing! Please make sure to include it in your project.");
        return Integer.valueOf(-4);
    }

    /* renamed from: h */
    private static boolean m23101h() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.support.v4.content.C0383g.class;	 Catch:{ Throwable -> 0x0004 }
        r0 = 1;
        return r0;
    L_0x0004:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.al.h():boolean");
    }

    /* renamed from: i */
    private static boolean m23102i() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.support.v4.app.af.class;	 Catch:{ Throwable -> 0x0004 }
        r0 = 1;
        return r0;
    L_0x0004:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.al.i():boolean");
    }

    /* renamed from: j */
    private static boolean m23103j() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.support.v4.app.C0342y.class;	 Catch:{ Throwable -> 0x0004 }
        r0 = 1;
        return r0;
    L_0x0004:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.al.j():boolean");
    }

    /* renamed from: c */
    private Integer m23098c(Context context) {
        boolean h = m23101h();
        boolean i = m23102i();
        if (h || i) {
            if (h) {
                if (i) {
                    if (VERSION.SDK_INT < 26 || m23095b(context) < 26 || m23103j() != null) {
                        return null;
                    }
                    am.m23187b(C5464i.FATAL, "The included Android Support Library is to old or incomplete. Please update to the 26.0.0 revision or newer.");
                    return Integer.valueOf(-5);
                }
            }
            am.m23187b(C5464i.FATAL, "The included Android Support Library is to old or incomplete. Please update to the 26.0.0 revision or newer.");
            return Integer.valueOf(-5);
        }
        am.m23187b(C5464i.FATAL, "Could not find the Android Support Library. Please make sure it has been correctly added to your project.");
        return Integer.valueOf(-3);
    }

    /* renamed from: c */
    int m23106c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = "com.amazon.device.messaging.ADM";	 Catch:{ ClassNotFoundException -> 0x0007 }
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0007 }
        r0 = 2;
        return r0;
    L_0x0007:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.al.c():int");
    }

    /* renamed from: d */
    Integer m23107d() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) am.f18401b.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        if (type != 1) {
            if (type != 9) {
                return Integer.valueOf(1);
            }
        }
        return Integer.valueOf(0);
    }

    /* renamed from: e */
    String m23108e() {
        String str = null;
        try {
            String networkOperatorName = ((TelephonyManager) am.f18401b.getSystemService(PlaceFields.PHONE)).getNetworkOperatorName();
            if (!"".equals(networkOperatorName)) {
                str = networkOperatorName;
            }
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    static String m23086a(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
        } catch (Throwable th) {
            am.m23161a(C5464i.ERROR, "", th);
            return null;
        }
    }

    /* renamed from: a */
    static String m23087a(Context context, String str, String str2) {
        Resources resources = context.getResources();
        context = resources.getIdentifier(str, "string", context.getPackageName());
        return context != null ? resources.getString(context) : str2;
    }

    /* renamed from: f */
    static String m23099f() {
        String language = Locale.getDefault().getLanguage();
        if (language.equals("iw")) {
            return "he";
        }
        if (language.equals("in")) {
            return "id";
        }
        if (language.equals("ji")) {
            return "yi";
        }
        if (!language.equals("zh")) {
            return language;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(language);
        stringBuilder.append("-");
        stringBuilder.append(Locale.getDefault().getCountry());
        return stringBuilder.toString();
    }

    /* renamed from: a */
    static boolean m23093a(String str) {
        if (str == null) {
            return null;
        }
        return Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$").matcher(str).matches();
    }

    /* renamed from: a */
    static boolean m23092a(android.content.Context r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.onesignal.am.f18401b;	 Catch:{ Throwable -> 0x000b }
        r0 = android.support.v4.app.af.a(r0);	 Catch:{ Throwable -> 0x000b }
        r0 = r0.a();	 Catch:{ Throwable -> 0x000b }
        return r0;
    L_0x000b:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.al.a(android.content.Context):boolean");
    }

    /* renamed from: a */
    static void m23090a(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    /* renamed from: b */
    static int m23095b(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion;
        } catch (Context context2) {
            context2.printStackTrace();
            return 15;
        }
    }

    /* renamed from: b */
    static boolean m23097b(String str) {
        return (str == null || str.matches("^[0-9]") != null) ? null : true;
    }

    /* renamed from: b */
    static Uri m23096b(Context context, String str) {
        Resources resources = context.getResources();
        context = context.getPackageName();
        if (m23097b(str)) {
            str = resources.getIdentifier(str, "raw", context);
            if (str != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("android.resource://");
                stringBuilder.append(context);
                stringBuilder.append("/");
                stringBuilder.append(str);
                return Uri.parse(stringBuilder.toString());
            }
        }
        str = resources.getIdentifier("onesignal_default_sound", "raw", context);
        if (str == null) {
            return null;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("android.resource://");
        stringBuilder.append(context);
        stringBuilder.append("/");
        stringBuilder.append(str);
        return Uri.parse(stringBuilder.toString());
    }

    /* renamed from: a */
    static long[] m23094a(org.json.JSONObject r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "vib_pt";	 Catch:{ JSONException -> 0x002c }
        r4 = r4.opt(r0);	 Catch:{ JSONException -> 0x002c }
        r0 = r4 instanceof java.lang.String;	 Catch:{ JSONException -> 0x002c }
        if (r0 == 0) goto L_0x0012;	 Catch:{ JSONException -> 0x002c }
    L_0x000a:
        r0 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x002c }
        r4 = (java.lang.String) r4;	 Catch:{ JSONException -> 0x002c }
        r0.<init>(r4);	 Catch:{ JSONException -> 0x002c }
        goto L_0x0015;	 Catch:{ JSONException -> 0x002c }
    L_0x0012:
        r0 = r4;	 Catch:{ JSONException -> 0x002c }
        r0 = (org.json.JSONArray) r0;	 Catch:{ JSONException -> 0x002c }
    L_0x0015:
        r4 = r0.length();	 Catch:{ JSONException -> 0x002c }
        r4 = new long[r4];	 Catch:{ JSONException -> 0x002c }
        r1 = 0;	 Catch:{ JSONException -> 0x002c }
    L_0x001c:
        r2 = r0.length();	 Catch:{ JSONException -> 0x002c }
        if (r1 >= r2) goto L_0x002b;	 Catch:{ JSONException -> 0x002c }
    L_0x0022:
        r2 = r0.optLong(r1);	 Catch:{ JSONException -> 0x002c }
        r4[r1] = r2;	 Catch:{ JSONException -> 0x002c }
        r1 = r1 + 1;
        goto L_0x001c;
    L_0x002b:
        return r4;
    L_0x002c:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.al.a(org.json.JSONObject):long[]");
    }

    /* renamed from: a */
    static String m23088a(String str, String str2) {
        str2 = MessageDigest.getInstance(str2);
        str2.update(str.getBytes(Utf8Charset.NAME));
        str = str2.digest();
        str2 = new StringBuilder();
        for (byte b : str) {
            String toHexString = Integer.toHexString(b & JfifUtil.MARKER_FIRST_BYTE);
            while (toHexString.length() < 2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                stringBuilder.append(toHexString);
                toHexString = stringBuilder.toString();
            }
            str2.append(toHexString);
        }
        return str2.toString();
    }

    /* renamed from: a */
    static void m23089a(int i) {
        try {
            Thread.sleep((long) i);
        } catch (int i2) {
            i2.printStackTrace();
        }
    }
}
