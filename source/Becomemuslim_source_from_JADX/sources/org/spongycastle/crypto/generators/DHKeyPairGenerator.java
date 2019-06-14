package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.DHKeyGenerationParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;

public class DHKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    /* renamed from: a */
    private DHKeyGenerationParameters f26834a;

    /* renamed from: a */
    public void m35326a(KeyGenerationParameters keyGenerationParameters) {
        this.f26834a = (DHKeyGenerationParameters) keyGenerationParameters;
    }

    /* renamed from: a */
    public AsymmetricCipherKeyPair mo5755a() {
        DHKeyGeneratorHelper dHKeyGeneratorHelper = DHKeyGeneratorHelper.f22350a;
        DHParameters c = this.f26834a.m35636c();
        BigInteger a = dHKeyGeneratorHelper.m27434a(c, this.f26834a.m27324a());
        return new AsymmetricCipherKeyPair(new DHPublicKeyParameters(dHKeyGeneratorHelper.m27433a(c, a), c), new DHPrivateKeyParameters(a, c));
    }
}
