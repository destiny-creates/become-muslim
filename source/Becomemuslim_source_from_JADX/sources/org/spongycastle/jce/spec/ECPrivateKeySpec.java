package org.spongycastle.jce.spec;

import java.math.BigInteger;

public class ECPrivateKeySpec extends ECKeySpec {
    /* renamed from: a */
    private BigInteger f27622a;

    public ECPrivateKeySpec(BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        super(eCParameterSpec);
        this.f27622a = bigInteger;
    }

    /* renamed from: b */
    public BigInteger m36251b() {
        return this.f27622a;
    }
}
