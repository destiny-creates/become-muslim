package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.ElGamalKeyGenerationParameters;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;

public class ElGamalKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    /* renamed from: a */
    private ElGamalKeyGenerationParameters f26839a;

    /* renamed from: a */
    public void m35335a(KeyGenerationParameters keyGenerationParameters) {
        this.f26839a = (ElGamalKeyGenerationParameters) keyGenerationParameters;
    }

    /* renamed from: a */
    public AsymmetricCipherKeyPair mo5755a() {
        DHKeyGeneratorHelper dHKeyGeneratorHelper = DHKeyGeneratorHelper.f22350a;
        ElGamalParameters c = this.f26839a.m35654c();
        DHParameters dHParameters = new DHParameters(c.m35655a(), c.m35656b(), null, c.m35657c());
        BigInteger a = dHKeyGeneratorHelper.m27434a(dHParameters, this.f26839a.m27324a());
        return new AsymmetricCipherKeyPair(new ElGamalPublicKeyParameters(dHKeyGeneratorHelper.m27433a(dHParameters, a), c), new ElGamalPrivateKeyParameters(a, c));
    }
}
