package org.spongycastle.crypto.agreement.srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.CryptoException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.util.BigIntegers;

public class SRP6Util {
    /* renamed from: a */
    private static BigInteger f22257a = BigInteger.valueOf(0);
    /* renamed from: b */
    private static BigInteger f22258b = BigInteger.valueOf(1);

    /* renamed from: a */
    public static BigInteger m27377a(Digest digest, BigInteger bigInteger, BigInteger bigInteger2) {
        return m27382b(digest, bigInteger, bigInteger, bigInteger2);
    }

    /* renamed from: a */
    public static BigInteger m27378a(Digest digest, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return m27382b(digest, bigInteger, bigInteger2, bigInteger3);
    }

    /* renamed from: a */
    public static BigInteger m27380a(Digest digest, BigInteger bigInteger, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        bigInteger = new byte[digest.mo5732b()];
        digest.mo5731a(bArr2, 0, bArr2.length);
        digest.mo5730a(58);
        digest.mo5731a(bArr3, 0, bArr3.length);
        digest.mo5728a(bigInteger, 0);
        digest.mo5731a(bArr, 0, bArr.length);
        digest.mo5731a(bigInteger, 0, bigInteger.length);
        digest.mo5728a(bigInteger, 0);
        return new BigInteger(1, bigInteger);
    }

    /* renamed from: a */
    public static BigInteger m27379a(Digest digest, BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        return BigIntegers.m29386a(f22258b.shiftLeft(Math.min(256, bigInteger.bitLength() / 2) - 1), bigInteger.subtract(f22258b), secureRandom);
    }

    /* renamed from: a */
    public static BigInteger m27376a(BigInteger bigInteger, BigInteger bigInteger2) {
        bigInteger = bigInteger2.mod(bigInteger);
        if (bigInteger.equals(f22257a) == null) {
            return bigInteger;
        }
        throw new CryptoException("Invalid public value: 0");
    }

    /* renamed from: b */
    private static BigInteger m27382b(Digest digest, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        int bitLength = (bigInteger.bitLength() + 7) / 8;
        bigInteger2 = m27381a(bigInteger2, bitLength);
        bigInteger = m27381a(bigInteger3, bitLength);
        digest.mo5731a(bigInteger2, 0, bigInteger2.length);
        digest.mo5731a(bigInteger, 0, bigInteger.length);
        bigInteger = new byte[digest.mo5732b()];
        digest.mo5728a(bigInteger, 0);
        return new BigInteger(1, bigInteger);
    }

    /* renamed from: a */
    private static byte[] m27381a(BigInteger bigInteger, int i) {
        bigInteger = BigIntegers.m29389a(bigInteger);
        if (bigInteger.length >= i) {
            return bigInteger;
        }
        BigInteger bigInteger2 = new byte[i];
        System.arraycopy(bigInteger, 0, bigInteger2, i - bigInteger.length, bigInteger.length);
        return bigInteger2;
    }
}
