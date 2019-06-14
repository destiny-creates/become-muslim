package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.util.Random;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.GOST3410KeyGenerationParameters;
import org.spongycastle.crypto.params.GOST3410Parameters;
import org.spongycastle.crypto.params.GOST3410PrivateKeyParameters;
import org.spongycastle.crypto.params.GOST3410PublicKeyParameters;
import org.spongycastle.math.ec.WNafUtil;

public class GOST3410KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    /* renamed from: a */
    private GOST3410KeyGenerationParameters f26840a;

    /* renamed from: a */
    public void m35337a(KeyGenerationParameters keyGenerationParameters) {
        this.f26840a = (GOST3410KeyGenerationParameters) keyGenerationParameters;
    }

    /* renamed from: a */
    public AsymmetricCipherKeyPair mo5755a() {
        GOST3410Parameters c = this.f26840a.m35658c();
        Random a = this.f26840a.m27324a();
        BigInteger b = c.m35660b();
        BigInteger a2 = c.m35659a();
        BigInteger c2 = c.m35661c();
        while (true) {
            BigInteger bigInteger = new BigInteger(256, a);
            if (bigInteger.signum() >= 1) {
                if (bigInteger.compareTo(b) < 0) {
                    if (WNafUtil.m28504c(bigInteger) >= 64) {
                        return new AsymmetricCipherKeyPair(new GOST3410PublicKeyParameters(c2.modPow(bigInteger, a2), c), new GOST3410PrivateKeyParameters(bigInteger, c));
                    }
                }
            }
        }
    }
}
