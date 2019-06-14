package com.facebook.ads.internal.p093h;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.internal.h.c */
public class C1388c {
    /* renamed from: a */
    private List<C1386a> f4037a = new ArrayList();
    /* renamed from: b */
    private int f4038b = 0;
    /* renamed from: c */
    private C1389d f4039c;
    /* renamed from: d */
    private String f4040d;

    public C1388c(C1389d c1389d, String str) {
        this.f4039c = c1389d;
        this.f4040d = str;
    }

    /* renamed from: a */
    public C1389d m4759a() {
        return this.f4039c;
    }

    /* renamed from: a */
    public void m4760a(C1386a c1386a) {
        this.f4037a.add(c1386a);
    }

    /* renamed from: b */
    public String m4761b() {
        return this.f4040d;
    }

    /* renamed from: c */
    public int m4762c() {
        return this.f4037a.size();
    }

    /* renamed from: d */
    public C1386a m4763d() {
        if (this.f4038b >= this.f4037a.size()) {
            return null;
        }
        this.f4038b++;
        return (C1386a) this.f4037a.get(this.f4038b - 1);
    }

    /* renamed from: e */
    public boolean m4764e() {
        if (this.f4039c != null) {
            if (System.currentTimeMillis() <= this.f4039c.m4766a() + ((long) this.f4039c.m4777l())) {
                return false;
            }
        }
        return true;
    }
}
