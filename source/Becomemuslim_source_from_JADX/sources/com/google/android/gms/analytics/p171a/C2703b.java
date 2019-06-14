package com.google.android.gms.analytics.p171a;

import com.google.android.gms.analytics.C2716q;
import com.google.android.gms.common.internal.C2872v;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.analytics.a.b */
public class C2703b {
    /* renamed from: a */
    private Map<String, String> f6952a = new HashMap();

    /* renamed from: a */
    private final void m7689a(String str, String str2) {
        C2872v.m8381a((Object) str, (Object) "Name should be non-null");
        this.f6952a.put(str, str2);
    }

    public C2703b(String str) {
        m7689a("&pa", str);
    }

    /* renamed from: a */
    public C2703b m7692a(String str) {
        m7689a("&ti", str);
        return this;
    }

    /* renamed from: b */
    public C2703b m7695b(String str) {
        m7689a("&ta", str);
        return this;
    }

    /* renamed from: a */
    public C2703b m7690a(double d) {
        m7689a("&tr", Double.toString(d));
        return this;
    }

    /* renamed from: b */
    public C2703b m7694b(double d) {
        m7689a("&tt", Double.toString(d));
        return this;
    }

    /* renamed from: c */
    public C2703b m7696c(double d) {
        m7689a("&ts", Double.toString(d));
        return this;
    }

    /* renamed from: c */
    public C2703b m7697c(String str) {
        m7689a("&tcc", str);
        return this;
    }

    /* renamed from: a */
    public C2703b m7691a(int i) {
        m7689a("&cos", Integer.toString(i));
        return this;
    }

    /* renamed from: d */
    public C2703b m7698d(String str) {
        m7689a("&col", str);
        return this;
    }

    /* renamed from: e */
    public C2703b m7699e(String str) {
        m7689a("&pal", str);
        return this;
    }

    /* renamed from: f */
    public C2703b m7700f(String str) {
        m7689a("&pls", str);
        return this;
    }

    /* renamed from: a */
    public final Map<String, String> m7693a() {
        return new HashMap(this.f6952a);
    }

    public String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.f6952a.entrySet()) {
            if (((String) entry.getKey()).startsWith("&")) {
                hashMap.put(((String) entry.getKey()).substring(1), (String) entry.getValue());
            } else {
                hashMap.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return C2716q.m7759a(hashMap);
    }
}
