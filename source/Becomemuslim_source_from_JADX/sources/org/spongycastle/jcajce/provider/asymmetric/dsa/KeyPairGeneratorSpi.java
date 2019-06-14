package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.DSAKeyPairGenerator;
import org.spongycastle.crypto.generators.DSAParametersGenerator;
import org.spongycastle.crypto.params.DSAKeyGenerationParameters;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.crypto.params.DSAPrivateKeyParameters;
import org.spongycastle.crypto.params.DSAPublicKeyParameters;

public class KeyPairGeneratorSpi extends KeyPairGenerator {
    /* renamed from: a */
    DSAKeyGenerationParameters f22735a;
    /* renamed from: b */
    DSAKeyPairGenerator f22736b = new DSAKeyPairGenerator();
    /* renamed from: c */
    int f22737c = 1024;
    /* renamed from: d */
    int f22738d = 20;
    /* renamed from: e */
    SecureRandom f22739e = new SecureRandom();
    /* renamed from: f */
    boolean f22740f = false;

    public KeyPairGeneratorSpi() {
        super("DSA");
    }

    public void initialize(int i, SecureRandom secureRandom) {
        if (i < 512 || i > 4096 || ((i < 1024 && i % 64 != 0) || (i >= 1024 && i % 1024 != 0))) {
            throw new InvalidParameterException("strength must be from 512 - 4096 and a multiple of 1024 above 1024");
        }
        this.f22737c = i;
        this.f22739e = secureRandom;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec instanceof DSAParameterSpec) {
            DSAParameterSpec dSAParameterSpec = (DSAParameterSpec) algorithmParameterSpec;
            this.f22735a = new DSAKeyGenerationParameters(secureRandom, new DSAParameters(dSAParameterSpec.getP(), dSAParameterSpec.getQ(), dSAParameterSpec.getG()));
            this.f22736b.m35330a(this.f22735a);
            this.f22740f = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a DSAParameterSpec");
    }

    public KeyPair generateKeyPair() {
        if (!this.f22740f) {
            DSAParametersGenerator dSAParametersGenerator = new DSAParametersGenerator();
            dSAParametersGenerator.m27450a(this.f22737c, this.f22738d, this.f22739e);
            this.f22735a = new DSAKeyGenerationParameters(this.f22739e, dSAParametersGenerator.m27449a());
            this.f22736b.m35330a(this.f22735a);
            this.f22740f = true;
        }
        AsymmetricCipherKeyPair a = this.f22736b.mo5755a();
        return new KeyPair(new BCDSAPublicKey((DSAPublicKeyParameters) a.m27281a()), new BCDSAPrivateKey((DSAPrivateKeyParameters) a.m27282b()));
    }
}
