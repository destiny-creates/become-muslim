package org.spongycastle.pqc.math.ntru.polynomial;

import java.security.SecureRandom;

public class ProductFormPolynomial implements Polynomial {
    /* renamed from: a */
    private SparseTernaryPolynomial f27881a;
    /* renamed from: b */
    private SparseTernaryPolynomial f27882b;
    /* renamed from: c */
    private SparseTernaryPolynomial f27883c;

    public ProductFormPolynomial(SparseTernaryPolynomial sparseTernaryPolynomial, SparseTernaryPolynomial sparseTernaryPolynomial2, SparseTernaryPolynomial sparseTernaryPolynomial3) {
        this.f27881a = sparseTernaryPolynomial;
        this.f27882b = sparseTernaryPolynomial2;
        this.f27883c = sparseTernaryPolynomial3;
    }

    /* renamed from: a */
    public static ProductFormPolynomial m36579a(int i, int i2, int i3, int i4, int i5, SecureRandom secureRandom) {
        return new ProductFormPolynomial(SparseTernaryPolynomial.m42140a(i, i2, i2, secureRandom), SparseTernaryPolynomial.m42140a(i, i3, i3, secureRandom), SparseTernaryPolynomial.m42140a(i, i4, i5, secureRandom));
    }

    /* renamed from: a */
    public IntegerPolynomial mo5933a(IntegerPolynomial integerPolynomial) {
        IntegerPolynomial a = this.f27882b.mo5933a(this.f27881a.mo5933a(integerPolynomial));
        a.m36552b(this.f27883c.mo5933a(integerPolynomial));
        return a;
    }

    /* renamed from: a */
    public BigIntPolynomial mo5932a(BigIntPolynomial bigIntPolynomial) {
        BigIntPolynomial a = this.f27882b.mo5932a(this.f27881a.mo5932a(bigIntPolynomial));
        a.m29313b(this.f27883c.mo5932a(bigIntPolynomial));
        return a;
    }

    /* renamed from: m */
    public IntegerPolynomial mo5935m() {
        IntegerPolynomial a = this.f27881a.mo5933a(this.f27882b.mo5935m());
        a.m36552b(this.f27883c.mo5935m());
        return a;
    }

    /* renamed from: a */
    public IntegerPolynomial mo5934a(IntegerPolynomial integerPolynomial, int i) {
        integerPolynomial = mo5933a(integerPolynomial);
        integerPolynomial.m36568i(i);
        return integerPolynomial;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.f27881a == null ? 0 : this.f27881a.hashCode()) + 31) * 31) + (this.f27882b == null ? 0 : this.f27882b.hashCode())) * 31;
        if (this.f27883c != null) {
            i = this.f27883c.hashCode();
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
        ProductFormPolynomial productFormPolynomial = (ProductFormPolynomial) obj;
        if (this.f27881a == null) {
            if (productFormPolynomial.f27881a != null) {
                return false;
            }
        } else if (!this.f27881a.equals(productFormPolynomial.f27881a)) {
            return false;
        }
        if (this.f27882b == null) {
            if (productFormPolynomial.f27882b != null) {
                return false;
            }
        } else if (!this.f27882b.equals(productFormPolynomial.f27882b)) {
            return false;
        }
        if (this.f27883c == null) {
            if (productFormPolynomial.f27883c != null) {
                return false;
            }
        } else if (this.f27883c.equals(productFormPolynomial.f27883c) == null) {
            return false;
        }
        return true;
    }
}
