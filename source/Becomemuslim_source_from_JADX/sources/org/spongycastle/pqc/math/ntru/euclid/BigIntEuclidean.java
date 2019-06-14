package org.spongycastle.pqc.math.ntru.euclid;

import java.math.BigInteger;

public class BigIntEuclidean {
    /* renamed from: a */
    public BigInteger f23399a;
    /* renamed from: b */
    public BigInteger f23400b;
    /* renamed from: c */
    public BigInteger f23401c;

    private BigIntEuclidean() {
    }

    /* renamed from: a */
    public static BigIntEuclidean m29295a(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = BigInteger.ZERO;
        BigInteger bigInteger4 = BigInteger.ONE;
        BigInteger bigInteger5 = BigInteger.ONE;
        BigInteger bigInteger6 = BigInteger.ZERO;
        while (true) {
            BigInteger bigInteger7 = bigInteger2;
            bigInteger2 = bigInteger;
            bigInteger = bigInteger7;
            BigInteger bigInteger8 = bigInteger4;
            bigInteger4 = bigInteger3;
            bigInteger3 = bigInteger8;
            BigInteger bigInteger9 = bigInteger6;
            bigInteger6 = bigInteger5;
            bigInteger5 = bigInteger9;
            if (bigInteger.equals(BigInteger.ZERO)) {
                bigInteger = new BigIntEuclidean();
                bigInteger.f23399a = bigInteger3;
                bigInteger.f23400b = bigInteger5;
                bigInteger.f23401c = bigInteger2;
                return bigInteger;
            }
            bigInteger2 = bigInteger2.divideAndRemainder(bigInteger);
            BigInteger bigInteger10 = bigInteger2[0];
            bigInteger2 = bigInteger2[1];
            bigInteger3 = bigInteger3.subtract(bigInteger10.multiply(bigInteger4));
            bigInteger5 = bigInteger5.subtract(bigInteger10.multiply(bigInteger6));
        }
    }
}
