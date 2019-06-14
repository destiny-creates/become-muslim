package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class ElGamalParameterSpec implements AlgorithmParameterSpec {
    /* renamed from: a */
    private BigInteger f23053a;
    /* renamed from: b */
    private BigInteger f23054b;

    public ElGamalParameterSpec(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f23053a = bigInteger;
        this.f23054b = bigInteger2;
    }

    /* renamed from: a */
    public BigInteger m28321a() {
        return this.f23053a;
    }

    /* renamed from: b */
    public BigInteger m28322b() {
        return this.f23054b;
    }
}
