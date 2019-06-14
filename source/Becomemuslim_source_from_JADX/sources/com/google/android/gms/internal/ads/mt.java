package com.google.android.gms.internal.ads;

import android.util.Log;

@cm
public class mt {
    /* renamed from: a */
    private static String m19915a(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            return str;
        }
        int lineNumber = stackTrace[3].getLineNumber();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 13);
        stringBuilder.append(str);
        stringBuilder.append(" @");
        stringBuilder.append(lineNumber);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static void m19916a(String str, Throwable th) {
        if (m19917a(3)) {
            Log.d("Ads", str, th);
        }
    }

    /* renamed from: a */
    public static boolean m19917a(int i) {
        if (i < 5) {
            if (!Log.isLoggable("Ads", i)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static void m19918b(String str) {
        if (m19917a(3)) {
            Log.d("Ads", str);
        }
    }

    /* renamed from: b */
    public static void m19919b(String str, Throwable th) {
        if (m19917a(6)) {
            Log.e("Ads", str, th);
        }
    }

    /* renamed from: c */
    public static void m19920c(String str) {
        if (m19917a(6)) {
            Log.e("Ads", str);
        }
    }

    /* renamed from: c */
    public static void m19921c(String str, Throwable th) {
        if (m19917a(5)) {
            Log.w("Ads", str, th);
        }
    }

    /* renamed from: d */
    public static void m19922d(String str) {
        if (m19917a(4)) {
            Log.i("Ads", str);
        }
    }

    /* renamed from: d */
    public static void m19923d(String str, Throwable th) {
        if (m19917a(5)) {
            if (th != null) {
                m19921c(m19915a(str), th);
                return;
            }
            m19924e(m19915a(str));
        }
    }

    /* renamed from: e */
    public static void m19924e(String str) {
        if (m19917a(5)) {
            Log.w("Ads", str);
        }
    }

    /* renamed from: f */
    public static void m19925f(String str) {
        m19923d(str, null);
    }
}
