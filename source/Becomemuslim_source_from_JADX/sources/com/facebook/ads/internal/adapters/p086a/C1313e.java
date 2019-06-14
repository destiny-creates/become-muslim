package com.facebook.ads.internal.adapters.p086a;

import java.io.Serializable;

/* renamed from: com.facebook.ads.internal.adapters.a.e */
public class C1313e implements Serializable {
    private static final long serialVersionUID = -4041915335826065133L;
    /* renamed from: a */
    private final String f3806a;
    /* renamed from: b */
    private final String f3807b;

    C1313e(String str, String str2) {
        this.f3806a = C1313e.m4513a(str);
        this.f3807b = C1313e.m4513a(str2);
    }

    /* renamed from: a */
    private static String m4513a(String str) {
        return "null".equalsIgnoreCase(str) ? "" : str;
    }

    /* renamed from: a */
    public String m4514a() {
        return this.f3806a;
    }

    /* renamed from: b */
    public String m4515b() {
        return this.f3807b;
    }
}
