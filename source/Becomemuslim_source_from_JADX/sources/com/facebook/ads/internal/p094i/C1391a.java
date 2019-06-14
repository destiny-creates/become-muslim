package com.facebook.ads.internal.p094i;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.internal.p091f.C1378c;
import com.facebook.ads.internal.p097l.C1405a;

/* renamed from: com.facebook.ads.internal.i.a */
public class C1391a {
    /* renamed from: a */
    private static final String f4062a = "com.facebook.ads.internal.i.a";
    /* renamed from: b */
    private static C1391a f4063b = null;
    /* renamed from: c */
    private static boolean f4064c = false;
    /* renamed from: d */
    private Context f4065d;

    private C1391a(Context context) {
        this.f4065d = context;
    }

    /* renamed from: a */
    public static C1391a m4778a(Context context) {
        if (f4063b == null) {
            context = context.getApplicationContext();
            synchronized (context) {
                if (f4063b == null) {
                    f4063b = new C1391a(context);
                }
            }
        }
        return f4063b;
    }

    /* renamed from: a */
    public synchronized void m4779a() {
        if (!f4064c) {
            if (C1405a.m4827h(this.f4065d)) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(new C1378c(Thread.getDefaultUncaughtExceptionHandler(), this.f4065d, new C1394c(this.f4065d, false).m4791b()));
                } catch (Throwable e) {
                    Log.e(f4062a, "No permissions to set the default uncaught exception handler", e);
                }
            }
            f4064c = true;
        }
    }
}
