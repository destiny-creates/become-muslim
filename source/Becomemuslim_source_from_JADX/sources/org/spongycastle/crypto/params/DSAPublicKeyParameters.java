package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class DSAPublicKeyParameters extends DSAKeyParameters {
    /* renamed from: b */
    private BigInteger f32633b;

    public DSAPublicKeyParameters(BigInteger bigInteger, DSAParameters dSAParameters) {
        super(false, dSAParameters);
        this.f32633b = bigInteger;
    }

    /* renamed from: c */
    public BigInteger m43368c() {
        return this.f32633b;
    }
}
