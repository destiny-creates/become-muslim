package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class GOST3410PublicKeySpec implements KeySpec {
    /* renamed from: a */
    private BigInteger f23062a;
    /* renamed from: b */
    private BigInteger f23063b;
    /* renamed from: c */
    private BigInteger f23064c;
    /* renamed from: d */
    private BigInteger f23065d;

    public GOST3410PublicKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f23062a = bigInteger;
        this.f23063b = bigInteger2;
        this.f23064c = bigInteger3;
        this.f23065d = bigInteger4;
    }

    /* renamed from: a */
    public BigInteger m28330a() {
        return this.f23062a;
    }

    /* renamed from: b */
    public BigInteger m28331b() {
        return this.f23063b;
    }

    /* renamed from: c */
    public BigInteger m28332c() {
        return this.f23064c;
    }

    /* renamed from: d */
    public BigInteger m28333d() {
        return this.f23065d;
    }
}
