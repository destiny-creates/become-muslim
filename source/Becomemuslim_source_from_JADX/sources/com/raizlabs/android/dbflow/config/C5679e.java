package com.raizlabs.android.dbflow.config;

import android.os.Build.VERSION;
import android.util.Log;

/* compiled from: FlowLog */
/* renamed from: com.raizlabs.android.dbflow.config.e */
public class C5679e {
    /* renamed from: a */
    public static final String f18978a = "e";
    /* renamed from: b */
    private static C5678a f18979b = C5678a.E;

    /* compiled from: FlowLog */
    /* renamed from: com.raizlabs.android.dbflow.config.e$a */
    public enum C5678a {
        V {
            /* renamed from: a */
            void mo5057a(String str, String str2, Throwable th) {
                Log.v(str, str2, th);
            }
        },
        D {
            /* renamed from: a */
            void mo5057a(String str, String str2, Throwable th) {
                Log.d(str, str2, th);
            }
        },
        I {
            /* renamed from: a */
            void mo5057a(String str, String str2, Throwable th) {
                Log.i(str, str2, th);
            }
        },
        W {
            /* renamed from: a */
            void mo5057a(String str, String str2, Throwable th) {
                Log.w(str, str2, th);
            }
        },
        E {
            /* renamed from: a */
            void mo5057a(String str, String str2, Throwable th) {
                Log.e(str, str2, th);
            }
        },
        WTF {
            /* renamed from: a */
            void mo5057a(String str, String str2, Throwable th) {
                if (VERSION.SDK_INT >= 8) {
                    Log.wtf(str, str2, th);
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("!!!!!!!!*******");
                stringBuilder.append(str2);
                stringBuilder.append("********!!!!!!");
                Log.e(str, stringBuilder.toString(), th);
            }
        };

        /* renamed from: a */
        abstract void mo5057a(String str, String str2, Throwable th);
    }

    /* renamed from: a */
    public static void m24075a(C5678a c5678a, String str) {
        C5679e.m24077a(c5678a, str, null);
    }

    /* renamed from: a */
    public static void m24077a(C5678a c5678a, String str, Throwable th) {
        C5679e.m24076a(c5678a, f18978a, str, th);
    }

    /* renamed from: a */
    public static void m24076a(C5678a c5678a, String str, String str2, Throwable th) {
        if (C5679e.m24080a(c5678a)) {
            c5678a.mo5057a(str, str2, th);
        }
    }

    /* renamed from: a */
    public static boolean m24080a(C5678a c5678a) {
        return c5678a.ordinal() >= f18979b.ordinal() ? true : null;
    }

    /* renamed from: a */
    public static void m24079a(Throwable th) {
        C5679e.m24078a(C5678a.E, th);
    }

    /* renamed from: a */
    public static void m24078a(C5678a c5678a, Throwable th) {
        C5679e.m24076a(c5678a, f18978a, "", th);
    }
}
