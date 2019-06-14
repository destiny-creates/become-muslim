package com.google.android.gms.analytics.p171a;

import com.google.android.gms.analytics.C2712l;
import com.google.android.gms.analytics.C2716q;
import com.google.android.gms.common.internal.C2872v;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.analytics.a.a */
public class C2702a {
    /* renamed from: a */
    private Map<String, String> f6951a = new HashMap();

    /* renamed from: a */
    private final void m7676a(String str, String str2) {
        C2872v.m8381a((Object) str, (Object) "Name should be non-null");
        this.f6951a.put(str, str2);
    }

    /* renamed from: a */
    public C2702a m7681a(String str) {
        m7676a("id", str);
        return this;
    }

    /* renamed from: b */
    public C2702a m7683b(String str) {
        m7676a("nm", str);
        return this;
    }

    /* renamed from: c */
    public C2702a m7684c(String str) {
        m7676a("br", str);
        return this;
    }

    /* renamed from: d */
    public C2702a m7685d(String str) {
        m7676a("ca", str);
        return this;
    }

    /* renamed from: e */
    public C2702a m7686e(String str) {
        m7676a("va", str);
        return this;
    }

    /* renamed from: a */
    public C2702a m7678a(int i) {
        m7676a("ps", Integer.toString(i));
        return this;
    }

    /* renamed from: a */
    public C2702a m7677a(double d) {
        m7676a("pr", Double.toString(d));
        return this;
    }

    /* renamed from: b */
    public C2702a m7682b(int i) {
        m7676a("qt", Integer.toString(i));
        return this;
    }

    /* renamed from: f */
    public C2702a m7687f(String str) {
        m7676a("cc", str);
        return this;
    }

    /* renamed from: a */
    public C2702a m7680a(int i, String str) {
        m7676a(C2712l.m7739l(i), str);
        return this;
    }

    /* renamed from: a */
    public C2702a m7679a(int i, int i2) {
        m7676a(C2712l.m7740m(i), Integer.toString(i2));
        return this;
    }

    /* renamed from: g */
    public final Map<String, String> m7688g(String str) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.f6951a.entrySet()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf((String) entry.getKey());
            hashMap.put(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), (String) entry.getValue());
        }
        return hashMap;
    }

    public String toString() {
        return C2716q.m7759a(this.f6951a);
    }
}
