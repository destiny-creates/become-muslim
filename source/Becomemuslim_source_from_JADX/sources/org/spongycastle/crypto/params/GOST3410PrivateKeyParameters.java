package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class GOST3410PrivateKeyParameters extends GOST3410KeyParameters {
    /* renamed from: b */
    private BigInteger f32638b;

    public GOST3410PrivateKeyParameters(BigInteger bigInteger, GOST3410Parameters gOST3410Parameters) {
        super(true, gOST3410Parameters);
        this.f32638b = bigInteger;
    }

    /* renamed from: c */
    public BigInteger m43373c() {
        return this.f32638b;
    }
}
