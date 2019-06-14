package org.spongycastle.pqc.math.linearalgebra;

public abstract class GF2nField {
    /* renamed from: a */
    protected int f23374a;
    /* renamed from: b */
    protected GF2Polynomial f23375b;

    /* renamed from: c */
    protected abstract void mo5931c();

    /* renamed from: a */
    public final int m29223a() {
        return this.f23374a;
    }

    /* renamed from: b */
    public final GF2Polynomial m29224b() {
        if (this.f23375b == null) {
            mo5931c();
        }
        return new GF2Polynomial(this.f23375b);
    }

    public final boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof GF2nField) {
                GF2nField gF2nField = (GF2nField) obj;
                if (gF2nField.f23374a != this.f23374a || !this.f23375b.equals(gF2nField.f23375b)) {
                    return false;
                }
                if ((this instanceof GF2nPolynomialField) && !(gF2nField instanceof GF2nPolynomialField)) {
                    return false;
                }
                if ((this instanceof GF2nONBField) && (gF2nField instanceof GF2nONBField) == null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f23374a + this.f23375b.hashCode();
    }
}
