package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C2709e.C4303b;
import com.google.android.gms.internal.p210i.bk;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.analytics.c */
public class C2707c implements UncaughtExceptionHandler {
    /* renamed from: a */
    private final UncaughtExceptionHandler f6955a;
    /* renamed from: b */
    private final C4748h f6956b;
    /* renamed from: c */
    private final Context f6957c;
    /* renamed from: d */
    private C2706b f6958d;
    /* renamed from: e */
    private C4746d f6959e;

    public C2707c(C4748h c4748h, UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        if (c4748h == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (context != null) {
            this.f6955a = uncaughtExceptionHandler;
            this.f6956b = c4748h;
            this.f6958d = new C4307g(context, new ArrayList());
            this.f6957c = context.getApplicationContext();
            c4748h = "ExceptionReporter created, original handler is ";
            if (uncaughtExceptionHandler == null) {
                uncaughtExceptionHandler = "null";
            } else {
                uncaughtExceptionHandler = uncaughtExceptionHandler.getClass().getName();
            }
            uncaughtExceptionHandler = String.valueOf(uncaughtExceptionHandler);
            bk.a(uncaughtExceptionHandler.length() != null ? c4748h.concat(uncaughtExceptionHandler) : new String(c4748h));
        } else {
            throw new NullPointerException("context cannot be null");
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str = "UncaughtException";
        if (this.f6958d != null) {
            str = this.f6958d.mo2354a(thread != null ? thread.getName() : null, th);
        }
        String str2 = "Reporting uncaught exception: ";
        String valueOf = String.valueOf(str);
        bk.a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.f6956b.m16640a(new C4303b().m13971a(str).m13972a(true).m7721b());
        if (this.f6959e == null) {
            this.f6959e = C4746d.m16610a(this.f6957c);
        }
        C4308i c4308i = this.f6959e;
        c4308i.m16621f();
        c4308i.m13988g().h().e();
        if (this.f6955a != null) {
            bk.a("Passing exception to the original handler");
            this.f6955a.uncaughtException(thread, th);
        }
    }

    /* renamed from: a */
    final UncaughtExceptionHandler m7710a() {
        return this.f6955a;
    }
}
