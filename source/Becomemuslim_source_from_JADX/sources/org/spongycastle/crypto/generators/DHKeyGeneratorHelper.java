package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.math.ec.WNafUtil;
import org.spongycastle.util.BigIntegers;

class DHKeyGeneratorHelper {
    /* renamed from: a */
    static final DHKeyGeneratorHelper f22350a = new DHKeyGeneratorHelper();
    /* renamed from: b */
    private static final BigInteger f22351b = BigInteger.valueOf(1);
    /* renamed from: c */
    private static final BigInteger f22352c = BigInteger.valueOf(2);

    private DHKeyGeneratorHelper() {
    }

    /* renamed from: a */
    BigInteger m27434a(DHParameters dHParameters, SecureRandom secureRandom) {
        int e = dHParameters.m35642e();
        int i;
        if (e != 0) {
            i = e >>> 2;
            do {
                dHParameters = new BigInteger(e, secureRandom).setBit(e - 1);
            } while (WNafUtil.m28504c(dHParameters) < i);
            return dHParameters;
        }
        BigInteger a;
        BigInteger bigInteger = f22352c;
        i = dHParameters.m35641d();
        if (i != 0) {
            bigInteger = f22351b.shiftLeft(i - 1);
        }
        BigInteger c = dHParameters.m35640c();
        if (c == null) {
            c = dHParameters.m35638a();
        }
        BigInteger subtract = c.subtract(f22352c);
        i = subtract.bitLength() >>> 2;
        do {
            a = BigIntegers.m29386a(bigInteger, subtract, secureRandom);
        } while (WNafUtil.m28504c(a) < i);
        return a;
    }

    /* renamed from: a */
    BigInteger m27433a(DHParameters dHParameters, BigInteger bigInteger) {
        return dHParameters.m35639b().modPow(bigInteger, dHParameters.m35638a());
    }
}
