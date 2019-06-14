package com.facebook.ads.internal.p105q.p106a;

import java.util.Locale;

/* renamed from: com.facebook.ads.internal.q.a.s */
public class C1519s {
    /* renamed from: a */
    public static String m5327a(double d) {
        return String.format(Locale.US, "%.3f", new Object[]{Double.valueOf(d)});
    }

    /* renamed from: a */
    public static String m5328a(long j) {
        return C1519s.m5327a(((double) j) / 1000.0d);
    }
}
