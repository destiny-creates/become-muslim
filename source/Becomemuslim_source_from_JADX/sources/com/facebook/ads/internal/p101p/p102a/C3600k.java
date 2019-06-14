package com.facebook.ads.internal.p101p.p102a;

/* renamed from: com.facebook.ads.internal.p.a.k */
public class C3600k extends C1448l {
    public C3600k(String str, C1452p c1452p) {
        super(str, null);
        this.b = C1447j.POST;
        this.a = str;
        this.c = "application/x-www-form-urlencoded;charset=UTF-8";
        if (c1452p != null) {
            this.d = c1452p.m5145b();
        }
    }

    public C3600k(String str, C1452p c1452p, String str2, byte[] bArr) {
        super(str, c1452p);
        this.b = C1447j.POST;
        this.c = str2;
        this.d = bArr;
    }
}
