package org.spongycastle.pqc.crypto.ntru;

import java.util.ArrayList;
import java.util.List;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;

public class NTRUSigningPrivateKeyParameters extends AsymmetricKeyParameter {
    /* renamed from: b */
    private List<Basis> f32174b;
    /* renamed from: c */
    private NTRUSigningPublicKeyParameters f32175c;

    public static class Basis {
        /* renamed from: d */
        public Polynomial f23312d;
        /* renamed from: e */
        public Polynomial f23313e;
        /* renamed from: f */
        public IntegerPolynomial f23314f;
        /* renamed from: g */
        NTRUSigningKeyGenerationParameters f23315g;

        protected Basis(Polynomial polynomial, Polynomial polynomial2, IntegerPolynomial integerPolynomial, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) {
            this.f23312d = polynomial;
            this.f23313e = polynomial2;
            this.f23314f = integerPolynomial;
            this.f23315g = nTRUSigningKeyGenerationParameters;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.f23312d == null ? 0 : this.f23312d.hashCode()) + 31) * 31) + (this.f23313e == null ? 0 : this.f23313e.hashCode())) * 31) + (this.f23314f == null ? 0 : this.f23314f.hashCode())) * 31;
            if (this.f23315g != null) {
                i = this.f23315g.hashCode();
            }
            return hashCode + i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof Basis)) {
                return false;
            }
            Basis basis = (Basis) obj;
            if (this.f23312d == null) {
                if (basis.f23312d != null) {
                    return false;
                }
            } else if (!this.f23312d.equals(basis.f23312d)) {
                return false;
            }
            if (this.f23313e == null) {
                if (basis.f23313e != null) {
                    return false;
                }
            } else if (!this.f23313e.equals(basis.f23313e)) {
                return false;
            }
            if (this.f23314f == null) {
                if (basis.f23314f != null) {
                    return false;
                }
            } else if (!this.f23314f.equals(basis.f23314f)) {
                return false;
            }
            if (this.f23315g == null) {
                if (basis.f23315g != null) {
                    return false;
                }
            } else if (this.f23315g.equals(basis.f23315g) == null) {
                return false;
            }
            return true;
        }
    }

    public NTRUSigningPrivateKeyParameters(List<Basis> list, NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters) {
        super(true);
        this.f32174b = new ArrayList(list);
        this.f32175c = nTRUSigningPublicKeyParameters;
    }

    public int hashCode() {
        if (this.f32174b == null) {
            return 31;
        }
        int hashCode = 31 + this.f32174b.hashCode();
        for (Basis hashCode2 : this.f32174b) {
            hashCode += hashCode2.hashCode();
        }
        return hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NTRUSigningPrivateKeyParameters nTRUSigningPrivateKeyParameters = (NTRUSigningPrivateKeyParameters) obj;
        if ((this.f32174b == null ? 1 : null) != (nTRUSigningPrivateKeyParameters.f32174b == null ? 1 : null)) {
            return false;
        }
        if (this.f32174b == null) {
            return true;
        }
        if (this.f32174b.size() != nTRUSigningPrivateKeyParameters.f32174b.size()) {
            return false;
        }
        for (int i = 0; i < this.f32174b.size(); i++) {
            Basis basis = (Basis) this.f32174b.get(i);
            Basis basis2 = (Basis) nTRUSigningPrivateKeyParameters.f32174b.get(i);
            if (!basis.f23312d.equals(basis2.f23312d) || !basis.f23313e.equals(basis2.f23313e)) {
                return false;
            }
            if ((i != 0 && !basis.f23314f.equals(basis2.f23314f)) || !basis.f23315g.equals(basis2.f23315g)) {
                return false;
            }
        }
        return true;
    }
}
