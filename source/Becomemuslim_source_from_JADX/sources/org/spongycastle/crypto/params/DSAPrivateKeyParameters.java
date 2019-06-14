package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class DSAPrivateKeyParameters extends DSAKeyParameters {
    /* renamed from: b */
    private BigInteger f32632b;

    public DSAPrivateKeyParameters(BigInteger bigInteger, DSAParameters dSAParameters) {
        super(true, dSAParameters);
        this.f32632b = bigInteger;
    }

    /* renamed from: c */
    public BigInteger m43367c() {
        return this.f32632b;
    }
}
