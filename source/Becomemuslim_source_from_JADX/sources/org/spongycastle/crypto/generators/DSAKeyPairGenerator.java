package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.DSAKeyGenerationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;
import org.spongycastle.math.ec.WNafUtil;
import org.spongycastle.util.BigIntegers;

public class DSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    /* renamed from: a */
    private static final BigInteger f26835a = BigInteger.valueOf(1);
    /* renamed from: b */
    private DSAKeyGenerationParameters f26836b;

    /* renamed from: a */
    public void m35330a(KeyGenerationParameters keyGenerationParameters) {
        this.f26836b = (DSAKeyGenerationParameters) keyGenerationParameters;
    }

    /* renamed from: a */
    public AsymmetricCipherKeyPair mo5755a() {
        DSAParameters c = this.f26836b.m35643c();
        BigInteger a = m35328a(c.m35645b(), this.f26836b.m27324a());
        return new AsymmetricCipherKeyPair(new DSAPublicKeyParameters(m35327a(c.m35644a(), c.m35646c(), a), c), new DSAPrivateKeyParameters(a, c));
    }

    /* renamed from: a */
    private static BigInteger m35328a(BigInteger bigInteger, SecureRandom secureRandom) {
        BigInteger a;
        int bitLength = bigInteger.bitLength() >>> 2;
        do {
            a = BigIntegers.m29386a(f26835a, bigInteger.subtract(f26835a), secureRandom);
        } while (WNafUtil.m28504c(a) < bitLength);
        return a;
    }

    /* renamed from: a */
    private static BigInteger m35327a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return bigInteger2.modPow(bigInteger3, bigInteger);
    }
}
