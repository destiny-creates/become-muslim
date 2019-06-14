package org.spongycastle.jcajce.provider.asymmetric.elgamal;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.ElGamalKeyPairGenerator;
import org.spongycastle.crypto.generators.ElGamalParametersGenerator;
import org.spongycastle.crypto.params.ElGamalKeyGenerationParameters;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ElGamalParameterSpec;

public class KeyPairGeneratorSpi extends KeyPairGenerator {
    /* renamed from: a */
    ElGamalKeyGenerationParameters f22767a;
    /* renamed from: b */
    ElGamalKeyPairGenerator f22768b = new ElGamalKeyPairGenerator();
    /* renamed from: c */
    int f22769c = 1024;
    /* renamed from: d */
    int f22770d = 20;
    /* renamed from: e */
    SecureRandom f22771e = new SecureRandom();
    /* renamed from: f */
    boolean f22772f = false;

    public KeyPairGeneratorSpi() {
        super("ElGamal");
    }

    public void initialize(int i, SecureRandom secureRandom) {
        this.f22769c = i;
        this.f22771e = secureRandom;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        boolean z = algorithmParameterSpec instanceof ElGamalParameterSpec;
        if (!z) {
            if (!(algorithmParameterSpec instanceof DHParameterSpec)) {
                throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec or an ElGamalParameterSpec");
            }
        }
        if (z) {
            ElGamalParameterSpec elGamalParameterSpec = (ElGamalParameterSpec) algorithmParameterSpec;
            this.f22767a = new ElGamalKeyGenerationParameters(secureRandom, new ElGamalParameters(elGamalParameterSpec.m28321a(), elGamalParameterSpec.m28322b()));
        } else {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
            this.f22767a = new ElGamalKeyGenerationParameters(secureRandom, new ElGamalParameters(dHParameterSpec.getP(), dHParameterSpec.getG(), dHParameterSpec.getL()));
        }
        this.f22768b.m35335a(this.f22767a);
        this.f22772f = true;
    }

    public KeyPair generateKeyPair() {
        if (!this.f22772f) {
            DHParameterSpec a = BouncyCastleProvider.f27551a.mo5887a(this.f22769c);
            if (a != null) {
                this.f22767a = new ElGamalKeyGenerationParameters(this.f22771e, new ElGamalParameters(a.getP(), a.getG(), a.getL()));
            } else {
                ElGamalParametersGenerator elGamalParametersGenerator = new ElGamalParametersGenerator();
                elGamalParametersGenerator.m27453a(this.f22769c, this.f22770d, this.f22771e);
                this.f22767a = new ElGamalKeyGenerationParameters(this.f22771e, elGamalParametersGenerator.m27452a());
            }
            this.f22768b.m35335a(this.f22767a);
            this.f22772f = true;
        }
        AsymmetricCipherKeyPair a2 = this.f22768b.mo5755a();
        return new KeyPair(new BCElGamalPublicKey((ElGamalPublicKeyParameters) a2.m27281a()), new BCElGamalPrivateKey((ElGamalPrivateKeyParameters) a2.m27282b()));
    }
}
