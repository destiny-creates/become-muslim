package com.facebook.ads.internal.p100o;

import com.facebook.ads.internal.protocol.C1484c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.facebook.ads.internal.o.a */
public class C1433a {
    /* renamed from: a */
    private static Map<String, Long> f4243a = new ConcurrentHashMap();
    /* renamed from: b */
    private static Map<String, Long> f4244b = new ConcurrentHashMap();
    /* renamed from: c */
    private static Map<String, String> f4245c = new ConcurrentHashMap();

    /* renamed from: a */
    private static long m5051a(String str, C1484c c1484c) {
        if (f4243a.containsKey(str)) {
            return ((Long) f4243a.get(str)).longValue();
        }
        switch (c1484c) {
            case BANNER:
                return 15000;
            default:
                return -1000;
        }
    }

    /* renamed from: a */
    public static void m5052a(long j, C1434b c1434b) {
        f4243a.put(C1433a.m5057d(c1434b), Long.valueOf(j));
    }

    /* renamed from: a */
    public static void m5053a(String str, C1434b c1434b) {
        f4245c.put(C1433a.m5057d(c1434b), str);
    }

    /* renamed from: a */
    public static boolean m5054a(C1434b c1434b) {
        String d = C1433a.m5057d(c1434b);
        boolean z = false;
        if (!f4244b.containsKey(d)) {
            return false;
        }
        long longValue = ((Long) f4244b.get(d)).longValue();
        if (System.currentTimeMillis() - longValue < C1433a.m5051a(d, c1434b.m5060b())) {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    public static void m5055b(C1434b c1434b) {
        f4244b.put(C1433a.m5057d(c1434b), Long.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: c */
    public static String m5056c(C1434b c1434b) {
        return (String) f4245c.get(C1433a.m5057d(c1434b));
    }

    /* renamed from: d */
    private static String m5057d(C1434b c1434b) {
        String str = "%s:%s:%s:%d:%d:%d";
        Object[] objArr = new Object[6];
        int i = 0;
        objArr[0] = c1434b.m5059a();
        objArr[1] = c1434b.m5060b();
        objArr[2] = c1434b.f4248c;
        objArr[3] = Integer.valueOf(c1434b.m5061c() == null ? 0 : c1434b.m5061c().m5309a());
        if (c1434b.m5061c() != null) {
            i = c1434b.m5061c().m5310b();
        }
        objArr[4] = Integer.valueOf(i);
        objArr[5] = Integer.valueOf(c1434b.m5062d());
        return String.format(str, objArr);
    }
}
