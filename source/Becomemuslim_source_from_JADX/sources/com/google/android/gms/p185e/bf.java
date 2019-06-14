package com.google.android.gms.p185e;

import android.content.Context;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.e.bf */
public class bf {
    /* renamed from: a */
    static Map<String, String> f7467a = new HashMap();
    /* renamed from: b */
    private static String f7468b;

    /* renamed from: a */
    public static String m8571a(Context context, String str) {
        if (f7468b == null) {
            synchronized (bf.class) {
                if (f7468b == null) {
                    context = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (context != null) {
                        f7468b = context.getString("referrer", "");
                    } else {
                        f7468b = "";
                    }
                }
            }
        }
        return bf.m8572a(f7468b, str);
    }

    /* renamed from: b */
    public static void m8573b(Context context, String str) {
        String a = bf.m8572a(str, "conv");
        if (a != null && a.length() > 0) {
            f7467a.put(a, str);
            ee.m8703a(context, "gtm_click_referrers", a, str);
        }
    }

    /* renamed from: a */
    public static String m8572a(String str, String str2) {
        if (str2 == null) {
            return str.length() > null ? str : null;
        } else {
            String str3 = "http://hostname/?";
            str = String.valueOf(str);
            return Uri.parse(str.length() != 0 ? str3.concat(str) : new String(str3)).getQueryParameter(str2);
        }
    }
}
