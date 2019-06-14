package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class ElGamalPublicKeyParameters extends ElGamalKeyParameters {
    /* renamed from: b */
    private BigInteger f32637b;

    public ElGamalPublicKeyParameters(BigInteger bigInteger, ElGamalParameters elGamalParameters) {
        super(false, elGamalParameters);
        this.f32637b = bigInteger;
    }

    /* renamed from: c */
    public BigInteger m43372c() {
        return this.f32637b;
    }

    public int hashCode() {
        return this.f32637b.hashCode() ^ super.hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof ElGamalPublicKeyParameters)) {
            return false;
        }
        if (((ElGamalPublicKeyParameters) obj).m43372c().equals(this.f32637b) && super.equals(obj) != null) {
            z = true;
        }
        return z;
    }
}
