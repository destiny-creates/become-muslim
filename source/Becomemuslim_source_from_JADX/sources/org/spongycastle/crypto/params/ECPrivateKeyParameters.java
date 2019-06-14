package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class ECPrivateKeyParameters extends ECKeyParameters {
    /* renamed from: c */
    BigInteger f32634c;

    public ECPrivateKeyParameters(BigInteger bigInteger, ECDomainParameters eCDomainParameters) {
        super(true, eCDomainParameters);
        this.f32634c = bigInteger;
    }

    /* renamed from: c */
    public BigInteger m43369c() {
        return this.f32634c;
    }
}
