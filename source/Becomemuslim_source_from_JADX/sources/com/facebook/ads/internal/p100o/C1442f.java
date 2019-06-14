package com.facebook.ads.internal.p100o;

import com.facebook.ads.internal.p093h.C1388c;

/* renamed from: com.facebook.ads.internal.o.f */
class C1442f {
    /* renamed from: a */
    private final C1441a f4279a;
    /* renamed from: b */
    private final C1388c f4280b;
    /* renamed from: c */
    private final String f4281c;
    /* renamed from: d */
    private final String f4282d;
    /* renamed from: e */
    private final String f4283e;

    /* renamed from: com.facebook.ads.internal.o.f$a */
    enum C1441a {
        UNKNOWN,
        ERROR,
        ADS
    }

    C1442f(C1441a c1441a) {
        this(c1441a, null, null, null, null);
    }

    C1442f(C1441a c1441a, C1388c c1388c, String str, String str2, String str3) {
        this.f4279a = c1441a;
        this.f4280b = c1388c;
        this.f4281c = str;
        this.f4282d = str2;
        this.f4283e = str3;
    }

    /* renamed from: a */
    public C1388c mo968a() {
        return this.f4280b;
    }

    /* renamed from: b */
    C1441a m5093b() {
        return this.f4279a;
    }

    /* renamed from: c */
    String m5094c() {
        return this.f4281c;
    }

    /* renamed from: d */
    String m5095d() {
        return this.f4282d;
    }

    /* renamed from: e */
    String m5096e() {
        return this.f4283e;
    }
}
