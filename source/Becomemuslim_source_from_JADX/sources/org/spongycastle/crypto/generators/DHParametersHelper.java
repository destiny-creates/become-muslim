package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.math.ec.WNafUtil;
import org.spongycastle.util.BigIntegers;

class DHParametersHelper {
    /* renamed from: a */
    private static final BigInteger f22357a = BigInteger.valueOf(1);
    /* renamed from: b */
    private static final BigInteger f22358b = BigInteger.valueOf(2);

    DHParametersHelper() {
    }

    /* renamed from: a */
    static BigInteger[] m27438a(int i, int i2, SecureRandom secureRandom) {
        int i3 = i - 1;
        i >>>= 2;
        while (true) {
            BigInteger bigInteger = new BigInteger(i3, 2, secureRandom);
            BigInteger add = bigInteger.shiftLeft(1).add(f22357a);
            if (add.isProbablePrime(i2)) {
                if (i2 <= 2 || bigInteger.isProbablePrime(i2 - 2)) {
                    if (WNafUtil.m28504c(add) >= i) {
                        return new BigInteger[]{add, bigInteger};
                    }
                }
            }
        }
    }

    /* renamed from: a */
    static BigInteger m27437a(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger modPow;
        bigInteger2 = bigInteger.subtract(f22358b);
        do {
            modPow = BigIntegers.m29386a(f22358b, bigInteger2, secureRandom).modPow(f22358b, bigInteger);
        } while (modPow.equals(f22357a));
        return modPow;
    }
}
