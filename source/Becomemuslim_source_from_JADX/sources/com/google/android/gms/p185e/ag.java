package com.google.android.gms.p185e;

import android.content.Context;

/* renamed from: com.google.android.gms.e.ag */
public final class ag implements ax {
    /* renamed from: a */
    private static ag f11604a;
    /* renamed from: b */
    private static final Object f11605b = new Object();
    /* renamed from: c */
    private ct f11606c;
    /* renamed from: d */
    private ay f11607d;

    private ag(Context context) {
        this(az.m14443a(context), new dw());
    }

    private ag(ay ayVar, ct ctVar) {
        this.f11607d = ayVar;
        this.f11606c = ctVar;
    }

    /* renamed from: a */
    public static ax m14429a(Context context) {
        synchronized (f11605b) {
            if (f11604a == null) {
                f11604a = new ag(context);
            }
            context = f11604a;
        }
        return context;
    }

    /* renamed from: a */
    public final boolean mo2505a(String str) {
        if (this.f11606c.mo2514a()) {
            this.f11607d.mo2509a(str);
            return true;
        }
        bs.m8584b("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
        return null;
    }
}
