package org.spongycastle.math.ec.endo;

import java.math.BigInteger;

public class GLVTypeBParameters {
    /* renamed from: a */
    protected final BigInteger f23153a;
    /* renamed from: b */
    protected final BigInteger f23154b;
    /* renamed from: c */
    protected final BigInteger f23155c;
    /* renamed from: d */
    protected final BigInteger f23156d;
    /* renamed from: e */
    protected final BigInteger f23157e;
    /* renamed from: f */
    protected final BigInteger f23158f;
    /* renamed from: g */
    protected final BigInteger f23159g;
    /* renamed from: h */
    protected final BigInteger f23160h;
    /* renamed from: i */
    protected final int f23161i;

    /* renamed from: a */
    private static void m28813a(BigInteger[] bigIntegerArr, String str) {
        if (bigIntegerArr == null || bigIntegerArr.length != 2 || bigIntegerArr[0] == null || bigIntegerArr[1] == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("'");
            stringBuilder.append(str);
            stringBuilder.append("' must consist of exactly 2 (non-null) values");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public GLVTypeBParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2, BigInteger bigInteger3, BigInteger bigInteger4, int i) {
        m28813a(bigIntegerArr, "v1");
        m28813a(bigIntegerArr2, "v2");
        this.f23153a = bigInteger;
        this.f23154b = bigInteger2;
        this.f23155c = bigIntegerArr[0];
        this.f23156d = bigIntegerArr[1];
        this.f23157e = bigIntegerArr2[0];
        this.f23158f = bigIntegerArr2[1];
        this.f23159g = bigInteger3;
        this.f23160h = bigInteger4;
        this.f23161i = i;
    }

    /* renamed from: a */
    public BigInteger m28814a() {
        return this.f23153a;
    }

    /* renamed from: b */
    public BigInteger m28815b() {
        return this.f23155c;
    }

    /* renamed from: c */
    public BigInteger m28816c() {
        return this.f23156d;
    }

    /* renamed from: d */
    public BigInteger m28817d() {
        return this.f23157e;
    }

    /* renamed from: e */
    public BigInteger m28818e() {
        return this.f23158f;
    }

    /* renamed from: f */
    public BigInteger m28819f() {
        return this.f23159g;
    }

    /* renamed from: g */
    public BigInteger m28820g() {
        return this.f23160h;
    }

    /* renamed from: h */
    public int m28821h() {
        return this.f23161i;
    }
}
