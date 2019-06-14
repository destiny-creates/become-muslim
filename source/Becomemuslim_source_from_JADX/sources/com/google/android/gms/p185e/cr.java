package com.google.android.gms.p185e;

/* renamed from: com.google.android.gms.e.cr */
class cr {
    /* renamed from: a */
    private static cr f7504a;
    /* renamed from: b */
    private volatile C2935a f7505b = C2935a.NONE;
    /* renamed from: c */
    private volatile String f7506c = null;
    /* renamed from: d */
    private volatile String f7507d = null;
    /* renamed from: e */
    private volatile String f7508e = null;

    /* renamed from: com.google.android.gms.e.cr$a */
    enum C2935a {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    cr() {
    }

    /* renamed from: a */
    static cr m8622a() {
        cr crVar;
        synchronized (cr.class) {
            if (f7504a == null) {
                f7504a = new cr();
            }
            crVar = f7504a;
        }
        return crVar;
    }

    /* renamed from: b */
    final C2935a m8623b() {
        return this.f7505b;
    }

    /* renamed from: c */
    final String m8624c() {
        return this.f7507d;
    }

    /* renamed from: d */
    final String m8625d() {
        return this.f7506c;
    }
}
