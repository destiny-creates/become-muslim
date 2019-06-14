package org.spongycastle.util;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class BigIntegers {
    /* renamed from: a */
    private static final BigInteger f23432a = BigInteger.valueOf(0);

    /* renamed from: a */
    public static byte[] m29389a(BigInteger bigInteger) {
        bigInteger = bigInteger.toByteArray();
        if (bigInteger[0] != (byte) 0) {
            return bigInteger;
        }
        Object obj = new byte[(bigInteger.length - 1)];
        System.arraycopy(bigInteger, 1, obj, 0, obj.length);
        return obj;
    }

    /* renamed from: a */
    public static byte[] m29388a(int i, BigInteger bigInteger) {
        bigInteger = bigInteger.toByteArray();
        if (bigInteger.length == i) {
            return bigInteger;
        }
        int i2 = 0;
        if (bigInteger[0] == (byte) 0) {
            i2 = 1;
        }
        int length = bigInteger.length - i2;
        if (length <= i) {
            i = new byte[i];
            System.arraycopy(bigInteger, i2, i, i.length - length, length);
            return i;
        }
        throw new IllegalArgumentException("standard length exceeded for value");
    }

    /* renamed from: a */
    public static BigInteger m29386a(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        int compareTo = bigInteger.compareTo(bigInteger2);
        if (compareTo >= 0) {
            if (compareTo <= 0) {
                return bigInteger;
            }
            throw new IllegalArgumentException("'min' may not be greater than 'max'");
        } else if (bigInteger.bitLength() > bigInteger2.bitLength() / 2) {
            return m29386a(f23432a, bigInteger2.subtract(bigInteger), secureRandom).add(bigInteger);
        } else {
            for (compareTo = 0; compareTo < 1000; compareTo++) {
                BigInteger bigInteger3 = new BigInteger(bigInteger2.bitLength(), secureRandom);
                if (bigInteger3.compareTo(bigInteger) >= 0 && bigInteger3.compareTo(bigInteger2) <= 0) {
                    return bigInteger3;
                }
            }
            return new BigInteger(bigInteger2.subtract(bigInteger).bitLength() - 1, secureRandom).add(bigInteger);
        }
    }

    /* renamed from: a */
    public static BigInteger m29387a(byte[] bArr, int i, int i2) {
        if (!(i == 0 && i2 == bArr.length)) {
            Object obj = new byte[i2];
            System.arraycopy(bArr, i, obj, 0, i2);
            bArr = obj;
        }
        return new BigInteger(1, bArr);
    }
}
