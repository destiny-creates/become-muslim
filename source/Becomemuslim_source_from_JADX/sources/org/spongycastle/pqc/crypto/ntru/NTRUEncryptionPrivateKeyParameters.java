package org.spongycastle.pqc.crypto.ntru;

import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;

public class NTRUEncryptionPrivateKeyParameters extends NTRUEncryptionKeyParameters {
    /* renamed from: c */
    public Polynomial f32735c;
    /* renamed from: d */
    public IntegerPolynomial f32736d;
    /* renamed from: e */
    public IntegerPolynomial f32737e;

    public NTRUEncryptionPrivateKeyParameters(IntegerPolynomial integerPolynomial, Polynomial polynomial, IntegerPolynomial integerPolynomial2, NTRUEncryptionParameters nTRUEncryptionParameters) {
        super(true, nTRUEncryptionParameters);
        this.f32737e = integerPolynomial;
        this.f32735c = polynomial;
        this.f32736d = integerPolynomial2;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.b == null ? 0 : this.b.hashCode()) + 31) * 31) + (this.f32735c == null ? 0 : this.f32735c.hashCode())) * 31;
        if (this.f32737e != null) {
            i = this.f32737e.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NTRUEncryptionPrivateKeyParameters)) {
            return false;
        }
        NTRUEncryptionPrivateKeyParameters nTRUEncryptionPrivateKeyParameters = (NTRUEncryptionPrivateKeyParameters) obj;
        if (this.b == null) {
            if (nTRUEncryptionPrivateKeyParameters.b != null) {
                return false;
            }
        } else if (!this.b.equals(nTRUEncryptionPrivateKeyParameters.b)) {
            return false;
        }
        if (this.f32735c == null) {
            if (nTRUEncryptionPrivateKeyParameters.f32735c != null) {
                return false;
            }
        } else if (!this.f32735c.equals(nTRUEncryptionPrivateKeyParameters.f32735c)) {
            return false;
        }
        return this.f32737e.equals(nTRUEncryptionPrivateKeyParameters.f32737e) != null;
    }
}
