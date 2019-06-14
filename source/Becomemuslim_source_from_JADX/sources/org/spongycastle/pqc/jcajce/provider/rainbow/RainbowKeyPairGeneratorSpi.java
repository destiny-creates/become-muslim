package org.spongycastle.pqc.jcajce.provider.rainbow;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.pqc.crypto.rainbow.RainbowKeyGenerationParameters;
import org.spongycastle.pqc.crypto.rainbow.RainbowKeyPairGenerator;
import org.spongycastle.pqc.crypto.rainbow.RainbowParameters;
import org.spongycastle.pqc.crypto.rainbow.RainbowPrivateKeyParameters;
import org.spongycastle.pqc.crypto.rainbow.RainbowPublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.RainbowParameterSpec;

public class RainbowKeyPairGeneratorSpi extends KeyPairGenerator {
    /* renamed from: a */
    RainbowKeyGenerationParameters f23338a;
    /* renamed from: b */
    RainbowKeyPairGenerator f23339b = new RainbowKeyPairGenerator();
    /* renamed from: c */
    int f23340c = 1024;
    /* renamed from: d */
    SecureRandom f23341d = new SecureRandom();
    /* renamed from: e */
    boolean f23342e = false;

    public RainbowKeyPairGeneratorSpi() {
        super("Rainbow");
    }

    public void initialize(int i, SecureRandom secureRandom) {
        this.f23340c = i;
        this.f23341d = secureRandom;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec instanceof RainbowParameterSpec) {
            this.f23338a = new RainbowKeyGenerationParameters(secureRandom, new RainbowParameters(((RainbowParameterSpec) algorithmParameterSpec).m29170a()));
            this.f23339b.m36417b(this.f23338a);
            this.f23342e = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a RainbowParameterSpec");
    }

    public KeyPair generateKeyPair() {
        if (!this.f23342e) {
            this.f23338a = new RainbowKeyGenerationParameters(this.f23341d, new RainbowParameters(new RainbowParameterSpec().m29170a()));
            this.f23339b.m36417b(this.f23338a);
            this.f23342e = true;
        }
        AsymmetricCipherKeyPair a = this.f23339b.mo5755a();
        return new KeyPair(new BCRainbowPublicKey((RainbowPublicKeyParameters) a.m27281a()), new BCRainbowPrivateKey((RainbowPrivateKeyParameters) a.m27282b()));
    }
}
