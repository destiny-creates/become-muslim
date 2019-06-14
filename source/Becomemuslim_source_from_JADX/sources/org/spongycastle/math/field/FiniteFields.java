package org.spongycastle.math.field;

import java.math.BigInteger;

public abstract class FiniteFields {
    /* renamed from: a */
    static final FiniteField f23162a = new PrimeField(BigInteger.valueOf(2));
    /* renamed from: b */
    static final FiniteField f23163b = new PrimeField(BigInteger.valueOf(3));

    /* renamed from: a */
    public static PolynomialExtensionField m28825a(int[] iArr) {
        if (iArr[0] == 0) {
            int i = 1;
            while (i < iArr.length) {
                if (iArr[i] > iArr[i - 1]) {
                    i++;
                } else {
                    throw new IllegalArgumentException("Polynomial exponents must be montonically increasing");
                }
            }
            return new GenericPolynomialExtensionField(f23162a, new GF2Polynomial(iArr));
        }
        throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
    }

    /* renamed from: a */
    public static FiniteField m28824a(BigInteger bigInteger) {
        int bitLength = bigInteger.bitLength();
        if (bigInteger.signum() <= 0 || bitLength < 2) {
            throw new IllegalArgumentException("'characteristic' must be >= 2");
        }
        if (bitLength < 3) {
            switch (bigInteger.intValue()) {
                case 2:
                    return f23162a;
                case 3:
                    return f23163b;
                default:
                    break;
            }
        }
        return new PrimeField(bigInteger);
    }
}
