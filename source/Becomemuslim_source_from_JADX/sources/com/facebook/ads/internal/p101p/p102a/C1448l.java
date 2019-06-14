package com.facebook.ads.internal.p101p.p102a;

/* renamed from: com.facebook.ads.internal.p.a.l */
public abstract class C1448l {
    /* renamed from: a */
    protected String f4301a = "";
    /* renamed from: b */
    protected C1447j f4302b;
    /* renamed from: c */
    protected String f4303c;
    /* renamed from: d */
    protected byte[] f4304d;

    public C1448l(String str, C1452p c1452p) {
        if (str != null) {
            this.f4301a = str;
        }
        if (c1452p != null) {
            str = c1452p.m5141a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f4301a);
            stringBuilder.append("?");
            stringBuilder.append(str);
            this.f4301a = stringBuilder.toString();
        }
    }

    /* renamed from: a */
    public String m5128a() {
        return this.f4301a;
    }

    /* renamed from: b */
    public C1447j m5129b() {
        return this.f4302b;
    }

    /* renamed from: c */
    public String m5130c() {
        return this.f4303c;
    }

    /* renamed from: d */
    public byte[] m5131d() {
        return this.f4304d;
    }
}
