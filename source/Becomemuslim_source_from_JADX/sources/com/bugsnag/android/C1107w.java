package com.bugsnag.android;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: ExceptionHandler */
/* renamed from: com.bugsnag.android.w */
class C1107w implements UncaughtExceptionHandler {
    /* renamed from: a */
    final Map<C1089j, Boolean> f3116a = new WeakHashMap();
    /* renamed from: b */
    private final UncaughtExceptionHandler f3117b;
    /* renamed from: c */
    private final ao f3118c = new ao();

    /* renamed from: a */
    static void m3927a(C1089j c1089j) {
        C1107w c1107w;
        UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof C1107w) {
            c1107w = (C1107w) defaultUncaughtExceptionHandler;
        } else {
            UncaughtExceptionHandler c1107w2 = new C1107w(defaultUncaughtExceptionHandler);
            Thread.setDefaultUncaughtExceptionHandler(c1107w2);
            c1107w = c1107w2;
        }
        c1107w.f3116a.put(c1089j, Boolean.valueOf(true));
    }

    /* renamed from: b */
    static void m3928b(C1089j c1089j) {
        UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof C1107w) {
            C1107w c1107w = (C1107w) defaultUncaughtExceptionHandler;
            c1107w.f3116a.remove(c1089j);
            if (c1107w.f3116a.isEmpty() != null) {
                Thread.setDefaultUncaughtExceptionHandler(c1107w.f3117b);
            }
        }
    }

    C1107w(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f3117b = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        boolean a = this.f3118c.m3762a(th);
        for (C1089j c1089j : this.f3116a.keySet()) {
            String str;
            af afVar;
            af afVar2 = new af();
            if (a) {
                String a2 = this.f3118c.m3761a(th.getMessage());
                af afVar3 = new af();
                afVar3.m11033a("StrictMode", "Violation", a2);
                str = a2;
                afVar = afVar3;
            } else {
                afVar = afVar2;
                str = null;
            }
            String str2 = a ? "strictMode" : "unhandledException";
            if (a) {
                ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy(ThreadPolicy.LAX);
                c1089j.m3801a(th, Severity.ERROR, afVar, str2, str, thread);
                StrictMode.setThreadPolicy(threadPolicy);
            } else {
                c1089j.m3801a(th, Severity.ERROR, afVar, str2, str, thread);
            }
        }
        if (this.f3117b != null) {
            this.f3117b.uncaughtException(thread, th);
            return;
        }
        System.err.printf("Exception in thread \"%s\" ", new Object[]{thread.getName()});
        ad.m3733a("Exception", th);
    }
}
