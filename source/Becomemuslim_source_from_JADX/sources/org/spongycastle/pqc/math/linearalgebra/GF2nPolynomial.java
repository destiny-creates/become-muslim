package org.spongycastle.pqc.math.linearalgebra;

public class GF2nPolynomial {
    /* renamed from: a */
    private GF2nElement[] f23376a;
    /* renamed from: b */
    private int f23377b;

    /* renamed from: a */
    public final int m29226a() {
        for (int i = this.f23377b - 1; i >= 0; i--) {
            if (!this.f23376a[i].mo6590a()) {
                return i;
            }
        }
        return -1;
    }

    public final boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof GF2nPolynomial) {
                GF2nPolynomial gF2nPolynomial = (GF2nPolynomial) obj;
                if (m29226a() != gF2nPolynomial.m29226a()) {
                    return false;
                }
                for (int i = 0; i < this.f23377b; i++) {
                    if (!this.f23376a[i].equals(gF2nPolynomial.f23376a[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return m29226a() + this.f23376a.hashCode();
    }
}
