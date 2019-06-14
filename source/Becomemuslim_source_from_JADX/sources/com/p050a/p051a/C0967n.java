package com.p050a.p051a;

import java.util.Map;

/* compiled from: TextDelegate */
/* renamed from: com.a.a.n */
public class C0967n {
    /* renamed from: a */
    private final Map<String, String> f2730a;
    /* renamed from: b */
    private boolean f2731b;

    /* renamed from: b */
    private String m3409b(String str) {
        return str;
    }

    /* renamed from: a */
    public final String m3410a(String str) {
        if (this.f2731b && this.f2730a.containsKey(str)) {
            return (String) this.f2730a.get(str);
        }
        String b = m3409b(str);
        if (this.f2731b) {
            this.f2730a.put(str, b);
        }
        return b;
    }
}
