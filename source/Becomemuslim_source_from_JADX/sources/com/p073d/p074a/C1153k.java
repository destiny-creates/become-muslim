package com.p073d.p074a;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Options */
/* renamed from: com.d.a.k */
public class C1153k {
    /* renamed from: a */
    private final Map<String, Object> f3258a = new ConcurrentHashMap();

    /* renamed from: a */
    public C1153k m4083a(String str, boolean z) {
        if ("Segment.io".equals(str)) {
            throw new IllegalArgumentException("Segment integration cannot be enabled or disabled.");
        }
        this.f3258a.put(str, Boolean.valueOf(z));
        return this;
    }

    /* renamed from: a */
    public C1153k m4082a(String str, Map<String, Object> map) {
        this.f3258a.put(str, map);
        return this;
    }

    /* renamed from: a */
    public Map<String, Object> m4084a() {
        return new LinkedHashMap(this.f3258a);
    }
}
