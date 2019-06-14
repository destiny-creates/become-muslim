package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class SRP6GroupParameters {
    /* renamed from: a */
    private BigInteger f22426a;
    /* renamed from: b */
    private BigInteger f22427b;

    public SRP6GroupParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f22426a = bigInteger;
        this.f22427b = bigInteger2;
    }

    /* renamed from: a */
    public BigInteger m27500a() {
        return this.f22427b;
    }

    /* renamed from: b */
    public BigInteger m27501b() {
        return this.f22426a;
    }
}
