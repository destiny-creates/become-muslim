package com.facebook.ads.internal.p088c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.ads.internal.p088c.C1354a.C1353c;
import com.facebook.ads.internal.p088c.C1357c.C1356a;
import com.facebook.ads.internal.p095j.C1397a;
import com.facebook.ads.internal.p095j.C1398b;
import com.facebook.ads.internal.p105q.p106a.C1494b;

/* renamed from: com.facebook.ads.internal.c.b */
public class C1355b {
    /* renamed from: a */
    public static String f3938a = "";
    /* renamed from: b */
    public static String f3939b = "";
    /* renamed from: c */
    public static boolean f3940c = false;
    /* renamed from: d */
    public static String f3941d = "";

    /* renamed from: a */
    public static void m4643a(Context context) {
        try {
            C1356a a;
            C1354a a2;
            SharedPreferences sharedPreferences = context.getSharedPreferences("SDKIDFA", 0);
            if (sharedPreferences.contains("attributionId")) {
                f3938a = sharedPreferences.getString("attributionId", "");
            }
            if (sharedPreferences.contains("advertisingId")) {
                f3939b = sharedPreferences.getString("advertisingId", "");
                f3940c = sharedPreferences.getBoolean("limitAdTracking", f3940c);
                f3941d = C1353c.SHARED_PREFS.name();
            }
            try {
                a = C1357c.m4644a(context.getContentResolver());
            } catch (Throwable e) {
                C1398b.m4797a(C1397a.m4794a(e, "Error retrieving attribution id from fb4a"));
                a = null;
            }
            if (!(a == null || a.f3942a == null)) {
                f3938a = a.f3942a;
            }
            if (C1494b.m5265a() && C1494b.m5266b("aid_override")) {
                f3938a = C1494b.m5264a("aid_override");
            }
            try {
                a2 = C1354a.m4637a(context, a);
            } catch (Throwable e2) {
                C1398b.m4797a(C1397a.m4794a(e2, "Error retrieving advertising id from Google Play Services"));
                a2 = null;
            }
            if (a2 != null) {
                String a3 = a2.m4640a();
                Boolean valueOf = Boolean.valueOf(a2.m4641b());
                if (a3 != null) {
                    f3939b = a3;
                    f3940c = valueOf.booleanValue();
                    f3941d = a2.m4642c().name();
                }
            }
            Editor edit = sharedPreferences.edit();
            edit.putString("attributionId", f3938a);
            edit.putString("advertisingId", f3939b);
            edit.putBoolean("limitAdTracking", f3940c);
            edit.apply();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
