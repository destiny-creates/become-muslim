package net.openid.appauth;

import android.text.TextUtils;

/* compiled from: Preconditions */
/* renamed from: net.openid.appauth.p */
public final class C6605p {
    /* renamed from: a */
    public static <T> T m26932a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static <T> T m26933a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* renamed from: a */
    public static String m26934a(String str, Object obj) {
        C6605p.m26933a((Object) str, obj);
        C6605p.m26935a(TextUtils.isEmpty(str) ^ 1, obj);
        return str;
    }

    /* renamed from: b */
    public static String m26937b(String str, Object obj) {
        if (str != null) {
            C6605p.m26934a(str, obj);
        }
        return str;
    }

    /* renamed from: a */
    public static void m26935a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* renamed from: a */
    public static void m26936a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
