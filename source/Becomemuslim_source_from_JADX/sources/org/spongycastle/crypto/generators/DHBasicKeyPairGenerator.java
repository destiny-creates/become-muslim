package org.spongycastle.crypto.generators;

import java.math.BigInteger;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.DHKeyGenerationParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;

public class DHBasicKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    /* renamed from: a */
    private DHKeyGenerationParameters f26833a;

    /* renamed from: a */
    public void m35324a(KeyGenerationParameters keyGenerationParameters) {
        this.f26833a = (DHKeyGenerationParameters) keyGenerationParameters;
    }

    /* renamed from: a */
    public AsymmetricCipherKeyPair mo5755a() {
        DHKeyGeneratorHelper dHKeyGeneratorHelper = DHKeyGeneratorHelper.f22350a;
        DHParameters c = this.f26833a.m35636c();
        BigInteger a = dHKeyGeneratorHelper.m27434a(c, this.f26833a.m27324a());
        return new AsymmetricCipherKeyPair(new DHPublicKeyParameters(dHKeyGeneratorHelper.m27433a(c, a), c), new DHPrivateKeyParameters(a, c));
    }
}
