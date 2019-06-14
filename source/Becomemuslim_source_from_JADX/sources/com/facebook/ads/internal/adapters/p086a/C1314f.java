package com.facebook.ads.internal.adapters.p086a;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.internal.adapters.a.f */
public class C1314f implements Serializable {
    private static final long serialVersionUID = -2102939945352398575L;
    /* renamed from: a */
    private final byte[] f3808a;
    /* renamed from: b */
    private final String f3809b;
    /* renamed from: c */
    private final List<String> f3810c;
    /* renamed from: d */
    private String f3811d;

    C1314f(byte[] bArr, String str, List<String> list) {
        this.f3808a = bArr;
        this.f3809b = str;
        this.f3810c = list;
    }

    /* renamed from: a */
    public String m4516a() {
        return this.f3811d;
    }

    /* renamed from: a */
    void m4517a(String str) {
        this.f3811d = str;
    }

    /* renamed from: b */
    public byte[] m4518b() {
        return this.f3808a;
    }

    /* renamed from: c */
    public String m4519c() {
        return this.f3809b;
    }

    /* renamed from: d */
    public List<String> m4520d() {
        return Collections.unmodifiableList(this.f3810c);
    }
}
