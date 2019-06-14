package com.google.android.exoplayer2.p164l;

import android.text.TextUtils;

/* compiled from: Assertions */
/* renamed from: com.google.android.exoplayer2.l.a */
public final class C2516a {
    /* renamed from: a */
    public static void m7017a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public static void m7018a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* renamed from: a */
    public static int m7014a(int i, int i2, int i3) {
        if (i >= i2 && i < i3) {
            return i;
        }
        throw new IndexOutOfBoundsException();
    }

    /* renamed from: b */
    public static void m7019b(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    /* renamed from: b */
    public static void m7020b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* renamed from: a */
    public static <T> T m7015a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public static String m7016a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }
}
