package com.facebook.ads.internal.p105q.p106a;

import java.util.Random;

/* renamed from: com.facebook.ads.internal.q.a.o */
public class C1512o {
    /* renamed from: a */
    private static String m5315a() {
        return C1514q.m5320a(Thread.currentThread().getStackTrace());
    }

    /* renamed from: a */
    public static String m5316a(int i) {
        return (i > 0 && new Random().nextFloat() < 1.0f / ((float) i)) ? C1512o.m5315a() : null;
    }
}
