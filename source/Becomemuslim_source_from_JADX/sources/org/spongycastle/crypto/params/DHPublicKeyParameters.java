package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class DHPublicKeyParameters extends DHKeyParameters {
    /* renamed from: b */
    private BigInteger f32631b;

    public DHPublicKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(false, dHParameters);
        this.f32631b = bigInteger;
    }

    /* renamed from: c */
    public BigInteger m43366c() {
        return this.f32631b;
    }

    public int hashCode() {
        return this.f32631b.hashCode() ^ super.hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof DHPublicKeyParameters)) {
            return false;
        }
        if (((DHPublicKeyParameters) obj).m43366c().equals(this.f32631b) && super.equals(obj) != null) {
            z = true;
        }
        return z;
    }
}
