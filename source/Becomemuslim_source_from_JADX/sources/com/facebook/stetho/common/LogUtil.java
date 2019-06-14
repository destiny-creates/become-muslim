package com.facebook.stetho.common;

import java.util.Locale;

public class LogUtil {
    private static final String TAG = "stetho";

    /* renamed from: e */
    public static void m5743e(String str, Object... objArr) {
        m5742e(format(str, objArr));
    }

    /* renamed from: e */
    public static void m5745e(Throwable th, String str, Object... objArr) {
        m5744e(th, format(str, objArr));
    }

    /* renamed from: e */
    public static void m5742e(String str) {
        if (isLoggable(6)) {
            LogRedirector.m5730e(TAG, str);
        }
    }

    /* renamed from: e */
    public static void m5744e(Throwable th, String str) {
        if (isLoggable(6)) {
            LogRedirector.m5731e(TAG, str, th);
        }
    }

    /* renamed from: w */
    public static void m5755w(String str, Object... objArr) {
        m5754w(format(str, objArr));
    }

    /* renamed from: w */
    public static void m5757w(Throwable th, String str, Object... objArr) {
        m5756w(th, format(str, objArr));
    }

    /* renamed from: w */
    public static void m5754w(String str) {
        if (isLoggable(5)) {
            LogRedirector.m5736w(TAG, str);
        }
    }

    /* renamed from: w */
    public static void m5756w(Throwable th, String str) {
        if (isLoggable(5)) {
            LogRedirector.m5737w(TAG, str, th);
        }
    }

    /* renamed from: i */
    public static void m5747i(String str, Object... objArr) {
        m5746i(format(str, objArr));
    }

    /* renamed from: i */
    public static void m5749i(Throwable th, String str, Object... objArr) {
        m5748i(th, format(str, objArr));
    }

    /* renamed from: i */
    public static void m5746i(String str) {
        if (isLoggable(4)) {
            LogRedirector.m5732i(TAG, str);
        }
    }

    /* renamed from: i */
    public static void m5748i(Throwable th, String str) {
        if (isLoggable(4)) {
            LogRedirector.m5733i(TAG, str, th);
        }
    }

    /* renamed from: d */
    public static void m5739d(String str, Object... objArr) {
        m5738d(format(str, objArr));
    }

    /* renamed from: d */
    public static void m5741d(Throwable th, String str, Object... objArr) {
        m5740d(th, format(str, objArr));
    }

    /* renamed from: d */
    public static void m5738d(String str) {
        if (isLoggable(3)) {
            LogRedirector.m5728d(TAG, str);
        }
    }

    /* renamed from: d */
    public static void m5740d(Throwable th, String str) {
        if (isLoggable(3)) {
            LogRedirector.m5729d(TAG, str, th);
        }
    }

    /* renamed from: v */
    public static void m5751v(String str, Object... objArr) {
        m5750v(format(str, objArr));
    }

    /* renamed from: v */
    public static void m5753v(Throwable th, String str, Object... objArr) {
        m5752v(th, format(str, objArr));
    }

    /* renamed from: v */
    public static void m5750v(String str) {
        if (isLoggable(2)) {
            LogRedirector.m5734v(TAG, str);
        }
    }

    /* renamed from: v */
    public static void m5752v(Throwable th, String str) {
        if (isLoggable(2)) {
            LogRedirector.m5735v(TAG, str, th);
        }
    }

    private static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static boolean isLoggable(int i) {
        switch (i) {
            case 5:
            case 6:
                return true;
            default:
                return LogRedirector.isLoggable(TAG, i);
        }
    }
}
