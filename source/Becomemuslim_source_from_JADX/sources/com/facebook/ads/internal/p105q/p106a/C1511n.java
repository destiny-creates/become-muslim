package com.facebook.ads.internal.p105q.p106a;

import java.util.UUID;

/* renamed from: com.facebook.ads.internal.q.a.n */
public class C1511n {
    /* renamed from: a */
    private static final String f4469a = "n";
    /* renamed from: b */
    private static volatile boolean f4470b = false;
    /* renamed from: c */
    private static double f4471c;
    /* renamed from: d */
    private static String f4472d;

    /* renamed from: a */
    public static void m5312a() {
        if (!f4470b) {
            synchronized (f4469a) {
                if (!f4470b) {
                    f4470b = true;
                    f4471c = ((double) System.currentTimeMillis()) / 1000.0d;
                    f4472d = UUID.randomUUID().toString();
                }
            }
        }
    }

    /* renamed from: b */
    public static double m5313b() {
        return f4471c;
    }

    /* renamed from: c */
    public static String m5314c() {
        return f4472d;
    }
}
