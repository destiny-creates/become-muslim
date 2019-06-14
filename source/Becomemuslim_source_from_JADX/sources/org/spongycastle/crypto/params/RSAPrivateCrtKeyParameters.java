package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class RSAPrivateCrtKeyParameters extends RSAKeyParameters {
    /* renamed from: b */
    private BigInteger f32642b;
    /* renamed from: c */
    private BigInteger f32643c;
    /* renamed from: d */
    private BigInteger f32644d;
    /* renamed from: e */
    private BigInteger f32645e;
    /* renamed from: f */
    private BigInteger f32646f;
    /* renamed from: g */
    private BigInteger f32647g;

    public RSAPrivateCrtKeyParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        super(true, bigInteger, bigInteger3);
        this.f32642b = bigInteger2;
        this.f32643c = bigInteger4;
        this.f32644d = bigInteger5;
        this.f32645e = bigInteger6;
        this.f32646f = bigInteger7;
        this.f32647g = bigInteger8;
    }

    /* renamed from: d */
    public BigInteger m43377d() {
        return this.f32642b;
    }

    /* renamed from: e */
    public BigInteger m43378e() {
        return this.f32643c;
    }

    /* renamed from: f */
    public BigInteger m43379f() {
        return this.f32644d;
    }

    /* renamed from: g */
    public BigInteger m43380g() {
        return this.f32645e;
    }

    /* renamed from: h */
    public BigInteger m43381h() {
        return this.f32646f;
    }

    /* renamed from: i */
    public BigInteger m43382i() {
        return this.f32647g;
    }
}
