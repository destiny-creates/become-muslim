package com.p079e.p080a;

/* compiled from: NetworkPolicy */
/* renamed from: com.e.a.q */
public enum C1226q {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);
    
    /* renamed from: d */
    final int f3470d;

    /* renamed from: a */
    public static boolean m4297a(int i) {
        return (i & NO_CACHE.f3470d) == 0;
    }

    /* renamed from: b */
    public static boolean m4298b(int i) {
        return (i & NO_STORE.f3470d) == 0;
    }

    /* renamed from: c */
    public static boolean m4299c(int i) {
        return (i & OFFLINE.f3470d) != 0;
    }

    private C1226q(int i) {
        this.f3470d = i;
    }
}
