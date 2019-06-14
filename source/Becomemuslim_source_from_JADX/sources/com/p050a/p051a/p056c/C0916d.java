package com.p050a.p051a.p056c;

import com.p050a.p051a.p056c.p058b.C3379n;
import java.util.List;

/* compiled from: FontCharacter */
/* renamed from: com.a.a.c.d */
public class C0916d {
    /* renamed from: a */
    private final List<C3379n> f2605a;
    /* renamed from: b */
    private final char f2606b;
    /* renamed from: c */
    private final double f2607c;
    /* renamed from: d */
    private final double f2608d;
    /* renamed from: e */
    private final String f2609e;
    /* renamed from: f */
    private final String f2610f;

    /* renamed from: a */
    public static int m3214a(char c, String str, String str2) {
        return ((((0 + c) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public C0916d(List<C3379n> list, char c, double d, double d2, String str, String str2) {
        this.f2605a = list;
        this.f2606b = c;
        this.f2607c = d;
        this.f2608d = d2;
        this.f2609e = str;
        this.f2610f = str2;
    }

    /* renamed from: a */
    public List<C3379n> m3215a() {
        return this.f2605a;
    }

    /* renamed from: b */
    public double m3216b() {
        return this.f2608d;
    }

    public int hashCode() {
        return C0916d.m3214a(this.f2606b, this.f2610f, this.f2609e);
    }
}
