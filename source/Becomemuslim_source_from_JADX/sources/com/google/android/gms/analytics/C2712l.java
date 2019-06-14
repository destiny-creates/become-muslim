package com.google.android.gms.analytics;

import com.google.android.gms.internal.p210i.bk;

/* renamed from: com.google.android.gms.analytics.l */
public final class C2712l {
    /* renamed from: a */
    public static String m7727a(int i) {
        return C2712l.m7728a("&cd", i);
    }

    /* renamed from: b */
    public static String m7729b(int i) {
        return C2712l.m7728a("cd", i);
    }

    /* renamed from: c */
    public static String m7730c(int i) {
        return C2712l.m7728a("&cm", i);
    }

    /* renamed from: d */
    public static String m7731d(int i) {
        return C2712l.m7728a("cm", i);
    }

    /* renamed from: a */
    private static String m7728a(String str, int i) {
        if (i <= 0) {
            bk.a("index out of range for prefix", str);
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 11);
        stringBuilder.append(str);
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    /* renamed from: e */
    public static String m7732e(int i) {
        return C2712l.m7728a("&pr", i);
    }

    /* renamed from: f */
    public static String m7733f(int i) {
        return C2712l.m7728a("pr", i);
    }

    /* renamed from: g */
    public static String m7734g(int i) {
        return C2712l.m7728a("&promo", i);
    }

    /* renamed from: h */
    public static String m7735h(int i) {
        return C2712l.m7728a("promo", i);
    }

    /* renamed from: i */
    public static String m7736i(int i) {
        return C2712l.m7728a("pi", i);
    }

    /* renamed from: j */
    public static String m7737j(int i) {
        return C2712l.m7728a("&il", i);
    }

    /* renamed from: k */
    public static String m7738k(int i) {
        return C2712l.m7728a("il", i);
    }

    /* renamed from: l */
    public static String m7739l(int i) {
        return C2712l.m7728a("cd", i);
    }

    /* renamed from: m */
    public static String m7740m(int i) {
        return C2712l.m7728a("cm", i);
    }
}
