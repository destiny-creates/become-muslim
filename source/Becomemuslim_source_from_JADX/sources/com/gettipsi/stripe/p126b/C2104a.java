package com.gettipsi.stripe.p126b;

import android.text.TextUtils;

/* compiled from: ArgCheck */
/* renamed from: com.gettipsi.stripe.b.a */
public abstract class C2104a {
    /* renamed from: a */
    public static <T> T m5776a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static String m5777a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: b */
    public static String m5779b(String str) {
        String a = C2104a.m5777a(str);
        Double.parseDouble(str);
        return a;
    }

    /* renamed from: a */
    public static void m5778a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
