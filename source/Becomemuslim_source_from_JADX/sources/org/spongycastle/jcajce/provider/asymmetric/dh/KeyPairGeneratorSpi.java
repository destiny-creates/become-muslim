package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.generators.DHBasicKeyPairGenerator;
import org.spongycastle.crypto.generators.DHParametersGenerator;
import org.spongycastle.crypto.params.DHKeyGenerationParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.util.Integers;

public class KeyPairGeneratorSpi extends KeyPairGenerator {
    /* renamed from: g */
    private static Hashtable f22723g = new Hashtable();
    /* renamed from: h */
    private static Object f22724h = new Object();
    /* renamed from: a */
    DHKeyGenerationParameters f22725a;
    /* renamed from: b */
    DHBasicKeyPairGenerator f22726b = new DHBasicKeyPairGenerator();
    /* renamed from: c */
    int f22727c = 1024;
    /* renamed from: d */
    int f22728d = 20;
    /* renamed from: e */
    SecureRandom f22729e = new SecureRandom();
    /* renamed from: f */
    boolean f22730f = false;

    public KeyPairGeneratorSpi() {
        super("DH");
    }

    public void initialize(int i, SecureRandom secureRandom) {
        this.f22727c = i;
        this.f22729e = secureRandom;
    }

    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec instanceof DHParameterSpec) {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
            this.f22725a = new DHKeyGenerationParameters(secureRandom, new DHParameters(dHParameterSpec.getP(), dHParameterSpec.getG(), null, dHParameterSpec.getL()));
            this.f22726b.m35324a(this.f22725a);
            this.f22730f = true;
            return;
        }
        throw new InvalidAlgorithmParameterException("parameter object not a DHParameterSpec");
    }

    public KeyPair generateKeyPair() {
        if (!this.f22730f) {
            Integer a = Integers.m29396a(this.f22727c);
            if (f22723g.containsKey(a)) {
                this.f22725a = (DHKeyGenerationParameters) f22723g.get(a);
            } else {
                DHParameterSpec a2 = BouncyCastleProvider.f27551a.mo5887a(this.f22727c);
                if (a2 != null) {
                    this.f22725a = new DHKeyGenerationParameters(this.f22729e, new DHParameters(a2.getP(), a2.getG(), null, a2.getL()));
                } else {
                    synchronized (f22724h) {
                        if (f22723g.containsKey(a)) {
                            this.f22725a = (DHKeyGenerationParameters) f22723g.get(a);
                        } else {
                            DHParametersGenerator dHParametersGenerator = new DHParametersGenerator();
                            dHParametersGenerator.m27436a(this.f22727c, this.f22728d, this.f22729e);
                            this.f22725a = new DHKeyGenerationParameters(this.f22729e, dHParametersGenerator.m27435a());
                            f22723g.put(a, this.f22725a);
                        }
                    }
                }
            }
            this.f22726b.m35324a(this.f22725a);
            this.f22730f = true;
        }
        AsymmetricCipherKeyPair a3 = this.f22726b.mo5755a();
        return new KeyPair(new BCDHPublicKey((DHPublicKeyParameters) a3.m27281a()), new BCDHPrivateKey((DHPrivateKeyParameters) a3.m27282b()));
    }
}
