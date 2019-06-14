package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.RSAKeyPairGenerator;
import org.spongycastle.crypto.params.RSAKeyGenerationParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.params.RSAPrivateCrtKeyParameters;

public class KeyPairGeneratorSpi extends KeyPairGenerator {
    /* renamed from: a */
    static final BigInteger f22796a = BigInteger.valueOf(65537);
    /* renamed from: b */
    RSAKeyGenerationParameters f22797b = new RSAKeyGenerationParameters(f22796a, new SecureRandom(), 2048, 112);
    /* renamed from: c */
    RSAKeyPairGenerator f22798c = new RSAKeyPairGenerator();

    public KeyPairGeneratorSpi() {
        super("RSA");
        this.f22798c.m35376a(this.f22797b);
    }

    public void initialize(int i, SecureRandom secureRandom) {
        this.f22797b = new RSAKeyGenerationParameters(f22796a, secureRandom, i, 112);
        this.f22798c.m35376a(this.f22797b);
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec instanceof RSAKeyGenParameterSpec) {
            RSAKeyGenParameterSpec rSAKeyGenParameterSpec = (RSAKeyGenParameterSpec) algorithmParameterSpec;
            this.f22797b = new RSAKeyGenerationParameters(rSAKeyGenParameterSpec.getPublicExponent(), secureRandom, rSAKeyGenParameterSpec.getKeysize(), 112);
            this.f22798c.m35376a(this.f22797b);
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a RSAKeyGenParameterSpec");
    }

    public KeyPair generateKeyPair() {
        AsymmetricCipherKeyPair a = this.f22798c.mo5755a();
        return new KeyPair(new BCRSAPublicKey((RSAKeyParameters) a.m27281a()), new BCRSAPrivateCrtKey((RSAPrivateCrtKeyParameters) a.m27282b()));
    }
}
