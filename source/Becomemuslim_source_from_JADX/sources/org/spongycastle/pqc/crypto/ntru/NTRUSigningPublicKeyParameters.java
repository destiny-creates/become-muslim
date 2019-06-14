package org.spongycastle.pqc.crypto.ntru;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;

public class NTRUSigningPublicKeyParameters extends AsymmetricKeyParameter {
    /* renamed from: b */
    public IntegerPolynomial f32176b;
    /* renamed from: c */
    private NTRUSigningParameters f32177c;

    public NTRUSigningPublicKeyParameters(IntegerPolynomial integerPolynomial, NTRUSigningParameters nTRUSigningParameters) {
        super(false);
        this.f32176b = integerPolynomial;
        this.f32177c = nTRUSigningParameters;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f32176b == null ? 0 : this.f32176b.hashCode()) + 31) * 31;
        if (this.f32177c != null) {
            i = this.f32177c.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters = (NTRUSigningPublicKeyParameters) obj;
        if (this.f32176b == null) {
            if (nTRUSigningPublicKeyParameters.f32176b != null) {
                return false;
            }
        } else if (!this.f32176b.equals(nTRUSigningPublicKeyParameters.f32176b)) {
            return false;
        }
        if (this.f32177c == null) {
            if (nTRUSigningPublicKeyParameters.f32177c != null) {
                return false;
            }
        } else if (this.f32177c.equals(nTRUSigningPublicKeyParameters.f32177c) == null) {
            return false;
        }
        return true;
    }
}
