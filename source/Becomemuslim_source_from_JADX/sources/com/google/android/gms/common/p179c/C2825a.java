package com.google.android.gms.common.p179c;

import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.android.gms.common.c.a */
public class C2825a {
    /* renamed from: a */
    private static C2824a f7224a;

    /* renamed from: com.google.android.gms.common.c.a$a */
    public interface C2824a {
        /* renamed from: a */
        ScheduledExecutorService mo2454a();
    }

    /* renamed from: a */
    public static synchronized C2824a m8119a() {
        C2824a c2824a;
        synchronized (C2825a.class) {
            if (f7224a == null) {
                f7224a = new C4359b();
            }
            c2824a = f7224a;
        }
        return c2824a;
    }
}
