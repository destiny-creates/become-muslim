package com.p079e.p080a;

/* compiled from: MemoryPolicy */
/* renamed from: com.e.a.p */
public enum C1225p {
    NO_CACHE(1),
    NO_STORE(2);
    
    /* renamed from: c */
    final int f3465c;

    /* renamed from: a */
    static boolean m4295a(int i) {
        return (i & NO_CACHE.f3465c) == 0;
    }

    /* renamed from: b */
    static boolean m4296b(int i) {
        return (i & NO_STORE.f3465c) == 0;
    }

    private C1225p(int i) {
        this.f3465c = i;
    }
}
