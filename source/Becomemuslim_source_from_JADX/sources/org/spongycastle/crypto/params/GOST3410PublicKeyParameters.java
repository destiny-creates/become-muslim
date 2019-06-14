package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class GOST3410PublicKeyParameters extends GOST3410KeyParameters {
    /* renamed from: b */
    private BigInteger f32639b;

    public GOST3410PublicKeyParameters(BigInteger bigInteger, GOST3410Parameters gOST3410Parameters) {
        super(false, gOST3410Parameters);
        this.f32639b = bigInteger;
    }

    /* renamed from: c */
    public BigInteger m43374c() {
        return this.f32639b;
    }
}
