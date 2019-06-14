package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.FixedPointCombMultiplier;
import org.spongycastle.math.ec.WNafUtil;

public class ECKeyPairGenerator implements AsymmetricCipherKeyPairGenerator, ECConstants {
    /* renamed from: a */
    ECDomainParameters f26837a;
    /* renamed from: b */
    SecureRandom f26838b;

    /* renamed from: a */
    public void m35332a(KeyGenerationParameters keyGenerationParameters) {
        ECKeyGenerationParameters eCKeyGenerationParameters = (ECKeyGenerationParameters) keyGenerationParameters;
        this.f26838b = eCKeyGenerationParameters.m27324a();
        this.f26837a = eCKeyGenerationParameters.m35652c();
        if (this.f26838b == null) {
            this.f26838b = new SecureRandom();
        }
    }

    /* renamed from: a */
    public AsymmetricCipherKeyPair mo5755a() {
        BigInteger c = this.f26837a.m35649c();
        int bitLength = c.bitLength();
        int i = bitLength >>> 2;
        while (true) {
            BigInteger bigInteger = new BigInteger(bitLength, this.f26838b);
            if (bigInteger.compareTo(e) >= 0) {
                if (bigInteger.compareTo(c) < 0) {
                    if (WNafUtil.m28504c(bigInteger) >= i) {
                        return new AsymmetricCipherKeyPair(new ECPublicKeyParameters(m35333b().mo5901a(this.f26837a.m35648b(), bigInteger), this.f26837a), new ECPrivateKeyParameters(bigInteger, this.f26837a));
                    }
                }
            }
        }
    }

    /* renamed from: b */
    protected ECMultiplier m35333b() {
        return new FixedPointCombMultiplier();
    }
}
