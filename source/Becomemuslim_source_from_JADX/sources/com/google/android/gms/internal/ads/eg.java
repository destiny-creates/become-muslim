package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class eg {
    /* renamed from: a */
    public static boolean f15334a = Log.isLoggable("Volley", 2);
    /* renamed from: b */
    private static String f15335b = "Volley";

    /* renamed from: com.google.android.gms.internal.ads.eg$a */
    static class C4925a {
        /* renamed from: a */
        public static final boolean f15331a = eg.f15334a;
        /* renamed from: b */
        private final List<fh> f15332b = new ArrayList();
        /* renamed from: c */
        private boolean f15333c = false;

        C4925a() {
        }

        /* renamed from: a */
        public final synchronized void m19386a(String str) {
            long j;
            this.f15333c = true;
            if (this.f15332b.size() == 0) {
                j = 0;
            } else {
                j = ((fh) this.f15332b.get(this.f15332b.size() - 1)).f15436c - ((fh) this.f15332b.get(0)).f15436c;
            }
            if (j > 0) {
                long j2 = ((fh) this.f15332b.get(0)).f15436c;
                eg.m19390b("(%-4d ms) %s", Long.valueOf(j), str);
                for (fh fhVar : this.f15332b) {
                    eg.m19390b("(+%-4d) [%2d] %s", Long.valueOf(fhVar.f15436c - j2), Long.valueOf(fhVar.f15435b), fhVar.f15434a);
                    j2 = fhVar.f15436c;
                }
            }
        }

        /* renamed from: a */
        public final synchronized void m19387a(String str, long j) {
            if (this.f15333c) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f15332b.add(new fh(str, j, SystemClock.elapsedRealtime()));
        }

        protected final void finalize() {
            if (!this.f15333c) {
                m19386a("Request on the loose");
                eg.m19391c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    /* renamed from: a */
    public static void m19388a(String str, Object... objArr) {
        if (f15334a) {
            Log.v(f15335b, m19392d(str, objArr));
        }
    }

    /* renamed from: a */
    public static void m19389a(Throwable th, String str, Object... objArr) {
        Log.e(f15335b, m19392d(str, objArr), th);
    }

    /* renamed from: b */
    public static void m19390b(String str, Object... objArr) {
        Log.d(f15335b, m19392d(str, objArr));
    }

    /* renamed from: c */
    public static void m19391c(String str, Object... objArr) {
        Log.e(f15335b, m19392d(str, objArr));
    }

    /* renamed from: d */
    private static String m19392d(String str, Object... objArr) {
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        String str2 = "<unknown>";
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClass().equals(eg.class)) {
                str2 = stackTrace[i].getClassName();
                str2 = str2.substring(str2.lastIndexOf(46) + 1);
                str2 = str2.substring(str2.lastIndexOf(36) + 1);
                String methodName = stackTrace[i].getMethodName();
                StringBuilder stringBuilder = new StringBuilder((String.valueOf(str2).length() + 1) + String.valueOf(methodName).length());
                stringBuilder.append(str2);
                stringBuilder.append(".");
                stringBuilder.append(methodName);
                str2 = stringBuilder.toString();
                break;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
