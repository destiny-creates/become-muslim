package org.spongycastle.math.field;

import java.math.BigInteger;

class PrimeField implements FiniteField {
    /* renamed from: a */
    protected final BigInteger f27647a;

    /* renamed from: b */
    public int mo5912b() {
        return 1;
    }

    PrimeField(BigInteger bigInteger) {
        this.f27647a = bigInteger;
    }

    /* renamed from: a */
    public BigInteger mo5911a() {
        return this.f27647a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrimeField)) {
            return null;
        }
        return this.f27647a.equals(((PrimeField) obj).f27647a);
    }

    public int hashCode() {
        return this.f27647a.hashCode();
    }
}
