package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.KeySpec;

public class GOST3410PrivateKeySpec implements KeySpec {
    /* renamed from: a */
    private BigInteger f23055a;
    /* renamed from: b */
    private BigInteger f23056b;
    /* renamed from: c */
    private BigInteger f23057c;
    /* renamed from: d */
    private BigInteger f23058d;

    public GOST3410PrivateKeySpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f23055a = bigInteger;
        this.f23056b = bigInteger2;
        this.f23057c = bigInteger3;
        this.f23058d = bigInteger4;
    }

    /* renamed from: a */
    public BigInteger m28323a() {
        return this.f23055a;
    }

    /* renamed from: b */
    public BigInteger m28324b() {
        return this.f23056b;
    }

    /* renamed from: c */
    public BigInteger m28325c() {
        return this.f23057c;
    }

    /* renamed from: d */
    public BigInteger m28326d() {
        return this.f23058d;
    }
}
