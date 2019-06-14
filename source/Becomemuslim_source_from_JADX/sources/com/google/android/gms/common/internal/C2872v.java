package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.util.C2913x;

/* renamed from: com.google.android.gms.common.internal.v */
public final class C2872v {
    /* renamed from: a */
    public static <T> T m8380a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null reference");
    }

    /* renamed from: a */
    public static String m8382a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    /* renamed from: a */
    public static String m8383a(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    /* renamed from: a */
    public static <T> T m8381a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* renamed from: a */
    public static int m8379a(int i) {
        if (i != 0) {
            return i;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    /* renamed from: a */
    public static void m8386a(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    public static void m8387a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* renamed from: a */
    public static void m8388a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    /* renamed from: b */
    public static void m8391b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* renamed from: b */
    public static void m8392b(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    /* renamed from: b */
    public static void m8390b(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: b */
    public static void m8389b(String str) {
        if (!C2913x.m8493a()) {
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: a */
    public static void m8384a() {
        C2872v.m8393c("Must not be called on the main application thread");
    }

    /* renamed from: c */
    public static void m8393c(String str) {
        if (C2913x.m8493a()) {
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: a */
    public static void m8385a(Handler handler) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException("Must be called on the handler thread");
        }
    }
}
