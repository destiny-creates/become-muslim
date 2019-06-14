package org.spongycastle.pqc.math.linearalgebra;

import java.math.BigInteger;

public final class BigIntUtils {
    private BigIntUtils() {
    }

    /* renamed from: a */
    public static byte[] m29181a(BigInteger bigInteger) {
        Object toByteArray = bigInteger.toByteArray();
        if (toByteArray.length != 1) {
            if ((bigInteger.bitLength() & 7) == 0) {
                bigInteger = new byte[(bigInteger.bitLength() >> 3)];
                System.arraycopy(toByteArray, 1, bigInteger, 0, bigInteger.length);
                return bigInteger;
            }
        }
        return toByteArray;
    }
}
