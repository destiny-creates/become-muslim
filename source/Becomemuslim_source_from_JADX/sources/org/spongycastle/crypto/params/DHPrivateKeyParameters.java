package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class DHPrivateKeyParameters extends DHKeyParameters {
    /* renamed from: b */
    private BigInteger f32630b;

    public DHPrivateKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(true, dHParameters);
        this.f32630b = bigInteger;
    }

    /* renamed from: c */
    public BigInteger m43365c() {
        return this.f32630b;
    }

    public int hashCode() {
        return this.f32630b.hashCode() ^ super.hashCode();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof DHPrivateKeyParameters)) {
            return false;
        }
        if (((DHPrivateKeyParameters) obj).m43365c().equals(this.f32630b) && super.equals(obj) != null) {
            z = true;
        }
        return z;
    }
}
