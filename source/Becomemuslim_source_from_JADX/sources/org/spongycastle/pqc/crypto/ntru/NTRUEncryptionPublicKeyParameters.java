package org.spongycastle.pqc.crypto.ntru;

import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;

public class NTRUEncryptionPublicKeyParameters extends NTRUEncryptionKeyParameters {
    /* renamed from: c */
    public IntegerPolynomial f32738c;

    public NTRUEncryptionPublicKeyParameters(IntegerPolynomial integerPolynomial, NTRUEncryptionParameters nTRUEncryptionParameters) {
        super(false, nTRUEncryptionParameters);
        this.f32738c = integerPolynomial;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f32738c == null ? 0 : this.f32738c.hashCode()) + 31) * 31;
        if (this.b != null) {
            i = this.b.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NTRUEncryptionPublicKeyParameters)) {
            return false;
        }
        NTRUEncryptionPublicKeyParameters nTRUEncryptionPublicKeyParameters = (NTRUEncryptionPublicKeyParameters) obj;
        if (this.f32738c == null) {
            if (nTRUEncryptionPublicKeyParameters.f32738c != null) {
                return false;
            }
        } else if (!this.f32738c.equals(nTRUEncryptionPublicKeyParameters.f32738c)) {
            return false;
        }
        if (this.b == null) {
            if (nTRUEncryptionPublicKeyParameters.b != null) {
                return false;
            }
        } else if (this.b.equals(nTRUEncryptionPublicKeyParameters.b) == null) {
            return false;
        }
        return true;
    }
}
