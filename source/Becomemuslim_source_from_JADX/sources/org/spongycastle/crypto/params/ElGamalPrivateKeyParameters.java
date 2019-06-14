package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class ElGamalPrivateKeyParameters extends ElGamalKeyParameters {
    /* renamed from: b */
    private BigInteger f32636b;

    public ElGamalPrivateKeyParameters(BigInteger bigInteger, ElGamalParameters elGamalParameters) {
        super(true, elGamalParameters);
        this.f32636b = bigInteger;
    }

    /* renamed from: c */
    public BigInteger m43371c() {
        return this.f32636b;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof ElGamalPrivateKeyParameters) && ((ElGamalPrivateKeyParameters) obj).m43371c().equals(this.f32636b)) {
            return super.equals(obj);
        }
        return false;
    }

    public int hashCode() {
        return m43371c().hashCode();
    }
}
